package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("PISAliq")
public class PISAliq {
    
    @XStreamAlias("CST")
    private String cst;
    
    @XStreamAlias("vBC")
    private String vBc;
    
    @XStreamAlias("pPIS")
    private String pPis;
    
    @XStreamAlias("vPIS")
    private String valorPis;

    public String getCst() {
        return cst;
    }

    public String getvBc() {
        return vBc;
    }

    public String getpPis() {
        return pPis;
    }

    public String getValorPis() {
        return valorPis;
    }

}
