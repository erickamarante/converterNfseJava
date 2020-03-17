package com.constanzooficial.integracao.model.nfse.go.rioVerde;

import static com.constanzooficial.integracao.util.MyUtils.*;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Waislan Waislan
 */
@XStreamAlias("InfNfse")
public class InfNfse {
    
    @XStreamAlias("Id")
    @XStreamAsAttribute
    private String id;
    
    @XStreamAlias("Numero")
    private String numero;
    
    @XStreamAlias("CodigoVerificacao")
    private String codigoVerificacao;
    
    @XStreamAlias("DataEmissao")
    private String dataEmissao;
    
    @XStreamAlias("NfseSubstituida")
    private String nfseSubstituida;
    
    @XStreamAlias("DescricaoCancelamento")
    private String descricaoCancelamento;
    
    @XStreamAlias("DescricaoSubstituicao")
    private String descricaoSubstituicao;
    
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
        // formato de hora da nota: AAAA-MM-DDThh:mm:ss.xxx
        String[] retorno = dataEmissao.split("\\.");

        retorno = trataDataHora2(retorno[0]);
        
        return retorno;
    }

    public String getNfseSubstituida() {
        return nfseSubstituida;
    }

    public String getDescricaoCancelamento() {
        return descricaoCancelamento;
    }

    public String getDescricaoSubstituicao() {
        return descricaoSubstituicao;
    }

    public ValoresNfse getValoresNfse() {
        return valoresNfse;
    }

    public DeclaracaoPrestacaoServico getDeclaracaoPrestacaoServico() {
        return declaracaoPrestacaoServico;
    }  
    
}
