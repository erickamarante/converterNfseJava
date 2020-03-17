package com.constanzooficial.integracao.model.nfse.ba.joaoDourado;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("Nfse")
public class Nfse {
    
    @XStreamAlias("versao")
    @XStreamAsAttribute
    private String versao;
    
    @XStreamAlias("InfNfse")
    private InfNfse infNfse;

    public InfNfse getInfNfse() {
        return infNfse;
    }

    public String getVersao() {
        return versao;
    }
}
