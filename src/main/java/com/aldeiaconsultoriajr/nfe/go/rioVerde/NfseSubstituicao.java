package com.aldeiaconsultoriajr.nfe.go.rioVerde;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("NfseSubstituicao")
public class NfseSubstituicao {
    
    @XStreamAlias("SubstituicaoNfse")
    private SubstituicaoNfse substituicaoNfse;

    public SubstituicaoNfse getSubstituicaoNfse() {
        return substituicaoNfse;
    }
}
