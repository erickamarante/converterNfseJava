package com.constanzooficial.integracao.model.nfse.mt.campoNovoDoParecis;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Nfse")
public class Nfse {

    @XStreamAlias("InfNfse")
    private InfNfse infNfse;

    public InfNfse getInfNfse() {
        return infNfse;
    }
}
