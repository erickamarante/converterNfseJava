package com.constanzooficial.integracao.model.nfse.sc.agrolandia2;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("lista")
public class Lista {
    
    @XStreamAlias("codigo_local_prestacao_servico")
    private String codigoLocalPrestacaoServico;
    
    @XStreamAlias("codigo_item_lista_servico")
    private String codigoItemListaServico;
    
    @XStreamAlias("descritivo")
    private String descritivo;
    
    @XStreamAlias("aliquota_item_lista_servico")
    private String aliquotaItemListaServico;
    
    @XStreamAlias("situacao_tributaria")
    private String situacaoTributaria;
    
    @XStreamAlias("valor_tributavel")
    private String valorTributavel;
    
    @XStreamAlias("valor_deducao")
    private String valorDeducao;
    
    @XStreamAlias("valor_issrf")
    private String valorIssrf;
    
    @XStreamAlias("tributa_municipio_prestador")
    private String tributaMunicipioPrestador;
    
    @XStreamAlias("unidade_codigo")
    private String unidadeCodigo;
    
    @XStreamAlias("unidade_quantidade")
    private String unidadeQuantidade;
    
    @XStreamAlias("unidade_valor_unitario")
    private String unidadeValorUnitario;

    public String getCodigoLocalPrestacaoServico() {
        return codigoLocalPrestacaoServico;
    }

    public String getCodigoItemListaServico() {
        return codigoItemListaServico;
    }

    public String getDescritivo() {
        return descritivo;
    }

    public String getAliquotaItemListaServico() {
        return aliquotaItemListaServico;
    }

    public String getSituacaoTributaria() {
        return situacaoTributaria;
    }

    public String getValorTributavel() {
        return valorTributavel;
    }

    public String getValorDeducao() {
        return valorDeducao;
    }

    public String getValorIssrf() {
        return valorIssrf;
    }

    public String getTributaMunicipioPrestador() {
        return tributaMunicipioPrestador;
    }

    public String getUnidadeCodigo() {
        return unidadeCodigo;
    }

    public String getUnidadeQuantidade() {
        return unidadeQuantidade;
    }

    public String getUnidadeValorUnitario() {
        return unidadeValorUnitario;
    }
    
}
