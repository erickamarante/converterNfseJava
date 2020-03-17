package com.constanzooficial.integracao.model.nfse.sp.saoVicente;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("tc:Nfse")
public class TcNfse {

    @XStreamAlias("tc:InfNfse")
    private TcInfNfse tcInfNfse;

    @XStreamAlias("Signature")
    private Signature signature;

    public TcInfNfse getTcInfNfse() {
        return tcInfNfse;
    }

    public Signature getSignature() {
        return signature;
    }
}
