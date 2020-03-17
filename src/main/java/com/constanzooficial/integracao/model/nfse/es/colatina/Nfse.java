package com.constanzooficial.integracao.model.nfse.es.colatina;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Luis Sanches
 */
@XStreamAlias("Nfse")
public class Nfse {    
    
    @XStreamAlias("Id")
    private String id;
    
    @XStreamAlias("LocalPrestacao")
    private String localPrestacao;
    
    @XStreamAlias("IssRetido")
    private String issRetido;
    
    @XStreamAlias("DataEmissao")
    private String dataEmissao;
    
    @XStreamAlias("IdentificacaoNfse")
    private IdentificacaoNfse identificacaoNfse;
    
    @XStreamAlias("DadosPrestador")
    private DadosPrestador dadosPrestador;
    
    @XStreamAlias("DadosTomador")
    private DadosTomador dadosTomador;
    
    @XStreamAlias("IdentificacaoIntermediario")
    private IdentificacaoIntermediario identificacaoIntermediario;
    
    @XStreamAlias("Servicos")
    private Servicos servicos;
    
    @XStreamAlias("Valores")
    private Valores valores;
    
    @XStreamAlias("NfseSubstituido")
    private String nfseSubstituido;
    
    @XStreamAlias("Observacao")
    private String observacao;
    
    @XStreamAlias("Status")
    private String status;

    public String getId() {
        return id;
    }

    public String getLocalPrestacao() {
        return localPrestacao;
    }

    public String getIssRetido() {
        return issRetido;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public IdentificacaoNfse getIdentificacaoNfse() {
        return identificacaoNfse;
    }

    public DadosPrestador getDadosPrestador() {
        return dadosPrestador;
    }

    public DadosTomador getDadosTomador() {
        return dadosTomador;
    }

    public IdentificacaoIntermediario getIdentificacaoIntermediario() {
        return identificacaoIntermediario;
    }

    public Servicos getServicos() {
        return servicos;
    }

    public Valores getValores() {
        return valores;
    }

    public String getNfseSubstituido() {
        return nfseSubstituido;
    }

    public String getObservacao() {
        return observacao;
    }

    public String getStatus() {
        return status;
    }
    
}
