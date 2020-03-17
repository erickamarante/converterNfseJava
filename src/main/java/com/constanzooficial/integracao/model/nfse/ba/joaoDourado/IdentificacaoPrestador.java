package com.constanzooficial.integracao.model.nfse.ba.joaoDourado;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("IdentificacaoPrestador")
public class IdentificacaoPrestador {

    @XStreamAlias("CpfCnpj")
    private CpfCnpj CpfCnpj;

    @XStreamAlias("InscricaoMunicipal")
    private String InscricaoMunicipal;

    public String getInscricaoMunicipal() {
        return InscricaoMunicipal;
    }

    public CpfCnpj getCpfCnpj() {
        return CpfCnpj;
    }
}
