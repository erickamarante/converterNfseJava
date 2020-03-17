package com.constanzooficial.integracao.model.nfse.go.rioVerde;

import com.aldeiaconsultoriajr.util.MyUtils;
import static com.aldeiaconsultoriajr.util.MyUtils.trataCnpj;
import static com.constanzooficial.integracao.util.MyUtils.trataCpf;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("CnpfCnpj")
public class CpfCnpj {
    
    @XStreamAlias("Cnpj")
    private String cnpj;
    
    @XStreamAlias("Cpf")
    private String cpf;

    public String getCnpj() {
        
        String retorno = trataCnpj(cnpj);
        
        return retorno;
    }

    public String getCpf() {
        
        String retorno = trataCpf(cpf);
        
        return retorno;
    }
    
}
