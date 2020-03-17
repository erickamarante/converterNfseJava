package com.constanzooficial.integracao.model.nfse.rn.caico;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("RecepcionarLoteRps")
public class RecepcionarLoteRps {
    
    @XStreamAlias("Arg")
    private Arg arg;

    public Arg getArg() {
        return arg;
    }
}
