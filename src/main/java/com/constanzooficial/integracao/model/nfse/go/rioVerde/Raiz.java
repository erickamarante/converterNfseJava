package com.constanzooficial.integracao.model.nfse.go.rioVerde;

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
    private ArrayList<GerarNfseResposta> gerarNfseRespostas;

    public ArrayList<GerarNfseResposta> getGerarNfseRespostas() {
        return gerarNfseRespostas;
    }  
    
}
