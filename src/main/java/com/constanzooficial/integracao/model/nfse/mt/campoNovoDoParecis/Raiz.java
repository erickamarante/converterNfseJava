package com.constanzooficial.integracao.model.nfse.mt.campoNovoDoParecis;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.ArrayList;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("raiz")
public class Raiz {
    
    @XStreamImplicit
    private ArrayList<ConsultarNfseRpsResposta> consultarNfseRpsResposta;

    public ArrayList<ConsultarNfseRpsResposta> getConsultarNfseRpsResposta() {
        return consultarNfseRpsResposta;
    }
}
