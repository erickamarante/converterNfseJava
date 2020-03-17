package com.constanzooficial.integracao.model.nfse.sp.bauru;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("CPFCNPJPrestador")
public class CPFCNPJPrestador {
    @XStreamAlias("CNPJ")
    private String cnpj;
    
    @XStreamAlias("CPF")
    private String cpf;

    public String getCnpj() {
        return cnpj;
    }

    public String getCpf() {
        return cpf;
    }
}
