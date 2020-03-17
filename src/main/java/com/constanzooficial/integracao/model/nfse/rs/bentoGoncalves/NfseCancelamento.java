package com.constanzooficial.integracao.model.nfse.rs.bentoGoncalves;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("NfseCancelamento")
public class NfseCancelamento {
    
    @XStreamAlias("Confirmacao")
    private Confirmacao confirmacao;

    public Confirmacao getConfirmacao() {
        return confirmacao;
    }
}
