package com.constanzooficial.integracao.model.nfse.go.goiania;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("IdentificacaoRps")
public class IdentificacaoRps {
    
    @XStreamAlias("Numero")
    private String numero;
    
    @XStreamAlias("Serie")
    private String serie;
    
    @XStreamAlias("Tipo")
    private String tipo;

    public String getNumero() {
        return numero;
    }

    public String getSerie() {
        return serie;
    }

    public String getTipo() {
        return tipo;
    }
    
}
