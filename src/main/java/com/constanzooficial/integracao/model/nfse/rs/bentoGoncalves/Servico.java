package com.constanzooficial.integracao.model.nfse.rs.bentoGoncalves;

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
}
