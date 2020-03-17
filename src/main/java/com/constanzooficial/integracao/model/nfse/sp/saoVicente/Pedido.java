package com.constanzooficial.integracao.model.nfse.sp.saoVicente;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("Pedido")
public class Pedido {

    @XStreamAlias("InfPedidoCancelamento")
    private InfPedidoCancelamento infPedidoCancelamento;

    public InfPedidoCancelamento getInfPedidoCancelamento() {
        return infPedidoCancelamento;
    }
}
