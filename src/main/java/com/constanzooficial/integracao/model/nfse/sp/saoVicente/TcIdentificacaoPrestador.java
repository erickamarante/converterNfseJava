package com.constanzooficial.integracao.model.nfse.sp.saoVicente;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("tc:IdentificacaoPrestador")
public class TcIdentificacaoPrestador {

    @XStreamAlias("tc:CpfCnpj")
    private TcCpfCnpj tcCpfCnpj;

    @XStreamAlias("tc:InscricaoMunicipal")
    private String tcInscricaoMunicipal;

    public TcCpfCnpj getTcCpfCnpj() {
        return tcCpfCnpj;
    }

    public String getTcInscricaoMunicipal() {
        return tcInscricaoMunicipal;
    }
}
