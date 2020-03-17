package com.constanzooficial.integracao.model.nfse.sp.barueri;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("ConsultarNfseFaixaResposta")
public class ConsultarNfseFaixaResposta {
    
    @XStreamAlias("xmlns")
    @XStreamAsAttribute
    private String xmlns;
    
    @XStreamAlias("xmlns:xs")
    @XStreamAsAttribute
    private String xmlnsXs;
    
    @XStreamAlias("ListaNfse")
    private ListaNfse listaNfse;

    public String getXmlns() {
        return xmlns;
    }

    public String getXmlnsXs() {
        return xmlnsXs;
    }

    public ListaNfse getListaNfse() {
        return listaNfse;
    }
}
