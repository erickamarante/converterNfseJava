package com.constanzooficial.integracao.controller.nfse.ba.irece;

import com.constanzooficial.integracao.model.nfse.ba.irece.DsExportarNotaFiscal;
import com.constanzooficial.integracao.model.nfse.ba.irece.TbNotasFiscais;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelCabecalho;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelDetalhe;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelDetalheComparator;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelNota;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelRodape;
import com.constanzooficial.integracao.util.MyUtils;
import com.constanzooficial.integracao.util.UtilCidades;
import com.constanzooficial.integracao.util.UtilFile;
import com.thoughtworks.xstream.XStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Waislan Luis Sanches
 */
public class ControllerLeitor {

    public ModelNota lerNotas(File[] arquivos, boolean considerarIss, String cnpjPrestador) throws IOException, Exception {

        ArrayList<TbNotasFiscais> notas = lerXMLs(arquivos);

        double valorTotalServicos = 0;
        double valorTotalDeducoes = 0;
        double valorTotalIss = 0;
        double valorTotalCredito = 0;

        ArrayList<ModelDetalhe> detalhes = new ArrayList<>();

        for (TbNotasFiscais c : notas) {
            ModelDetalhe d = new ModelDetalhe();

            d.setNumeroNfse(c.getNumeroNF());

            d.setDataHoraNfse(c.getDataEmissao());

            d.setDataEmissaoRps(c.getDataEmissao());

            //d.setInscricaoMunicipalPrestador(c.ge);
            
            d.setIndicadorCpfCnpjPrestador("2");
            d.setCpfCnpjPrestador(cnpjPrestador);
            
            //d.setRazaoSocialPrestador(c.getNfse().getInfNfse().getPrestadorServico().getRazaoSocial());
            /*
            d.setEnderecoPrestador(c.getNfse().getInfNfse().getPrestadorServico().getEndereco().getEndereco());
            
            d.setNumeroEnderecoPrestador(c.getNfse().getInfNfse().getPrestadorServico().getEndereco().getNumero());

            d.setComplementoEnderecoPrestador(c.getNfse().getInfNfse().getPrestadorServico().getEndereco().getComplemento());

            d.setBairroPrestador(c.getNfse().getInfNfse().getPrestadorServico().getEndereco().getBairro());
            */
            d.setCidadePrestador("Irece");

            d.setUfPrestador("BA");
            /*
            d.setCepPrestador(c.getNfse().getInfNfse().getPrestadorServico().getEndereco().getCep());

            d.setEmailPrestador(c.getNfse().getInfNfse().getPrestadorServico().getContato().getEmail());
            */
            /*
            if (c.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getOptanteSimplesNacional().equals("1")) {
                d.setOpcaoPeloSimples("4");
            } else {
                d.setOpcaoPeloSimples("0");
            }
            */
            d.setOpcaoPeloSimples("4");
            /*
            if (c.getNfseCancelamento() != null) {
                d.setSituacaoNotaFiscal("C");
                d.setDataCancelamento(c.getNfseCancelamento().getConfirmacao().getDataHora());
            }
            
            if (!n.getSituacao().equals("Emitida") && !n.getSituacao().equals("Cancelada")){
                throw new Exception("Favor contatar o administrador.");
            }
            
            if (c.getNfse().getInfNfse().getNfseSubstituida().equals("1")) {
                d.setSituacaoNotaFiscal("S");
            }
            */
            double valorServico = Double.valueOf(c.getValorTotal());
            d.setValorServicos(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorServico));
            /*
            if (c.getNfseCancelamento() == null && !d.getSituacaoNotaFiscal().equals("S")) {
                valorTotalServicos += valorServico;
            }
            */
            valorTotalServicos += valorServico;
            
            double valorDeducoes = Double.valueOf(c.getValorDeducao());
            d.setValorDeducoes(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorDeducoes));
            valorTotalDeducoes += valorDeducoes;
            /*
            double valorDeducoes = Double.valueOf(n.getValorTotalDeducoes());
            d.setValorDeducoes(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorDeducoes));
            if (!d.getSituacaoNotaFiscal().equals("C") && !d.getSituacaoNotaFiscal().equals("S")) {
                valorTotalDeducoes += valorDeducoes;
            }
            */
            //d.setCodigoServicoPrestadoNotaFiscal(c.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getServico().getCodigoCnae());

