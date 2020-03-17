package com.aldeiaconsultoriajr.nfe.sc.agrolandia;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("prestador")
public class Prestador {

    @XStreamAlias("cpfcnpj")
    private String cpfCnpj;

    @XStreamAlias("cidade")
    private String cidade;

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getCidade() {
        return cidade;
    }
}
