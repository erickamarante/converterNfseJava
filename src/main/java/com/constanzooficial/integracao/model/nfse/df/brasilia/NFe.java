package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("NFe")
public class NFe {
    
    @XStreamAlias("xmlns")
    @XStreamAsAttribute
    private String xmlns;
    
    @XStreamAlias("infNFe")
    private InfNFe infNfe;
    
    @XStreamAlias("Signature")
    private Signature signature;

    public String getXmlns() {
        return xmlns;
    }

    public InfNFe getInfNfe() {
        return infNfe;
    }

    public Signature getSignature() {
        return signature;
    }

}
