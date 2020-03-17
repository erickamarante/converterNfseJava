package com.constanzooficial.integracao.model.nfse.sc.agrolandia2;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("tomador")
public class Tomador {

    @XStreamAlias("tipo")
    private String tipo;
    
    @XStreamAlias("cpfcnpj")
    private String cpfCnpj;
    
    @XStreamAlias("ie")
    private String ie;
    
    @XStreamAlias("nome_razao_social")
    private String nomeRazaoSocial;

    @XStreamAlias("sobrenome_nome_fantasia")
    private String sobrenomeNomeFantasia;
    
    @XStreamAlias("logradouro")
    private String logradouro;
    
    @XStreamAlias("email")
    private String email;
    
    @XStreamAlias("complemento")
    private String complemento;
    
    @XStreamAlias("ponto_referencia")
    private String pontoReferencia;
    
    @XStreamAlias("bairro")
    private String bairro;
    
    @XStreamAlias("cidade")
    private String cidade;
    
    @XStreamAlias("cep")
    private String cep;
    
    @XStreamAlias("ddd_fone_comercial")
    private String dddFoneComercial;
    
    @XStreamAlias("fone_comercial")
    private String foneComercial;
    
    @XStreamAlias("ddd_fone_residencial")
    private String dddFoneResidencial;
    
    @XStreamAlias("fone_residencial")
    private String foneResidencial;
    
    @XStreamAlias("ddd_fax")
    private String dddFax;
    
    @XStreamAlias("fone_fax")
    private String foneFax;

    public String getTipo() {
        return tipo;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getIe() {
        return ie;
    }

    public String getNomeRazaoSocial() {
        return nomeRazaoSocial;
    }

    public String getSobrenomeNomeFantasia() {
        return sobrenomeNomeFantasia;
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

    public String getPontoReferencia() {
        return pontoReferencia;
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

    public String getDddFoneComercial() {
        return dddFoneComercial;
    }

    public String getFoneComercial() {
        return foneComercial;
    }

    public String getDddFoneResidencial() {
        return dddFoneResidencial;
    }

    public String getFoneResidencial() {
        return foneResidencial;
    }

    public String getDddFax() {
        return dddFax;
    }

    public String getFoneFax() {
        return foneFax;
    }
    
}
