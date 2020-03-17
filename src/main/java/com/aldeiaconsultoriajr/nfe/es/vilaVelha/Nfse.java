package com.aldeiaconsultoriajr.nfe.es.vilaVelha;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("Nfse")
public class Nfse {

    @XStreamAlias("InfNfse")
    private InfNfse infNfse;

    public InfNfse getInfNfse() {
        return infNfse;
    }
}
