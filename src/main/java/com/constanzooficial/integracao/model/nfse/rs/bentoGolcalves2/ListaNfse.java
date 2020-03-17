package com.constanzooficial.integracao.model.nfse.rs.bentoGolcalves2;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.ArrayList;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("listaNfse")
public class ListaNfse {
    
    @XStreamImplicit
    private ArrayList<Nfse> nfses;

    public ArrayList<Nfse> getNfses() {
        return nfses;
    }
}
