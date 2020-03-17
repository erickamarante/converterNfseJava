package com.aldeiaconsultoriajr.nfe.es.vilaVelha;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("InfPedidoCancelamento")
public class InfPedidoCancelamento {
    
    @XStreamAlias("Id")
    @XStreamAsAttribute
    private String id;
    
    @XStreamAlias("IdentificacaoNfse")
    private IdentificacaoNfse identificacaoNfse;
    @XStreamAlias("CodigoCancelamento")
    private String codigoCancelamento;

    public String getId() {
        return id;
    }

    public IdentificacaoNfse getIdentificacaoNfse() {
        return identificacaoNfse;
    }

    public void setIdentificacaoNfse(IdentificacaoNfse identificacaoNfse) {
        this.identificacaoNfse = identificacaoNfse;
    }

    public String getCodigoCancelamento() {
        return codigoCancelamento;
    }
}
