package com.constanzooficial.integracao.model.nfse.ba.vitoriaDaConquista;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("NfseCancelamento")
public class NfseCancelamento {
    
    @XStreamAlias("Confirmacao")
    private Confirmacao confirmacao;
    
    @XStreamAlias("Signature")
    private Signature signature;

    public Confirmacao getConfirmacao() {
        return confirmacao;
    }

    public Signature getSignature() {
        return signature;
    }
}
