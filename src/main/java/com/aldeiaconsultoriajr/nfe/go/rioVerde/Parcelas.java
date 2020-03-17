package com.aldeiaconsultoriajr.nfe.go.rioVerde;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("Parcelas")
public class Parcelas {
    
    @XStreamAlias("Parcela")
    private String parcela;
    
    @XStreamAlias("Valor")
    private String valor;

    public String getParcela() {
        return parcela;
    }

    public String getValor() {
        return valor;
    }
    
}
