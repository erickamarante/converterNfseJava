package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("pag")
public class Pag {
    
    @XStreamAlias("detPag")
    private DetPag detPag;

    public DetPag getDetPag() {
        return detPag;
    }

}
