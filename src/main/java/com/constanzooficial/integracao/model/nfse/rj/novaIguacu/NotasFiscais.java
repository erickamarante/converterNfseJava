package com.constanzooficial.integracao.model.nfse.rj.novaIguacu;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.ArrayList;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("NOTAS_FISCAIS")
public class NotasFiscais {
    
    @XStreamImplicit
    private ArrayList<NotaFiscal> notasFiscais;

    public ArrayList<NotaFiscal> getNotasFiscais() {
        return notasFiscais;
    }
}
