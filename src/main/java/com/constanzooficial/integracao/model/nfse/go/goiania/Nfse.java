package com.constanzooficial.integracao.model.nfse.go.goiania;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("Nfse")
public class Nfse {
    
    @XStreamAsAttribute
    @XStreamAlias("versao")
    private String versao;
    
    @XStreamAlias("InfNfse")
    private InfNfse infNfse;

    public String getVersao() {
        return versao;
    }

    public InfNfse getInfNfse() {
        return infNfse;
    }
    
}
