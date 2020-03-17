package com.constanzooficial.integracao.model.nfse.rn.mossoro;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("Rps")
public class Rps {
    
    @XStreamAlias("InfRps")
    private InfRps infRps;
    
    @XStreamAlias("Signature")
    private Signature signature;

    public InfRps getInfRps() {
        return infRps;
    }

    public Signature getSignature() {
        return signature;
    }
}
