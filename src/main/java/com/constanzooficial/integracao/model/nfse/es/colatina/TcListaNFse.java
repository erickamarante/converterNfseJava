package com.constanzooficial.integracao.model.nfse.es.colatina;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.ArrayList;

/**
 *
 * @author Waislan Luis Sanches
 */
@XStreamAlias("tcListaNFse")
public class TcListaNFse {
    
    @XStreamImplicit
    private ArrayList <Nfse> notasFiscais;
    
    @XStreamAlias("xmlns")
    @XStreamAsAttribute
    private String xmlns;

    public ArrayList <Nfse> getNotasFiscais() {
        return notasFiscais;
    }
      
}
