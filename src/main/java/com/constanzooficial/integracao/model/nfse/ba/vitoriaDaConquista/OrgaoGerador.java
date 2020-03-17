package com.constanzooficial.integracao.model.nfse.ba.vitoriaDaConquista;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("OrgaoGerador")
public class OrgaoGerador {
    
    @XStreamAlias("CodigoMunicipio")
    private String codigoMunicipio;

    @XStreamAlias("Uf")
    private String uf;

    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public String getUf() {
        return uf;
    }
    
}
