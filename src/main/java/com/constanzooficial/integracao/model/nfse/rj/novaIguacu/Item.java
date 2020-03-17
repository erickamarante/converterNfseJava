package com.constanzooficial.integracao.model.nfse.rj.novaIguacu;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("ITEM")
public class Item {

    @XStreamAlias("TRIBUTAVEL")
    private String tributavel;

    @XStreamAlias("DESCRICAO")
    private String descricao;

    @XStreamAlias("QUANTIDADE")
    private String quantidade;

    @XStreamAlias("VALOR_UNITARIO")
    private String valorUnitario;

    @XStreamAlias("VALOR_TOTAL")
    private String valorTotal;

    @XStreamAlias("DEDUCAO")
    private String deducao;

    @XStreamAlias("VALOR_ISS_UNITARIO")
    private String valorIssUnitario;

    public String getTributavel() {
        return tributavel;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public String getValorUnitario() {
        return valorUnitario;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public String getDeducao() {
        return deducao;
    }

    public String getValorIssUnitario() {
        return valorIssUnitario;
    }
}
