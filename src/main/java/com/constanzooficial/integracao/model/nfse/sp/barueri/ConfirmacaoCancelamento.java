package com.constanzooficial.integracao.model.nfse.sp.barueri;

import static com.constanzooficial.integracao.util.MyUtils.trataDataHora2;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("ConfirmacaoCancelamento")
public class ConfirmacaoCancelamento {

    @XStreamAlias("PedidoCancelamento")
    private PedidoCancelamento pedidoCancelamento;
    @XStreamAlias("DataHora")
    private String dataHora;

    public PedidoCancelamento getPedidoCancelamento() {
        return pedidoCancelamento;
    }

    public String[] getDataHora() {
        return trataDataHora2(dataHora);
    }
}
