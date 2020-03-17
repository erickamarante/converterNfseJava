package com.aldeiaconsultoriajr.nfe.pr.ibaiti;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("prestadorServico")
class PrestadorServico {

    private String nmPrestador;
    private String nrDocumento;
    private String nrInscricaoMunicipal;
    private String dsEndereco;
    private String nrEndereco;
    private String nmPais;
    private String nmCidade;
    private String nmBairro;
    private String nmUf;
    private String nrCep;

    public String getNmPrestador() {
        return nmPrestador;
    }

    public String getNrDocumento() {
        return nrDocumento;
    }

    public String getNrInscricaoMunicipal() {
        return nrInscricaoMunicipal;
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

    public String getNrCep() {
        return nrCep;
    }
}
