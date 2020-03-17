package com.constanzooficial.integracao.model.nfse.rs.bentoGolcalves2;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.ArrayList;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("itens")
public class Itens {
    
    @XStreamImplicit
    @XStreamAlias("lista")
    private ArrayList<Lista> lista;

    public ArrayList<Lista> getLista() {
        return lista;
    }
    
}
