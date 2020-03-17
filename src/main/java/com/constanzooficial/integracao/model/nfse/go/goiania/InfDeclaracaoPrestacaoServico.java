package com.constanzooficial.integracao.model.nfse.go.goiania;

import static com.constanzooficial.integracao.util.MyUtils.trataDataHora2;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("InfDeclaracaoPrestacaoServico")
public class InfDeclaracaoPrestacaoServico {
    
    @XStreamAlias("Rps")
    private Rps rps;
    
    @XStreamAlias("Competencia")
    private String competencia;
    
    @XStreamAlias("Servico")
    private Servico servico;
    
    @XStreamAlias("Prestador")
    private Prestador prestador;
    
    @XStreamAlias("Tomador")
    private Tomador tomador;
    
    @XStreamAlias("OptanteSimplesNacional")
    private String optanteSimplesNacional;

    public Rps getRps() {
        return rps;
    }

    public String[] getCompetencia() {
        String[] retorno = trataDataHora2(competencia);
        return retorno;
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

    public String getOptanteSimplesNacional() {
        return optanteSimplesNacional;
    }
    
}
