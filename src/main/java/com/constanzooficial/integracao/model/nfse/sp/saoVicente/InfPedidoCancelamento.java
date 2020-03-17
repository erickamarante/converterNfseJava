package com.constanzooficial.integracao.model.nfse.sp.saoVicente;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("InfPedidoCancelamento")
public class InfPedidoCancelamento {
    
    @XStreamAlias("IdentificacaoNfse")
    private IdentificacaoNfse identificacaoNfse;

    public IdentificacaoNfse getIdentificacaoNfse() {
        return identificacaoNfse;
    }
}
