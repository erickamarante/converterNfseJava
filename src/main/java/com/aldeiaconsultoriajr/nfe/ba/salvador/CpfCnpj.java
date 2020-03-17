package com.aldeiaconsultoriajr.nfe.ba.salvador;

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
        if (cpf != null) {
            return cpf.replace(".", "").replace("-", "");
        } else {
            return null;
        }
    }

    public String getCnpj() {
        if (cnpj != null) {
            return cnpj.replace(".", "").replace("/", "").replaceAll("-", "");
        } else {
            return null;
        }
    }
}
