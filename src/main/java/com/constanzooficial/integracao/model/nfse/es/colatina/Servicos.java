package com.constanzooficial.integracao.model.nfse.es.colatina;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Luis Sanches
 */
@XStreamAlias("Servicos")
public class Servicos {

    @XStreamAlias("CodigoServico116")
    private String codigoServico116;

    @XStreamAlias("CodigoServicoMunicipal")
    private String codigoServicoMunicipal;

    @XStreamAlias("Quantidade")
    private String quantidade;

    @XStreamAlias("Unidade")
    private String unidade;

    @XStreamAlias("Descricao")
    private String descricao;

    @XStreamAlias("Aliquota")
    private String aliquota;

    @XStreamAlias("ValorServico")
    private String valorServico;

    @XStreamAlias("ValorIssqn")
    private String valorIssqn;

    @XStreamAlias("ValorDesconto")
    private String valorDesconto;

    @XStreamAlias("NumeroAlvara")
    private String numeroAlvara;
    
    @XStreamAlias("NumeroCei")
    private String numeroCei;
    
    @XStreamAlias("NumeroArt")
    private String numeroArt;

    public String getCodigoServico116() {
        if (codigoServico116 == null) {
            return "";
        }
        return codigoServico116;
    }

    public String getCodigoServicoMunicipal() {
        return codigoServicoMunicipal;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public String getUnidade() {
        return unidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getAliquota() {
        return aliquota;
    }

    public String getValorServico() {
        return valorServico;
    }

    public String getValorIssqn() {
        return valorIssqn;
    }

    public String getValorDesconto() {
        return valorDesconto;
    }

    public String getNumeroAlvara() {
        return numeroAlvara;
    }

    public String getNumeroCei() {
        return numeroCei;
    }

    public String getNumeroArt() {
        return numeroArt;
    }

}
