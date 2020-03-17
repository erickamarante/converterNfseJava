package com.constanzooficial.integracao.model.nfse.go.rioVerde;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("Tomador")
public class Tomador {
    
    @XStreamAlias("IdentificacaoTomador")
    private IdentificacaoTomador identificacaoTomador;
    
    @XStreamAlias("RazaoSocial")
    private String razaoSocial;
    
    @XStreamAlias("Endereco")
    private Endereco endereco;

    public IdentificacaoTomador getIdentificacaoTomador() {
        return identificacaoTomador;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public Endereco getEndereco() {
        return endereco;
    } 
       
}
