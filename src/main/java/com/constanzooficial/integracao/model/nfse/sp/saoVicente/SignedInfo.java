package com.constanzooficial.integracao.model.nfse.sp.saoVicente;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
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
