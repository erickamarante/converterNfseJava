package com.aldeiaconsultoriajr.nfe.es.vilaVelha;

import com.aldeiaconsultoriajr.util.MyUtils;
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
        return MyUtils.trataCpf(cpf);
    }

    public String getCnpj() {
        return MyUtils.trataCnpj(cnpj);
    }
}
