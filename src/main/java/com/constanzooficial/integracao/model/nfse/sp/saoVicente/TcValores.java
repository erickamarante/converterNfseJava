package com.constanzooficial.integracao.model.nfse.sp.saoVicente;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("tc:Valores")
public class TcValores {

    @XStreamAlias("tc:ValorServicos")
    private String tcValorServicos;

    @XStreamAlias("tc:ValorDeducoes")
    private String tcValorDeducoes;

    @XStreamAlias("tc:ValorPis")
    private String tcValorPis;

    @XStreamAlias("tc:ValorCofins")
    private String tcValorCofins;

    @XStreamAlias("tc:ValorInss")
    private String tcValorInss;

    @XStreamAlias("tc:ValorIr")
    private String tcValorIr;

    @XStreamAlias("tc:ValorCsll")
    private String tcValorCsll;

    @XStreamAlias("tc:IssRetido")
    private String tcIssRetido;

    @XStreamAlias("tc:OutrasRetencoes")
    private String tcOutrasRetencoes;

    @XStreamAlias("tc:BaseCalculo")
    private String tcBaseCalculo;

    @XStreamAlias("tc:Aliquota")
    private String tcAliquota;

    @XStreamAlias("tc:ValorLiquidoNfse")
    private String tcValorLiquidoNfse;

    @XStreamAlias("tc:ValorIssRetido")
    private String tcValorIssRetido;

    @XStreamAlias("tc:ValorIss")
    private String tcValorIss;

    @XStreamAlias("tc:DescontoCondicionado")
    private String tcDescontoCondicionado;

    @XStreamAlias("tc:DescontoIncondicionado")
    private String tcDescontoIncondicionado;

    public String getTcValorServicos() {
        return tcValorServicos;
    }

    public String getTcValorDeducoes() {
        return tcValorDeducoes;
    }

    public String getTcValorPis() {
        return tcValorPis;
    }

    public String getTcValorCofins() {
        return tcValorCofins;
    }

    public String getTcValorInss() {
        return tcValorInss;
    }

    public String getTcValorIr() {
        return tcValorIr;
    }

    public String getTcValorCsll() {
        return tcValorCsll;
    }

    public String getTcIssRetido() {
        return tcIssRetido;
    }

    public String getTcOutrasRetencoes() {
        return tcOutrasRetencoes;
    }

    public String getTcBaseCalculo() {
        return tcBaseCalculo;
    }

    public String getTcAliquota() {
        return tcAliquota;
    }

    public String getTcValorLiquidoNfse() {
        return tcValorLiquidoNfse;
    }

    public String getTcValorIssRetido() {
        return tcValorIssRetido;
    }

    public String getTcValorIss() {
        return tcValorIss;
    }

    public String getTcDescontoCondicionado() {
        return tcDescontoCondicionado;
    }

    public String getTcDescontoIncondicionado() {
        return tcDescontoIncondicionado;
    }
}
