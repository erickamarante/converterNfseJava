package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("emit")
public class Emit {
    
    @XStreamAlias("CNPJ")
    private String cnpj;
    
    @XStreamAlias("xNome")
    private String razaoSocial;
    
    @XStreamAlias("xFant")
    private String nomeFantasia;
    
    @XStreamAlias("enderEmit")
    private EnderEmit enderEmit;
    
    @XStreamAlias("IE")
    private String inscricaoEstadual;
    
    @XStreamAlias("IM")
    private String inscricaoMunicipal;
    
    @XStreamAlias("CNAE")
    private String cnae;
    
    @XStreamAlias("CRT")
    private String crt;

    public String getCnpj() {
        return cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia ;
    }

    public EnderEmit getEnderEmit() {
        return enderEmit;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public String getCnae() {
        return cnae;
    }

    public String getCrt() {
        return crt;
    }
 
}
