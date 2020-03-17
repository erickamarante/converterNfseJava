package com.constanzooficial.integracao.test;

import com.aldeiaconsultoriajr.util.ExcelReader;
import com.constanzooficial.integracao.controller.ControllerConfig;
import com.constanzooficial.integracao.controller.ControllerWebService;
import com.constanzooficial.integracao.controller.nfse.sp.saoPaulo.v001.GeradorPDF;
import com.constanzooficial.integracao.db.SQLite;
import com.constanzooficial.integracao.model.ModelClientes;
import com.constanzooficial.integracao.util.MyUtils;
import com.constanzooficial.integracao.util.UtilAES;
import com.constanzooficial.integracao.util.UtilCidades;
import com.constanzooficial.integracao.util.UtilDatas;
import com.constanzooficial.integracao.util.UtilSQLite3;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.jfree.date.SerialDate;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
public class test {

    public static void main(String[] args) throws Exception {

        //UtilCidades.nomeCidade(5300108);

        //sql.connect(new File("db/cidades.db"));

        /*
        String statement = "CREATE TABLE IF NOT EXISTS cidades ("
                + "codigoIbge integer PRIMARY KEY,"
                + "nome text NOT NULL"
                + ");";
        sql.executeStatement(statement);
        
        com.constanzooficial.integracao.util.ExcelReader excelReader = new com.constanzooficial.integracao.util.ExcelReader(MyUtils.class.getResourceAsStream("/res/codigosMunicipios.xlsx"));
        excelReader.selecionarPlanilha(0);
        for (int i = 0; i < excelReader.numeroLinhas(); i++) {
            excelReader.selecionarLinha(i);
            sql.insert(Integer.valueOf(excelReader.getConteudoCelulaString(0)), excelReader.getConteudoCelulaString(1));
        }
         */
        
        //System.out.println(UtilAES.getInstance().decrypt("OOqXpFDtzsW3Qbc9swXhvA=="));
        
        /*
        UtilSQLite3 sqlite = new UtilSQLite3();
        sqlite.connect(new File("db/feriados.db"));
        //System.out.println(sqlite.existeTabela("teste"));
        //System.out.println(sqlite.existeTabela("testes"));
        ArrayList<String> tabela = new ArrayList<>();
        tabela.add("testando"); // Table name
        tabela.add("umCampo"); // Column name
        tabela.add("TEXT"); // TYPE
        tabela.add(""); // NOT NULL
        tabela.add(""); // PRIMARY KEY
        tabela.add(null); // AUTO INCREMENT
        tabela.add(""); // UNIQUE
        sqlite.criarTabela(tabela);
        */
        
        
        /*
        ControllerConfig cc = new ControllerConfig();
        cc.loadConfigs();
        ControllerWebService webService = new ControllerWebService(null);
        ModelClientes c = new ModelClientes();
        c.setAtivo(true);
        c.setConsiderarIss(true);
        c.setCpfCnpj("67680363000196");
        c.setEmiteNFe(true);
        c.setInscricaoMunicipal("20464029");
        c.setRazaoSocial("PANTY'S CAR COM DE PECAS E VEICULOS AUTOMOTIVOS LTDA");
        // webService.consultaNfe(c, "1969");
        webService.consultaCNPJ("67630145000147");
        webService.consultaCNPJ2("67630145000147");
        */
        
        
        /*
        ControllerConfig cc = new ControllerConfig();
        cc.loadConfigs();
        ControllerWebService webService = new ControllerWebService(null);
        webService.consultaCNPJ("67630145000147");
        */
        
        
        UtilDatas ud = new UtilDatas();
        //ud.preencheTabelaFeriadosNacionais(10, 2018, 3550308);
        //System.out.println(ud.ehFeriadoNacional(Calendar.getInstance()));
        SerialDate sd = SerialDate.createInstance(43385);
        Date d = sd.toDate();
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        System.out.println("Data original: " + cal);
        System.out.println("Nova data: " + ud.diaUtil(cal));
        
    }
}
