package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("evento")
public class Evento {
    
    @XStreamAlias("versao")
    @XStreamAsAttribute
    private String versao;
    
    @XStreamAlias("infEvento")
    private InfEvento infEvento;
    
    @XStreamAlias("Signature")
    private Signature signature;

    public String getVersao() {
        return versao;
    }

    public InfEvento getInfEvento() {
        return infEvento;
    }

    public Signature getSignature() {
        return signature;
    }
    
}
