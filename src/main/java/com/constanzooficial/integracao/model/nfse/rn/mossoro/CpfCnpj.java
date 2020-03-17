package com.constanzooficial.integracao.model.nfse.rn.mossoro;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("CpfCnpj")
public class CpfCnpj {
    
    @XStreamAlias("Cpf")
    private String cpf;

    public String getCpf() {
        return cpf;
    }
}
