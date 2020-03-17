package com.aldeiaconsultoriajr.nfe.es.vilaVelha;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("NfseCancelamento")
public class NfseCancelamento {
    
    @XStreamAlias("ConfirmacaoCancelamento")
    private ConfirmacaoCancelamento confirmacaoCancelamento;

    public ConfirmacaoCancelamento getConfirmacaoCancelamento() {
        return confirmacaoCancelamento;
    }
}
