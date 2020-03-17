package com.aldeiaconsultoriajr.nfe.rs.canoas;

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

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
