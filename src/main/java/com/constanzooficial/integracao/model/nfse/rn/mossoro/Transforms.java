package com.constanzooficial.integracao.model.nfse.rn.mossoro;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("Transforms")
public class Transforms {
    
    @XStreamAlias("Transform")
    private Transform transform;

    public Transform getTransform() {
        return transform;
    }

}
