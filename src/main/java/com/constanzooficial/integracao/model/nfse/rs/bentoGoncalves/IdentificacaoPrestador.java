package com.constanzooficial.integracao.model.nfse.rs.bentoGoncalves;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("IdentificacaoPrestador")
public class IdentificacaoPrestador {

    @XStreamAlias("Cnpj")
    private String cnpj;

    @XStreamAlias("InscricaoMunicipal")
    private String InscricaoMunicipal;

    public String getCnpj() {
        return cnpj;
    }

    public String getInscricaoMunicipal() {
        return InscricaoMunicipal;
    }
}
