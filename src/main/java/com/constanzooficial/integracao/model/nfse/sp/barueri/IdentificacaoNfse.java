package com.constanzooficial.integracao.model.nfse.sp.barueri;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("IdentificacaoNfse")
public class IdentificacaoNfse {
    
    @XStreamAlias("Numero")
    private String numero;
    @XStreamAlias("CpfCnpj")
    private CpfCnpj cpfCnpj;
    @XStreamAlias("InscricaoMunicipal")
    private String inscricaoMunicipal;
    @XStreamAlias("CodigoMunicipio")
    private String codigoMunicipio;

    public String getNumero() {
        return numero;
    }

    public CpfCnpj getCpfCnpj() {
        return cpfCnpj;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }
}
