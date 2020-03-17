package com.constanzooficial.integracao.model.nfse.go.rioVerde;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("Servico")
public class Servico {
    
    @XStreamAlias("Discriminacao")
    private String discriminacao;
    
    @XStreamAlias("CodigoMunicipio")
    private String codigoMunicipio;

    public String getDiscriminacao() {
        return discriminacao;
    }

    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }
    
}
