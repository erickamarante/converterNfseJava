package com.constanzooficial.integracao.model.nfse.rn.caico;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("Servico")
public class Servico {
    
    @XStreamAlias("Valores")
    private Valores Valores;
    
    @XStreamAlias("ItemListaServico")
    private String itemListaServico;
    
    @XStreamAlias("CodigoTributacaoMunicipio")
    private String codigoTributacaoMunicipio;
    
    @XStreamAlias("CodigoCnae")
    private String codigoCnae;
    
    @XStreamAlias("Discriminacao")
    private String discriminacao;
    
    @XStreamAlias("CodigoMunicipio")
    private String codigoMunicipio;

    public Valores getValores() {
        return Valores;
    }

    public String getItemListaServico() {
        return itemListaServico;
    }

    public String getCodigoTributacaoMunicipio() {
        return codigoTributacaoMunicipio;
    }

    public String getCodigoCnae() {
        return codigoCnae;
    }

    public String getDiscriminacao() {
        return discriminacao;
    }

    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }
}
