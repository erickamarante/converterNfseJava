package com.constanzooficial.integracao.model.sp.osasco;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Luis Sanches
 */
@XStreamAlias("Endereco")
public class Endereco {
    
    @XStreamAlias("TipoLogradouro")
    private String tipoLogradouro;
    
    @XStreamAlias("Logradouro")
    private String logradouro;
    
    @XStreamAlias("Numero")
    private String numero;
    
    @XStreamAlias("Complemento")
    private String complemento;
    
    @XStreamAlias("Bairro")
    private String bairro;
    
    @XStreamAlias("Cidade")
    private String cidade;
    
    @XStreamAlias("CEP")
    private String cep;
    
    @XStreamAlias("Estado")
    private String estado;
    
    @XStreamAlias("Pais")
    private String pais;

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getCep() {
        return cep;
    }

    public String getEstado() {
        return estado;
    }
    
}
