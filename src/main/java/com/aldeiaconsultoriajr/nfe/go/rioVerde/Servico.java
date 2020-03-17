package com.aldeiaconsultoriajr.nfe.go.rioVerde;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("Servico")
public class Servico {

    @XStreamAlias("Valores")
    private Valores valores;
    @XStreamAlias("ItemListaServico")
    private String itemListaServico;
    @XStreamAlias("Discriminacao")
    private String discriminacao;
    @XStreamAlias("CodigoMunicipio")
    private String codigoMunicipio;

    public Valores getValores() {
        return valores;
    }

    public String getItemListaServico() {
        return itemListaServico;
    }

    public String getDiscriminacao() {
        return discriminacao;
    }

    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }
}
