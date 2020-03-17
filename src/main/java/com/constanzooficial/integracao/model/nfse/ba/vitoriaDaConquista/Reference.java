package com.constanzooficial.integracao.model.nfse.ba.vitoriaDaConquista;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("Reference")
public class Reference {
    
    @XStreamAlias("URI")
    @XStreamAsAttribute
    private String URI;
    
    @XStreamAlias("Transforms")
    private Transforms transforms;
    
    @XStreamAlias("DigestMethod")
    private DigestMethod digestMethod;
    
    @XStreamAlias("DigestValue")
    private String digestValue;

    public String getURI() {
        return URI;
    }

    public Transforms getTransforms() {
        return transforms;
    }

    public DigestMethod getDigestMethod() {
        return digestMethod;
    }

    public String getDigestValue() {
        return digestValue;
    }
    
}
