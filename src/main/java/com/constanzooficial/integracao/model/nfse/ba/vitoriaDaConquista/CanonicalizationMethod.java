package com.constanzooficial.integracao.model.nfse.ba.vitoriaDaConquista;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("CanonicalizationMethod")
public class CanonicalizationMethod {
    
    @XStreamAlias("Algorithm")
    @XStreamAsAttribute
    private String algorithm;

    public String getAlgorithm() {
        return algorithm;
    }
    
}
