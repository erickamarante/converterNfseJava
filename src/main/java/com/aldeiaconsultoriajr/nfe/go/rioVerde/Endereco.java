package com.aldeiaconsultoriajr.nfe.go.rioVerde;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("Endereco")
public class Endereco {

    @XStreamAlias("Endereco")
    private String endereco;
    @XStreamAlias("Numero")
    private String numero;
    @XStreamAlias("Complemento")
    private String complemento;
    @XStreamAlias("Bairro")
    private String bairro;
    @XStreamAlias("CodigoMunicipio")
    private String codigoMunicipio;
    @XStreamAlias("Uf")
    private String uf;
    @XStreamAlias("Cep")
    private String cep;
    @XStreamAlias("CodigoPais")
    private String codigoPais;

    public String getEndereco() {
        return endereco;
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

    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public String getUf() {
        return uf;
    }

    public String getCep() {
        return cep;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

}
