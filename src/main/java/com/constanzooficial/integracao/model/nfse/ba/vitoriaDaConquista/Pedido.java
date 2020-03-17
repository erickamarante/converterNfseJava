package com.constanzooficial.integracao.model.nfse.ba.vitoriaDaConquista;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("Pedido")
public class Pedido {

    @XStreamAlias("InfPedidoCancelamento")
    private InfPedidoCancelamento infPedidoCancelamento;
    
    @XStreamAlias("ns2:Signature")
    private String ns2Signature;

    public InfPedidoCancelamento getInfPedidoCancelamento() {
        return infPedidoCancelamento;
    }

    public String getNs2Signature() {
        return ns2Signature;
    }
}
