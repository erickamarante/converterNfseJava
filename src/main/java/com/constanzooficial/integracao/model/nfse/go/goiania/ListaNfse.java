package com.constanzooficial.integracao.model.nfse.go.goiania;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("ListaNfse")
public class ListaNfse {
    
    @XStreamAlias("CompNfse")
    private CompNfse compNfse;

    public CompNfse getCompNfse() {
        return compNfse;
    }
    
}
