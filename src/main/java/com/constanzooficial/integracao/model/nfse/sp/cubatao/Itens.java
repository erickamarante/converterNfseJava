package com.constanzooficial.integracao.model.nfse.sp.cubatao;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("ITENS")
public class Itens {
    
    @XStreamAlias("Quantidade")
    private String quantidade;
    
    @XStreamAlias("CodigoAtividade")
    private String codigoAtividade;
    
    @XStreamAlias("Servico")
    private String servico;
    
    @XStreamAlias("ValorUnitario")
    private String valorUnitario;
    
    @XStreamAlias("ValorTotal")
    private String valorTotal;
    
    @XStreamAlias("ImpostoRetido")
    private String impostoRetido;
    
    @XStreamAlias("Aliquota")
    private String aliquota;

    public String getQuantidade() {
        return quantidade;
    }

    public String getCodigoAtividade() {
        return codigoAtividade;
    }

    public String getServico() {
        return servico;
    }

    public String getValorUnitario() {
        return valorUnitario;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public String getImpostoRetido() {
        return impostoRetido;
    }

    public String getAliquota() {
        return aliquota;
    }
    
}
