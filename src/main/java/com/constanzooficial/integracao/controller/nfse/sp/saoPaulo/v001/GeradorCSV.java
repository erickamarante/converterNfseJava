package com.constanzooficial.integracao.controller.nfse.sp.saoPaulo.v001;

import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelDetalhe;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelNota;
import com.constanzooficial.integracao.util.MyUtils;
import static com.constanzooficial.integracao.util.Reversed.reversed;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
public class GeradorCSV {

    private ModelNota nota;
    public static final int EMITIDA = 0;
    public static final int RECEBIDA = 1;

    public GeradorCSV(ModelNota nota) {
        this.nota = nota;
    }

    public void gerarCsv(String caminhoDestino, int emitidaRecebida) throws FileNotFoundException, IOException {

        if (this.getNota() != null) {
            new File(caminhoDestino).mkdir();
            FileOutputStream fos = new FileOutputStream(caminhoDestino + "/NFSe_" + ((emitidaRecebida == EMITIDA) ? "E_" : "")
                    + ((getNota().getCabecalho().getInscricaoMunicipalContribuinte() == null) ? "" : getNota().getCabecalho().getInscricaoMunicipalContribuinte()
                    + "_") + getNota().getCabecalho().getDataInicioArquivo()[2]
                    + getNota().getCabecalho().getDataInicioArquivo()[1]
                    + getNota().getCabecalho().getDataInicioArquivo()[0] + "_"
                    + getNota().getCabecalho().getDataFimArquivo()[2]
                    + getNota().getCabecalho().getDataFimArquivo()[1]
                    + getNota().getCabecalho().getDataFimArquivo()[0] + ".csv");
            OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
            BufferedWriter gravarArq = new BufferedWriter(osw);

            gravarArq.write('\ufeff');

            // Primeira linha do arquivo
            gravarArq.append("Tipo de Registro").append(";");
            gravarArq.append("Nº NFS-e").append(";");
            gravarArq.append("Data Hora NFE").append(";");
            gravarArq.append("Código de verificação da NFS-e").append(";");
            gravarArq.append("Tipo de RPS").append(";");
            gravarArq.append("Série do RPS").append(";");
            gravarArq.append("Número do RPS").append(";");
            gravarArq.append("Data de Emissão do RPS").append(";");
            gravarArq.append("Inscrição Municipal do Prestador").append(";");
            gravarArq.append("Indicador de CPF/CNPJ do Prestador").append(";");
            gravarArq.append("CPF ou CNPJ do Prestador").append(";");
            gravarArq.append("Razão Social do Prestador").append(";");
            gravarArq.append("Tipo do Endereço do Prestador (Rua, Av, ...)").append(";");
            gravarArq.append("Endereço do Prestador").append(";");
            gravarArq.append("Número do Endereço do Prestador").append(";");
            gravarArq.append("Complemento do Endereço do Prestador").append(";");
            gravarArq.append("Bairro do Prestador").append(";");
            gravarArq.append("Cidade do Prestador").append(";");
            gravarArq.append("UF do Prestador").append(";");
            gravarArq.append("CEP do Prestador").append(";");
            gravarArq.append("E-mail do Prestador").append(";");
            gravarArq.append("Opção Pelo Simples").append(";");
            gravarArq.append("Situação da Nota Fiscal").append(";");
            gravarArq.append("Data de Cancelamento").append(";");
            gravarArq.append("Nº da Guia").append(";");
            gravarArq.append("Data de Quitação da Guia Vinculada a Nota Fiscal").append(";");
            gravarArq.append("Valor dos Serviços").append(";");
            gravarArq.append("Valor das Deduções").append(";");
            gravarArq.append("Código do Serviço Prestado na Nota Fiscal").append(";");
            gravarArq.append("Alíquota").append(";");
            gravarArq.append("Valor do ISS").append(";");
            gravarArq.append("Valor do Crédito").append(";");
            gravarArq.append("ISS Retido").append(";");
            gravarArq.append("Indicador de CPF/CNPJ do Tomador").append(";");
            gravarArq.append("CPF ou CNPJ do Tomador").append(";");
            gravarArq.append("Inscrição Municipal do Tomador").append(";");
            gravarArq.append("Inscrição Estadual do Tomador").append(";");
            gravarArq.append("Razão Social do Tomador").append(";");
            gravarArq.append("Tipo do Endereço do Tomador (Rua, Av, ...)").append(";");
            gravarArq.append("Endereço do Tomador").append(";");
            gravarArq.append("Número do Endereço do Tomador").append(";");
            gravarArq.append("Complemento do Endereço do Tomador").append(";");
            gravarArq.append("Bairro do Tomador").append(";");
            gravarArq.append("Cidade do Tomador").append(";");
            gravarArq.append("UF do Tomador").append(";");
            gravarArq.append("CEP do Tomador").append(";");
            gravarArq.append("Email do Tomador").append(";");
            gravarArq.append("Discriminação dos Serviços").append("\n");

            for (ModelDetalhe detalhe : reversed(getNota().getDetalhe())) {

                // Tipo de Registro
                gravarArq.append(detalhe.getTipoRegistro()).append(";");
                // Nº NF-e
                gravarArq.append(detalhe.getNumeroNfse()).append(";");
                // Data Hora NFE
                String[] dataHora = detalhe.getDataHoraNfse();
                gravarArq.append(dataHora[0] + "/" + dataHora[1] + "/" + dataHora[2] + " " + dataHora[3] + ":" + dataHora[4] + ":" + dataHora[5]).append(";");
                // Código de Verificação da NF-e 
                gravarArq.append(detalhe.getCodigoVerificacaoNfse()).append(";");
                // Tipo de RPS
                gravarArq.append(detalhe.getTipoRps().equals("") ? "RPS" : detalhe.getTipoRps()).append(";");
                // Série do RPS
                gravarArq.append(detalhe.getSerieRps()).append(";");
                // Número do RPS
                gravarArq.append(detalhe.getNumeroRps()).append(";");
                // Data de Emissão do RPS
                if (!detalhe.getDataEmissaoRps()[0].contains(" ")) {
                    dataHora = detalhe.getDataEmissaoRps();
                }
                gravarArq.append(dataHora[0] + "/" + dataHora[1] + "/" + dataHora[2]).append(";");
                try {
                    // Inscrição Municipal do Prestador
                    gravarArq.append(MyUtils.formatarIMSP(detalhe.getInscricaoMunicipalPrestador())).append(";");
                } catch (Exception ex) {
                    gravarArq.append(";");
                }
                // Indicador de CPF/CNPJ do Prestador (1 - CPF; 2 - CNPJ)
                gravarArq.append(detalhe.getIndicadorCpfCnpjPrestador()).append(";");
                // CPF ou CNPJ do Prestador
                switch (detalhe.getIndicadorCpfCnpjPrestador()) {
                    case "1":
                        try {
                            gravarArq.append(MyUtils.formatarCpf(detalhe.getCpfCnpjPrestador()));
                        } catch (Exception ex) {
                        }
                        break;
                    case "2":
                        try {
                            gravarArq.append(MyUtils.formatarCnpj(detalhe.getCpfCnpjPrestador()));
                        } catch (Exception ex) {
                        }
                        break;
                }
                gravarArq.append(";");
                // Razão Social do Prestador
                gravarArq.append(detalhe.getRazaoSocialPrestador()).append(";");
                // Tipo do Endereço do Prestador (Rua, Av, ...)
                gravarArq.append(detalhe.getTipoEnderecoPrestador()).append(";");
                // Endereço do Prestador
                gravarArq.append(detalhe.getEnderecoPrestador()).append(";");
                // Número do Endereço do Prestador
                gravarArq.append(detalhe.getNumeroEnderecoPrestador()).append(";");
                // Complemento do Endereço do Prestador
                gravarArq.append(detalhe.getComplementoEnderecoPrestador()).append(";");
                // Bairro do Prestador
                gravarArq.append(detalhe.getBairroPrestador()).append(";");
                // Cidade do Prestador
                gravarArq.append(detalhe.getCidadePrestador()).append(";");
                // UF do Prestador
                gravarArq.append(detalhe.getUfPrestador()).append(";");
                try {
                    // CEP do Prestador
                    gravarArq.append(MyUtils.formatarCep(detalhe.getCepPrestadorTxt())).append(";");
                } catch (Exception ex) {
                    gravarArq.append(";");
                }
                // E-mail do Prestador
                gravarArq.append(detalhe.getEmailPrestador()).append(";");
                // Opção Pelo Simples
                gravarArq.append(detalhe.getOpcaoPeloSimples()).append(";");
                // Situação da Nota Fiscal
                gravarArq.append(detalhe.getSituacaoNotaFiscal()).append(";");
                // Data de Cancelamento
                if (!detalhe.getDataCancelamento()[0].contains(" ")) {
                    gravarArq.append(detalhe.getDataCancelamento()[0] + "/"
                            + detalhe.getDataCancelamento()[1] + "/"
                            + detalhe.getDataCancelamento()[2]);
                }
                gravarArq.append(";");
                // Nº da Guia
                gravarArq.append(detalhe.getNumeroGuia()).append(";");
                // Data de Quitação da Guia Vinculada a Nota Fiscal
                if (!detalhe.getDataQuitacaoGuiaVinculadaNotaFiscal()[0].contains(" ")) {
                    gravarArq.append(detalhe.getDataQuitacaoGuiaVinculadaNotaFiscal()[0] + "/"
                            + detalhe.getDataQuitacaoGuiaVinculadaNotaFiscal()[1] + "/"
                            + detalhe.getDataQuitacaoGuiaVinculadaNotaFiscal()[2]);
                }
                gravarArq.append(";");
                // Valor dos Serviços
                gravarArq.append(detalhe.getValorServicos().substring(0, detalhe.getValorServicos().length() - 2)).append(',').append(detalhe.getValorServicos().substring(detalhe.getValorServicos().length() - 2)).append(";");
                // Valor das Deduções
                gravarArq.append(detalhe.getValorDeducoes().substring(0, detalhe.getValorDeducoes().length() - 2)).append(',').append(detalhe.getValorDeducoes().substring(detalhe.getValorDeducoes().length() - 2)).append(";");
                // Código do Serviço Prestado na Nota Fiscal
                gravarArq.append(detalhe.getCodigoServicoPrestadoNotaFiscal()).append(";");
                // Alíquota
                gravarArq.append(detalhe.getAliquota().substring(0, detalhe.getAliquota().length() - 2)).append(',').append(detalhe.getAliquota().substring(detalhe.getAliquota().length() - 2)).append(";");
                // Valor do ISS
                gravarArq.append(detalhe.getValorIss().substring(0, detalhe.getValorIss().length() - 2)).append(',').append(detalhe.getValorIss().substring(detalhe.getValorIss().length() - 2)).append(";");
                // Valor do Crédito
                gravarArq.append(detalhe.getValorCredito().substring(0, detalhe.getValorCredito().length() - 2)).append(',').append(detalhe.getValorCredito().substring(detalhe.getValorCredito().length() - 2)).append(";");
                // ISS Retido
                gravarArq.append(detalhe.getIssRetido()).append(";");
                // Indicador de CPF/CNPJ do Tomador
                gravarArq.append(detalhe.getIndicadorCpfCnpjTomador()).append(";");
                // CNPJ do Tomador
                switch (detalhe.getIndicadorCpfCnpjTomador()) {
                    case "1":
                        try {
                            gravarArq.append(MyUtils.formatarCpf(detalhe.getCpfCnpjTomador()));
                        } catch (Exception ex) {
                        }
                        break;
                    case "2":
                        try {
                            gravarArq.append(MyUtils.formatarCnpj(detalhe.getCpfCnpjTomador()));
                        } catch (Exception ex) {
                        }
                        break;
                }
                gravarArq.append(";");
                try {
                    // Inscrição Municipal do Tomador
                    gravarArq.append(MyUtils.formatarIMSP(detalhe.getInscricaoMunicipalTomador())).append(";");
                } catch (Exception ex) {
                    gravarArq.append(";");
                }
                // Inscrição Estadual do Tomador
                gravarArq.append(detalhe.getInscricaoEstadualTomador()).append(";");
                // Razão Social do Tomador
                gravarArq.append(detalhe.getRazaoSocialTomador()).append(";");
                // Tipo do Endereço do Tomador (Rua, Av, ...)
                gravarArq.append(detalhe.getTipoEnderecoTomador()).append(";");
                // Endereço do Tomador
                gravarArq.append(detalhe.getEnderecoTomador()).append(";");
                // Número do Endereço do Tomador
                gravarArq.append(detalhe.getNumeroEnderecoTomador()).append(";");
                // Complemento do Endereço do Tomador
                gravarArq.append(detalhe.getComplementoEnderecoTomador()).append(";");
                // Bairro do Tomador
                gravarArq.append(detalhe.getBairroTomador()).append(";");
                // Cidade do Tomador
                gravarArq.append(detalhe.getCidadeTomador()).append(";");
                // UF do Tomador
                gravarArq.append(detalhe.getUfTomador()).append(";");
                try {
                    // CEP do Tomador
                    gravarArq.append(MyUtils.formatarCep(detalhe.getCepTomadorTxt())).append(";");
                } catch (Exception ex) {
                    gravarArq.append(";");
                }
                // Email do Tomador
                gravarArq.append(detalhe.getEmailTomador()).append(";");
                // Discriminação dos Serviços
                gravarArq.append(detalhe.getDiscriminacaoServicos());
                // Caractere de Fim de Linha
                gravarArq.append("\n");
            }

            // Última linha do arquivo
            gravarArq.append("Total").append(";");
            gravarArq.append(getNota().getRodape().getNumeroLinhasDetalhe()).append(";");
            for (int i = 0; i < 24; i++) {
                gravarArq.append(";");
            }
            gravarArq.append(getNota().getRodape().getValorTotalServicos().substring(0, getNota().getRodape().getValorTotalServicos().length() - 2)).append(',').append(getNota().getRodape().getValorTotalServicos().substring(getNota().getRodape().getValorTotalServicos().length() - 2)).append(";");
            gravarArq.append(getNota().getRodape().getValorTotalDeducoes().substring(0, getNota().getRodape().getValorTotalDeducoes().length() - 2)).append(',').append(getNota().getRodape().getValorTotalDeducoes().substring(getNota().getRodape().getValorTotalDeducoes().length() - 2)).append(";");
            gravarArq.append(";");
            gravarArq.append(";");
            gravarArq.append(getNota().getRodape().getValorTotalIss().substring(0, getNota().getRodape().getValorTotalIss().length() - 2)).append(',').append(getNota().getRodape().getValorTotalIss().substring(getNota().getRodape().getValorTotalIss().length() - 2)).append(";");
            gravarArq.append(getNota().getRodape().getValorTotalCreditos().substring(0, getNota().getRodape().getValorTotalCreditos().length() - 2)).append(',').append(getNota().getRodape().getValorTotalCreditos().substring(getNota().getRodape().getValorTotalCreditos().length() - 2)).append(";");
            for (int i = 0; i < 15; i++) {
                gravarArq.append(";");
            }
            gravarArq.append("\n");

            gravarArq.close();
        }
    }

    public ModelNota getNota() {
        return nota;
    }

    public void setNota(ModelNota nota) {
        this.nota = nota;
    }
}
