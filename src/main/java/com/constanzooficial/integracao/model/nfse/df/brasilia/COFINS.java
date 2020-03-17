package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("COFINS")
public class COFINS {
    
    @XStreamAlias("COFINSAliq")
    private COFINSAliq cofinsAliquota;
    
    @XStreamAlias("COFINSOutr")
    private String COFINSOutr;
    
    @XStreamAlias("COFINSNT")
    private PISNT COFINSNT;

    public COFINSAliq getCofinsAliquota() {
        return cofinsAliquota;
    }

    public String getCOFINSOutr() {
        return COFINSOutr;
    }
    
}
