package com.aldeiaconsultoriajr.nfe.sc.agrolandia;

import com.aldeiaconsultoriajr.util.MyUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("lista")
public class Lista {
    
    @XStreamAlias("codigo_local_prestacao_servico")
    private String codigo_local_prestacao_servico;
    
    @XStreamAlias("codigo_item_lista_servico")
    private String codigo_item_lista_servico;
    
    @XStreamAlias("descritivo")
    private String descritivo;
    
    @XStreamAlias("aliquota_item_lista_servico")
    private String aliquota_item_lista_servico;
    
    @XStreamAlias("situacao_tributaria")
    private String situacao_tributaria;
    
    @XStreamAlias("valor_tributavel")
    private String valor_tributavel;
    
    @XStreamAlias("valor_deducao")
    private String valor_deducao;
    
    @XStreamAlias("valor_issrf")
    private String valor_issrf;
    
    @XStreamAlias("tributa_municipio_prestador")
    private String tributa_municipio_prestador;
    
    @XStreamAlias("unidade_codigo")
    private String unidade_codigo;
    
    @XStreamAlias("unidade_quantidade")
    private String unidade_quantidade;
    
    @XStreamAlias("unidade_valor_unitario")
    private String unidade_valor_unitario;

    public String getCodigo_local_prestacao_servico() {
        return codigo_local_prestacao_servico;
    }

    public String getCodigo_item_lista_servico() {
        return codigo_item_lista_servico;
    }

    public String getDescritivo() {
        return descritivo;
    }

    public String getAliquota_item_lista_servico() {
        return MyUtils.trataValor(aliquota_item_lista_servico);
    }

    public String getSituacao_tributaria() {
        return situacao_tributaria;
    }

    public String getValor_tributavel() {
        return MyUtils.trataValor(valor_tributavel);
    }

    public String getValor_deducao() {
        return MyUtils.trataValor(valor_deducao);
    }

    public String getValor_issrf() {
        return MyUtils.trataValor(valor_issrf);
    }

    public String getTributa_municipio_prestador() {
        return tributa_municipio_prestador;
    }

    public String getUnidade_codigo() {
        return unidade_codigo;
    }

    public String getUnidade_quantidade() {
        return unidade_quantidade;
    }

    public String getUnidade_valor_unitario() {
        return unidade_valor_unitario;
    }
    
}
