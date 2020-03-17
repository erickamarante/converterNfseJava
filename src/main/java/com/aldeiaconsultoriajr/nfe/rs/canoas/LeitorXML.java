package com.aldeiaconsultoriajr.nfe.rs.canoas;

import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
public class LeitorXML {
    
    public ArrayList<CompNfse> lerXML(File folder) throws FileNotFoundException {

        ArrayList<CompNfse> retorno = new ArrayList<>();

        for (File file : folder.listFiles()) {
            
            XStream xstream = new XStream();
            xstream.autodetectAnnotations(true);
            InputStream is = new FileInputStream(new File(file.getAbsolutePath()));
            xstream.alias("ConsultarNfseLote", ConsultarNfseLote.class);
            ConsultarNfseLote consultarNfseLote = (ConsultarNfseLote)xstream.fromXML(is);
            
            for (CompNfse comp : consultarNfseLote.getListaNfse()) {
                retorno.add(comp);
            }
            
        }
        return retorno;
    }
}
