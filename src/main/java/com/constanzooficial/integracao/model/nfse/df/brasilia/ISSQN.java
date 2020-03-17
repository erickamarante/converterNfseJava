package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("ISSQN")
public class ISSQN {
    
    @XStreamAlias("vBC")
    private String baseCalculo;
    
    @XStreamAlias("vAliq")
    private String aliquota;
    
    @XStreamAlias("vISSQN")
    private String valorIssQn;
    
    @XStreamAlias("cMunFG")
    private String cMunFg;
    
    @XStreamAlias("cListServ")
    private String cListServ;
    
    @XStreamAlias("vISSRet")
    private String vISSRet;
    
    @XStreamAlias("indISS")
    private String indIss;
    
    @XStreamAlias("indIncentivo")
    private String indIncentivo;

    public String getBaseCalculo() {
        return baseCalculo;
    }

    public String getAliquota() {
        return aliquota;
    }

    public String getValorIssQn() {
        return valorIssQn;
    }

    public String getcMunFg() {
        return cMunFg;
    }

    public String getcListServ() {
        return cListServ;
    }

    public String getIndIss() {
        return indIss;
    }

    public String getIndIncentivo() {
        return indIncentivo;
    }

    public String getvISSRet() {
        return vISSRet;
    }

}
