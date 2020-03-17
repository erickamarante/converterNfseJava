package com.constanzooficial.integracao.model.nfse.rs.bentoGoncalves;

import com.constanzooficial.integracao.util.MyUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.Arrays;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("InfNfse")
public class InfNfse {

    @XStreamAlias("Numero")
    private String Numero;

    @XStreamAlias("CodigoVerificacao")
    private String CodigoVerificacao;

    @XStreamAlias("DataEmissao")
    private String DataEmissao;
    
    @XStreamAlias("IdentificacaoRps")
    private String identificacaoRps;
    
    @XStreamAlias("NaturezaOperacao")
    private String naturezaOperacao;
    
    @XStreamAlias("OptanteSimplesNacional")
    private String optanteSimplesNacional;
    
    @XStreamAlias("Competencia")
    private String competencia;
    
    @XStreamAlias("Servico")
    private Servico servico;
    
    @XStreamAlias("PrestadorServico")
    private PrestadorServico prestadorServico;
    
    @XStreamAlias("TomadorServico")
    private TomadorServico tomadorServico;
    
    @XStreamAlias("IntermediarioServico")
    private String intermediarioServico;
    
    @XStreamAlias("ConstrucaoCivil")
    private String construcaoCivil;
    
    @XStreamAlias("CondicaoPagamento")
    private CondicaoPagamento condicaoPagamento;

    public String getNumero() {
        return Numero;
    }

    public String getCodigoVerificacao() {
        return CodigoVerificacao;
    }

    public String[] getDataEmissao() {
        String[] dataHora = MyUtils.trataDataHora2(DataEmissao);
        dataHora[5] = dataHora[5].split("\\.")[0];
        return dataHora;
    }

    public String getIdentificacaoRps() {
        return identificacaoRps;
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

    public String getIntermediarioServico() {
        return intermediarioServico;
    }

    public String getConstrucaoCivil() {
        return construcaoCivil;
    }

    public CondicaoPagamento getCondicaoPagamento() {
        return condicaoPagamento;
    }
}
