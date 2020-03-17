package com.constanzooficial.integracao.model.sp.osasco;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Luis Sanches
 */
@XStreamAlias("Prestador")
public class Prestador {
    
    @XStreamAlias("CNPJ")
    private String cnpj;
    
    @XStreamAlias("InscricaoMunicipal")
    private String inscricaoMunicipal;
    
    @XStreamAlias("Nome")
    private String nome;
    
    @XStreamAlias("Email")
    private String email;
    
    @XStreamAlias("Endereco")
    private Endereco endereco;
    
    @XStreamAlias("Telefone")
    private String telefone;

    public String getCnpj() {
        return cnpj;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }
    
}
