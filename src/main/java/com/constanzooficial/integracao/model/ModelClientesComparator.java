package com.constanzooficial.integracao.model;

import java.util.Comparator;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
public class ModelClientesComparator implements Comparator {

    @Override
    public int compare(Object t, Object t1) {

        ModelClientes c1 = (ModelClientes) t;
        ModelClientes c2 = (ModelClientes) t1;
        
        double cnpj1 = Double.parseDouble(c1.getCpfCnpj());
        double cnpj2 = Double.parseDouble(c2.getCpfCnpj());
        double im1 = 0, im2 = 0;

        if (c1.getInscricaoMunicipal() != null && c2.getInscricaoMunicipal() != null) {
            im1 = Double.parseDouble(c1.getInscricaoMunicipal());
            im2 = Double.parseDouble(c1.getInscricaoMunicipal());
        }

        if (cnpj1 > cnpj2) {
            return 1;
        } else if (cnpj1 < cnpj2) {
            return -1;
        } else {

            if (c1.getInscricaoMunicipal() != null && c2.getInscricaoMunicipal() != null) {
                if (im1 > im2) {
                    return 1;
                } else if (im1 < im2) {
                    return -1;
                } else {
                    return 0;
                }
            } else {

                if (c1.getInscricaoMunicipal() != null) {
                    return 1;
                } else if (c2.getInscricaoMunicipal() != null) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }
}
