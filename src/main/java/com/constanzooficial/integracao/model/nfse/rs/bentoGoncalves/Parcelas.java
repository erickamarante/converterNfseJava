package com.constanzooficial.integracao.model.nfse.rs.bentoGoncalves;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("Parcelas")
public class Parcelas {
    
    @XStreamAlias("Parcela")
    private String parcela;
    
    @XStreamAlias("DataVencimento")
    private String dataVencimento;
    
    @XStreamAlias("Valor")
    private String valor;

    public String getParcela() {
        return parcela;
    }

    public String getValor() {
        return valor;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }
    
}
