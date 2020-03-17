package com.constanzooficial.integracao.model.nfse.sp.barueri;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("IdentificacaoTomador")
public class IdentificacaoTomador {

    @XStreamAlias("CpfCnpj")
    private CpfCnpj cpfCnpj;

    public CpfCnpj getCpfCnpj() {
        return cpfCnpj;
    }
}
