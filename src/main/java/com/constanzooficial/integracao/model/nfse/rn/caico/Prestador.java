package com.constanzooficial.integracao.model.nfse.rn.caico;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("Prestador")
public class Prestador {
    
    @XStreamAlias("Cnpj")
    private String cnpj;
    
    @XStreamAlias("InscricaoMunicipal")
    private String inscricaoMunicipal;

    public String getCnpj() {
        return cnpj;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }
}
