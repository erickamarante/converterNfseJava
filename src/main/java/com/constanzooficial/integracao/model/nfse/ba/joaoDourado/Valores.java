package com.constanzooficial.integracao.model.nfse.ba.joaoDourado;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("Valores")
public class Valores {
    
    @XStreamAlias("ValorServicos")
    private String valorServicos;
    
    @XStreamAlias("ValorDeducoes")
    private String valorDeducoes;

    @XStreamAlias("ValorPis")
    private String valorPis;

    @XStreamAlias("ValorCofins")
    private String valorCofins;
    
    @XStreamAlias("ValorInss")
    private String valorInss;
    
    @XStreamAlias("ValorIr")
    private String valorIr;
    
    @XStreamAlias("ValorCsll")
    private String valorCsll;
    
    @XStreamAlias("OutrasRetencoes")
    private String outrasRetencoes;
    
    @XStreamAlias("ValTotTributos")
    private String valTotTributos;
    
    @XStreamAlias("ValorIss")
    private String valorIss;
    
    @XStreamAlias("Aliquota")
    private String aliquota;
    
    @XStreamAlias("DescontoIncondicionado")
    private String descontoIncondicionado;
    
    @XStreamAlias("DescontoCondicionado")
    private String descontoCondicionado;

    public String getValorServicos() {
        return valorServicos;
    }

    public String getValorDeducoes() {
        return valorDeducoes;
    }

    public String getValorPis() {
        return valorPis;
    }

    public String getValorCofins() {
        return valorCofins;
    }

    public String getValorInss() {
        return valorInss;
    }

    public String getValorIr() {
        return valorIr;
    }

    public String getValorCsll() {
        return valorCsll;
    }

    public String getOutrasRetencoes() {
        return outrasRetencoes;
    }

    public String getValTotTributos() {
        return valTotTributos;
    }

    public String getValorIss() {
        return valorIss;
    }

    public String getAliquota() {
        return aliquota;
    }

    public String getDescontoIncondicionado() {
        return descontoIncondicionado;
    }

    public String getDescontoCondicionado() {
        return descontoCondicionado;
    }
}
