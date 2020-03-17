package com.aldeiaconsultoriajr.conversor;

import com.aldeiaconsultoriajr.nfe.rs.canoas.CompNfse;
import com.aldeiaconsultoriajr.nfe.rs.canoas.ConsultarNfseLote;
import com.aldeiaconsultoriajr.nfe.rs.canoas.InfNfse;
import com.aldeiaconsultoriajr.util.ExcelReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.text.WordUtils;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
public class GeradorTXT {

    private final ArrayList<CompNfse> listaNfse;

    public GeradorTXT(ConsultarNfseLote consultarNfseLote) {
        this.listaNfse = consultarNfseLote.getListaNfse();
    }

    public void gerarTXT() throws IOException {

        if (!listaNfse.isEmpty()) {
            FileOutputStream fos = new FileOutputStream("NFSE_E_" + StringUtils.leftPad(listaNfse.get(0).getNfse().getInfNfse().getPrestadorServico().getIdentificacaoPrestador().getInscricaoMunicipal(), 8, '0') + "_" + listaNfse.get(0).getNfse().getInfNfse().getDataEmissao().substring(0, 8).replace("-", "") + "01" + "_" + listaNfse.get(listaNfse.size() - 1).getNfse().getInfNfse().getDataEmissao().substring(0, 8).replace("-", "") + ultimoDiaMes(Integer.parseInt(listaNfse.get(listaNfse.size() - 1).getNfse().getInfNfse().getDataEmissao().substring(5, 7)), Integer.parseInt(listaNfse.get(listaNfse.size() - 1).getNfse().getInfNfse().getDataEmissao().substring(0, 4))) + ".txt");
            OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
            BufferedWriter gravarArq = new BufferedWriter(osw);

            // Registro Tipo 1 - Cabeçalho
            gravarArq.append("1");
            // Versão do Arquivo
            gravarArq.append("001");
            // Inscrição Municipal do Contribuinte
            gravarArq.append(StringUtils.leftPad(listaNfse.get(0).getNfse().getInfNfse().getPrestadorServico().getIdentificacaoPrestador().getInscricaoMunicipal(), 8, '0'));
            // Data de Início do Período Transferido no Arquivo
            String data = listaNfse.get(0).getNfse().getInfNfse().getDataEmissao().substring(0, 8);
            data = data.replace("-", "");
            gravarArq.append(data + "01");
            // Data de Fim do Período Transferido no Arquivo
            data = listaNfse.get(listaNfse.size() - 1).getNfse().getInfNfse().getDataEmissao().substring(0, 8);
            String split[] = data.split("-");
            gravarArq.append(split[0] + split[1] + ultimoDiaMes(Integer.parseInt(split[1]), Integer.parseInt(split[0])));
            // Caractere de Fim de Linha
            gravarArq.append("\n");

            double valorTotalServicos = 0;
            double valorTotalDeducoes = 0;
            double valorTotalISS = 0;
            double valorTotalCreditos = 0;
            for (CompNfse compNfse : listaNfse) {

                InfNfse infNfse = compNfse.getNfse().getInfNfse();

                // Registro Tipo 2 - Detalhe
                gravarArq.append("2");
                // Nº NF-e
                gravarArq.append(StringUtils.leftPad(infNfse.getNumero(), 8, "0"));
                // Data Hora NFE
                data = infNfse.getDataEmissao();
                split = data.split("-");
                gravarArq.append(split[0] + split[1]);
                split = split[2].split("T");
                gravarArq.append(split[0]);
                split = split[1].split(":");
                gravarArq.append(split[0] + split[1] + split[2]);
                // Código de Verificação da NF-e 
                gravarArq.append("        ");
                // Tipo de RPS
                gravarArq.append("RPS  ");
                // Série do RPS
                gravarArq.append(StringUtils.leftPad(infNfse.getIdentificacaoRps().getSerie(), 5, " "));
                // Número do RPS
                gravarArq.append(StringUtils.leftPad(infNfse.getIdentificacaoRps().getNumero(), 12, "0"));
                // Data de Emissão do RPS
                data = infNfse.getDataEmissao();
                split = data.split("-");
                gravarArq.append(split[0] + split[1]);
                split = split[2].split("T");
                gravarArq.append(split[0]);
                // Inscrição Municipal do Prestador
                gravarArq.append(StringUtils.leftPad(infNfse.getPrestadorServico().getIdentificacaoPrestador().getInscricaoMunicipal(), 8, "0"));
                // Indicador de CPF/CNPJ do Prestador (1 - CPF; 2 - CNPJ)
                gravarArq.append("2");
                // CPF ou CNPJ do Prestador
                gravarArq.append(infNfse.getPrestadorServico().getIdentificacaoPrestador().getCnpj());
                // Razão Social do Prestador
                gravarArq.append(StringUtils.rightPad(infNfse.getPrestadorServico().getRazaoSocial(), 75, " "));
                // Tipo do Endereço do Prestador (Rua, Av, ...)
                split = separaTipoEndereco(infNfse.getPrestadorServico().getEndereco().getEndereco(), 3, 50);
                gravarArq.append(split[0]);
                // Endereço do Prestador
                gravarArq.append(split[1]);
                // Número do Endereço do Prestador
                gravarArq.append(StringUtils.rightPad(infNfse.getPrestadorServico().getEndereco().getNumero(), 10, " "));
                // Complemento do Endereço do Prestador
                gravarArq.append(StringUtils.rightPad(infNfse.getPrestadorServico().getEndereco().getComplemento(), 30, " "));
                // Bairro do Prestador
                gravarArq.append(StringUtils.rightPad(infNfse.getPrestadorServico().getEndereco().getBairro(), 30, " "));
                // Cidade do Prestador
                gravarArq.append(StringUtils.rightPad(nomeMunicipio(Double.parseDouble(infNfse.getPrestadorServico().getEndereco().getCodigoMunicipio())).replace("null", ""), 50, ' '));
                // UF do Prestador
                gravarArq.append(StringUtils.rightPad(infNfse.getPrestadorServico().getEndereco().getUf(), 2, ' '));
                // CEP do Prestador
                gravarArq.append(StringUtils.rightPad(infNfse.getPrestadorServico().getEndereco().getCep(), 8, '0'));
                // E-mail do Prestador
                gravarArq.append(StringUtils.rightPad(infNfse.getPrestadorServico().getContato().getEmail(), 75, ' '));
                // Opção Pelo Simples
                switch(infNfse.getOptanteSimplesNacional()) {
                    case "1":
                        gravarArq.append('4');
                        break;
                    default:
                        gravarArq.append('0');
                }
                // Situação da Nota Fiscal
                gravarArq.append(" ");
                // Data de Cancelamento
                gravarArq.append("        ");
                // Nº da Guia
                gravarArq.append("000000000000");
                // Data de Quitação da Guia Vinculada a Nota Fiscal
                gravarArq.append("        ");
                // Valor dos Serviços
                gravarArq.append(StringUtils.leftPad(infNfse.getServico().getValores().getValorServicos().replace(".", ""), 15, '0'));
                valorTotalServicos += Double.parseDouble(infNfse.getServico().getValores().getValorServicos());
                // Valor das Deduções
                gravarArq.append(StringUtils.leftPad(infNfse.getServico().getValores().getValorDeducoes().replace(".", ""), 15, '0'));
                valorTotalDeducoes += Double.parseDouble(infNfse.getServico().getValores().getValorDeducoes());
                // Código do Serviço Prestado na Nota Fiscal
                gravarArq.append(StringUtils.leftPad(infNfse.getServico().getItemListaServico(), 5, '0'));
                // Alíquota
                DecimalFormat df = new DecimalFormat("0.00");
                gravarArq.append(StringUtils.leftPad(df.format((Double.parseDouble(infNfse.getServico().getValores().getAliquota()) * 100)).replace(".", "").replace(",", ""), 4, '0'));
                // Valor do ISS
                gravarArq.append(StringUtils.leftPad(infNfse.getServico().getValores().getValorIss().replace(".", ""), 15, '0'));
                valorTotalISS += Double.parseDouble(infNfse.getServico().getValores().getValorIss());
                // Valor do Crédito
                gravarArq.append(StringUtils.leftPad(infNfse.getValorCredito().replace(".", ""), 15, '0'));
                valorTotalCreditos += Double.parseDouble(infNfse.getValorCredito());
                // ISS Retido
                gravarArq.append((infNfse.getServico().getValores().getIssRetido().equals("1")) ? "S" : "N");
                // Indicador de CPF/CNPJ do Tomador
                if (infNfse.getTomadorServico().getIdentificacaoTomador().getCpfCnpj().getCpf() != null) {
                    gravarArq.append("1");
                    // CPF ou CNPJ do Tomador-
                    gravarArq.append(StringUtils.leftPad(infNfse.getTomadorServico().getIdentificacaoTomador().getCpfCnpj().getCpf(), 14, '0'));
                } else if (infNfse.getTomadorServico().getIdentificacaoTomador().getCpfCnpj().getCnpj() != null) {
                    gravarArq.append("2");
                    // CPF ou CNPJ do Tomador-
                    gravarArq.append(StringUtils.leftPad(infNfse.getTomadorServico().getIdentificacaoTomador().getCpfCnpj().getCnpj(), 14, '0'));
                } else {
                    gravarArq.append("3");
                    // CPF ou CNPJ do Tomador-
                    gravarArq.append("00000000000000");
                }
                // Inscrição Municipal do Tomador
                gravarArq.append(StringUtils.leftPad(infNfse.getTomadorServico().getIdentificacaoTomador().getInscricaoMunicipal(), 8, '0'));
                // Inscrição Estadual do Tomador
                gravarArq.append("000000000000");
                // Razão Social do Tomador
                gravarArq.append(StringUtils.rightPad(infNfse.getTomadorServico().getRazaoSocial(), 75, ' '));
                // Tipo do Endereço do Tomador (Rua, Av, ...)
                split = separaTipoEndereco(infNfse.getTomadorServico().getEndereco().getEndereco(), 3, 50);
                gravarArq.append(split[0]);
                // Endereço do Tomador
                gravarArq.append(split[1]);
                // Número do Endereço do Tomador
                gravarArq.append(StringUtils.rightPad(infNfse.getTomadorServico().getEndereco().getNumero(), 10, ' '));
                // Complemento do Endereço do Tomador
                gravarArq.append(StringUtils.rightPad(infNfse.getTomadorServico().getEndereco().getComplemento(), 30, ' '));
                // Bairro do Tomador
                gravarArq.append(StringUtils.rightPad(infNfse.getTomadorServico().getEndereco().getBairro(), 30, ' '));
                // Cidade do Tomador
                gravarArq.append(StringUtils.rightPad(nomeMunicipio(Double.parseDouble(infNfse.getTomadorServico().getEndereco().getCodigoMunicipio())).replace("null", ""), 50, ' '));
                // UF do Tomador
                gravarArq.append(StringUtils.rightPad(infNfse.getTomadorServico().getEndereco().getUf(), 2, ' '));
                // CEP do Tomador
                gravarArq.append(StringUtils.leftPad(infNfse.getTomadorServico().getEndereco().getCep(), 8, '0'));
                // Email do Tomador
                gravarArq.append(StringUtils.rightPad(infNfse.getTomadorServico().getContato().getEmail(), 75, ' '));
                // Discriminação dos Serviços
                gravarArq.append(infNfse.getServico().getDiscriminacao().replace('\n', ' '));
                // Caractere de Fim de Linha
                gravarArq.append("\n");

            }
            // Registro Tipo 9 - Rodapé
            // Tipo de registro
            gravarArq.append("9");
            // Número de linhas de detalhe do arquivo
            gravarArq.append(StringUtils.leftPad(Integer.toString(listaNfse.size()), 7, '0'));
            // Valor total dos serviços contido no arquivo
            gravarArq.append(StringUtils.leftPad(doubleParaStringSemPontoCom2CasasDecimais(valorTotalServicos), 15, '0'));
            // Valor total das deduções contidas no arquivo
            gravarArq.append(StringUtils.leftPad(doubleParaStringSemPontoCom2CasasDecimais(valorTotalDeducoes), 15, '0'));
            // Valor total do ISS
            gravarArq.append(StringUtils.leftPad(doubleParaStringSemPontoCom2CasasDecimais(valorTotalISS), 15, '0'));
            // Valor total dos Créditos
            gravarArq.append(StringUtils.leftPad(doubleParaStringSemPontoCom2CasasDecimais(valorTotalCreditos), 15, '0'));
            // Caractere de Fim de Linha
            gravarArq.append("\n");

            gravarArq.close();
        }
    }

