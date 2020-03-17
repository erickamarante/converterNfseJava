package com.constanzooficial.integracao.model.nfse.es.colatina;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Luis Sanches
 */
@XStreamAlias("IdentificacaoPrestador")
public class IdentificacaoPrestador {
    
    @XStreamAlias("CpfCnpj")
    private String cpfCnpj;
    
    @XStreamAlias("IndicacaoCpfCnpj")
    private String indicacaoCpfCnpj;
    
    @XStreamAlias("InscricaoMunicipal")
    private String inscricaoMunicipal;

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getIndicacaoCpfCnpj() {
        return indicacaoCpfCnpj;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }
    
}
