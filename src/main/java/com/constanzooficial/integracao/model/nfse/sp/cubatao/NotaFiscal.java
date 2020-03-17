package com.constanzooficial.integracao.model.nfse.sp.cubatao;

import com.constanzooficial.integracao.util.MyUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("NOTA_FISCAL")
public class NotaFiscal {
    
    @XStreamAlias("Cae")
    private String cae;
    
    @XStreamAlias("DataEmissao")
    private String dataEmissao;
    
    @XStreamAlias("NaturezaOperacao")
    private String naturezaOperacao;
    
    @XStreamAlias("NumeroNota")
    private String numeroNota;
    
    @XStreamAlias("NumeroRps")
    private String numeroRps;
    
    @XStreamAlias("SituacaoNf")
    private String situacaoNf;
    
    @XStreamAlias("ChaveValidacao")
    private String chaveValidacao;
    
    @XStreamAlias("ClienteNomeRazaoSocial")
    private String clienteNomeRazaoSocial;
    
    @XStreamAlias("ClienteNomeFantasia")
    private String clienteNomeFantasia;
    
    @XStreamAlias("ClienteCNPJCPF")
    private String clienteCNPJCPF;
    
    @XStreamAlias("ClienteEndereco")
    private String clienteEndereco;
    
    @XStreamAlias("ClienteBairro")
    private String clienteBairro;
    
    @XStreamAlias("ClienteNumeroLogradouro")
    private String clienteNumeroLogradouro;
    
    @XStreamAlias("ClienteCidade")
    private String clienteCidade;
    
    @XStreamAlias("ClienteUF")
    private String clienteUF;
    
    @XStreamAlias("ClientePais")
    private String clientePais;
    
    @XStreamAlias("ClienteFone")
    private String clienteFone;
    
    @XStreamAlias("ClienteFax")
    private String clienteFax;
    
    @XStreamAlias("ClienteInscricaoMunicipal")
    private String clienteInscricaoMunicipal;
    
    @XStreamAlias("ClienteCEP")
    private String clienteCEP;
    
    @XStreamAlias("ClienteEmail")
    private String clienteEmail;
    
    @XStreamAlias("ClienteInscricaoEstadual")
    private String clienteInscricaoEstadual;
    
    @XStreamAlias("BaseCalculo")
    private String baseCalculo;
    
    @XStreamAlias("ISSQNCliente")
    private String issQNCliente;
    
    @XStreamAlias("ISSQNSemRetencao")
    private String issQNSemRetencao;
    
    @XStreamAlias("ISSQNTotal")
    private String issQNTotal;
    
    @XStreamAlias("Irrf")
    private String irrf;
    
    @XStreamAlias("Cofins")
    private String cofins;
    
    @XStreamAlias("Inss")
    private String inss;
    
    @XStreamAlias("Csll")
    private String csll;
    
    @XStreamAlias("Pis")
    private String pis;
    
    @XStreamAlias("VlrOutros")
    private String vlrOutros;
    
    @XStreamAlias("ValorTotalNota")
    private String valorTotalNota;
    
    @XStreamAlias("ValorTotalDeducoes")
    private String valorTotalDeducoes;
    
    @XStreamAlias("TotalImpostoAprox")
    private String totalImpostoAprox;
    
    @XStreamAlias("AliquotaImpostoAprox")
    private String aliquotaImpostoAprox;
    
    @XStreamAlias("FonteImpostoAprox")
    private String fonteImpostoAprox;
    
    @XStreamAlias("FreteCNPJ")
    private String freteCNPJ;
    
    @XStreamAlias("FreteRazaoSocial")
    private String freteRazaoSocial;
    
    @XStreamAlias("FreteEndereco")
    private String freteEndereco;
    
    @XStreamAlias("FreteEmitente")
    private String freteEmitente;
    
    @XStreamAlias("FreteDestinatario")
    private String freteDestinatario;
    
    @XStreamAlias("FreteQuantidade")
    private String freteQuantidade;
    
    @XStreamAlias("FreteEspecie")
    private String freteEspecie;
    
    @XStreamAlias("FretePesoLiquido")
    private String fretePesoLiquido;
    
    @XStreamAlias("FretePesoBruto")
    private String fretePesoBruto;
    
    @XStreamAlias("Serie")
    private String serie;
    
    @XStreamAlias("SerieSimplificada")
    private String serieSimplificada;
    
    @XStreamAlias("CodigoSerie")
    private String codigoSerie;
    
    @XStreamAlias("Observacao")
    private String observacao;
    
    @XStreamAlias("ServicoCidade")
    private String servicoCidade;
    
    @XStreamAlias("ServicoEstado")
    private String servicoEstado;
    
    @XStreamAlias("TimbreContribuinteLinha1")
    private String timbreContribuinteLinha1;
    
    @XStreamAlias("TimbreContribuinteLinha2")
    private String timbreContribuinteLinha2;
    
    @XStreamAlias("TimbreContribuinteLinha3")
    private String timbreContribuinteLinha3;
    
    @XStreamAlias("TimbreContribuinteLinha4")
    private String timbreContribuinteLinha4;
    
    @XStreamAlias("TimbrePrefeituraLogo")
    private String timbrePrefeituraLogo;
    
