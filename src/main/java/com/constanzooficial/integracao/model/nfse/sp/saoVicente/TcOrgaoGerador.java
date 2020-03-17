package com.constanzooficial.integracao.model.nfse.sp.saoVicente;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("tc:OrgaoGerador")
public class TcOrgaoGerador {

    @XStreamAlias("tc:CodigoMunicipio")
    private String tcCodigoMunicipio;

    @XStreamAlias("tc:Uf")
    private String tcUf;

    public String getTcCodigoMunicipio() {
        return tcCodigoMunicipio;
    }

    public String getTcUf() {
        return tcUf;
    }
}
