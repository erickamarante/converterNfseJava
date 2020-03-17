package com.aldeiaconsultoriajr.nfe.es.vilaVelha;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("InfSubstituicaoNfse")
public class InfSubstituicaoNfse {
    
    @XStreamAlias("Id")
    @XStreamAsAttribute
    private String id;
    
    @XStreamAlias("NfseSubstituidora")
    private String NfseSubstituidora;

    public String getId() {
        return id;
    }

    public String getNfseSubstituidora() {
        return NfseSubstituidora;
    }
}
