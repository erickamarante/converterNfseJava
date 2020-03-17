package com.constanzooficial.integracao.model.nfse.rn.mossoro;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("EnviarLoteRpsEnvio")
public class EnviarLoteRpsEnvio {
    
    @XStreamAlias("xmlns")
    @XStreamAsAttribute
    private String xmlns;
    
    @XStreamAlias("LoteRps")
    private LoteRps loteRps;
    
    @XStreamAlias("Signature")
    private Signature signature;

    public String getXmlns() {
        return xmlns;
    }

    public LoteRps getLoteRps() {
        return loteRps;
    }

    public Signature getSignature() {
        return signature;
    }
}
