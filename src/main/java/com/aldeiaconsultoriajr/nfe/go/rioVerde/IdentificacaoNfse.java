package com.aldeiaconsultoriajr.nfe.go.rioVerde;

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
    private String InscricaoMunicipal;
    
    @XStreamAlias("CodigoMunicipio")
    private String CodigoMunicipio;

    public String getNumero() {
        return numero;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getInscricaoMunicipal() {
        return InscricaoMunicipal;
    }

    public String getCodigoMunicipio() {
        return CodigoMunicipio;
    }
}
