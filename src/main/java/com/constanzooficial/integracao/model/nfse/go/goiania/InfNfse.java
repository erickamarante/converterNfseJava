package com.constanzooficial.integracao.model.nfse.go.goiania;

import static com.constanzooficial.integracao.util.MyUtils.trataDataHora2;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
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
    
    @XStreamAlias("DeclaracaoPrestacaoServico")
    private DeclaracaoPrestacaoServico declaracaoPrestacaoServico;

    public String getNumero() {
        return numero;
    }

    public String getCodigoVerificacao() {
        return codigoVerificacao;
    }

    public String[] getDataEmissao() {
        String[] retorno = trataDataHora2(dataEmissao);
        return retorno;
    }

    public ValoresNfse getValoresNfse() {
        return valoresNfse;
    }

    public DeclaracaoPrestacaoServico getDeclaracaoPrestacaoServico() {
        return declaracaoPrestacaoServico;
    }
    
}
