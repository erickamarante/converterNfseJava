package com.constanzooficial.integracao.model.nfse.sp.barueri;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.ArrayList;

@XStreamAlias("ListaNfse")
public class ListaNfse {
    
    @XStreamImplicit
    private ArrayList<CompNfse> listaNfse;
    
    @XStreamAlias("ProximaPagina")
    private String proximaPagina;

    public ArrayList<CompNfse> getListaNfse() {
        return listaNfse;
    }

    public String getProximaPagina() {
        return proximaPagina;
    }
    
}
