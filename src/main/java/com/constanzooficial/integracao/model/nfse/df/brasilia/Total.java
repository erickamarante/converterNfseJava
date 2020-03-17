package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("total")
public class Total {
    
    @XStreamAlias("ICMSTot")
    private ICMSTot icmsTotal;
    
    @XStreamAlias("ISSQNtot")
    private ISSQNTot issQnTotal;
    
    @XStreamAlias("retTrib")
    private String retTrib;

    public ICMSTot getIcmsTotal() {
        return icmsTotal;
    }

    public ISSQNTot getIssQnTotal() {
        return issQnTotal;
    }

    public String getRetTrib() {
        return retTrib;
    }

}
