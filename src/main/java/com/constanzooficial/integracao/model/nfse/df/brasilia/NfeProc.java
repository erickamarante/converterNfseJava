package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("nfeProc")
public class NfeProc {
    
    @XStreamAlias("versao")
    @XStreamAsAttribute
    private String versao;
    
    @XStreamAlias("xmlns")
    @XStreamAsAttribute
    private String xmlns;
    
    @XStreamAlias("NFe")
    private NFe nfe;
    
    @XStreamAlias("protNFe")
    private ProtNFe protNfe;
    
    @XStreamAlias("evento")
    private Evento evento;
    
    @XStreamAlias("retEvento")
    private RetEvento retEvento;

    public String getVersao() {
        return versao;
    }

    public String getXmlns() {
        return xmlns;
    }

    public NFe getNfe() {
        return nfe;
    }

    public ProtNFe getProtNfe() {
        return protNfe;
    }

    public Evento getEvento() {
        return evento;
    }

    public RetEvento getRetEvento() {
        return retEvento;
    }
 
}
