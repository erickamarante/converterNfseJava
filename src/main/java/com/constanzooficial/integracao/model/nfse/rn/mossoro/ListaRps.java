package com.constanzooficial.integracao.model.nfse.rn.mossoro;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.ArrayList;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("ListaRps")
public class ListaRps {
    
    @XStreamImplicit
    private ArrayList<Rps> listaRps;

    public ArrayList<Rps> getListaRps() {
        return listaRps;
    }
}
