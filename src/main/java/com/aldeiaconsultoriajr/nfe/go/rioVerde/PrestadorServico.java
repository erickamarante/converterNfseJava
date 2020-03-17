package com.aldeiaconsultoriajr.nfe.go.rioVerde;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("PrestadorServico")
public class PrestadorServico {

    @XStreamAlias("IdentificacaoPrestador")
    private IdentificacaoPrestador identificacaoPrestador;
    @XStreamAlias("RazaoSocial")
    private String razaoSocial;
    @XStreamAlias("NomeFantasia")
    private String nomeFantasia;
    @XStreamAlias("Endereco")
    private Endereco endereco;
    @XStreamAlias("Contato")
    private Contato contato;

    public IdentificacaoPrestador getIdentificacaoPrestador() {
        return identificacaoPrestador;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Contato getContato() {
        return contato;
    }
}
