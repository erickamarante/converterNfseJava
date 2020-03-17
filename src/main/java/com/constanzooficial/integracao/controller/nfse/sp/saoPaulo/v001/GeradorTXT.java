package com.constanzooficial.integracao.controller.nfse.sp.saoPaulo.v001;

import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelDetalhe;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelNota;
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
public class GeradorTXT {

    private ModelNota nota;
    public static final int EMITIDA = 0;
    public static final int RECEBIDA = 1;

    public GeradorTXT(ModelNota nota) {

        this.nota = nota;
    }

    public void gerarTxt(String caminhoDestino, int emitidaRecebida) throws FileNotFoundException, IOException {

        System.setProperty("file.encoding", "UTF-8");

        if (this.getNota() != null) {
            new File(caminhoDestino).mkdir();
            FileOutputStream fos = new FileOutputStream(caminhoDestino + "/NFSe_" + ((emitidaRecebida == EMITIDA) ? "E_" : "")
                    + ((getNota().getCabecalho().getInscricaoMunicipalContribuinte() == null) ? "" : getNota().getCabecalho().getInscricaoMunicipalContribuinte()
                    + "_") + getNota().getCabecalho().getDataInicioArquivo()[2]
                    + getNota().getCabecalho().getDataInicioArquivo()[1]
                    + getNota().getCabecalho().getDataInicioArquivo()[0] + "_"
                    + getNota().getCabecalho().getDataFimArquivo()[2]
                    + getNota().getCabecalho().getDataFimArquivo()[1]
                    + getNota().getCabecalho().getDataFimArquivo()[0] + ".txt");
            try (OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8)) {
                BufferedWriter gravarArq = new BufferedWriter(osw);

                // Registro Tipo 1 - Cabeçalho
                gravarArq.append(getNota().getCabecalho().getTipoRegistro());
                // Versão do Arquivo
                gravarArq.append(getNota().getCabecalho().getVersaoArquivo());
                // Inscrição Municipal do Contribuinte
                gravarArq.append(getNota().getCabecalho().getInscricaoMunicipalContribuinte());
                // Data de Início do Período Transferido no Arquivo
                gravarArq.append(getNota().getCabecalho().getDataInicioArquivo()[2]
                        + getNota().getCabecalho().getDataInicioArquivo()[1]
                        + getNota().getCabecalho().getDataInicioArquivo()[0]);
                // Data de Fim do Período Transferido no Arquivo
                gravarArq.append(getNota().getCabecalho().getDataFimArquivo()[2]
                        + getNota().getCabecalho().getDataFimArquivo()[1]
                        + getNota().getCabecalho().getDataFimArquivo()[0]);
                // Caractere de Fim de Linha
                gravarArq.append("\n");

                for (ModelDetalhe detalhe : reversed(getNota().getDetalhe())) {

                    // Registro Tipo 2 - Detalhe
                    gravarArq.append(detalhe.getTipoRegistroTxt());
                    // Nº NF-e
                    gravarArq.append(detalhe.getNumeroNfseTxt());
                    // Data Hora NFE
                    String[] dataHora = detalhe.getDataHoraNfse();
                    gravarArq.append(dataHora[2] + dataHora[1] + dataHora[0] + dataHora[3] + dataHora[4] + dataHora[5]);
                    // Código de Verificação da NF-e 
                    gravarArq.append(detalhe.getCodigoVerificacaoNfseTxt());
                    // Tipo de RPS
                    gravarArq.append(detalhe.getTipoRpsTxt());
                    // Série do RPS
                    gravarArq.append(detalhe.getSerieRpsTxt());
                    // Número do RPS
                    gravarArq.append(detalhe.getNumeroRpsTxt());
                    // Data de Emissão do RPS
                    if (!detalhe.getDataEmissaoRps()[0].contains(" ")) {
                        dataHora = detalhe.getDataEmissaoRps();
                    }
                    gravarArq.append(dataHora[2] + dataHora[1] + dataHora[0]);
                    // Inscrição Municipal do Prestador
                    gravarArq.append(detalhe.getInscricaoMunicipalPrestadorTxt());
                    // Indicador de CPF/CNPJ do Prestador (1 - CPF; 2 - CNPJ)
                    gravarArq.append(detalhe.getIndicadorCpfCnpjPrestadorTxt());
                    // CPF ou CNPJ do Prestador
                    gravarArq.append(detalhe.getCpfCnpjPrestadorTxt());
                    // Razão Social do Prestador
                    gravarArq.append(detalhe.getRazaoSocialPrestadorTxt());
                    // Tipo do Endereço do Prestador (Rua, Av, ...)
                    gravarArq.append(detalhe.getTipoEnderecoPrestadorTxt());
                    // Endereço do Prestador
                    gravarArq.append(detalhe.getEnderecoPrestadorTxt());
                    // Número do Endereço do Prestador
                    gravarArq.append(detalhe.getNumeroEnderecoPrestadorTxt());
                    // Complemento do Endereço do Prestador
                    gravarArq.append(detalhe.getComplementoEnderecoPrestadorTxt());
                    // Bairro do Prestador
                    gravarArq.append(detalhe.getBairroPrestadorTxt());
                    // Cidade do Prestador
                    gravarArq.append(detalhe.getCidadePrestadorTxt());
                    // UF do Prestador
                    gravarArq.append(detalhe.getUfPrestadorTxt());
                    // CEP do Prestador
                    gravarArq.append(detalhe.getCepPrestadorTxt());
                    // E-mail do Prestador
                    gravarArq.append(detalhe.getEmailPrestadorTxt());
                    // Opção Pelo Simples
                    gravarArq.append(detalhe.getOpcaoPeloSimplesTxt());
                    // Situação da Nota Fiscal
                    gravarArq.append(detalhe.getSituacaoNotaFiscalTxt());
                    // Data de Cancelamento
                    gravarArq.append(detalhe.getDataCancelamento()[2]
                            + detalhe.getDataCancelamento()[1]
                            + detalhe.getDataCancelamento()[0]);
                    // Nº da Guia
                    gravarArq.append(detalhe.getNumeroGuiaTxt());
                    // Data de Quitação da Guia Vinculada a Nota Fiscal
                    gravarArq.append(detalhe.getDataQuitacaoGuiaVinculadaNotaFiscal()[2]
                            + detalhe.getDataQuitacaoGuiaVinculadaNotaFiscal()[1]
                            + detalhe.getDataQuitacaoGuiaVinculadaNotaFiscal()[0]);
                    // Valor dos Serviços
                    gravarArq.append(detalhe.getValorServicosTxt());
                    // Valor das Deduções
                    gravarArq.append(detalhe.getValorDeducoesTxt());
                    // Código do Serviço Prestado na Nota Fiscal
                    gravarArq.append(detalhe.getCodigoServicoPrestadoNotaFiscalTxt());
                    // Alíquota
                    gravarArq.append(detalhe.getAliquotaTxt());
                    // Valor do ISS
                    gravarArq.append(detalhe.getValorIssTxt());
                    // Valor do Crédito
                    gravarArq.append(detalhe.getValorCreditoTxt());
                    // ISS Retido
                    gravarArq.append(detalhe.getIssRetidoTxt());
                    // Indicador de CPF/CNPJ do Tomador
                    gravarArq.append(detalhe.getIndicadorCpfCnpjTomadorTxt());
                    // CNPJ do Tomador
                    gravarArq.append(detalhe.getCpfCnpjTomadorTxt());
                    // Inscrição Municipal do Tomador
                    gravarArq.append(detalhe.getInscricaoMunicipalTomadorTxt());
                    // Inscrição Estadual do Tomador
                    gravarArq.append(detalhe.getInscricaoEstadualTomadorTxt());
                    // Razão Social do Tomador
                    gravarArq.append(detalhe.getRazaoSocialTomadorTxt());
                    // Tipo do Endereço do Tomador (Rua, Av, ...)
                    gravarArq.append(detalhe.getTipoEnderecoTomadorTxt());
                    // Endereço do Tomador
                    gravarArq.append(detalhe.getEnderecoTomadorTxt());
                    // Número do Endereço do Tomador
                    gravarArq.append(detalhe.getNumeroEnderecoTomadorTxt());
                    // Complemento do Endereço do Tomador
                    gravarArq.append(detalhe.getComplementoEnderecoTomadorTxt());
                    // Bairro do Tomador
                    gravarArq.append(detalhe.getBairroTomadorTxt());
                    // Cidade do Tomador
                    gravarArq.append(detalhe.getCidadeTomadorTxt());
                    // UF do Tomador
                    gravarArq.append(detalhe.getUfTomadorTxt());
                    // CEP do Tomador
                    gravarArq.append(detalhe.getCepTomadorTxt());
                    // Email do Tomador
                    gravarArq.append(detalhe.getEmailTomadorTxt());
                    // Discriminação dos Serviços
                    gravarArq.append(detalhe.getDiscriminacaoServicos());
                    // Caractere de Fim de Linha
                    gravarArq.append("\n");
                }

                // Registro Tipo 9 - Rodapé
                gravarArq.append(getNota().getRodape().getTipoRegistro());
                // Número de linhas de detalhe do arquivo
                gravarArq.append(getNota().getRodape().getNumeroLinhasDetalhe());
                // Valor total dos serviços contido no arquivo
                gravarArq.append(getNota().getRodape().getValorTotalServicos());
                // Valor total das deduções contidas no arquivo
                gravarArq.append(getNota().getRodape().getValorTotalDeducoes());
                // Valor total do ISS
                gravarArq.append(getNota().getRodape().getValorTotalIss());
                // Valor total dos Créditos
                gravarArq.append(getNota().getRodape().getValorTotalCreditos());
                // Caractere de Fim de Linha
                gravarArq.append("\n");

                gravarArq.close();
            }
        }
    }

    public ModelNota getNota() {
        return nota;
    }

    public void setNota(ModelNota nota) {
        this.nota = nota;
    }
}
