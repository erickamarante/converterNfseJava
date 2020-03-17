package com.aldeiaconsultoriajr.nfe.go.rioVerde;

import com.aldeiaconsultoriajr.util.MyUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("InfNfse")
public class InfNfse {

    @XStreamAlias("Numero")
    private String numero;
    @XStreamAlias("CodigoVerificacao")
    private String codigoVerificacao;
    @XStreamAlias("DataEmissao")
    private String dataEmissao;
    @XStreamAlias("IdentificacaoRps")
    private IdentificacaoRps identificacaoRps;
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
    private IntermediarioServico intermediarioServico;
    @XStreamAlias("ConstrucaoCivil")
    private ConstrucaoCivil construcaoCivil;
    @XStreamAlias("CondicaoPagamento")
    private CondicaoPagamento condicaoPagamento;

    public String getNumero() {
        return numero;
    }

    public String getCodigoVerificacao() {
        return codigoVerificacao;
    }

    public String[] getDataEmissao() {
        return MyUtils.trataDataHora(dataEmissao);
    }

    public IdentificacaoRps getIdentificacaoRps() {
        return identificacaoRps;
    }

    public String getNaturezaOperacao() {
        return naturezaOperacao;
    }

    public boolean getOptanteSimplesNacional() {
        return !"2".equals(optanteSimplesNacional);
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

    public IntermediarioServico getIntermediarioServico() {
        return intermediarioServico;
    }

    public ConstrucaoCivil getConstrucaoCivil() {
        return construcaoCivil;
    }

    public CondicaoPagamento getCondicaoPagamento() {
        return condicaoPagamento;
    }
}
