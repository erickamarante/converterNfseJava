package com.constanzooficial.integracao.model.nfse.rn.caico;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("Envelope")
public class Envelope {
    
    @XStreamAlias("xmlns:soapenv")
    @XStreamAsAttribute
    private String xmlnsSoapenv;
    
    @XStreamAlias("xmlns:tin")
    @XStreamAsAttribute
    private String xmlnsTin;
    
    @XStreamAlias("xmlns:xd")
    @XStreamAsAttribute
    private String xmlnsXd;
    
    @XStreamAlias("Header")
    private String header;
    
    @XStreamAlias("Body")
    private Body body;

    public String getXmlnsSoapenv() {
        return xmlnsSoapenv;
    }

    public String getXmlnsTin() {
        return xmlnsTin;
    }

    public String getXmlnsXd() {
        return xmlnsXd;
    }

    public String getHeader() {
        return header;
    }

    public Body getBody() {
        return body;
    }
    
}
