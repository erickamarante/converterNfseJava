package com.constanzooficial.integracao.model.nfse.ba.irece;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.ArrayList;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("DsExportarNotaFiscal")
public class DsExportarNotaFiscal {
    
    @XStreamAlias("xmlns")
    @XStreamAsAttribute
    private String xmlns;
    
    @XStreamImplicit
    private ArrayList<TbNotasFiscais> tbNotasFiscais;

    public String getXmlns() {
        return xmlns;
    }

    public ArrayList<TbNotasFiscais> getTbNotasFiscais() {
        return tbNotasFiscais;
    }
}
