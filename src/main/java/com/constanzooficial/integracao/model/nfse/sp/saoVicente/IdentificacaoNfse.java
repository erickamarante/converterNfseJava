package com.constanzooficial.integracao.model.nfse.sp.saoVicente;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("IdentificacaoNfse")
public class IdentificacaoNfse {
    
    @XStreamAlias("NumeroNfse")
    private String numeroNfse;
    
    @XStreamAlias("CpfCnpj")
    private String cpfCnpj;
    
    @XStreamAlias("InscricaoMunicipal")
    private String InscricaoMunicipal;

    public String getNumeroNfse() {
        return numeroNfse;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getInscricaoMunicipal() {
        return InscricaoMunicipal;
    }
}
