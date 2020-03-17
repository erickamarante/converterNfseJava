package com.constanzooficial.integracao.controller;

import com.constanzooficial.integracao.model.ModelConfig;
import com.constanzooficial.integracao.util.UtilFile;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
public class ControllerConfig {

    private final File cfgFile;
    private final BufferedReader reader;

    public ControllerConfig() throws FileNotFoundException {

        this.cfgFile = new File("config.cfg");
        FileReader fr = new FileReader(this.cfgFile);
        this.reader = new BufferedReader(fr);
    }

    public void saveConfigs() throws IOException {

        ArrayList<String> array = new ArrayList<>();
        array.add(ModelConfig.getInstance().getPkcs12file().getPath());
        array.add(ModelConfig.getInstance().getPrivateKeyAlias());
        array.add(ModelConfig.getInstance().getPassword());
        array.add(ModelConfig.getInstance().getCnpj());
        array.add(ModelConfig.getInstance().getInscricaoMunicipal());

        UtilFile.createFileFromLines(cfgFile, array);
    }

    public void loadConfigs() throws IOException {

        ModelConfig config = ModelConfig.getInstance();

        String filePath = reader.readLine();
        String[] split = filePath.split("[\\\\|/]");
        String relativePath = "cd" + ModelConfig.getInstance().getBarra() + split[split.length - 1];
        try {
            //System.out.println("Caminho do certificado: " + relativePath);
            config.setPkcs12file(new File(relativePath));
        } catch (Exception e) {
            config.setPkcs12file(new File(filePath));
        }
        
        config.setPrivateKeyAlias(reader.readLine());
        config.setPassword(reader.readLine());
        config.setCnpj(reader.readLine());
        config.setInscricaoMunicipal(reader.readLine());
    }
}
