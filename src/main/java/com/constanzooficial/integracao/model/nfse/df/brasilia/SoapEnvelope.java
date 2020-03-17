package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("soap:Envelope")
public class SoapEnvelope {
    
    @XStreamAlias("xmlns:soap")
    @XStreamAsAttribute
    private String xmlnsSoap;
    
    @XStreamAlias("xmlns:xsd")
    @XStreamAsAttribute
    private String xmlnsXsd;
    
    @XStreamAlias("soap:Body")
    private SoapBody soapBody;

    public String getXmlnsSoap() {
        return xmlnsSoap;
    }

    public String getXmlnsXsd() {
        return xmlnsXsd;
    }

    public SoapBody getSoapBody() {
        return soapBody;
    }
}
