package com.constanzooficial.integracao.model.nfse.sp.saoVicente;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("CompNfse")
public class CompNfse {

    @XStreamAlias("tc:Nfse")
    private TcNfse tcNfse;
    
    @XStreamAlias("NfseCancelamento")
    private NfseCancelamento nfseCancelamento;

    public TcNfse getTcNfse() {
        return tcNfse;
    }
    
    public NfseCancelamento getNfseCancelamento() {
        return nfseCancelamento;
    }
}
