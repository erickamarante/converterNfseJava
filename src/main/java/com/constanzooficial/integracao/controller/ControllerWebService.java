package com.constanzooficial.integracao.controller;

import com.constanzooficial.integracao.controller.nfse.sp.saoPaulo.v001.GeradorCSV;
import com.constanzooficial.integracao.controller.nfse.sp.saoPaulo.v001.GeradorPDF;
import com.constanzooficial.integracao.controller.nfse.sp.saoPaulo.v001.GeradorTXT;
import com.constanzooficial.integracao.model.ModelClientes;
import com.constanzooficial.integracao.model.ModelConfig;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelCabecalho;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelDetalhe;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelDetalheComparator;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelNota;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelRodape;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.xml.Nfe;
import com.constanzooficial.integracao.util.MyUtils;
import com.constanzooficial.integracao.util.UtilAES;
import com.constanzooficial.integracao.util.UtilCidades;
import com.constanzooficial.integracao.util.UtilDatas;
import com.constanzooficial.integracao.util.UtilFile;
import com.constanzooficial.integracao.util.UtilXmlSign;
import com.constanzooficial.integracao.util.UtilXmlValidator;
import com.constanzooficial.integracao.view.ViewComBarra;
import br.gov.sp.prefeitura.nfeAsync.TpEventoAsync;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
public class ControllerWebService {

    public final static int NOTASEMITIDAS = 1;
    public final static int NOTASRECEBIDAS = 2;
    public final static int JANEIRO = 1;
    public final static int FEVEREIRO = 2;
    public final static int MARCO = 3;
    public final static int ABRIL = 4;
    public final static int MAIO = 5;
    public final static int JUNHO = 6;
    public final static int JULHO = 7;
    public final static int AGOSTO = 8;
    public final static int SETEMBRO = 9;
    public final static int OUTUBRO = 10;
    public final static int NOVEMBRO = 11;
    public final static int DEZEMBRO = 12;

    private ViewComBarra view;
    private AtomicInteger index;

    public ControllerWebService(ViewComBarra view) throws Exception {

        if (ModelConfig.getInstance().getPkcs12file() == null) {
            throw new Exception("Configurações de certificado digital não encontradas!");
        }
        System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");
        System.setProperty("javax.net.ssl.keyStore", ModelConfig.getInstance().getPkcs12file().getPath());
        System.setProperty("javax.net.ssl.keyStorePassword", UtilAES.getInstance().decrypt(ModelConfig.getInstance().getPassword()));

        this.view = view;
        this.index = new AtomicInteger(0);
    }

