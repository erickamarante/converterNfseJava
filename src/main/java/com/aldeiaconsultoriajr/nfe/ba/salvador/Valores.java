package com.aldeiaconsultoriajr.nfe.ba.salvador;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("Valores")
public class Valores {

    @XStreamAlias("ValorServicos")
    private String valorServicos;
    @XStreamAlias("ValorDeducoes")
    private String valorDeducoes;
    @XStreamAlias("ValorPis")
    private String valorPis;
    @XStreamAlias("ValorCofins")
    private String valorCofins;
    @XStreamAlias("ValorInss")
    private String valorInss;
    @XStreamAlias("ValorIr")
    private String valorIr;
    @XStreamAlias("ValorCsll")
    private String valorCsll;
    @XStreamAlias("IssRetido")
    private String issRetido;
    @XStreamAlias("ValorIssRetido")
    private String valorIssRetido;
    @XStreamAlias("ValorIss")
    private String valorIss;
    @XStreamAlias("OutrasRetencoes")
    private String outrasRetencoes;
    @XStreamAlias("BaseCalculo")
    private String baseCalculo;
    @XStreamAlias("Aliquota")
    private String aliquota;
    @XStreamAlias("ValorLiquidoNfse")
    private String valorLiquidoNfse;
    @XStreamAlias("DescontoIncondicionado")
    private String descontoIncondicionado;
    @XStreamAlias("DescontoCondicionado")
    private String descontoCondicionado;

    public String getValorServicos() {
        if (valorServicos != null) {
            return valorServicos.replace(',', '.');
        } else {
            return "0";
        }
    }

    public String getValorDeducoes() {
        if (valorDeducoes != null) {
            return valorDeducoes.replace(',', '.');
        } else {
            return "0";
        }
    }

    public String getValorPis() {
        if (valorPis != null) {
            return valorPis.replace(',', '.');
        } else {
            return "0";
        }
    }

    public String getValorCofins() {
        if (valorCofins != null) {
            return valorCofins.replace(',', '.');
        } else {
            return "0";
        }
    }

    public String getValorInss() {
        if (valorInss != null) {
            return valorInss.replace(',', '.');
        } else {
            return "0";
        }
    }

    public String getValorIr() {
        if (valorIr != null) {
            return valorIr.replace(',', '.');
        } else {
            return "0";
        }
    }

    public String getValorCsll() {
        if (valorCsll != null) {
            return valorCsll.replace(',', '.');
        } else {
            return "0";
        }
    }

    public String getIssRetido() {
        if (issRetido != null) {
            return issRetido.replace(',', '.');
        } else {
            return "0";
        }
    }

    public String getValorIssRetido() {
        if (valorIssRetido != null) {
            return valorIssRetido.replace(',', '.');
        } else {
            return "0";
        }
    }

    public String getValorIss() {
        if (valorIss != null) {
            return valorIss.replace(',', '.');
        } else {
            return "0";
        }
    }

    public String getOutrasRetencoes() {
        if (outrasRetencoes != null) {
            return outrasRetencoes.replace(',', '.');
        } else {
            return "0";
        }
    }

    public String getBaseCalculo() {
        if (baseCalculo != null) {
            return baseCalculo.replace(',', '.');
        } else {
            return "0";
        }
    }

    public String getAliquota() {
        if (aliquota != null) {
            return aliquota.replace(',', '.');
        } else {
            return "0";
        }
    }

    public String getValorLiquidoNfse() {
        if (valorLiquidoNfse != null) {
            return valorLiquidoNfse.replace(',', '.');
        } else {
            return "0";
        }
    }

    public String getDescontoIncondicionado() {
        if (descontoIncondicionado != null) {
            return descontoIncondicionado.replace(',', '.');
        } else {
            return "0";
        }
    }

    public String getDescontoCondicionado() {
        if (descontoCondicionado != null) {
            return descontoCondicionado.replace(',', '.');
        } else {
            return "0";
        }
    }

}
