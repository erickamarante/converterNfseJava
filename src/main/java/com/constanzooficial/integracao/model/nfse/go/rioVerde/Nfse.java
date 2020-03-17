package com.constanzooficial.integracao.model.nfse.go.rioVerde;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("Nfse")
public class Nfse {
    
    @XStreamAlias("InfNfse")
    private InfNfse infNfse;
    
    public InfNfse getInfNfse() {
        return infNfse;
    }
    
}
