package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.constanzooficial.integracao.util.MyUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("infEvento")
public class InfEvento {
    
    @XStreamAlias("Id")
    @XStreamAsAttribute
    private String id;
    
    @XStreamAlias("cOrgao")
    private String cOrgao;
    
    @XStreamAlias("tpAmb")
    private String tpAmb;
    
    @XStreamAlias("CNPJ")
    private String cnpj;
    
    @XStreamAlias("chNFe")
    private String chNFe;
    
    @XStreamAlias("dhEvento")
    private String dhEvento;
    
    @XStreamAlias("tpEvento")
    private String tpEvento;
    
    @XStreamAlias("nSeqEvento")
    private String nSeqEvento;
    
    @XStreamAlias("verEvento")
    private String verEvento;
    
    @XStreamAlias("detEvento")
    private DetEvento detEvento;
    
    @XStreamAlias("verAplic")
    private String verAplic;
    
    @XStreamAlias("cStat")
    private String cStat;
    
    @XStreamAlias("xMotivo")
    private String xMotivo;
    
    @XStreamAlias("CNPJDest")
    private String cnpjDest;
    
    @XStreamAlias("dhRegEvento")
    private String dhRegEvento;
    
    @XStreamAlias("nProt")
    private String nProt;

    public String getId() {
        return id;
    }

    public String getcOrgao() {
        return cOrgao;
    }

    public String getTpAmb() {
        return tpAmb;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getChNFe() {
        return chNFe.substring(30, 34);
    }

    public String[] getDhEvento() {
        String[] retorno = MyUtils.trataDataHora2(dhEvento.substring(0, 19));
        //System.out.println("Data de emissão: " + Arrays.toString(retorno) + "\n");
        return retorno;
    }

    public String getTpEvento() {
        return tpEvento;
    }

    public String getnSeqEvento() {
        return nSeqEvento;
    }

    public String getVerEvento() {
        return verEvento;
    }

    public DetEvento getDetEvento() {
        return detEvento;
    }

    public String getVerAplic() {
        return verAplic;
    }

    public String getcStat() {
        return cStat;
    }

    public String getxMotivo() {
        return xMotivo;
    }

    public String getCnpjDest() {
        return cnpjDest;
    }

    public String getDhRegEvento() {
        return dhRegEvento;
    }

    public String getnProt() {
        return nProt;
    }

}
