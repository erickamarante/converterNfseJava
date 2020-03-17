package com.constanzooficial.integracao.controller.nfse.sp.bauru;

import com.constanzooficial.integracao.model.nfse.sp.bauru.NFe;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelCabecalho;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelDetalhe;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelDetalheComparator;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelNota;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelRodape;
import com.constanzooficial.integracao.util.MyUtils;
import com.constanzooficial.integracao.util.UtilFile;
import com.constanzooficial.integracao.util.UtilZip;
import com.thoughtworks.xstream.XStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Waislan Luis Sanches
 */
public class ControllerLeitor {

    public ModelNota lerNotas(File[] arquivos, boolean considerarIss) throws IOException, Exception {

        ArrayList<File> xmls = extrairZips(arquivos);
        ArrayList<NFe> notas = lerXMLs(xmls);

        double valorTotalServicos = 0;
        double valorTotalDeducoes = 0;
        double valorTotalIss = 0;
        double valorTotalCredito = 0;

        ArrayList<ModelDetalhe> detalhes = new ArrayList<>();

        for (NFe n : notas) {
            System.out.println(n.getChaveNFe().getNumeroNFe());
            
            ModelDetalhe d = new ModelDetalhe();
            
            d.setNumeroNfse(n.getChaveNFe().getNumeroNFe());

            d.setDataHoraNfse(n.getChaveNFe().getDataEmissaoNFe());

            d.setDataEmissaoRps(n.getChaveNFe().getDataEmissaoNFe());
            
            d.setInscricaoMunicipalPrestador(n.getInscricaoPrestador());
            
            if (n.getCpfCnpjPrestador().getCpf() != null) {
                d.setIndicadorCpfCnpjPrestador("1");
                d.setCpfCnpjPrestador(n.getCpfCnpjPrestador().getCpf());
            } else {
                d.setIndicadorCpfCnpjPrestador("2");
                d.setCpfCnpjPrestador(n.getCpfCnpjPrestador().getCnpj());
            }

            d.setRazaoSocialPrestador(n.getRazaoSocialPrestador());
            /*
            String logradouro = n.getEnderecoPrestador().getLogradouro();
            
            d.setTipoEnderecoPrestador(logradouro.split(" ")[0]);
            */
            d.setEnderecoPrestador(n.getEnderecoPrestador().getLogradouro());

            /*
            não precisa remover zeros à esquerda por enquanto
            d.setNumeroEnderecoPrestador(MyUtils.removeZeroEsquerda(n.getPrestadorPrestNumero()));
            
            
            logradouro = logradouro[1].split("-");
            logradouro[0] = logradouro[0].trim();
            */        
            d.setNumeroEnderecoPrestador(n.getEnderecoPrestador().getNumeroEndereco());
            
            d.setComplementoEnderecoPrestador(n.getEnderecoPrestador().getComplementoEndereco());
            
            d.setBairroPrestador(n.getEnderecoPrestador().getBairro());
            /*
            auxiliar = n.getTimbreContribuinteLinha3();
            String[] cepCidadeEstado = auxiliar.split(" - ");
            */
            d.setCidadePrestador(n.getEnderecoPrestador().getCidade());

            d.setUfPrestador(n.getEnderecoPrestador().getUf());
            
            //cepCidadeEstado[0] = cepCidadeEstado[0].replaceAll("[^0-9]", "");
            
            d.setCepPrestador(n.getEnderecoPrestador().getCep());
            
            if (n.getEmailPrestador() != null) {
                d.setEmailPrestador(n.getEmailPrestador());
            }
            
            if (n.getOpcaoSimples().toLowerCase().equals("não")){
                d.setOpcaoPeloSimples("4");
            } else {
                d.setOpcaoPeloSimples("0");
            }
            
            if (!n.getStatusNFe().toLowerCase().equals("ativa") /* && !n.get.replaceAll("0", "").equals("") */) {
                throw new Exception("Nota inativa! Favor contatar o administrador.");
                /*
                d.setSituacaoNotaFiscal("C");
                d.setDataCancelamento(c.getNfseCancelamento().getConfirmacao().getInfConfirmacaoCancelamento().getDataHora());
                */
            }
            /*
            if (!n.getSituacaoNf().equals("Normal") && !n.getSituacaoNf().equals("Cancelada")){
                throw new Exception("Favor contatar o administrador.");
            }
            if (!c.getNfseSubstituicao().getSubstituicaoNfse().equals("")) {
                throw new Exception("Notas substituidas detectadas. Favor solicitar correção do conversor.");
                // d.setSituacaoNotaFiscal("S");
            }
            */
            NumberFormat nf = new DecimalFormat("#,###.00");
            double valorServico = nf.parse (n.getValorServicos()).doubleValue();
            
            //double valorServico = Double.valueOf(n.getValorServicos().replaceAll(",", "."));
            d.setValorServicos(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorServico));
            
            if (n.getStatusNFe().toLowerCase().equals("ativa")) {
                valorTotalServicos += valorServico;
            }
            /*
            double valorDeducoes = Double.valueOf(n.getV);
            d.setValorDeducoes(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorDeducoes));
//            if (!d.getSituacaoNotaFiscal().equals("C") && !d.getSituacaoNotaFiscal().equals("S")) {
                valorTotalDeducoes += valorDeducoes;
//            }

            /* não precisa tratar zeros à esquerda por enquanto
            d.setCodigoServicoPrestadoNotaFiscal(MyUtils.removeZeroEsquerda(n.getCosServico()));
             */
            
            d.setCodigoServicoPrestadoNotaFiscal(n.getCodigoServico());
            
            d.setAliquota(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(considerarIss ? MyUtils.trataValor(n.getAliquotaServicos()) : "0"));

            double valorIss = 0;
            if(considerarIss){
                double aliquota = Double.valueOf(n.getAliquotaServicos());
                valorIss = aliquota * valorServico;
                d.setValorIss(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorIss));
            } else {
                //valorIss = 0;
                d.setValorIss(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorIss));
            }
            
