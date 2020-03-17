package com.constanzooficial.integracao.model.nfse.mt.campoNovoDoParecis;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("InfDeclaracaoPrestacaoServico")
public class InfDeclaracaoPrestacaoServico {
    
    @XStreamAlias("Competencia")
    private String competencia;
    
    @XStreamAlias("Servico")
    private Servico servico;
    
    @XStreamAlias("Prestador")
    private IdentificacaoPrestador prestador;
    
    @XStreamAlias("Tomador")
    private Tomador tomador;
    
    @XStreamAlias("RegimeEspecialTributacao")
    private String regimeEspecialTributacao;
    
    @XStreamAlias("OptanteSimplesNacional")
    private String optanteSimplesNacional;
    
    @XStreamAlias("IncentivoFiscal")
    private String incentivoFiscal;
    
    @XStreamAlias("OutrasInformacoes")
    private String outrasInformacoes;
    
    @XStreamAlias("Rps")
    private String rps;

    public String getCompetencia() {
        return competencia;
    }

    public Servico getServico() {
        return servico;
    }

    public Tomador getTomador() {
        return tomador;
    }

    public boolean getOptanteSimplesNacional() {
        return "1".equals(optanteSimplesNacional);
    }

    public String getIncentivoFiscal() {
        return incentivoFiscal;
    }

    public IdentificacaoPrestador getPrestador() {
        return prestador;
    }

    public String getRegimeEspecialTributacao() {
        return regimeEspecialTributacao;
    }

    public String getOutrasInformacoes() {
        return outrasInformacoes;
    }

    public String getRps() {
        return rps;
    }
    
}
