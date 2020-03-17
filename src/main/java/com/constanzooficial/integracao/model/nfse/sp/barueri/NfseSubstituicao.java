package com.constanzooficial.integracao.model.nfse.sp.barueri;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("NfseSubstituicao")
public class NfseSubstituicao {
    
    @XStreamAlias("InfSubstituicaoNfse")
    private InfSubstituicaoNfse infSubstituicaoNfse;

    public InfSubstituicaoNfse getInfSubstituicaoNfse() {
        return infSubstituicaoNfse;
    }
}
