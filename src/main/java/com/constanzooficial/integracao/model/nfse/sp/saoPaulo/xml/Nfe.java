package com.constanzooficial.integracao.model.nfse.sp.saoPaulo.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("NFe")
public class Nfe {

    @XStreamAlias("")
    @XStreamAsAttribute
    private String xmlns;

    @XStreamAlias("Assinatura")
    private String assinatura;

    @XStreamAlias("ChaveNFe")
    private ChaveNfe chaveNfe;

    @XStreamAlias("DataEmissaoNFe")
    private String dataEmissaoNFe;

    @XStreamAlias("NumeroLote")
    private String numeroLote;

    @XStreamAlias("ChaveRPS")
    private ChaveRPS chaveRPS;

    @XStreamAlias("TipoRPS")
    private String tipoRPS;

    @XStreamAlias("DataEmissaoRPS")
    private String dataEmissaoRPS;

    @XStreamAlias("CPFCNPJPrestador")
    private CpfCnpjPrestador cpfCnpjPrestador;

    @XStreamAlias("RazaoSocialPrestador")
    private String razaoSocialPrestador;

    @XStreamAlias("EnderecoPrestador")
    private EnderecoPrestador enderecoPrestador;

    @XStreamAlias("EmailPrestador")
    private String emailPrestador;

    @XStreamAlias("StatusNFe")
    private String statusNFe;

    @XStreamAlias("DataCancelamento")
    private String dataCancelamento;

    @XStreamAlias("TributacaoNFe")
    private String tributacaoNFe;

    @XStreamAlias("OpcaoSimples")
    private String opcaoSimples;

    @XStreamAlias("NumeroGuia")
    private String numeroGuia;

    @XStreamAlias("DataQuitacaoGuia")
    private String dataQuitacaoGuia;

    @XStreamAlias("ValorServicos")
    private String valorServicos;

    @XStreamAlias("ValorDeducoes")
    private String valorDeducoes;

    @XStreamAlias("ValorPIS")
    private String valorPIS;

    @XStreamAlias("ValorCOFINS")
    private String valorCOFINS;
    
    @XStreamAlias("ValorINSS")
    private String valorInss;

    @XStreamAlias("ValorIR")
    private String valorIR;

    @XStreamAlias("ValorCSLL")
    private String valorCSLL;

    @XStreamAlias("CodigoServico")
    private String codigoServico;

    @XStreamAlias("AliquotaServicos")
    private String aliquotaServicos;

    @XStreamAlias("ValorISS")
    private String valorISS;

    @XStreamAlias("ValorCredito")
    private String valorCredito;

    @XStreamAlias("ISSRetido")
    private String issRetido;

    @XStreamAlias("CPFCNPJTomador")
    private CpfCnpjTomador cpfCnpjTomador;
    
    @XStreamAlias("InscricaoMunicipalTomador")
    private String inscricaoMunicipalTomador;

    @XStreamAlias("RazaoSocialTomador")
    private String razaoSocialTomador;

    @XStreamAlias("EnderecoTomador")
    private EnderecoTomador enderecoTomador;

    @XStreamAlias("EmailTomador")
    private String emailTomador;

    @XStreamAlias("Discriminacao")
    private String discriminacao;

    @XStreamAlias("ValorCargaTributaria")
    private String valorCargaTributaria;

    @XStreamAlias("PercentualCargaTributaria")
    private String percentualCargaTributaria;

    @XStreamAlias("FonteCargaTributaria")
    private String fonteCargaTributaria;

    @XStreamAlias("MunicipioPrestacao")
    private String municipioPrestacao;

    @XStreamAlias("CPFCNPJIntermediario")
    private String cpfCnpjIntermediario;

    @XStreamAlias("ISSRetidoIntermediario")
    private String issRetidoIntermediario;

    @XStreamAlias("EmailIntermediario")
    private String emailIntermediario;

    public String getXmlns() {
        return xmlns;
    }

    public ChaveNfe getChaveNfe() {
        return chaveNfe;
    }

    public String getDataEmissaoNFe() {
        return dataEmissaoNFe;
    }

    public CpfCnpjPrestador getCpfCnpjPrestador() {
        return cpfCnpjPrestador;
    }

    public String getRazaoSocialPrestador() {
        return razaoSocialPrestador;
    }

    public EnderecoPrestador getEnderecoPrestador() {
        return enderecoPrestador;
    }

    public String getStatusNFe() {
        return statusNFe;
    }

    public String getTributacaoNFe() {
        return tributacaoNFe;
    }

    public String getOpcaoSimples() {
        return opcaoSimples;
    }

    public String getValorServicos() {
        return valorServicos;
    }

    public String getCodigoServico() {
        return codigoServico;
    }

    public String getAliquotaServicos() {
        return aliquotaServicos;
    }

    public String getValorISS() {
        return valorISS;
    }

    public String getValorCredito() {
        return valorCredito;
    }

    public String getIssRetido() {
        return issRetido;
    }

    public CpfCnpjTomador getCpfCnpjTomador() {
        return cpfCnpjTomador;
    }

    public String getRazaoSocialTomador() {
        return razaoSocialTomador;
    }

    public EnderecoTomador getEnderecoTomador() {
        return enderecoTomador;
    }

    public String getEmailTomador() {
        return emailTomador;
    }

    public String getDiscriminacao() {
        return discriminacao;
    }

    public String getFonteCargaTributaria() {
        return fonteCargaTributaria;
    }

    public String getEmailPrestador() {
        return emailPrestador;
    }

    public String getAssinatura() {
        return assinatura;
    }

    public String getNumeroLote() {
        return numeroLote;
    }

    public ChaveRPS getChaveRPS() {
        return chaveRPS;
    }

    public String getTipoRPS() {
        return tipoRPS;
    }

    public String getDataEmissaoRPS() {
        return dataEmissaoRPS;
    }

    public String getDataCancelamento() {
        return dataCancelamento;
    }

    public String getNumeroGuia() {
        return numeroGuia;
    }

    public String getDataQuitacaoGuia() {
        return dataQuitacaoGuia;
    }

    public String getValorDeducoes() {
        return valorDeducoes;
    }

    public String getValorPIS() {
        return valorPIS;
    }

    public String getValorCOFINS() {
        return valorCOFINS;
    }

    public String getValorIR() {
        return valorIR;
    }

    public String getValorCSLL() {
        return valorCSLL;
    }

    public String getValorCargaTributaria() {
        return valorCargaTributaria;
    }

    public String getPercentualCargaTributaria() {
        return percentualCargaTributaria;
    }

    public String getMunicipioPrestacao() {
        return municipioPrestacao;
    }

    public String getCpfCnpjIntermediario() {
        return cpfCnpjIntermediario;
    }

    public String getIssRetidoIntermediario() {
        return issRetidoIntermediario;
    }

    public String getEmailIntermediario() {
        return emailIntermediario;
    }

    public String getValorInss() {
        return valorInss;
    }

    public String getInscricaoMunicipalTomador() {
        return inscricaoMunicipalTomador;
    }
}
