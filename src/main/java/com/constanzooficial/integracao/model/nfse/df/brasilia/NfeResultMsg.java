package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("NfeResultMsg")
public class NfeResultMsg {
    
    @XStreamAlias("xmlns")
    @XStreamAsAttribute
    private String xmlns;
    
    @XStreamAlias("retInutNFe")
    private RetInutNFe retInutNFe;

    public String getXmlns() {
        return xmlns;
    }

    public RetInutNFe getRetInutNFe() {
        return retInutNFe;
    }
}
