package com.constanzooficial.integracao.model.nfse.sp.cubatao;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("nfdok")
public class Nfdok {
    
    @XStreamAlias("numeronfd")
    @XStreamAsAttribute
    private String numeroNfd;
    
    @XStreamAlias("NewDataSet")
    private NewDataSet newDataSet;

    public String getNumeroNfd() {
        return numeroNfd;
    }

    public NewDataSet getNewDataSet() {
        return newDataSet;
    }
    
}
