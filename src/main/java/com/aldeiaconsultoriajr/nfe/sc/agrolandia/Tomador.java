package com.aldeiaconsultoriajr.nfe.sc.agrolandia;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("tomador")
public class Tomador {

    @XStreamAlias("tipo")
    private String tipo;

    @XStreamAlias("cpfcnpj")
    private String cpfcnpj;

    @XStreamAlias("ie")
    private String ie;

    @XStreamAlias("nome_razao_social")
    private String nome_razao_social;

    @XStreamAlias("sobrenome_nome_fantasia")
    private String sobrenome_nome_fantasia;

    @XStreamAlias("logradouro")
    private String logradouro;

    @XStreamAlias("email")
    private String email;

    @XStreamAlias("complemento")
    private String complemento;

    @XStreamAlias("ponto_referencia")
    private String ponto_referencia;

    @XStreamAlias("bairro")
    private String bairro;

    @XStreamAlias("cidade")
    private String cidade;

    @XStreamAlias("cep")
    private String cep;

    @XStreamAlias("ddd_fone_comercial")
    private String ddd_fone_comercial;

    @XStreamAlias("fone_comercial")
    private String fone_comercial;

    @XStreamAlias("ddd_fone_residencial")
    private String ddd_fone_residencial;

    @XStreamAlias("fone_residencial")
    private String fone_residencial;

    @XStreamAlias("ddd_fax")
    private String ddd_fax;

    @XStreamAlias("fone_fax")
    private String fone_fax;

    public String getTipo() {
        return tipo;
    }

    public String getCpfcnpj() {
        return cpfcnpj;
    }

    public String getIe() {
        return ie;
    }

    public String getNome_razao_social() {
        return nome_razao_social;
    }

    public String getSobrenome_nome_fantasia() {
        return sobrenome_nome_fantasia;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getEmail() {
        return email;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getPonto_referencia() {
        return ponto_referencia;
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

    public String getDdd_fone_comercial() {
        return ddd_fone_comercial;
    }

    public String getFone_comercial() {
        return fone_comercial;
    }

    public String getDdd_fone_residencial() {
        return ddd_fone_residencial;
    }

    public String getFone_residencial() {
        return fone_residencial;
    }

    public String getDdd_fax() {
        return ddd_fax;
    }

    public String getFone_fax() {
        return fone_fax;
    }
}
