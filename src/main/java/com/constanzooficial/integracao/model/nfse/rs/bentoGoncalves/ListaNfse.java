package com.constanzooficial.integracao.model.nfse.rs.bentoGoncalves;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.ArrayList;

@XStreamAlias("ListaNfse")
public class ListaNfse {
    
    @XStreamImplicit
    private ArrayList<CompNfse> listaNfse;
    
    @XStreamAlias("ListaMensagemRetorno")
    private String listaMensagemRetorno;

    public ArrayList<CompNfse> getListaNfse() {
        return listaNfse;
    }

    public String getListaMensagemRetorno() {
        return listaMensagemRetorno;
    }
    
}
