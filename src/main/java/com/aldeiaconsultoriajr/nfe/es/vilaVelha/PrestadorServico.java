package com.aldeiaconsultoriajr.nfe.es.vilaVelha;

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
    @XStreamAlias("Endereco")
    private Endereco endereco;
    @XStreamAlias("Contato")
    private Contato contato;

    public IdentificacaoPrestador getIdentificacaoPrestador() {
        return identificacaoPrestador;
    }

    public String getRazaoSocial() {
        if (razaoSocial != null) {
            return razaoSocial.trim();
        } else {
            return null;
        }
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Contato getContato() {
        return contato;
    }
}
