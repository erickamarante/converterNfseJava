package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("PIS")
public class PIS {
    
    @XStreamAlias("PISAliq")
    private PISAliq pisAliquota;
    
    @XStreamAlias("PISOutr")
    private String PISOutr;
    
    @XStreamAlias("PISNT")
    private PISNT PISNT;

    public PISAliq getPisAliquota() {
        return pisAliquota;
    }

    public String getPISOutr() {
        return PISOutr;
    }

    public PISNT getPISNT() {
        return PISNT;
    }
    
}
