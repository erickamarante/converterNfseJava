package com.constanzooficial.integracao.model.nfse.sc.agrolandia2;

import com.constanzooficial.integracao.util.MyUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;
/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("nf")
public class Nf {

    @XStreamAlias("numero_nfse")
    private String numeroNfse;

    @XStreamAlias("serie_nfse")
    private String serieNfse;

    @XStreamAlias("data_nfse")
    private String dataNfse;
    
    @XStreamAlias("hora_nfse")
    private String horaNfse;
    
    @XStreamAlias("valor_total")
    private String valorTotal;
    
    @XStreamAlias("valor_desconto")
    private String valorDesconto;
    
    @XStreamAlias("valor_ir")
    private String valorIr;
    
    @XStreamAlias("valor_inss")
    private String valorInss;
    
    @XStreamAlias("valor_contribuicao_social")
    private String valorContribuicaoSocial;
    
    @XStreamAlias("valor_rps")
    private String valorRps;
    
    @XStreamAlias("valor_pis")
    private String valorPis;
    
    @XStreamAlias("valor_cofins")
    private String valorCofins;
    
    @XStreamAlias("observacao")
    private String observacao;
    
    @XStreamAlias("situacao")
    private String situacao;

    public String getNumeroNfse() {
        return numeroNfse;
    }

    public String getSerieNfse() {
        return serieNfse;
    }
    
    public String[] getDataNfse() {
        String[] dataHora = MyUtils.trataDataHora3(dataNfse, horaNfse);
        //dataHora[5] = dataHora[5].split("\\.")[0];
        return dataHora;
    }

    public String getHoraNfse() {
        return horaNfse;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public String getValorDesconto() {
        return valorDesconto;
    }

    public String getValorIr() {
        return valorIr;
    }

    public String getValorInss() {
        return valorInss;
    }

    public String getValorContribuicaoSocial() {
        return valorContribuicaoSocial;
    }

    public String getValorRps() {
        return valorRps;
    }

    public String getValorPis() {
        return valorPis;
    }

    public String getValorCofins() {
        return valorCofins;
    }

    public String getObservacao() {
        return observacao;
    }

    public String getSituacao() {
        return situacao;
    }

}
