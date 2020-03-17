package com.constanzooficial.integracao.model.nfse.rn.caico;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("Arg")
public class Arg {
    
    @XStreamAlias("LoteRps")
    private LoteRps loteRps;

    public LoteRps getLoteRps() {
        return loteRps;
    }
}
