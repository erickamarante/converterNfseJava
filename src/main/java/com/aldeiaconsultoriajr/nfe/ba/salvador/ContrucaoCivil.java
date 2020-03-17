package com.aldeiaconsultoriajr.nfe.ba.salvador;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("ContrucaoCivil")
class ContrucaoCivil {
    
    @XStreamAlias("CodigoObra")
    private String codigoObra;
    @XStreamAlias("Art")
    private String art;

    public String getCodigoObra() {
        return codigoObra;
    }

    public String getArt() {
        return art;
    }
}
