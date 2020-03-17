package com.constanzooficial.integracao.model.nfse.ba.joaoDourado;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("InfDeclaracaoPrestacaoServico")
public class InfDeclaracaoPrestacaoServico {
    
    @XStreamAlias("Competencia")
    private String competencia;

    @XStreamAlias("Servico")
    private Servico servico;

    @XStreamAlias("Prestador")
    private Prestador prestador;
    
    @XStreamAlias("Tomador")
    private Tomador tomador;
    
    @XStreamAlias("RegimeEspecialTributacao")
    private String regimeEspecialTributacao;
    
    @XStreamAlias("OptanteSimplesNacional")
    private String optanteSimplesNacional;
    
    @XStreamAlias("IncentivoFiscal")
    private String incentivoFiscal;

    public String getCompetencia() {
        return competencia;
    }

    public Servico getServico() {
        return servico;
    }

    public Prestador getPrestador() {
        return prestador;
    }

    public Tomador getTomador() {
        return tomador;
    }

    public String getRegimeEspecialTributacao() {
        return regimeEspecialTributacao;
    }

    public String getOptanteSimplesNacional() {
        return optanteSimplesNacional;
    }

    public String getIncentivoFiscal() {
        return incentivoFiscal;
    }
}
