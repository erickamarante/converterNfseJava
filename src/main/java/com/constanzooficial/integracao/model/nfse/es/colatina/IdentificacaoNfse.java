package com.constanzooficial.integracao.model.nfse.es.colatina;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Luis Sanches
 */
@XStreamAlias("IdentificacaoNfse")
public class IdentificacaoNfse {
    
    @XStreamAlias("Numero")
    private String numero;
    
    @XStreamAlias("NumeroRps")
    private String numeroRps;
    
    @XStreamAlias("Serie")
    private String serie;
    
    @XStreamAlias("Tipo")
    private String tipo;

    public String getNumero() {
        return numero;
    }

    public String getNumeroRps() {
        return numeroRps;
    }

    public String getSerie() {
        return serie;
    }

    public String getTipo() {
        return tipo;
    }
    
}
