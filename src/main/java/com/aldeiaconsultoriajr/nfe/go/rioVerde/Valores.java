package com.aldeiaconsultoriajr.nfe.go.rioVerde;

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
    @XStreamAlias("ValorIr")
    private String valorIr;
    @XStreamAlias("IssRetido")
    private String issRetido;
    @XStreamAlias("ValorIss")
    private String valorIss;
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

    public String getValorIr() {
        return valorIr;
    }

    public boolean getIssRetido() {
        return !"2".equals(issRetido);
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
}
