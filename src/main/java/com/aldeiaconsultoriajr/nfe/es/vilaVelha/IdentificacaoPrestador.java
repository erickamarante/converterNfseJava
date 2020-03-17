package com.aldeiaconsultoriajr.nfe.es.vilaVelha;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("IdentificacaoPrestador")
public class IdentificacaoPrestador {

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
