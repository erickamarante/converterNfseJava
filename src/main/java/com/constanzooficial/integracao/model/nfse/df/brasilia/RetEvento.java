package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("retEvento")
public class RetEvento {
    
    @XStreamAlias("versao")
    @XStreamAsAttribute
    private String versao;
    
    @XStreamAlias("infEvento")
    private InfEvento infEvento;

    public String getVersao() {
        return versao;
    }

    public InfEvento getInfEvento() {
        return infEvento;
    }
    
}
