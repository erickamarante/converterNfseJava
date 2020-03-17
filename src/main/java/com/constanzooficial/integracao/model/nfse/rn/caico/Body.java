package com.constanzooficial.integracao.model.nfse.rn.caico;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("Body")
public class Body {
    
    @XStreamAlias("RecepcionarLoteRps")
    private RecepcionarLoteRps RecepcionarLoteRps;

    public RecepcionarLoteRps getRecepcionarLoteRps() {
        return RecepcionarLoteRps;
    }
}
