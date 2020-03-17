package com.constanzooficial.integracao.controller.nfse.ba.vitoriaDaConquista;

import com.constanzooficial.integracao.model.nfse.ba.vitoriaDaConquista.CompNfse;
import com.constanzooficial.integracao.model.nfse.ba.vitoriaDaConquista.ConsultarNfseResposta;
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

        //ArrayList<File> xmls = converterParaXMLLegivel(arquivos);
        ArrayList<CompNfse> notas = lerXMLs(arquivos);

        double valorTotalServicos = 0;
        double valorTotalDeducoes = 0;
        double valorTotalIss = 0;
        double valorTotalCredito = 0;

        ArrayList<ModelDetalhe> detalhes = new ArrayList<>();

        for (CompNfse c : notas) {
            System.out.println(c.getNfse().getInfNfse().getNumero());
            ModelDetalhe d = new ModelDetalhe();
            /* não precisa desta linha por enquanto
            d.setNumeroNfse(MyUtils.removeZeroEsquerda(n.getNumNota()));
             */

            d.setNumeroNfse(c.getNfse().getInfNfse().getNumero());

            d.setDataHoraNfse(c.getNfse().getInfNfse().getDataEmissao());

            d.setDataEmissaoRps(c.getNfse().getInfNfse().getDataEmissao());

            d.setInscricaoMunicipalPrestador(c.getNfse().getInfNfse().getPrestadorServico().getIdentificacaoPrestador().getInscricaoMunicipal());
            /*
            if (n.getCpfCnpjPrestador().length() == 11) {
                d.setIndicadorCpfCnpjPrestador("1");
            } else {
                d.setIndicadorCpfCnpjPrestador("2");
            }
             */
            d.setCpfCnpjPrestador(c.getNfse().getInfNfse().getPrestadorServico().getIdentificacaoPrestador().getCnpj());

            d.setRazaoSocialPrestador(c.getNfse().getInfNfse().getPrestadorServico().getRazaoSocial());
            /*
            d.setTipoEnderecoPrestador(endereco[0]);
             */
            d.setEnderecoPrestador(c.getNfse().getInfNfse().getPrestadorServico().getEndereco().getEndereco());
            /*
            não precisa remover zeros à esquerda por enquanto
            d.setNumeroEnderecoPrestador(MyUtils.removeZeroEsquerda(n.getPrestadorPrestNumero()));
             */
            d.setNumeroEnderecoPrestador(c.getNfse().getInfNfse().getPrestadorServico().getEndereco().getNumero());

            d.setComplementoEnderecoPrestador(c.getNfse().getInfNfse().getPrestadorServico().getEndereco().getComplemento());

            d.setBairroPrestador(c.getNfse().getInfNfse().getPrestadorServico().getEndereco().getBairro());

            d.setCidadePrestador(UtilCidades.nomeCidade(c.getNfse().getInfNfse().getPrestadorServico().getEndereco().getCodigoMunicipio()));

            d.setUfPrestador(c.getNfse().getInfNfse().getPrestadorServico().getEndereco().getUf());

            d.setCepPrestador(c.getNfse().getInfNfse().getPrestadorServico().getEndereco().getCep());

            d.setEmailPrestador(c.getNfse().getInfNfse().getPrestadorServico().getContato().getEmail());

            if (c.getNfse().getInfNfse().getOptanteSimplesNacional()) {
                d.setOpcaoPeloSimples("4");
            } else {
                d.setOpcaoPeloSimples("0");
            }

            if (c.getNfseCancelamento() != null /* && !n.get.replaceAll("0", "").equals("") */) {
                d.setSituacaoNotaFiscal("C");
                d.setDataCancelamento(c.getNfseCancelamento().getConfirmacao().getDataHora());
            }
            /*
            if (!n.getSituacao().equals("Emitida") && !n.getSituacao().equals("Cancelada")){
                throw new Exception("Favor contatar o administrador.");
            }

            if (!c.getNfseSubstituicao().getSubstituicaoNfse().equals("")) {
                throw new Exception("Notas substituidas detectadas. Favor solicitar correção do conversor.");
                // d.setSituacaoNotaFiscal("S");
            }
             */
            double valorServico = Double.valueOf(c.getNfse().getInfNfse().getServico().getValores().getValorServicos());
            d.setValorServicos(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorServico));

            if (c.getNfseCancelamento() == null /* && !d.getSituacaoNotaFiscal().equals("S") */) {
                valorTotalServicos += valorServico;
            }
            /*
            double valorDeducoes = Double.valueOf(n.getValorTotalDeducoes());
            d.setValorDeducoes(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorDeducoes));
            if (!d.getSituacaoNotaFiscal().equals("C") && !d.getSituacaoNotaFiscal().equals("S")) {
                valorTotalDeducoes += valorDeducoes;
            }

            /* não precisa tratar zeros à esquerda por enquanto
            d.setCodigoServicoPrestadoNotaFiscal(MyUtils.removeZeroEsquerda(n.getCosServico()));
             */
            d.setCodigoServicoPrestadoNotaFiscal(c.getNfse().getInfNfse().getServico().getItemListaServico());

            d.setAliquota(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(considerarIss ? MyUtils.trataValor(c.getNfse().getInfNfse().getServico().getValores().getValorIss()) : "0"));

            double valorIss = 0;

            if (considerarIss) {
                double aliquota = Double.valueOf(c.getNfse().getInfNfse().getServico().getValores().getAliquota());
                valorIss = aliquota * valorServico;
                d.setValorIss(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorIss));
            } else {
                d.setValorIss(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorIss));
            }

            if (c.getNfseCancelamento() == null /* && !d.getSituacaoNotaFiscal().equals("S") */) {
                valorTotalIss += valorIss;
            }

            if (Double.valueOf(c.getNfse().getInfNfse().getServico().getValores().getIssRetido()) != 0) {
                d.setIssRetido("S");
            } else {
                d.setIssRetido("N");
            }

            d.setIndicadorCpfCnpjTomador("1");
            d.setCpfCnpjTomador(c.getNfse().getInfNfse().getTomadorServico().getIdentificacaoTomador().getCpfCnpj().getCpf());

            //d.setInscricaoMunicipalTomador(c.getNfse().getInfNfse().getTomadorServico());
            d.setRazaoSocialTomador(c.getNfse().getInfNfse().getTomadorServico().getRazaoSocial());
            /*
            d.setTipoEnderecoTomador(endereco[0]);
             */

            if (c.getNfse().getInfNfse().getTomadorServico().getEndereco() != null) {
                d.setEnderecoTomador(c.getNfse().getInfNfse().getTomadorServico().getEndereco().getEndereco());

                d.setNumeroEnderecoTomador(c.getNfse().getInfNfse().getTomadorServico().getEndereco().getNumero());

                d.setComplementoEnderecoTomador(c.getNfse().getInfNfse().getTomadorServico().getEndereco().getComplemento());

                d.setBairroTomador(c.getNfse().getInfNfse().getTomadorServico().getEndereco().getBairro());

                d.setCidadeTomador(UtilCidades.nomeCidade(c.getNfse().getInfNfse().getTomadorServico().getEndereco().getCodigoMunicipio()));

                d.setUfTomador(c.getNfse().getInfNfse().getTomadorServico().getEndereco().getUf());

                d.setCepTomador(c.getNfse().getInfNfse().getTomadorServico().getEndereco().getCep());
            }

            /*
            if (c.getNfse().getInfNfse().getTomadorServico().getContato().getEmail().){
                d.setEmailTomador(c.getNfse().getInfNfse().getTomadorServico().getContato().getEmail());
            }
             */
            d.setDiscriminacaoServicos(c.getNfse().getInfNfse().getServico().getDiscriminacao());

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

    /*
    private ArrayList<File> converterParaXMLLegivel(File[] files) throws IOException {
        ArrayList<File> retorno = new ArrayList<>();
        boolean flag;

        for (File f : files) {

            File newFile = new File(f.getAbsolutePath().replace(".xml", ""));
            Scanner in;
            try (FileWriter fw = new FileWriter(newFile)) {
                in = new Scanner(new FileReader(f.getAbsoluteFile()));
                flag = false;
                while (in.hasNextLine()) {
                    String line = in.nextLine();

                    if (line.contains("Transform ") && !flag) {
                        flag = true;
                    } else if (line.contains("Transform ") && flag) {
                        fw.write(System.getProperty("line.separator"));
                    } else {
                        fw.write(line + System.getProperty("line.separator"));
                    }
                }
            }

            retorno.add(newFile);

            in.close();
            f.delete();
        }

        return retorno;
    }
     */
    public ArrayList<CompNfse> lerXMLs(File[] xmls) throws IOException {
        ArrayList<CompNfse> retorno = new ArrayList<>();

        for (File f : xmls) {
            //System.out.println("" + f.getAbsolutePath());
            String xml = UtilFile.fileToStringInline(new File(f.getAbsolutePath()));
            xml = xml.replace("<Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\" />", "");
            xml = xml.replace("<Transform Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\" />", "");

            //System.out.println("" + xml);
            XStream xstream = new XStream();
            xstream.autodetectAnnotations(true);

            InputStream is = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));

            xstream.alias("ConsultarNfseResposta", ConsultarNfseResposta.class);

            ConsultarNfseResposta consultarNfseResposta = (ConsultarNfseResposta) xstream.fromXML(is);

            retorno.addAll(consultarNfseResposta.getListaNfse().getListaNfse());

        }
        return retorno;
    }
}
