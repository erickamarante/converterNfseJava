package com.constanzooficial.integracao.model.nfse.sp.saoPaulo.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("ChaveNFe")
public class ChaveNfe {

    @XStreamAlias("InscricaoPrestador")
    private String inscricaoPrestador;

    @XStreamAlias("NumeroNFe")
    private String numeroNFe;

    @XStreamAlias("CodigoVerificacao")
    private String codigoVerificacao;

    public String getInscricaoPrestador() {
        return inscricaoPrestador;
    }

    public String getNumeroNFe() {
        return numeroNFe;
    }

    public String getCodigoVerificacao() {
        return codigoVerificacao;
    }
}
