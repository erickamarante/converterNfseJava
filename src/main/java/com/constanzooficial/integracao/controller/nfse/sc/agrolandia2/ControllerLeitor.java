package com.constanzooficial.integracao.controller.nfse.sc.agrolandia2;

import com.constanzooficial.integracao.model.nfse.sc.agrolandia2.ListaNfse;
import com.constanzooficial.integracao.model.nfse.sc.agrolandia2.Nf;
import com.constanzooficial.integracao.model.nfse.sc.agrolandia2.Nfse;
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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Waislan Sanches
 */
public class ControllerLeitor {

    public ModelNota lerNotas(File pasta, boolean considerarIss) throws FileNotFoundException, Exception {

        ArrayList<Nfse> notas = lerXMLs(pasta);

        double valorTotalServicos = 0;
        double valorTotalDeducoes = 0;
        double valorTotalIss = 0;
        double valorTotalCredito = 0;

        ArrayList<ModelDetalhe> detalhes = new ArrayList<>();
        for (Nfse c : notas) {

            ModelDetalhe d = new ModelDetalhe();
            Nf n = c.getNf();

            /* não precisa desta linha por enquanto
            d.setNumeroNfse(MyUtils.removeZeroEsquerda(n.getNumNota()));
             */
            d.setNumeroNfse(n.getNumeroNfse());

            d.setDataHoraNfse(n.getDataNfse());

            d.setDataEmissaoRps(n.getDataNfse());
            //d.setInscricaoMunicipalPrestador(n.getInfNfse().getPrestadorServico().getIdentificacaoPrestador().getInscricaoMunicipal());
            if (c.getPrestador().getCpfCnpj().length() == 11) {
                d.setIndicadorCpfCnpjPrestador("1");
            } else {
                d.setIndicadorCpfCnpjPrestador("2");
            }

            d.setCpfCnpjPrestador(c.getPrestador().getCpfCnpj());

            //d.setRazaoSocialPrestador(n.getInfNfse().getPrestadorServico().getRazaoSocial());
//            String[] endereco = MyUtils.separaTipoEndereco(n.getInfNfse().getPrestadorServico().getEndereco().getEndereco());
//            d.setTipoEnderecoPrestador(endereco[0]);
//            d.setEnderecoPrestador(endereco[1]);

            /*
            não precisa remover zeros à esquerda por enquanto
            d.setNumeroEnderecoPrestador(MyUtils.removeZeroEsquerda(n.getPrestadorPrestNumero()));
             */
            //d.setNumeroEnderecoPrestador(n.getInfNfse().getPrestadorServico().getEndereco().getNumero());
            //d.setComplementoEnderecoPrestador(n.getInfNfse().getPrestadorServico().getEndereco().getComplemento());
            //d.setBairroPrestador(n.getInfNfse().getPrestadorServico().getEndereco().getBairro());
            d.setCidadePrestador(UtilCidades.nomeCidade(4200200));

            d.setUfPrestador("SC");
            //d.setCepPrestador(n.getInfNfse().getPrestadorServico().getEndereco().getCep());
            //d.setEmailPrestador(n.getInfNfse().getPrestadorServico().getContato().getEmail());
            //d.setOpcaoPeloSimples(n.getInfNfse().getOptanteSimplesNacional() ? "4" : "0");
            if (n.getSituacao() != null && n.getSituacao().equals("C")) {
                d.setSituacaoNotaFiscal("C");
                d.setDataCancelamento(n.getDataNfse());
            }
            else if (n.getSituacao() != null) {
                throw new Exception("Notas substituidas detectadas. Favor contatar o administrador.");
                // d.setSituacaoNotaFiscal("S");
            }
            double valorServico = Double.valueOf(MyUtils.trataValor(n.getValorTotal().replace(",", ".")));
            d.setValorServicos(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorServico));
//            if (!d.getSituacaoNotaFiscal().equals("C") && !d.getSituacaoNotaFiscal().equals("S")) {
                valorTotalServicos += valorServico;
//            }

            double valorDeducoes = Double.valueOf(MyUtils.trataValor(n.getValorDesconto().replace(",", ".")));
            d.setValorDeducoes(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorDeducoes));
//            if (!d.getSituacaoNotaFiscal().equals("C") && !d.getSituacaoNotaFiscal().equals("S")) {
                valorTotalDeducoes += valorDeducoes;
//            }

            /* não precisa tratar zeros à esquerda por enquanto
            d.setCodigoServicoPrestadoNotaFiscal(MyUtils.removeZeroEsquerda(n.getCosServico()));
             */
            d.setCodigoServicoPrestadoNotaFiscal(c.getItens().getLista().get(0).getCodigoItemListaServico().replaceAll("[^0-9]", ""));
            d.setAliquota(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(considerarIss ? MyUtils.trataValor(c.getItens().getLista().get(0).getAliquotaItemListaServico()) : "0"));

