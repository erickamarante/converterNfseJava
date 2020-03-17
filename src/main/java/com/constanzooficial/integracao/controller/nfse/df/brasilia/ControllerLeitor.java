package com.constanzooficial.integracao.controller.nfse.df.brasilia;

import com.constanzooficial.integracao.model.nfse.df.brasilia.NfeProc;
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
        ArrayList<NfeProc> notas = lerXMLs(arquivos);

        double valorTotalServicos = 0;
        double valorTotalDeducoes = 0;
        double valorTotalIss = 0;
        double valorTotalCredito = 0;

        ArrayList<ModelDetalhe> detalhes = new ArrayList<>();

        for (NfeProc n : notas) {
            //System.out.println(n.getNfe().getInfNfe().getId());
            ModelDetalhe d = new ModelDetalhe();
            /* não precisa desta linha por enquanto
            d.setNumeroNfse(MyUtils.removeZeroEsquerda(n.getNumNota()));
             */

            if (n.getNfe() != null) {
                // nota não cancelada
                d.setNumeroNfse(n.getNfe().getInfNfe().getIde().getnumeroNfe());

                d.setDataHoraNfse(n.getNfe().getInfNfe().getIde().getDataHoraEmissao());

                d.setDataEmissaoRps(n.getNfe().getInfNfe().getIde().getDataHoraEmissao());

                d.setInscricaoMunicipalPrestador(n.getNfe().getInfNfe().getEmit().getInscricaoMunicipal());
                /*
                if (n.getCpfCnpjPrestador().length() == 11) {
                    d.setIndicadorCpfCnpjPrestador("1");
                } else {
                    d.setIndicadorCpfCnpjPrestador("2");
                }
                 */
                d.setIndicadorCpfCnpjPrestador("2");
                d.setCpfCnpjPrestador(n.getNfe().getInfNfe().getEmit().getCnpj());

                d.setRazaoSocialPrestador(n.getNfe().getInfNfe().getEmit().getRazaoSocial());
                /*
                d.setTipoEnderecoPrestador(endereco[0]);
                 */
                d.setEnderecoPrestador(n.getNfe().getInfNfe().getEmit().getEnderEmit().getLogradouro());
                /*
                não precisa remover zeros à esquerda por enquanto
                d.setNumeroEnderecoPrestador(MyUtils.removeZeroEsquerda(n.getPrestadorPrestNumero()));
                 */
                d.setNumeroEnderecoPrestador(n.getNfe().getInfNfe().getEmit().getEnderEmit().getNumero());
                /*
                d.setComplementoEnderecoPrestador(n.getInfNfse().getPrestadorServico().getEndereco().getComplemento());
                 */
                d.setBairroPrestador(n.getNfe().getInfNfe().getEmit().getEnderEmit().getBairro());

                d.setCidadePrestador(UtilCidades.nomeCidade(n.getNfe().getInfNfe().getEmit().getEnderEmit().getCodigoMunicipio()));

                d.setUfPrestador(n.getNfe().getInfNfe().getEmit().getEnderEmit().getUf());

                d.setCepPrestador(n.getNfe().getInfNfe().getEmit().getEnderEmit().getCep());
                /*
                d.setEmailPrestador(n.getInfNfse().getPrestadorServico().getContato().getEmail());
                 */
                if (n.getNfe().getInfNfe().getInfAdic() != null) {
                    if (n.getNfe().getInfNfe().getInfAdic().getInfCpl().contains("OPTANTE PELO SIMPLES NACIONAL")) {
                        d.setOpcaoPeloSimples("4");
                    } else {
                        d.setOpcaoPeloSimples("0");
                    }
                }
                /*
                if (n.getSituacao().equals("Cancelada") /* && !n.get.replaceAll("0", "").equals("")) {
                    d.setSituacaoNotaFiscal("C");
                    d.setDataCancelamento(c.getNfseCancelamento().getConfirmacao().getInfConfirmacaoCancelamento().getDataHora());
                }
                if (!n.getSituacao().equals("Emitida") && !n.getSituacao().equals("Cancelada")){
                    throw new Exception("Favor contatar o administrador.");
                }

                if (!c.getNfseSubstituicao().getSubstituicaoNfse().equals("")) {
                    throw new Exception("Notas substituidas detectadas. Favor solicitar correção do conversor.");
                    // d.setSituacaoNotaFiscal("S");
                }
                 */
//                System.out.println("id: " + n.getNfe().getInfNfe().getId() + " ");
//                System.out.println("vServ: " + Double.valueOf(n.getNfe().getInfNfe().getTotal().getIssQnTotal().getvServ()));

                double valorServicos;
                if (n.getNfe().getInfNfe().getTotal().getIssQnTotal() != null){
                    valorServicos = Double.valueOf(n.getNfe().getInfNfe().getTotal().getIssQnTotal().getvServ());
                } else {
                    valorServicos = Double.valueOf(n.getNfe().getInfNfe().getTotal().getIcmsTotal().getvProd());
                }
                

                d.setValorServicos(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorServicos));
                /*
                if (!d.getSituacaoNotaFiscal().equals("C") && !d.getSituacaoNotaFiscal().equals("S")) {
                    valorTotalServicos += valorServico;
                }
                 */
                valorTotalServicos += valorServicos;
                /*
                double valorDeducoes = Double.valueOf(n.getValorTotalDeducoes());
                d.setValorDeducoes(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorDeducoes));
                if (!d.getSituacaoNotaFiscal().equals("C") && !d.getSituacaoNotaFiscal().equals("S")) {
                    valorTotalDeducoes += valorDeducoes;
                }

                /* não precisa tratar zeros à esquerda por enquanto
                d.setCodigoServicoPrestadoNotaFiscal(MyUtils.removeZeroEsquerda(n.getCosServico()));
                 */

                d.setCodigoServicoPrestadoNotaFiscal(n.getNfe().getInfNfe().getDet().get(0).getProduto().getCodigoServico());

                d.setAliquota(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(2));

                double valorIss = 0;

                if (considerarIss) {
                    /*
                    double aliquota = Double.valueOf(n.getNfe().getInfNfe().getDet().getImposto().getIssQn().getAliquota());
                    valorIss = aliquota * valorServico;
                    d.setValorIss(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorIss));
                     */
                    d.setValorIss(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(Double.valueOf(n.getNfe().getInfNfe().getTotal().getIssQnTotal().getvIss())));
                } else {
                    d.setValorIss(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(0));
                }
                /*
                if (!d.getSituacaoNotaFiscal().equals("C") && !d.getSituacaoNotaFiscal().equals("S")) {
                    valorTotalIss += valorIss;
                }
                 */
                valorTotalIss += valorIss;
                /*
                if (Double.valueOf(c.getItens().getLista().get(0).getValorIssrf().replace(",", ".")) != 0) {
                    d.setIssRetido("S");
                } else {
                    d.setIssRetido("N");
                }
                 */
                if (n.getNfe().getInfNfe().getDest().getCpf() != null) {
                    d.setIndicadorCpfCnpjTomador("1");
                    d.setCpfCnpjTomador(n.getNfe().getInfNfe().getDest().getCpf());
                } else {
                    d.setIndicadorCpfCnpjTomador("2");
                    d.setCpfCnpjTomador(n.getNfe().getInfNfe().getDest().getCnpj());
                }

                /*
                d.setInscricaoMunicipalTomador(n.getClienteInscricaoMunicipal());
                 */
                d.setRazaoSocialTomador(n.getNfe().getInfNfe().getDest().getNome());
                /*
                d.setTipoEnderecoTomador(endereco[0]);
                 */
                d.setEnderecoTomador(n.getNfe().getInfNfe().getDest().getEnderecoDest().getLogradouro());

                d.setNumeroEnderecoTomador(n.getNfe().getInfNfe().getDest().getEnderecoDest().getNumero());
                /*
                d.setComplementoEnderecoTomador(c.getTomador().getComplemento());
                 */
                d.setBairroTomador(n.getNfe().getInfNfe().getDest().getEnderecoDest().getBairro());

                d.setCidadeTomador(UtilCidades.nomeCidade(n.getNfe().getInfNfe().getDest().getEnderecoDest().getCodigoMunicipio()));

                d.setUfTomador(n.getNfe().getInfNfe().getDest().getEnderecoDest().getUf());

                if (n.getNfe().getInfNfe().getDest().getIndIeDest().equals("1")) {
                    d.setInscricaoEstadualTomador(n.getNfe().getInfNfe().getDest().getIe());
                }
                /*
                d.setCepTomador(n.getNfe().getInfNfe().getDest().getEnderecoDest().getCep());

                if (c.getTomador().getEmail() != null) {
                    d.setEmailTomador(c.getTomador().getEmail());
                }

                d.setDiscriminacaoServicos(n.getInfNfse().getServico().getDiscriminacao().replace("&lt;", " ").replace("br /&gt;", " "));
                 */
                detalhes.add(d);
            } else {
                // nota cancelada
                d.setNumeroNfse(n.getEvento().getInfEvento().getChNFe());

                d.setDataHoraNfse(n.getEvento().getInfEvento().getDhEvento());

                d.setDataEmissaoRps(n.getEvento().getInfEvento().getDhEvento());

                /*
                d.setInscricaoMunicipalPrestador(n.getNfe().getInfNfe().getEmit().getInscricaoMunicipal());
                if (n.getCpfCnpjPrestador().length() == 11) {
                    d.setIndicadorCpfCnpjPrestador("1");
                } else {
                    d.setIndicadorCpfCnpjPrestador("2");
                }
                 */
                d.setIndicadorCpfCnpjPrestador("2");
                d.setCpfCnpjPrestador(n.getEvento().getInfEvento().getCnpj());

                /*
                d.setRazaoSocialPrestador(n.getNfe().getInfNfe().getEmit().getRazaoSocial());
                d.setTipoEnderecoPrestador(endereco[0]);
                d.setEnderecoPrestador(n.getNfe().getInfNfe().getEmit().getEnderEmit().getLogradouro());
                não precisa remover zeros à esquerda por enquanto
                d.setNumeroEnderecoPrestador(MyUtils.removeZeroEsquerda(n.getPrestadorPrestNumero()));
                d.setNumeroEnderecoPrestador(n.getNfe().getInfNfe().getEmit().getEnderEmit().getNumero());
                d.setComplementoEnderecoPrestador(n.getInfNfse().getPrestadorServico().getEndereco().getComplemento());
                d.setBairroPrestador(n.getNfe().getInfNfe().getEmit().getEnderEmit().getBairro());
                 */
                d.setCidadePrestador(UtilCidades.nomeCidade(5300108));

                d.setUfPrestador("DF");

                /*
                d.setCepPrestador(n.getNfe().getInfNfe().getEmit().getEnderEmit().getCep());
                d.setEmailPrestador(n.getInfNfse().getPrestadorServico().getContato().getEmail());
           
                if (n.getNfe().getInfNfe().getInfAdic().getInfCpl().contains("EMPRESA OPTANTE PELO SIMPLES NACIONAL")) {
                    d.setOpcaoPeloSimples("4");
                } else {
                    d.setOpcaoPeloSimples("0");
                }
                 */
                d.setSituacaoNotaFiscal("C");
                /*
                d.setDataCancelamento(c.getNfseCancelamento().getConfirmacao().getInfConfirmacaoCancelamento().getDataHora());
                double valorServico = Double.valueOf(n.getNfe().getInfNfe().getDet().getProduto().getValorProduto());
                d.setValorServicos(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorServico));
                if (!d.getSituacaoNotaFiscal().equals("C") && !d.getSituacaoNotaFiscal().equals("S")) {
                    valorTotalServicos += valorServico;
                }

                valorTotalServicos += valorServico;
                double valorDeducoes = Double.valueOf(n.getValorTotalDeducoes());
                d.setValorDeducoes(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorDeducoes));
                if (!d.getSituacaoNotaFiscal().equals("C") && !d.getSituacaoNotaFiscal().equals("S")) {
                    valorTotalDeducoes += valorDeducoes;
                }
                d.setCodigoServicoPrestadoNotaFiscal(n.getNfe().getInfNfe().getDet().getProduto().getProduto());
                 

                d.setAliquota(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(considerarIss ? MyUtils.trataValor(n.getNfe().getInfNfe().getDet().getImposto().getIssQn().getAliquota()) : "0"));

                double valorIss = 0;

                if (considerarIss) {
                    
                double aliquota = Double.valueOf(n.getNfe().getInfNfe().getDet().getImposto().getIssQn().getAliquota());
                valorIss = aliquota * valorServico;
                d.setValorIss(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorIss));
                     
                    d.setValorIss(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(Double.valueOf(n.getNfe().getInfNfe().getDet().getImposto().getIssQn().getValorIssQn())));
                } else {
                    //valorIss = 0;
                    d.setValorIss(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorIss));
                }
                
                if (!d.getSituacaoNotaFiscal().equals("C") && !d.getSituacaoNotaFiscal().equals("S")) {
                    valorTotalIss += valorIss;
                }
                 
                valorTotalIss += valorIss;
                
                if (Double.valueOf(c.getItens().getLista().get(0).getValorIssrf().replace(",", ".")) != 0) {
                    d.setIssRetido("S");
                } else {
                    d.setIssRetido("N");
                }
                 */
                d.setIndicadorCpfCnpjTomador("2");
                d.setCpfCnpjTomador(n.getRetEvento().getInfEvento().getCnpjDest());
                /*
                d.setInscricaoMunicipalTomador(n.getClienteInscricaoMunicipal());
                 
                d.setRazaoSocialTomador(n.getNfe().getInfNfe().getDest().getNome());
                
                d.setTipoEnderecoTomador(endereco[0]);
                 
                d.setEnderecoTomador(n.getNfe().getInfNfe().getDest().getEnderecoDest().getLogradouro());

                d.setNumeroEnderecoTomador(n.getNfe().getInfNfe().getDest().getEnderecoDest().getNumero());
                
                d.setComplementoEnderecoTomador(c.getTomador().getComplemento());
                 
                d.setBairroTomador(n.getNfe().getInfNfe().getDest().getEnderecoDest().getBairro());
                 */
                d.setCidadeTomador(UtilCidades.nomeCidade(5300108));

                d.setUfTomador("DF");
                /*
                d.setCepTomador(n.getNfe().getInfNfe().getDest().getEnderecoDest().getCep());

                if (c.getTomador().getEmail() != null) {
                    d.setEmailTomador(c.getTomador().getEmail());
                }

                d.setDiscriminacaoServicos(n.getInfNfse().getServico().getDiscriminacao().replace("&lt;", " ").replace("br /&gt;", " "));
                 */
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
    public ArrayList<NfeProc> lerXMLs(File[] xmls) throws IOException {
        ArrayList<NfeProc> retorno = new ArrayList<>();

        for (File f : xmls) {
            String xml = UtilFile.fileToStringInline(new File(f.getAbsolutePath()));
            //System.out.println(f.getName());

            XStream xstream = new XStream();

            if (!f.getAbsolutePath().contains("retInut")) {
                xml = xml.replace("<Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"></Transform><Transform Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"></Transform>", "");
                xml = xml.replace("<Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\" /><Transform Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\" />", "");
                xml = xml.replace("<Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"/><Transform Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/>", "");

                xml = xml.replace("procEventoNFe", "nfeProc");

                xstream.autodetectAnnotations(true);

                InputStream is = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));

                xstream.alias("nfeProc", NfeProc.class);

                NfeProc nfse = (NfeProc) xstream.fromXML(is);
                retorno.add(nfse);
            }
        }
        return retorno;
    }
}
