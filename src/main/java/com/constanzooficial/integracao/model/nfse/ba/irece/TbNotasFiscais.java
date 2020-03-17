package com.constanzooficial.integracao.model.nfse.ba.irece;

import com.constanzooficial.integracao.util.MyUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("TbNotasFiscais")
public class TbNotasFiscais {
    
    @XStreamAlias("NumeroNF")
    private String numeroNF;
    
    @XStreamAlias("DtEmissao")
    private String dataEmissao;

    @XStreamAlias("Assinatura")
    private String assinatura;

    @XStreamAlias("CNPJCPFTomador")
    private String cnpjCpfTomador;
    
    @XStreamAlias("Status")
    private String status;
    
    @XStreamAlias("ValorTotal")
    private String valorTotal;
    
    @XStreamAlias("ValorDeducao")
    private String ValorDeducao;
    
    @XStreamAlias("ImpDevido")
    private String impDevido;
    
    @XStreamAlias("ImpRetido")
    private String impRetido;
    
    @XStreamAlias("RetencaoIRRF")
    private String retencaoIRRF;
    
    @XStreamAlias("RetencaoPIS")
    private String retencaoPIS;
    
    @XStreamAlias("RetencaoCOFINS")
    private String retencaoCOFINS;
    
    @XStreamAlias("RetencaoCSLL")
    private String retencaoCSLL;
    
    @XStreamAlias("RetencaoINSS")
    private String retencaoINSS;
    
    @XStreamAlias("Observacoes")
    private String rbservacoes;
    
    @XStreamAlias("BaseCalculo")
    private String baseCalculo;
    
    @XStreamAlias("NomeRazaoTomador")
    private String nomeRazaoTomador;
    
    @XStreamAlias("MunicipioTomador")
    private String municipioTomador;

    public String getNumeroNF() {
        return numeroNF;
    }

    public String[] getDataEmissao() {
        String[] dataHora = MyUtils.trataDataHora2(dataEmissao);
        return dataHora;
    }

    public String getAssinatura() {
        return assinatura;
    }

    public String getCnpjCpfTomador() {
        return cnpjCpfTomador;
    }

    public String getStatus() {
        return status;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public String getImpDevido() {
        return impDevido;
    }

    public String getImpRetido() {
        return impRetido;
    }

    public String getRetencaoIRRF() {
        return retencaoIRRF;
    }

    public String getRetencaoPIS() {
        return retencaoPIS;
    }

    public String getRetencaoCOFINS() {
        return retencaoCOFINS;
    }

    public String getRetencaoCSLL() {
        return retencaoCSLL;
    }

    public String getRetencaoINSS() {
        return retencaoINSS;
    }

    public String getRbservacoes() {
        return rbservacoes;
    }

    public String getBaseCalculo() {
        return baseCalculo;
    }

    public String getNomeRazaoTomador() {
        return nomeRazaoTomador;
    }

    public String getMunicipioTomador() {
        return municipioTomador;
    }

    public String getValorDeducao() {
        return ValorDeducao;
    }
}
