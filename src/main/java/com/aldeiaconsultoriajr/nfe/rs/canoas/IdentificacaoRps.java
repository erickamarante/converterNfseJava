package com.aldeiaconsultoriajr.nfe.rs.canoas;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("IdentificacaoRps")
public class IdentificacaoRps {
    
    @XStreamAlias("Numero")
    private String Numero;
    @XStreamAlias("Serie")
    private String Serie;
    @XStreamAlias("Tipo")
    private String Tipo;

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public String getSerie() {
        return Serie;
    }

    public void setSerie(String Serie) {
        this.Serie = Serie;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
}
