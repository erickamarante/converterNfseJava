package com.constanzooficial.integracao.model.nfse.sp.bauru;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("EnderecoPrestador")
public class EnderecoPrestador {
    @XStreamAlias("Logradouro")
    private String logradouro;
    
    @XStreamAlias("NumeroEndereco")
    private String numeroEndereco;
    
    @XStreamAlias("ComplementoEndereco")
    private String complementoEndereco;
    
    @XStreamAlias("Bairro")
    private String bairro;
    
    @XStreamAlias("Cidade")
    private String cidade;
    
    @XStreamAlias("UF")
    private String uf;
    
    @XStreamAlias("CEP")
    private String cep;

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumeroEndereco() {
        return numeroEndereco;
    }

    public String getComplementoEndereco() {
        return complementoEndereco;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }

    public String getCep() {
        return cep;
    }
}
