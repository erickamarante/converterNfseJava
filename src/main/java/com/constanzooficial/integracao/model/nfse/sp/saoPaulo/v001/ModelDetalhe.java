package com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001;

import com.constanzooficial.integracao.util.MyUtils;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
public class ModelDetalhe {

    // Registro tipo 2 - detalhe
    private String tipoRegistro;
    private String numeroNfse;
    private String[] dataHoraNfse;
    private String codigoVerificacaoNfse;
    private String tipoRps; // opcional
    private String serieRps; //opcional
    private String numeroRps; //opcional
    private String[] dataEmissaoRps; //igual a da nota
    private String inscricaoMunicipalPrestador;
    private String indicadorCpfCnpjPrestador;
    private String cpfCnpjPrestador;
    private String razaoSocialPrestador;
    private String tipoEnderecoPrestador;
    private String enderecoPrestador;
    private String numeroEnderecoPrestador;
    private String complementoEnderecoPrestador;
    private String bairroPrestador;
    private String cidadePrestador;
    private String ufPrestador;
    private String cepPrestador;
    private String emailPrestador;
    private String opcaoPeloSimples;
    private String situacaoNotaFiscal;
    private String[] dataCancelamento;
    private String numeroGuia;
    private String[] dataQuitacaoGuiaVinculadaNotaFiscal;
    private String valorServicos;
    private String valorDeducoes;
    private String codigoServicoPrestadoNotaFiscal;
    private String aliquota;
    private String valorIss;
    private String valorCredito;
    private String issRetido;
    private String indicadorCpfCnpjTomador;
    private String cpfCnpjTomador;
    private String inscricaoMunicipalTomador;
    private String inscricaoEstadualTomador;
    private String razaoSocialTomador;
    private String tipoEnderecoTomador;
    private String enderecoTomador;
    private String numeroEnderecoTomador;
    private String complementoEnderecoTomador;
    private String bairroTomador;
    private String cidadeTomador;
    private String ufTomador;
    private String cepTomador;
    private String emailTomador;
    private String discriminacaoServicos;
    private String cpfCnpjIntermediario;

    public ModelDetalhe() {
        this.tipoRegistro = "2";
    }

    public String getTipoRegistroTxt() {
        return MyUtils.strTamanhoMax(this.tipoRegistro, 1, "numerico");
    }

    public String getTipoRegistro() {
        if (this.tipoRegistro == null) {
            return "";
        }
        return this.tipoRegistro;
    }

