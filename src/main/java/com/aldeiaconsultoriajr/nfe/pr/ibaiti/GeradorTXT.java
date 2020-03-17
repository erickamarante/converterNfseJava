package com.aldeiaconsultoriajr.nfe.pr.ibaiti;

import static com.aldeiaconsultoriajr.util.MyUtils.*;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
public class GeradorTXT {

    private final ArrayList<Nfs> listaNfs;

    public GeradorTXT(ListaNfs listaNfs) {
        this.listaNfs = listaNfs.getNfs();
    }

    public void gerarTXT(String path, boolean considerarISS) throws IOException {

        if (!listaNfs.isEmpty()) {
            FileOutputStream fos = new FileOutputStream(path + "NFSE_E_" + listaNfs.get(0).getPrestadorServico().getNrInscricaoMunicipal() + "_" + listaNfs.get(0).getDtEmissaoNfs()[0] + listaNfs.get(0).getDtEmissaoNfs()[1] + "01" + "_" + listaNfs.get(listaNfs.size() - 1).getDtEmissaoNfs()[0] + listaNfs.get(listaNfs.size() - 1).getDtEmissaoNfs()[1] + ultimoDiaMes(Integer.parseInt(listaNfs.get(listaNfs.size() - 1).getDtEmissaoNfs()[1]), Integer.parseInt(listaNfs.get(listaNfs.size() - 1).getDtEmissaoNfs()[0])) + ".txt");
            OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
            BufferedWriter gravarArq = new BufferedWriter(osw);

            // Registro Tipo 1 - Cabeçalho
            gravarArq.append("1");
            // Versão do Arquivo
            gravarArq.append("001");
            // Inscrição Municipal do Contribuinte
            gravarArq.append(strTamanhoMax(listaNfs.get(0).getPrestadorServico().getNrInscricaoMunicipal(), 8, "numerico"));
            // Data de Início do Período Transferido no Arquivo
            gravarArq.append(listaNfs.get(0).getDtEmissaoNfs()[0] + listaNfs.get(0).getDtEmissaoNfs()[1] + "01");
            // Data de Fim do Período Transferido no Arquivo
            gravarArq.append(listaNfs.get(listaNfs.size() - 1).getDtEmissaoNfs()[0] + listaNfs.get(listaNfs.size() - 1).getDtEmissaoNfs()[1] + ultimoDiaMes(Integer.parseInt(listaNfs.get(listaNfs.size() - 1).getDtEmissaoNfs()[1]), Integer.parseInt(listaNfs.get(listaNfs.size() - 1).getDtEmissaoNfs()[0])));
            // Caractere de Fim de Linha
            gravarArq.append("\n");

            double valorTotalServicos = 0;
            double valorTotalDeducoes = 0;
            double valorTotalISS = 0;
            double valorTotalCreditos = 0;
            for (Nfs nfs : listaNfs) {

                //InfNfse infNfse = nfs.getNfse().getInfNfse();
                // Registro Tipo 2 - Detalhe
                gravarArq.append("2");
                // Nº NF-e
                gravarArq.append(strTamanhoMax(nfs.getNrNfs(), 8, "numerico"));
                // Data Hora NFE
                gravarArq.append(nfs.getDtEmissaoNfs()[0] + nfs.getDtEmissaoNfs()[1] + nfs.getDtEmissaoNfs()[2] + nfs.getDtEmissaoNfs()[3] + nfs.getDtEmissaoNfs()[4] + nfs.getDtEmissaoNfs()[5]);
                // Código de Verificação da NF-e 
                gravarArq.append(strTamanhoMax(null, 8, "texto"));
                // Tipo de RPS
                gravarArq.append("RPS  ");
                // Série do RPS
                gravarArq.append("     ");
                // Número do RPS
                gravarArq.append("            ");
                // Data de Emissão do RPS
                gravarArq.append(nfs.getDtEmissaoNfs()[0] + nfs.getDtEmissaoNfs()[1] + nfs.getDtEmissaoNfs()[2]);
                // Inscrição Municipal do Prestador
                gravarArq.append(strTamanhoMax(nfs.getPrestadorServico().getNrInscricaoMunicipal(), 8, "numerico"));
                // Indicador de CPF/CNPJ do Prestador (1 - CPF; 2 - CNPJ)
                gravarArq.append((nfs.getPrestadorServico().getNrDocumento().length() == 11) ? "1" : "2");
                // CPF ou CNPJ do Prestador
                gravarArq.append(strTamanhoMax(nfs.getPrestadorServico().getNrDocumento(), 14, "numerico"));
                // Razão Social do Prestador
                gravarArq.append(strTamanhoMax(nfs.getPrestadorServico().getNmPrestador(), 75, "texto"));
                // Tipo do Endereço do Prestador (Rua, Av, ...)
                String[] split = separaTipoEndereco(nfs.getPrestadorServico().getDsEndereco(), 3, 50);
                gravarArq.append(split[0]);
                // Endereço do Prestador
                gravarArq.append(split[1]);
                // Número do Endereço do Prestador
                gravarArq.append(strTamanhoMax(nfs.getPrestadorServico().getNrEndereco(), 10, "texto"));
                // Complemento do Endereço do Prestador
                gravarArq.append("                              ");
                // Bairro do Prestador
                gravarArq.append(strTamanhoMax(nfs.getPrestadorServico().getNmBairro(), 30, "texto"));
                // Cidade do Prestador
                gravarArq.append(strTamanhoMax(nfs.getPrestadorServico().getNmCidade(), 50, "texto"));
                // UF do Prestador
                gravarArq.append(strTamanhoMax(nfs.getPrestadorServico().getNmUf(), 2, "texto"));
                // CEP do Prestador
                gravarArq.append(strTamanhoMax(nfs.getPrestadorServico().getNrCep(), 8, "numerico"));
                // E-mail do Prestador
                gravarArq.append(strTamanhoMax("", 75, "texto"));
                // Opção Pelo Simples
                gravarArq.append((nfs.getIsOptanteSimplesNacional()) ? "4" : "0");
                // Situação da Nota Fiscal
                gravarArq.append((nfs.getIsNfsCancelada()) ? "C" : " ");
                // Data de Cancelamento
                gravarArq.append("        ");
                // Nº da Guia
                gravarArq.append("000000000000");
                // Data de Quitação da Guia Vinculada a Nota Fiscal
                gravarArq.append("        ");
                // Valor dos Serviços
                double valorServico = 0;
                for (Servico s : nfs.getServicos()) {
                    valorServico += Double.parseDouble(s.getVlServico());
                }
                gravarArq.append(strTamanhoMax(doubleParaStringSemPontoCom2CasasDecimais(valorServico), 15, "numerico"));
                if (!nfs.getIsNfsCancelada()) {
                    valorTotalServicos += valorServico;
                }
                // Valor das Deduções
                double valorDeducao = 0;
                for (Servico s : nfs.getServicos()) {
                    valorDeducao += Double.parseDouble(s.getVlDeducao());
                }
                gravarArq.append(strTamanhoMax(doubleParaStringSemPontoCom2CasasDecimais(valorDeducao), 15, "numerico"));
                if (!nfs.getIsNfsCancelada()) {
                    valorTotalDeducoes += Double.parseDouble(nfs.getServicos().get(0).getVlDeducao());
                }
                // Código do Serviço Prestado na Nota Fiscal
                gravarArq.append(strTamanhoMax(nfs.getServicos().get(0).getNrServico().replace(".", ""), 5, "numerico"));
                // Alíquota
                double aliquota;
                if (considerarISS) {
                    aliquota = Double.parseDouble(nfs.getServicos().get(0).getVlAliquota());
                } else {
                    aliquota = 0.0;
                }
                gravarArq.append(strTamanhoMax(doubleParaStringSemPontoCom2CasasDecimais(aliquota), 4, "numerico"));
                // Valor do ISS
                double valorISS = 0;
                if (considerarISS) {
                    for (Servico s : nfs.getServicos()) {
                        valorISS += (Double.parseDouble(s.getVlAliquota()) / 100) * Double.parseDouble(s.getVlServico());
                    }
                } else {
                    valorISS = 0.0;
                }
                gravarArq.append(strTamanhoMax(doubleParaStringSemPontoCom2CasasDecimais(valorISS), 15, "numerico"));
                valorTotalISS += valorISS;
                // Valor do Crédito
                gravarArq.append(strTamanhoMax("", 15, "numerico"));
                valorTotalCreditos += 0;
                // ISS Retido
                gravarArq.append((nfs.getIsIssRetido()) ? "S" : "N");
                // Indicador de CPF/CNPJ do Tomador
                if (nfs.getTomadorServico().getNrDocumento() != null) {
                    switch (nfs.getTomadorServico().getNrDocumento().length()) {
                        case 11:
                            gravarArq.append("1");
                            // CPF do Tomador
                            gravarArq.append(strTamanhoMax(nfs.getTomadorServico().getNrDocumento(), 14, "numerico"));
                            break;
                        case 14:
                            gravarArq.append("2");
                            // CNPJ do Tomador
                            gravarArq.append(strTamanhoMax(nfs.getTomadorServico().getNrDocumento(), 14, "numerico"));
                            break;
                        default:
                            gravarArq.append("3");
                            // Documento não informado
                            gravarArq.append(strTamanhoMax("", 14, "numerico"));
                            break;
                    }
                } else {
                    gravarArq.append("3");
                    // Documento não informado
                    gravarArq.append(strTamanhoMax(null, 14, "numerico"));
                }
                // Inscrição Municipal do Tomador
                gravarArq.append(strTamanhoMax("", 8, "numerico"));
                // Inscrição Estadual do Tomador
                gravarArq.append(strTamanhoMax("", 12, "texto"));
                // Razão Social do Tomador
                if (nfs.getTomadorServico().getNmTomador() != null) {
                    gravarArq.append(strTamanhoMax(nfs.getTomadorServico().getNmTomador(), 75, "texto"));
                } else {
                    gravarArq.append(strTamanhoMax(null, 75, "texto"));
                }
                if (nfs.getTomadorServico().getDsEndereco() != null) {
                    // Tipo do Endereço do Tomador (Rua, Av, ...)
                    split = separaTipoEndereco(nfs.getTomadorServico().getDsEndereco(), 3, 50);
                    gravarArq.append(split[0]);
                    // Endereço do Tomador
                    gravarArq.append(split[1]);
                    // Número do Endereço do Tomador
                    gravarArq.append(strTamanhoMax(nfs.getTomadorServico().getNrEndereco(), 10, "texto"));
                    // Complemento do Endereço do Tomador
                    gravarArq.append(strTamanhoMax("", 30, "texto"));
                    // Bairro do Tomador
                    gravarArq.append(strTamanhoMax(nfs.getTomadorServico().getNmBairro(), 30, "texto"));
                    // Cidade do Tomador
                    if (nfs.getTomadorServico().getNmCidade() != null) {
                        gravarArq.append(strTamanhoMax(nfs.getTomadorServico().getNmCidade(), 50, "texto"));
                    } else {
                        gravarArq.append(strTamanhoMax("", 50, "texto"));
                    }
                    // UF do Tomador
                    if (nfs.getTomadorServico().getNmUf() != null) {
                        gravarArq.append(strTamanhoMax(nfs.getTomadorServico().getNmUf(), 2, "texto"));
                    } else {
                        gravarArq.append(strTamanhoMax("", 2, "texto"));
                    }
                    // CEP do Tomador
                    gravarArq.append(strTamanhoMax(nfs.getTomadorServico().getNrCep(), 8, "numerico"));
                } else {
                    gravarArq.append(strTamanhoMax(nfs.getTomadorServico().getNmTomador(), 183, "texto"));
                }
                // Email do Tomador
                gravarArq.append(strTamanhoMax(null, 75, "texto"));
                // Discriminação dos 
                gravarArq.append(nfs.getServicos().get(0).getDsDiscriminacaoServico().replace('\n', ' ').replace('\r', ' '));
                // Caractere de Fim de Linha
                gravarArq.append("\n");

            }
            // Registro Tipo 9 - Rodapé
            // Tipo de registro
            gravarArq.append("9");
            // Número de linhas de detalhe do arquivo
            gravarArq.append(StringUtils.leftPad(Integer.toString(listaNfs.size()), 7, '0'));
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
}
