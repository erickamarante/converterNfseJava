package com.constanzooficial.integracao.model.nfse.rn.mossoro;

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
    private Endereco Endereco;
    
    @XStreamAlias("Contato")
    private Contato contato;

    public IdentificacaoTomador getIdentificacaoTomador() {
        return identificacaoTomador;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public Endereco getEndereco() {
        return Endereco;
    }

    public Contato getContato() {
        return contato;
    }
}
