package com.constanzooficial.integracao.model.nfse.sp.barueri;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
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
    
    @XStreamAlias("ExigibilidadeISS")
    private String exigibilidadeISS;
    
    @XStreamAlias("MunicipioIncidencia")
    private String municipioIncidencia;

    public Valores getValores() {
        return valores;
    }

    public boolean getIssRetido() {
        return !"2".equals(issRetido);
    }

    public String getResponsavelRetencao() {
        return responsavelRetencao;
    }

    public String getItemListaServico() {
        if (itemListaServico != null) {
            return itemListaServico.replace(".", "");
        } else {
            return null;
        }
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

    public String getExigibilidadeISS() {
        return exigibilidadeISS;
    }

    public String getMunicipioIncidencia() {
        return municipioIncidencia;
    }
}
