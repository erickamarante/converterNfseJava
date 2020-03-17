package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("infInut")
public class InfInut {
    
    
    @XStreamAlias("tpAmb")
    private String tpAmb;
    
    @XStreamAlias("verAplic")
    private String verAplic;
    
    @XStreamAlias("cStat")
    private String cStat;
    
    @XStreamAlias("xMotivo")
    private String xMotivo;
    
    @XStreamAlias("cUF")
    private String cUF;
    
    @XStreamAlias("ano")
    private String ano;
    
    @XStreamAlias("CNPJ")
    private String CNPJ;
    
    @XStreamAlias("mod")
    private String mod;
    
    @XStreamAlias("serie")
    private String serie;
    
    @XStreamAlias("nNFIni")
    private String nNFIni;
    
    @XStreamAlias("nNFFin")
    private String nNFFin;
    
    @XStreamAlias("dhRecbto")
    private String dhRecbto;
    
    @XStreamAlias("nProt")
    private String nProt;

    public String getTpAmb() {
        return tpAmb;
    }

    public String getVerAplic() {
        return verAplic;
    }

    public String getcStat() {
        return cStat;
    }

    public String getxMotivo() {
        return xMotivo;
    }

    public String getcUF() {
        return cUF;
    }

    public String getAno() {
        return ano;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public String getMod() {
        return mod;
    }

    public String getSerie() {
        return serie;
    }

    public String getnNFIni() {
        return nNFIni;
    }

    public String getnNFFin() {
        return nNFFin;
    }

    public String getDhRecbto() {
        return dhRecbto;
    }

    public String getnProt() {
        return nProt;
    }
}
