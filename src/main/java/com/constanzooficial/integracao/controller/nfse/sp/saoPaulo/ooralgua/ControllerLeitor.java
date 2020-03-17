package com.constanzooficial.integracao.controller.nfse.sp.saoPaulo.ooralgua;

import com.aldeiaconsultoriajr.util.ExcelReader;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelCabecalho;
import com.constanzooficial.integracao.util.MyUtils;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelDetalhe;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelDetalheComparator;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelNota;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelRodape;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import org.jfree.date.SerialDate;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
public class ControllerLeitor {

    public ModelNota lerArquivo(File arquivo) throws IOException {

        ArrayList<ModelDetalhe> detalhes = new ArrayList<>();
        ModelNota nota = new ModelNota();
        ExcelReader er = new ExcelReader(new FileInputStream(arquivo));

        er.selecionarLinha(0);
        String razaoSocialPrestador = er.getConteudoCelulaString(1);
        String inscricaoMunicipalPrestador = er.getConteudoCelulaString(10);
        String cpfCnpjPrestador = MyUtils.trataCpfCnpj(er.getConteudoCelulaString(13));
        er.selecionarLinha(1);
        String[] endereco = MyUtils.separaTipoEndereco(er.getConteudoCelulaString(1), 3, 50);
        String tipoEnderecoPrestador = endereco[0];
        String enderecoPrestador = endereco[1];
        String numeroEnderecoPrestador = er.getConteudoCelulaString(10);
        String bairroPrestador = er.getConteudoCelulaString(13);
        er.selecionarLinha(2);
        String cidadePrestador = er.getConteudoCelulaString(1);
        String ufPrestador = er.getConteudoCelulaString(10);
        String cepPrestador = er.getConteudoCelulaString(13).replaceAll("[^0-9]", "");

        double valorTotalServicos = 0;
        double valorTotalDeducoes = 0;

        for (int i = 6; i < er.numeroLinhas(); i++) {

            er.selecionarLinha(i);

            if (er.selecionarLinha(i) && !er.linhaEmBranco()) {// && er.getCelula(0).getCellTypeEnum() == CellType.NUMERIC

                ModelDetalhe detalhe = new ModelDetalhe();

                String[] data = new String[3];
                switch (er.getCelula(0).getCellTypeEnum()) {
                    
                    case NUMERIC:
                        SerialDate sd = SerialDate.createInstance(new Double(er.getCelula(0).getNumericCellValue()).intValue());
                        data[0] = MyUtils.strTamanhoMax(Integer.toString(sd.getDayOfMonth()), 2, "numerico");
                        data[1] = MyUtils.strTamanhoMax(Integer.toString(sd.getMonth()), 2, "numerico");
                        data[2] = MyUtils.strTamanhoMax(Integer.toString(sd.getYYYY()), 4, "numerico");
                        break;
                    case STRING:
                        data = er.getCelula(0).getStringCellValue().split("/");
                        break;
                }

                String numero = er.getConteudoCelulaString(1);
                detalhe.setNumeroNfse(numero);

                detalhe.setDataHoraNfse(data);
                detalhe.setDataEmissaoRps(data);

                detalhe.setInscricaoMunicipalPrestador(inscricaoMunicipalPrestador);

                detalhe.setCpfCnpjPrestador(cpfCnpjPrestador);

                String codigoServico = er.getConteudoCelulaString(2);
                detalhe.setCodigoServicoPrestadoNotaFiscal(codigoServico);

                double valorNota = er.getCelula(4).getNumericCellValue();
                valorTotalServicos += valorNota;
                detalhe.setValorServicos(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorNota));

                double valorDeducoes = valorNota - er.getCelula(5).getNumericCellValue();
                valorTotalDeducoes += valorDeducoes;
                detalhe.setValorDeducoes(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorDeducoes));

                String cpf = er.getConteudoCelulaString(7);
                cpf = MyUtils.trataCpf(cpf);
                detalhe.setCpfCnpjTomador(cpf);

                String nome = er.getConteudoCelulaString(6);
                detalhe.setRazaoSocialTomador(nome);

                detalhe.setTipoEnderecoTomador(tipoEnderecoPrestador);

                detalhe.setEnderecoTomador(enderecoPrestador);

                detalhe.setNumeroEnderecoTomador(numeroEnderecoPrestador);

                detalhe.setBairroTomador(bairroPrestador);

                detalhe.setCidadeTomador(cidadePrestador);

                detalhe.setUfTomador(ufPrestador);

                detalhe.setCepTomador(cepPrestador);

                detalhes.add(detalhe);
            }
        }

        Collections.sort(detalhes, new ModelDetalheComparator());

        ModelCabecalho cabecalho = new ModelCabecalho();
        cabecalho.setInscricaoMunicipalContribuinte(inscricaoMunicipalPrestador);
        cabecalho.setDataInicioArquivo(detalhes.get(0).getDataHoraNfse());
        cabecalho.setDataFimArquivo(detalhes.get(detalhes.size() - 1).getDataHoraNfse());

        ModelRodape rodape = new ModelRodape();
        rodape.setValorTotalServicos(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorTotalServicos));
        rodape.setValorTotalDeducoes(MyUtils.doubleParaStringSemPontoCom2CasasDecimais(valorTotalDeducoes));

        nota.setCabecalho(cabecalho);
        nota.setDetalhe(detalhes);
        nota.setRodape(rodape);

        for (ModelDetalhe det : detalhes) {

        }

        return nota;
    }
}
