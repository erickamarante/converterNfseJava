package com.aldeiaconsultoriajr.nfe.es.vilaVelha;

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
