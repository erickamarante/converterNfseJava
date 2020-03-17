package com.constanzooficial.integracao.model.sp.osasco;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.ArrayList;

/**
 *
 * @author Waislan Luis Sanches
 */
@XStreamAlias("NFE")
public class NFE {
    
    @XStreamImplicit
    private ArrayList <NotaFiscalRelatorioDTO> notasFiscais;

    @XStreamAlias("xmlns")
    @XStreamAsAttribute
    private String xmlns;    
    
    public ArrayList <NotaFiscalRelatorioDTO> getNotasFiscais() {
        return notasFiscais;
    }
    
}
