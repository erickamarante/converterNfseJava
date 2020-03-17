package com.aldeiaconsultoriajr.nfe.go.rioVerde;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import java.util.ArrayList;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("ConsultarNfseResposta")
public class ConsultarNfseResposta {

    @XStreamAlias("xmlns:ns2")
    @XStreamAsAttribute
    private String xmlnsns2;

    @XStreamAlias("ListaNfse")
    private ArrayList<ComplNfse> listaNfse;

    @XStreamAlias("ListaMensagemRetorno")
    private String ListaMensagemRetorno;

    public String getXmlnsns2() {
        return xmlnsns2;
    }

    public ArrayList<ComplNfse> getListaNfse() {
        return listaNfse;
    }

    public String getListaMensagemRetorno() {
        return ListaMensagemRetorno;
    }
}
