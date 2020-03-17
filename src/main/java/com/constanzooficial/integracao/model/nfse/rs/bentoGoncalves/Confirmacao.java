package com.constanzooficial.integracao.model.nfse.rs.bentoGoncalves;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("ConfirmacaoCancelamento")
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