    public void baixarNotas(File destino, int mes, int ano, int nThreads) throws Exception {

        Date date = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(date.getTime());
        int mesAtual = cal.get(Calendar.MONTH) + 1;
        int anoAtual = cal.get(Calendar.YEAR);

        if (ano > anoAtual || (ano == anoAtual && mes > mesAtual)) {
            throw new Exception("Data inválida.");
        }

        ExecutorService executor = Executors.newCachedThreadPool();
        ArrayList<Future<Boolean>> threads = new ArrayList<>(nThreads);

        Thread salvaClientes = new Thread(() -> {
            for (Future<Boolean> future : threads) {
                try {
                    future.get();
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(ControllerWebService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            ControllerClientes c = new ControllerClientes();
            try {
                c.salvarClientes();
            } catch (IOException ex) {
                Logger.getLogger(ControllerWebService.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        for (int i = 0; i < nThreads; i++) {

            threads.add(executor.submit(() -> {

                boolean houveAlteracaoNosClientes = false;

                ModelClientes cliente = proximoCliente();
                while (cliente != null) {
                    try {
                        int resultado = baixarUmaNota(cliente, destino, mes, ano);
                        if (resultado == 1) {
                            houveAlteracaoNosClientes = true;
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(ControllerWebService.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
                    }
                    view.incrementarBarra();
                    cliente = proximoCliente();
                }

                try {
                    salvaClientes.start();
                } catch (IllegalThreadStateException ex) {
                }

                return houveAlteracaoNosClientes;
            }));

            /*
            Thread t = new Thread(() -> {

                ModelClientes cliente = proximoCliente();
                while (cliente != null) {
                    try {
                        baixarUmaNota(cliente, destino, mes, ano);
                    } catch (IOException ex) {
                        Logger.getLogger(ControllerWebService.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
                    }
                    view.incrementarBarra();
                    cliente = proximoCliente();
                }
            });
            t.start();
             */
        }
    }

    /**
     *
     * @param cliente
     * @param destino
     * @param mes
     * @param ano
     * @return 1 se houve alguma alteração na lista de clientes
     * @throws IOException
     */
    public int baixarUmaNota(ModelClientes cliente, File destino, int mes, int ano) throws IOException, Exception {

        System.out.println(cliente.getRazaoSocial());

        boolean houveAlteracaoNosClientes = false;

        if (cliente.isAtivo()) {

            if (cliente.getInscricaoMunicipal() == null) {
                ArrayList<String> inscricaoMunicipal = consultaCNPJ(cliente.getCpfCnpj());
                if (!inscricaoMunicipal.isEmpty()) {
                    cliente.setInscricaoMunicipal(inscricaoMunicipal.get(0));
                    if (inscricaoMunicipal.get(1).equals("true")) {
                        cliente.setEmiteNFe(true);
                    } else {
                        cliente.setEmiteNFe(false);
                    }
                }
            }

            if (cliente.getInscricaoMunicipal() != null) {

                ArrayList<String> notasXml = null;
                if (cliente.emiteNFe()) {
                    notasXml = consultaNFeEmitidas(cliente, mes, ano);
                }
                ArrayList<String> notasXmlRecebidas = consultaNFeRecebidas(cliente, mes, ano);
                ArrayList<Nfe> notas = new ArrayList<>();
                ArrayList<Nfe> notasRecebidas = new ArrayList<>();

                // Conversão do ArrayList de strings xml em ArrayList de Nfe
                if (notasXml != null) {
                    // System.out.println("Iniciando a conversão das notas emitidas");
                    for (String nota : notasXml) {

                        try {
                            // System.out.println("\nNota emitida: " + nota);
                            XStream xstream = new XStream();
                            xstream.autodetectAnnotations(true);
                            xstream.alias("NFe", Nfe.class);
                            Nfe nfe = (Nfe) xstream.fromXML(nota);
                            notas.add(nfe);
                            // System.out.println("Foi uma");
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                    // System.out.println("Fim");
                }
                if (!notasXmlRecebidas.isEmpty()) {
                    // System.out.println("Iniciando a conversão das notas recebidas");
                    for (String nota : notasXmlRecebidas) {

                        try {
                            // System.out.println("\nNota recebida: " + nota);
                            XStream xstream = new XStream();
                            xstream.autodetectAnnotations(true);
                            xstream.alias("NFe", Nfe.class);
                            Nfe nfe = (Nfe) xstream.fromXML(nota);
                            notasRecebidas.add(nfe);
                            // System.out.println("Foi uma");
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                    // System.out.println("Fim");
                }

                ModelNota nota;
                if (!notas.isEmpty()) {

                    if (cliente.getRazaoSocial() == null) {
                        for (Nfe n : notas) {
                            if (n.getRazaoSocialPrestador() != null) {
                                String razaoSocial = n.getRazaoSocialPrestador();
                                razaoSocial = razaoSocial.replace("\\", "").replace("/", "");
                                cliente.setRazaoSocial(razaoSocial);
                                houveAlteracaoNosClientes = true;
                                break;
                            }
                        }
                    }

                    ArrayList<ModelDetalhe> detalhes = new ArrayList<>();

                    // Preenchendo os modelos
                    double valorTotalServicos = 0;
                    double valorTotalDeducoes = 0;
                    double valorTotalIss = 0;
                    double valorTotalCredito = 0;

                    for (Nfe n : notas) {

                        ModelDetalhe d = new ModelDetalhe();
                        d.setNumeroNfse(n.getChaveNfe().getNumeroNFe());
                        d.setDataHoraNfse(MyUtils.trataDataHora2(n.getDataEmissaoNFe()));
                        d.setCodigoVerificacaoNfse(n.getChaveNfe().getCodigoVerificacao());
                        d.setTipoRps(n.getTipoRPS());
                        if (n.getChaveRPS() != null) {
                            d.setSerieRps(n.getChaveRPS().getSerieRPS());
                            d.setNumeroRps(n.getChaveRPS().getNumeroRPS());
                            d.setInscricaoMunicipalPrestador(n.getChaveRPS().getInscricaoPrestador());
                        }
                        if (n.getDataEmissaoRPS() != null) {
                            d.setDataEmissaoRps(MyUtils.trataData2(n.getDataEmissaoRPS()));
                        } else {
                            d.setDataEmissaoRps(MyUtils.trataData2(n.getDataEmissaoNFe()));
                        }
                        if (n.getChaveNfe().getInscricaoPrestador() != null) {
                            d.setInscricaoMunicipalPrestador(n.getChaveNfe().getInscricaoPrestador());
                        }
                        if (n.getCpfCnpjPrestador() != null) {
                            d.setIndicadorCpfCnpjPrestador((n.getCpfCnpjPrestador().getCpf() != null) ? "1" : "2");
                            d.setCpfCnpjPrestador((n.getCpfCnpjPrestador().getCpf() != null) ? n.getCpfCnpjPrestador().getCpf() : n.getCpfCnpjPrestador().getCnpj());
                        }
                        d.setRazaoSocialPrestador(n.getRazaoSocialPrestador());
                        if (n.getEnderecoPrestador() != null) {
                            d.setTipoEnderecoPrestador(n.getEnderecoPrestador().getTipoLogradouro());
                            d.setEnderecoPrestador(n.getEnderecoPrestador().getLogradouro());
                            d.setNumeroEnderecoPrestador(n.getEnderecoPrestador().getNumeroEndereco());
                            d.setComplementoEnderecoPrestador(n.getEnderecoPrestador().getComplementoEndereco());
                            d.setBairroPrestador(n.getEnderecoPrestador().getBairro());
                            if (n.getEnderecoPrestador().getCidade() != null) {
                                d.setCidadePrestador(UtilCidades.nomeCidade(n.getEnderecoPrestador().getCidade()));
                            }
                            d.setUfPrestador(n.getEnderecoPrestador().getUf());
                            d.setCepPrestador(n.getEnderecoPrestador().getCep());
                        }
                        d.setEmailPrestador(n.getEmailPrestador());
                        d.setOpcaoPeloSimples(n.getOpcaoSimples());
                        if (n.getStatusNFe().equalsIgnoreCase("N")) {
                            d.setSituacaoNotaFiscal(n.getTributacaoNFe());
                        } else {
                            d.setSituacaoNotaFiscal(n.getStatusNFe().toUpperCase());
                        }
                        if (n.getDataCancelamento() != null) {
                            d.setDataCancelamento(MyUtils.trataData2(n.getDataCancelamento()));
                        }
                        d.setNumeroGuia(n.getNumeroGuia());
                        if (n.getDataQuitacaoGuia() != null) {
                            d.setDataQuitacaoGuiaVinculadaNotaFiscal(MyUtils.trataData2(n.getDataQuitacaoGuia()));
                        }
                        double valorServicos = 0;
                        if (n.getValorServicos() != null) {
                            valorServicos = Double.valueOf(n.getValorServicos());
                            d.setValorServicos(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorServicos));
                        }
                        double valorDeducoes = 0;
                        if (n.getValorDeducoes() != null) {
                            valorDeducoes = Double.valueOf(n.getValorDeducoes());
                            d.setValorDeducoes(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorDeducoes));
                        }
                        d.setCodigoServicoPrestadoNotaFiscal(n.getCodigoServico());
                        if (n.getAliquotaServicos() != null) {
                            if (cliente.isConsiderarIss()) {
                                d.setAliquota(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(Double.valueOf(n.getAliquotaServicos()) * 100));
                            } else {
                                d.setAliquota(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(0));
                            }
                        }
                        double valorIss = 0;
                        if (n.getValorISS() != null) {
                            if (cliente.isConsiderarIss()) {
                                valorIss = Double.valueOf(n.getValorISS());
                            } else {
                                valorIss = 0;
                            }
                            d.setValorIss(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorIss));
                        }
                        double valorCredito = 0;
                        if (n.getValorCredito() != null) {
                            valorCredito = Double.valueOf(n.getValorCredito());
                            d.setValorCredito(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorCredito));
                        }

                        if (!d.getSituacaoNotaFiscal().equals("C")) {
                            valorTotalServicos += valorServicos;
                            valorTotalDeducoes += valorDeducoes;
                            valorTotalIss += valorIss;
                            valorTotalCredito += valorCredito;
                        }

                        if (n.getIssRetido() != null) {
                            d.setIssRetido(n.getIssRetido().equals("true") ? "S" : "N");
                        }
                        if (n.getCpfCnpjTomador() != null) {
                            d.setIndicadorCpfCnpjTomador((n.getCpfCnpjTomador().getCpf() != null) ? "1" : "2");
                            d.setCpfCnpjTomador((n.getCpfCnpjTomador().getCpf() != null) ? n.getCpfCnpjTomador().getCpf() : n.getCpfCnpjTomador().getCnpj());
                        }
                        d.setInscricaoMunicipalTomador(n.getInscricaoMunicipalTomador());
                        d.setRazaoSocialTomador(n.getRazaoSocialTomador());
                        if (n.getEnderecoTomador() != null) {
                            d.setTipoEnderecoTomador(n.getEnderecoTomador().getTipoLogradouro());
                            d.setEnderecoTomador(n.getEnderecoTomador().getLogradouro());
                            d.setNumeroEnderecoTomador(n.getEnderecoTomador().getNumeroEndereco());
                            d.setComplementoEnderecoTomador(n.getEnderecoTomador().getComplementoEndereco());
                            d.setBairroTomador(n.getEnderecoTomador().getBairro());
                            if (n.getEnderecoTomador().getCidade() != null) {
                                d.setCidadeTomador(UtilCidades.nomeCidade(n.getEnderecoTomador().getCidade()));
                            }
                            d.setUfTomador(n.getEnderecoTomador().getUf());
                            d.setCepTomador(n.getEnderecoTomador().getCep());
                        }
                        d.setEmailTomador(n.getEmailTomador());
                        d.setDiscriminacaoServicos(n.getDiscriminacao());
                        if (n.getCpfCnpjIntermediario() != null) {
                            d.setCpfCnpjIntermediario(n.getCpfCnpjIntermediario());
                        }
                        detalhes.add(d);
                    }
                    Collections.sort(detalhes, new ModelDetalheComparator());

                    ModelCabecalho cabecalho = new ModelCabecalho();
                    cabecalho.setInscricaoMunicipalContribuinte(cliente.getInscricaoMunicipal());
                    String[] dataInicioArquivo = {"01", MyUtils.strTamanhoMax(Integer.toString(mes), 2, "numerico"), MyUtils.strTamanhoMax(Integer.toString(ano), 4, "numerico")};
                    cabecalho.setDataInicioArquivo(dataInicioArquivo);
                    String[] dataFimArquivo = {MyUtils.strTamanhoMax(Integer.toString(MyUtils.ultimoDiaMes(mes, ano)), 2, "numerico"), MyUtils.strTamanhoMax(Integer.toString(mes), 2, "numerico"), MyUtils.strTamanhoMax(Integer.toString(ano), 4, "numerico")};
                    cabecalho.setDataFimArquivo(dataFimArquivo);
                    cabecalho.setRazaoSocialContribuinte(cliente.getRazaoSocial());

                    ModelRodape rodape = new ModelRodape();
                    rodape.setNumeroLinhasDetalhe(Integer.toString(detalhes.size()));
                    rodape.setValorTotalServicos(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorTotalServicos));
                    rodape.setValorTotalDeducoes(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorTotalDeducoes));
                    rodape.setValorTotalIss(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorTotalIss));
                    rodape.setValorTotalCreditos(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorTotalCredito));

                    nota = new ModelNota();
                    nota.setCabecalho(cabecalho);
                    nota.setDetalhe(detalhes);
                    nota.setRodape(rodape);

                } else {

                    ModelCabecalho cabecalho = new ModelCabecalho();
                    cabecalho.setInscricaoMunicipalContribuinte(cliente.getInscricaoMunicipal());
                    String[] dataInicioArquivo = {"01", MyUtils.strTamanhoMax(Integer.toString(mes), 2, "numerico"), MyUtils.strTamanhoMax(Integer.toString(ano), 4, "numerico")};
                    cabecalho.setDataInicioArquivo(dataInicioArquivo);
                    String[] dataFimArquivo = {MyUtils.strTamanhoMax(Integer.toString(MyUtils.ultimoDiaMes(mes, ano)), 2, "numerico"), MyUtils.strTamanhoMax(Integer.toString(mes), 2, "numerico"), MyUtils.strTamanhoMax(Integer.toString(ano), 4, "numerico")};
                    cabecalho.setDataFimArquivo(dataFimArquivo);
                    cabecalho.setRazaoSocialContribuinte(cliente.getRazaoSocial());

                    ModelRodape rodape = new ModelRodape();
                    rodape.setNumeroLinhasDetalhe("0");
                    rodape.setValorTotalServicos("0");
                    rodape.setValorTotalDeducoes("0");
                    rodape.setValorTotalIss("0");
                    rodape.setValorTotalCreditos("0");

                    nota = new ModelNota();
                    nota.setCabecalho(cabecalho);
                    nota.setDetalhe(new ArrayList<>());
                    nota.setRodape(rodape);
                }

                GeradorTXT gerador = new GeradorTXT(nota);
                String barra = System.getProperty("os.name").equals("Linux") ? "/" : "\\";
                gerador.gerarTxt(destino.getAbsolutePath().concat(barra + (cliente.getRazaoSocial() == null ? "" : cliente.getRazaoSocial() + " - ") + cliente.getCpfCnpj()), GeradorTXT.EMITIDA);
                GeradorCSV geradorCsv = new GeradorCSV(nota);
                geradorCsv.gerarCsv(destino.getAbsolutePath().concat(barra + (cliente.getRazaoSocial() == null ? "" : cliente.getRazaoSocial() + " - ") + cliente.getCpfCnpj()), GeradorCSV.EMITIDA);
                GeradorPDF geradorPDF = new GeradorPDF(nota);
                geradorPDF.gerarPDFEmitidas(destino.getAbsolutePath().concat(barra + (cliente.getRazaoSocial() == null ? "" : cliente.getRazaoSocial() + " - ") + cliente.getCpfCnpj()));

                if (!notasRecebidas.isEmpty()) {

                    if (cliente.getRazaoSocial() == null) {
                        for (Nfe n : notasRecebidas) {
                            if (n.getRazaoSocialTomador() != null) {
                                String razaoSocial = n.getRazaoSocialTomador();
                                razaoSocial = razaoSocial.replace("\\", "").replace("/", "");
                                cliente.setRazaoSocial(razaoSocial);
                                houveAlteracaoNosClientes = true;
                                break;
                            }
                        }
                    }

                    ArrayList<ModelDetalhe> detalhes = new ArrayList<>();

                    // Preenchendo os modelos
                    double valorTotalServicos = 0;
                    double valorTotalDeducoes = 0;
                    double valorTotalIss = 0;
                    double valorTotalCredito = 0;

                    for (Nfe n : notasRecebidas) {

                        ModelDetalhe d = new ModelDetalhe();
                        d.setNumeroNfse(n.getChaveNfe().getNumeroNFe());
                        d.setDataHoraNfse(MyUtils.trataDataHora2(n.getDataEmissaoNFe()));
                        d.setCodigoVerificacaoNfse(n.getChaveNfe().getCodigoVerificacao());
                        d.setTipoRps(n.getTipoRPS());
                        if (n.getChaveRPS() != null) {
                            d.setSerieRps(n.getChaveRPS().getSerieRPS());
                            d.setNumeroRps(n.getChaveRPS().getNumeroRPS());
                            d.setInscricaoMunicipalPrestador(n.getChaveRPS().getInscricaoPrestador());
                        }
                        if (n.getDataEmissaoRPS() != null) {
                            d.setDataEmissaoRps(MyUtils.trataData2(n.getDataEmissaoRPS()));
                        } else {
                            d.setDataEmissaoRps(MyUtils.trataData2(n.getDataEmissaoNFe()));
                        }
                        if (n.getChaveNfe().getInscricaoPrestador() != null) {
                            d.setInscricaoMunicipalPrestador(n.getChaveNfe().getInscricaoPrestador());
                        }
                        if (n.getCpfCnpjPrestador() != null) {
                            d.setIndicadorCpfCnpjPrestador((n.getCpfCnpjPrestador().getCpf() != null) ? "1" : "2");
                            d.setCpfCnpjPrestador((n.getCpfCnpjPrestador().getCpf() != null) ? n.getCpfCnpjPrestador().getCpf() : n.getCpfCnpjPrestador().getCnpj());
                        }
                        d.setRazaoSocialPrestador(n.getRazaoSocialPrestador());
                        if (n.getEnderecoPrestador() != null) {
                            d.setTipoEnderecoPrestador(n.getEnderecoPrestador().getTipoLogradouro());
                            d.setEnderecoPrestador(n.getEnderecoPrestador().getLogradouro());
                            d.setNumeroEnderecoPrestador(n.getEnderecoPrestador().getNumeroEndereco());
                            d.setComplementoEnderecoPrestador(n.getEnderecoPrestador().getComplementoEndereco());
                            d.setBairroPrestador(n.getEnderecoPrestador().getBairro());
                            if (n.getEnderecoPrestador().getCidade() != null) {
                                d.setCidadePrestador(UtilCidades.nomeCidade(n.getEnderecoPrestador().getCidade()));
                            }
                            d.setUfPrestador(n.getEnderecoPrestador().getUf());
                            d.setCepPrestador(n.getEnderecoPrestador().getCep());
                        }
                        d.setEmailPrestador(n.getEmailPrestador());
                        d.setOpcaoPeloSimples(n.getOpcaoSimples());
                        if (n.getStatusNFe().equalsIgnoreCase("N")) {
                            d.setSituacaoNotaFiscal(n.getTributacaoNFe());
                        } else {
                            d.setSituacaoNotaFiscal(n.getStatusNFe().toUpperCase());
                        }
                        if (n.getDataCancelamento() != null) {
                            d.setDataCancelamento(MyUtils.trataData2(n.getDataCancelamento()));
                        }
                        d.setNumeroGuia(n.getNumeroGuia());
                        if (n.getDataQuitacaoGuia() != null) {
                            d.setDataQuitacaoGuiaVinculadaNotaFiscal(MyUtils.trataData2(n.getDataQuitacaoGuia()));
                        }
                        double valorServicos = 0;
                        if (n.getValorServicos() != null) {
                            valorServicos = Double.valueOf(n.getValorServicos());
                            d.setValorServicos(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorServicos));
                        }
                        double valorDeducoes = 0;
                        if (n.getValorDeducoes() != null) {
                            valorDeducoes = Double.valueOf(n.getValorDeducoes());
                            d.setValorDeducoes(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorDeducoes));
                        }
                        d.setCodigoServicoPrestadoNotaFiscal(n.getCodigoServico());
                        if (n.getAliquotaServicos() != null) {
                            if (cliente.isConsiderarIss()) {
                                d.setAliquota(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(Double.valueOf(n.getAliquotaServicos()) * 100));
                            } else {
                                d.setAliquota(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(0));
                            }
                        }
                        double valorIss = 0;
                        if (n.getValorISS() != null) {
                            if (cliente.isConsiderarIss()) {
                                valorIss = Double.valueOf(n.getValorISS());
                            } else {
                                valorIss = 0;
                            }
                            d.setValorIss(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorIss));
                        }
                        double valorCredito = 0;
                        if (n.getValorCredito() != null) {
                            valorCredito = Double.valueOf(n.getValorCredito());
                            d.setValorCredito(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorCredito));
                        }

                        if (!d.getSituacaoNotaFiscal().equals("C")) {
                            valorTotalServicos += valorServicos;
                            valorTotalDeducoes += valorDeducoes;
                            valorTotalIss += valorIss;
                            valorTotalCredito += valorCredito;
                        }

                        if (n.getIssRetido() != null) {
                            d.setIssRetido(n.getIssRetido().equals("true") ? "S" : "N");
                        }
                        if (n.getCpfCnpjTomador() != null) {
                            d.setIndicadorCpfCnpjTomador((n.getCpfCnpjTomador().getCpf() != null) ? "1" : "2");
                            d.setCpfCnpjTomador((n.getCpfCnpjTomador().getCpf() != null) ? n.getCpfCnpjTomador().getCpf() : n.getCpfCnpjTomador().getCnpj());
                        }
                        d.setInscricaoMunicipalTomador(cliente.getInscricaoMunicipal());
                        d.setRazaoSocialTomador(n.getRazaoSocialTomador());
                        if (n.getEnderecoTomador() != null) {
                            d.setTipoEnderecoTomador(n.getEnderecoTomador().getTipoLogradouro());
                            d.setEnderecoTomador(n.getEnderecoTomador().getLogradouro());
                            d.setNumeroEnderecoTomador(n.getEnderecoTomador().getNumeroEndereco());
                            d.setComplementoEnderecoTomador(n.getEnderecoTomador().getComplementoEndereco());
                            d.setBairroTomador(n.getEnderecoTomador().getBairro());
                            if (n.getEnderecoTomador().getCidade() != null) {
                                d.setCidadeTomador(UtilCidades.nomeCidade(n.getEnderecoTomador().getCidade()));
                            }
                            d.setUfTomador(n.getEnderecoTomador().getUf());
                            d.setCepTomador(n.getEnderecoTomador().getCep());
                        }
                        d.setEmailTomador(n.getEmailTomador());
                        d.setDiscriminacaoServicos(n.getDiscriminacao());
                        if (n.getCpfCnpjIntermediario() != null) {
                            d.setCpfCnpjIntermediario(n.getCpfCnpjIntermediario());
                        }
                        detalhes.add(d);
                    }
                    Collections.sort(detalhes, new ModelDetalheComparator());

                    ModelCabecalho cabecalho = new ModelCabecalho();
                    cabecalho.setInscricaoMunicipalContribuinte(cliente.getInscricaoMunicipal());
                    String[] dataInicioArquivo = {"01", MyUtils.strTamanhoMax(Integer.toString(mes), 2, "numerico"), MyUtils.strTamanhoMax(Integer.toString(ano), 4, "numerico")};
                    cabecalho.setDataInicioArquivo(dataInicioArquivo);
                    String[] dataFimArquivo = {MyUtils.strTamanhoMax(Integer.toString(MyUtils.ultimoDiaMes(mes, ano)), 2, "numerico"), MyUtils.strTamanhoMax(Integer.toString(mes), 2, "numerico"), MyUtils.strTamanhoMax(Integer.toString(ano), 4, "numerico")};
                    cabecalho.setDataFimArquivo(dataFimArquivo);
                    cabecalho.setRazaoSocialContribuinte(cliente.getRazaoSocial());

                    ModelRodape rodape = new ModelRodape();
                    rodape.setNumeroLinhasDetalhe(Integer.toString(detalhes.size()));
                    rodape.setValorTotalServicos(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorTotalServicos));
                    rodape.setValorTotalDeducoes(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorTotalDeducoes));
                    rodape.setValorTotalIss(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorTotalIss));
                    rodape.setValorTotalCreditos(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorTotalCredito));

                    nota = new ModelNota();
                    nota.setCabecalho(cabecalho);
                    nota.setDetalhe(detalhes);
                    nota.setRodape(rodape);

                } else {

                    ModelCabecalho cabecalho = new ModelCabecalho();
                    cabecalho.setInscricaoMunicipalContribuinte(cliente.getInscricaoMunicipal());
                    String[] dataInicioArquivo = {"01", MyUtils.strTamanhoMax(Integer.toString(mes), 2, "numerico"), MyUtils.strTamanhoMax(Integer.toString(ano), 4, "numerico")};
                    cabecalho.setDataInicioArquivo(dataInicioArquivo);
                    String[] dataFimArquivo = {MyUtils.strTamanhoMax(Integer.toString(MyUtils.ultimoDiaMes(mes, ano)), 2, "numerico"), MyUtils.strTamanhoMax(Integer.toString(mes), 2, "numerico"), MyUtils.strTamanhoMax(Integer.toString(ano), 4, "numerico")};
                    cabecalho.setDataFimArquivo(dataFimArquivo);
                    cabecalho.setRazaoSocialContribuinte(cliente.getRazaoSocial());

                    ModelRodape rodape = new ModelRodape();
                    rodape.setNumeroLinhasDetalhe("0");
                    rodape.setValorTotalServicos("0");
                    rodape.setValorTotalDeducoes("0");
                    rodape.setValorTotalIss("0");
                    rodape.setValorTotalCreditos("0");

                    nota = new ModelNota();
                    nota.setCabecalho(cabecalho);
                    nota.setDetalhe(new ArrayList<>());
                    nota.setRodape(rodape);
                }

