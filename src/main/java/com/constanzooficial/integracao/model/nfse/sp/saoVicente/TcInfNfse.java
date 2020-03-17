package com.constanzooficial.integracao.model.nfse.sp.saoVicente;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("tc:InfNfse")
public class TcInfNfse {

    @XStreamAlias("tc:Numero")
    private String tcNumero;

    @XStreamAlias("tc:CodigoVerificacao")
    private String tcCodigoVerificacao;

    @XStreamAlias("tc:DataEmissao")
    private String tcDataEmissao;

    @XStreamAlias("tc:NaturezaOperacao")
    private String tcNaturezaOperacao;

    @XStreamAlias("tc:RegimeEspecialTributacao")
    private String tcRegimeEspecialTributacao;

    @XStreamAlias("tc:OptanteSimplesNacional")
    private String tcOptanteSimplesNacional;

    @XStreamAlias("tc:IncentivadorCultural")
    private String tcIncentivadorCultural;

    @XStreamAlias("tc:Competencia")
    private String tcCompetencia;

    @XStreamAlias("tc:NfseSubstituida")
    private String tcNfseSubstituida;

    @XStreamAlias("tc:OutrasInformacoes")
    private String tcOutrasInformacoes;

    @XStreamAlias("tc:Servico")
    private TcServico tcServico;

    @XStreamAlias("tc:PrestadorServico")
    private TcPrestadorServico tcPrestadorServico;

    @XStreamAlias("tc:TomadorServico")
    private TcTomadorServico tcTomadorServico;

    @XStreamAlias("tc:OrgaoGerador")
    private TcOrgaoGerador tcOrgaoGerador;

    @XStreamAlias("tc:ValorCredito")
    private String tcValorCredito;

    public String getTcNumero() {
        return tcNumero;
    }

    public String getTcCodigoVerificacao() {
        return tcCodigoVerificacao;
    }

    public String getTcDataEmissao() {
        return tcDataEmissao;
    }

    public String getTcNaturezaOperacao() {
        return tcNaturezaOperacao;
    }

    public String getTcRegimeEspecialTributacao() {
        return tcRegimeEspecialTributacao;
    }

    public String getTcOptanteSimplesNacional() {
        return tcOptanteSimplesNacional;
    }

    public String getTcIncentivadorCultural() {
        return tcIncentivadorCultural;
    }

    public String getTcCompetencia() {
        return tcCompetencia;
    }

    public String getTcNfseSubstituida() {
        return tcNfseSubstituida;
    }

    public String getTcOutrasInformacoes() {
        return tcOutrasInformacoes;
    }

    public TcServico getTcServico() {
        return tcServico;
    }

    public TcPrestadorServico getTcPrestadorServico() {
        return tcPrestadorServico;
    }

    public TcTomadorServico getTcTomadorServico() {
        return tcTomadorServico;
    }

    public TcOrgaoGerador getTcOrgaoGerador() {
        return tcOrgaoGerador;
    }

    public String getTcValorCredito() {
        return tcValorCredito;
    }
}
