package com.aldeiaconsultoriajr.nfe.go.rioVerde;

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

    private final ArrayList<ComplNfse> listaNfse;

    public GeradorTXT(ConsultarNfseResposta consultarNfseResposta) {
        this.listaNfse = consultarNfseResposta.getListaNfse();
    }

    public void gerarTXT(String path, boolean considerarISS) throws IOException {

        if (!listaNfse.isEmpty()) {
            String inscricaoMunicipal = listaNfse.get(0).getNfse().getInfNfse().getPrestadorServico().getIdentificacaoPrestador().getInscricaoMunicipal();
            FileOutputStream fos = new FileOutputStream(path + "NFSE_E_" + inscricaoMunicipal + "_" + listaNfse.get(0).getNfse().getInfNfse().getDataEmissao()[0] + listaNfse.get(0).getNfse().getInfNfse().getDataEmissao()[1] + listaNfse.get(0).getNfse().getInfNfse().getDataEmissao()[2] + "_" + listaNfse.get(listaNfse.size() - 1).getNfse().getInfNfse().getDataEmissao()[0] + listaNfse.get(listaNfse.size() - 1).getNfse().getInfNfse().getDataEmissao()[1] + listaNfse.get(listaNfse.size() - 1).getNfse().getInfNfse().getDataEmissao()[2] + ".txt");
            OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
            BufferedWriter gravarArq = new BufferedWriter(osw);

            // Registro Tipo 1 - Cabeçalho
            gravarArq.append("1");
            // Versão do Arquivo
            gravarArq.append("001");
            // Inscrição Municipal do Contribuinte
            gravarArq.append(strTamanhoMax(inscricaoMunicipal, 8, "numerico"));
            // Data de Início do Período Transferido no Arquivo
            gravarArq.append(listaNfse.get(0).getNfse().getInfNfse().getDataEmissao()[0] + listaNfse.get(0).getNfse().getInfNfse().getDataEmissao()[1] + listaNfse.get(0).getNfse().getInfNfse().getDataEmissao()[2]);
            // Data de Fim do Período Transferido no Arquivo
            gravarArq.append(listaNfse.get(listaNfse.size() - 1).getNfse().getInfNfse().getDataEmissao()[0] + listaNfse.get(listaNfse.size() - 1).getNfse().getInfNfse().getDataEmissao()[1] + listaNfse.get(listaNfse.size() - 1).getNfse().getInfNfse().getDataEmissao()[2]);
            // Caractere de Fim de Linha
            gravarArq.append("\n");

            double valorTotalServicos = 0;
            double valorTotalDeducoes = 0;
            double valorTotalISS = 0;
            double valorTotalCreditos = 0;

            String codigoCidadeAnterior = null;
            String cidadeAnterior = null;

            for (ComplNfse complNfse : listaNfse) {

                InfNfse infNfse = complNfse.getNfse().getInfNfse();

                // Registro Tipo 2 - Detalhe
                gravarArq.append("2");
                // Nº NF-e
                gravarArq.append(strTamanhoMax(infNfse.getNumero(), 8, "numerico"));
                // Data Hora NFE
                String[] data = infNfse.getDataEmissao();
                gravarArq.append(data[0] + data[1] + data[2] + data[3] + data[4] + data[5].substring(0, 2));
                // Código de Verificação da NF-e 
                //gravarArq.append(strTamanhoMax(infNfse.getCodigoVerificacao(), 8, "texto"));
                gravarArq.append(strTamanhoMax(null, 8, "texto"));
                // Tipo de RPS
                gravarArq.append(strTamanhoMax("RPS", 5, "texto"));
                // Série do RPS
                gravarArq.append(strTamanhoMax("", 5, "texto"));
                // Número do RPS
                gravarArq.append(strTamanhoMax("", 12, "numerico"));
                // Data de Emissão do RPS
                gravarArq.append(data[0] + data[1] + data[2]);
                // Inscrição Municipal do Prestador
                gravarArq.append(strTamanhoMax(infNfse.getPrestadorServico().getIdentificacaoPrestador().getInscricaoMunicipal(), 8, "numerico"));
                // Indicador de CPF/CNPJ do Prestador (1 - CPF; 2 - CNPJ)
                gravarArq.append("2");
                // CPF ou CNPJ do Prestador
                gravarArq.append(strTamanhoMax(infNfse.getPrestadorServico().getIdentificacaoPrestador().getCnpj(), 14, "numerico"));
                // Razão Social do Prestador
                gravarArq.append(strTamanhoMax(infNfse.getPrestadorServico().getRazaoSocial(), 75, "texto"));
                // Tipo do Endereço do Prestador (Rua, Av, ...)
                String[] split = separaTipoEndereco(infNfse.getPrestadorServico().getEndereco().getEndereco(), 3, 50);
                gravarArq.append(split[0]);
                // Endereço do Prestador
                gravarArq.append(split[1]);
                // Número do Endereço do Prestador
                gravarArq.append(strTamanhoMax(infNfse.getPrestadorServico().getEndereco().getNumero(), 10, "numerico"));
                // Complemento do Endereço do Prestador
                gravarArq.append(strTamanhoMax(infNfse.getPrestadorServico().getEndereco().getComplemento(), 30, "texto"));
                // Bairro do Prestador
                gravarArq.append(strTamanhoMax(infNfse.getPrestadorServico().getEndereco().getBairro(), 30, "texto"));
                // Cidade do Prestador
                String codigoCidade = infNfse.getPrestadorServico().getEndereco().getCodigoMunicipio();
                if (codigoCidade.equals(codigoCidadeAnterior)) {
                    gravarArq.append(strTamanhoMax(cidadeAnterior, 50, "texto"));
                } else {
                    codigoCidadeAnterior = codigoCidade;
                    cidadeAnterior = nomeMunicipio(Double.parseDouble(codigoCidade)).replace("null", "");
                    gravarArq.append(strTamanhoMax(cidadeAnterior, 50, "texto"));
                }
                // UF do Prestador
                gravarArq.append(strTamanhoMax(ufMunicipio(codigoCidade), 2, "texto"));
                // CEP do Prestador
                gravarArq.append(strTamanhoMax(infNfse.getPrestadorServico().getEndereco().getCep(), 8, "numerico"));
                // E-mail do Prestador
                if (infNfse.getPrestadorServico().getContato() != null) {
                    gravarArq.append(strTamanhoMax(infNfse.getPrestadorServico().getContato().getEmail(), 75, "texto"));
                } else {
                    gravarArq.append(strTamanhoMax("", 75, "texto"));
                }
                // Opção Pelo Simples
                if (infNfse.getOptanteSimplesNacional()) {
                    gravarArq.append('4');
                } else {
                    gravarArq.append('0');
                }
                // Situação da Nota Fiscal
                if (complNfse.getNfseCancelamento().getConfirmacao().getInfConfirmacaoCancelamento().getSucesso().equals("true")) {
                    gravarArq.append('C');
                    // Data de Cancelamento
                    data = complNfse.getNfseCancelamento().getConfirmacao().getInfConfirmacaoCancelamento().getDataHora();
                    gravarArq.append(data[0] + data[1] + data[2]);
                } else {
                    gravarArq.append(strTamanhoMax("", 9, "texto"));
                }
                // Nº da Guia
                gravarArq.append(strTamanhoMax("", 12, "numerico"));
                // Data de Quitação da Guia Vinculada a Nota Fiscal
                gravarArq.append(strTamanhoMax("", 8, "texto"));
                // Valor dos Serviços
                double valor = Double.parseDouble(infNfse.getServico().getValores().getValorServicos());
                gravarArq.append(strTamanhoMax(doubleParaStringSemPontoCom2CasasDecimais(valor), 15, "numerico"));
                valorTotalServicos += valor;
                // Valor das Deduções
                valor = Double.parseDouble(infNfse.getServico().getValores().getValorDeducoes());
                gravarArq.append(strTamanhoMax(doubleParaStringSemPontoCom2CasasDecimais(valor), 15, "numerico"));
                valorTotalDeducoes += valor;
                // Código do Serviço Prestado na Nota Fiscal
                gravarArq.append(strTamanhoMax(infNfse.getServico().getItemListaServico(), 5, "numerico"));
                // Alíquota
                if (considerarISS) {
                    valor = Double.parseDouble(infNfse.getServico().getValores().getAliquota());
                } else {
                    valor = 0.0;
                }
                gravarArq.append(strTamanhoMax(doubleParaStringSemPontoCom2CasasDecimais(valor), 4, "numerico"));
                // Valor do ISS
                if (considerarISS) {
                    valor = Double.parseDouble(infNfse.getServico().getValores().getValorIss());
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
                gravarArq.append((infNfse.getServico().getValores().getIssRetido()) ? "S" : "N");
                // Indicador de CPF/CNPJ do Tomador
                if (infNfse.getTomadorServico().getIdentificacaoTomador().getCpfCnpj() != null) {
                    if (infNfse.getTomadorServico().getIdentificacaoTomador().getCpfCnpj().getCpf() != null) {
                        gravarArq.append("1");
                        // CPF ou CNPJ do Tomador
                        gravarArq.append(strTamanhoMax(infNfse.getTomadorServico().getIdentificacaoTomador().getCpfCnpj().getCpf(), 14, "numerico"));
                    } else if (infNfse.getTomadorServico().getIdentificacaoTomador().getCpfCnpj().getCnpj() != null) {
                        gravarArq.append("2");
                        // CPF ou CNPJ do Tomador
                        gravarArq.append(strTamanhoMax(infNfse.getTomadorServico().getIdentificacaoTomador().getCpfCnpj().getCnpj(), 14, "numerico"));
                    }
                } else {
                    gravarArq.append("3");
                    // CPF ou CNPJ do Tomador
                    gravarArq.append(strTamanhoMax("", 14, "numerico"));
                }

                // Inscrição Municipal do Tomador
                gravarArq.append(strTamanhoMax(infNfse.getTomadorServico().getIdentificacaoTomador().getInscricaoMunicipal(), 8, "numerico"));
                // Inscrição Estadual do Tomador
                gravarArq.append(strTamanhoMax("", 12, "texto"));
                // Razão Social do Tomador
                gravarArq.append(strTamanhoMax(infNfse.getTomadorServico().getRazaoSocial(), 75, "texto"));

                if (infNfse.getTomadorServico().getEndereco() != null) {
                    if (infNfse.getTomadorServico().getEndereco().getEndereco() != null) {
                        // Tipo do Endereço do Tomador (Rua, Av, ...)
                        split = separaTipoEndereco(infNfse.getTomadorServico().getEndereco().getEndereco(), 3, 50);
                        gravarArq.append(split[0]);
                        // Endereço do Tomador
                        gravarArq.append(split[1]);
                    } else {
                        gravarArq.append(strTamanhoMax("", 53, "texto"));
                    }
                    // Número do Endereço do Tomador
                    gravarArq.append(strTamanhoMax(infNfse.getTomadorServico().getEndereco().getNumero(), 10, "texto"));
                    // Complemento do Endereço do Tomador
                    gravarArq.append(strTamanhoMax(infNfse.getTomadorServico().getEndereco().getComplemento(), 30, "texto"));
                    // Bairro do Tomador
                    gravarArq.append(strTamanhoMax(infNfse.getTomadorServico().getEndereco().getBairro(), 30, "texto"));
                    // Cidade do Tomador
                    codigoCidade = infNfse.getTomadorServico().getEndereco().getCodigoMunicipio();
                    if (codigoCidade != null) {
                        if (codigoCidade.equals(codigoCidadeAnterior)) {
                            gravarArq.append(strTamanhoMax(cidadeAnterior, 50, "texto"));
                        } else {
                            codigoCidadeAnterior = codigoCidade;
                            cidadeAnterior = nomeMunicipio(Double.parseDouble(codigoCidade)).replace("null", "");
                            gravarArq.append(strTamanhoMax(cidadeAnterior, 50, "texto"));
                        }
                    } else {
                        gravarArq.append(strTamanhoMax("", 50, "texto"));
                    }
                    // UF do Tomador
                    gravarArq.append(strTamanhoMax(infNfse.getTomadorServico().getEndereco().getUf(), 2, "texto"));
                    // CEP do Tomador
                    gravarArq.append(strTamanhoMax(infNfse.getTomadorServico().getEndereco().getCep(), 8, "numerico"));
                } else {
                    gravarArq.append(strTamanhoMax("", 183, "texto"));
                }
                // Email do Tomador
                if (infNfse.getTomadorServico().getContato() != null) {
                    gravarArq.append(strTamanhoMax(infNfse.getTomadorServico().getContato().getEmail(), 75, "texto"));
                } else {
                    gravarArq.append(strTamanhoMax("", 75, "texto"));
                }
                // Discriminação dos Serviços
                gravarArq.append(infNfse.getServico().getDiscriminacao());
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
