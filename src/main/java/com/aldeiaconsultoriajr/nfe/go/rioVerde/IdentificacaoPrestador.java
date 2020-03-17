package com.aldeiaconsultoriajr.nfe.go.rioVerde;

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
    private String inscricaoMunicipal;

    public String getCnpj() {
        return cnpj;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

}
