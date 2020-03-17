package com.constanzooficial.integracao.model.nfse.es.colatina;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Luis Sanches
 */
@XStreamAlias("DadosPrestador")
public class DadosPrestador {
    
    @XStreamAlias("IdentificacaoPrestador")
    private IdentificacaoPrestador identificacaoPrestador;
    
    @XStreamAlias("RazaoSocial")
    private String razaoSocial;
    
    @XStreamAlias("NomeFantasia")
    private String nomeFantasia;
    
    @XStreamAlias("IncentivadorCultural")
    private String incentivadorCultural;
    
    @XStreamAlias("OptanteSimplesNacional")
    private String optanteSimplesNacional;
    
    @XStreamAlias("NaturezaOperacao")
    private String naturezaOperacao;
    
    @XStreamAlias("RegimeEspecialTributacao")
    private String regimeEspecialTributacao;
    
    @XStreamAlias("Endereco")
    private Endereco endereco;
    
    @XStreamAlias("Contato")
    private Contato contato;

    public IdentificacaoPrestador getIdentificacaoPrestador() {
        return identificacaoPrestador;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String getIncentivadorCultural() {
        return incentivadorCultural;
    }

    public String getOptanteSimplesNacional() {
        return optanteSimplesNacional;
    }

    public String getNaturezaOperacao() {
        return naturezaOperacao;
    }

    public String getRegimeEspecialTributacao() {
        return regimeEspecialTributacao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Contato getContato() {
        return contato;
    }
    
}
