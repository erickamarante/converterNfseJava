package com.constanzooficial.integracao.model.nfse.go.rioVerde;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("IdentificacaoTomador")
public class IdentificacaoTomador {
    
    @XStreamAlias("CpfCnpj")
    private CpfCnpj cpfCnpj;
    
    @XStreamAlias("Endereco")
    private Endereco endereco;

    public CpfCnpj getCpfCnpj() {
        return cpfCnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }   
       
}
