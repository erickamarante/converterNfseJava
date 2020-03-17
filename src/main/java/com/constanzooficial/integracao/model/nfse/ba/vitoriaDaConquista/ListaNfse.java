package com.constanzooficial.integracao.model.nfse.ba.vitoriaDaConquista;

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
    private ArrayList<CompNfse> listaNfse;

    public ArrayList<CompNfse> getListaNfse() {
        return listaNfse;
    }
    
}
