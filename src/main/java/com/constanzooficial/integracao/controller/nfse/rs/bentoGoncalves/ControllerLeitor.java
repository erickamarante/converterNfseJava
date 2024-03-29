package com.constanzooficial.integracao.controller.nfse.rs.bentoGoncalves;

import com.constanzooficial.integracao.model.nfse.rs.bentoGoncalves.CompNfse;
import com.constanzooficial.integracao.model.nfse.rs.bentoGoncalves.ConsultarNfseResposta;
import com.constanzooficial.integracao.model.nfse.rs.bentoGoncalves.Nfse;
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
 * @author Yuri Fernandes de Oliveira
 */
public class ControllerLeitor {

    public ModelNota lerNotas(String caminhoXml, boolean considerarIss) throws FileNotFoundException, Exception {

        ArrayList<CompNfse> notas = lerXML(caminhoXml);

        double valorTotalServicos = 0;
        double valorTotalDeducoes = 0;
        double valorTotalIss = 0;
        double valorTotalCredito = 0;

        ArrayList<ModelDetalhe> detalhes = new ArrayList<>();
        for (CompNfse c : notas) {

            ModelDetalhe d = new ModelDetalhe();
            Nfse n = c.getNfse();

            /* não precisa desta linha por enquanto
            d.setNumeroNfse(MyUtils.removeZeroEsquerda(n.getNumNota()));
             */
            d.setNumeroNfse(n.getInfNfse().getNumero());

            d.setDataHoraNfse(n.getInfNfse().getDataEmissao());

            d.setDataEmissaoRps(n.getInfNfse().getDataEmissao());

            d.setInscricaoMunicipalPrestador(n.getInfNfse().getPrestadorServico().getIdentificacaoPrestador().getInscricaoMunicipal());

            d.setIndicadorCpfCnpjPrestador("2");
            
            d.setCpfCnpjPrestador(n.getInfNfse().getPrestadorServico().getIdentificacaoPrestador().getCnpj());

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

            d.setCepPrestador(n.getInfNfse().getPrestadorServico().getEndereco().getCep());
            
            d.setEmailPrestador(n.getInfNfse().getPrestadorServico().getContato().getEmail());
            
            d.setOpcaoPeloSimples(n.getInfNfse().getOptanteSimplesNacional() ? "4" : "0");

            if (c.getNfseCancelamento().getConfirmacao().getInfConfirmacaoCancelamento().getSucesso().equals("true") /* && !n.get.replaceAll("0", "").equals("") */) {
                d.setSituacaoNotaFiscal("C");
                d.setDataCancelamento(c.getNfseCancelamento().getConfirmacao().getInfConfirmacaoCancelamento().getDataHora());
            }

            if (!c.getNfseSubstituicao().getSubstituicaoNfse().equals("")) {
                throw new Exception("Notas substituidas detectadas. Favor solicitar correção do conversor.");
                // d.setSituacaoNotaFiscal("S");
            }

            double valorServico = Double.valueOf(MyUtils.trataValor(n.getInfNfse().getServico().getValores().getValorServicos()));
            d.setValorServicos(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorServico));
            if (!d.getSituacaoNotaFiscal().equals("C") && !d.getSituacaoNotaFiscal().equals("S")) {
                valorTotalServicos += valorServico;
            }

            double valorDeducoes = Double.valueOf(MyUtils.trataValor(n.getInfNfse().getServico().getValores().getValorDeducoes()));
            d.setValorDeducoes(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorDeducoes));
            if (!d.getSituacaoNotaFiscal().equals("C") && !d.getSituacaoNotaFiscal().equals("S")) {
                valorTotalDeducoes += valorDeducoes;
            }

            /* não precisa tratar zeros à esquerda por enquanto
            d.setCodigoServicoPrestadoNotaFiscal(MyUtils.removeZeroEsquerda(n.getCosServico()));
             */
            d.setCodigoServicoPrestadoNotaFiscal(n.getInfNfse().getServico().getItemListaServico().replaceAll("[^0-9]", ""));

            d.setAliquota(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(considerarIss ? MyUtils.trataValor(n.getInfNfse().getServico().getValores().getAliquota()) : "0"));

            double valorIss = considerarIss ? Double.valueOf(n.getInfNfse().getServico().getValores().getValorIss()) : 0;
            d.setValorIss(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorIss));
            if (!d.getSituacaoNotaFiscal().equals("C") && !d.getSituacaoNotaFiscal().equals("S")) {
                valorTotalIss += valorIss;
            }

            if (n.getInfNfse().getServico().getValores().getIssRetido().equals("1")) {
                d.setIssRetido("S");
            } else {
                d.setIssRetido("N");
            }

            if (n.getInfNfse().getTomadorServico().getIdentificacaoTomador().getCpfCnpj().getCpf() != null) {
                d.setIndicadorCpfCnpjTomador("1");
                d.setCpfCnpjTomador(n.getInfNfse().getTomadorServico().getIdentificacaoTomador().getCpfCnpj().getCpf());
            } else {
                d.setIndicadorCpfCnpjTomador("2");
                d.setCpfCnpjTomador(n.getInfNfse().getTomadorServico().getIdentificacaoTomador().getCpfCnpj().getCnpj());
            }
            
            d.setInscricaoMunicipalTomador(n.getInfNfse().getTomadorServico().getIdentificacaoTomador().getInscricaoMunicipal());

            d.setRazaoSocialTomador(n.getInfNfse().getTomadorServico().getRazaoSocial());

            endereco = MyUtils.separaTipoEndereco(n.getInfNfse().getTomadorServico().getEndereco().getEndereco());
            d.setTipoEnderecoTomador(endereco[0]);
            d.setEnderecoTomador(endereco[1]);

            /* não precisa remover zeros à esquerda por enquanto
            d.setNumeroEnderecoTomador(MyUtils.removeZeroEsquerda(n.getTomadorNumero()));
             */
            d.setNumeroEnderecoTomador(n.getInfNfse().getTomadorServico().getEndereco().getNumero());

            d.setComplementoEnderecoTomador(n.getInfNfse().getTomadorServico().getEndereco().getComplemento());

            d.setBairroTomador(n.getInfNfse().getTomadorServico().getEndereco().getBairro());

            d.setCidadeTomador(UtilCidades.nomeCidade(n.getInfNfse().getTomadorServico().getEndereco().getCodigoMunicipio()));

            d.setUfTomador(n.getInfNfse().getTomadorServico().getEndereco().getUf());

            d.setCepTomador(n.getInfNfse().getTomadorServico().getEndereco().getCep());

            if (n.getInfNfse().getTomadorServico().getContato() != null) {
                d.setEmailTomador(n.getInfNfse().getTomadorServico().getContato().getEmail());
            }

            d.setDiscriminacaoServicos(n.getInfNfse().getServico().getDiscriminacao().replace("&lt;", " ").replace("br /&gt;", " "));

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

    private ArrayList<CompNfse> lerXML(String path) throws FileNotFoundException {

        XStream xstream = new XStream();
        xstream.autodetectAnnotations(true);
        InputStream is = new FileInputStream(new File(path));
        xstream.alias("ConsultarNfseResposta", ConsultarNfseResposta.class);
        ConsultarNfseResposta retorno = (ConsultarNfseResposta) xstream.fromXML(is);

        return retorno.getListaNfse().getListaNfse();
    }

}
