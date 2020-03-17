package com.constanzooficial.integracao.model.sp.osasco;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Luis Sanches
 */
@XStreamAlias("Tomador")
public class Tomador {
    
    @XStreamAlias("Id")
    private String id;
    
    @XStreamAlias("CNPJ")
    private String cnpj;
    
    @XStreamAlias("CPF")
    private String cpf;
    
    @XStreamAlias("InscricaoMunicipal")
    private String inscricaoMunicipal;
    
    @XStreamAlias("Nome")
    private String nome;
    
    @XStreamAlias("Email")
    private String email;
    
    @XStreamAlias("Endereco")
    private Endereco endereco;

    public String getId() {
        return id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }
    
}
