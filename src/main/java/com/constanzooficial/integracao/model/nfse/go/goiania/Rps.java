package com.constanzooficial.integracao.model.nfse.go.goiania;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("Rps")
public class Rps {
    
    @XStreamAlias("IdentificacaoRps")
    private IdentificacaoRps identificacaoRps;
    
    @XStreamAlias("DataEmissao")
    private String DataEmissao;
    
    @XStreamAlias("Status")
    private String status;

    public IdentificacaoRps getIdentificacaoRps() {
        return identificacaoRps;
    }

    public String getDataEmissao() {
        return DataEmissao;
    }

    public String getStatus() {
        return status;
    }
    
}
