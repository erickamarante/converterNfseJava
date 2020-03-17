package com.constanzooficial.integracao.controller.nfse.mt.campoNovoDoParecis;

import com.constanzooficial.integracao.model.nfse.mt.campoNovoDoParecis.CompNfse;
import com.constanzooficial.integracao.model.nfse.mt.campoNovoDoParecis.ConsultarNfseRpsResposta;
import com.constanzooficial.integracao.model.nfse.mt.campoNovoDoParecis.ConsultarNfseRpsRespostas;
import com.constanzooficial.integracao.model.nfse.mt.campoNovoDoParecis.Nfse;
import com.constanzooficial.integracao.model.nfse.mt.campoNovoDoParecis.Raiz;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
public class ControllerLeitor {

    public ModelNota lerNotas(String caminhoXml, boolean considerarIss) throws FileNotFoundException, Exception {

        ArrayList<ConsultarNfseRpsResposta> notas = lerXML(caminhoXml);

        double valorTotalServicos = 0;
        double valorTotalDeducoes = 0;
        double valorTotalIss = 0;
        double valorTotalCredito = 0;

        ArrayList<ModelDetalhe> detalhes = new ArrayList<>();
        for (ConsultarNfseRpsResposta cons : notas) {

            CompNfse c = cons.getCompNfse();

            ModelDetalhe d = new ModelDetalhe();
            Nfse n = c.getNfse();

            /* não precisa desta linha por enquanto
            d.setNumeroNfse(MyUtils.removeZeroEsquerda(n.getNumNota()));
             */
            d.setNumeroNfse(n.getInfNfse().getNumero().substring(n.getInfNfse().getNumero().length() - 8));

            d.setDataHoraNfse(MyUtils.trataDataHora2(n.getInfNfse().getDataEmissao()));

            d.setDataEmissaoRps(MyUtils.trataData2(n.getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getCompetencia()));

            d.setInscricaoMunicipalPrestador(n.getInfNfse().getPrestadorServico().getIdentificacaoPrestador().getInscricaoMunicipal());

            if (n.getInfNfse().getPrestadorServico().getIdentificacaoPrestador().getCpfCnpj().getCpf() != null) {
                d.setIndicadorCpfCnpjPrestador("1");
                d.setCpfCnpjPrestador(n.getInfNfse().getPrestadorServico().getIdentificacaoPrestador().getCpfCnpj().getCpf());
            } else if (n.getInfNfse().getPrestadorServico().getIdentificacaoPrestador().getCpfCnpj().getCnpj() != null) {
                d.setIndicadorCpfCnpjPrestador("2");
                d.setCpfCnpjPrestador(n.getInfNfse().getPrestadorServico().getIdentificacaoPrestador().getCpfCnpj().getCnpj());
            }

            d.setRazaoSocialPrestador(n.getInfNfse().getPrestadorServico().getRazaoSocial());

            String[] endereco = MyUtils.separaTipoEndereco(n.getInfNfse().getPrestadorServico().getEndereco().getEndereco());
            d.setTipoEnderecoPrestador(endereco[0]);
            d.setEnderecoPrestador(endereco[1]);

            /*
            não precisa remover zeros à esquerda por enquanto
            d.setNumeroEnderecoPrestador(MyUtils.removeZeroEsquerda(n.getPrestadorPrestNumero()));
             */
            d.setNumeroEnderecoPrestador(n.getInfNfse().getPrestadorServico().getEndereco().getNumero());

            d.setComplementoEnderecoPrestador(n.getInfNfse().getPrestadorServico().getEndereco().getComplemento());

            d.setBairroPrestador(n.getInfNfse().getPrestadorServico().getEndereco().getBairro());

            d.setCidadePrestador(UtilCidades.nomeCidade(n.getInfNfse().getPrestadorServico().getEndereco().getCodigoMunicipio()));

            d.setUfPrestador(n.getInfNfse().getPrestadorServico().getEndereco().getUf());

            d.setCepPrestador(n.getInfNfse().getPrestadorServico().getEndereco().getCep().replaceAll("[^0-9]", ""));

            d.setEmailPrestador(n.getInfNfse().getPrestadorServico().getContato().getEmail());

            d.setOpcaoPeloSimples(n.getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getOptanteSimplesNacional() ? "4" : "0");

            if (n.getInfNfse().getOutrasInformacoes().toLowerCase().contains("nota cancelada")) {
                d.setSituacaoNotaFiscal("C");

                Pattern pattern = Pattern.compile("EM \\d{2}/\\d{2}/\\d{4}");
                Matcher matcher = pattern.matcher(n.getInfNfse().getOutrasInformacoes());
                if (matcher.find()) {
                    String[] dataSplitada = matcher.group(0).split(" ")[1].split("/");
                    d.setDataCancelamento(dataSplitada);   
                }
            }

            if (!n.getInfNfse().getNfseSubstituida().equals("0")) {
                d.setSituacaoNotaFiscal("S");
            }

            double valorServico = Double.valueOf(MyUtils.trataValor(n.getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getServico().getValores().getValorServicos()));
            d.setValorServicos(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorServico));
            if (!d.getSituacaoNotaFiscal().equals("C") && !d.getSituacaoNotaFiscal().equals("S")) {
                valorTotalServicos += valorServico;
            }

            double valorDeducoes = Double.valueOf(MyUtils.trataValor(n.getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getServico().getValores().getValorDeducoes()));
            d.setValorDeducoes(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorDeducoes));
            if (!d.getSituacaoNotaFiscal().equals("C") && !d.getSituacaoNotaFiscal().equals("S")) {
                valorTotalDeducoes += valorDeducoes;
            }

