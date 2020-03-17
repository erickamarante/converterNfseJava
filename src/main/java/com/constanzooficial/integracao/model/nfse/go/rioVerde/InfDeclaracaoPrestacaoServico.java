package com.constanzooficial.integracao.model.nfse.go.rioVerde;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("InfDeclaracaoPrestacaoServico")
public class InfDeclaracaoPrestacaoServico {
    
    @XStreamAlias("Servico")
    private Servico servico; 
    
    @XStreamAlias("Prestador")
    private Prestador prestador;
    
    @XStreamAlias("Tomador")
    private Tomador tomador;

    public Servico getServico() {
        return servico;
    }

    public Prestador getPrestador() {
        return prestador;
    }

    public Tomador getTomador() {
        return tomador;
    }     
    
}
