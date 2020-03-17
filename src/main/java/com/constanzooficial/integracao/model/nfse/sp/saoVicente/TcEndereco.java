package com.constanzooficial.integracao.model.nfse.sp.saoVicente;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("tc:Endereco")
public class TcEndereco {

    @XStreamAlias("tc:Endereco")
    private String tcEndereco;

    @XStreamAlias("tc:Numero")
    private String tcNumero;

    @XStreamAlias("tc:Complemento")
    private String tcComplemento;

    @XStreamAlias("tc:Bairro")
    private String tcBairro;

    @XStreamAlias("tc:Cidade")
    private String tcCidade;

    @XStreamAlias("tc:Estado")
    private String tcEstado;

    @XStreamAlias("tc:Cep")
    private String tcCep;

    public String getTcEndereco() {
        return tcEndereco;
    }

    public String getTcNumero() {
        return tcNumero;
    }

    public String getTcComplemento() {
        return tcComplemento;
    }

    public String getTcBairro() {
        return tcBairro;
    }

    public String getTcCidade() {
        return tcCidade;
    }

    public String getTcEstado() {
        return tcEstado;
    }

    public String getTcCep() {
        return tcCep;
    }
}
