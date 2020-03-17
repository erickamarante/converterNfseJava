package com.constanzooficial.integracao.model.nfse.rs.bentoGoncalves;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("Tomador")
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
