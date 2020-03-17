package com.constanzooficial.integracao.controller.nfse.rn.caico;

import com.constanzooficial.integracao.model.nfse.rn.caico.Envelope;
import com.constanzooficial.integracao.model.nfse.rn.caico.InfRps;
import com.constanzooficial.integracao.model.nfse.rn.caico.Rps;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelCabecalho;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelDetalhe;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelDetalheComparator;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelNota;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelRodape;
import com.constanzooficial.integracao.util.MyUtils;
import com.constanzooficial.integracao.util.UtilCidades;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Waislan Sanches
 */
public class ControllerLeitor {
    
    public ModelNota lerNotas(String caminhoXml, boolean considerarIss) throws FileNotFoundException, Exception {

        ArrayList<Rps> notas = lerXML(caminhoXml);

        double valorTotalServicos = 0;
        double valorTotalDeducoes = 0;
        double valorTotalIss = 0;
        double valorTotalCredito = 0;

        ArrayList<ModelDetalhe> detalhes = new ArrayList<>();
        for (Rps c : notas) {

            ModelDetalhe d = new ModelDetalhe();
            InfRps n = c.getInfRps();

            d.setNumeroNfse(n.getIdentificacaoRps().getNumero());

            d.setDataHoraNfse(n.getDataEmissao());

            d.setDataEmissaoRps(n.getDataEmissao());

            d.setInscricaoMunicipalPrestador(n.getPrestador().getInscricaoMunicipal());

            d.setIndicadorCpfCnpjPrestador("2");
            
            d.setCpfCnpjPrestador(n.getPrestador().getCnpj());
            /*
            d.setRazaoSocialPrestador(n.getInfNfse().getPrestadorServico().getRazaoSocial());

            String[] endereco = MyUtils.separaTipoEndereco(n.getInfNfse().getPrestadorServico().getEndereco().getEndereco());
            d.setTipoEnderecoPrestador(endereco[0]);
            d.setEnderecoPrestador(endereco[1]);
            
            /*
            não precisa remover zeros à esquerda por enquanto
            d.setNumeroEnderecoPrestador(MyUtils.removeZeroEsquerda(n.getPrestadorPrestNumero()));
             *
            d.setNumeroEnderecoPrestador(n.getInfNfse().getPrestadorServico().getEndereco().getNumero());

            d.setComplementoEnderecoPrestador(n.getInfNfse().getPrestadorServico().getEndereco().getComplemento());

            d.setBairroPrestador(n.getInfNfse().getPrestadorServico().getEndereco().getBairro());
            */
            d.setCidadePrestador(UtilCidades.nomeCidade(n.getServico().getCodigoMunicipio()));

            d.setUfPrestador("RN");
            /*
            d.setCepPrestador(n.getInfNfse().getPrestadorServico().getEndereco().getCep());
            
            d.setEmailPrestador(n.getInfNfse().getPrestadorServico().getContato().getEmail());
            */
            d.setOpcaoPeloSimples(n.getOptanteSimplesNacional().equals("1") ? "4" : "0");
            /*
            if (c.getNfseCancelamento().getConfirmacao().getInfConfirmacaoCancelamento().getSucesso().equals("true") /* && !n.get.replaceAll("0", "").equals("") *) {
                d.setSituacaoNotaFiscal("C");
                d.setDataCancelamento(c.getNfseCancelamento().getConfirmacao().getInfConfirmacaoCancelamento().getDataHora());
            }

            if (!c.getNfseSubstituicao().getSubstituicaoNfse().equals("")) {
                throw new Exception("Notas substituidas detectadas. Favor solicitar correção do conversor.");
                // d.setSituacaoNotaFiscal("S");
            }
            */
            double valorServico = Double.valueOf(MyUtils.trataValor(n.getServico().getValores().getValorServicos()));
            d.setValorServicos(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorServico));
            /*
            if (!d.getSituacaoNotaFiscal().equals("C") && !d.getSituacaoNotaFiscal().equals("S")) {
                valorTotalServicos += valorServico;
            }
            *
            double valorDeducoes = Double.valueOf(MyUtils.trataValor(n.getInfNfse().getServico().getValores().getValorDeducoes()));
            d.setValorDeducoes(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorDeducoes));
            if (!d.getSituacaoNotaFiscal().equals("C") && !d.getSituacaoNotaFiscal().equals("S")) {
                valorTotalDeducoes += valorDeducoes;
            }
            */
            /* não precisa tratar zeros à esquerda por enquanto
            d.setCodigoServicoPrestadoNotaFiscal(MyUtils.removeZeroEsquerda(n.getCosServico()));
             */
            d.setCodigoServicoPrestadoNotaFiscal(n.getServico().getCodigoCnae().replaceAll("[^0-9]", ""));

            d.setAliquota(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(considerarIss ? MyUtils.trataValor(n.getServico().getValores().getAliquota()) : "0"));

            double valorIss = considerarIss ? Double.valueOf(n.getServico().getValores().getValorIss()) : 0;
            d.setValorIss(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorIss));
            if (!d.getSituacaoNotaFiscal().equals("C") && !d.getSituacaoNotaFiscal().equals("S")) {
                valorTotalIss += valorIss;
            }

