package com.constanzooficial.integracao.model.nfse.df.brasilia;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.ArrayList;

/**
 *
 * @author Waislan Sanches
 */
@XStreamAlias("infNFe")
public class InfNFe {
    
    @XStreamAlias("Id")
    @XStreamAsAttribute
    private String id;
    
    @XStreamAlias("versao")
    @XStreamAsAttribute
    private String versao;
    
    @XStreamAlias("ide")
    private Ide ide;
    
    @XStreamAlias("emit")
    private Emit emit;
    
    @XStreamAlias("dest")
    private Dest dest;
    
    @XStreamAlias("det")
    @XStreamImplicit
    private ArrayList<Det> det;
    
    @XStreamAlias("CST")
    private String cst;
    
    @XStreamAlias("vBC")
    private String vBc;
    
    @XStreamAlias("pPIS")
    private String pPis;
    
    @XStreamAlias("total")
    private Total total;
    
    @XStreamAlias("transp")
    private Transp transp;
    
    @XStreamAlias("pag")
    private Pag pag;
    
    @XStreamAlias("infAdic")
    private InfAdic infAdic;

    public String getId() {
        return id;
    }

    public String getVersao() {
        return versao;
    }

    public Ide getIde() {
        return ide;
    }

    public Emit getEmit() {
        return emit;
    }

    public Dest getDest() {
        return dest;
    }

    public ArrayList<Det> getDet() {
        return det;
    }

    public String getCst() {
        return cst;
    }

    public String getvBc() {
        return vBc;
    }

    public String getpPis() {
        return pPis;
    }

    public Total getTotal() {
        return total;
    }

    public Transp getTransp() {
        return transp;
    }

    public Pag getPag() {
        return pag;
    }

    public InfAdic getInfAdic() {
        return infAdic;
    }

}
