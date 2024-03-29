package com.constanzooficial.integracao.model.nfse.ba.vitoriaDaConquista;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("ConsultarNfseResposta")
public class ConsultarNfseResposta {
    
    @XStreamAlias("xmlns:xsd")
    @XStreamAsAttribute
    private String xmlnsxsd;
    
    @XStreamAlias("xmlns:xsi")
    @XStreamAsAttribute
    private String xmlnsxsi;
    
    @XStreamAlias("xmlns")
    @XStreamAsAttribute
    private String xmlns;
    
    @XStreamAlias("ListaNfse")
    private ListaNfse listaNfse;

    public String getXmlnsxsd() {
        return xmlnsxsd;
    }
    
    public String getXmlnsxsi() {
        return xmlnsxsi;
    }

    public String getXmlns() {
        return xmlns;
    }

    public ListaNfse getListaNfse() {
        return listaNfse;
    }
   
}
