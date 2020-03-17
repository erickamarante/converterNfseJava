package com.constanzooficial.integracao.model.nfse.ba.vitoriaDaConquista;

import com.constanzooficial.integracao.util.MyUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("ConfirmacaoCancelamento")
public class Confirmacao {
    
    @XStreamAsAttribute
    @XStreamAlias("Id")
    private String id;
    
    @XStreamAlias("DataHora")
    private String DataHora;

    @XStreamAlias("Pedido")
    private Pedido pedido;

    public Pedido getPedido() {
        return pedido;
    }

    public String getId() {
        return id;
    }

    public String[] getDataHora() {
        return MyUtils.trataDataHora2(DataHora);
    }
    
}
