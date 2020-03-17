package com.constanzooficial.integracao.model.nfse.sp.cubatao;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.ArrayList;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("tbnfd")
public class Tbnfd {
    
    @XStreamImplicit
    @XStreamAlias("nfdok")
    private ArrayList<Nfdok> nfdoks;

    public ArrayList<Nfdok> getNfdoks() {
        return nfdoks;
    }
    
}
