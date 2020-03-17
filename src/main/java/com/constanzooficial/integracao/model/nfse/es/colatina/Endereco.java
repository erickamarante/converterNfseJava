package com.constanzooficial.integracao.model.nfse.es.colatina;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Luis Sanches
 */
@XStreamAlias("Endereco")
public class Endereco {
    
    @XStreamAlias("LogradouroTipo")
    private String logradouroTipo;
    
    @XStreamAlias("Logradouro")
    private String logradouro;
    
    @XStreamAlias("LogradouroNumero")
    private String logradouroNumero;
    
    @XStreamAlias("LogradouroComplemento")
    private String logradouroComplemento;
    
    @XStreamAlias("Bairro")
    private String bairro;
    
    @XStreamAlias("CodigoMunicipio")
    private String codigoMunicipio;
    
    @XStreamAlias("Municipio")
    private String municipio;
    
    @XStreamAlias("Uf")
    private String uf;
    
    @XStreamAlias("Cep")
    private String cep;

    public String getLogradouroTipo() {
        return logradouroTipo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getLogradouroNumero() {
        return logradouroNumero;
    }

    public String getLogradouroComplemento() {
        return logradouroComplemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getUf() {
        return uf;
    }

    public String getCep() {
        return cep;
    }
    
}
