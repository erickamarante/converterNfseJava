package com.constanzooficial.integracao.model.nfse.sp.bauru;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("LocalServico")
public class LocalServico {
    @XStreamAlias("LocalServicoEstado")
    private String localServicoEstado;
    
    @XStreamAlias("LocalServicoCidade")
    private String localServicoCidade;

    public String getLocalServicoEstado() {
        return localServicoEstado;
    }

    public String getLocalServicoCidade() {
        return localServicoCidade;
    }
}
