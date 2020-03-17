package com.constanzooficial.integracao.model.nfse.es.colatina;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Luis Sanches
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
