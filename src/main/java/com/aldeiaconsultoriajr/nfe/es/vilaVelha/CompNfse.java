package com.aldeiaconsultoriajr.nfe.es.vilaVelha;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("CompNfse")
public class CompNfse {

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
