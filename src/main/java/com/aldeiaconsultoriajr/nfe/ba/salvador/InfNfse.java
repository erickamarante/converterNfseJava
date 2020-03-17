package com.aldeiaconsultoriajr.nfe.ba.salvador;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("InfNfse")
public class InfNfse {
    
    @XStreamAlias("Numero")
    private String numero;
    @XStreamAlias("CodigoVerificacao")
    private String codigoVerificacao;
    @XStreamAlias("DataEmissao")
    private String dataEmissao;
    @XStreamAlias("IdentificacaoRps")
    private IdentificacaoRps identificacaoRps;
    @XStreamAlias("NaturezaOperacao")
    private String naturezaOperacao;
    @XStreamAlias("OptanteSimplesNacional")
    private String optanteSimplesNacional;
    @XStreamAlias("Competencia")
    private String competencia;
    @XStreamAlias("NfseSubstituida")
    private String NfseSubstituida;
    @XStreamAlias("OutrasInformacoes")
    private String outrasInformacoes;
    @XStreamAlias("Servico")
    private Servico servico;
    @XStreamAlias("PrestadorServico")
    private PrestadorServico prestadorServico;
    @XStreamAlias("TomadorServico")
    private TomadorServico tomadorServico;
    @XStreamAlias("OrgaoGerador")
    private OrgaoGerador orgaoGerador;
    @XStreamAlias("ContrucaoCivil")
    private ContrucaoCivil contrucaoCivil;
    
    public String getNumero() {
        return numero;
    }
    
    public String getCodigoVerificacao() {
        return codigoVerificacao;
    }

    /**
     *
     * @return retorno[0]: ano; retorno[1]: mes; retorno[2]: dia; retorno[3]:
     * hora; retorno[4]: minuto; retorno[5]: segundo.
     */
    public String[] getDataEmissao() {
        
        String[] retorno = new String[6];
        
        String[] split = dataEmissao.split("-");
        retorno[0] = split[0];
        retorno[1] = split[1];
        split = split[2].split("T");
        retorno[2] = split[0];
        split = split[1].split(":");
        retorno[3] = split[0];
        retorno[4] = split[1];
        retorno[5] = split[2];
        
        return retorno;
    }
    
    public IdentificacaoRps getIdentificacaoRps() {
        return identificacaoRps;
    }
    
    public String getNaturezaOperacao() {
        return naturezaOperacao;
    }
    
    public String getOptanteSimplesNacional() {
        return optanteSimplesNacional;
    }
    
    public String getCompetencia() {
        return competencia;
    }
    
    public boolean getNfseSubstituida() {
        return NfseSubstituida.equals("1");
    }
    
    public String getOutrasInformacoes() {
        return outrasInformacoes;
    }
    
    public Servico getServico() {
        return servico;
    }
    
    public PrestadorServico getPrestadorServico() {
        return prestadorServico;
    }
    
    public TomadorServico getTomadorServico() {
        return tomadorServico;
    }
    
    public OrgaoGerador getOrgaoGerador() {
        return orgaoGerador;
    }
    
    public ContrucaoCivil getContrucaoCivil() {
        return contrucaoCivil;
    }
    
}
