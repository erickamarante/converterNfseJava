package com.constanzooficial.integracao.model.nfse.pi.saoRaimundoNonato;

import com.constanzooficial.integracao.util.MyUtils;
import static com.constanzooficial.integracao.util.MyUtils.trataCpf;
import static com.constanzooficial.integracao.util.MyUtils.trataDataHora5;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("nfse")
public class Nfse {
    
    @XStreamAlias("numero")
    private String numero;
    
    @XStreamAlias("cpfTomador")
    private String cpfTomador;
    
    @XStreamAlias("nomeTomador")
    private String nomeTomador;
    
    @XStreamAlias("dataEmissao")
    private String dataEmissao;
    
    @XStreamAlias("numeroDesconhecido")
    private String numeroDesconhecido;
    
    @XStreamAlias("valorDesconhecido")
    private String valorDesconhecido;
    
    @XStreamAlias("valorServico")
    private String valorServico;
    
    @XStreamAlias("valorDesconhecido2")
    private String valorDesconhecido2;
    
    @XStreamAlias("situacao")
    private String situacao;
    
    @XStreamAlias("campoDesconhecido")
    private String campoDesconhecido;

    public String getNumero() {
        return numero;
    }

    public String getCpfTomador() {
        String retorno = trataCpf(cpfTomador);
        return retorno;
    }

    public String getNomeTomador() {
        return nomeTomador;
    }

    public String[] getDataEmissao() {
        // formato: DD/MM/AA HH:MM
        String[] retorno = trataDataHora5(dataEmissao);
        return retorno;
    }

    public String getNumeroDesconhecido() {
        return numeroDesconhecido.replaceAll("[^0-9]", "").substring(0, 5);
    }
    
    public String getValorDesconhecido() {
        return valorDesconhecido;
    }

    public String getValorServico() {
        valorServico = valorServico.replace(".", "");
        valorServico = valorServico.replace(",", ".");

        return valorServico;
    }

    public String getValorDesconhecido2() {
        return valorDesconhecido2;
    }

    public String getSituacao() {
        return situacao;
    }  

    public String getCampoDesconhecido() {
        return campoDesconhecido;
    }
    
}
