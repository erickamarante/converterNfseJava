package com.constanzooficial.integracao.model.nfse.sp.saoVicente;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("Confirmacao")
public class Confirmacao {

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
