package com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001;

import java.util.ArrayList;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
public class ModelNota {
    
    private ModelCabecalho cabecalho;
    private ArrayList<ModelDetalhe> detalhe;
    private ModelRodape rodape;

    public ModelCabecalho getCabecalho() {
        return cabecalho;
    }

    public void setCabecalho(ModelCabecalho cabecalho) {
        this.cabecalho = cabecalho;
    }

    public ArrayList<ModelDetalhe> getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(ArrayList<ModelDetalhe> detalhe) {
        this.detalhe = detalhe;
    }

    public ModelRodape getRodape() {
        return rodape;
    }

    public void setRodape(ModelRodape rodape) {
        this.rodape = rodape;
    }
}
