package com.constanzooficial.integracao.model.nfse.sp.saoVicente;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("DigestMethod")
public class DigestMethod {

    @XStreamAlias("Algorithm")
    @XStreamAsAttribute
    private String algorithm;

    public String getAlgorithm() {
        return algorithm;
    }
}
