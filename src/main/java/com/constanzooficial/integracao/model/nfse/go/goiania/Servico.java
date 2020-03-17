package com.constanzooficial.integracao.model.nfse.go.goiania;

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
    
    @XStreamAlias("CodigoTributacaoMunicipio")
    private String codigoTributacaoMunicipio;
    
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

    public String getIssRetido() {
        return issRetido;
    }

    public String getCodigoTributacaoMunicipio() {
        return codigoTributacaoMunicipio.substring(0, 5);
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