            if (n.getServico().getValores().getIssRetido().equals("1")) {
                d.setIssRetido("S");
            } else {
                d.setIssRetido("N");
            }

            if (n.getTomador().getIdentificacaoTomador().getCpfCnpj().getCpf() != null) {
                d.setIndicadorCpfCnpjTomador("1");
                d.setCpfCnpjTomador(n.getTomador().getIdentificacaoTomador().getCpfCnpj().getCpf());
            } else {
                d.setIndicadorCpfCnpjTomador("2");
                d.setCpfCnpjTomador(n.getTomador().getIdentificacaoTomador().getCpfCnpj().getCnpj());
            }
            
            //d.setInscricaoMunicipalTomador(n.getTomador().getIdentificacaoTomador().getInscricaoMunicipal());

            d.setRazaoSocialTomador(n.getTomador().getRazaoSocial());

            String[] endereco = MyUtils.separaTipoEndereco(n.getTomador().getEndereco().getEndereco());
            d.setTipoEnderecoTomador(endereco[0]);
            d.setEnderecoTomador(endereco[1]);

            /* não precisa remover zeros à esquerda por enquanto
            d.setNumeroEnderecoTomador(MyUtils.removeZeroEsquerda(n.getTomadorNumero()));
             */
            d.setNumeroEnderecoTomador(n.getTomador().getEndereco().getNumero());

            d.setComplementoEnderecoTomador(n.getTomador().getEndereco().getComplemento());

            d.setBairroTomador(n.getTomador().getEndereco().getBairro());

            d.setCidadeTomador(UtilCidades.nomeCidade(n.getTomador().getEndereco().getCodigoMunicipio()));

            d.setUfTomador(n.getTomador().getEndereco().getUf());

            d.setCepTomador(n.getTomador().getEndereco().getCep());

            if (n.getTomador().getContato() != null) {
                d.setEmailTomador(n.getTomador().getContato().getEmail());
            }

            d.setDiscriminacaoServicos(n.getServico().getDiscriminacao().replace("&lt;", " ").replace("br /&gt;", " "));

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

    private ArrayList<Rps> lerXML(String path) throws FileNotFoundException {

        XStream xstream = new XStream();
        xstream.autodetectAnnotations(true);
        InputStream is = new FileInputStream(new File(path));
        xstream.alias("Envelope", Envelope.class);
        Envelope retorno = (Envelope) xstream.fromXML(is);

        return retorno.getBody().getRecepcionarLoteRps().getArg().getLoteRps().getListaRps().getListaRps();
    }
    
}
