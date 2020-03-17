package com.aldeiaconsultoriajr.nfe.es.vilaVelha;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("DeclaracaoPrestacaoServico")
public class DeclaracaoPrestacaoServico {

    @XStreamAlias("Id")
    @XStreamAsAttribute
    private String id;

    @XStreamAlias("InfDeclaracaoPrestacaoServico")
    private InfDeclaracaoPrestacaoServico infDeclaracaoPrestacaoServico;

    public String getId() {
        return id;
    }

    public InfDeclaracaoPrestacaoServico getInfDeclaracaoPrestacaoServico() {
        return infDeclaracaoPrestacaoServico;
    }
}
