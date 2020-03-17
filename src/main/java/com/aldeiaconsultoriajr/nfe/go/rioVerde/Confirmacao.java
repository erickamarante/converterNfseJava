package com.aldeiaconsultoriajr.nfe.go.rioVerde;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("Confirmacao")
class Confirmacao {

    @XStreamAlias("Pedido")
    private Pedido pedido;
    
    @XStreamAlias("InfConfirmacaoCancelamento")
    private InfConfirmacaoCancelamento infConfirmacaoCancelamento;

    public Pedido getPedido() {
        return pedido;
    }

    public InfConfirmacaoCancelamento getInfConfirmacaoCancelamento() {
        return infConfirmacaoCancelamento;
    }
}
