package com.constanzooficial.integracao.model.nfse.rs.bentoGoncalves;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("ConsultarNfseResposta")
public class ConsultarNfseResposta {
    
    @XStreamAlias("xmlns:ns2")
    @XStreamAsAttribute
    private String xmlnsns2;
    
    @XStreamAlias("ListaNfse")
    private ListaNfse listaNfse;
            
    @XStreamAlias("ListaMensagemRetorno")
    private String listaMensagemRetorno;

    public String getXmlnsns2() {
        return xmlnsns2;
    }

    public ListaNfse getListaNfse() {
        return listaNfse;
    }

    public String getListaMensagemRetorno() {
        return listaMensagemRetorno;
    }
}
