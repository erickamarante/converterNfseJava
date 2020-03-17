package com.constanzooficial.integracao.controller.nfse.pi.saoRaimundoNonato;

import com.constanzooficial.integracao.model.nfse.pi.saoRaimundoNonato.Nfse;
import com.constanzooficial.integracao.model.nfse.pi.saoRaimundoNonato.Table;
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
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Waislan Luis Sanches
 */
public class ControllerLeitor {

    public ModelNota lerNotas(File[] arquivos, boolean considerarIss, String cnpjPrestador) throws IOException, Exception {

        ArrayList<File> xmls = converterParaXMLLegivel(arquivos);
        ArrayList<Nfse> notas = lerXMLs(xmls);

        double valorTotalServicos = 0;
        double valorTotalDeducoes = 0;
        double valorTotalIss = 0;
        double valorTotalCredito = 0;

        ArrayList<ModelDetalhe> detalhes = new ArrayList<>();

        for (Nfse n : notas) {

            ModelDetalhe d = new ModelDetalhe();
            //NotaFiscal n = c.getNf();

            /* não precisa desta linha por enquanto
            d.setNumeroNfse(MyUtils.removeZeroEsquerda(n.getNumNota()));
             */
            d.setNumeroNfse(n.getNumero());

            d.setDataHoraNfse(n.getDataEmissao());

            d.setDataEmissaoRps(n.getDataEmissao());
            
            //d.setInscricaoMunicipalPrestador(n.getInfNfse().getPrestadorServico().getIdentificacaoPrestador().getInscricaoMunicipal());
            
//            if (n.getCpfCnpjPrestador().length() == 11) {
//                d.setIndicadorCpfCnpjPrestador("1");
//            } else {
                d.setIndicadorCpfCnpjPrestador("2");
//            }

//            d.setCpfCnpjPrestador(cnpjPrestador);
            d.setCpfCnpjPrestador("07194240000113");

//            d.setRazaoSocialPrestador(n.getTimbreContribuinteLinha1());
            
//            String auxiliar = n.getTimbreContribuinteLinha2();
//            String[] logradouro = auxiliar.split(",");
            
//            String[] endereco = MyUtils.separaTipoEndereco(logradouro[0]);
//            d.setTipoEnderecoPrestador(endereco[0]);
//            d.setEnderecoPrestador(endereco[1]);

            /*
            não precisa remover zeros à esquerda por enquanto
            d.setNumeroEnderecoPrestador(MyUtils.removeZeroEsquerda(n.getPrestadorPrestNumero()));
             */
            
//            logradouro = logradouro[1].split("-");
//            logradouro[0] = logradouro[0].trim();
//                    
//            d.setNumeroEnderecoPrestador(logradouro[0]);
//            //d.setComplementoEnderecoPrestador(n.getInfNfse().getPrestadorServico().getEndereco().getComplemento());
//            d.setBairroPrestador(logradouro[1]);
//            
//            auxiliar = n.getTimbreContribuinteLinha3();
//            String[] cepCidadeEstado = auxiliar.split(" - ");
//            
            d.setCidadePrestador(UtilCidades.nomeCidade(2210607));
//
//            d.setUfPrestador(cepCidadeEstado[2]);
//            
//            cepCidadeEstado[0] = cepCidadeEstado[0].replaceAll("[^0-9]", "");
//            
//            d.setCepPrestador(cepCidadeEstado[0]);
            
            //d.setEmailPrestador(n.getInfNfse().getPrestadorServico().getContato().getEmail());
            
            //d.setOpcaoPeloSimples(n.getInfNfse().getOptanteSimplesNacional() ? "4" : "0");
            
            if (n.getSituacao().equals("Cancelada") /* && !n.get.replaceAll("0", "").equals("") */) {
                d.setSituacaoNotaFiscal("C");
                //d.setDataCancelamento(c.getNfseCancelamento().getConfirmacao().getInfConfirmacaoCancelamento().getDataHora());
            }
            if (!n.getSituacao().equals("Emitida") && !n.getSituacao().equals("Cancelada")){
                throw new Exception("Favor contatar o administrador.");
            }
//            if (!c.getNfseSubstituicao().getSubstituicaoNfse().equals("")) {
//                throw new Exception("Notas substituidas detectadas. Favor solicitar correção do conversor.");
//                // d.setSituacaoNotaFiscal("S");
//            }

            double valorServico = Double.valueOf(n.getValorServico());
            d.setValorServicos(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorServico));
            
//            if (!d.getSituacaoNotaFiscal().equals("C") && !d.getSituacaoNotaFiscal().equals("S")) {
                valorTotalServicos += valorServico;
//            }

//            double valorDeducoes = Double.valueOf(n.getValorTotalDeducoes());
//            d.setValorDeducoes(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorDeducoes));
//            if (!d.getSituacaoNotaFiscal().equals("C") && !d.getSituacaoNotaFiscal().equals("S")) {
//                valorTotalDeducoes += valorDeducoes;
//            }

            /* não precisa tratar zeros à esquerda por enquanto
            d.setCodigoServicoPrestadoNotaFiscal(MyUtils.removeZeroEsquerda(n.getCosServico()));
             */
            d.setCodigoServicoPrestadoNotaFiscal(n.getNumeroDesconhecido());
//            d.setCodigoServicoPrestadoNotaFiscal(n.getCae().replaceAll("[^0-9]", ""));
            
//            d.setAliquota(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(considerarIss ? MyUtils.trataValor(n.getAliquotaImpostoAprox()) : "0"));

//            double valorIss = 0;
//            if(considerarIss){
//                double aliquota = Double.valueOf(n.getAliquotaImpostoAprox());
//                valorIss = Double.valueOf(aliquota * valorServico);
//                d.setValorIss(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorIss));
//
//            }
//            else {
//                //valorIss = 0;
//                d.setValorIss(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorIss));
//
//            }
            
//            if (!d.getSituacaoNotaFiscal().equals("C") && !d.getSituacaoNotaFiscal().equals("S")) {
//                valorTotalIss += valorIss;
//            }

//            if (Double.valueOf(c.getItens().getLista().get(0).getValorIssrf().replace(",", ".")) != 0) {
//                d.setIssRetido("S");
//            } else {
//                d.setIssRetido("N");
//            }

//            if (n.getClienteCNPJCPF().length() == 11) {
                d.setIndicadorCpfCnpjTomador("1");
                d.setCpfCnpjTomador(n.getCpfTomador());
//            } else {
//                d.setIndicadorCpfCnpjTomador("2");
//                d.setCpfCnpjTomador(n.getClienteCNPJCPF());
//            }

//            d.setInscricaoMunicipalTomador(n.getClienteInscricaoMunicipal());
//
//            d.setRazaoSocialTomador(n.getClienteNomeRazaoSocial());
//            
//            auxiliar = n.getClienteEndereco();
//            String logradouroCliente = auxiliar.replaceAll("[^a-zA-Z\\s]+", "");
//            String numeroLogradouroCliente = auxiliar.replaceAll("[^0-9]", "");
//            endereco = MyUtils.separaTipoEndereco(logradouroCliente);
//
//            d.setTipoEnderecoTomador(endereco[0]);
//            d.setEnderecoTomador(endereco[1]);

            /* não precisa remover zeros à esquerda por enquanto
            d.setNumeroEnderecoTomador(MyUtils.removeZeroEsquerda(n.getTomadorNumero()));
             */
//            d.setNumeroEnderecoTomador(numeroLogradouroCliente);

            //d.setComplementoEnderecoTomador(c.getTomador().getComplemento());

//            d.setBairroTomador(n.getClienteBairro());
//
//            d.setCidadeTomador(n.getClienteCidade());
//
//            d.setUfTomador(n.getClienteUF());
//
//            d.setCepTomador(n.getClienteCEP());

//            if (c.getTomador().getEmail() != null) {
//                d.setEmailTomador(c.getTomador().getEmail());
//            }

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

        FileUtils.deleteDirectory(new File("tmp"));
        return nota;
    }

