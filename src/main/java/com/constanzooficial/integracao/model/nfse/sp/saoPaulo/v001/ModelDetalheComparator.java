package com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001;

import java.util.Comparator;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
public class ModelDetalheComparator implements Comparator {

    @Override
    public int compare(Object t, Object t1) {

        ModelDetalhe d1 = (ModelDetalhe) t;
        ModelDetalhe d2 = (ModelDetalhe) t1;

        // Comparação pelo ano
        if (Integer.parseInt(d1.getDataHoraNfse()[2]) > Integer.parseInt(d2.getDataHoraNfse()[2])) {
            return 1;
        } else if (Integer.parseInt(d1.getDataHoraNfse()[2]) < Integer.parseInt(d2.getDataHoraNfse()[2])) {
            return -1;
        } else {

            // Comparação pelo mês
            if (Integer.parseInt(d1.getDataHoraNfse()[1]) > Integer.parseInt(d2.getDataHoraNfse()[1])) {
                return 1;
            } else if (Integer.parseInt(d1.getDataHoraNfse()[1]) < Integer.parseInt(d2.getDataHoraNfse()[1])) {
                return -1;
            } else {

                // Comparação pelo dia
                if (Integer.parseInt(d1.getDataHoraNfse()[0]) > Integer.parseInt(d2.getDataHoraNfse()[0])) {
                    return 1;
                } else if (Integer.parseInt(d1.getDataHoraNfse()[0]) < Integer.parseInt(d2.getDataHoraNfse()[0])) {
                    return -1;
                } else {

                    // Comparação pela hora
                    if (Integer.parseInt(d1.getDataHoraNfse()[3]) > Integer.parseInt(d2.getDataHoraNfse()[3])) {
                        return 1;
                    } else if (Integer.parseInt(d1.getDataHoraNfse()[3]) < Integer.parseInt(d2.getDataHoraNfse()[3])) {
                        return -1;
                    } else {

                        // Comparação pelo minuto
                        if (Integer.parseInt(d1.getDataHoraNfse()[4]) > Integer.parseInt(d2.getDataHoraNfse()[4])) {
                            return 1;
                        } else if (Integer.parseInt(d1.getDataHoraNfse()[4]) < Integer.parseInt(d2.getDataHoraNfse()[4])) {
                            return -1;
                        } else {

                            // Comparação pelo segundo
                            if (Integer.parseInt(d1.getDataHoraNfse()[5]) > Integer.parseInt(d2.getDataHoraNfse()[5])) {
                                return 1;
                            } else if (Integer.parseInt(d1.getDataHoraNfse()[5]) < Integer.parseInt(d2.getDataHoraNfse()[5])) {
                                return -1;
                            } else {
                                return 0;
                            }
                        }
                    }
                }
            }
        }
    }

}
