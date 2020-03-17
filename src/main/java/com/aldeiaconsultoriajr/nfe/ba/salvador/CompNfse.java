package com.aldeiaconsultoriajr.nfe.ba.salvador;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("CompNfse")
public class CompNfse {

    @XStreamAlias("Nfse")
    private Nfse nfse;
    
    @XStreamAlias("NfseCancelamento")
    private NfseCancelamento nfseCancelamento;

    public Nfse getNfse() {
        return nfse;
    }

    public NfseCancelamento getNfseCancelamento() {
        return nfseCancelamento;
    }

}
