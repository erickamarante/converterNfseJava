package com.aldeiaconsultoriajr.nfe.sc.agrolandia;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("nfse")
public class Nfse {
    
    @XStreamAlias("nf")
    private Nf nf;
    
    @XStreamAlias("prestador")
    private Prestador prestador;
    
    @XStreamAlias("tomador")
    private Tomador tomador;
    
    @XStreamAlias("itens")
    private Itens itens;

    public Nf getNf() {
        return nf;
    }

    public Prestador getPrestador() {
        return prestador;
    }

    public Tomador getTomador() {
        return tomador;
    }

    public Itens getItens() {
        return itens;
    }
}
