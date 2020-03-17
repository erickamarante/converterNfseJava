package com.constanzooficial.integracao.model.nfse.ba.vitoriaDaConquista;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
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
