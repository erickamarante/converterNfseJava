package com.constanzooficial.integracao.model.nfse.go.goiania;

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
