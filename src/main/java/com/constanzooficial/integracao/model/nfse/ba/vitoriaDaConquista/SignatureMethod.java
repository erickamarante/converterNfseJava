package com.constanzooficial.integracao.model.nfse.ba.vitoriaDaConquista;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("SignatureMethod")
public class SignatureMethod {
    
    @XStreamAlias("Algorithm")
    @XStreamAsAttribute
    private String Algorithm;

    public String getAlgorithm() {
        return Algorithm;
    }
    
}
