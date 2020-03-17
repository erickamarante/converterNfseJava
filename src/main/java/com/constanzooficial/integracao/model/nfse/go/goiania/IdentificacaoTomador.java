package com.constanzooficial.integracao.model.nfse.go.goiania;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("IdentificacaoTomador")
public class IdentificacaoTomador {
    
    @XStreamAlias("CpfCnpj")
    private CpfCnpj cpfCnpj;

    public CpfCnpj getCpfCnpj() {
        return cpfCnpj;
    }
    
}
