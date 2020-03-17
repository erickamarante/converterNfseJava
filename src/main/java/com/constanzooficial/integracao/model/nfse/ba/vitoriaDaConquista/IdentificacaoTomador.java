package com.constanzooficial.integracao.model.nfse.ba.vitoriaDaConquista;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("IdentificacaoTomador")
public class IdentificacaoTomador {

    @XStreamAlias("CpfCnpj")
    private CpfCnpj cpfCnpj;
    
    @XStreamAlias("InscricaoMunicipal")
    private String inscricaoMunicipal;

    public CpfCnpj getCpfCnpj() {
        return cpfCnpj;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

}
