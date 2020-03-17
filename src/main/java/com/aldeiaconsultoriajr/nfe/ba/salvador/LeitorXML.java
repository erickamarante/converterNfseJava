package com.aldeiaconsultoriajr.nfe.ba.salvador;

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

    public ConsultarNfseResposta lerXML(String path) throws FileNotFoundException {

        XStream xstream = new XStream();
        xstream.autodetectAnnotations(true);
        InputStream is = new FileInputStream(new File(path));
        xstream.alias("ConsultarNfseResposta", ConsultarNfseResposta.class);
        ConsultarNfseResposta retorno = (ConsultarNfseResposta) xstream.fromXML(is);

        return retorno;
    }
}
