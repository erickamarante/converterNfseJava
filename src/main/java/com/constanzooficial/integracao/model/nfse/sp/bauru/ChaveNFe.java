package com.constanzooficial.integracao.model.nfse.sp.bauru;

import com.constanzooficial.integracao.util.MyUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("ChaveNFe")
public class ChaveNFe {
    @XStreamAlias("NumeroNFe")
    private String numeroNFe;
    
    @XStreamAlias("SerieNFe")
    private String serieNFe;
    
    @XStreamAlias("CodigoVerificacao")
    private String codigoVerificacao;
    
    @XStreamAlias("DataEmissaoNFe")
    private String dataEmissaoNFe;

    public String getNumeroNFe() {
        return numeroNFe;
    }

    public String getSerieNFe() {
        return serieNFe;
    }

    public String getCodigoVerificacao() {
        return codigoVerificacao;
    }

    public String[] getDataEmissaoNFe() {
        String[] dataHora = MyUtils.trataData2(dataEmissaoNFe);
        
        return dataHora;
    }
}
