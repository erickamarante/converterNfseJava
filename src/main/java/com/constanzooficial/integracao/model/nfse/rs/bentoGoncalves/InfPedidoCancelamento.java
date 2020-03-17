package com.constanzooficial.integracao.model.nfse.rs.bentoGoncalves;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("InfPedidoCancelamento")
public class InfPedidoCancelamento {
    
    @XStreamAlias("IdentificacaoNfse")
    private IdentificacaoNfse identificacaoNfse;
    @XStreamAlias("CodigoCancelamento")
    private String codigoCancelamento;

    public IdentificacaoNfse getIdentificacaoNfse() {
        return identificacaoNfse;
    }

    public String getCodigoCancelamento() {
        return codigoCancelamento;
    }
}
