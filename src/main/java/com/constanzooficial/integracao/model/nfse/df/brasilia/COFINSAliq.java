package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("COFINSAliq")
public class COFINSAliq {
    
    @XStreamAlias("CST")
    private String cst;
    
    @XStreamAlias("vBC")
    private String vBc;
    
    @XStreamAlias("pCOFINS")
    private String pCofins;
    
    @XStreamAlias("vCOFINS")
    private String valorCofins;

    public String getCst() {
        return cst;
    }

    public String getvBc() {
        return vBc;
    }

    public String getpCofins() {
        return pCofins;
    }

    public String getValorCofins() {
        return valorCofins;
    }

}
