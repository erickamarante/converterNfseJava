package com.aldeiaconsultoriajr.nfe.es.vilaVelha;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.ArrayList;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("ListaNfse")
public class ListaNfse {
    
    @XStreamAlias("CompNfse")
    @XStreamImplicit
    private ArrayList<CompNfse> compNfse;
    
    @XStreamAlias("ProximaPagina")
    private String proximaPagina;

    public ArrayList<CompNfse> getCompNfse() {
        return compNfse;
    }

    public String getProximaPagina() {
        return proximaPagina;
    }
}
