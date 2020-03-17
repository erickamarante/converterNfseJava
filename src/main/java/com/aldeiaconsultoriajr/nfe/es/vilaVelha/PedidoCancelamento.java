package com.aldeiaconsultoriajr.nfe.es.vilaVelha;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("PedidoCancelamento")
public class PedidoCancelamento {

    @XStreamAlias("InfPedidoCancelamento")
    private InfPedidoCancelamento infPedidoCancelamento;

    public InfPedidoCancelamento getInfPedidoCancelamento() {
        return infPedidoCancelamento;
    }
}
