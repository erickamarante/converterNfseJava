package com.constanzooficial.integracao.model.nfse.pi.saoRaimundoNonato;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.ArrayList;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("table")
public class Table {
    
    @XStreamImplicit
    private ArrayList<Nfse> nfses;

    public ArrayList<Nfse> getNfses() {
        return nfses;
    }
    
}
