package com.constanzooficial.integracao.model.nfse.rn.caico;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("CpfCnpj")
public class CpfCnpj {
    
    @XStreamAlias("Cpf")
    private String cpf;
    
    @XStreamAlias("Cnpj")
    private String cnpj;

    public String getCpf() {
        return cpf;
    }

    public String getCnpj() {
        return cnpj;
    }
}
