package com.constanzooficial.integracao.model.nfse.go.goiania;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("CpfCnpj")
public class CpfCnpj {
    
    @XStreamAlias("Cnpj")
    private String cnpj;
    
    @XStreamAlias("Cpf")
    private String cpf;

    public String getCnpj() {
        return cnpj;
    }

    public String getCpf() {
        return cpf;
    }
    
}
