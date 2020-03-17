package com.aldeiaconsultoriajr.nfe.ba.salvador;

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
    @XStreamAlias("CodigoCnae")
    private String codigoCnae;
    @XStreamAlias("CodigoTributacaoMunicipio")
    private String codigoTributacaoMunicipio;
    @XStreamAlias("Discriminacao")
    private String discriminacao;

    public Valores getValores() {
        return valores;
    }

    public String getItemListaServico() {
        return itemListaServico;
    }

    public String getCodigoCnae() {
        return codigoCnae;
    }

    public String getCodigoTributacaoMunicipio() {
        return codigoTributacaoMunicipio;
    }

    public String getDiscriminacao() {
        return discriminacao;
    }
}
