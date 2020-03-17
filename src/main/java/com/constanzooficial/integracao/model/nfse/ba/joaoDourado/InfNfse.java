package com.constanzooficial.integracao.model.nfse.ba.joaoDourado;

import com.constanzooficial.integracao.util.MyUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("InfNfse")
public class InfNfse {

    @XStreamAlias("Id")
    @XStreamAsAttribute
    private String id;
    
    @XStreamAlias("Numero")
    private String numero;

    @XStreamAlias("CodigoVerificacao")
    private String CodigoVerificacao;

    @XStreamAlias("DataEmissao")
    private String dataEmissao;
    
    @XStreamAlias("NfseSubstituida")
    private String nfseSubstituida;
    
    @XStreamAlias("OutrasInformacoes")
    private String outrasInformacoes;
    
    @XStreamAlias("ValoresNfse")
    private ValoresNfse valoresNfse;
    
    @XStreamAlias("ValorCredito")
    private String valorCredito;
    
    @XStreamAlias("PrestadorServico")
    private PrestadorServico prestadorServico;
    
    @XStreamAlias("DeclaracaoPrestacaoServico")
    private DeclaracaoPrestacaoServico declaracaoPrestacaoServico;

    public String getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public String getCodigoVerificacao() {
        return CodigoVerificacao;
    }

    public String[] getDataEmissao() {
        String[] dataHora = MyUtils.trataDataHora2(dataEmissao);
        return dataHora;
    }

    public String getNfseSubstituida() {
        return nfseSubstituida;
    }

    public String getOutrasInformacoes() {
        return outrasInformacoes;
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

    public DeclaracaoPrestacaoServico getDeclaracaoPrestacaoServico() {
        return declaracaoPrestacaoServico;
    }

}
