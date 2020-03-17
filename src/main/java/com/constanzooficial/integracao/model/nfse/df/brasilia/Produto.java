package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("prod")
public class Produto {
    
    @XStreamAlias("cProd")
    private String cProduto;
    
    @XStreamAlias("cEAN")
    private String cEan;
    
    @XStreamAlias("xProd")
    private String produto;
    
    @XStreamAlias("NCM")
    private String ncm;
    
    @XStreamAlias("cBenef")
    private String cBenef;
    
    @XStreamAlias("CEST")
    private String cest;
    
    @XStreamAlias("CFOP")
    private String codigoServico;
    
    @XStreamAlias("uCom")
    private String uCom;
    
    @XStreamAlias("qCom")
    private String qCom;
    
    @XStreamAlias("vUnCom")
    private String vUnCom;
    
    @XStreamAlias("vProd")
    private String valorProduto;
    
    @XStreamAlias("cEANTrib")
    private String cEanTrib;
    
    @XStreamAlias("uTrib")
    private String uTrib;
    
    @XStreamAlias("qTrib")
    private String qTrib;
    
    @XStreamAlias("vUnTrib")
    private String vUnTrib;
    
    @XStreamAlias("indTot")
    private String indTot;
    
    @XStreamAlias("xPed")
    private String xPed;
    
    @XStreamAlias("nItemPed")
    private String nItemPed;

    public String getCProduto() {
        return getcProduto();
    }

    public String getcEan() {
        return cEan;
    }

    public String getProduto() {
        return produto;
    }

    public String getNcm() {
        return ncm;
    }

    public String getCodigoServico() {
        return codigoServico;
    }

    public String getuCom() {
        return uCom;
    }

    public String getqCom() {
        return qCom;
    }

    public String getvUnCom() {
        return vUnCom;
    }

    public String getValorProduto() {
        return valorProduto;
    }

    public String getcEanTrib() {
        return cEanTrib;
    }

    public String getuTrib() {
        return uTrib;
    }

    public String getqTrib() {
        return qTrib;
    }

    public String getvUnTrib() {
        return vUnTrib;
    }

    public String getIndTot() {
        return indTot;
    }

    public String getcProduto() {
        return cProduto;
    }

    public String getCest() {
        return cest;
    }

    public String getxPed() {
        return xPed;
    }

    public String getcBenef() {
        return cBenef;
    }
    
    
    
}
