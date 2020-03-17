package com.constanzooficial.integracao.model.nfse.sp.barueri;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("InfDeclaracaoPrestacaoServico")
public class InfDeclaracaoPrestacaoServico {

    @XStreamAlias("Id")
    @XStreamAsAttribute
    private String id;
    
    @XStreamAlias("Competencia")
    private String competencia;
    
    @XStreamAlias("Servico")
    private Servico servico;
    
    @XStreamAlias("Tomador")
    private Tomador tomador;
    
    @XStreamAlias("OptanteSimplesNacional")
    private String optanteSimplesNacional;
    
    @XStreamAlias("IncentivoFiscal")
    private String incentivoFiscal;

    public String getCompetencia() {
        return competencia;
    }

    public Servico getServico() {
        return servico;
    }

    public Tomador getTomador() {
        return tomador;
    }

    public boolean getOptanteSimplesNacional() {
        return !"2".equals(optanteSimplesNacional);
    }

    public String getIncentivoFiscal() {
        return incentivoFiscal;
    }

    public String getId() {
        return id;
    }
}
