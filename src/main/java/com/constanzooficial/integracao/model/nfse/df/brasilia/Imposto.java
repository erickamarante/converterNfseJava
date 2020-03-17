package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("imposto")
public class Imposto {
    
    @XStreamAlias("vTotTrib")
    private String valorTotalTributacao;
    
    @XStreamAlias("IPI")
    private IPI ipi;
    
    @XStreamAlias("ISSQN")
    private ISSQN issQn;
    
    @XStreamAlias("ICMS")
    private ICMS icms;
    
    @XStreamAlias("PIS")
    private PIS pis;
    
    @XStreamAlias("COFINS")
    private COFINS cofins;

    public String getValorTotalTributacao() {
        return valorTotalTributacao;
    }

    public IPI getIpi() {
        return ipi;
    }

    public ISSQN getIssQn() {
        return issQn;
    }

    public PIS getPis() {
        return pis;
    }

    public COFINS getCofins() {
        return cofins;
    }

    /**
     * @return the icms
     */
    public ICMS getIcms() {
        return icms;
    }

}
