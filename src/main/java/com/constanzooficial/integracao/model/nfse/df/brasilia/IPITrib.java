package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("IPITrib")
public class IPITrib {
    
    @XStreamAlias("CST")
    private String cst;
    
    @XStreamAlias("qUnid")
    private String qUnidade;
    
    @XStreamAlias("vUnid")
    private String valorUnidade;
    
    @XStreamAlias("vIPI")
    private String valorIpi;

    public String getCst() {
        return cst;
    }

    public String getqUnidade() {
        return qUnidade;
    }

    public String getValorUnidade() {
        return valorUnidade;
    }

    public String getValorIpi() {
        return valorIpi;
    }
    
    
    
}
