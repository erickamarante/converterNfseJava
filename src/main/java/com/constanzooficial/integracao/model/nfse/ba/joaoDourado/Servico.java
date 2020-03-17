package com.constanzooficial.integracao.model.nfse.ba.joaoDourado;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("Servico")
public class Servico {
    
    @XStreamAlias("Valores")
    private Valores valores;
    
    @XStreamAlias("IssRetido")
    private String issRetido;

    @XStreamAlias("ResponsavelRetencao")
    private String responsavelRetencao;

    @XStreamAlias("ItemListaServico")
    private String itemListaServico;
    
    @XStreamAlias("CodigoCnae")
    private String codigoCnae;
    
    @XStreamAlias("Discriminacao")
    private String discriminacao;
    
    @XStreamAlias("CodigoMunicipio")
    private String codigoMunicipio;
    
    @XStreamAlias("CodigoPais")
    private String codigoPais;
    
    @XStreamAlias("ExigibilidadeISS")
    private String exigibilidadeISS;
    
    @XStreamAlias("MunicipioIncidencia")
    private String municipioIncidencia;

    public Valores getValores() {
        return valores;
    }

    public String getIssRetido() {
        return issRetido;
    }

    public String getResponsavelRetencao() {
        return responsavelRetencao;
    }

    public String getItemListaServico() {
        return itemListaServico;
    }

    public String getCodigoCnae() {
        return codigoCnae;
    }

    public String getDiscriminacao() {
        return discriminacao;
    }

    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public String getExigibilidadeISS() {
        return exigibilidadeISS;
    }

    public String getMunicipioIncidencia() {
        return municipioIncidencia;
    }
}
