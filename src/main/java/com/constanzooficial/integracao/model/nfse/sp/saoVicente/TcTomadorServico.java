package com.constanzooficial.integracao.model.nfse.sp.saoVicente;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("tc:TomadorServico")
public class TcTomadorServico {

    @XStreamAlias("tc:IdentificacaoTomador")
    private TcIdentificacaoTomador tcIdentificacaoTomador;

    @XStreamAlias("tc:RazaoSocial")
    private String tcRazaoSocial;

    @XStreamAlias("tc:Endereco")
    private TcEndereco tcEndereco;

    @XStreamAlias("tc:Contato")
    private TcContato tcContato;

    public TcIdentificacaoTomador getTcIdentificacaoTomador() {
        return tcIdentificacaoTomador;
    }

    public String getTcRazaoSocial() {
        return tcRazaoSocial;
    }

    public TcEndereco getTcEndereco() {
        return tcEndereco;
    }

    public TcContato getTcContato() {
        return tcContato;
    }
}
