package com.aldeiaconsultoriajr.nfe.go.rioVerde;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("Contato")
public class Contato {

    @XStreamAlias("Telefone")
    private String telefone;
    @XStreamAlias("Email")
    private String email;

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

}
