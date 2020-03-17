package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("dest")
public class Dest {
    
    @XStreamAlias("CPF")
    private String cpf;
    
    @XStreamAlias("CNPJ")
    private String cnpj;
    
    @XStreamAlias("xNome")
    private String nome;
    
    @XStreamAlias("enderDest")
    private EnderDest enderecoDest;
    
    @XStreamAlias("indIEDest")
    private String indIeDest;
    
    @XStreamAlias("IE")
    private String ie;
    
    @XStreamAlias("email")
    private String email;

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public EnderDest getEnderecoDest() {
        return enderecoDest;
    }

    public String getIndIeDest() {
        return indIeDest;
    }
    
    public String getEmail() {
        return email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getIe() {
        return ie.substring(1, 13);
    }
    
}
