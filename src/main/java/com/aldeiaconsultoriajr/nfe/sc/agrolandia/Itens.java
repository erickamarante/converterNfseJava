package com.aldeiaconsultoriajr.nfe.sc.agrolandia;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("itens")
public class Itens {
    
    @XStreamAlias("lista")
    private Lista lista;

    public Lista getLista() {
        return lista;
    }
}
