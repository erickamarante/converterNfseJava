package com.aldeiaconsultoriajr.nfe.pr.ibaiti;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.ArrayList;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("nfs")
public class Nfs {
    
    private String nrNfs;
    private String cdAutenticacao;
    private String dtEmissaoNfs;
    private String tpTributacao;
    private String isOptanteSimplesNacional;
    private String isIssRetido;
    private String isNfsCancelada;
    private String isNfsCartaCorrecao;
    private ArrayList<Servico> servicos;
    private String vlCofins;
    private String vlAliquotaCofins;
    private String vlCsll;
    private String vlAliquotaCsll;
    private String vlInss;
    private String vlAliquotaInss;
    private String vlIrpj;
    private String vlAliquotaIrpj;
    private String vlPis;
    private String vlAliquotaPis;
    private String vlBaseCalculo;
    private String vlTotalNota;
    private String vlTotalDeducoes;
    private String vlImposto;
    private PrestadorServico prestadorServico;
    private TomadorServico tomadorServico;
    private String dsImpostos;
    
    public String getNrNfs() {
        return nrNfs;
    }
    
    public String getCdAutenticacao() {
        return cdAutenticacao;
    }
    
    public String[] getDtEmissaoNfs() {
        
        String[] split;
        String[] retorno = new String[6];
        
        split = dtEmissaoNfs.split("-");
        retorno[0] = split[0];
        retorno[1] = split[1];
        split = split[2].split("T");
        retorno[2] = split[0];
        split = split[1].split(":");
        retorno[3] = split[0];
        retorno[4] = split[1];
        retorno[5] = split[2];
        
        return retorno;
    }
    
    public String getTpTributacao() {
        return tpTributacao;
    }
    
    public boolean getIsOptanteSimplesNacional() {
        return isOptanteSimplesNacional.equals("Optante");
    }
    
    public boolean getIsIssRetido() {
        return !isIssRetido.equals("Não");
    }
    
    public boolean getIsNfsCancelada() {
        return !isNfsCancelada.equals("Não");
    }
    
    public String getIsNfsCartaCorrecao() {
        return isNfsCartaCorrecao;
    }
    
    public ArrayList<Servico> getServicos() {
        return servicos;
    }
    
    public String getVlCofins() {
        return vlCofins;
    }
    
    public String getVlAliquotaCofins() {
        return vlAliquotaCofins;
    }
    
    public String getVlCsll() {
        return vlCsll;
    }
    
    public String getVlAliquotaCsll() {
        return vlAliquotaCsll;
    }
    
    public String getVlInss() {
        return vlInss;
    }
    
    public String getVlAliquotaInss() {
        return vlAliquotaInss;
    }
    
    public String getVlIrpj() {
        return vlIrpj;
    }
    
    public String getVlAliquotaIrpj() {
        return vlAliquotaIrpj;
    }
    
    public String getVlPis() {
        return vlPis;
    }
    
    public String getVlAliquotaPis() {
        return vlAliquotaPis;
    }
    
    public String getVlBaseCalculo() {
        return vlBaseCalculo;
    }
    
    public String getVlTotalNota() {
        return vlTotalNota;
    }
    
    public String getVlTotalDeducoes() {
        return vlTotalDeducoes;
    }
    
    public String getVlImposto() {
        return vlImposto;
    }
    
    public PrestadorServico getPrestadorServico() {
        return prestadorServico;
    }
    
    public TomadorServico getTomadorServico() {
        return tomadorServico;
    }
    
    public String getDsImpostos() {
        return dsImpostos;
    }
}
