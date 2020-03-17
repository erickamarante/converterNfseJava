package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("Transforms")
public class Transforms {
    
    @XStreamAlias("Transform")
    private Transform transform1;

    public Transform getTransform() {
        return transform1;
    }

}
