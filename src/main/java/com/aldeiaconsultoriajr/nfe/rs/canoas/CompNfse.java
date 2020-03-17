package com.aldeiaconsultoriajr.nfe.rs.canoas;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("CompNfse")
public class CompNfse {
    
    @XStreamAlias("Nfse")
    private Nfse nfse;

    public Nfse getNfse() {
        return nfse;
    }

    public void setNfse(Nfse nfse) {
        this.nfse = nfse;
    }
}
