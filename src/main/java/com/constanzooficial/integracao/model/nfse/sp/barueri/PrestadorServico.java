package com.constanzooficial.integracao.model.nfse.sp.barueri;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("PrestadorServico")
public class PrestadorServico {

    @XStreamAlias("IdentificacaoPrestador")
    private IdentificacaoPrestador IdentificacaoPrestador;

    @XStreamAlias("RazaoSocial")
    private String RazaoSocial;

    @XStreamAlias("Endereco")
    private Endereco Endereco;

    @XStreamAlias("Contato")
    private Contato Contato;

    public IdentificacaoPrestador getIdentificacaoPrestador() {
        return IdentificacaoPrestador;
    }

    public String getRazaoSocial() {
        return RazaoSocial;
    }

    public Endereco getEndereco() {
        return Endereco;
    }

    public Contato getContato() {
        return Contato;
    }
}
