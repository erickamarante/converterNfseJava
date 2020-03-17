package com.constanzooficial.integracao.model.sp.osasco;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Luis Sanches
 */
@XStreamAlias("NotaFiscalRelatorioDTO")
public class NotaFiscalRelatorioDTO {
    
    @XStreamAlias("Prestador")
    private Prestador prestador;
    
    @XStreamAlias("Tomador")
    private Tomador tomador;
    
    @XStreamAlias("DataEmissao")
    private String dataEmissao;
    
    @XStreamAlias("DataCancelamento")
    private String dataCancelamento;
    
    @XStreamAlias("DataRecibo")
    private String dataRecibo;
    
    @XStreamAlias("Numero")
    private String numero;
    
    @XStreamAlias("Serie")
    private String serie;
    
    @XStreamAlias("DescricaoServicos")
    private String descricaoServicos;
    
    @XStreamAlias("NumeroRecibo")
    private String numeroRecibo;

    @XStreamAlias("InformacoesAdicionais")
    private String informacoesAdicionais;
    
    @XStreamAlias("ValorIss")
    private String valorIss;

    @XStreamAlias("Valor")
    private String valor;
    
    @XStreamAlias("ValorDeducao")
    private String valorDeducao;
    
    @XStreamAlias("BaseCalculo")
    private String baseCalculo;
    
    @XStreamAlias("Aliquota")
    private String aliquota;
    
    @XStreamAlias("SubstituicaoTributaria")
    private String substituicaoTributaria;
    
    @XStreamAlias("DescricaoAtividade")
    private String descricaoAtividade;
    
    @XStreamAlias("CodigoAutenticidade")
    private String codigoAutenticidade;
    
    @XStreamAlias("ValorIR")
    private String valorIr;
    
    @XStreamAlias("ValorINSS")
    private String valorInss;
    
    @XStreamAlias("ValorCofins")
    private String valorCofins;
    
    @XStreamAlias("ValorPisPasep")
    private String valorPisPasep;
    
    @XStreamAlias("ValorCSLL")
    private String valorCsll;
    
    @XStreamAlias("ValorOutrosImpostos")
    private String valorOutrosImpostos;
    
    @XStreamAlias("ValorRepasse")
    private String valorRepasse;
    
    @XStreamAlias("SomarISSAoValorTotal")
    private String somarIssAoValorTotal;
    
    @XStreamAlias("SimplesNacional")
    private String simplesNacional;
    
    @XStreamAlias("NotaFiscalSubstituida")
    private String notaFiscalSubstituida;
    
    @XStreamAlias("IsCEI")
    private String IsCEI;
    
    @XStreamAlias("LinkNota")
    private String linkNota;
    
    public Prestador getPrestador() {
        return prestador;
    }

    public Tomador getTomador() {
        return tomador;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public String getDataCancelamento() {
        return dataCancelamento;
    }

    public String getDataRecibo() {
        return dataRecibo;
    }   

    public String getNumero() {
        return numero;
    }

    public String getSerie() {
        return serie;
    }

    public String getDescricaoServicos() {
        return descricaoServicos;
    }

    public String getNumeroRecibo() {
        return numeroRecibo;
    }

    public String getInformacoesAdicionais() {
        return informacoesAdicionais;
    }

    public String getValorIss() {
        return valorIss;
    }

    public String getValor() {
        return valor;
    }

    public String getValorDeducao() {
        return valorDeducao;
    }

    public String getBaseCalculo() {
        return baseCalculo;
    }

    public String getAliquota() {
        return aliquota;
    }

    public String getSubstituicaoTributaria() {
        return substituicaoTributaria;
    }

    public String getDescricaoAtividade() {
        return descricaoAtividade;
    }

    public String getCodigoAutenticidade() {
        return codigoAutenticidade;
    }

    public String getValorIr() {
        return valorIr;
    }

    public String getValorInss() {
        return valorInss;
    }

    public String getValorCofins() {
        return valorCofins;
    }

    public String getValorPisPasep() {
        return valorPisPasep;
    }

    public String getValorCsll() {
        return valorCsll;
    }

    public String getValorOutrosImpostos() {
        return valorOutrosImpostos;
    }

    public String getValorRepasse() {
        return valorRepasse;
    }

    public String getSomarIssAoValorTotal() {
        return somarIssAoValorTotal;
    }

    public String getSimplesNacional() {
        return simplesNacional;
    }

    public String getNotaFiscalSubstituida() {
        return notaFiscalSubstituida;
    }

    public String getIsCEI() {
        return IsCEI;
    }

    public String getLinkNota() {
        return linkNota;
    }
    
}
