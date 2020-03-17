package com.aldeiaconsultoriajr.nfe.rs.canoas;

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
    @XStreamAlias("ValorIssRetido")
    private String valorIssRetido;
    @XStreamAlias("OutrasRetencoes")
    private String outrasRetencoes;
    @XStreamAlias("BaseCalculo")
    private String baseCalculo;
    @XStreamAlias("Aliquota")
    private String aliquota;
    @XStreamAlias("ValorLiquidoNfse")
    private String valorLiquidoNfse;
    @XStreamAlias("DescontoIncondicionado")
    private String descontoIncondicionado;
    @XStreamAlias("DescontoCondicionado")
    private String descontoCondicionado;

    public String getValorServicos() {
        return valorServicos;
    }

    public void setValorServicos(String valorServicos) {
        this.valorServicos = valorServicos;
    }

    public String getValorDeducoes() {
        return valorDeducoes;
    }

    public void setValorDeducoes(String valorDeducoes) {
        this.valorDeducoes = valorDeducoes;
    }

    public String getValorPis() {
        return valorPis;
    }

    public void setValorPis(String valorPis) {
        this.valorPis = valorPis;
    }

    public String getValorCofins() {
        return valorCofins;
    }

    public void setValorCofins(String valorCofins) {
        this.valorCofins = valorCofins;
    }

    public String getValorInss() {
        return valorInss;
    }

    public void setValorInss(String valorInss) {
        this.valorInss = valorInss;
    }

    public String getValorIr() {
        return valorIr;
    }

    public void setValorIr(String valorIr) {
        this.valorIr = valorIr;
    }

    public String getValorCsll() {
        return valorCsll;
    }

    public void setValorCsll(String valorCsll) {
        this.valorCsll = valorCsll;
    }

    public String getIssRetido() {
        return issRetido;
    }

    public void setIssRetido(String issRetido) {
        this.issRetido = issRetido;
    }

    public String getValorIss() {
        return valorIss;
    }

    public void setValorIss(String valorIss) {
        this.valorIss = valorIss;
    }

    public String getValorIssRetido() {
        return valorIssRetido;
    }

    public void setValorIssRetido(String valorIssRetido) {
        this.valorIssRetido = valorIssRetido;
    }

    public String getOutrasRetencoes() {
        return outrasRetencoes;
    }

    public void setOutrasRetencoes(String outrasRetencoes) {
        this.outrasRetencoes = outrasRetencoes;
    }

    public String getBaseCalculo() {
        return baseCalculo;
    }

    public void setBaseCalculo(String baseCalculo) {
        this.baseCalculo = baseCalculo;
    }

    public String getAliquota() {
        return aliquota;
    }

    public void setAliquota(String aliquota) {
        this.aliquota = aliquota;
    }

    public String getValorLiquidoNfse() {
        return valorLiquidoNfse;
    }

    public void setValorLiquidoNfse(String valorLiquidoNfse) {
        this.valorLiquidoNfse = valorLiquidoNfse;
    }

    public String getDescontoIncondicionado() {
        return descontoIncondicionado;
    }

    public void setDescontoIncondicionado(String descontoIncondicionado) {
        this.descontoIncondicionado = descontoIncondicionado;
    }

    public String getDescontoCondicionado() {
        return descontoCondicionado;
    }

    public void setDescontoCondicionado(String descontoCondicionado) {
        this.descontoCondicionado = descontoCondicionado;
    }
}
