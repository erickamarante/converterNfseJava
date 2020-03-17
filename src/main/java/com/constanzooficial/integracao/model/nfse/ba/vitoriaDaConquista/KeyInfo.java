package com.constanzooficial.integracao.model.nfse.ba.vitoriaDaConquista;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("KeyInfo")
public class KeyInfo {
    
    @XStreamAlias("X509Data")
    private X509Data x509Data;

    public X509Data getX509Data() {
        return x509Data;
    }
 
}
