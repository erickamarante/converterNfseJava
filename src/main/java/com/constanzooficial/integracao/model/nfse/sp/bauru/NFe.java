package com.constanzooficial.integracao.model.nfse.sp.bauru;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("NFe")
public class NFe {
    @XStreamAlias("Prefeitura")
    private String prefeitura;
    
    @XStreamAlias("InscricaoPrestador")
    private String inscricaoPrestador;
    
    @XStreamAlias("IEPrestador")
    private String iePrestador;
    
    @XStreamAlias("CPFCNPJPrestador")
    private CPFCNPJPrestador cpfCnpjPrestador;
    
    @XStreamAlias("ChaveNFe")
    private ChaveNFe chaveNFe;
    
    @XStreamAlias("RazaoSocialPrestador")
    private String razaoSocialPrestador;
    
    @XStreamAlias("EnderecoPrestador")
    private EnderecoPrestador enderecoPrestador;
    
    @XStreamAlias("TelefonePrestador")
    private String telefonePrestador;
    
    @XStreamAlias("EmailPrestador")
    private String emailPrestador;
    
    @XStreamAlias("StatusNFe")
    private String statusNFe;
    
    @XStreamAlias("TributacaoNFe")
    private String tributacaoNFe;
    
    @XStreamAlias("OpcaoSimples")
    private String opcaoSimples;
    
    @XStreamAlias("ValorServicos")
    private String valorServicos;
    
    @XStreamAlias("ValorBase")
    private String valorBase;
    
    @XStreamAlias("CodigoServico")
    private String codigoServico;
    
    @XStreamAlias("AliquotaServicos")
    private String aliquotaServicos;
    
    @XStreamAlias("ValorINSS")
    private String valorINSS;
    
    @XStreamAlias("ValorIR")
    private String valorIR;
    
    @XStreamAlias("ValorPIS")
    private String valorPIS;
    
    @XStreamAlias("ValorCOFINS")
    private String valorCOFINS;
    
    @XStreamAlias("ValorCSLL")
    private String valorCSLL;
    
    @XStreamAlias("ValorISS")
    private String valorISS;
    
    @XStreamAlias("ValorISSFora")
    private String valorISSFora;
    
    @XStreamAlias("ISSRetido")
    private String issRetido;
    
    @XStreamAlias("InscricaoTomador")
    private String inscricaoTomador;
    
    @XStreamAlias("CPFCNPJTomador")
    private CPFCNPJTomador cpfCnpjTomador;
    
    @XStreamAlias("IETomador")
    private String ieTomador;
    
    @XStreamAlias("RazaoSocialTomador")
    private String razaoSocialTomador;
    
    @XStreamAlias("EnderecoTomador")
    private EnderecoTomador enderecoTomador;
    
    @XStreamAlias("LocalServico")
    private LocalServico localServico;
    
    @XStreamAlias("TelefoneTomador")
    private String telefoneTomador;
    
    @XStreamAlias("EmailTomador")
    private String emailTomador;
    
    @XStreamAlias("Discriminacao")
    private String discriminacao;
    
    @XStreamAlias("ServicoExportacao")
    private String servicoExportacao;

    public String getPrefeitura() {
        return prefeitura;
    }

    public String getInscricaoPrestador() {
        return inscricaoPrestador;
    }

    public String getIePrestador() {
        return iePrestador;
    }

    public CPFCNPJPrestador getCpfCnpjPrestador() {
        return cpfCnpjPrestador;
    }

    public ChaveNFe getChaveNFe() {
        return chaveNFe;
    }

    public String getRazaoSocialPrestador() {
        return razaoSocialPrestador;
    }

    public EnderecoPrestador getEnderecoPrestador() {
        return enderecoPrestador;
    }

    public String getTelefonePrestador() {
        return telefonePrestador;
    }

    public String getEmailPrestador() {
        return emailPrestador;
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

    public String getValorBase() {
        return valorBase;
    }

    public String getCodigoServico() {
        return codigoServico;
    }

    public String getAliquotaServicos() {
        return aliquotaServicos;
    }

    public String getValorINSS() {
        return valorINSS;
    }

    public String getValorIR() {
        return valorIR;
    }

    public String getValorPIS() {
        return valorPIS;
    }

    public String getValorCOFINS() {
        return valorCOFINS;
    }

    public String getValorCSLL() {
        return valorCSLL;
    }

    public String getValorISS() {
        return valorISS;
    }

    public String getValorISSFora() {
        return valorISSFora;
    }

    public String getIssRetido() {
        return issRetido;
    }

    public String getInscricaoTomador() {
        return inscricaoTomador;
    }

    public CPFCNPJTomador getCpfCnpjTomador() {
        return cpfCnpjTomador;
    }

    public String getIeTomador() {
        return ieTomador;
    }

    public String getRazaoSocialTomador() {
        return razaoSocialTomador;
    }

    public EnderecoTomador getEnderecoTomador() {
        return enderecoTomador;
    }

    public LocalServico getLocalServico() {
        return localServico;
    }

    public String getTelefoneTomador() {
        return telefoneTomador;
    }

    public String getEmailTomador() {
        return emailTomador;
    }

    public String getDiscriminacao() {
        return discriminacao;
    }

    public String getServicoExportacao() {
        return servicoExportacao;
    }
}
