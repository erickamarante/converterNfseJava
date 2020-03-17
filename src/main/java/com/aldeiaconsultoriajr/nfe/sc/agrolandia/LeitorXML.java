package com.aldeiaconsultoriajr.nfe.sc.agrolandia;

import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
public class LeitorXML {

    public ArrayList<Nfse> lerXMLs(File folder) throws IOException {

        ArrayList<Nfse> retorno = new ArrayList<>();

        for (File file : folder.listFiles()) {
            XStream xstream = new XStream();
            xstream.autodetectAnnotations(true);
            try (InputStream is = new FileInputStream(file)) {
                xstream.alias("nfse", Nfse.class);
                Nfse nfse = (Nfse) xstream.fromXML(is);
                retorno.add(nfse);
            }
        }
        return retorno;
    }
}
