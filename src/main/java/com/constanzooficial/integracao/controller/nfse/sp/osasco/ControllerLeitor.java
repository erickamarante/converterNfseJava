package com.constanzooficial.integracao.controller.nfse.sp.osasco;

import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelCabecalho;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelDetalhe;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelDetalheComparator;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelNota;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelRodape;
import com.constanzooficial.integracao.model.sp.osasco.NFE;
import com.constanzooficial.integracao.model.sp.osasco.NotaFiscalRelatorioDTO;
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

        NFE notas = lerXML(caminhoXml);

        double valorTotalServicos = 0;
        double valorTotalDeducoes = 0;
        double valorTotalIss = 0;
        double valorTotalCredito = 0;

        ArrayList<ModelDetalhe> detalhes = new ArrayList<>();
        for (NotaFiscalRelatorioDTO n : notas.getNotasFiscais()) {

            ModelDetalhe d = new ModelDetalhe();

        /* não precisa desta linha por enquanto
            d.setNumeroNfse(MyUtils.removeZeroEsquerda(n.getNumNota()));
        */
            d.setNumeroNfse(n.getNumero());

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
            
            d.setInscricaoMunicipalPrestador(n.getPrestador().getInscricaoMunicipal());

            /*
            a princípio não precisa desta verificação
            if (n.getDadosPrestador().getIdentificacaoPrestador().getCpfCnpj().length() == 11){
                d.setIndicadorCpfCnpjPrestador("1");
            } else {
                d.setIndicadorCpfCnpjPrestador("2");
            }
            */
            
            d.setCpfCnpjPrestador(n.getPrestador().getCnpj());

            d.setRazaoSocialPrestador(n.getPrestador().getNome());

            String[] endereco = MyUtils.separaTipoEndereco(n.getPrestador().getEndereco().getTipoLogradouro()
                    + " " + n.getPrestador().getEndereco().getLogradouro());
            d.setTipoEnderecoPrestador(endereco[0]);
            d.setEnderecoPrestador(endereco[1]);

            /*
            não precisa remover zeros à esquerda por enquanto
            d.setNumeroEnderecoPrestador(MyUtils.removeZeroEsquerda(n.getPrestadorPrestNumero()));
            */
            
            d.setNumeroEnderecoPrestador(n.getPrestador().getEndereco().getNumero());
            
            d.setComplementoEnderecoPrestador(n.getPrestador().getEndereco().getComplemento());

            d.setBairroPrestador(n.getPrestador().getEndereco().getBairro());

            d.setCidadePrestador(n.getPrestador().getEndereco().getCidade());

            d.setUfPrestador(n.getPrestador().getEndereco().getEstado());

            d.setCepPrestador(n.getPrestador().getEndereco().getCep());

            /*
            condição que estava antes no if
            !n.getStatus().equals("1") && !n.get.replaceAll("0", "").equals("")
            */
            if (!n.getDataCancelamento().equals("")) {
                d.setSituacaoNotaFiscal("C");
                tmp = n.getDataCancelamento();
                dataHora = new String[6];
                split = tmp.split("-");
                dataHora[2] = split[0];
                dataHora[1] = split[1];
                split = split[2].split("T");
                dataHora[0] = split[0];
                split = split[1].split(":");
                dataHora[3] = split[0];
                dataHora[4] = split[1];
                split = split[2].split("\\.");
                dataHora[5] = split[0];
                d.setDataCancelamento(dataHora);
            }

            double valorServico = Double.valueOf(MyUtils.trataValor(n.getValor()));
            d.setValorServicos(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorServico));
            if (!d.getSituacaoNotaFiscal().equals("C")){
                valorTotalServicos += valorServico;
            }

            double valorDeducoes = Double.valueOf(MyUtils.trataValor(n.getValorDeducao()));
            d.setValorDeducoes(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorDeducoes));
            if (!d.getSituacaoNotaFiscal().equals("C")) {
                valorTotalDeducoes += valorDeducoes;
            }

            /* não precisa tratar zeros à esquerda por enquanto
            d.setCodigoServicoPrestadoNotaFiscal(MyUtils.removeZeroEsquerda(n.getCosServico()));
            */

            d.setCodigoServicoPrestadoNotaFiscal(n.getDescricaoAtividade().replaceAll("[^0-9]", ""));

            d.setAliquota(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(considerarIss ? MyUtils.trataValor(n.getAliquota()) : "0"));

            double valorIss = considerarIss ? Double.valueOf(n.getValorIss()) : 0;
            /* não precisa desta verificação por enquanto
            if (valorIss == 0) {
                valorIss = Double.valueOf(n.getIssRetido());
            }
            */
            d.setValorIss(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorIss));
            if (!d.getSituacaoNotaFiscal().equals("C")) {
                valorTotalIss += valorIss;
            }

            if (!n.getSubstituicaoTributaria().equals("false")) {
                d.setIssRetido("S");
            } else {
                d.setIssRetido("N");
            }

            if (n.getTomador().getCnpj() == null) {
                d.setIndicadorCpfCnpjTomador("1");
                d.setCpfCnpjTomador(n.getTomador().getCpf());
            } else {
                d.setIndicadorCpfCnpjTomador("2");
                d.setCpfCnpjTomador(n.getTomador().getCnpj());
            }             

            d.setRazaoSocialTomador(n.getTomador().getNome());
            
            d.setInscricaoMunicipalTomador(n.getTomador().getInscricaoMunicipal());

            endereco = MyUtils.separaTipoEndereco(n.getTomador().getEndereco().getTipoLogradouro() + " "
                    + n.getTomador().getEndereco().getLogradouro());
            d.setTipoEnderecoTomador(endereco[0]);
            d.setEnderecoTomador(endereco[1]);

            /* não precisa remover zeros à esquerda por enquanto
            d.setNumeroEnderecoTomador(MyUtils.removeZeroEsquerda(n.getTomadorNumero()));
            */
            d.setNumeroEnderecoTomador(n.getTomador().getEndereco().getNumero());
            
            d.setComplementoEnderecoTomador(n.getTomador().getEndereco().getComplemento());

            d.setBairroTomador(n.getTomador().getEndereco().getBairro());

            d.setCidadeTomador(n.getTomador().getEndereco().getCidade());

            d.setUfTomador(n.getTomador().getEndereco().getEstado());

            d.setCepTomador(n.getTomador().getEndereco().getCep());

            d.setEmailTomador(n.getTomador().getEmail());

            d.setDiscriminacaoServicos(n.getDescricaoServicos().replace("\n", ""));

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
    
    private NFE lerXML(String path) throws FileNotFoundException {

        XStream xstream = new XStream();
        xstream.autodetectAnnotations(true);
        InputStream is = new FileInputStream(new File(path));
        xstream.alias("NFE", NFE.class);
        NFE retorno = (NFE) xstream.fromXML(is);

        return retorno;
    }
    
}
