package com.constanzooficial.integracao.model.nfse.sp.saoVicente;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("tc:PrestadorServico")
public class TcPrestadorServico {

    @XStreamAlias("tc:IdentificacaoPrestador")
    private TcIdentificacaoPrestador tcIdentificacaoPrestador;

    @XStreamAlias("tc:RazaoSocial")
    private String tcRazaoSocial;

    @XStreamAlias("tc:NomeFantasia")
    private String tcNomeFantasia;

    @XStreamAlias("tc:Endereco")
    private TcEndereco tcEndereco;

    @XStreamAlias("tc:Contato")
    private TcContato tcContato;

    public TcIdentificacaoPrestador getTcIdentificacaoPrestador() {
        return tcIdentificacaoPrestador;
    }

    public String getTcRazaoSocial() {
        return tcRazaoSocial;
    }

    public String getTcNomeFantasia() {
        return tcNomeFantasia;
    }

    public TcEndereco getTcEndereco() {
        return tcEndereco;
    }

    public TcContato getTcContato() {
        return tcContato;
    }
}
