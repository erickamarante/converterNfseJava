package com.constanzooficial.integracao.model.nfse.ba.vitoriaDaConquista;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("IdentificacaoPrestador")
public class IdentificacaoPrestador {

    @XStreamAlias("Cnpj")
    private String cnpj;

    @XStreamAlias("InscricaoMunicipal")
    private String InscricaoMunicipal;

    public String getCnpj() {
        return cnpj;
    }

    public String getInscricaoMunicipal() {
        return InscricaoMunicipal;
    }
}
