package com.constanzooficial.integracao.model.nfse.rn.caico;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
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
