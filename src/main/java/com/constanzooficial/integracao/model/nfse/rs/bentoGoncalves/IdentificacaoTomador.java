package com.constanzooficial.integracao.model.nfse.rs.bentoGoncalves;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("IdentificacaoTomador")
public class IdentificacaoTomador {

    @XStreamAlias("CpfCnpj")
    private CpfCnpj cpfCnpj;
    
    @XStreamAlias("InscricaoMunicipal")
    private String InscricaoMunicipal;

    public CpfCnpj getCpfCnpj() {
        return cpfCnpj;
    }

    public String getInscricaoMunicipal() {
        return InscricaoMunicipal;
    }
}
