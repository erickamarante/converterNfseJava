package com.constanzooficial.integracao.model.nfse.go.goiania;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("GerarNfseResposta")
public class GerarNfseResposta {
    
    @XStreamAsAttribute
    @XStreamAlias("xmlns")
    private String xmlns;
    
    @XStreamAlias("ListaNfse")
    private ListaNfse listaNfse;
    
    @XStreamAlias("ListaMensagemRetorno")
    private ListaMensagemRetorno listaMensagemRetorno;

    public String getXmlns() {
        return xmlns;
    }

    public ListaNfse getListaNfse() {
        return listaNfse;
    }

    public ListaMensagemRetorno getListaMensagemRetorno() {
        return listaMensagemRetorno;
    }
    
}
