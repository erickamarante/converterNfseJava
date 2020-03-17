package com.constanzooficial.integracao.model.nfse.sp.barueri;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("IdentificacaoPrestador")
public class IdentificacaoPrestador {

    @XStreamAlias("CpfCnpj")
    private CpfCnpj CpfCnpj;

    @XStreamAlias("InscricaoMunicipal")
    private String InscricaoMunicipal;

    public CpfCnpj getCpfCnpj() {
        return CpfCnpj;
    }

    public String getInscricaoMunicipal() {
        return InscricaoMunicipal;
    }
}
