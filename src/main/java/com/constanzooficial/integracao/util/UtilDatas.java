package com.constanzooficial.integracao.util;

import com.constanzooficial.integracao.model.ModelFeriado;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jfree.date.SerialDate;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
public class UtilDatas {

    /**
     * Verifica se a data passada como parâmetro corresponde a um dia útil.
     *
     * @param data
     * @return A data mais próxima, podendo ser inclusive a própria data
     * fornecida, referente a um dia útil.
     * @throws java.lang.Exception
     */
    public Calendar diaUtil(Calendar data) throws Exception {

        // se data for um domingo
        if (data.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            data.add(Calendar.DATE, 1);
        } // se data for um sábado
        else if (data.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            data.add(Calendar.DATE, 2);
        }
        if (!ehFeriadoNacional(data)) {
            return data;
        } else {
            data.add(Calendar.DAY_OF_MONTH, 1);
            return diaUtil(data);
        }
    }

    public boolean ehFeriadoNacional(Calendar data) throws IOException, Exception {

        SerialDate sd = SerialDate.createInstance(data.getTime());
        int serial = sd.toSerial();

        String tabela = preencheTabelaFeriadosNacionais(data.get(Calendar.MONTH) + 1, data.get(Calendar.YEAR));
        UtilSQLite3 sqlite = new UtilSQLite3(new File("db/feriados.db"));
        List<Map<String, Object>> resultSet = sqlite.executarQuery("SELECT data FROM " + tabela + " WHERE data = " + serial);
        return resultSet.size() > 0;
    }

    public String preencheTabelaFeriadosNacionais(int mes, int ano) throws Exception {

        System.out.println("Preenchendo");
        
        if (mes < 1 || mes > 12 || ano < 1900) {
            throw new Exception("Data inválida");
        }

        String mesAno = null;
        switch (mes) {
            case 1:
                mesAno = "janeiro";
                break;
            case 2:
                mesAno = "fevereiro";
                break;
            case 3:
                mesAno = "marco";
                break;
            case 4:
                mesAno = "abril";
                break;
            case 5:
                mesAno = "maio";
                break;
            case 6:
                mesAno = "junho";
                break;
            case 7:
                mesAno = "julho";
                break;
            case 8:
                mesAno = "agosto";
                break;
            case 9:
                mesAno = "setembro";
                break;
            case 10:
                mesAno = "outubro";
                break;
            case 11:
                mesAno = "novembro";
                break;
            case 12:
                mesAno = "dezembro";
                break;
        }
        mesAno = mesAno + Integer.toString(ano);

        UtilSQLite3 sqlite = new UtilSQLite3(new File("db/feriados.db"));

        if (!sqlite.existeTabela(mesAno)) {

            ArrayList<String> tabela = new ArrayList<>();
            tabela.add(mesAno);

            tabela.add("data");    // Nome
            tabela.add("INTEGER"); // Tipo
            tabela.add("");        // Não nulo
            tabela.add("");        // Chave primária
            tabela.add(null);      // Auto incremento
            tabela.add(null);      // Unico

            tabela.add("nome"); // Nome
            tabela.add("TEXT"); // Tipo
            tabela.add("");     // Não nulo
            tabela.add(null);   // Chave primária
            tabela.add(null);   // Auto incremento
            tabela.add(null);   // Unico

            tabela.add("tipo");    // Nome
            tabela.add("INTEGER"); // Tipo
            tabela.add("");        // Não nulo
            tabela.add(null);      // Chave primária
            tabela.add(null);      // Auto incremento
            tabela.add(null);      // Unico

            sqlite.criarTabela(tabela);

            ArrayList<ModelFeriado> feriados = consultaFeriados(mes, ano);
            if (!feriados.isEmpty()) {
                for (ModelFeriado feriado : feriados) {
                    if (feriado.getTipo() == ModelFeriado.NACIONAL) {
                        sqlite.executarQuery("INSERT INTO " + mesAno + "(data,nome,tipo) VALUES(" + feriado.getSerialDate().toSerial() + ",\"" + feriado.getNome() + "\"," + feriado.getTipo() + ")");
                    }
                }
            }
        }
        
        return mesAno;
    }

    public ArrayList<ModelFeriado> consultaFeriados(int mes, int ano) throws IOException {

        ArrayList<ModelFeriado> feriados = new ArrayList<>();

        String url = "https://api.calendario.com.br/?ano=" + Integer.toString(ano) + "&token=eXVyaWZvYm9yZ2hpQGdtYWlsLmNvbSZoYXNoPTEzNDkyNzA1Ng";
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        String line;
        while ((line = rd.readLine()) != null) {
            if (line.contains("<date>")) {
                line = line.replaceAll("<date>|</date>", "").trim();
                String[] split = line.split("/");
                if (Integer.valueOf(split[1]) == mes) {
                    ModelFeriado f = new ModelFeriado();
                    f.setData(line);
                    line = rd.readLine();
                    if (line.contains("<name>")) {
                        line = line.replaceAll("<name>|</name>", "").trim();
                        f.setNome(line);
                    }
                    rd.readLine();
                    rd.readLine();
                    line = rd.readLine();
                    if (line.contains("<type_code>")) {
                        line = line.replaceAll("<type_code>|</type_code>", "").trim();
                        f.setTipo(Integer.valueOf(line));
                    }
                    feriados.add(f);
                }
            }
        }
        return feriados;
    }
}
