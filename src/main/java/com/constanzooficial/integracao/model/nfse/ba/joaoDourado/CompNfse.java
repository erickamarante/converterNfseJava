package com.constanzooficial.integracao.model.nfse.ba.joaoDourado;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("CompNfse")
public class CompNfse {
    
    @XStreamAlias("Nfse")
    private Nfse nfse;

    public Nfse getNfse() {
        return nfse;
    }
    
}
