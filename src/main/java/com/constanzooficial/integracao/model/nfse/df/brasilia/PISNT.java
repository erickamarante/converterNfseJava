package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("PISNT")
public class PISNT {
    
    @XStreamAlias("CST")
    private String CST;

    public String getCST() {
        return CST;
    }
    
}