            if(considerarIss){
                double aliquota = Double.valueOf(c.getItens().getLista().get(0).getAliquotaItemListaServico().replace(",", "."));
                double valorIss = Double.valueOf(aliquota * valorServico);
                d.setValorIss(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorIss));

            }
            else {
                double valorIss = 0;
                d.setValorIss(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorIss));

            }
            
//            if (!d.getSituacaoNotaFiscal().equals("C") && !d.getSituacaoNotaFiscal().equals("S")) {
//                valorTotalIss += valorIss;
//            }

            if (Double.valueOf(c.getItens().getLista().get(0).getValorIssrf().replace(",", ".")) != 0) {
                d.setIssRetido("S");
            } else {
                d.setIssRetido("N");
            }

            if (c.getTomador().getCpfCnpj().length() == 11) {
                d.setIndicadorCpfCnpjTomador("1");
                d.setCpfCnpjTomador(c.getTomador().getCpfCnpj());
            } else {
                d.setIndicadorCpfCnpjTomador("2");
                d.setCpfCnpjTomador(c.getTomador().getCpfCnpj());
            }

            //d.setInscricaoMunicipalTomador(n.getInfNfse().getTomadorServico().getIdentificacaoTomador().getInscricaoMunicipal());

            d.setRazaoSocialTomador(c.getTomador().getNomeRazaoSocial());

            //endereco = MyUtils.separaTipoEndereco(n.getInfNfse().getTomadorServico().getEndereco().getEndereco());
            //d.setTipoEnderecoTomador(endereco[0]);
            //d.setEnderecoTomador(endereco[1]);

            /* não precisa remover zeros à esquerda por enquanto
            d.setNumeroEnderecoTomador(MyUtils.removeZeroEsquerda(n.getTomadorNumero()));
             */
            //d.setNumeroEnderecoTomador(n.getInfNfse().getTomadorServico().getEndereco().getNumero());

            d.setComplementoEnderecoTomador(c.getTomador().getComplemento());

            d.setBairroTomador(c.getTomador().getBairro());

            d.setCidadeTomador(c.getTomador().getCidade());

            //d.setUfTomador(n.getInfNfse().getTomadorServico().getEndereco().getUf());

            d.setCepTomador(c.getTomador().getCep());

            if (c.getTomador().getEmail() != null) {
                d.setEmailTomador(c.getTomador().getEmail());
            }

            //d.setDiscriminacaoServicos(n.getInfNfse().getServico().getDiscriminacao().replace("&lt;", " ").replace("br /&gt;", " "));

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

        //System.out.println("Quantidade de notas: " + notas.getNotasFiscais().size());
        //System.out.println("Valor total dos serviços: " + valorTotalServicos);
        return nota;
    }

//    private ArrayList<Nfse> lerXML(String path) throws FileNotFoundException {
//
//        XStream xstream = new XStream();
//        xstream.autodetectAnnotations(true);
//        InputStream is = new FileInputStream(new File(path));
//        xstream.alias("ConsultarNfseResposta", ConsultarNfseResposta.class);
//        ConsultarNfseResposta retorno = (ConsultarNfseResposta) xstream.fromXML(is);
//
//        return retorno.getListaNfse().getListaNfse();
//    }
    
//    private ArrayList<Nfse> lerXML(File pasta) throws FileNotFoundException, IOException {
//
//        String xml = UtilFile.fileToStringInline(new File(path));
//        xml = xml.replace("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>", "");
//        xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><listaNfse>" + xml + "</listaNfse>";
//
//        XStream xstream = new XStream();
//        xstream.autodetectAnnotations(true);
//        //InputStream is = new FileInputStream(new File(path));
//        InputStream is = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));
//        xstream.alias("listaNfse", ListaNfse.class);
//        ListaNfse retorno = (ListaNfse) xstream.fromXML(is);
//
//        return retorno.getNfses();
//    }
    
    public ArrayList<Nfse> lerXMLs(File folder) throws IOException {

        ArrayList<Nfse> retorno = new ArrayList<>();

        for (File file : folder.listFiles()) {
            
            String xml = UtilFile.fileToStringInline(new File(file.getAbsolutePath()));
            xml = xml.replace("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>", "");
            xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><listaNfse>" + xml + "</listaNfse>";
            
            XStream xstream = new XStream();
            xstream.autodetectAnnotations(true);
            
            InputStream is = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));
            xstream.alias("listaNfse", ListaNfse.class);
            ListaNfse nota = (ListaNfse) xstream.fromXML(is);
            
            for (Nfse nfse : nota.getNfses()){
                retorno.add(nfse);
            }
        }
        return retorno;
    }

}
