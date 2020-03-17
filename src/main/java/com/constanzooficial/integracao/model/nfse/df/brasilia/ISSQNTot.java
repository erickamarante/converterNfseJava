package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("ISSQNtot")
public class ISSQNTot {
    
    @XStreamAlias("vServ")
    private String vServ;
    
    @XStreamAlias("vBC")
    private String vBc;
    
    @XStreamAlias("vISS")
    private String vIss;
    
    @XStreamAlias("vPIS")
    private String vPis;
    
    @XStreamAlias("vCOFINS")
    private String vCofins;
    
    @XStreamAlias("dCompet")
    private String dCompet;
    
    @XStreamAlias("vISSRet")
    private String vISSRet;
    
    @XStreamAlias("cRegTrib")
    private String cRegTrib;

    public String getvServ() {
        return vServ;
    }

    public String getvBc() {
        return vBc;
    }

    public String getvIss() {
        return vIss;
    }

    public String getvPis() {
        return vPis;
    }

    public String getvCofins() {
        return vCofins;
    }

    public String getdCompet() {
        return dCompet;
    }

    public String getcRegTrib() {
        return cRegTrib;
    }

    public String getvISSRet() {
        return vISSRet;
    }

}
