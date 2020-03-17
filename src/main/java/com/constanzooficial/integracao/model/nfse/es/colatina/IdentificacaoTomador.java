package com.constanzooficial.integracao.model.nfse.es.colatina;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Luis Sanches
 */
@XStreamAlias("IdentificacaoTomador")
public class IdentificacaoTomador {
    
    @XStreamAlias("CpfCnpj")
    private String cpfCnpj;
    
    @XStreamAlias("IndicacaoCpfCnpj")
    private String indicacaoCpfCnpj;

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getIdentificacaoCpfCnpj() {
        return indicacaoCpfCnpj;
    }
    
}
