package com.constanzooficial.integracao.model.nfse.sc.agrolandia2;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
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
