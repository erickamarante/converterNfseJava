package com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001;

import com.constanzooficial.integracao.util.MyUtils;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
public class ModelRodape {

    // Registro tipo 9 - rodapé
    private String tipoRegistro;
    private String numeroLinhasDetalhe;
    private String valorTotalServicos;
    private String valorTotalDeducoes;
    private String valorTotalIss;
    private String valorTotalCreditos;

    public ModelRodape() {
        this.tipoRegistro = "9";
    }

    public String getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(String tipoRegistro) {
        this.tipoRegistro = MyUtils.strTamanhoMax(tipoRegistro, 1, "numerico");
    }

    public String getNumeroLinhasDetalhe() {
        if (this.numeroLinhasDetalhe == null) {
            this.setNumeroLinhasDetalhe(null);
        }
        return numeroLinhasDetalhe;
    }

    public void setNumeroLinhasDetalhe(String numeroLinhasDetalhe) {
        this.numeroLinhasDetalhe = MyUtils.strTamanhoMax(numeroLinhasDetalhe, 7, "numerico");
    }

    public String getValorTotalServicos() {
        if (this.valorTotalServicos == null) {
            this.setValorTotalServicos(null);
        }
        return valorTotalServicos;
    }

    public void setValorTotalServicos(String valorTotalServicos) {
        this.valorTotalServicos = MyUtils.strTamanhoMax(valorTotalServicos, 15, "numerico");
    }

    public String getValorTotalDeducoes() {
        if (this.valorTotalDeducoes == null) {
            this.setValorTotalDeducoes(null);
        }
        return valorTotalDeducoes;
    }

    public void setValorTotalDeducoes(String valorTotalDeducoes) {
        this.valorTotalDeducoes = MyUtils.strTamanhoMax(valorTotalDeducoes, 15, "numerico");
    }

    public String getValorTotalIss() {
        if (this.valorTotalIss == null) {
            this.setValorTotalIss(null);
        }
        return valorTotalIss;
    }

    public void setValorTotalIss(String valorTotalIss) {
        this.valorTotalIss = MyUtils.strTamanhoMax(valorTotalIss, 15, "numerico");
    }

    public String getValorTotalCreditos() {
        if (this.valorTotalCreditos == null) {
            this.setValorTotalCreditos(null);
        }
        return valorTotalCreditos;
    }

    public void setValorTotalCreditos(String valorTotalCreditos) {
        this.valorTotalCreditos = MyUtils.strTamanhoMax(valorTotalCreditos, 15, "numerico");
    }
}
