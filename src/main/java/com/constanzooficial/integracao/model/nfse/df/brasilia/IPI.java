package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("IPI")
public class IPI {
    
    @XStreamAlias("cEnq")
    private String cEnq;
    
    @XStreamAlias("IPITrib")
    private IPITrib IpiTributacao;

    public String getcEnq() {
        return cEnq;
    }

    public IPITrib getIpiTributacao() {
        return IpiTributacao;
    }
    
}
