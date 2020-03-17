package com.constanzooficial.integracao.model.nfse.es.colatina;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Luis Sanches
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
    
    @XStreamAlias("ValorIss")
    private String valorIss;
    
    @XStreamAlias("ValorLiquidoNfse")
    private String valorLiquidoNfse;
    
    @XStreamAlias("OutrosDescontos")
    private String outrosDescontos;

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

    public String getValorIss() {
        return valorIss;
    }

    public String getValorLiquidoNfse() {
        return valorLiquidoNfse;
    }

    public String getOutrosDescontos() {
        return outrosDescontos;
    }
    
}
