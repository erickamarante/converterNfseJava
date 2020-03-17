package com.constanzooficial.integracao.model.nfse.sp.saoVicente;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("tc:Servico")
public class TcServico {

    @XStreamAlias("tc:ItemListaServico")
    private String tcItemListaServico;

    @XStreamAlias("tc:CodigoCnae")
    private String tcCodigoCnae;

    @XStreamAlias("tc:CodigoTributacaoMunicipio")
    private String tcCodigoTributacaoMunicipio;

    @XStreamAlias("tc:Discriminacao")
    private String tcDiscriminacao;

    @XStreamAlias("tc:MunicipioPrestacaoServico")
    private String tcMunicipioPrestacaoServico;

    @XStreamAlias("tc:Valores")
    private TcValores tcValores;

    public String getTcItemListaServico() {
        return tcItemListaServico;
    }

    public String getTcCodigoCnae() {
        return tcCodigoCnae;
    }

    public String getTcCodigoTributacaoMunicipio() {
        return tcCodigoTributacaoMunicipio;
    }

    public String getTcDiscriminacao() {
        return tcDiscriminacao;
    }

    public String getTcMunicipioPrestacaoServico() {
        return tcMunicipioPrestacaoServico;
    }

    public TcValores getTcValores() {
        return tcValores;
    }
}
