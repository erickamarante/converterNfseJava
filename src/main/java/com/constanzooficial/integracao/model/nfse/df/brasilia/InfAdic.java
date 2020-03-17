package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("InfAdic")
public class InfAdic {
    
    @XStreamAlias("infCpl")
    private String infCpl;

    public String getInfCpl() {
        return infCpl;
    }
    
}
