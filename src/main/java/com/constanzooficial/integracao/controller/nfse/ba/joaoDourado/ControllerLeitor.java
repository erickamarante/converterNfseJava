package com.constanzooficial.integracao.controller.nfse.ba.joaoDourado;

import com.constanzooficial.integracao.model.nfse.ba.joaoDourado.CompNfse;
import com.constanzooficial.integracao.model.nfse.ba.joaoDourado.ConsultarNfseFaixaResposta;
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

    public ModelNota lerNotas(File[] arquivos, boolean considerarIss) throws IOException, Exception {

        ArrayList<CompNfse> notas = lerXMLs(arquivos);

        double valorTotalServicos = 0;
        double valorTotalDeducoes = 0;
        double valorTotalIss = 0;
        double valorTotalCredito = 0;

        ArrayList<ModelDetalhe> detalhes = new ArrayList<>();

        for (CompNfse c : notas) {
            ModelDetalhe d = new ModelDetalhe();

            d.setNumeroNfse(c.getNfse().getInfNfse().getNumero());

            d.setDataHoraNfse(c.getNfse().getInfNfse().getDataEmissao());

            d.setDataEmissaoRps(c.getNfse().getInfNfse().getDataEmissao());

            d.setInscricaoMunicipalPrestador(c.getNfse().getInfNfse().getPrestadorServico().getIdentificacaoPrestador().getInscricaoMunicipal());
            
            if (c.getNfse().getInfNfse().getPrestadorServico().getIdentificacaoPrestador().getCpfCnpj().getCnpj() == null) {
                d.setIndicadorCpfCnpjPrestador("1");
                d.setCpfCnpjPrestador(c.getNfse().getInfNfse().getPrestadorServico().getIdentificacaoPrestador().getCpfCnpj().getCpf());
            } else {
                d.setIndicadorCpfCnpjPrestador("2");
                d.setCpfCnpjPrestador(c.getNfse().getInfNfse().getPrestadorServico().getIdentificacaoPrestador().getCpfCnpj().getCnpj());
            }
            
            d.setRazaoSocialPrestador(c.getNfse().getInfNfse().getPrestadorServico().getRazaoSocial());
            
            d.setEnderecoPrestador(c.getNfse().getInfNfse().getPrestadorServico().getEndereco().getEndereco());
            
            d.setNumeroEnderecoPrestador(c.getNfse().getInfNfse().getPrestadorServico().getEndereco().getNumero());

            d.setComplementoEnderecoPrestador(c.getNfse().getInfNfse().getPrestadorServico().getEndereco().getComplemento());

            d.setBairroPrestador(c.getNfse().getInfNfse().getPrestadorServico().getEndereco().getBairro());

            d.setCidadePrestador(UtilCidades.nomeCidade(c.getNfse().getInfNfse().getPrestadorServico().getEndereco().getCodigoMunicipio()));

            d.setUfPrestador(c.getNfse().getInfNfse().getPrestadorServico().getEndereco().getUf());

            d.setCepPrestador(c.getNfse().getInfNfse().getPrestadorServico().getEndereco().getCep());

            d.setEmailPrestador(c.getNfse().getInfNfse().getPrestadorServico().getContato().getEmail());

            if (c.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getOptanteSimplesNacional().equals("1")) {
                d.setOpcaoPeloSimples("4");
            } else {
                d.setOpcaoPeloSimples("0");
            }
            /*
            if (c.getNfseCancelamento() != null) {
                d.setSituacaoNotaFiscal("C");
                d.setDataCancelamento(c.getNfseCancelamento().getConfirmacao().getDataHora());
            }
            
            if (!n.getSituacao().equals("Emitida") && !n.getSituacao().equals("Cancelada")){
                throw new Exception("Favor contatar o administrador.");
            }
            */
            if (c.getNfse().getInfNfse().getNfseSubstituida().equals("1")) {
                d.setSituacaoNotaFiscal("S");
            }
            
            double valorServico = Double.valueOf(c.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getServico().getValores().getValorServicos());
            d.setValorServicos(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorServico));
            /*
            if (c.getNfseCancelamento() == null && !d.getSituacaoNotaFiscal().equals("S")) {
                valorTotalServicos += valorServico;
            }
            */
            valorTotalServicos += valorServico;
            
            double valorDeducoes = Double.valueOf(c.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getServico().getValores().getValorDeducoes());
            d.setValorDeducoes(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorDeducoes));
            valorTotalDeducoes += valorDeducoes;
            /*
            double valorDeducoes = Double.valueOf(n.getValorTotalDeducoes());
            d.setValorDeducoes(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorDeducoes));
            if (!d.getSituacaoNotaFiscal().equals("C") && !d.getSituacaoNotaFiscal().equals("S")) {
                valorTotalDeducoes += valorDeducoes;
            }
            */
            d.setCodigoServicoPrestadoNotaFiscal(c.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getServico().getCodigoCnae());

            double valorIss = 0;

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

            if (Double.valueOf(c.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getServico().getIssRetido()) != 0) {
                d.setIssRetido("S");
            } else {
                d.setIssRetido("N");
            }

            if (c.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getIdentificacaoTomador().getCpfCnpj().getCpf() != null) {
                d.setIndicadorCpfCnpjTomador("1");
                d.setCpfCnpjTomador(c.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getIdentificacaoTomador().getCpfCnpj().getCpf());
            } else {
                d.setIndicadorCpfCnpjTomador("2");
                d.setCpfCnpjTomador(c.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getIdentificacaoTomador().getCpfCnpj().getCnpj());
            }
            
            d.setInscricaoMunicipalTomador(c.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getIdentificacaoTomador().getInscricaoMunicipal());
            
            d.setRazaoSocialTomador(c.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getRazaoSocial());

            d.setEnderecoTomador(c.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getEndereco().getEndereco());

            d.setNumeroEnderecoTomador(c.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getEndereco().getNumero());

            d.setComplementoEnderecoTomador(c.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getEndereco().getComplemento());

            d.setBairroTomador(c.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getEndereco().getBairro());

            d.setCidadeTomador(UtilCidades.nomeCidade(c.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getEndereco().getCodigoMunicipio()));

            d.setUfTomador(c.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getEndereco().getUf());

            d.setCepTomador(c.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getEndereco().getCep());

            d.setEmailTomador(c.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getContato().getEmail());
            
            d.setDiscriminacaoServicos(c.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getServico().getDiscriminacao());

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

    public ArrayList<CompNfse> lerXMLs(File[] xmls) throws IOException {
        ArrayList<CompNfse> retorno = new ArrayList<>();

        for (File f : xmls) {
            String xml = UtilFile.fileToStringInline(new File(f.getAbsolutePath()));

            XStream xstream = new XStream();
            xstream.autodetectAnnotations(true);

            InputStream is = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));

            xstream.alias("ConsultarNfseFaixaResposta", ConsultarNfseFaixaResposta.class);

            ConsultarNfseFaixaResposta consultarNfseFaixaResposta = (ConsultarNfseFaixaResposta) xstream.fromXML(is);

            retorno.addAll(consultarNfseFaixaResposta.getListaNfse().getListaNfse());
        }
        return retorno;
    }
}
