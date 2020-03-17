package com.constanzooficial.integracao.model.nfse.go.rioVerde;

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
    private String inscricaoMunicipal;

    public CpfCnpj getCpfCnpj() {
        return cpfCnpj;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

}
