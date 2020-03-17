package com.aldeiaconsultoriajr.nfe.es.vilaVelha;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("NfseSubstituicao")
public class NfseSubstituicao {
    
    @XStreamAlias("InfSubstituicaoNfse")
    private InfSubstituicaoNfse infSubstituicaoNfse;

    public InfSubstituicaoNfse getInfSubstituicaoNfse() {
        return infSubstituicaoNfse;
    }
}
