package com.aldeiaconsultoriajr.nfe.ba.salvador;

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

    private final ArrayList<CompNfse> listaNfse;

    public GeradorTXT(ConsultarNfseResposta consultarNfseResposta) {
        this.listaNfse = consultarNfseResposta.getListaNfse();
    }

    /**
     *
     * @param tipo 1 - NFSe Emitida; 2 - NFSe Recebida.
     * @throws IOException
     */
    public void gerarTXT(String path, int tipo, boolean considerarISS) throws IOException {

        if (!listaNfse.isEmpty()) {
            String inscricaoMunicipal = (tipo == 1) ? listaNfse.get(0).getNfse().getInfNfse().getPrestadorServico().getIdentificacaoPrestador().getInscricaoMunicipal() : listaNfse.get(0).getNfse().getInfNfse().getTomadorServico().getIdentificacaoTomador().getInscricaoMunicipal();
            FileOutputStream fos = new FileOutputStream(path + "NFSE_" + ((tipo == 1) ? "E_" : "R_") + inscricaoMunicipal + "_" + listaNfse.get(0).getNfse().getInfNfse().getDataEmissao()[0] + listaNfse.get(0).getNfse().getInfNfse().getDataEmissao()[1] + "01" + "_" + listaNfse.get(listaNfse.size() - 1).getNfse().getInfNfse().getDataEmissao()[0] + listaNfse.get(listaNfse.size() - 1).getNfse().getInfNfse().getDataEmissao()[1] + ultimoDiaMes(Integer.parseInt(listaNfse.get(listaNfse.size() - 1).getNfse().getInfNfse().getDataEmissao()[1]), Integer.parseInt(listaNfse.get(listaNfse.size() - 1).getNfse().getInfNfse().getDataEmissao()[0])) + ".txt");
            OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
            BufferedWriter gravarArq = new BufferedWriter(osw);

            // Registro Tipo 1 - Cabeçalho
            gravarArq.append("1");
            // Versão do Arquivo
            gravarArq.append("001");
            // Inscrição Municipal do Contribuinte
            gravarArq.append(listaNfse.get(0).getNfse().getInfNfse().getPrestadorServico().getIdentificacaoPrestador().getInscricaoMunicipal().substring(0, 8));
            // Data de Início do Período Transferido no Arquivo
            gravarArq.append(listaNfse.get(0).getNfse().getInfNfse().getDataEmissao()[0] + listaNfse.get(0).getNfse().getInfNfse().getDataEmissao()[1] + "01");
            // Data de Fim do Período Transferido no Arquivo
            gravarArq.append(listaNfse.get(listaNfse.size() - 1).getNfse().getInfNfse().getDataEmissao()[0] + listaNfse.get(listaNfse.size() - 1).getNfse().getInfNfse().getDataEmissao()[1] + ultimoDiaMes(Integer.parseInt(listaNfse.get(listaNfse.size() - 1).getNfse().getInfNfse().getDataEmissao()[1]), Integer.parseInt(listaNfse.get(listaNfse.size() - 1).getNfse().getInfNfse().getDataEmissao()[0])));
            // Caractere de Fim de Linha
            gravarArq.append("\n");

            double valorTotalServicos = 0;
            double valorTotalDeducoes = 0;
            double valorTotalISS = 0;
            double valorTotalCreditos = 0;

            String codigoCidadeAnterior = null;
            String cidadeAnterior = null;

            for (CompNfse compNfse : listaNfse) {

                InfNfse infNfse = compNfse.getNfse().getInfNfse();

                // Registro Tipo 2 - Detalhe
                gravarArq.append("2");
                // Nº NF-e
                gravarArq.append(StringUtils.leftPad(infNfse.getNumero(), 8, "0"));
                // Data Hora NFE
                String[] data = infNfse.getDataEmissao();
                gravarArq.append(data[0] + data[1] + data[2] + data[3] + data[4] + data[5]);
                // Código de Verificação da NF-e
                //gravarArq.append(StringUtils.rightPad(infNfse.getCodigoVerificacao(), 8, ' '));
                gravarArq.append(strTamanhoMax(null, 8, "texto"));
                // Tipo de RPS
                gravarArq.append("RPS  ");
                // Série do RPS
                gravarArq.append(StringUtils.rightPad(infNfse.getIdentificacaoRps().getSerie(), 5, ' '));
                // Número do RPS
                gravarArq.append(StringUtils.leftPad(infNfse.getIdentificacaoRps().getNumero(), 12, '0'));
                // Data de Emissão do RPS
                gravarArq.append(data[0] + data[1] + data[2]);
                // Inscrição Municipal do Prestador
                gravarArq.append(listaNfse.get(0).getNfse().getInfNfse().getPrestadorServico().getIdentificacaoPrestador().getInscricaoMunicipal().substring(0, 8));
                // Indicador de CPF/CNPJ do Prestador (1 - CPF; 2 - CNPJ)
                gravarArq.append("2");
                // CPF ou CNPJ do Prestador
                gravarArq.append(StringUtils.leftPad(infNfse.getPrestadorServico().getIdentificacaoPrestador().getCnpj(), 14, '0'));
                // Razão Social do Prestador
                gravarArq.append(StringUtils.rightPad(infNfse.getPrestadorServico().getRazaoSocial(), 75, ' '));
                // Tipo do Endereço do Prestador (Rua, Av, ...)
                String[] split = separaTipoEndereco(infNfse.getPrestadorServico().getEndereco().getEndereco(), 3, 50);
                gravarArq.append(split[0]);
                // Endereço do Prestador
                gravarArq.append(split[1]);
                // Número do Endereço do Prestador
                gravarArq.append(StringUtils.rightPad(infNfse.getPrestadorServico().getEndereco().getNumero(), 10, ' '));
                // Complemento do Endereço do Prestador
                gravarArq.append(StringUtils.rightPad(infNfse.getPrestadorServico().getEndereco().getComplemento(), 30, ' '));
                // Bairro do Prestador
                gravarArq.append(StringUtils.rightPad(infNfse.getPrestadorServico().getEndereco().getBairro(), 30, ' '));
                // Cidade do Prestador
                String codigoCidade = infNfse.getPrestadorServico().getEndereco().getCodigoMunicipio();
                if (!codigoCidade.equals("")) {
                    if (codigoCidade.equals(codigoCidadeAnterior)) {
                        gravarArq.append(StringUtils.rightPad(cidadeAnterior, 50, ' '));
                    } else {
                        codigoCidadeAnterior = codigoCidade;
                        cidadeAnterior = nomeMunicipio(Double.parseDouble(codigoCidade)).replace("null", "");
                        gravarArq.append(StringUtils.rightPad(cidadeAnterior, 50, ' '));
                    }
                } else {
                    gravarArq.append(StringUtils.rightPad("", 50, ' '));
                }
                // UF do Prestador
                gravarArq.append(StringUtils.rightPad(infNfse.getPrestadorServico().getEndereco().getUf(), 2, ' '));
                // CEP do Prestador
                gravarArq.append(StringUtils.rightPad(infNfse.getPrestadorServico().getEndereco().getCep() != null ? infNfse.getPrestadorServico().getEndereco().getCep() : "", 8, '0'));
                // E-mail do Prestador
                gravarArq.append(StringUtils.rightPad(infNfse.getPrestadorServico().getContato().getEmail(), 75, ' '));
                // Opção Pelo Simples
                switch (infNfse.getOptanteSimplesNacional()) {
                    case "1":
                        gravarArq.append('4');
                        break;
                    default:
                        gravarArq.append('0');
                }
                // Situação da Nota Fiscal
                if (compNfse.getNfseCancelamento() != null) {
                    gravarArq.append('C');
                    // Data de Cancelamento
                    data = compNfse.getNfseCancelamento().getConfirmacao().getDataHoraCancelamento();
                    gravarArq.append(data[0] + data[1] + data[2]);
                } else {
                    gravarArq.append("         ");
                }
                // Nº da Guia
                gravarArq.append("000000000000");
                // Data de Quitação da Guia Vinculada a Nota Fiscal
                gravarArq.append("        ");
                // Valor dos Serviços
                double valor = Double.parseDouble(infNfse.getServico().getValores().getValorServicos());
                gravarArq.append(StringUtils.leftPad(doubleParaStringSemPontoCom2CasasDecimais(valor), 15, '0'));
                valorTotalServicos += valor;
                // Valor das Deduções
                valor = Double.parseDouble(infNfse.getServico().getValores().getValorDeducoes());
                gravarArq.append(StringUtils.leftPad(doubleParaStringSemPontoCom2CasasDecimais(valor), 15, '0'));
                valorTotalDeducoes += valor;
                // Código do Serviço Prestado na Nota Fiscal
                gravarArq.append(StringUtils.leftPad(infNfse.getServico().getItemListaServico(), 5, '0'));
                // Alíquota
                if (considerarISS) {
                    valor = Double.parseDouble(infNfse.getServico().getValores().getAliquota()) * 100;
                } else {
                    valor = 0.0;
                }
                gravarArq.append(StringUtils.leftPad(doubleParaStringSemPontoCom2CasasDecimais(valor), 4, '0'));
                // Valor do ISS
                if (considerarISS) {
                    valor = Double.parseDouble(infNfse.getServico().getValores().getValorIss());
                } else {
                    valor = 0.0;
                }
                gravarArq.append(StringUtils.leftPad(doubleParaStringSemPontoCom2CasasDecimais(valor), 15, '0'));
                valorTotalISS += valor;
                // Valor do Crédito
                gravarArq.append("000000000000000");
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
                gravarArq.append(strTamanhoMax(infNfse.getTomadorServico().getIdentificacaoTomador().getInscricaoMunicipal(), 8, "numerico"));
                // Inscrição Estadual do Tomador
                gravarArq.append("            ");
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
                codigoCidade = infNfse.getTomadorServico().getEndereco().getCodigoMunicipio();
                if (!codigoCidade.equals("")) {
                    if (codigoCidade.equals(codigoCidadeAnterior)) {
                        gravarArq.append(StringUtils.rightPad(cidadeAnterior, 50, ' '));
                    } else {
                        codigoCidadeAnterior = codigoCidade;
                        cidadeAnterior = nomeMunicipio(Double.parseDouble(codigoCidade)).replace("null", "");
                        gravarArq.append(StringUtils.rightPad(cidadeAnterior, 50, ' '));
                    }
                } else {
                    gravarArq.append(StringUtils.rightPad("", 50, ' '));
                }
                // UF do Tomador
                gravarArq.append(StringUtils.rightPad(infNfse.getTomadorServico().getEndereco().getUf(), 2, ' '));
                // CEP do Tomador
                gravarArq.append(StringUtils.leftPad(infNfse.getTomadorServico().getEndereco().getCep() != null ? infNfse.getTomadorServico().getEndereco().getCep() : "", 8, '0'));
                // Email do Tomador
                gravarArq.append(StringUtils.rightPad(infNfse.getTomadorServico().getContato().getEmail(), 75, ' '));
                // Discriminação dos Serviços
                gravarArq.append(infNfse.getServico().getDiscriminacao().replace('\n', ' ').trim());
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
