package com.aldeiaconsultoriajr.nfe.ba.salvador;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("Confirmacao")
class Confirmacao {

    @XStreamAlias("DataHoraCancelamento")
    private String dataHoraCancelamento;

    public String[] getDataHoraCancelamento() {

        String[] retorno = new String[6];

        String[] split = dataHoraCancelamento.split("-");
        retorno[0] = split[0];
        retorno[1] = split[1];
        split = split[2].split("T");
        retorno[2] = split[0];
        split = split[1].split(":");
        retorno[3] = split[0];
        retorno[4] = split[1];
        retorno[5] = split[2];

        return retorno;
    }
}
