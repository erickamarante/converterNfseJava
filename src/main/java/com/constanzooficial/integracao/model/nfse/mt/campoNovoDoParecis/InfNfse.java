package com.constanzooficial.integracao.model.nfse.mt.campoNovoDoParecis;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("InfNfse")
public class InfNfse {
    
    @XStreamAlias("Id")
    @XStreamAsAttribute
    private String id;

    @XStreamAlias("Numero")
    private String Numero;

    @XStreamAlias("CodigoVerificacao")
    private String CodigoVerificacao;

    @XStreamAlias("DataEmissao")
    private String DataEmissao;
    
    @XStreamAlias("NfseSubstituida")
    private String nfseSubstituida;
    
    @XStreamAlias("OutrasInformacoes")
    private String outrasInformacoes;

    @XStreamAlias("ValoresNfse")
    private ValoresNfse valoresNfse;

    @XStreamAlias("ValorCredito")
    private String valorCredito;

    @XStreamAlias("PrestadorServico")
    private PrestadorServico PrestadorServico;

    @XStreamAlias("OrgaoGerador")
    private OrgaoGerador OrgaoGerador;

    @XStreamAlias("DeclaracaoPrestacaoServico")
    private DeclaracaoPrestacaoServico declaracaoPrestacaoServico;
    
    @XStreamAlias("tsStatusRps")
    private String tsStatusRps;
    
    @XStreamAlias("tsStatusNfse")
    private String tsStatusNfse;

    public String getId() {
        return id;
    }

    public String getNumero() {
        return Numero;
    }

    public String getCodigoVerificacao() {
        return CodigoVerificacao;
    }

    public String getDataEmissao() {
        return DataEmissao;
    }

    public String getNfseSubstituida() {
        return nfseSubstituida;
    }

    public String getOutrasInformacoes() {
        return outrasInformacoes;
    }

    public ValoresNfse getValoresNfse() {
        return valoresNfse;
    }

    public String getValorCredito() {
        return valorCredito;
    }

    public PrestadorServico getPrestadorServico() {
        return PrestadorServico;
    }

    public OrgaoGerador getOrgaoGerador() {
        return OrgaoGerador;
    }

    public DeclaracaoPrestacaoServico getDeclaracaoPrestacaoServico() {
        return declaracaoPrestacaoServico;
    }

    public String getTsStatusRps() {
        return tsStatusRps;
    }

    public String getTsStatusNfse() {
        return tsStatusNfse;
    }
}