    @XStreamAlias("TimbrePrefeituraLinha1")
    private String timbrePrefeituraLinha1;
    
    @XStreamAlias("TimbrePrefeituraLinha2")
    private String timbrePrefeituraLinha2;
    
    @XStreamAlias("TimbrePrefeituraLinha3")
    private String timbrePrefeituraLinha3;
    
    @XStreamAlias("ITENS")
    private Itens itens;

    public String getCae() {
        return cae;
    }

    public String[] getDataEmissao() {
        String[] dataHora = MyUtils.trataDataHora4(dataEmissao);
        
        return dataHora;
    }

    public String getNaturezaOperacao() {
        return naturezaOperacao;
    }

    public String getNumeroNota() {
        return numeroNota;
    }

    public String getNumeroRps() {
        return numeroRps;
    }

    public String getSituacaoNf() {
        return situacaoNf;
    }

    public String getChaveValidacao() {
        return chaveValidacao;
    }

    public String getClienteNomeRazaoSocial() {
        return clienteNomeRazaoSocial;
    }

    public String getClienteNomeFantasia() {
        return clienteNomeFantasia;
    }

    public String getClienteCNPJCPF() {
        return clienteCNPJCPF.replaceAll("[^0-9]", "");
    }

    public String getClienteEndereco() {
        return clienteEndereco;
    }

    public String getClienteBairro() {
        return clienteBairro;
    }

    public String getClienteNumeroLogradouro() {
        return clienteNumeroLogradouro;
    }

    public String getClienteCidade() {
        return clienteCidade;
    }

    public String getClienteUF() {
        return clienteUF;
    }

    public String getClientePais() {
        return clientePais;
    }

    public String getClienteFone() {
        return clienteFone;
    }

    public String getClienteFax() {
        return clienteFax;
    }

    public String getClienteInscricaoMunicipal() {
        return clienteInscricaoMunicipal;
    }

    public String getClienteCEP() {
        return clienteCEP;
    }

    public String getClienteEmail() {
        return clienteEmail;
    }

    public String getClienteInscricaoEstadual() {
        return clienteInscricaoEstadual;
    }

    public String getBaseCalculo() {
        return baseCalculo;
    }

    public String getIssQNCliente() {
        return issQNCliente;
    }

    public String getIssQNSemRetencao() {
        return issQNSemRetencao;
    }

    public String getIssQNTotal() {
        return issQNTotal;
    }

    public String getIrrf() {
        return irrf;
    }

    public String getCofins() {
        return cofins;
    }

    public String getInss() {
        return inss;
    }

    public String getCsll() {
        return csll;
    }

    public String getPis() {
        return pis;
    }

    public String getVlrOutros() {
        return vlrOutros;
    }

    public String getValorTotalNota() {
        return valorTotalNota;
    }

    public String getValorTotalDeducoes() {
        return valorTotalDeducoes;
    }

    public String getTotalImpostoAprox() {
        return totalImpostoAprox;
    }

    public String getAliquotaImpostoAprox() {
        return aliquotaImpostoAprox;
    }

    public String getFonteImpostoAprox() {
        return fonteImpostoAprox;
    }

    public String getFreteCNPJ() {
        return freteCNPJ;
    }

    public String getFreteRazaoSocial() {
        return freteRazaoSocial;
    }

    public String getFreteEndereco() {
        return freteEndereco;
    }

    public String getFreteEmitente() {
        return freteEmitente;
    }

    public String getFreteDestinatario() {
        return freteDestinatario;
    }

    public String getFreteQuantidade() {
        return freteQuantidade;
    }

    public String getFreteEspecie() {
        return freteEspecie;
    }

    public String getFretePesoLiquido() {
        return fretePesoLiquido;
    }

    public String getFretePesoBruto() {
        return fretePesoBruto;
    }

    public String getSerie() {
        return serie;
    }

    public String getSerieSimplificada() {
        return serieSimplificada;
    }

    public String getCodigoSerie() {
        return codigoSerie;
    }

    public String getObservacao() {
        return observacao;
    }

    public String getServicoCidade() {
        return servicoCidade;
    }

    public String getServicoEstado() {
        return servicoEstado;
    }

    public String getTimbreContribuinteLinha1() {
        return timbreContribuinteLinha1;
    }

    public String getTimbreContribuinteLinha2() {
        return timbreContribuinteLinha2;
    }

    public String getTimbreContribuinteLinha3() {
        return timbreContribuinteLinha3;
    }

    public String getTimbreContribuinteLinha4() {
        return timbreContribuinteLinha4;
    }

    public String getTimbrePrefeituraLogo() {
        return timbrePrefeituraLogo;
    }

    public String getTimbrePrefeituraLinha1() {
        return timbrePrefeituraLinha1;
    }

    public String getTimbrePrefeituraLinha2() {
        return timbrePrefeituraLinha2;
    }

    public String getTimbrePrefeituraLinha3() {
        return timbrePrefeituraLinha3;
    }

    public Itens getItens() {
        return itens;
    }
    
    public String getCpfCnpjPrestador(){
        String cpfCnpjPrestador = MyUtils.trataCpfCnpj2(timbreContribuinteLinha4);
        
        return cpfCnpjPrestador;
    }
    
}
