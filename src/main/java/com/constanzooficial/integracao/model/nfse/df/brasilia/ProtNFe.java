package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("protNFe")
public class ProtNFe {
    
    @XStreamAlias("xmlns")
    @XStreamAsAttribute
    private String xmlns;
    
    @XStreamAlias("versao")
    @XStreamAsAttribute
    private String versao;
    
    @XStreamAlias("infProt")
    private InfProt infProt;

    public String getXmlns() {
        return xmlns;
    }

    public String getVersao() {
        return versao;
    }

    public InfProt getInfProt() {
        return infProt;
    }
 
}
