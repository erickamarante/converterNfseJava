package com.aldeiaconsultoriajr.nfe.go.rioVerde;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("ComplNfse")
public class ComplNfse {
    
    @XStreamAlias("Nfse")
    private Nfse nfse;
    
    @XStreamAlias("NfseCancelamento")
    private NfseCancelamento nfseCancelamento;
    
    @XStreamAlias("NfseSubstituicao")
    private NfseSubstituicao nfseSubstituicao;

    public Nfse getNfse() {
        return nfse;
    }

    public NfseCancelamento getNfseCancelamento() {
        return nfseCancelamento;
    }

    public NfseSubstituicao getNfseSubstituicao() {
        return nfseSubstituicao;
    }
}
