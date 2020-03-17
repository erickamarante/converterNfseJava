package com.constanzooficial.integracao.model.nfse.ba.joaoDourado;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("Prestador")
public class Prestador {
    
    @XStreamAlias("CpfCnpj")
    private CpfCnpj cpfCnpj;

    @XStreamAlias("InscricaoMunicipal")
    private Servico InscricaoMunicipal;

    public CpfCnpj getCpfCnpj() {
        return cpfCnpj;
    }

    public Servico getInscricaoMunicipal() {
        return InscricaoMunicipal;
    }
}
