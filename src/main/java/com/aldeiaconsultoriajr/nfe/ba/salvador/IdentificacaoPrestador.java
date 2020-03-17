package com.aldeiaconsultoriajr.nfe.ba.salvador;

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
        return cnpj.replace(".", "").replace("/", "").replaceAll("-", "");
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }
}
