package com.aldeiaconsultoriajr.nfe.go.rioVerde;

import com.aldeiaconsultoriajr.util.MyUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("InfConfirmacaoCancelamento")
public class InfConfirmacaoCancelamento {
    
    @XStreamAlias("Sucesso")
    private String sucesso;
    
    @XStreamAlias("DataHora")
    private String dataHora;

    public String getSucesso() {
        return sucesso;
    }

    public String[] getDataHora() {
        return MyUtils.trataDataHora(dataHora);
    }
}
