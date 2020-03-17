package com.aldeiaconsultoriajr.nfe.ba.salvador;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
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
