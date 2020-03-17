package com.aldeiaconsultoriajr.nfe.es.vilaVelha;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import java.util.ArrayList;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("ConsultarNfseFaixaResposta")
public class ConsultarNfseFaixaResposta {
    
    @XStreamAlias("xmlns:xs")
    @XStreamAsAttribute
    private String xmlnsxs;
    
    @XStreamAsAttribute
    private String xmlns;
    
    /*
    @XStreamAlias("ListaNfse")
    private ArrayList<CompNfse> listaNfse;
    */

    @XStreamAlias("ListaNfse")
    private ListaNfse listaNfse;
    
    public String getXmlnsxs() {
        return xmlnsxs;
    }

    public String getXmlns() {
        return xmlns;
    }

    public ListaNfse getListaNfse() {
        return listaNfse;
    }
}
