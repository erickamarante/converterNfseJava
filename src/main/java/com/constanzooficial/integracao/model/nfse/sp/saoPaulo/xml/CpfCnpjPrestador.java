package com.constanzooficial.integracao.model.nfse.sp.saoPaulo.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("CPFCNPJPrestador")
public class CpfCnpjPrestador {

    @XStreamAlias("CPF")
    private String cpf;

    @XStreamAlias("CNPJ")
    private String cnpj;

    public String getCpf() {
        return cpf;
    }

    public String getCnpj() {
        return cnpj;
    }
}
