package com.constanzooficial.integracao.model.nfse.sp.saoVicente;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("tc:Contato")
public class TcContato {

    @XStreamAlias("tc:Telefone")
    private String tcTelefone;

    @XStreamAlias("tc:Email")
    private String tcEmail;

    public String getTcTelefone() {
        return tcTelefone;
    }

    public String getTcEmail() {
        return tcEmail;
    }
}
