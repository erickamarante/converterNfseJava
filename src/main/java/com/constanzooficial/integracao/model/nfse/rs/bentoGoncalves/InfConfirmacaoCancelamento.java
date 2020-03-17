package com.constanzooficial.integracao.model.nfse.rs.bentoGoncalves;

import com.constanzooficial.integracao.util.MyUtils;
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
        String[] data = MyUtils.trataDataHora2(dataHora);
        data[5] = data[5].split("\\.")[1];
        return data;
    }
}
