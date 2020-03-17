package com.constanzooficial.integracao.model.nfse.mt.campoNovoDoParecis;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.ArrayList;

@XStreamAlias("ConsultarNfseRpsRespostas")
public class ConsultarNfseRpsRespostas {
    
    @XStreamImplicit
    private ArrayList<ConsultarNfseRpsResposta> consultarNfseRpsResposta;

    public ArrayList<ConsultarNfseRpsResposta> getConsultarNfseRpsResposta() {
        return consultarNfseRpsResposta;
    }
}
