package com.aldeiaconsultoriajr.nfe.pr.ibaiti;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.ArrayList;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("listaNfs")
public class ListaNfs {
    
    @XStreamAsAttribute
    private String xmlns;
    
    @XStreamImplicit
    private ArrayList<Nfs> nfs;

    public String getXmlns() {
        return xmlns;
    }

    public ArrayList<Nfs> getNfs() {
        return nfs;
    }
    
}
