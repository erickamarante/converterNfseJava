package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("infProt")
public class InfProt {
    
    @XStreamAlias("tpAmb")
    private String tpAmp;
    
    @XStreamAlias("verAplic")
    private String verAplic;
    
    @XStreamAlias("chNFe")
    private String chNFe;
    
    @XStreamAlias("dhRecbto")
    private String dhRecbto;
    
    @XStreamAlias("nProt")
    private String nProt;
    
    @XStreamAlias("digVal")
    private String digVal;
    
    @XStreamAlias("cStat")
    private String cStat;
    
    @XStreamAlias("xMotivo")
    private String xMotivo;

    public String getTpAmp() {
        return tpAmp;
    }

    public String getVerAplic() {
        return verAplic;
    }

    public String getChNFe() {
        return chNFe;
    }

    public String getDhRecbto() {
        return dhRecbto;
    }

    public String getnProt() {
        return nProt;
    }

    public String getDigVal() {
        return digVal;
    }

    public String getcStat() {
        return cStat;
    }

    public String getxMotivo() {
        return xMotivo;
    }

}
