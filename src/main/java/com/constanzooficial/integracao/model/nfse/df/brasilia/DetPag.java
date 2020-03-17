package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("detPag")
public class DetPag {
    
    @XStreamAlias("tPag")
    private String tPag;
    
    @XStreamAlias("vPag")
    private String vPag;
    
    @XStreamAlias("indPag")
    private String indPag;
    
    @XStreamAlias("card")
    private String card;

    public String gettPag() {
        return tPag;
    }

    public String getvPag() {
        return vPag;
    }

    public String getIndPag() {
        return indPag;
    }

    public String getCard() {
        return card;
    }

}
