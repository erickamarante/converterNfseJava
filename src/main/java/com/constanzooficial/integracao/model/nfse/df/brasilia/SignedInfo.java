package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("SignedInfo")
public class SignedInfo {
    
    @XStreamAlias("CanonicalizationMethod")
    private CanonicalizationMethod canonicalizationMethod;
    
    @XStreamAlias("SignatureMethod")
    private SignatureMethod signatureMethod;
    
    @XStreamAlias("Reference")
    private Reference reference;

    public CanonicalizationMethod getCanonicalizationMethod() {
        return canonicalizationMethod;
    }

    public SignatureMethod getSignatureMethod() {
        return signatureMethod;
    }

    public Reference getReference() {
        return reference;
    }
    
}
