package com.constanzooficial.integracao.model.nfse.go.goiania;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("DeclaracaoPrestacaoServico")
public class DeclaracaoPrestacaoServico {
    
    @XStreamAlias("InfDeclaracaoPrestacaoServico")
    private InfDeclaracaoPrestacaoServico infDeclaracaoPrestacaoServico;

    public InfDeclaracaoPrestacaoServico getInfDeclaracaoPrestacaoServico() {
        return infDeclaracaoPrestacaoServico;
    }
    
}
