package com.aldeiaconsultoriajr.nfe.go.rioVerde;

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
    private String inscricaoMunicipal;

    public CpfCnpj getCpfCnpj() {
        return cpfCnpj;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }
}
