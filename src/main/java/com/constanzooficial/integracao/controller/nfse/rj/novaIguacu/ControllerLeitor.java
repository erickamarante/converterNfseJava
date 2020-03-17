package com.constanzooficial.integracao.controller.nfse.rj.novaIguacu;

import com.constanzooficial.integracao.model.nfse.rj.novaIguacu.NotaFiscal;
import com.constanzooficial.integracao.model.nfse.rj.novaIguacu.NotasFiscais;
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
 * @author Yuri Fernandes de Oliveira
 */
public class ControllerLeitor {

    public ModelNota lerNotas(String caminhoXml, boolean considerarIss) throws FileNotFoundException {

        NotasFiscais notas = lerXML(caminhoXml);

        double valorTotalServicos = 0;
        double valorTotalDeducoes = 0;
        double valorTotalIss = 0;
        double valorTotalCredito = 0;

        ArrayList<ModelDetalhe> detalhes = new ArrayList<>();
        for (NotaFiscal n : notas.getNotasFiscais()) {

            ModelDetalhe d = new ModelDetalhe();

            d.setNumeroNfse(MyUtils.removeZeroEsquerda(n.getNumNota()));

            String tmp = n.getDataHoraEmissao();
            String[] dataHora = new String[6];
            String[] split = tmp.split(" ");
            split = split[0].split("/");
            dataHora[0] = split[0];
            dataHora[1] = split[1];
            dataHora[2] = split[2];
            split = tmp.split(" ");
            split = split[1].split(":");
            dataHora[3] = split[0];
            dataHora[4] = split[1];
            dataHora[5] = split[2];
            d.setDataHoraNfse(dataHora);

            d.setDataEmissaoRps(dataHora);

            d.setInscricaoMunicipalPrestador(n.getPrestadorInscricaoMunicipal());

            if (n.getPrestadorCpfCnpj().length() == 11) {
                d.setIndicadorCpfCnpjPrestador("1");
            } else {
                d.setIndicadorCpfCnpjPrestador("2");
            }

            d.setCpfCnpjPrestador(n.getPrestadorCpfCnpj());

            d.setRazaoSocialPrestador(n.getPrestadorRazaoSocial());

            String[] endereco = MyUtils.separaTipoEndereco(n.getPrestadorTipoLogradouro() + " " + n.getPrestadorLogradouro());
            d.setTipoEnderecoPrestador(endereco[0]);
            d.setEnderecoPrestador(endereco[1]);

            d.setNumeroEnderecoPrestador(MyUtils.removeZeroEsquerda(n.getPrestadorPrestNumero()));

            d.setComplementoEnderecoPrestador(n.getPrestadorComplemento());

            d.setBairroPrestador(n.getPrestadorBairro());

            d.setCidadePrestador(n.getPrestadorCidade());

            d.setUfPrestador(n.getPrestadorUf());

            d.setCepPrestador(n.getPrestadorCep());

            if (!n.getSituacaoNf().equals("Normal") && !n.getDataHoraCancelamento().replaceAll("0", "").equals("")) {
                d.setSituacaoNotaFiscal("C");
                tmp = n.getDataHoraCancelamento();
                dataHora = new String[6];
                split = tmp.split(" ");
                split = split[0].split("/");
                dataHora[0] = split[0];
                dataHora[1] = split[1];
                dataHora[2] = split[2];
                d.setDataCancelamento(dataHora);
            }

            double valorServico = Double.valueOf(MyUtils.trataValor(n.getValorServico()));
            d.setValorServicos(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorServico));
            if (!d.getSituacaoNotaFiscal().equals("C")) {
                valorTotalServicos += valorServico;
            }

            double valorDeducoes = Double.valueOf(MyUtils.trataValor(n.getValorDeducao()));
            d.setValorDeducoes(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorDeducoes));
            if (!d.getSituacaoNotaFiscal().equals("C")) {
                valorTotalDeducoes += valorDeducoes;
            }

            d.setCodigoServicoPrestadoNotaFiscal(MyUtils.removeZeroEsquerda(n.getCosServico()));

            d.setAliquota(considerarIss ? MyUtils.trataValor(n.getAliquota()) : "0");

            double valorIss = considerarIss ? Double.valueOf(MyUtils.trataValor(n.getValorIss())) : 0;
            if (valorIss == 0) {
                valorIss = considerarIss ? Double.valueOf(MyUtils.trataValor(n.getValorIssRet())) : 0;
            }
            d.setValorIss(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorIss));
            if (!d.getSituacaoNotaFiscal().equals("C")) {
                valorTotalIss += valorIss;
            }

            if (Double.valueOf(MyUtils.trataValor(n.getValorIssRet())) != 0) {
                d.setIssRetido("S");
            } else {
                d.setIssRetido("N");
            }

            if (n.getTomadorCpfCnpj().length() == 11) {
                d.setIndicadorCpfCnpjTomador("1");
            } else {
                d.setIndicadorCpfCnpjTomador("2");
            }

            d.setCpfCnpjTomador(n.getTomadorCpfCnpj());

            d.setRazaoSocialTomador(n.getTomadorRazaoSocial());

            endereco = MyUtils.separaTipoEndereco(n.getTomadorTipoLogradouro() + " " + n.getTomadorLogradouro());
            d.setTipoEnderecoTomador(endereco[0]);
            d.setEnderecoTomador(endereco[1]);

            d.setNumeroEnderecoTomador(MyUtils.removeZeroEsquerda(n.getTomadorNumero()));

            d.setComplementoEnderecoTomador(n.getTomadorComplemento());

            d.setBairroTomador(n.getTomadorBairro());

            d.setCidadeTomador(n.getTomadorCidade());

            d.setUfTomador(n.getTomadorUf());

            d.setCepTomador(n.getTomadorCep());

            d.setEmailTomador(n.getTomadorEmail());

            d.setDiscriminacaoServicos(n.getDescricaoNota());

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

    private NotasFiscais lerXML(String path) throws FileNotFoundException {

        XStream xstream = new XStream();
        xstream.autodetectAnnotations(true);
        InputStream is = new FileInputStream(new File(path));
        xstream.alias("NOTAS_FISCAIS", NotasFiscais.class);
        NotasFiscais retorno = (NotasFiscais) xstream.fromXML(is);

        return retorno;
    }
}
