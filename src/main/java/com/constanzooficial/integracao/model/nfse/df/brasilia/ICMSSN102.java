package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Wislan Sanches
 */
@XStreamAlias("ICMSSN102")
public class ICMSSN102 {

    @XStreamAlias("orig")
    private String orig;

    @XStreamAlias("CSOSN")
    private String csosn;

    public String getOrig() {
        return orig;
    }
    
    public String getCsosn() {
        return csosn;
    }

}
