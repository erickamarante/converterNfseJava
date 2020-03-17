package com.constanzooficial.integracao.model.nfse.go.goiania;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("ListaMensagemRetorno")
public class ListaMensagemRetorno {
    
    @XStreamAlias("MensagemRetorno")
    private MensagemRetorno MensagemRetorno;

    public MensagemRetorno getMensagemRetorno() {
        return MensagemRetorno;
    }
    
}
