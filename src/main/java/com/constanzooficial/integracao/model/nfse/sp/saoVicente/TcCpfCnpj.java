package com.constanzooficial.integracao.model.nfse.sp.saoVicente;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("tc:CpfCnpj")
public class TcCpfCnpj {

    @XStreamAlias("tc:Cpf")
    private String tcCpf;

    @XStreamAlias("tc:Cnpj")
    private String tcCnpj;

    public String getTcCpf() {
        return tcCpf;
    }

    public String getTcCnpj() {
        return tcCnpj;
    }
}
