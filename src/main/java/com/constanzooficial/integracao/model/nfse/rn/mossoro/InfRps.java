package com.constanzooficial.integracao.model.nfse.rn.mossoro;

import com.constanzooficial.integracao.util.MyUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("InfRps")
public class InfRps {
    
    @XStreamAlias("Id")
    @XStreamAsAttribute
    private String id;
    
    @XStreamAlias("IdentificacaoRps")
    private IdentificacaoRps identificacaoRps;
    
    @XStreamAlias("DataEmissao")
    private String dataEmissao;
    
    @XStreamAlias("NaturezaOperacao")
    private String naturezaOperacao;
    
    @XStreamAlias("RegimeEspecialTributacao")
    private String regimeEspecialTributacao;
    
    @XStreamAlias("OptanteSimplesNacional")
    private String optanteSimplesNacional;
    
    @XStreamAlias("IncentivadorCultural")
    private String incentivadorCultural;
    
    @XStreamAlias("Status")
    private String status;
    
    @XStreamAlias("Servico")
    private Servico Servico;
    
    @XStreamAlias("Prestador")
    private Prestador Prestador;
    
    @XStreamAlias("Tomador")
    private Tomador tomador;

    public String getId() {
        return id;
    }

    public IdentificacaoRps getIdentificacaoRps() {
        return identificacaoRps;
    }

    public String[] getDataEmissao() {
        String[] dataHora = MyUtils.trataDataHora2(dataEmissao);
        return dataHora;
    }

    public String getNaturezaOperacao() {
        return naturezaOperacao;
    }

    public String getRegimeEspecialTributacao() {
        return regimeEspecialTributacao;
    }

    public String getOptanteSimplesNacional() {
        return optanteSimplesNacional;
    }

    public String getIncentivadorCultural() {
        return incentivadorCultural;
    }

    public String getStatus() {
        return status;
    }

    public Servico getServico() {
        return Servico;
    }

    public Prestador getPrestador() {
        return Prestador;
    }

    public Tomador getTomador() {
        return tomador;
    }
}