    private ArrayList<File> converterParaXMLLegivel(File[] files) throws IOException {

        ArrayList<File> retorno = new ArrayList<>();
        int contador;
        boolean flag;

        for (File f : files) {
            String xml = UtilFile.fileToStringInline(new File(f.getAbsolutePath()));
            //xml = xml.replace("row", "nfse");

            File newFile = new File(f.getAbsolutePath().replace(".xml", ""));
            Scanner in;
            try (FileWriter fw = new FileWriter(newFile)) {
                in = new Scanner(new FileReader(f.getAbsoluteFile()));
                contador = 0;
                flag = false;
                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    
                    if (line.equals("<row>")){
                        line = line.replace("<row>", "<nfse>");
                        fw.write(line + System.getProperty("line.separator"));
                        flag = true;
                        contador = 0;
                    }
                    else if (line.equals("</row>")){
                        line = line.replace("</row>", "</nfse>");
                        fw.write(line + System.getProperty("line.separator"));
                        flag = false;
                    }
                    else if (flag){
                        switch (contador){
                            case 0:
                                line = line.replace("column", "numero");
                                fw.write(line + System.getProperty("line.separator"));
                                contador++;
                                break;
                            case 1:
                                line = line.replace("column", "cpfTomador");
                                fw.write(line + System.getProperty("line.separator"));
                                contador++;
                                break;
                            case 2:
                                line = line.replace("column", "nomeTomador");
                                fw.write(line + System.getProperty("line.separator"));
                                contador++;
                                break;
                            case 3:
                                line = line.replace("column", "dataEmissao");
                                fw.write(line + System.getProperty("line.separator"));
                                contador++;
                                break;
                            case 4:
                                line = line.replace("column", "numeroDesconhecido");
                                fw.write(line + System.getProperty("line.separator"));
                                contador++;
                                break;
                            case 5:
                                line = line.replace("column", "valorDesconhecido");
                                fw.write(line + System.getProperty("line.separator"));
                                contador++;
                                break;
                            case 6:
                                line = line.replace("column", "valorServico");
                                fw.write(line + System.getProperty("line.separator"));
                                contador++;
                                break;
                            case 7:
                                line = line.replace("column", "valorDesconhecido2");
                                fw.write(line + System.getProperty("line.separator"));
                                contador++;
                                break;
                            case 8:
                                line = line.replace("column", "situacao");
                                fw.write(line + System.getProperty("line.separator"));
                                contador++;
                                break;
                            case 9:
                                line = line.replace("column", "campoDesconhecido");
                                fw.write(line + System.getProperty("line.separator"));
                                contador++;
                                break;
                            default:
                                System.out.println("\nO contador possui valor inválido!\n");
                                break;
                        }
                    }
                    else {
                        fw.write(line + System.getProperty("line.separator"));
                    }
                }
            }
            in.close();
            f.delete();
            
            retorno.add(newFile);
        }
        return retorno;
    }
    
    public ArrayList<Nfse> lerXMLs(ArrayList<File> xmls) throws IOException {

        ArrayList<Nfse> retorno = new ArrayList<>();

        for (File f : xmls) {
//            System.out.println(f.getAbsolutePath());
            String xml = UtilFile.fileToStringInline(new File(f.getAbsolutePath()));
//            xml = xml.replace("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>", "");
//            xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><listaNfse>" + xml + "</listaNfse>";

            XStream xstream = new XStream();
            xstream.autodetectAnnotations(true);

            InputStream is = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));
            xstream.alias("table", Table.class);
            Table table = (Table) xstream.fromXML(is);

            for (Nfse nfse : table.getNfses()) {
                retorno.add(nfse);
            }
        }
        return retorno;
    }
}
