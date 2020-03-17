package com.aldeiaconsultoriajr.nfe.go.rioVerde;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("TomadorServico")
public class TomadorServico {

    @XStreamAlias("IdentificacaoTomador")
    private IdentificacaoTomador identificacaoTomador;
    @XStreamAlias("RazaoSocial")
    private String razaoSocial;
    @XStreamAlias("Endereco")
    private Endereco endereco;
    @XStreamAlias("Contato")
    private Contato contato;

    public IdentificacaoTomador getIdentificacaoTomador() {
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
