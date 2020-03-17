package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("retInutNFe")
public class RetInutNFe {
    
    @XStreamAlias("xmlns")
    @XStreamAsAttribute
    private String xmlns;
    
    @XStreamAlias("infInut")
    private InfInut infInut;

    public String getXmlns() {
        return xmlns;
    }

    public InfInut getInfInut() {
        return infInut;
    }
}