                gerador = new GeradorTXT(nota);
                gerador.gerarTxt(destino.getAbsolutePath().concat(barra + (cliente.getRazaoSocial() == null ? "" : cliente.getRazaoSocial() + " - ") + cliente.getCpfCnpj()), GeradorTXT.RECEBIDA);
                geradorCsv = new GeradorCSV(nota);
                geradorCsv.gerarCsv(destino.getAbsolutePath().concat(barra + (cliente.getRazaoSocial() == null ? "" : cliente.getRazaoSocial() + " - ") + cliente.getCpfCnpj()), GeradorCSV.RECEBIDA);
                geradorPDF = new GeradorPDF(nota);
                geradorPDF.gerarPDFRecebidas(destino.getAbsolutePath().concat(barra + (cliente.getRazaoSocial() == null ? "" : cliente.getRazaoSocial() + " - ") + cliente.getCpfCnpj()));
            }
        }

        if (houveAlteracaoNosClientes) {
            return 1;
        }
        return 0;
    }

    private synchronized ModelClientes proximoCliente() {
        if (index.get() < ControllerClientes.getClientes().size()) {
            return ControllerClientes.getClientes().get(index.incrementAndGet() - 1);
        }
        return null;
    }

    private String gerarMensagemXMLConsultaCNPJRequest(String cfpCnpjRemetente, String cnpjContribuinte) throws Exception, URISyntaxException {

        String aux = null;
        File xmlFile = new File("data/ws/sp/saopaulo/pedidoConsultaCNPJ.xml");
        String mensagemXML = UtilFile.fileToStringInline(xmlFile).replaceAll("\t", "").replaceAll("[ ]+", " ").replaceAll("> <", "><");

        // Preenchimento do campo CPFCNPJRemetente
        if (cfpCnpjRemetente.length() == 14) {
            aux = "<CNPJ>".concat(cfpCnpjRemetente).concat("</CNPJ>");
        } else if (cfpCnpjRemetente.length() == 11) {
            aux = "<CPF>".concat(cfpCnpjRemetente).concat("</CPF>");
        }
        mensagemXML = mensagemXML.replaceAll("<##CPFCNPJREMETENTE##/>", aux);

        // Preenchimento do campo CNPJContribuinte
        aux = "<CNPJ>".concat(cnpjContribuinte).concat("</CNPJ>");
        mensagemXML = mensagemXML.replaceAll("<##CNPJCONTRIBUINTE##/>", aux);

        // Assinatura
        mensagemXML = new UtilXmlSign().signXml(mensagemXML).replaceAll("\n|\r", "");

        // Validação
        //new UtilXmlValidator().valida(mensagemXML, new File("data/ws/sp/saopaulo/PedidoConsultaCNPJ_v01.xsd"));
        return mensagemXML;
    }

    public ArrayList<String> consultaCNPJ(String cnpj) {

        ArrayList<String> inscricoesMunicipais = new ArrayList<>();

        try { // Call Web Service Operation
            br.gov.sp.prefeitura.nfe.LoteNFe service = new br.gov.sp.prefeitura.nfe.LoteNFe();
            br.gov.sp.prefeitura.nfe.LoteNFeSoap port = service.getLoteNFeSoap();
            // TODO initialize WS operation arguments here
            br.gov.sp.prefeitura.nfe.ConsultaCNPJRequest parameters = new br.gov.sp.prefeitura.nfe.ConsultaCNPJRequest();
            parameters.setVersaoSchema(1);
            parameters.setMensagemXML(gerarMensagemXMLConsultaCNPJRequest(ModelConfig.getInstance().getCnpj(), cnpj));
            // TODO process result here
            br.gov.sp.prefeitura.nfe.ConsultaCNPJResponse result = port.consultaCNPJ(parameters);

            // System.out.println("Result (consultaCNPJ) = " + result.getRetornoXML());
            Pattern pattern = Pattern.compile("<InscricaoMunicipal>(.*?)</InscricaoMunicipal>");
            Pattern pattern2 = Pattern.compile("<EmiteNFe>(.*?)</EmiteNFe>");
            Matcher matcher = pattern.matcher(result.getRetornoXML());
            Matcher matcher2 = pattern2.matcher(result.getRetornoXML());
            if (matcher.find() && matcher2.find()) {

                inscricoesMunicipais.add(matcher.group(1));
                if (matcher2.group(1).equals("true")) {
                    inscricoesMunicipais.add("true");
                } else {
                    inscricoesMunicipais.add("false");
                }
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return inscricoesMunicipais;
    }

    public ArrayList<String> consultaCNPJ2(String cnpj) {

        try { // Call Web Service Operation
            br.gov.sp.prefeitura.nfe.LoteNFe service = new br.gov.sp.prefeitura.nfe.LoteNFe();
            br.gov.sp.prefeitura.nfe.LoteNFeSoap port = service.getLoteNFeSoap12();
            // TODO initialize WS operation arguments here
            br.gov.sp.prefeitura.nfe.ConsultaCNPJRequest parameters = new br.gov.sp.prefeitura.nfe.ConsultaCNPJRequest();
            parameters.setVersaoSchema(1);
            parameters.setMensagemXML(gerarMensagemXMLConsultaCNPJRequest(ModelConfig.getInstance().getCnpj(), cnpj));
            // System.out.println("Mensagem: " + parameters.getMensagemXML());
            // TODO process result here
            br.gov.sp.prefeitura.nfe.ConsultaCNPJResponse result = port.consultaCNPJ(parameters);
            // System.out.println("Result = " + result.getRetornoXML());
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }

        return null;
    }

    private String gerarMensagemXMLConsultaNFeEmitidasRecebidasRequest(ModelClientes cliente, int mes, int ano, int pagina) throws Exception, URISyntaxException {

        String aux = null;
        File xmlFile = new File("data/ws/sp/saoPaulo/PedidoConsultaNFeEmitidas.xml");
        String mensagemXML = UtilFile.fileToStringInline(xmlFile).replaceAll("\t", "").replaceAll("[ ]+", " ").replaceAll("> <", "><");

        // Preenchimento do campo CPFCNPJRemetente
        if (ModelConfig.getInstance().getCnpj().length() == 14) {
            aux = "<CNPJ>".concat(ModelConfig.getInstance().getCnpj()).concat("</CNPJ>");
        } else if (ModelConfig.getInstance().getCnpj().length() == 11) {
            aux = "<CPF>".concat(ModelConfig.getInstance().getCnpj()).concat("</CPF>");
        }
        mensagemXML = mensagemXML.replaceAll("<##CPFCNPJRemetente##/>", aux);

        // Preenchimento do campo CPFCNPJ
        if (cliente.getCpfCnpj().length() == 14) {
            aux = "<CNPJ>".concat(cliente.getCpfCnpj()).concat("</CNPJ>");
        } else if (cliente.getCpfCnpj().length() == 11) {
            aux = "<CPF>".concat(cliente.getCpfCnpj()).concat("</CPF>");
        }
        mensagemXML = mensagemXML.replaceAll("<##CPFCNPJ##/>", aux);

        // Preenchimento do campo Inscricao
        aux = cliente.getInscricaoMunicipal();
        mensagemXML = mensagemXML.replaceAll("<##Inscricao##/>", aux);

        // Preenchimento do campo dtInicio
        aux = Integer.toString(ano).concat("-").concat(MyUtils.strTamanhoMax(Integer.toString(mes), 2, "numerico")).concat("-01");
        mensagemXML = mensagemXML.replaceAll("<##dtInicio##/>", aux);

        // Preenchimento do campo dtFim
        Date date = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(date.getTime());
        int diaAtual = cal.get(Calendar.DAY_OF_MONTH);
        int mesAtual = cal.get(Calendar.MONTH) + 1;
        int anoAtual = cal.get(Calendar.YEAR);
        int dia;

        if (ano == anoAtual && mes == mesAtual) {
            dia = diaAtual;
        } else {
            dia = MyUtils.ultimoDiaMes(mes, ano);
        }
        aux = Integer.toString(ano).concat("-").concat(MyUtils.strTamanhoMax(Integer.toString(mes), 2, "numerico")).concat("-").concat(MyUtils.strTamanhoMax(Integer.toString(dia), 2, "numerico"));
        mensagemXML = mensagemXML.replaceAll("<##dtFim##/>", aux);

        // Preenchimento do campo NumeroPagina
        aux = Integer.toString(pagina);
        mensagemXML = mensagemXML.replaceAll("<##NumeroPagina##/>", aux);

        // Assinatura
        mensagemXML = new UtilXmlSign().signXml(mensagemXML).replaceAll("\n|\r", "");

        // Validação
        new UtilXmlValidator().valida(mensagemXML, new File("data/ws/sp/saoPaulo/PedidoConsultaNFePeriodo_v01.xsd"));

        return mensagemXML;
    }

    public ArrayList<String> consultaNFeEmitidas(ModelClientes cliente, int mes, int ano) {

        ArrayList<String> notas = new ArrayList<>();

        try { // Call Web Service Operation
            br.gov.sp.prefeitura.nfe.LoteNFe service = new br.gov.sp.prefeitura.nfe.LoteNFe();
            br.gov.sp.prefeitura.nfe.LoteNFeSoap port = service.getLoteNFeSoap();

            // TODO initialize WS operation arguments here
            br.gov.sp.prefeitura.nfe.ConsultaNFeEmitidasRequest parameters = new br.gov.sp.prefeitura.nfe.ConsultaNFeEmitidasRequest();
            parameters.setVersaoSchema(1);

            Pattern pattern = Pattern.compile("<NFe xmlns=\"\">(.*?)</NFe>");
            Pattern pattern2 = Pattern.compile("<DataEmissaoRPS>(.*?)</DataEmissaoRPS>");

            for (int i = 1;; i++) {
                parameters.setMensagemXML(gerarMensagemXMLConsultaNFeEmitidasRecebidasRequest(cliente, mes, ano, i));

                // TODO process result here
                br.gov.sp.prefeitura.nfe.ConsultaNFeEmitidasResponse result = port.consultaNFeEmitidas(parameters);
                // System.out.println("\nResultado das notas emitidas pela empresa" + cliente.getRazaoSocial() + ": " + result.getRetornoXML());

                Matcher matcher = pattern.matcher(result.getRetornoXML().replaceAll("\n", " ").replaceAll("[ ]+", " "));
                int qtdNotas = 0;
                while (matcher.find()) {
                    qtdNotas++;

                    Matcher matcher2 = pattern2.matcher(matcher.group(0));
                    if (matcher2.find()) {
                        String[] dataEmissaoRps = MyUtils.trataData2(matcher2.group(1));
                        if (mes == Integer.valueOf(dataEmissaoRps[1])) {
                            notas.add(matcher.group(0));
                        }
                    } else {
                        notas.add(matcher.group(0));
                    }
                }

                if (qtdNotas < 50) {
                    break;
                }
            }

            // Repetindo o processo, para verificar notas geradas no mês seguinte mas que ainda se referem ao mês solicitado
            Date date = new Date();
            Calendar cal = new GregorianCalendar();
            cal.setTimeInMillis(date.getTime());
            int mesAtual = cal.get(Calendar.MONTH) + 1;
            int anoAtual = cal.get(Calendar.YEAR);

            if (mes == 12 && ano < anoAtual) {
                ano += 1;
                mes = 1;
            } else {
                if ((ano == anoAtual && mes < mesAtual) || ano != anoAtual) {
                    mes += 1;
                }
            }

            for (int i = 1;; i++) {
                parameters.setMensagemXML(gerarMensagemXMLConsultaNFeEmitidasRecebidasRequest(cliente, mes, ano, i));
                br.gov.sp.prefeitura.nfe.ConsultaNFeEmitidasResponse result = port.consultaNFeEmitidas(parameters);
                // System.out.println("\nResult 2 (emitidas) = " + result.getRetornoXML());
                Matcher matcher = pattern.matcher(result.getRetornoXML().replaceAll("\n", " ").replaceAll("[ ]+", " "));
                int qtdNotas = 0;
                while (matcher.find()) {
                    qtdNotas++;

                    Matcher matcher2 = pattern2.matcher(matcher.group(0));
                    if (matcher2.find()) {
                        String[] dataEmissaoRps = MyUtils.trataData2(matcher2.group(1));
                        if (mes - 1 == Integer.valueOf(dataEmissaoRps[1])) {
                            notas.add(matcher.group(0));
                        }
                    }
                }

                if (qtdNotas < 50) {
                    break;
                }
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return notas;
    }

    public ArrayList<String> consultaNFeRecebidas(ModelClientes cliente, int mes, int ano) {

        ArrayList<String> notas = new ArrayList<>();

        try { // Call Web Service Operation
            br.gov.sp.prefeitura.nfe.LoteNFe service = new br.gov.sp.prefeitura.nfe.LoteNFe();
            br.gov.sp.prefeitura.nfe.LoteNFeSoap port = service.getLoteNFeSoap();

            // TODO initialize WS operation arguments here
            br.gov.sp.prefeitura.nfe.ConsultaNFeRecebidasRequest parameters = new br.gov.sp.prefeitura.nfe.ConsultaNFeRecebidasRequest();
            parameters.setVersaoSchema(1);

            Pattern pattern = Pattern.compile("<NFe xmlns=\"\">(.*?)</NFe>");
            Pattern pattern2 = Pattern.compile("<DataEmissaoRPS>(.*?)</DataEmissaoRPS>");

            for (int i = 1;; i++) {
                parameters.setMensagemXML(gerarMensagemXMLConsultaNFeEmitidasRecebidasRequest(cliente, mes, ano, i));

                // TODO process result here
                br.gov.sp.prefeitura.nfe.ConsultaNFeRecebidasResponse result = port.consultaNFeRecebidas(parameters);
                // System.out.println("\nResultado das notas recebidas pela empresa" + cliente.getRazaoSocial() + ": " + result.getRetornoXML());

                Matcher matcher = pattern.matcher(result.getRetornoXML().replaceAll("\n", " ").replaceAll("[ ]+", " "));
                int qtdNotas = 0;
                while (matcher.find()) {
                    // System.out.println("Achou uma nota");
                    qtdNotas++;

                    Matcher matcher2 = pattern2.matcher(matcher.group(0));
                    if (matcher2.find()) {
                        String[] dataEmissaoRps = MyUtils.trataData2(matcher2.group(1));
                        if (mes == Integer.valueOf(dataEmissaoRps[1])) {
                            notas.add(matcher.group(0));
                        }
                    } else {
                        notas.add(matcher.group(0));
                    }
                }
                // System.out.println("Foram encontradas " + qtdNotas + " notas");
                if (qtdNotas < 50) {
                    // System.out.println("Saindo do for");
                    break;
                }
            }

            // Repetindo o processo, para verificar notas geradas no mês seguinte mas que ainda se referem ao mês solicitado
            Date date = new Date();
            Calendar cal = new GregorianCalendar();
            cal.setTimeInMillis(date.getTime());
            int mesAtual = cal.get(Calendar.MONTH) + 1;
            int anoAtual = cal.get(Calendar.YEAR);

            if (mes == 12 && ano < anoAtual) {
                ano += 1;
                mes = 1;
            } else {
                if ((ano == anoAtual && mes < mesAtual) || ano != anoAtual) {
                    mes += 1;
                }
            }

            for (int i = 1;; i++) {
                parameters.setMensagemXML(gerarMensagemXMLConsultaNFeEmitidasRecebidasRequest(cliente, mes, ano, i));
                br.gov.sp.prefeitura.nfe.ConsultaNFeRecebidasResponse result = port.consultaNFeRecebidas(parameters);
                // System.out.println("\nNotas recebidas do mês seguinte: = " + result.getRetornoXML());
                Matcher matcher = pattern.matcher(result.getRetornoXML().replaceAll("\n", " ").replaceAll("[ ]+", " "));
                int qtdNotas = 0;
                while (matcher.find()) {
                    // System.out.println("Achou uma nota");
                    qtdNotas++;

                    Matcher matcher2 = pattern2.matcher(matcher.group(0));
                    if (matcher2.find()) {
                        String[] dataEmissaoRps = MyUtils.trataData2(matcher2.group(1));
                        if (mes - 1 == Integer.valueOf(dataEmissaoRps[1])) {
                            notas.add(matcher.group(0));
                        }
                    }
                }
                // System.out.println("Foram encontradas " + qtdNotas + " notas");
                if (qtdNotas < 50) {
                    // System.out.println("Saindo do for");
                    break;
                }
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return notas;
    }

    private String gerarMensagemXMLConsultaNFeRequest(ModelClientes prestador, String numeroNfe) throws Exception, URISyntaxException {

        String aux = null;
        File xmlFile = new File("data/ws/sp/saopaulo/PedidoConsultaNFe.xml");
        String mensagemXML = UtilFile.fileToStringInline(xmlFile).replaceAll("\t", "").replaceAll("[ ]+", " ").replaceAll("> <", "><");

        // Preenchimento do campo CPFCNPJRemetente
        if (ModelConfig.getInstance().getCnpj().length() == 14) {
            aux = "<CNPJ>".concat(ModelConfig.getInstance().getCnpj()).concat("</CNPJ>");
        } else if (ModelConfig.getInstance().getCnpj().length() == 11) {
            aux = "<CPF>".concat(ModelConfig.getInstance().getCnpj()).concat("</CPF>");
        }
        mensagemXML = mensagemXML.replaceAll("<##CPFCNPJRemetente##/>", aux);

        // Preenchimento do campo InscricaoPrestador
        aux = prestador.getInscricaoMunicipal();
        mensagemXML = mensagemXML.replaceAll("<##InscricaoPrestador##/>", aux);

        // Preenchimento do campo NumeroNFe
        mensagemXML = mensagemXML.replaceAll("<##NumeroNFe##/>", numeroNfe);

        // Assinatura
        mensagemXML = new UtilXmlSign().signXml(mensagemXML).replaceAll("\n|\r", "");

        // Validação
        new UtilXmlValidator().valida(mensagemXML, new File("data/ws/sp/saopaulo/PedidoConsultaNFe_v01.xsd"));

        return mensagemXML;
    }

    public String consultaNfe(ModelClientes prestador, String numeroNfe) {

        try { // Call Web Service Operation
            br.gov.sp.prefeitura.nfe.LoteNFe service = new br.gov.sp.prefeitura.nfe.LoteNFe();
            br.gov.sp.prefeitura.nfe.LoteNFeSoap port = service.getLoteNFeSoap();

            // TODO initialize WS operation arguments here
            br.gov.sp.prefeitura.nfe.ConsultaNFeRequest parameters = new br.gov.sp.prefeitura.nfe.ConsultaNFeRequest();
            parameters.setVersaoSchema(1);
            parameters.setMensagemXML(gerarMensagemXMLConsultaNFeRequest(prestador, numeroNfe));

            // TODO process result here
            br.gov.sp.prefeitura.nfe.ConsultaNFeResponse result = port.consultaNFe(parameters);
            System.out.println("Result = " + result.getRetornoXML());
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    public String gerarMensagemXMLEmissaoGuiaRequest(ModelClientes prestador, int tipoEmissaoGuia, int mes, int ano) throws IOException, InvalidAlgorithmParameterException, Exception {

        String aux = null;
        File xmlFile = new File("data/ws/sp/saoPaulo/PedidoEmissaoGuia.xml");
        String mensagemXML = UtilFile.fileToStringInline(xmlFile).replaceAll("\t", "").replaceAll("[ ]+", " ").replaceAll("> <", "><");

        // Preenchimento do campo CPFCNPJRemetente
        if (ModelConfig.getInstance().getCnpj().length() == 14) {
            aux = "<CNPJ>".concat(ModelConfig.getInstance().getCnpj()).concat("</CNPJ>");
        } else if (ModelConfig.getInstance().getCnpj().length() == 11) {
            aux = "<CPF>".concat(ModelConfig.getInstance().getCnpj()).concat("</CPF>");
        }
        mensagemXML = mensagemXML.replaceAll("<##CPFCNPJRemetente##/>", aux);

        // Preenchimento do campo InscricaoPrestador
        aux = prestador.getInscricaoMunicipal();
        mensagemXML = mensagemXML.replaceAll("<##InscricaoPrestador##/>", aux);

        // Preenchimento do campo TipoEmissaoGuia
        mensagemXML = mensagemXML.replaceAll("<##TipoEmissaoGuia##/>", Integer.toString(tipoEmissaoGuia));

        // Preenchimento do campo Incidencia
        mensagemXML = mensagemXML.replaceAll("<##Incidencia##/>", Integer.toString(ano).concat("-").concat(MyUtils.strTamanhoMax(Integer.toString(mes), 2, "numerico")));

        // Preenchimento do campo DataPagamento
        UtilDatas ud = new UtilDatas();
        Calendar cal = Calendar.getInstance();
        System.out.println("Mes: " + mes);
        if (mes != 12) {
            cal.set(ano, mes - 1, 10);
        } else {
            cal.set(ano + 1, 0, 10);
        }
        cal = ud.diaUtil(cal);
        ano = cal.get(Calendar.YEAR);
        mes = cal.get(Calendar.MONTH) + 1;
        String dia = MyUtils.strTamanhoMax(Integer.toString(cal.get(Calendar.DAY_OF_MONTH)), 2, "numerico");
        mensagemXML = mensagemXML.replaceAll("<##DataPagamento##/>", Integer.toString(ano).concat("-").concat(MyUtils.strTamanhoMax(Integer.toString(mes), 2, "numerico")).concat("-").concat(dia));

        // Assinatura
        mensagemXML = new UtilXmlSign().signXml(mensagemXML).replaceAll("\n|\r", "");

        // Validação
        //new UtilXmlValidator().valida(mensagemXML, new File("data/ws/sp/saoPaulo/EmissaoGuiaAsync_v01.xsd"));
        System.out.println(mensagemXML);

        return mensagemXML;
    }

    public String emissaoGuiaAsync(ModelClientes prestador, int tipoEmissaoGuia, int mes, int ano) {

        br.gov.sp.prefeitura.nfeAsync.LoteNFeAsync service = new br.gov.sp.prefeitura.nfeAsync.LoteNFeAsync();
        br.gov.sp.prefeitura.nfeAsync.LoteNFeAsyncSoap port = service.getLoteNFeAsyncSoap();

        // TODO initialize WS operation arguments here
        br.gov.sp.prefeitura.nfeAsync.EmissaoGuiaRequest parameters = new br.gov.sp.prefeitura.nfeAsync.EmissaoGuiaRequest();
        parameters.setVersaoSchema(1);
        try {
            parameters.setMensagemXML(gerarMensagemXMLEmissaoGuiaRequest(prestador, tipoEmissaoGuia, mes, ano));
        } catch (InvalidAlgorithmParameterException ex) {
            Logger.getLogger(ControllerWebService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ControllerWebService.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO process result here
        br.gov.sp.prefeitura.nfeAsync.EmissaoGuiaResponse result = port.emissaoGuiaAsync(parameters);
        System.out.println("Erros:");
        for (TpEventoAsync erro : result.getEmissaoGuiaResult().getErro()) {
            System.out.println("Erro " + erro.getCodigo() + ": " + erro.getDescricao());
        }
        //System.out.println("Sucesso = " + result.getEmissaoGuiaResult().getCabecalho().isSucesso());
        //System.out.println("Protocolo = " + result.getEmissaoGuiaResult().getCabecalho().getInformacoesGuia().getNumeroProtocolo());
        return result.getEmissaoGuiaResult().getCabecalho().getInformacoesGuia().getNumeroProtocolo();

    }

    public String emissaoGuiaAsync2(ModelClientes prestador, int tipoEmissaoGuia, int mes, int ano) {

        try { // Call Web Service Operation
            br.gov.sp.prefeitura.nfeAsync.LoteNFeAsync service = new br.gov.sp.prefeitura.nfeAsync.LoteNFeAsync();
            br.gov.sp.prefeitura.nfeAsync.LoteNFeAsyncSoap port = service.getLoteNFeAsyncSoap12();
            // TODO initialize WS operation arguments here
            br.gov.sp.prefeitura.nfeAsync.EmissaoGuiaRequest parameters = new br.gov.sp.prefeitura.nfeAsync.EmissaoGuiaRequest();
            parameters.setVersaoSchema(1);
            parameters.setMensagemXML(gerarMensagemXMLEmissaoGuiaRequest(prestador, tipoEmissaoGuia, mes, ano));
            // TODO process result here
            br.gov.sp.prefeitura.nfeAsync.EmissaoGuiaResponse result = port.emissaoGuiaAsync(parameters);
            System.out.println("Erros:");
            for (TpEventoAsync erro : result.getEmissaoGuiaResult().getErro()) {
                System.out.println("Erro " + erro.getCodigo() + ": " + erro.getDescricao());
            }
            System.out.println("Sucesso = " + result.getEmissaoGuiaResult().getCabecalho().isSucesso());
            System.out.println("Protocolo = " + result.getEmissaoGuiaResult().getCabecalho().getInformacoesGuia().getNumeroProtocolo());
            return result.getEmissaoGuiaResult().getCabecalho().getInformacoesGuia().getNumeroProtocolo();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    public String consultaSituacaoGuia(String numeroProtocolo) {

        try { // Call Web Service Operation
            br.gov.sp.prefeitura.nfeAsync.LoteNFeAsync service = new br.gov.sp.prefeitura.nfeAsync.LoteNFeAsync();
            br.gov.sp.prefeitura.nfeAsync.LoteNFeAsyncSoap port = service.getLoteNFeAsyncSoap();
            // TODO initialize WS operation arguments here
            br.gov.sp.prefeitura.nfeAsync.ConsultaSituacaoGuiaRequest parameters = null;
            // TODO process result here
            br.gov.sp.prefeitura.nfeAsync.ConsultaSituacaoGuiaResponse result = port.consultaSituacaoGuia(parameters);
            System.out.println("Result = " + result.getRetornoXML());
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    private String gerarMensagemXMLConsultaGuia(ModelClientes prestador, int mesIncidencia, int anoIncidencia, int situacao) throws IOException, InvalidAlgorithmParameterException, Exception {

        String aux = null;
        File xmlFile = new File("data/ws/sp/saoPaulo/PedidoConsultaGuia.xml");
        String mensagemXML = UtilFile.fileToStringInline(xmlFile).replaceAll("\t", "").replaceAll("[ ]+", " ").replaceAll("> <", "><");

        // Preenchimento do campo CPFCNPJRemetente
        if (ModelConfig.getInstance().getCnpj().length() == 14) {
            aux = "<CNPJ>".concat(ModelConfig.getInstance().getCnpj()).concat("</CNPJ>");
        } else if (ModelConfig.getInstance().getCnpj().length() == 11) {
            aux = "<CPF>".concat(ModelConfig.getInstance().getCnpj()).concat("</CPF>");
        }
        mensagemXML = mensagemXML.replaceAll("<##CPFCNPJRemetente##/>", aux);

        // Preenchimento do campo InscricaoPrestador
        aux = prestador.getInscricaoMunicipal();
        mensagemXML = mensagemXML.replaceAll("<##InscricaoPrestador##/>", aux);

        // Preenchimento do campo Incidencia
        mensagemXML = mensagemXML.replaceAll("<##Incidencia##/>", Integer.toString(anoIncidencia).concat("-").concat(MyUtils.strTamanhoMax(Integer.toString(mesIncidencia), 2, "numerico")));

        // Preenchimento do campo Situacao
        mensagemXML = mensagemXML.replaceAll("<##Situacao##/>", Integer.toString(situacao));

        // Assinatura
        mensagemXML = new UtilXmlSign().signXml(mensagemXML).replaceAll("\n|\r", "");

        // Validação
        new UtilXmlValidator().valida(mensagemXML, new File("data/ws/sp/saoPaulo/ConsultaGuia_v01.xsd"));
        //System.out.println(mensagemXML);

        return mensagemXML;
    }

    public String consultaGuia(ModelClientes prestador, int mesIncidencia, int anoIncidencia, int situacao) {

        try { // Call Web Service Operation
            br.gov.sp.prefeitura.nfeAsync.LoteNFeAsync service = new br.gov.sp.prefeitura.nfeAsync.LoteNFeAsync();
            br.gov.sp.prefeitura.nfeAsync.LoteNFeAsyncSoap port = service.getLoteNFeAsyncSoap();
            // TODO initialize WS operation arguments here
            br.gov.sp.prefeitura.nfeAsync.ConsultaGuiaRequest parameters = new br.gov.sp.prefeitura.nfeAsync.ConsultaGuiaRequest();
            parameters.setVersaoSchema(1);
            parameters.setMensagemXML(gerarMensagemXMLConsultaGuia(prestador, mesIncidencia, anoIncidencia, situacao));
            // TODO process result here
            br.gov.sp.prefeitura.nfeAsync.ConsultaGuiaResponse result = port.consultaGuia(parameters);
            System.out.println("Result = " + result.toString());
        } catch (Exception ex) {
            System.out.printf("Exception: %s\n", ex.getMessage());
        }

        return null;
    }

}
