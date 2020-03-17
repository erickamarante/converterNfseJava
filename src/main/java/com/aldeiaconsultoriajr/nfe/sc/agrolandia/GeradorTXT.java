package com.aldeiaconsultoriajr.nfe.sc.agrolandia;

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

    private final ArrayList<Nfse> listaNfse;

    public GeradorTXT(ArrayList<Nfse> listaNfse) {
        this.listaNfse = listaNfse;
    }

    public void gerarTXT(String path, boolean considerarISS) throws IOException {

        if (!listaNfse.isEmpty()) {
            FileOutputStream fos = new FileOutputStream(path + "NFSE_E__" + listaNfse.get(0).getNf().getData_nfse()[0] + listaNfse.get(0).getNf().getData_nfse()[1] + listaNfse.get(0).getNf().getData_nfse()[2] + "_" + listaNfse.get(listaNfse.size() - 1).getNf().getData_nfse()[0] + listaNfse.get(listaNfse.size() - 1).getNf().getData_nfse()[1] + listaNfse.get(listaNfse.size() - 1).getNf().getData_nfse()[2] + ".txt");
            OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
            BufferedWriter gravarArq = new BufferedWriter(osw);

            // Registro Tipo 1 - Cabeçalho
            gravarArq.append("1");
            // Versão do Arquivo
            gravarArq.append("001");
            // Inscrição Municipal do Contribuinte
            gravarArq.append(strTamanhoMax(null, 8, "numerico"));
            // Data de Início do Período Transferido no Arquivo
            gravarArq.append(listaNfse.get(0).getNf().getData_nfse()[0] + listaNfse.get(0).getNf().getData_nfse()[1] + listaNfse.get(0).getNf().getData_nfse()[2]);
            // Data de Fim do Período Transferido no Arquivo
            gravarArq.append(listaNfse.get(listaNfse.size() - 1).getNf().getData_nfse()[0] + listaNfse.get(listaNfse.size() - 1).getNf().getData_nfse()[1] + listaNfse.get(listaNfse.size() - 1).getNf().getData_nfse()[2]);
            // Caractere de Fim de Linha
            gravarArq.append("\n");

            double valorTotalServicos = 0;
            double valorTotalDeducoes = 0;
            double valorTotalISS = 0;
            double valorTotalCreditos = 0;

            for (Nfse nfse : listaNfse) {

                // Registro Tipo 2 - Detalhe
                gravarArq.append("2");
                // Nº NF-e
                gravarArq.append(strTamanhoMax(nfse.getNf().getNumero_nfse(), 8, "numerico"));
                // Data Hora NFE
                String[] data = nfse.getNf().getData_nfse();
                String[] hora = nfse.getNf().getHora_nfse();
                gravarArq.append(data[0] + data[1] + data[2] + hora[0] + hora[1] + hora[2]);
                // Código de Verificação da NF-e 
                gravarArq.append(strTamanhoMax(null, 8, "texto"));
                // Tipo de RPS
                gravarArq.append(strTamanhoMax("RPS", 5, "texto"));
                // Série do RPS
                gravarArq.append(strTamanhoMax(null, 5, "texto"));
                // Número do RPS
                gravarArq.append(strTamanhoMax(null, 12, "numerico"));
                // Data de Emissão do RPS
                gravarArq.append(data[0] + data[1] + data[2]);
                // Inscrição Municipal do Prestador
                gravarArq.append(strTamanhoMax(null, 8, "numerico"));
                // Indicador de CPF/CNPJ do Prestador (1 - CPF; 2 - CNPJ)
                gravarArq.append((nfse.getPrestador().getCpfCnpj().length() == 14) ? "2" : "1");
                // CPF ou CNPJ do Prestador
                gravarArq.append(strTamanhoMax(nfse.getPrestador().getCpfCnpj(), 14, "numerico"));
                // Razão Social do Prestador
                gravarArq.append(strTamanhoMax(null, 75, "texto"));
                // Tipo do Endereço do Prestador (Rua, Av, ...)
                gravarArq.append(strTamanhoMax(null, 3, "texto"));
                // Endereço do Prestador
                gravarArq.append(strTamanhoMax(null, 50, "texto"));
                // Número do Endereço do Prestador
                gravarArq.append(strTamanhoMax(null, 10, "numerico"));
                // Complemento do Endereço do Prestador
                gravarArq.append(strTamanhoMax(null, 30, "texto"));
                // Bairro do Prestador
                gravarArq.append(strTamanhoMax(null, 30, "texto"));
                // Cidade do Prestador
                gravarArq.append(strTamanhoMax("AGROLANDIA", 50, "texto"));
                // UF do Prestador
                gravarArq.append(strTamanhoMax("SC", 2, "texto"));
                // CEP do Prestador
                gravarArq.append(strTamanhoMax(null, 8, "numerico"));
                // E-mail do Prestador
                gravarArq.append(strTamanhoMax(null, 75, "texto"));
                // Opção Pelo Simples
                gravarArq.append(strTamanhoMax(null, 1, "numerico"));
                // Situação da Nota Fiscal
                if (nfse.getNf().getSituacao() != null && nfse.getNf().getSituacao().equals("C")) {
                    gravarArq.append(strTamanhoMax(nfse.getNf().getSituacao(), 1, "texto"));
                    gravarArq.append(strTamanhoMax(null, 8, "texto"));
                } else {
                    gravarArq.append(strTamanhoMax(null, 9, "texto"));
                }
                // Nº da Guia
                gravarArq.append(strTamanhoMax(null, 12, "numerico"));
                // Data de Quitação da Guia Vinculada a Nota Fiscal
                gravarArq.append(strTamanhoMax(null, 8, "texto"));
                // Valor dos Serviços
                double valorServicos = Double.parseDouble(nfse.getItens().getLista().getValor_tributavel());
                gravarArq.append(strTamanhoMax(doubleParaStringSemPontoCom2CasasDecimais(valorServicos), 15, "numerico"));
                valorTotalServicos += valorServicos;
                // Valor das Deduções
                double valor = Double.parseDouble(nfse.getItens().getLista().getValor_deducao());
                gravarArq.append(strTamanhoMax(doubleParaStringSemPontoCom2CasasDecimais(valor), 15, "numerico"));
                valorTotalDeducoes += valor;
                // Código do Serviço Prestado na Nota Fiscal
                gravarArq.append(strTamanhoMax(nfse.getItens().getLista().getCodigo_item_lista_servico(), 5, "numerico"));
                // Alíquota
                double aliquota;
                if (considerarISS) {
                    aliquota = Double.parseDouble(nfse.getItens().getLista().getAliquota_item_lista_servico());
                    gravarArq.append(strTamanhoMax(doubleParaStringSemPontoCom2CasasDecimais(aliquota), 4, "numerico"));
                } else {
                    aliquota = 0.0;
                    gravarArq.append(strTamanhoMax(null, 4, "numerico"));
                }
                // Valor do ISS
                if (considerarISS) {
                    valor = valorServicos * aliquota;
                } else {
                    valor = 0.0;
                }
                gravarArq.append(strTamanhoMax(doubleParaStringSemPontoCom2CasasDecimais(valor), 15, "numerico"));
                valorTotalISS += valor;

                // Valor do Crédito
                valor = 0.0;
                gravarArq.append(strTamanhoMax(doubleParaStringSemPontoCom2CasasDecimais(valor), 15, "numerico"));
                valorTotalCreditos += valor;
                // ISS Retido
                gravarArq.append((Double.parseDouble(nfse.getItens().getLista().getValor_issrf()) > 0) ? "S" : "N");
                // Indicador de CPF/CNPJ do Tomador
                if (nfse.getTomador().getCpfcnpj() != null) {
                    if (nfse.getTomador().getCpfcnpj().length() > 11) {
                        gravarArq.append("2");
                        // CNPJ do Tomador
                        gravarArq.append(strTamanhoMax(nfse.getTomador().getCpfcnpj(), 14, "numerico"));
                    } else {
                        gravarArq.append("1");
                        // CPF do Tomador
                        gravarArq.append(strTamanhoMax(nfse.getTomador().getCpfcnpj(), 14, "numerico"));
                    }
                } else {
                    gravarArq.append("3");
                    // CPF ou CNPJ do Tomador
                    gravarArq.append(strTamanhoMax(null, 14, "numerico"));
                }
                // Inscrição Municipal do Tomador
                gravarArq.append(strTamanhoMax(null, 8, "numerico"));
                // Inscrição Estadual do Tomador
                gravarArq.append(strTamanhoMax(nfse.getTomador().getIe(), 12, "texto"));
                // Razão Social do Tomador
                if (nfse.getTomador().getSobrenome_nome_fantasia() != null) {
                    gravarArq.append(strTamanhoMax(nfse.getTomador().getNome_razao_social() + " " + nfse.getTomador().getSobrenome_nome_fantasia(), 75, "texto"));
                } else {
                    gravarArq.append(strTamanhoMax(nfse.getTomador().getNome_razao_social(), 75, "texto"));
                }

                if (nfse.getTomador().getLogradouro() != null) {
                    // Tipo do Endereço do Tomador (Rua, Av, ...)
                    String[] split = separaTipoEndereco(nfse.getTomador().getLogradouro(), 3, 50);
                    gravarArq.append(split[0]);
                    // Endereço do Tomador
                    gravarArq.append(split[1]);
                } else {
                    gravarArq.append(strTamanhoMax("", 53, "texto"));
                }
                // Número do Endereço do Tomador
                gravarArq.append(strTamanhoMax(null, 10, "texto"));
                // Complemento do Endereço do Tomador
                gravarArq.append(strTamanhoMax(nfse.getTomador().getComplemento(), 30, "texto"));
                // Bairro do Tomador
                gravarArq.append(strTamanhoMax(nfse.getTomador().getBairro(), 30, "texto"));
                // Cidade do Tomador
                gravarArq.append(strTamanhoMax(nfse.getTomador().getCidade(), 50, "texto"));
                // UF do Tomador
                gravarArq.append(strTamanhoMax(null, 2, "texto"));
                // CEP do Tomador
                gravarArq.append(strTamanhoMax(nfse.getTomador().getCep(), 8, "numerico"));
                // Email do Tomador
                gravarArq.append(strTamanhoMax(nfse.getTomador().getEmail(), 75, "texto"));
                // Discriminação dos Serviços
                gravarArq.append(nfse.getItens().getLista().getDescritivo());
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
}
