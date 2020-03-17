package com.aldeiaconsultoriajr.nfe.pr.ibaiti;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("servico")
public class Servico {
    
    private String nrServico;
    private String dsDiscriminacaoServico;
    private String vlAliquota;
    private String vlDeducao;
    private String vlServico;

    public String getNrServico() {
        return nrServico;
    }

    public String getDsDiscriminacaoServico() {
        return dsDiscriminacaoServico;
    }

    public String getVlAliquota() {
        return vlAliquota;
    }

    public String getVlDeducao() {
        return vlDeducao;
    }

    public String getVlServico() {
        return vlServico;
    }
}
