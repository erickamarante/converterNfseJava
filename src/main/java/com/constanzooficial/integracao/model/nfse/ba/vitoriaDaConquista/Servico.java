package com.constanzooficial.integracao.model.nfse.ba.vitoriaDaConquista;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
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
    
    @XStreamAlias("CodigoMunicipio")
    private String codigoMunicipio;

    public Valores getValores() {
        return valores;
    }

    public String getItemListaServico() {
        if (itemListaServico != null) {
            return itemListaServico.replace(".", "");
        } else {
            return null;
        }
    }

    public String getDiscriminacao() {
        return discriminacao;
    }

    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public String getCodigoCnae() {
        return codigoCnae;
    }

    public String getCodigoTributacaoMunicipio() {
        return codigoTributacaoMunicipio;
    }
}
