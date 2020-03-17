package com.aldeiaconsultoriajr.nfe.go.rioVerde;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("CondicaoPagamento")
public class CondicaoPagamento {
    
    @XStreamAlias("Condicao")
    private String condicao;
    
    @XStreamAlias("QtdParcela")
    private String qtdParcela;
    
    @XStreamAlias("Parcelas")
    private Parcelas parcelas;

    public String getCondicao() {
        return condicao;
    }

    public String getQtdParcela() {
        return qtdParcela;
    }

    public Parcelas getParcelas() {
        return parcelas;
    }
}
