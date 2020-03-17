package com.constanzooficial.integracao.model.nfse.ba.vitoriaDaConquista;

import com.constanzooficial.integracao.util.MyUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("InfNfse")
public class InfNfse {

    @XStreamAlias("Id")
    @XStreamAsAttribute
    private String id;
    
    @XStreamAlias("Numero")
    private String Numero;

    @XStreamAlias("CodigoVerificacao")
    private String CodigoVerificacao;

    @XStreamAlias("DataEmissao")
    private String DataEmissao;
    
    @XStreamAlias("NaturezaOperacao")
    private String naturezaOperacao;
    
    @XStreamAlias("OptanteSimplesNacional")
    private String optanteSimplesNacional;
    
    @XStreamAlias("IncentivadorCultural")
    private String incentivadorCultural;
    
    @XStreamAlias("Competencia")
    private String competencia;
    
    @XStreamAlias("OutrasInformacoes")
    private String outrasInformacoes;
    
    @XStreamAlias("Servico")
    private Servico servico;
    
    @XStreamAlias("PrestadorServico")
    private PrestadorServico prestadorServico;
    
    @XStreamAlias("TomadorServico")
    private TomadorServico tomadorServico;
    
    @XStreamAlias("OrgaoGerador")
    private OrgaoGerador orgaoGerador;

    public String getNumero() {
        return Numero.substring(7, 15);
    }

    public String getCodigoVerificacao() {
        return CodigoVerificacao;
    }

    public String[] getDataEmissao() {
        String[] dataHora = MyUtils.trataDataHora2(DataEmissao);
        return dataHora;
    }

    public String getNaturezaOperacao() {
        return naturezaOperacao;
    }

    public boolean getOptanteSimplesNacional() {
        return optanteSimplesNacional.equals("1");
    }

    public String getCompetencia() {
        return competencia;
    }

    public Servico getServico() {
        return servico;
    }

    public PrestadorServico getPrestadorServico() {
        return prestadorServico;
    }

    public TomadorServico getTomadorServico() {
        return tomadorServico;
    }

    public String getId() {
        return id;
    }

    public String getOutrasInformacoes() {
        return outrasInformacoes;
    }

    public OrgaoGerador getOrgaoGerador() {
        return orgaoGerador;
    }

}
