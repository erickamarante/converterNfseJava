package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("vol")
public class Vol {
    
    @XStreamAlias("qVol")
    private String qVol;
    
    @XStreamAlias("pesoL")
    private String pesoL;
    
    @XStreamAlias("pesoB")
    private String pesoB;

    public String getqVol() {
        return qVol;
    }

    public String getPesoL() {
        return pesoL;
    }

    public String getPesoB() {
        return pesoB;
    }
}
