package com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001;

import com.constanzooficial.integracao.util.MyUtils;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
public class ModelCabecalho {

    // Registro tipo 1 - cabeçalho
    private String tipoRegistro;
    private String versaoArquivo;
    private String inscricaoMunicipalContribuinte;
    private String razaoSocialContribuinte;
    private String[] dataInicioArquivo;
    private String[] dataFimArquivo;

    public ModelCabecalho() {

        this.tipoRegistro = "1";
        this.versaoArquivo = "001";
    }

    public String getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(String tipoRegistro) {
        this.tipoRegistro = MyUtils.strTamanhoMax(tipoRegistro, 1, "numerico");
    }

    public String getVersaoArquivo() {
        return versaoArquivo;
    }

    public void setVersaoArquivo(String versaoArquivo) {
        this.versaoArquivo = MyUtils.strTamanhoMax(versaoArquivo, 3, "numerico");
    }

    public String getInscricaoMunicipalContribuinte() {
        if (this.inscricaoMunicipalContribuinte == null) {
            this.setInscricaoMunicipalContribuinte(null);
        }
        return inscricaoMunicipalContribuinte;
    }

    public void setInscricaoMunicipalContribuinte(String inscricaoMunicipalContribuinte) {
        this.inscricaoMunicipalContribuinte = MyUtils.strTamanhoMax(inscricaoMunicipalContribuinte, 8, "numerico");
    }

    public String[] getDataInicioArquivo() {
        if (this.dataInicioArquivo == null) {
            this.setDataInicioArquivo(null);
        }
        return dataInicioArquivo;
    }

    public void setDataInicioArquivo(String[] dataInicioArquivo) {

        this.dataInicioArquivo = new String[3];
        if (dataInicioArquivo != null) {
            this.dataInicioArquivo[0] = MyUtils.strTamanhoMax(dataInicioArquivo[0], 2, "numerico");
            this.dataInicioArquivo[1] = MyUtils.strTamanhoMax(dataInicioArquivo[1], 2, "numerico");
            this.dataInicioArquivo[2] = MyUtils.strTamanhoMax(dataInicioArquivo[2], 4, "numerico");
        } else {
            this.dataInicioArquivo[0] = MyUtils.strTamanhoMax(null, 2, "numerico");
            this.dataInicioArquivo[1] = MyUtils.strTamanhoMax(null, 2, "numerico");
            this.dataInicioArquivo[2] = MyUtils.strTamanhoMax(null, 4, "numerico");
        }
    }

    public String[] getDataFimArquivo() {
        if (this.dataFimArquivo == null) {
            this.setDataFimArquivo(null);
        }
        return dataFimArquivo;
    }

    public void setDataFimArquivo(String[] dataFimArquivo) {
        this.dataFimArquivo = new String[3];
        if (dataFimArquivo != null) {
            this.dataFimArquivo[0] = MyUtils.strTamanhoMax(dataFimArquivo[0], 2, "numerico");
            this.dataFimArquivo[1] = MyUtils.strTamanhoMax(dataFimArquivo[1], 2, "numerico");
            this.dataFimArquivo[2] = MyUtils.strTamanhoMax(dataFimArquivo[2], 4, "numerico");
        } else {
            this.dataFimArquivo[0] = MyUtils.strTamanhoMax(null, 2, "numerico");
            this.dataFimArquivo[1] = MyUtils.strTamanhoMax(null, 2, "numerico");
            this.dataFimArquivo[2] = MyUtils.strTamanhoMax(null, 4, "numerico");
        }
    }

    public String getRazaoSocialContribuinte() {
        return razaoSocialContribuinte;
    }

    public void setRazaoSocialContribuinte(String razaoSocialContribuinte) {
        this.razaoSocialContribuinte = razaoSocialContribuinte;
    }
}