    public void setTipoRegistro(String tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    public String getNumeroNfseTxt() {
        return MyUtils.strTamanhoMax(this.numeroNfse, 8, "numerico").replaceAll("[^0-9]", "");
    }

    public String getNumeroNfse() {
        if (this.numeroNfse == null) {
            return "";
        }
        return this.numeroNfse;
    }

    public void setNumeroNfse(String numeroNfse) {
        this.numeroNfse = numeroNfse;
    }

    public String[] getDataHoraNfse() {

        String[] dataHora;
        dataHora = new String[6];
        if (this.dataHoraNfse != null) {
            dataHora[0] = MyUtils.strTamanhoMax((this.dataHoraNfse.length >= 1) ? this.dataHoraNfse[0] : null, 2, "numerico");
            dataHora[1] = MyUtils.strTamanhoMax((this.dataHoraNfse.length >= 2) ? this.dataHoraNfse[1] : null, 2, "numerico");
            dataHora[2] = MyUtils.strTamanhoMax((this.dataHoraNfse.length >= 3) ? this.dataHoraNfse[2] : null, 4, "numerico");
            dataHora[3] = MyUtils.strTamanhoMax((this.dataHoraNfse.length >= 4) ? this.dataHoraNfse[3] : null, 2, "numerico");
            dataHora[4] = MyUtils.strTamanhoMax((this.dataHoraNfse.length >= 5) ? this.dataHoraNfse[4] : null, 2, "numerico");
            dataHora[5] = MyUtils.strTamanhoMax((this.dataHoraNfse.length >= 6) ? this.dataHoraNfse[5] : null, 2, "numerico");
        } else {
            dataHora[0] = MyUtils.strTamanhoMax(null, 2, "numerico");
            dataHora[1] = MyUtils.strTamanhoMax(null, 2, "numerico");
            dataHora[2] = MyUtils.strTamanhoMax(null, 4, "numerico");
            dataHora[3] = MyUtils.strTamanhoMax(null, 2, "numerico");
            dataHora[4] = MyUtils.strTamanhoMax(null, 2, "numerico");
            dataHora[5] = MyUtils.strTamanhoMax(null, 2, "numerico");
        }

        return dataHora;
    }

    /**
     * DD MM AAAA HH mm ss
     *
     * @param dataHoraNfse
     */
    public void setDataHoraNfse(String[] dataHoraNfse) {
        this.dataHoraNfse = dataHoraNfse;
    }

    public String getCodigoVerificacaoNfseTxt() {
        return MyUtils.strTamanhoMax(this.codigoVerificacaoNfse, 8, "texto");
    }

    public String getCodigoVerificacaoNfse() {
        if (this.codigoVerificacaoNfse == null) {
            return "";
        }
        return this.codigoVerificacaoNfse;
    }

    public void setCodigoVerificacaoNfse(String codigoVerificacaoNfse) {
        this.codigoVerificacaoNfse = codigoVerificacaoNfse;
    }

    public String getTipoRpsTxt() {
        return MyUtils.strTamanhoMax(this.tipoRps, 5, "texto", "RPS");
    }

    public String getTipoRps() {
        if (this.tipoRps == null) {
            return "";
        }
        return this.tipoRps;
    }

    public void setTipoRps(String tipoRps) {
        this.tipoRps = tipoRps;
    }

    public String getSerieRpsTxt() {
        return MyUtils.strTamanhoMax(this.serieRps, 5, "texto");
    }

    public String getSerieRps() {
        if (this.serieRps == null) {
            return "";
        }
        return this.serieRps;
    }

    public void setSerieRps(String serieRps) {
        this.serieRps = serieRps;
    }

    public String getNumeroRpsTxt() {
        return MyUtils.strTamanhoMax(this.numeroRps, 12, "numerico");
    }

    public String getNumeroRps() {
        if (this.numeroRps == null) {
            return "";
        }
        return this.numeroRps;
    }

    public void setNumeroRps(String numeroRps) {
        this.numeroRps = numeroRps;
    }

    public String[] getDataEmissaoRps() {

        String[] dataEmissao;
        dataEmissao = new String[3];
        if (this.dataEmissaoRps != null) {
            dataEmissao[0] = MyUtils.strTamanhoMax(this.dataEmissaoRps[0], 2, "numerico");
            dataEmissao[1] = MyUtils.strTamanhoMax(this.dataEmissaoRps[1], 2, "numerico");
            dataEmissao[2] = MyUtils.strTamanhoMax(this.dataEmissaoRps[2], 4, "numerico");
        } else {
            dataEmissao[0] = MyUtils.strTamanhoMax(null, 2, "numerico");
            dataEmissao[1] = MyUtils.strTamanhoMax(null, 2, "numerico");
            dataEmissao[2] = MyUtils.strTamanhoMax(null, 4, "numerico");
        }
        return dataEmissao;
    }

    public void setDataEmissaoRps(String[] dataEmissaoRps) {
        this.dataEmissaoRps = dataEmissaoRps;
    }

    public String getInscricaoMunicipalPrestadorTxt() {
        return MyUtils.strTamanhoMax(this.inscricaoMunicipalPrestador, 8, "numerico");
    }

    public String getInscricaoMunicipalPrestador() {
        if (this.inscricaoMunicipalPrestador == null) {
            return "";
        }
        return this.inscricaoMunicipalPrestador;
    }

    public void setInscricaoMunicipalPrestador(String inscricaoMunicipalPrestador) {
        this.inscricaoMunicipalPrestador = inscricaoMunicipalPrestador;
    }

    public String getIndicadorCpfCnpjPrestadorTxt() {
        return MyUtils.strTamanhoMax(this.indicadorCpfCnpjPrestador, 1, "numerico");
    }

    public String getIndicadorCpfCnpjPrestador() {
        if (this.indicadorCpfCnpjPrestador == null) {
            return "";
        }
        return this.indicadorCpfCnpjPrestador;
    }

    public void setIndicadorCpfCnpjPrestador(String indicadorCpfCnpjPrestador) {
        this.indicadorCpfCnpjPrestador = indicadorCpfCnpjPrestador;
    }

    public String getCpfCnpjPrestadorTxt() {
        return MyUtils.strTamanhoMax(this.cpfCnpjPrestador, 14, "numerico");
    }

    public String getCpfCnpjPrestador() {
        if (this.cpfCnpjPrestador == null) {
            return "";
        }
        return this.cpfCnpjPrestador;
    }

    public void setCpfCnpjPrestador(String cpfCnpjPrestador) {
        if (cpfCnpjPrestador != null) {
            if (cpfCnpjPrestador.length() == 11) {
                this.setIndicadorCpfCnpjPrestador("1");
            } else if (cpfCnpjPrestador.length() == 14) {
                this.setIndicadorCpfCnpjPrestador("2");
            }
        } else {
            this.setIndicadorCpfCnpjPrestador("3");
        }
        this.cpfCnpjPrestador = cpfCnpjPrestador;
    }

    public String getRazaoSocialPrestadorTxt() {
        return MyUtils.strTamanhoMax(this.razaoSocialPrestador, 75, "texto");
    }

    public String getRazaoSocialPrestador() {
        if (this.razaoSocialPrestador == null) {
            return "";
        }
        return this.razaoSocialPrestador;
    }

    public void setRazaoSocialPrestador(String razaoSocialPrestador) {
        this.razaoSocialPrestador = razaoSocialPrestador;
    }

    public String getTipoEnderecoPrestadorTxt() {
        return MyUtils.strTamanhoMax(this.tipoEnderecoPrestador, 3, "texto");
    }

    public String getTipoEnderecoPrestador() {
        if (this.tipoEnderecoPrestador == null) {
            return "";
        }
        return this.tipoEnderecoPrestador;
    }

    public void setTipoEnderecoPrestador(String tipoEnderecoPrestador) {
        this.tipoEnderecoPrestador = tipoEnderecoPrestador;
    }

    public String getEnderecoPrestadorTxt() {
        return MyUtils.strTamanhoMax(this.enderecoPrestador, 50, "texto");
    }

    public String getEnderecoPrestador() {
        if (this.enderecoPrestador == null) {
            return "";
        }
        return this.enderecoPrestador;
    }

    public void setEnderecoPrestador(String enderecoPrestador) {
        this.enderecoPrestador = enderecoPrestador;
    }

    public String getNumeroEnderecoPrestadorTxt() {
        return MyUtils.strTamanhoMax(this.numeroEnderecoPrestador, 10, "texto");
    }

    public String getNumeroEnderecoPrestador() {
        if (this.numeroEnderecoPrestador == null) {
            return "";
        }
        return this.numeroEnderecoPrestador;
    }

    public void setNumeroEnderecoPrestador(String numeroEnderecoPrestador) {
        this.numeroEnderecoPrestador = numeroEnderecoPrestador;
    }

    public String getComplementoEnderecoPrestadorTxt() {
        return MyUtils.strTamanhoMax(this.complementoEnderecoPrestador, 30, "texto");
    }

    public String getComplementoEnderecoPrestador() {
        if (this.complementoEnderecoPrestador == null) {
            return "";
        }
        return this.complementoEnderecoPrestador;
    }

    public void setComplementoEnderecoPrestador(String complementoEnderecoPrestador) {
        this.complementoEnderecoPrestador = complementoEnderecoPrestador;
    }

    public String getBairroPrestadorTxt() {
        return MyUtils.strTamanhoMax(this.bairroPrestador, 30, "texto");
    }

    public String getBairroPrestador() {
        if (this.bairroPrestador == null) {
            return "";
        }
        return this.bairroPrestador;
    }

    public void setBairroPrestador(String bairroPrestador) {
        this.bairroPrestador = bairroPrestador;
    }

    public String getCidadePrestadorTxt() {
        return MyUtils.strTamanhoMax(this.cidadePrestador, 50, "texto");
    }

    public String getCidadePrestador() {
        if (this.cidadePrestador == null) {
            return "";
        }
        return this.cidadePrestador;
    }

    public void setCidadePrestador(String cidadePrestador) {
        this.cidadePrestador = cidadePrestador;
    }

    public String getUfPrestadorTxt() {
        return MyUtils.strTamanhoMax(this.ufPrestador, 2, "texto");
    }

    public String getUfPrestador() {
        if (this.ufPrestador == null) {
            return "";
        }
        return this.ufPrestador;
    }

    public void setUfPrestador(String ufPrestador) {
        this.ufPrestador = ufPrestador;
    }

    public String getCepPrestadorTxt() {
        return MyUtils.strTamanhoMax(this.cepPrestador, 8, "numerico");
    }

    public String getCepPrestador() {
        if (this.cepPrestador == null) {
            return "";
        }
        return this.cepPrestador;
    }

    public void setCepPrestador(String cepPrestador) {
        this.cepPrestador = cepPrestador;
    }

    public String getEmailPrestadorTxt() {
        return MyUtils.strTamanhoMax(this.emailPrestador, 75, "texto");
    }

    public String getEmailPrestador() {
        if (this.emailPrestador == null) {
            return "";
        }
        return this.emailPrestador;
    }

    public void setEmailPrestador(String emailPrestador) {
        this.emailPrestador = emailPrestador;
    }

    public String getOpcaoPeloSimplesTxt() {
        return MyUtils.strTamanhoMax(this.opcaoPeloSimples, 1, "numerico");
    }

    public String getOpcaoPeloSimples() {
        if (this.opcaoPeloSimples == null) {
            return "";
        }
        return this.opcaoPeloSimples;
    }

    public void setOpcaoPeloSimples(String opcaoPeloSimples) {
        this.opcaoPeloSimples = opcaoPeloSimples;
    }

    public String getSituacaoNotaFiscalTxt() {
        return MyUtils.strTamanhoMax(this.situacaoNotaFiscal, 1, "texto");
    }

    public String getSituacaoNotaFiscal() {
        if (this.situacaoNotaFiscal == null) {
            return "";
        }
        return this.situacaoNotaFiscal;
    }

    public void setSituacaoNotaFiscal(String situacaoNotaFiscal) {
        this.situacaoNotaFiscal = situacaoNotaFiscal;
    }

    public String[] getDataCancelamento() {

        String[] data;
        data = new String[3];
        if (this.dataCancelamento != null) {
            data[0] = MyUtils.strTamanhoMax(this.dataCancelamento[0], 2, "numerico");
            data[1] = MyUtils.strTamanhoMax(this.dataCancelamento[1], 2, "numerico");
            data[2] = MyUtils.strTamanhoMax(this.dataCancelamento[2], 4, "numerico");
        } else {
            data[0] = MyUtils.strTamanhoMax(null, 2, "texto");
            data[1] = MyUtils.strTamanhoMax(null, 2, "texto");
            data[2] = MyUtils.strTamanhoMax(null, 4, "texto");
        }
        return data;
    }

    public void setDataCancelamento(String[] dataCancelamento) {
        this.dataCancelamento = dataCancelamento;
    }

    public String getNumeroGuiaTxt() {
        return MyUtils.strTamanhoMax(this.numeroGuia, 12, "numerico");
    }

    public String getNumeroGuia() {
        if (this.numeroGuia == null) {
            return "";
        }
        return this.numeroGuia;
    }

    public void setNumeroGuia(String numeroGuia) {
        this.numeroGuia = numeroGuia;
    }

    public String[] getDataQuitacaoGuiaVinculadaNotaFiscal() {

        String[] data;
        data = new String[3];
        if (this.dataQuitacaoGuiaVinculadaNotaFiscal != null) {
            data[0] = MyUtils.strTamanhoMax(this.dataQuitacaoGuiaVinculadaNotaFiscal[0], 2, "numerico");
            data[1] = MyUtils.strTamanhoMax(this.dataQuitacaoGuiaVinculadaNotaFiscal[1], 2, "numerico");
            data[2] = MyUtils.strTamanhoMax(this.dataQuitacaoGuiaVinculadaNotaFiscal[2], 4, "numerico");
        } else {
            data[0] = MyUtils.strTamanhoMax(null, 2, "texto");
            data[1] = MyUtils.strTamanhoMax(null, 2, "texto");
            data[2] = MyUtils.strTamanhoMax(null, 4, "texto");
        }
        return data;
    }

    public void setDataQuitacaoGuiaVinculadaNotaFiscal(String[] dataQuitacaoGuiaVinculadaNotaFiscal) {
        this.dataQuitacaoGuiaVinculadaNotaFiscal = dataQuitacaoGuiaVinculadaNotaFiscal;
    }

    public String getValorServicosTxt() {
        return MyUtils.strTamanhoMax(this.valorServicos, 15, "numerico");
    }

    public String getValorServicos() {
        if (this.valorServicos == null) {
            return "000";
        }
        return this.valorServicos;
    }

    public void setValorServicos(String valorServicos) {
        this.valorServicos = valorServicos;
    }

    public String getValorDeducoesTxt() {
        return MyUtils.strTamanhoMax(this.valorDeducoes, 15, "numerico");
    }

    public String getValorDeducoes() {
        if (this.valorDeducoes == null) {
            return "000";
        }
        return this.valorDeducoes;
    }

    public void setValorDeducoes(String valorDeducoes) {
        this.valorDeducoes = valorDeducoes;
    }

    public String getCodigoServicoPrestadoNotaFiscalTxt() {
        return MyUtils.strTamanhoMax(this.codigoServicoPrestadoNotaFiscal, 5, "numerico");
    }

    public String getCodigoServicoPrestadoNotaFiscal() {
        if (this.codigoServicoPrestadoNotaFiscal == null) {
            return "";
        }
        return this.codigoServicoPrestadoNotaFiscal;
    }

    public void setCodigoServicoPrestadoNotaFiscal(String codigoServicoPrestadoNotaFiscal) {
        this.codigoServicoPrestadoNotaFiscal = codigoServicoPrestadoNotaFiscal;
    }

    public String getAliquotaTxt() {
        return MyUtils.strTamanhoMax(this.aliquota, 4, "numerico");
    }

    public String getAliquota() {
        if (this.aliquota == null) {
            return "000";
        }
        return this.aliquota;
    }

    public void setAliquota(String aliquota) {
        this.aliquota = aliquota;
    }

    public String getValorIssTxt() {
        return MyUtils.strTamanhoMax(this.valorIss, 15, "numerico");
    }

    public String getValorIss() {
        if (this.valorIss == null) {
            return "000";
        }
        return this.valorIss;
    }

    public void setValorIss(String valorIss) {
        this.valorIss = valorIss;
    }

    public String getValorCreditoTxt() {
        return MyUtils.strTamanhoMax(this.valorCredito, 15, "numerico");
    }

    public String getValorCredito() {
        if (this.valorCredito == null) {
            return "000";
        }
        return this.valorCredito;
    }

    public void setValorCredito(String valorCredito) {
        this.valorCredito = valorCredito;
    }

    public String getIssRetidoTxt() {
        return MyUtils.strTamanhoMax(this.issRetido, 1, "texto");
    }

    public String getIssRetido() {
        if (this.issRetido == null) {
            return "";
        }
        return this.issRetido;
    }

    public void setIssRetido(String issRetido) {
        this.issRetido = issRetido;
    }

    public String getIndicadorCpfCnpjTomadorTxt() {
        return MyUtils.strTamanhoMax(this.indicadorCpfCnpjTomador, 1, "numerico", "3");
    }

    public String getIndicadorCpfCnpjTomador() {
        if (this.indicadorCpfCnpjTomador == null) {
            return "";
        }
        return this.indicadorCpfCnpjTomador;
    }

    public void setIndicadorCpfCnpjTomador(String indicadorCpfCnpjTomador) {
        this.indicadorCpfCnpjTomador = indicadorCpfCnpjTomador;
    }

    public String getCpfCnpjTomadorTxt() {
        return MyUtils.strTamanhoMax(this.cpfCnpjTomador, 14, "numerico");
    }

    public String getCpfCnpjTomador() {
        if (this.cpfCnpjTomador == null) {
            return "";
        }
        return this.cpfCnpjTomador;
    }

    public void setCpfCnpjTomador(String cpfCnpjTomador) {
        if (cpfCnpjTomador != null) {
            if (cpfCnpjTomador.length() == 11) {
                this.setIndicadorCpfCnpjTomador("1");
            } else if (cpfCnpjTomador.length() == 14) {
                this.setIndicadorCpfCnpjTomador("2");
            }
        } else {
            this.setIndicadorCpfCnpjTomador("3");
        }
        this.cpfCnpjTomador = cpfCnpjTomador;
    }

    public String getInscricaoMunicipalTomadorTxt() {
        return MyUtils.strTamanhoMax(this.inscricaoMunicipalTomador, 8, "numerico");
    }

    public String getInscricaoMunicipalTomador() {
        if (this.inscricaoMunicipalTomador == null) {
            return "";
        }
        return this.inscricaoMunicipalTomador;
    }

    public void setInscricaoMunicipalTomador(String inscricaoMunicipalTomador) {
        this.inscricaoMunicipalTomador = inscricaoMunicipalTomador;
    }

    public String getInscricaoEstadualTomadorTxt() {
        return MyUtils.strTamanhoMax(this.inscricaoEstadualTomador, 12, "numerico");
    }

    public String getInscricaoEstadualTomador() {
        if (this.inscricaoEstadualTomador == null) {
            return "";
        }
        return this.inscricaoEstadualTomador;
    }

    public void setInscricaoEstadualTomador(String inscricaoEstadualTomador) {
        this.inscricaoEstadualTomador = inscricaoEstadualTomador;
    }

    public String getRazaoSocialTomadorTxt() {
        return MyUtils.strTamanhoMax(this.razaoSocialTomador, 75, "texto");
    }

    public String getRazaoSocialTomador() {
        if (this.razaoSocialTomador == null) {
            return "";
        }
        return this.razaoSocialTomador;
    }

    public void setRazaoSocialTomador(String razaoSocialTomador) {
        this.razaoSocialTomador = razaoSocialTomador;
    }

    public String getTipoEnderecoTomadorTxt() {
        return MyUtils.strTamanhoMax(this.tipoEnderecoTomador, 3, "texto");
    }

    public String getTipoEnderecoTomador() {
        if (this.tipoEnderecoTomador == null) {
            return "";
        }
        return this.tipoEnderecoTomador;
    }

    public void setTipoEnderecoTomador(String tipoEnderecoTomador) {
        this.tipoEnderecoTomador = tipoEnderecoTomador;
    }

    public String getEnderecoTomadorTxt() {
        return MyUtils.strTamanhoMax(this.enderecoTomador, 50, "texto");
    }

    public String getEnderecoTomador() {
        if (this.enderecoTomador == null) {
            return "";
        }
        return this.enderecoTomador;
    }

    public void setEnderecoTomador(String enderecoTomador) {
        this.enderecoTomador = enderecoTomador;
    }

    public String getNumeroEnderecoTomadorTxt() {
        return MyUtils.strTamanhoMax(this.numeroEnderecoTomador, 10, "texto");
    }

    public String getNumeroEnderecoTomador() {
        if (this.numeroEnderecoTomador == null) {
            return "";
        }
        return this.numeroEnderecoTomador;
    }

    public void setNumeroEnderecoTomador(String numeroEnderecoTomador) {
        this.numeroEnderecoTomador = numeroEnderecoTomador;
    }

    public String getComplementoEnderecoTomadorTxt() {
        return MyUtils.strTamanhoMax(this.complementoEnderecoTomador, 30, "texto");
    }

    public String getComplementoEnderecoTomador() {
        if (this.complementoEnderecoTomador == null) {
            return "";
        }
        return this.complementoEnderecoTomador;
    }

    public void setComplementoEnderecoTomador(String complementoEnderecoTomador) {
        this.complementoEnderecoTomador = complementoEnderecoTomador;
    }

    public String getBairroTomadorTxt() {
        return MyUtils.strTamanhoMax(this.bairroTomador, 30, "texto");
    }

    public String getBairroTomador() {
        if (this.bairroTomador == null) {
            return "";
        }
        return this.bairroTomador;
    }

    public void setBairroTomador(String bairroTomador) {
        this.bairroTomador = bairroTomador;
    }

    public String getCidadeTomadorTxt() {
        return MyUtils.strTamanhoMax(this.cidadeTomador, 50, "texto");
    }

    public String getCidadeTomador() {
        if (this.cidadeTomador == null) {
            return "";
        }
        return this.cidadeTomador;
    }

    public void setCidadeTomador(String cidadeTomador) {
        this.cidadeTomador = cidadeTomador;
    }

    public String getUfTomadorTxt() {
        return MyUtils.strTamanhoMax(this.ufTomador, 2, "texto");
    }

    public String getUfTomador() {
        if (this.ufTomador == null) {
            return "";
        }
        return this.ufTomador;
    }

    public void setUfTomador(String ufTomador) {
        this.ufTomador = ufTomador;
    }

    public String getCepTomadorTxt() {
        return MyUtils.strTamanhoMax(this.cepTomador, 8, "numerico");
    }

    public String getCepTomador() {
        if (this.cepTomador == null) {
            return "";
        }
        return this.cepTomador;
    }

    public void setCepTomador(String cepTomador) {
        this.cepTomador = cepTomador;
    }

    public String getEmailTomadorTxt() {
        return MyUtils.strTamanhoMax(this.emailTomador, 75, "texto");
    }

    public String getEmailTomador() {
        if (this.emailTomador == null) {
            return "";
        }
        return this.emailTomador;
    }

    public void setEmailTomador(String emailTomador) {
        this.emailTomador = emailTomador;
    }

    public String getDiscriminacaoServicos() {
        if (this.discriminacaoServicos == null) {
            return "";
        }
        return discriminacaoServicos;
    }

    public void setDiscriminacaoServicos(String discriminacaoServicos) {
        this.discriminacaoServicos = discriminacaoServicos;
    }

    public String getCpfCnpjIntermediario() {
        if (this.cpfCnpjIntermediario == null) {
            return "";
        }
        return cpfCnpjIntermediario;
    }

    public void setCpfCnpjIntermediario(String cpfCnpjIntermediario) {
        this.cpfCnpjIntermediario = cpfCnpjIntermediario;
    }
}
