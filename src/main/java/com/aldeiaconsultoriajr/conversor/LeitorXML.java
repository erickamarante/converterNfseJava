package com.aldeiaconsultoriajr.conversor;

import com.aldeiaconsultoriajr.nfe.rs.canoas.ConsultarNfseLote;
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
    
    public ConsultarNfseLote lerXML(String path) throws FileNotFoundException {
        
        XStream xstream = new XStream();
        xstream.autodetectAnnotations(true);
        InputStream is = new FileInputStream(new File(path));
        xstream.alias("ConsultarNfseLote", ConsultarNfseLote.class);
        ConsultarNfseLote retorno = (ConsultarNfseLote)xstream.fromXML(is);
        
        return retorno;
    }
}
