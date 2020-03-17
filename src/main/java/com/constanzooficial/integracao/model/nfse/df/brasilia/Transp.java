package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("Transp")
public class Transp {
    
    @XStreamAlias("modFrete")
    private String modFrete;
    
    @XStreamAlias("vol")
    private Vol vol;

    public String getModFrete() {
        return modFrete;
    }

    public Vol getVol() {
        return vol;
    }

}