//            if (!d.getSituacaoNotaFiscal().equals("C") && !d.getSituacaoNotaFiscal().equals("S")) {
                valorTotalIss += valorIss;
//            }

            if (n.getIssRetido().toLowerCase().equals("sim")) {
                d.setIssRetido("S");
            } else {
                d.setIssRetido("N");
            }

            if (n.getCpfCnpjTomador().getCpf() != null) {
                d.setIndicadorCpfCnpjTomador("1");
                d.setCpfCnpjTomador(n.getCpfCnpjTomador().getCpf());
            } else {
                d.setIndicadorCpfCnpjTomador("2");
                d.setCpfCnpjTomador(n.getCpfCnpjTomador().getCnpj());
            }

            d.setInscricaoMunicipalTomador(n.getInscricaoTomador());

            d.setRazaoSocialTomador(n.getRazaoSocialTomador());
            /*
            auxiliar = n.getClienteEndereco();
            String logradouroCliente = auxiliar.replaceAll("[^a-zA-Z\\s]+", "");
            String numeroLogradouroCliente = auxiliar.replaceAll("[^0-9]", "");
            endereco = MyUtils.separaTipoEndereco(logradouroCliente);

            d.setTipoEnderecoTomador(endereco[0]);
            */
            d.setEnderecoTomador(n.getEnderecoTomador().getLogradouro());

            /* não precisa remover zeros à esquerda por enquanto
            d.setNumeroEnderecoTomador(MyUtils.removeZeroEsquerda(n.getTomadorNumero()));
             */
            d.setNumeroEnderecoTomador(n.getEnderecoTomador().getNumeroEndereco());

            d.setComplementoEnderecoTomador(n.getEnderecoTomador().getComplementoEndereco());

            d.setBairroTomador(n.getEnderecoTomador().getBairro());

            d.setCidadeTomador(n.getEnderecoTomador().getCidade());

            d.setUfTomador(n.getEnderecoTomador().getUf());

            d.setCepTomador(n.getEnderecoTomador().getCep());

            if (n.getEmailTomador() != null) {
                d.setEmailTomador(n.getEmailTomador());
            }

            d.setDiscriminacaoServicos(n.getDiscriminacao());

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

    private ArrayList<File> extrairZips(File[] files) throws IOException {
        ArrayList<File> retorno = new ArrayList<>();
        File destFolder = new File("tmp");

        for (File f : files) {
            if (f.getName().toLowerCase().endsWith(".zip")) {
                UtilZip.unzipArchive(f, destFolder);
            } else {
                retorno.add(f);
            }
        }

        if (destFolder.listFiles() != null) {
            for (File f : destFolder.listFiles()) {
                retorno.add(f);
            }
        }
        return retorno;
    }
    
    public ArrayList<NFe> lerXMLs(ArrayList<File> xmls) throws IOException {
        ArrayList<NFe> retorno = new ArrayList<>();

        for (File f : xmls) {
            //System.out.println(f.getName());
            String xml = UtilFile.fileToStringInline(new File(f.getAbsolutePath()));
            
            XStream xstream = new XStream();
            xstream.autodetectAnnotations(true);
            
            InputStream is = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));
            xstream.alias("NFe", NFe.class);
            NFe nfe = (NFe) xstream.fromXML(is);
            
            retorno.add(nfe);
        }
        return retorno;
    }
}