            double valorIss = 0;
            /*
            if (considerarIss) {
                double aliquota = Double.valueOf(c.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getServico().getValores().getAliquota());
                d.setAliquota(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(aliquota));
                valorIss = aliquota * valorServico;
                d.setValorIss(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorIss));
            } else {
                d.setAliquota(MyUtils.doubleParaStringSemPontoCom2CasasDecimais("0"));
                d.setValorIss(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorIss));
            }
            /*
            if (c.getNfseCancelamento() == null && !d.getSituacaoNotaFiscal().equals("S")) {
                valorTotalIss += valorIss;
            }
            */
            valorTotalIss += valorIss;
            /*
            if (Double.valueOf(c.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getServico().getIssRetido()) != 0) {
                d.setIssRetido("S");
            } else {
                d.setIssRetido("N");
            }
            */
            if (c.getCnpjCpfTomador().replaceAll("[^0-9]", "").length() == 11) {
                d.setIndicadorCpfCnpjTomador("1");
                d.setCpfCnpjTomador(c.getCnpjCpfTomador());
            } else {
                d.setIndicadorCpfCnpjTomador("2");
                d.setCpfCnpjTomador(c.getCnpjCpfTomador());
            }
            
            //d.setInscricaoMunicipalTomador(c.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getIdentificacaoTomador().getInscricaoMunicipal());
            
            d.setRazaoSocialTomador(c.getNomeRazaoTomador());
            /*
            d.setEnderecoTomador(c.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getEndereco().getEndereco());

            d.setNumeroEnderecoTomador(c.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getEndereco().getNumero());

            d.setComplementoEnderecoTomador(c.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getEndereco().getComplemento());

            d.setBairroTomador(c.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getEndereco().getBairro());
            */
            d.setCidadeTomador(c.getMunicipioTomador());

            //d.setUfTomador("BA");
            /*
            d.setCepTomador(c.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getEndereco().getCep());

            d.setEmailTomador(c.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getContato().getEmail());
            
            d.setDiscriminacaoServicos(c.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getServico().getDiscriminacao());
            */
            detalhes.add(d);

        }

        Collections.sort(detalhes, new ModelDetalheComparator());

        ModelCabecalho cabecalho = new ModelCabecalho();
        cabecalho.setDataInicioArquivo(detalhes.get(0).getDataHoraNfse());
        cabecalho.setDataFimArquivo(detalhes.get(detalhes.size() - 1).getDataHoraNfse());
        cabecalho.setInscricaoMunicipalContribuinte(detalhes.get(0).getInscricaoMunicipalPrestadorTxt());

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

        FileUtils.deleteDirectory(new File("tmp"));
        return nota;
    }

    public ArrayList<TbNotasFiscais> lerXMLs(File[] xmls) throws IOException {
        ArrayList<TbNotasFiscais> retorno = new ArrayList<>();

        for (File f : xmls) {
            System.out.println(f.getName());
            String xml = UtilFile.fileToStringInline(new File(f.getAbsolutePath()));

            XStream xstream = new XStream();
            xstream.autodetectAnnotations(true);

            InputStream is = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));

            xstream.alias("DsExportarNotaFiscal", DsExportarNotaFiscal.class);

            DsExportarNotaFiscal dsExportarNotaFiscal = (DsExportarNotaFiscal) xstream.fromXML(is);

            retorno.addAll(dsExportarNotaFiscal.getTbNotasFiscais());
        }
        return retorno;
    }
}
