package com.constanzooficial.integracao.model.nfse.sp.saoVicente;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("ConsultarNfseRpsResposta")
public class ConsultarNfseRpsResposta {
    
    @XStreamAlias("xmlns:tc")
    @XStreamAsAttribute
    private String xmlnsTc;
    
    @XStreamAlias("xmlns:ts")
    @XStreamAsAttribute
    private String xmlnsTs;
    
    @XStreamAlias("xmlns")
    @XStreamAsAttribute
    private String xmlns;
    
    @XStreamAlias("CompNfse")
    private CompNfse compNfse;

    public String getXmlnsTc() {
        return xmlnsTc;
    }

    public String getXmlnsTs() {
        return xmlnsTs;
    }

    public String getXmlns() {
        return xmlns;
    }

    public CompNfse getCompNfse() {
        return compNfse;
    }
}
