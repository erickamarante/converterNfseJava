package com.constanzooficial.integracao.model.nfse.sp.saoPaulo.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("ChaveRPS")
public class ChaveRPS {
    
    @XStreamAlias("InscricaoPrestador")
    private String inscricaoPrestador;
    
    @XStreamAlias("SerieRPS")
    private String serieRPS;
    
    @XStreamAlias("NumeroRPS")
    private String numeroRPS;

    public String getInscricaoPrestador() {
        return inscricaoPrestador;
    }

    public String getSerieRPS() {
        return serieRPS;
    }

    public String getNumeroRPS() {
        return numeroRPS;
    }
}
