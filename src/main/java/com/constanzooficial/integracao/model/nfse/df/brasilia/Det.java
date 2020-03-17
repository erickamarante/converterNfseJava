package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("det")
public class Det {
    
    @XStreamAlias("nItem")
    @XStreamAsAttribute
    private String nItem;
    
    @XStreamAlias("prod")
    private Produto produto;
    
    @XStreamAlias("imposto")
    private Imposto imposto;

    public String getnItem() {
        return nItem;
    }

    public Produto getProduto() {
        return produto;
    }

    public Imposto getImposto() {
        return imposto;
    }

}
