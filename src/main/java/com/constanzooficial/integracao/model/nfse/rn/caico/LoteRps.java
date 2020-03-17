package com.constanzooficial.integracao.model.nfse.rn.caico;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("LoteRps")
public class LoteRps {
    
    @XStreamAlias("Id")
    @XStreamAsAttribute
    private String id;
    
    @XStreamAlias("NumeroLote")
    private String NumeroLote;
    
    @XStreamAlias("Cnpj")
    private String cnpj;
    
    @XStreamAlias("InscricaoMunicipal")
    private String inscricaoMunicipal;
    
    @XStreamAlias("QuantidadeRps")
    private String quantidadeRps;
    
    @XStreamAlias("ListaRps")
    private ListaRps listaRps;

    public String getId() {
        return id;
    }

    public String getNumeroLote() {
        return NumeroLote;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public String getQuantidadeRps() {
        return quantidadeRps;
    }

    public ListaRps getListaRps() {
        return listaRps;
    }
    
}
