package com.constanzooficial.integracao.model.nfse.ba.joaoDourado;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("PrestadorServico")
public class PrestadorServico {

    @XStreamAlias("IdentificacaoPrestador")
    private IdentificacaoPrestador IdentificacaoPrestador;

    @XStreamAlias("RazaoSocial")
    private String RazaoSocial;
    
    @XStreamAlias("NomeFantasia")
    private String nomeFantasia;

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

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public Endereco getEndereco() {
        return Endereco;
    }

    public Contato getContato() {
        return Contato;
    }
}
