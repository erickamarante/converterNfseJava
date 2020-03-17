package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("Signature")
public class Signature {
    
    @XStreamAlias("xmlns")
    @XStreamAsAttribute
    private String xmlns;
    
    @XStreamAlias("SignedInfo")
    private SignedInfo signedInfo;
    
    @XStreamAlias("SignatureValue")
    private String signatureValue;
    
    @XStreamAlias("KeyInfo")
    private KeyInfo keyInfo;

    public String getXmlns() {
        return xmlns;
    }

    public SignedInfo getSignedInfo() {
        return signedInfo;
    }

    public String getSignatureValue() {
        return signatureValue;
    }

    public KeyInfo getKeyInfo() {
        return keyInfo;
    }

}
