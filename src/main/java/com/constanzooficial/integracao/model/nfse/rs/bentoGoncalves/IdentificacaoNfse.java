package com.constanzooficial.integracao.model.nfse.rs.bentoGoncalves;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("IdentificacaoNfse")
public class IdentificacaoNfse {
    
    @XStreamAlias("Numero")
    private String numero;
    @XStreamAlias("Cnpj")
    private String cnpj;
    @XStreamAlias("InscricaoMunicipal")
    private String inscricaoMunicipal;
    @XStreamAlias("CodigoMunicipio")
    private String codigoMunicipio;

    public String getNumero() {
        return numero;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }
}
