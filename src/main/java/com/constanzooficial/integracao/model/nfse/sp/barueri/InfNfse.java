package com.constanzooficial.integracao.model.nfse.sp.barueri;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("InfNfse")
public class InfNfse {

    @XStreamAlias("Numero")
    private String Numero;

    @XStreamAlias("CodigoVerificacao")
    private String CodigoVerificacao;

    @XStreamAlias("DataEmissao")
    private String DataEmissao;

    @XStreamAlias("ValoresNfse")
    private ValoresNfse valoresNfse;

    @XStreamAlias("ValorCredito")
    private String valorCredito;

    @XStreamAlias("PrestadorServico")
    private PrestadorServico PrestadorServico;

    @XStreamAlias("OrgaoGerador")
    private OrgaoGerador OrgaoGerador;

    @XStreamAlias("DeclaracaoPrestacaoServico")
    private DeclaracaoPrestacaoServico declaracaoPrestacaoServico;

    public String getNumero() {
        return Numero;
    }

    public String getCodigoVerificacao() {
        return CodigoVerificacao;
    }

    public String getDataEmissao() {
        return DataEmissao;
    }

    public ValoresNfse getValoresNfse() {
        return valoresNfse;
    }

    public String getValorCredito() {
        return valorCredito;
    }

    public PrestadorServico getPrestadorServico() {
        return PrestadorServico;
    }

    public OrgaoGerador getOrgaoGerador() {
        return OrgaoGerador;
    }

    public DeclaracaoPrestacaoServico getDeclaracaoPrestacaoServico() {
        return declaracaoPrestacaoServico;
    }

}
