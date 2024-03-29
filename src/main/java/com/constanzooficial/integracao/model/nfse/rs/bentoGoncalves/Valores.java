package com.constanzooficial.integracao.model.nfse.rs.bentoGoncalves;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
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
    
    @XStreamAlias("IssRetido")
    private String issRetido;
    
    @XStreamAlias("ValorIss")
    private String valorIss;
    
    @XStreamAlias("OutrasRetencoes")
    private String outrasRetencoes;
    
    @XStreamAlias("BaseCalculo")
    private String baseCalculo;
    
    @XStreamAlias("Aliquota")
    private String aliquota;
    
    @XStreamAlias("ValorLiquidoNfse")
    private String valorLiquidoNfse;
    
    @XStreamAlias("DescontoCondicionado")
    private String descontoCondicionado;
    
    @XStreamAlias("DescontoIncondicionado")
    private String descontoIncondicionado;

    public String getValorServicos() {
        return valorServicos;
    }

    public String getValorDeducoes() {
        return valorDeducoes;
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

    public String getValorLiquidoNfse() {
        return valorLiquidoNfse;
    }

    public String getDescontoCondicionado() {
        return descontoCondicionado;
    }

    public String getDescontoIncondicionado() {
        return descontoIncondicionado;
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
}
