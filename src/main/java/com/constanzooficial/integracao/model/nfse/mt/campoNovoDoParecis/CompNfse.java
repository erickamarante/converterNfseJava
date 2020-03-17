package com.constanzooficial.integracao.model.nfse.mt.campoNovoDoParecis;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("CompNfse")
public class CompNfse {

    @XStreamAlias("Nfse")
    private Nfse nfse;

    public Nfse getNfse() {
        return nfse;
    }
}
