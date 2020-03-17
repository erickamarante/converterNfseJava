package com.aldeiaconsultoriajr.nfe.es.vilaVelha;

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

    public String getEmail() {
        return email;
    }
}
