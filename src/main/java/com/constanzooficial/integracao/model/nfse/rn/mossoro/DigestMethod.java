package com.constanzooficial.integracao.model.nfse.rn.mossoro;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("DigestMethod")
public class DigestMethod {
    
    @XStreamAlias("Algorithm")
    @XStreamAsAttribute
    private String algorithm;

    public String getAlgorithm() {
        return algorithm;
    }
 
}
