package com.constanzooficial.integracao.model.nfse.rn.caico;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("Valores")
public class Valores {
    
    @XStreamAlias("ValorServicos")
    private String valorServicos;
    
    @XStreamAlias("IssRetido")
    private String issRetido;
    
    @XStreamAlias("ValorIss")
    private String valorIss;
    
    @XStreamAlias("BaseCalculo")
    private String baseCalculo;
    
    @XStreamAlias("Aliquota")
    private String aliquota;
    
    @XStreamAlias("ValorLiquidoNfse")
    private IdentificacaoRps valorLiquidoNfse;

    public String getValorServicos() {
        return valorServicos;
    }

    public String getIssRetido() {
        return issRetido;
    }

    public String getValorIss() {
        return valorIss;
    }

    public String getBaseCalculo() {
        return baseCalculo;
    }

    public String getAliquota() {
        return aliquota;
    }

    public IdentificacaoRps getValorLiquidoNfse() {
        return valorLiquidoNfse;
    }

    public void setValorLiquidoNfse(IdentificacaoRps valorLiquidoNfse) {
        this.valorLiquidoNfse = valorLiquidoNfse;
    }
}
