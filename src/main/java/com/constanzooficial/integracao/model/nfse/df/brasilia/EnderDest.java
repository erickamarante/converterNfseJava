package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("enderDest")
public class EnderDest {
    
    @XStreamAlias("xLgr")
    private String logradouro;
    
    @XStreamAlias("nro")
    private String numero;
    
    @XStreamAlias("xCpl")
    private String cpl;
    
    @XStreamAlias("xBairro")
    private String bairro;
    
    @XStreamAlias("cMun")
    private String codigoMunicipio;
    
    @XStreamAlias("xMun")
    private String Municipio;
    
    @XStreamAlias("UF")
    private String uf;
    
    @XStreamAlias("cPais")
    private String codigoPais;
    
    @XStreamAlias("xPais")
    private String pais;
    
    @XStreamAlias("fone")
    private String fone;
    
    @XStreamAlias("CEP")
    private String cep;

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getCpl() {
        return cpl;
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

    public String getCodigoPais() {
        return codigoPais;
    }

    public String getPais() {
        return pais;
    }

    public String getMunicipio() {
        return Municipio;
    }
    
    public String getFone() {
        return fone;
    }
    
    public String getCep() {
        return cep;
    }

}
