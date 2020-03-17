package com.constanzooficial.integracao.model.nfse.sp.saoVicente;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("KeyInfo")
public class KeyInfo {

    @XStreamAlias("X509Data")
    private X509Data x509Data;

    public X509Data getX509Data() {
        return x509Data;
    }
}
