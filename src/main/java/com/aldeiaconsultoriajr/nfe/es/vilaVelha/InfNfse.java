package com.aldeiaconsultoriajr.nfe.es.vilaVelha;

import com.aldeiaconsultoriajr.util.MyUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("InfNfse")
public class InfNfse {

    @XStreamAlias("Numero")
    private String numero;
    @XStreamAlias("CodigoVerificacao")
    private String codigoVerificacao;
    @XStreamAlias("DataEmissao")
    private String dataEmissao;
    @XStreamAlias("ValoresNfse")
    private ValoresNfse valoresNfse;
    @XStreamAlias("ValorCredito")
    private String valorCredito;
    @XStreamAlias("PrestadorServico")
    private PrestadorServico prestadorServico;
    @XStreamAlias("OrgaoGerador")
    private OrgaoGerador orgaoGerador;
    @XStreamAlias("DeclaracaoPrestacaoServico")
    private DeclaracaoPrestacaoServico declaracaoPrestacaoServico;

    public String getNumero() {
        return numero;
    }

    public String getCodigoVerificacao() {
        return codigoVerificacao;
    }

    public String[] getDataEmissao() {
        return MyUtils.trataData(dataEmissao);
    }

    public ValoresNfse getValoresNfse() {
        return valoresNfse;
    }

    public String getValorCredito() {
        return valorCredito;
    }

    public PrestadorServico getPrestadorServico() {
        return prestadorServico;
    }

    public OrgaoGerador getOrgaoGerador() {
        return orgaoGerador;
    }

    public DeclaracaoPrestacaoServico getDeclaracaoPrestacaoServico() {
        return declaracaoPrestacaoServico;
    }
}
