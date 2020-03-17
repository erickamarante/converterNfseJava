package com.constanzooficial.integracao.model.nfse.go.rioVerde;

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
    @XStreamAlias("CompNfse")
    private ArrayList<CompNfse> compNfses;

    public ArrayList<CompNfse> getCompNfses() {
        return compNfses;
    }
    
}
