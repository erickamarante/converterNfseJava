/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.constanzooficial.integracao.model.nfse.es.colatina;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author waislan
 */
@XStreamAlias("DadosTomador")
public class DadosTomador {
    
    @XStreamAlias("IdentificacaoTomador")
    private IdentificacaoTomador identificacaoTomador;
    
    @XStreamAlias("RazaoSocial")
    private String razaoSocial;
    
    @XStreamAlias("NomeFantasia")
    private String nomeFantasia;
    
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
