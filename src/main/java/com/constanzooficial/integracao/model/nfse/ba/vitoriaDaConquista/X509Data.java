package com.constanzooficial.integracao.model.nfse.ba.vitoriaDaConquista;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("X509Data")
public class X509Data {
    
    @XStreamAlias("X509Certificate")
    private String x509Certificate;

    public String getX509Certificate() {
        return x509Certificate;
    }

}
