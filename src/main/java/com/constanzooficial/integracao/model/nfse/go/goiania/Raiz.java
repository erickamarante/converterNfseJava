package com.constanzooficial.integracao.model.nfse.go.goiania;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.ArrayList;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("raiz")
public class Raiz {
    
    @XStreamImplicit
    private ArrayList<GerarNfseResposta> gerarNfseResposta;

    public ArrayList<GerarNfseResposta> getGerarNfseResposta() {
        return gerarNfseResposta;
    }
    
}
