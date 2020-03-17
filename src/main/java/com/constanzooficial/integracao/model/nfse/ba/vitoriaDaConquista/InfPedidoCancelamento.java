package com.constanzooficial.integracao.model.nfse.ba.vitoriaDaConquista;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
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
