package com.constanzooficial.integracao.model;

import com.constanzooficial.integracao.util.MyUtils;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
public class ModelClientes {

    private String razaoSocial;
    private String cpfCnpj;
    private String inscricaoMunicipal;
    private boolean emiteNFe;
    private boolean considerarIss;
    private boolean ativo;
    
    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getCpfCnpjFormatado() {

        try {
            if (this.cpfCnpj.length() == 11) {
                return MyUtils.formatarCpf(this.cpfCnpj);
            } else {
                return MyUtils.formatarCnpj(this.cpfCnpj);
            }
        } catch (Exception ex) {
            Logger.getLogger(ModelClientes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public boolean isConsiderarIss() {
        return considerarIss;
    }

    public void setConsiderarIss(boolean considerarIss) {
        this.considerarIss = considerarIss;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean selecionado) {
        this.ativo = selecionado;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public boolean emiteNFe() {
        return emiteNFe;
    }

    public void setEmiteNFe(boolean emiteNFe) {
        this.emiteNFe = emiteNFe;
    }
}
