package com.aldeiaconsultoriajr.nfe.es.vilaVelha;

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

    public ConsultarNfseFaixaResposta lerXML(String path) throws FileNotFoundException {

        XStream xstream = new XStream();
        xstream.autodetectAnnotations(true);
        InputStream is = new FileInputStream(new File(path));
        xstream.alias("ConsultarNfseFaixaResposta", ConsultarNfseFaixaResposta.class);
        ConsultarNfseFaixaResposta retorno = (ConsultarNfseFaixaResposta) xstream.fromXML(is);

        return retorno;
    }
}