    private int ultimoDiaMes(int mes, int ano) {

        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (anoBissexto(ano)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return -1;
        }
    }

    private boolean anoBissexto(int ano) {

        return (ano % 400 == 0) || ((ano % 4 == 0) && (ano % 100 != 0));
    }

    private String[] separaTipoEndereco(String endereco, int nCaracteresTipo, int nCaracteresEndereco) {

        String[] retorno = new String[2];
        String[] split = endereco.split(" ");

        boolean enderecoTemTipo = false;
        if (split.length > 1) {
            switch (split[0].toLowerCase()) {
                case "rua":
                case "ru":
                case "ru.":
                case "r":
                case "r.":
                    retorno[0] = StringUtils.rightPad("R", nCaracteresTipo, ' ');
                    enderecoTemTipo = true;
                    break;
                case "avenida":
                case "av":
                case "av.":
                    retorno[0] = StringUtils.rightPad("AV", nCaracteresTipo, ' ');
                    enderecoTemTipo = true;
                    break;
                case "travessa":
                case "t":
                case "t.":
                case "tv":
                case "tv.":
                case "trv":
                case "trv.":
                    retorno[0] = StringUtils.rightPad("T", nCaracteresTipo, ' ');
                    enderecoTemTipo = true;
                    break;
                case "praca":
                case "praça":
                case "pca":
                case "pca.":
                case "pça":
                case "pça.":
                case "pc":
                case "pc.":
                case "pç":
                case "pç.":
                    retorno[0] = StringUtils.rightPad("PÇ", nCaracteresTipo, ' ');
                    enderecoTemTipo = true;
                    break;
                default:
                    retorno[0] = StringUtils.rightPad("", nCaracteresTipo, ' ');
                    break;
            }
        } else {
            retorno[0] = StringUtils.rightPad("", nCaracteresTipo, ' ');
        }

        int contador = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = (enderecoTemTipo ? 1 : 0); i < split.length && (contador + split[i].length()) <= nCaracteresEndereco; i++) {
            sb.append(split[i]);
            contador += split[i].length();
            if (i != split.length - 1 && (contador + split[i + 1].length()) <= nCaracteresEndereco) {
                sb.append(' ');
                contador += 1;
            }
        }
        while (contador < nCaracteresEndereco) {
            sb.append(' ');
            contador++;
        }
        retorno[1] = sb.toString();

        return retorno;
    }

    private String nomeMunicipio(double codigoIBGE) throws IOException {
        ExcelReader excelReader = new ExcelReader(getClass().getResourceAsStream("/res/codigosMunicipios.xlsx"));
        excelReader.selecionarPlanilha(0);
        String nomeMunicipio = excelReader.buscaBinariaMunicipio(codigoIBGE);
        return WordUtils.capitalizeFully(nomeMunicipio);
    }

    private String doubleParaStringSemPontoCom2CasasDecimais(double valor) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(valor).replace(".", "").replace(",", "");
    }
}
