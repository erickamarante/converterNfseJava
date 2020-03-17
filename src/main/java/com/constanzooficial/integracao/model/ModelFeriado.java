package com.constanzooficial.integracao.model;

import org.jfree.date.SerialDate;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
public class ModelFeriado {

    public static final int NACIONAL = 1;
    public static final int ESTADUAL = 2;
    public static final int MUNICIPAL = 3;
    public static final int FACULTATIVO = 4;
    public static final int DIA_CONVENCIONAL = 9;

    private String nome;
    private String data;
    private int tipo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public SerialDate getSerialDate() {
        if (data != null) {
            String[] split = data.split("/");
            SerialDate sd = SerialDate.createInstance(Integer.valueOf(split[0]), Integer.valueOf(split[1]), Integer.valueOf(split[2]));
            return sd;
        }
        return null;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
