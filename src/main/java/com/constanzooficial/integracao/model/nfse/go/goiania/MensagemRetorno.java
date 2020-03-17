package com.constanzooficial.integracao.model.nfse.go.goiania;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("MensagemRetorno")
public class MensagemRetorno {
    
    @XStreamAlias("Codigo")
    private String codigo;
    
    @XStreamAlias("Mensagem")
    private String mensagem;

    public String getCodigo() {
        return codigo;
    }

    public String getMensagem() {
        return mensagem;
    }
    
}
