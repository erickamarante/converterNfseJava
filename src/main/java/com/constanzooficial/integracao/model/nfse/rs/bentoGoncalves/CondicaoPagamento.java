package com.constanzooficial.integracao.model.nfse.rs.bentoGoncalves;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.ArrayList;

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
    
    @XStreamImplicit
    @XStreamAlias("Parcelas")
    private ArrayList<Parcelas> parcelas;

    public String getCondicao() {
        return condicao;
    }

    public String getQtdParcela() {
        return qtdParcela;
    }

    public ArrayList<Parcelas> getParcelas() {
        return parcelas;
    }
}
