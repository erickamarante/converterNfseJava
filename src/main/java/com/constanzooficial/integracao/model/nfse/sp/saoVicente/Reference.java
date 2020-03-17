package com.constanzooficial.integracao.model.nfse.sp.saoVicente;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import java.util.ArrayList;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("Reference")
public class Reference {

    @XStreamAlias("URI")
    @XStreamAsAttribute
    private String uri;

    @XStreamAlias("Transforms")
    private ArrayList<Transform> transforms;

    @XStreamAlias("DigestMethod")
    private DigestMethod digestMethod;

    @XStreamAlias("DigestValue")
    private String digestValue;

    public String getUri() {
        return uri;
    }

    public ArrayList<Transform> getTransforms() {
        return transforms;
    }

    public DigestMethod getDigestMethod() {
        return digestMethod;
    }

    public String getDigestValue() {
        return digestValue;
    }
}
