package com.constanzooficial.integracao.model.nfse.mt.campoNovoDoParecis;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("ConsultarNfseRpsResposta")
public class ConsultarNfseRpsResposta {

    @XStreamAlias("xmlns")
    @XStreamAsAttribute
    private String xmlns;

    @XStreamAlias("CompNfse")
    private CompNfse compNfse;

    public String getXmlns() {
        return xmlns;
    }

    public CompNfse getCompNfse() {
        return compNfse;
    }

}
