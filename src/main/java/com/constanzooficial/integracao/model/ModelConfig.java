package com.constanzooficial.integracao.model;

import java.io.File;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
public class ModelConfig {

    private static final ModelConfig INSTANCE = new ModelConfig();

    // Certificado digital
    private File pkcs12file;
    private String privateKeyAlias;
    private String password;
    private String cnpj;
    private String inscricaoMunicipal;
    
    private final String barra;

    public static ModelConfig getInstance() {
        return INSTANCE;
    }

    public ModelConfig() {
        this.barra = System.getProperty("os.name").equals("Linux") ? "/" : "\\";
    }

    public File getPkcs12file() {
        return pkcs12file;
    }

    public void setPkcs12file(File pkcs12file) {
        this.pkcs12file = pkcs12file;
    }

    public String getPrivateKeyAlias() {
        return privateKeyAlias;
    }

    public void setPrivateKeyAlias(String privateKeyAlias) {
        this.privateKeyAlias = privateKeyAlias;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public String getBarra() {
        return barra;
    }

}
