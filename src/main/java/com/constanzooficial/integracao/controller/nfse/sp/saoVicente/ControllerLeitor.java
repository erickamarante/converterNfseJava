package com.constanzooficial.integracao.controller.nfse.sp.saoVicente;

import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelCabecalho;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelDetalhe;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelDetalheComparator;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelNota;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelRodape;
import com.constanzooficial.integracao.model.nfse.sp.saoVicente.CompNfse;
import com.constanzooficial.integracao.model.nfse.sp.saoVicente.ConsultarNfseRpsResposta;
import com.constanzooficial.integracao.model.nfse.sp.saoVicente.TcInfNfse;
import com.constanzooficial.integracao.util.MyUtils;
import com.constanzooficial.integracao.util.UtilCidades;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
public class ControllerLeitor {

    /**
     *
     * @param selectedFiles
     * @param emitidaRecebida 0 para emitida e 1 para recebida
     * @return
     * @throws IOException
     */
    public ModelNota lerNotas(File[] selectedFiles, int emitidaRecebida, boolean considerarIss) throws IOException {

        ArrayList<ModelDetalhe> detalhes = new ArrayList<>();

        double valorTotalServicos = 0;
        double valorTotalDeducoes = 0;
        double valorTotalIss = 0;
        double valorTotalCredito = 0;

        for (CompNfse compNfse : lerXMLs(selectedFiles)) {

            TcInfNfse infNfse = compNfse.getTcNfse().getTcInfNfse();

            ModelDetalhe d = new ModelDetalhe();
            d.setNumeroNfse(infNfse.getTcNumero());
            d.setDataHoraNfse(MyUtils.trataDataHora2(infNfse.getTcDataEmissao()));
            d.setDataEmissaoRps(MyUtils.trataData2(infNfse.getTcDataEmissao()));
            d.setInscricaoMunicipalPrestador(infNfse.getTcPrestadorServico().getTcIdentificacaoPrestador().getTcInscricaoMunicipal());
            d.setIndicadorCpfCnpjPrestador(infNfse.getTcPrestadorServico().getTcIdentificacaoPrestador().getTcCpfCnpj().getTcCpf() != null ? "1" : "2");
            d.setCpfCnpjPrestador(d.getIndicadorCpfCnpjPrestadorTxt().equals("1")
                    ? infNfse.getTcPrestadorServico().getTcIdentificacaoPrestador().getTcCpfCnpj().getTcCpf()
                    : infNfse.getTcPrestadorServico().getTcIdentificacaoPrestador().getTcCpfCnpj().getTcCnpj());
            d.setRazaoSocialPrestador(infNfse.getTcPrestadorServico().getTcRazaoSocial());

            if (infNfse.getTcPrestadorServico().getTcEndereco() != null) {
                String[] tipoEEndereco = MyUtils.separaTipoEndereco(infNfse.getTcPrestadorServico().getTcEndereco().getTcEndereco());
                d.setTipoEnderecoPrestador(tipoEEndereco[0]);
                d.setEnderecoPrestador(tipoEEndereco[1]);
                d.setNumeroEnderecoPrestador(infNfse.getTcPrestadorServico().getTcEndereco().getTcNumero());
                d.setComplementoEnderecoPrestador(infNfse.getTcPrestadorServico().getTcEndereco().getTcComplemento());
                d.setBairroPrestador(infNfse.getTcPrestadorServico().getTcEndereco().getTcBairro());
                d.setCidadePrestador(UtilCidades.nomeCidade(infNfse.getTcPrestadorServico().getTcEndereco().getTcCidade()));
                d.setUfPrestador(infNfse.getTcPrestadorServico().getTcEndereco().getTcEstado());
                d.setCepPrestador(infNfse.getTcPrestadorServico().getTcEndereco().getTcCep());
            }

            if (infNfse.getTcPrestadorServico().getTcContato() != null) {
                d.setEmailPrestador(infNfse.getTcPrestadorServico().getTcContato().getTcEmail());
            }

            d.setOpcaoPeloSimples(infNfse.getTcOptanteSimplesNacional().equals("1") ? "4" : "0");

            d.setSituacaoNotaFiscal(compNfse.getNfseCancelamento() != null ? "C" : null);

            if (compNfse.getNfseCancelamento() != null) {
                d.setDataCancelamento(compNfse.getNfseCancelamento().getConfirmacao().getInfConfirmacaoCancelamento().getDataHora());
            }

            double valorServicos = Double.parseDouble(infNfse.getTcServico().getTcValores().getTcValorServicos());
            d.setValorServicos(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorServicos));
            valorTotalServicos += valorServicos;

            double valorDeducoes = 0;
            if (considerarIss) {
                valorDeducoes = Double.parseDouble(infNfse.getTcServico().getTcValores().getTcValorDeducoes());
                valorTotalDeducoes += valorDeducoes;
            }
            d.setValorDeducoes(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorDeducoes));

            d.setCodigoServicoPrestadoNotaFiscal(infNfse.getTcServico().getTcCodigoCnae());

            double aliquota = 0;
            if (considerarIss) {
                aliquota = Double.parseDouble(infNfse.getTcServico().getTcValores().getTcAliquota());
            }
            d.setAliquota(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(aliquota));

