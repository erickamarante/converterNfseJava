package com.aldeiaconsultoriajr.nfe.rs.canoas;

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

    public void setIdentificacaoPrestador(IdentificacaoPrestador identificacaoPrestador) {
        this.identificacaoPrestador = identificacaoPrestador;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }
    
}
