package com.aldeiaconsultoriajr.nfe.pr.ibaiti;

import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
public class LeitorXML {
    
    public ListaNfs lerXML(String path) throws FileNotFoundException {
        
        XStream xstream = new XStream();
        xstream.autodetectAnnotations(true);
        InputStream is = new FileInputStream(new File(path));
        xstream.alias("listaNfs", ListaNfs.class);
        ListaNfs retorno = (ListaNfs)xstream.fromXML(is);
        
        return retorno;
    }
}
