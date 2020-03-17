package com.constanzooficial.integracao.model.nfse.sp.cubatao;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("NewDataSet")
public class NewDataSet {
    
    @XStreamAlias("NOTA_FISCAL")
    private NotaFiscal notaFiscal;

    public NotaFiscal getNotaFiscal() {
        return notaFiscal;
    }
    
}
