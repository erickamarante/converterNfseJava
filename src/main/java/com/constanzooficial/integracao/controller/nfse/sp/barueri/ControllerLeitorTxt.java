package com.constanzooficial.integracao.controller.nfse.sp.barueri;

import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelCabecalho;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelDetalhe;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelDetalheComparator;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelNota;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelRodape;
import com.constanzooficial.integracao.util.MyUtils;
import com.constanzooficial.integracao.util.UtilFile;
import com.constanzooficial.integracao.util.UtilZip;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Waislan Luis Sanches
 */
public class ControllerLeitorTxt {

    public ModelNota lerNotas(File[] arquivos, boolean considerarIss, String cpfCnpjPrestador) throws IOException {

        ArrayList<File> txts = extrairZips(arquivos);

        double valorTotalServicos = 0;
        double valorTotalDeducoes = 0;
        double valorTotalIss = 0;
        double valorTotalCredito = 0;

        ArrayList<ModelDetalhe> detalhes = new ArrayList<>();

        for (File f : txts) {

            ArrayList<String> linhas = UtilFile.readFile(f);
            ModelDetalhe d = new ModelDetalhe();

            String inscricaoPrestador = linhas.get(0).substring(1, 8);

            for (int i = 1; i < linhas.size() - 1; i++) {
                String linha = linhas.get(i);

                if (linha.startsWith("2")) {
                    d = new ModelDetalhe();

                    if (cpfCnpjPrestador.length() == 11) {
                        d.setIndicadorCpfCnpjPrestador("1");
                    } else if (cpfCnpjPrestador.length() == 14) {
                        d.setIndicadorCpfCnpjPrestador("1");
                    }
                    d.setCpfCnpjPrestador(cpfCnpjPrestador);

                    d.setNumeroNfse(Integer.toString(Integer.valueOf(linha.substring(6, 12))));

                    String[] aux = new String[6];
                    aux[0] = linha.substring(18, 20);
                    aux[1] = linha.substring(16, 18);
                    aux[2] = linha.substring(12, 16);
                    aux[3] = linha.substring(20, 22);
                    aux[4] = linha.substring(22, 24);
                    aux[5] = linha.substring(24, 26);
                    d.setDataHoraNfse(aux);

                    d.setDataEmissaoRps(aux);

                    d.setInscricaoMunicipalPrestador(inscricaoPrestador);

                    if (linha.substring(66, 67).equals("C")) {
                        d.setSituacaoNotaFiscal("C");
                        aux = new String[3];
                        aux[0] = linha.substring(73, 75);
                        aux[1] = linha.substring(71, 73);
                        aux[2] = linha.substring(67, 71);
                        d.setDataCancelamento(aux);
                    }

                    d.setIssRetido(linha.substring(65, 66));

                    d.setCpfCnpjTomador(linha.substring(93, 107).trim());
                    d.setIndicadorCpfCnpjTomador(d.getCpfCnpjTomador().length() == 11 ? "1" : "2");

                    d.setRazaoSocialTomador(linha.substring(107, 207).trim());

                    aux = MyUtils.separaTipoEndereco(linha.substring(207, 307).trim());
                    d.setTipoEnderecoTomador(aux[0]);
                    d.setEnderecoTomador(aux[1]);

                    try {
                        d.setNumeroEnderecoTomador(Integer.toString(Integer.valueOf(linha.substring(307, 316).trim())));
                    } catch (Exception e) {
                        d.setNumeroEnderecoTomador(linha.substring(307, 316).trim());
                    }

                    d.setComplementoEnderecoTomador(linha.substring(316, 336).trim());

                    d.setBairroTomador(linha.substring(336, 376).trim());

                    d.setCidadeTomador(linha.substring(376, 416).trim());

                    d.setUfTomador(linha.substring(416, 418).trim());

                    d.setCepTomador(linha.substring(418, 426).trim());

                    d.setEmailTomador(linha.substring(476, 628).trim());

                    d.setDiscriminacaoServicos(linha.substring(628, 1628).trim());
                } else if (linha.startsWith("3")) {

                    d.setCodigoServicoPrestadoNotaFiscal(linha.substring(67, 76).trim());

                    double valorServicos = Double.valueOf(linha.substring(76, 89) + "." + linha.substring(89, 91)) * Double.valueOf(linha.substring(1, 7));
                    d.setValorServicos(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorServicos));
                    if (!d.getSituacaoNotaFiscal().equals("C")) {
                        valorTotalServicos += valorServicos;
                    }

                    d.setAliquota(considerarIss ? linha.substring(91, 95) : "0");

                    double valorIss = valorServicos * Double.valueOf(linha.substring(91, 93) + "." + linha.substring(93, 95)) / 100;
                    if (considerarIss) {
                        d.setValorIss(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorIss));
                        if (!d.getSituacaoNotaFiscal().equals("C")) {
                            valorTotalIss += valorIss;
                        }
                    }

                    detalhes.add(d);
                }
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

    private ArrayList<File> extrairZips(File[] files) throws IOException {

        ArrayList<File> retorno = new ArrayList<>();
        File destFolder = new File("tmp");

        for (File f : files) {
            if (f.getName().toLowerCase().endsWith(".zip")) {
                UtilZip.unzipArchive(f, destFolder);
            } else {
                retorno.add(f);
            }
        }

        if (destFolder.listFiles() != null) {
            for (File f : destFolder.listFiles()) {
                retorno.add(f);
            }
        }

        return retorno;
    }

}
