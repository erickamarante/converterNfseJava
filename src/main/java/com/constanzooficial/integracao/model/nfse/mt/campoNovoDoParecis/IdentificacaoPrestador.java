package com.constanzooficial.integracao.model.nfse.mt.campoNovoDoParecis;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("IdentificacaoPrestador")
public class IdentificacaoPrestador {

    @XStreamAlias("CpfCnpj")
    private CpfCnpj CpfCnpj;

    @XStreamAlias("InscricaoMunicipal")
    private String InscricaoMunicipal;
    
    @XStreamAlias("InscricaoEstadual")
    private String inscricaoEstadual;

    public CpfCnpj getCpfCnpj() {
        return CpfCnpj;
    }

    public String getInscricaoMunicipal() {
        return InscricaoMunicipal;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }
}
