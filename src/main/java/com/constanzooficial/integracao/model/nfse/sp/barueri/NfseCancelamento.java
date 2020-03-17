package com.constanzooficial.integracao.model.nfse.sp.barueri;

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
