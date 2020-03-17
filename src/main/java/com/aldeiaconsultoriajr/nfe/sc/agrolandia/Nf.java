package com.aldeiaconsultoriajr.nfe.sc.agrolandia;

import com.aldeiaconsultoriajr.util.MyUtils;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
public class Nf {

    private String numero_nfse;
    private String situacao;
    private String serie_nfse;
    private String data_nfse;
    private String hora_nfse;
    private String valor_total;
    private String valor_desconto;
    private String valor_ir;
    private String valor_inss;
    private String valor_contribuicao_social;
    private String valor_rps;
    private String valor_pis;
    private String valor_cofins;
    private String observacao;

    public String getNumero_nfse() {
        return numero_nfse;
    }

    public String getSituacao() {
        return situacao;
    }

    public String getSerie_nfse() {
        return serie_nfse;
    }

    public String[] getData_nfse() {
        return MyUtils.trataData(data_nfse);
    }

    public String[] getHora_nfse() {
        return MyUtils.trataHora(hora_nfse);
    }

    public String getValor_total() {
        return MyUtils.trataValor(valor_total);
    }

    public String getValor_desconto() {
        return MyUtils.trataValor(valor_desconto);
    }

    public String getValor_ir() {
        return MyUtils.trataValor(valor_ir);
    }

    public String getValor_inss() {
        return MyUtils.trataValor(valor_inss);
    }

    public String getValor_contribuicao_social() {
        return MyUtils.trataValor(valor_contribuicao_social);
    }

    public String getValor_rps() {
        return MyUtils.trataValor(valor_rps);
    }

    public String getValor_pis() {
        return MyUtils.trataValor(valor_pis);
    }

    public String getValor_cofins() {
        return MyUtils.trataValor(valor_cofins);
    }

    public String getObservacao() {
        return observacao;
    }
}
