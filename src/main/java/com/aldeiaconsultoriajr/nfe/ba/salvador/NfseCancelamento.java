package com.aldeiaconsultoriajr.nfe.ba.salvador;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("NfseCancelamento")
class NfseCancelamento {
    
    @XStreamAlias("Confirmacao")
    private Confirmacao confirmacao;

    public Confirmacao getConfirmacao() {
        return confirmacao;
    }
}
