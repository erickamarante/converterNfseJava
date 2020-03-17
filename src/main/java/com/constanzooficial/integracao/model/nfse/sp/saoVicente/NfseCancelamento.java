package com.constanzooficial.integracao.model.nfse.sp.saoVicente;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
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
