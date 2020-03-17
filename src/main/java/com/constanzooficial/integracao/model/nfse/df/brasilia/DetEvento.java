package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("detEvento")
public class DetEvento {
    
    @XStreamAlias("versao")
    @XStreamAsAttribute
    private String versao;
    
    @XStreamAlias("descEvento")
    private String descEvento;
    
    @XStreamAlias("nProt")
    private String nProt;
    
    @XStreamAlias("xJust")
    private String xJust;

    public String getVersao() {
        return versao;
    }

    public String getDescEvento() {
        return descEvento;
    }

    public String getnProt() {
        return nProt;
    }

    public String getxJust() {
        return xJust;
    }

}
