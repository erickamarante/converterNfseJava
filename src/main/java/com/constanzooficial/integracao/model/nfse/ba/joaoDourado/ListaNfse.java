package com.constanzooficial.integracao.model.nfse.ba.joaoDourado;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.ArrayList;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("ListaNfse")
public class ListaNfse {
    
    @XStreamImplicit
    private ArrayList<CompNfse> compNfse;
    
    @XStreamAlias("ProximaPagina")
    private String proximaPagina;

    public ArrayList<CompNfse> getListaNfse() {
        return getCompNfse();
    }

    public ArrayList<CompNfse> getCompNfse() {
        return compNfse;
    }

    public String getProximaPagina() {
        return proximaPagina;
    }
    
}
