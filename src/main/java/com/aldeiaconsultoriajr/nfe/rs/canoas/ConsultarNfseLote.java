package com.aldeiaconsultoriajr.nfe.rs.canoas;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.ArrayList;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("ConsultarNfseLote")
public class ConsultarNfseLote {
    
    @XStreamAlias("ListaNfse")
    private ArrayList<CompNfse> listaNfse;

    public ArrayList<CompNfse> getListaNfse() {
        return listaNfse;
    }

    public void setListaNfse(ArrayList<CompNfse> listaNfse) {
        this.listaNfse = listaNfse;
    }

}
