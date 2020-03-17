package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("enderEmit")
public class EnderEmit {
    
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
    private String municipio;
    
    @XStreamAlias("UF")
    private String uf;
    
    @XStreamAlias("CEP")
    private String cep;
    
    @XStreamAlias("cPais")
    private String codigoPais;
    
    @XStreamAlias("xPais")
    private String pais;
    
    @XStreamAlias("fone")
    private String telefone;

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

    public String getMunicipio() {
        return municipio;
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

    public String getPais() {
        return pais;
    }

    public String getTelefone() {
        return telefone;
    }
    
    
    
}
