package com.constanzooficial.integracao.model.nfse.mt.campoNovoDoParecis;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ValoresNfse")
public class ValoresNfse {
    
    @XStreamAlias("BaseCalculo")
    private String baseCalculo;
    
    @XStreamAlias("Aliquota")
    private String aliquota;
    
    @XStreamAlias("ValorIss")
    private String valorIss;
    
    @XStreamAlias("ValorLiquidoNfse")
    private String valorLiquidoNfse;

    public String getBaseCalculo() {
        return baseCalculo;
    }

    public String getAliquota() {
        return aliquota;
    }

    public String getValorIss() {
        return valorIss;
    }

    public String getValorLiquidoNfse() {
        return valorLiquidoNfse;
    }

}
