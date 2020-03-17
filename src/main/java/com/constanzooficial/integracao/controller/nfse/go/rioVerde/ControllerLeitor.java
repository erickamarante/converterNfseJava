package com.constanzooficial.integracao.controller.nfse.go.rioVerde;

import com.constanzooficial.integracao.model.nfse.go.rioVerde.CompNfse;
import com.constanzooficial.integracao.model.nfse.go.rioVerde.GerarNfseResposta;
import com.constanzooficial.integracao.model.nfse.go.rioVerde.Raiz;
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
 * @author Waislan Luis Sanches
 */
public class ControllerLeitor {

    public ModelNota lerNotas(File[] files, boolean considerarIss) throws FileNotFoundException, IOException, Exception {

        ArrayList<GerarNfseResposta> notas = lerXML(files);

        double valorTotalServicos = 0;
        double valorTotalDeducoes = 0;
        double valorTotalIss = 0;
        double valorTotalCredito = 0;

        ArrayList<ModelDetalhe> detalhes = new ArrayList<>();

        for (GerarNfseResposta n : notas) {

            for (CompNfse nota : n.getListaNfse().getCompNfses()) {
                
                ModelDetalhe d = new ModelDetalhe();

                /* não precisa desta linha por enquanto
                d.setNumeroNfse(MyUtils.removeZeroEsquerda(n.getNumNota()));
                 */
                d.setNumeroNfse(nota.getNfse().getInfNfse().getNumero());

                d.setDataHoraNfse(nota.getNfse().getInfNfse().getDataEmissao());

                d.setDataEmissaoRps(nota.getNfse().getInfNfse().getDataEmissao());
                
                d.setInscricaoMunicipalPrestador(nota.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getPrestador().getInscricaoMunicipal());

                if (nota.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getPrestador().getCpfCnpj().getCpf() != null) {
                    d.setIndicadorCpfCnpjPrestador("1");
                    d.setCpfCnpjPrestador(nota.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getPrestador().getCpfCnpj().getCpf());
                } else {
                    d.setIndicadorCpfCnpjPrestador("2");
                    d.setCpfCnpjPrestador(nota.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getPrestador().getCpfCnpj().getCnpj());
                } 

                //d.setRazaoSocialPrestador(n.getDadosPrestador().getRazaoSocial());
//            String[] endereco = MyUtils.separaTipoEndereco(n.getDadosPrestador().getEndereco().getLogradouroTipo()
//                    + " " + n.getDadosPrestador().getEndereco().getLogradouro());
//            d.setTipoEnderecoPrestador(endereco[0]);
//            d.setEnderecoPrestador(endereco[1]);

                /*
            não precisa remover zeros à esquerda por enquanto
            d.setNumeroEnderecoPrestador(MyUtils.removeZeroEsquerda(n.getPrestadorPrestNumero()));
                 */
                //d.setNumeroEnderecoPrestador(n.getDadosPrestador().getEndereco().getLogradouroNumero());
                //d.setComplementoEnderecoPrestador(n.getDadosPrestador().getEndereco().getLogradouroComplemento());
                //d.setBairroPrestador(n.getDadosPrestador().getEndereco().getBairro());
                //d.setCidadePrestador(n.getDadosPrestador().getEndereco().getMunicipio());
                //d.setUfPrestador(n.getDadosPrestador().getEndereco().getUf());
                //d.setCepPrestador(n.getDadosPrestador().getEndereco().getCep());
                if (!nota.getNfse().getInfNfse().getNfseSubstituida().equals("0") /* !n.getStatus().equals("1") && !n.get.replaceAll("0", "").equals("") */) {

                    throw new Exception("Nota substituída detectada! Favor contatar o administrador.");

                    //d.setSituacaoNotaFiscal("C");
                    /*
                tmp = n.getDataHoraCancelamento();
                dataHora = new String[6];
                split = tmp.split(" ");
                split = split[0].split("/");
                dataHora[0] = split[0];
                dataHora[1] = split[1];
                dataHora[2] = split[2];
                d.setDataCancelamento(dataHora);
                     */
                }

                double valorServico = Double.valueOf(MyUtils.trataValor(nota.getNfse().getInfNfse().getValoresNfse().getBaseCalculo()));
                d.setValorServicos(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorServico));

                if (nota.getNfse().getInfNfse().getDescricaoCancelamento().equals("") /*!d.getSituacaoNotaFiscal().equals("C")*/) {
                    valorTotalServicos += valorServico;
                }

//            double valorDeducoes = Double.valueOf(MyUtils.trataValor(n.getValores().getValorDeducoes()));
//            d.setValorDeducoes(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorDeducoes));
//            if (nota.getNfse().getInfNfse().getDescricaoCancelamento().equals("") /* !d.getSituacaoNotaFiscal().equals("C") */) {
//                valorTotalDeducoes += valorDeducoes;
//            }

                /* não precisa tratar zeros à esquerda por enquanto
            d.setCodigoServicoPrestadoNotaFiscal(MyUtils.removeZeroEsquerda(n.getCosServico()));
                 */
                //d.setCodigoServicoPrestadoNotaFiscal(n.getServicos().getCodigoServico116().replaceAll("[^0-9]", ""));
                d.setAliquota(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(considerarIss ? MyUtils.trataValor(nota.getNfse().getInfNfse().getValoresNfse().getAliquota()) : "0"));

                double valorIss = considerarIss ? Double.valueOf(nota.getNfse().getInfNfse().getValoresNfse().getValorIss()) : 0;
                d.setValorIss(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorIss));

                if (nota.getNfse().getInfNfse().getDescricaoCancelamento().equals("") /*!d.getSituacaoNotaFiscal().equals("C")*/) {
                    valorTotalIss += valorIss;
                }

//            if (Double.valueOf(MyUtils.trataValor(n.getIssRetido())) != 1) {
//                d.setIssRetido("S");
//            } else {
//                d.setIssRetido("N");
//            }
                if (nota.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getIdentificacaoTomador().getCpfCnpj().getCpf() != null) {
                    d.setIndicadorCpfCnpjTomador("1");
                    d.setCpfCnpjTomador(nota.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getIdentificacaoTomador().getCpfCnpj().getCpf());
                } else {
                    d.setIndicadorCpfCnpjTomador("2");
                    d.setCpfCnpjTomador(nota.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getIdentificacaoTomador().getCpfCnpj().getCnpj());
                } 

                d.setRazaoSocialTomador(nota.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getRazaoSocial());

                String[] endereco = MyUtils.separaTipoEndereco(nota.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getEndereco().getEndereco());
                d.setTipoEnderecoTomador(endereco[0]);
                d.setEnderecoTomador(endereco[1]);

                /* não precisa remover zeros à esquerda por enquanto
            d.setNumeroEnderecoTomador(MyUtils.removeZeroEsquerda(n.getTomadorNumero()));
                 */
                d.setNumeroEnderecoTomador(nota.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getEndereco().getNumero());

                d.setComplementoEnderecoTomador(nota.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getEndereco().getComplemento());

                d.setBairroTomador(nota.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getEndereco().getBairro());

                d.setCidadeTomador(UtilCidades.nomeCidade(nota.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getEndereco().getCodigoMunicipio()));

                //d.setUfTomador(n.getDadosTomador().getEndereco().getUf());
                d.setCepTomador(nota.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getEndereco().getCep());

                //d.setEmailTomador(n.getDadosTomador().getContato().getEmail());
                d.setDiscriminacaoServicos(nota.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getServico().getDiscriminacao());

                detalhes.add(d);
            }

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

    private ArrayList<GerarNfseResposta> lerXML(File[] files) throws FileNotFoundException, IOException {

        String xml = UtilFile.fileToStringInline(new File(files[0].getAbsolutePath()));
        XStream xstream = new XStream();
        xstream.autodetectAnnotations(true);
        InputStream is = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));

        for (File f : files) {

            xml = UtilFile.fileToStringInline(new File(f.getAbsolutePath()));

//            xml = xml.replace("<GerarNfseResposta\n"
//                    + "    xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"\n"
//                    + "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n"
//                    + "    xmlns=\"http://www.centi.com.br/files/nfse.xsd\">", "");
//            
//            xml = xml.replace("</GerarNfseResposta>", "");
//            
//            xml = xml.replace("<ListaNfse>", "");
//
//            xml = xml.replace("</ListaNfse>", "");
            xml = "<raiz>" + xml + "</raiz>";

            is = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));

        }
        xstream.alias("raiz", Raiz.class);
        Raiz retorno = (Raiz) xstream.fromXML(is);
        return retorno.getGerarNfseRespostas();
    }

}
