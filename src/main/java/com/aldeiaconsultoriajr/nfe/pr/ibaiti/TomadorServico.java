package com.aldeiaconsultoriajr.nfe.pr.ibaiti;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("tomadorServico")
class TomadorServico {
    
    private String nmTomador;
    private String nrDocumento;
    private String dsEndereco;
    private String nrEndereco;
    private String nmPais;
    private String nmCidade;
    private String nmBairro;
    private String nmUf;
    private String cdIbge;
    private String nrCep;

    public String getNmTomador() {
        return nmTomador;
    }

    public String getNrDocumento() {
        return nrDocumento;
    }

    public String getDsEndereco() {
        return dsEndereco;
    }

    public String getNrEndereco() {
        return nrEndereco;
    }

    public String getNmPais() {
        return nmPais;
    }

    public String getNmCidade() {
        return nmCidade;
    }

    public String getNmBairro() {
        return nmBairro;
    }

    public String getNmUf() {
        return nmUf;
    }

    public String getCdIbge() {
        return cdIbge;
    }

    public String getNrCep() {
        return nrCep;
    }
}