            /* não precisa tratar zeros à esquerda por enquanto
            d.setCodigoServicoPrestadoNotaFiscal(MyUtils.removeZeroEsquerda(n.getCosServico()));
             */
            d.setCodigoServicoPrestadoNotaFiscal(n.getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getServico().getItemListaServico().replaceAll("[^0-9]", ""));

            d.setAliquota(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(considerarIss ? MyUtils.trataValor(n.getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getServico().getValores().getAliquota()) : "0"));

            double valorIss = considerarIss ? Double.valueOf(n.getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getServico().getValores().getValorIss()) : 0;
            d.setValorIss(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorIss));
            if (!d.getSituacaoNotaFiscal().equals("C") && !d.getSituacaoNotaFiscal().equals("S")) {
                valorTotalIss += valorIss;
            }

            if (n.getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getServico().getIssRetido()) {
                d.setIssRetido("S");
            } else {
                d.setIssRetido("N");
            }

            if (n.getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getIdentificacaoTomador().getCpfCnpj().getCpf() != null) {
                d.setIndicadorCpfCnpjTomador("1");
                d.setCpfCnpjTomador(n.getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getIdentificacaoTomador().getCpfCnpj().getCpf());
            } else {
                d.setIndicadorCpfCnpjTomador("2");
                d.setCpfCnpjTomador(n.getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getIdentificacaoTomador().getCpfCnpj().getCnpj());
            }

            d.setInscricaoMunicipalTomador(n.getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getIdentificacaoTomador().getInscricaoMunicipal());

            d.setInscricaoEstadualTomador(n.getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getIdentificacaoTomador().getInscricaoEstadual());

            d.setRazaoSocialTomador(n.getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getRazaoSocial());

            endereco = MyUtils.separaTipoEndereco(n.getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getEndereco().getEndereco());
            d.setTipoEnderecoTomador(endereco[0]);
            d.setEnderecoTomador(endereco[1]);

            /* não precisa remover zeros à esquerda por enquanto
            d.setNumeroEnderecoTomador(MyUtils.removeZeroEsquerda(n.getTomadorNumero()));
             */
            d.setNumeroEnderecoTomador(n.getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getEndereco().getNumero());

            d.setComplementoEnderecoTomador(n.getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getEndereco().getComplemento());

            d.setBairroTomador(n.getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getEndereco().getBairro());

            d.setCidadeTomador(UtilCidades.nomeCidade(n.getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getEndereco().getCodigoMunicipio()));

            d.setUfTomador(n.getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getEndereco().getUf());

            d.setCepTomador(n.getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getEndereco().getCep());

            if (n.getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getContato() != null) {
                d.setEmailTomador(n.getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getTomador().getContato().getEmail());
            }

            d.setDiscriminacaoServicos(n.getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getServico().getDiscriminacao().replace("&lt;", " ").replace("br /&gt;", " "));

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

    private ArrayList<ConsultarNfseRpsResposta> lerXML(String path) throws FileNotFoundException, IOException {

        String xml = UtilFile.fileToStringInline(new File(path));
        xml = xml.replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "");
        xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><raiz>" + xml + "</raiz>";

        XStream xstream = new XStream();
        xstream.autodetectAnnotations(true);
        //InputStream is = new FileInputStream(new File(path));
        InputStream is = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));
        xstream.alias("raiz", Raiz.class);
        Raiz retorno = (Raiz) xstream.fromXML(is);

        return retorno.getConsultarNfseRpsResposta();
    }

}
