package com.aldeiaconsultoriajr.nfe.rs.canoas;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("InfNfse")
public class InfNfse {

    @XStreamAlias("id")
    @XStreamAsAttribute
    private String id;
    @XStreamAlias("Numero")
    private String numero;
    @XStreamAlias("Serie")
    private String serie;
    @XStreamAlias("Tipo")
    private String tipo;
    @XStreamAlias("CodigoVerificacao")
    private String codigoVerificacao;
    @XStreamAlias("DataEmissao")
    private String dataEmissao;
    @XStreamAlias("IdentificacaoRps")
    private IdentificacaoRps identificacaoRps;
    @XStreamAlias("DataEmissaoRps")
    private String dataEmissaoRps;
    @XStreamAlias("NaturezaOperacao")
    private String naturezaOperacao;
    @XStreamAlias("OptanteSimplesNacional")
    private String optanteSimplesNacional;
    @XStreamAlias("IncentivadorCultural")
    private String incentivadorCultural;
    @XStreamAlias("Competencia")
    private String competencia;
    @XStreamAlias("OutrasInformacoes")
    private String outrasInformacoes;
    @XStreamAlias("Servico")
    private Servico servico;
    @XStreamAlias("ValorCredito")
    private String valorCredito;
    @XStreamAlias("PrestadorServico")
    private PrestadorServico prestadorServico;
    @XStreamAlias("TomadorServico")
    private TomadorServico tomadorServico;
    @XStreamAlias("OrgaoGerador")
    private OrgaoGerador orgaoGerador;

    
    /*
    @XStreamAlias("tc:RegimeEspecialTributacao")
    private String tcRegimeEspecialTributacao;

    @XStreamAlias("tc:NfseSubstituida")
    private String tcNfseSubstituida;
    */

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodigoVerificacao() {
        return codigoVerificacao;
    }

    public void setCodigoVerificacao(String codigoVerificacao) {
        this.codigoVerificacao = codigoVerificacao;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public IdentificacaoRps getIdentificacaoRps() {
        return identificacaoRps;
    }

    public void setIdentificacaoRps(IdentificacaoRps identificacaoRps) {
        this.identificacaoRps = identificacaoRps;
    }

    public String getDataEmissaoRps() {
        return dataEmissaoRps;
    }

    public void setDataEmissaoRps(String dataEmissaoRps) {
        this.dataEmissaoRps = dataEmissaoRps;
    }

    public String getNaturezaOperacao() {
        return naturezaOperacao;
    }

    public void setNaturezaOperacao(String naturezaOperacao) {
        this.naturezaOperacao = naturezaOperacao;
    }

    public String getOptanteSimplesNacional() {
        return optanteSimplesNacional;
    }

    public void setOptanteSimplesNacional(String optanteSimplesNacional) {
        this.optanteSimplesNacional = optanteSimplesNacional;
    }

    public String getIncentivadorCultural() {
        return incentivadorCultural;
    }

    public void setIncentivadorCultural(String incentivadorCultural) {
        this.incentivadorCultural = incentivadorCultural;
    }

    public String getCompetencia() {
        return competencia;
    }

    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }

    public String getOutrasInformacoes() {
        return outrasInformacoes;
    }

    public void setOutrasInformacoes(String outrasInformacoes) {
        this.outrasInformacoes = outrasInformacoes;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public String getValorCredito() {
        return valorCredito;
    }

    public void setValorCredito(String valorCredito) {
        this.valorCredito = valorCredito;
    }

    public PrestadorServico getPrestadorServico() {
        return prestadorServico;
    }

    public void setPrestadorServico(PrestadorServico prestadorServico) {
        this.prestadorServico = prestadorServico;
    }

    public TomadorServico getTomadorServico() {
        return tomadorServico;
    }

    public void setTomadorServico(TomadorServico tomadorServico) {
        this.tomadorServico = tomadorServico;
    }

    public OrgaoGerador getOrgaoGerador() {
        return orgaoGerador;
    }

    public void setOrgaoGerador(OrgaoGerador orgaoGerador) {
        this.orgaoGerador = orgaoGerador;
    }
}
