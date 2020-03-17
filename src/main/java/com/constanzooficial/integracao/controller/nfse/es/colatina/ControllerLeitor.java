package com.constanzooficial.integracao.controller.nfse.es.colatina;

import com.constanzooficial.integracao.model.nfse.es.colatina.Nfse;
import com.constanzooficial.integracao.model.nfse.es.colatina.TcListaNFse;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelCabecalho;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelDetalhe;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelDetalheComparator;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelNota;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelRodape;
import com.constanzooficial.integracao.util.MyUtils;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Waislan Luis Sanches
 */
public class ControllerLeitor {

    public ModelNota lerNotas(String caminhoXml, boolean considerarIss) throws FileNotFoundException {

        TcListaNFse notas = lerXML(caminhoXml);

        double valorTotalServicos = 0;
        double valorTotalDeducoes = 0;
        double valorTotalIss = 0;
        double valorTotalCredito = 0;

        ArrayList<ModelDetalhe> detalhes = new ArrayList<>();
        for (Nfse n : notas.getNotasFiscais()) {

            ModelDetalhe d = new ModelDetalhe();

            /* não precisa desta linha por enquanto
            d.setNumeroNfse(MyUtils.removeZeroEsquerda(n.getNumNota()));
             */
            d.setNumeroNfse(n.getIdentificacaoNfse().getNumero());

            String tmp = n.getDataEmissao();
            String[] dataHora = new String[6];
            String[] split = tmp.split("T");
            split = split[0].split("-");
            dataHora[0] = split[2];
            dataHora[1] = split[1];
            dataHora[2] = split[0];
            split = tmp.split("T");
            split = split[1].split("\\.");
            split = split[0].split(":");
            dataHora[3] = split[0];
            dataHora[4] = split[1];
            dataHora[5] = split[2];

            d.setDataHoraNfse(dataHora);
            d.setDataEmissaoRps(dataHora);

            d.setInscricaoMunicipalPrestador(n.getDadosPrestador().getIdentificacaoPrestador().getInscricaoMunicipal());

            if (n.getDadosPrestador().getIdentificacaoPrestador().getCpfCnpj().length() == 11) {
                d.setIndicadorCpfCnpjPrestador("1");
            } else {
                d.setIndicadorCpfCnpjPrestador("2");
            }

            d.setCpfCnpjPrestador(n.getDadosPrestador().getIdentificacaoPrestador().getCpfCnpj());

            d.setRazaoSocialPrestador(n.getDadosPrestador().getRazaoSocial());

            String[] endereco = MyUtils.separaTipoEndereco(n.getDadosPrestador().getEndereco().getLogradouroTipo()
                    + " " + n.getDadosPrestador().getEndereco().getLogradouro());
            d.setTipoEnderecoPrestador(endereco[0]);
            d.setEnderecoPrestador(endereco[1]);

            /*
            não precisa remover zeros à esquerda por enquanto
            d.setNumeroEnderecoPrestador(MyUtils.removeZeroEsquerda(n.getPrestadorPrestNumero()));
             */
            d.setNumeroEnderecoPrestador(n.getDadosPrestador().getEndereco().getLogradouroNumero());

            d.setComplementoEnderecoPrestador(n.getDadosPrestador().getEndereco().getLogradouroComplemento());

            d.setBairroPrestador(n.getDadosPrestador().getEndereco().getBairro());

            d.setCidadePrestador(n.getDadosPrestador().getEndereco().getMunicipio());

            d.setUfPrestador(n.getDadosPrestador().getEndereco().getUf());

            d.setCepPrestador(n.getDadosPrestador().getEndereco().getCep());

            if (!n.getStatus().equals("1") /* && !n.get.replaceAll("0", "").equals("") */) {
                d.setSituacaoNotaFiscal("C");
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

            double valorServico = Double.valueOf(MyUtils.trataValor(n.getValores().getValorServicos()));
            d.setValorServicos(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorServico));
            if (!d.getSituacaoNotaFiscal().equals("C")) {
                valorTotalServicos += valorServico;
            }

            double valorDeducoes = Double.valueOf(MyUtils.trataValor(n.getValores().getValorDeducoes()));
            d.setValorDeducoes(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorDeducoes));
            if (!d.getSituacaoNotaFiscal().equals("C")) {
                valorTotalDeducoes += valorDeducoes;
            }

            /* não precisa tratar zeros à esquerda por enquanto
            d.setCodigoServicoPrestadoNotaFiscal(MyUtils.removeZeroEsquerda(n.getCosServico()));
             */
            d.setCodigoServicoPrestadoNotaFiscal(n.getServicos().getCodigoServico116().replaceAll("[^0-9]", ""));

            d.setAliquota(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(considerarIss ? MyUtils.trataValor(n.getServicos().getAliquota()) : "0"));

            double valorIss = considerarIss ? Double.valueOf(n.getValores().getValorIss()) : 0;
            d.setValorIss(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorIss));
            if (!d.getSituacaoNotaFiscal().equals("C")) {
                valorTotalIss += valorIss;
            }

            if (Double.valueOf(MyUtils.trataValor(n.getIssRetido())) != 1) {
                d.setIssRetido("S");
            } else {
                d.setIssRetido("N");
            }

            if (n.getDadosTomador().getIdentificacaoTomador().getCpfCnpj().length() == 11) {
                d.setIndicadorCpfCnpjTomador("1");
            } else {
                d.setIndicadorCpfCnpjTomador("2");
            }

            d.setCpfCnpjTomador(n.getDadosTomador().getIdentificacaoTomador().getCpfCnpj());

            d.setRazaoSocialTomador(n.getDadosTomador().getRazaoSocial());

            endereco = MyUtils.separaTipoEndereco(n.getDadosTomador().getEndereco().getLogradouroTipo() + " "
                    + n.getDadosTomador().getEndereco().getLogradouro());
            d.setTipoEnderecoTomador(endereco[0]);
            d.setEnderecoTomador(endereco[1]);

            /* não precisa remover zeros à esquerda por enquanto
            d.setNumeroEnderecoTomador(MyUtils.removeZeroEsquerda(n.getTomadorNumero()));
             */
            d.setNumeroEnderecoTomador(n.getDadosTomador().getEndereco().getLogradouroNumero());

            d.setComplementoEnderecoTomador(n.getDadosTomador().getEndereco().getLogradouroComplemento());

            d.setBairroTomador(n.getDadosTomador().getEndereco().getBairro());

            d.setCidadeTomador(n.getDadosTomador().getEndereco().getMunicipio());

            d.setUfTomador(n.getDadosTomador().getEndereco().getUf());

            d.setCepTomador(n.getDadosTomador().getEndereco().getCep());

            d.setEmailTomador(n.getDadosTomador().getContato().getEmail());

            d.setDiscriminacaoServicos(n.getServicos().getDescricao());

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

    private TcListaNFse lerXML(String path) throws FileNotFoundException {

        XStream xstream = new XStream();
        xstream.autodetectAnnotations(true);
        InputStream is = new FileInputStream(new File(path));
        xstream.alias("tcListaNFse", TcListaNFse.class);
        TcListaNFse retorno = (TcListaNFse) xstream.fromXML(is);

        return retorno;
    }

}
