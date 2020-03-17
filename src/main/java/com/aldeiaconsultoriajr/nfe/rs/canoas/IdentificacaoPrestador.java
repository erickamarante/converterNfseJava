package com.aldeiaconsultoriajr.nfe.rs.canoas;

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

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }
}
