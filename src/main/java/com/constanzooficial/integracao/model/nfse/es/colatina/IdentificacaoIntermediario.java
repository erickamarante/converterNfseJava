package com.constanzooficial.integracao.model.nfse.es.colatina;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Luis Sanches
 */
@XStreamAlias("IdentificacaoIntermediario")
public class IdentificacaoIntermediario {
    
    @XStreamAlias("IndicacaoCpfCnpj")
    private String indicacaoCpfCnpj;

    public String getIndicacaoCpfCnpj() {
        return indicacaoCpfCnpj;
    }
    
}
