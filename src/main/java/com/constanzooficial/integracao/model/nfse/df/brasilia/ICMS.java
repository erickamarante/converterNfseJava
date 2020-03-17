package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("ICMS")
public class ICMS {
    
    @XStreamAlias("ICMSSN102")
    private ICMSSN102 icmssn102;

    public ICMSSN102 getIcmssn102() {
        return icmssn102;
    }
    
}
