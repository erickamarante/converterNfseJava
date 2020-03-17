package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("soap:Body")
public class SoapBody {
    
    @XStreamAlias("nfeResultMsg")
    private NfeResultMsg nfeResultMsg;

    public NfeResultMsg getNfeResultMsg() {
        return nfeResultMsg;
    }
}
