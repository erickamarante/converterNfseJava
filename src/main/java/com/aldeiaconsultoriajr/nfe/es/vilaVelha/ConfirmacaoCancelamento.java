package com.aldeiaconsultoriajr.nfe.es.vilaVelha;

import com.aldeiaconsultoriajr.util.MyUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("ConfirmacaoCancelamento")
class ConfirmacaoCancelamento {

    @XStreamAlias("PedidoCancelamento")
    private PedidoCancelamento pedidoCancelamento;
    @XStreamAlias("DataHora")
    private String dataHora;

    public PedidoCancelamento getPedidoCancelamento() {
        return pedidoCancelamento;
    }

    public String[] getDataHora() {
        return MyUtils.trataDataHora(dataHora);
    }
}
