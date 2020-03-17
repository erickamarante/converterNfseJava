package com.constanzooficial.integracao.model.nfse.rs.bentoGoncalves;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("NfseSubstituicao")
public class NfseSubstituicao {
    
    @XStreamAlias("SubstituicaoNfse")
    private String substituicaoNfse;
    
    @XStreamAlias("InfSubstituicaoNfse")
    private InfSubstituicaoNfse infSubstituicaoNfse;

    public InfSubstituicaoNfse getInfSubstituicaoNfse() {
        return infSubstituicaoNfse;
    }

    public String getSubstituicaoNfse() {
        return substituicaoNfse;
    }
}
