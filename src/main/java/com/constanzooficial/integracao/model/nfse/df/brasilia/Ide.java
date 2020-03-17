package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.constanzooficial.integracao.util.MyUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.Arrays;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("ide")
public class Ide {
    
    @XStreamAlias("cUF")
    private String cUf;
    
    @XStreamAlias("cNF")
    private String cNf;
    
    @XStreamAlias("natOp")
    private String natOp;
    
    @XStreamAlias("mod")
    private String mod;
    
    @XStreamAlias("serie")
    private String serie;
    
    @XStreamAlias("nNF")
    private String numeroNfe;
    
    @XStreamAlias("dhEmi")
    private String dataHoraEmissao;
    
    @XStreamAlias("dhSaiEnt")
    private String dhSaiEnt;
    
    @XStreamAlias("tpNF")
    private String tpNf;
    
    @XStreamAlias("idDest")
    private String idDest;
    
    @XStreamAlias("cMunFG")
    private String cMunFg;
    
    @XStreamAlias("tpImp")
    private String tpImp;
    
    @XStreamAlias("tpEmis")
    private String tpEmis;
    
    @XStreamAlias("cDV")
    private String cDv;
    
    @XStreamAlias("tpAmb")
    private String tpAmp;
    
    @XStreamAlias("finNFe")
    private String finNfe;
    
    @XStreamAlias("indFinal")
    private String indFinal;
    
    @XStreamAlias("indPres")
    private String indPres;
    
    @XStreamAlias("procEmi")
    private String procEmi;
    
    @XStreamAlias("verProc")
    private String verProc;

    public String getcUf() {
        return cUf;
    }

    public String getcNf() {
        return cNf;
    }

    public String getNatOp() {
        return natOp;
    }

    public String getMod() {
        return mod;
    }

    public String getSerie() {
        return serie;
    }

    public String getnumeroNfe() {
        return numeroNfe;
    }

    public String[] getDataHoraEmissao() {
        String[] retorno = MyUtils.trataDataHora2(dataHoraEmissao.substring(0, 19));
        //System.out.println("Data de emissão: " + Arrays.toString(retorno) + "\n");
        return retorno;
    }

    public String getDhSaiEnt() {
        return dhSaiEnt;
    }

    public String getTpNf() {
        return tpNf;
    }

    public String getIdDest() {
        return idDest;
    }

    public String getcMunFg() {
        return cMunFg;
    }

    public String getTpImp() {
        return tpImp;
    }

    public String getTpEmis() {
        return tpEmis;
    }

    public String getcDv() {
        return cDv;
    }

    public String getTpAmp() {
        return tpAmp;
    }

    public String getFinNfe() {
        return finNfe;
    }

    public String getIndFinal() {
        return indFinal;
    }

    public String getIndPres() {
        return indPres;
    }

    public String getProcEmi() {
        return procEmi;
    }

    public String getVerProc() {
        return verProc;
    }
    
    
    
}
