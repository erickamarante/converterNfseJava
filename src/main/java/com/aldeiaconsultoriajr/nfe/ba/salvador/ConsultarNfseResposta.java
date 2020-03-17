package com.aldeiaconsultoriajr.nfe.ba.salvador;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import java.util.ArrayList;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("ConsultarNfseResposta")
public class ConsultarNfseResposta {
    
    @XStreamAlias("xmlns:xsd")
    @XStreamAsAttribute
    private String xmlnsxsd;
    
    @XStreamAlias("xmlns:xsi")
    @XStreamAsAttribute
    private String xmlnsxsi;
    
    @XStreamAlias("xmlns")
    @XStreamAsAttribute
    private String xmlns;
    
    @XStreamAlias("ListaNfse")
    private ArrayList<CompNfse> listaNfse;

    public String getXmlnsxsd() {
        return xmlnsxsd;
    }

    public String getXmlnsxsi() {
        return xmlnsxsi;
    }

    public String getXmlns() {
        return xmlns;
    }

    public ArrayList<CompNfse> getListaNfse() {
        return listaNfse;
    }
}
