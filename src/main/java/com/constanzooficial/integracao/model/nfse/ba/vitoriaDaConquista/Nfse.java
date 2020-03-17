package com.constanzooficial.integracao.model.nfse.ba.vitoriaDaConquista;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("Nfse")
public class Nfse {
    
    @XStreamAlias("InfNfse")
    private InfNfse infNfse;
    
    @XStreamAlias("Signature")
    private Signature signature;

    public InfNfse getInfNfse() {
        return infNfse;
    }
}
