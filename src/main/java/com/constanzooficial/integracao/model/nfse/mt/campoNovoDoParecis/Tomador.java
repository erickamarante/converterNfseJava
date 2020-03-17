package com.constanzooficial.integracao.model.nfse.mt.campoNovoDoParecis;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("Tomador")
public class Tomador {

    @XStreamAlias("IdentificacaoTomador")
    private IdentificacaoPrestador identificacaoTomador;
    
    @XStreamAlias("RazaoSocial")
    private String razaoSocial;

    @XStreamAlias("Endereco")
    private Endereco endereco;
    
    @XStreamAlias("Contato")
    private Contato contato;

    public IdentificacaoPrestador getIdentificacaoTomador() {
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
