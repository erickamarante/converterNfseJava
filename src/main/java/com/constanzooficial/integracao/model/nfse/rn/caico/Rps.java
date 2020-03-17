package com.constanzooficial.integracao.model.nfse.rn.caico;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("Rps")
public class Rps {
    
    @XStreamAlias("InfRps")
    private InfRps infRps;

    public InfRps getInfRps() {
        return infRps;
    }
}
