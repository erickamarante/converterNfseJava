package com.constanzooficial.integracao.model.nfse.ba.joaoDourado;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("Tomador")
public class Tomador {
    
    @XStreamAlias("IdentificacaoTomador")
    private IdentificacaoPrestador identificacaoTomador;

    @XStreamAlias("RazaoSocial")
    private String razaoSocial;

    @XStreamAlias("Endereco")
    private Endereco endereco;
    
    @XStreamAlias("Contato")
    private Contato contato;

    public IdentificacaoPrestador getIdentificacaoTomador() {
        return identificacaoTomador;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Contato getContato() {
        return contato;
    }
}
