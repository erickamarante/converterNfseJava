package com.constanzooficial.integracao.model.nfse.sp.barueri;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
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
