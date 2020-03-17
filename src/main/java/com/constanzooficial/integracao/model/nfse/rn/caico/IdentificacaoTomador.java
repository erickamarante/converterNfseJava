package com.constanzooficial.integracao.model.nfse.rn.caico;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("IdentificacaoTomador")
public class IdentificacaoTomador {
    
    @XStreamAlias("CpfCnpj")
    private CpfCnpj CpfCnpj;

    public CpfCnpj getCpfCnpj() {
        return CpfCnpj;
    }
}