            double valorIss = 0;
            if (considerarIss) {
                valorIss = Double.parseDouble(infNfse.getTcServico().getTcValores().getTcValorIss());
                valorTotalIss += valorIss;
            }
            d.setValorIss(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorIss));

            double valorCredito = Double.parseDouble(infNfse.getTcValorCredito());
            d.setValorCredito(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorCredito));
            valorTotalCredito += valorCredito;

            d.setIssRetido(infNfse.getTcServico().getTcValores().getTcIssRetido().equals("1") ? "S" : "N");

            if (infNfse.getTcTomadorServico().getTcIdentificacaoTomador() != null) {
                d.setInscricaoMunicipalTomador(infNfse.getTcTomadorServico().getTcIdentificacaoTomador().getTcInscricaoMunicipal());
            }
            if (infNfse.getTcTomadorServico().getTcIdentificacaoTomador() == null
                    || infNfse.getTcTomadorServico().getTcIdentificacaoTomador().getTcCpfCnpj() == null) {
                d.setIndicadorCpfCnpjTomador("3");
            } else if (infNfse.getTcTomadorServico().getTcIdentificacaoTomador().getTcCpfCnpj().getTcCpf() != null) {
                d.setIndicadorCpfCnpjTomador("1");
                d.setCpfCnpjTomador(infNfse.getTcTomadorServico().getTcIdentificacaoTomador().getTcCpfCnpj().getTcCpf());
            } else {
                d.setIndicadorCpfCnpjTomador("2");
                d.setCpfCnpjTomador(infNfse.getTcTomadorServico().getTcIdentificacaoTomador().getTcCpfCnpj().getTcCnpj());
            }

            d.setRazaoSocialTomador(infNfse.getTcTomadorServico().getTcRazaoSocial());
            if (infNfse.getTcTomadorServico().getTcEndereco() != null) {
                String[] tipoEEndereco = MyUtils.separaTipoEndereco(infNfse.getTcTomadorServico().getTcEndereco().getTcEndereco());
                d.setTipoEnderecoTomador(tipoEEndereco[0]);
                d.setEnderecoTomador(tipoEEndereco[1]);
                d.setNumeroEnderecoTomador(infNfse.getTcTomadorServico().getTcEndereco().getTcNumero());
                d.setComplementoEnderecoTomador(infNfse.getTcTomadorServico().getTcEndereco().getTcComplemento());
                d.setBairroTomador(infNfse.getTcTomadorServico().getTcEndereco().getTcBairro());
                if (infNfse.getTcTomadorServico().getTcEndereco().getTcCidade() != null) {
                    d.setCidadeTomador(UtilCidades.nomeCidade(infNfse.getTcTomadorServico().getTcEndereco().getTcCidade()));
                }
                d.setUfTomador(infNfse.getTcTomadorServico().getTcEndereco().getTcEstado());
                d.setCepTomador(infNfse.getTcTomadorServico().getTcEndereco().getTcCep());
            }

            if (infNfse.getTcTomadorServico().getTcContato() != null) {
                d.setEmailTomador(infNfse.getTcTomadorServico().getTcContato().getTcEmail());
            }

            d.setDiscriminacaoServicos(infNfse.getTcServico().getTcDiscriminacao().replaceAll("\n", " "));

            detalhes.add(d);
        }

        Collections.sort(detalhes, new ModelDetalheComparator());

        ModelCabecalho cabecalho = new ModelCabecalho();
        cabecalho.setDataInicioArquivo(detalhes.get(0).getDataHoraNfse());
        cabecalho.setDataFimArquivo(detalhes.get(detalhes.size() - 1).getDataHoraNfse());
        cabecalho.setInscricaoMunicipalContribuinte(emitidaRecebida == 0 ? detalhes.get(0).getInscricaoMunicipalPrestadorTxt() : detalhes.get(0).getInscricaoMunicipalTomadorTxt());

        ModelRodape rodape = new ModelRodape();
        rodape.setNumeroLinhasDetalhe(Integer.toString(detalhes.size()));
        rodape.setValorTotalServicos(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorTotalServicos));
        rodape.setValorTotalIss(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorTotalIss));
        rodape.setValorTotalDeducoes(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorTotalDeducoes));
        rodape.setValorTotalCreditos(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorTotalCredito));

        ModelNota nota = new ModelNota();
        nota.setCabecalho(cabecalho);
        nota.setDetalhe(detalhes);
        nota.setRodape(rodape);

        System.out.println("Valor total dos serviços: " + valorTotalServicos);
        return nota;

    }

    private ArrayList<CompNfse> lerXMLs(File[] files) throws IOException {

        ArrayList<CompNfse> retorno = new ArrayList<>();

        for (File file : files) {

            if (file.isDirectory() || !file.getName().endsWith(".xml")) {
                continue;
            }
            System.out.println(file.getName());
            XStream xstream = new XStream();
            xstream.autodetectAnnotations(true);
            try (InputStream is = new FileInputStream(file)) {
                xstream.alias("ConsultarNfseRpsResposta", ConsultarNfseRpsResposta.class);
                ConsultarNfseRpsResposta nfse = (ConsultarNfseRpsResposta) xstream.fromXML(is);
                retorno.add(nfse.getCompNfse());
            }
        }
        return retorno;
    }
}
