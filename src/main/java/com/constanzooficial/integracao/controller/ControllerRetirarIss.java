package com.constanzooficial.integracao.controller;

import com.constanzooficial.integracao.util.UtilFile;
import com.constanzooficial.integracao.view.ViewRetirarIss;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
public class ControllerRetirarIss {

    private File[] files;
    private AtomicInteger index;
    private ViewRetirarIss view;

    public ControllerRetirarIss(File[] files, ViewRetirarIss view) {

        this.files = files;
        this.index = new AtomicInteger(0);
        this.view = view;
    }

    public void iniciar(int numeroThreads) {

        for (int i = 0; i < numeroThreads; i++) {
            Thread t = new Thread(() -> {

                int qtdArquivosProcessados = 0;
                File file = nextFile();
                while (file != null) {
                    retirarIss(file);
                    qtdArquivosProcessados++;
                    view.incrementarBarra();
                    file = nextFile();
                }
            });
            t.start();
        }
    }

    public void retirarIss(File file) {

        String strFile = null;
        try {
            strFile = UtilFile.fileToString(file);

            boolean arquivoModificado = false;

            if (strFile.contains("<tc:IssRetido>")) {
                strFile = strFile.replaceAll("(<tc:IssRetido>)1(</tc:IssRetido>)", "<tc:IssRetido>2</tc:IssRetido>");
                arquivoModificado = true;
            }
            if (strFile.contains("<tc:Aliquota>")) {
                strFile = strFile.replaceAll("<tc:Aliquota>(.*?)</tc:Aliquota>", "<tc:Aliquota>0</tc:Aliquota>");
                arquivoModificado = true;
            }
            if (strFile.contains("<tc:ValorIssRetido>")) {
                strFile = strFile.replaceAll("<tc:ValorIssRetido>(.*?)</tc:ValorIssRetido>", "<tc:ValorIssRetido>0</tc:ValorIssRetido>");
                arquivoModificado = true;
            }
            if (strFile.contains("<tc:ValorIss>")) {
                strFile = strFile.replaceAll("<tc:ValorIss>(.*?)</tc:ValorIss>", "<tc:ValorIss>0</tc:ValorIss>");
                arquivoModificado = true;
            }

            if (strFile.contains("<ns3:IssRetido>")) {
                strFile = strFile.replaceAll("(<ns3:IssRetido>)1(</ns3:IssRetido>)", "<ns3:IssRetido>2</ns3:IssRetido>");
                arquivoModificado = true;
            }
            if (strFile.contains("<ns3:ValorIss>")) {
                strFile = strFile.replaceAll("<ns3:ValorIss>(.*?)</ns3:ValorIss>", "<ns3:ValorIss>0</ns3:ValorIss>");
                arquivoModificado = true;
            }
            if (strFile.contains("<ns3:Aliquota>")) {
                strFile = strFile.replaceAll("<ns3:Aliquota>(.*?)</ns3:Aliquota>", "<ns3:Aliquota>0</ns3:Aliquota>");
                arquivoModificado = true;
            }
            if (strFile.contains("<ns3:ValorIssRetido>")) {
                strFile = strFile.replaceAll("<ns3:ValorIssRetido>(.*?)</ns3:ValorIssRetido>", "<ns3:ValorIssRetido>0</ns3:ValorIssRetido>");
                arquivoModificado = true;
            }

            if (strFile.contains("<ISSQNCliente>")) {
                strFile = strFile.replaceAll("<ISSQNCliente>(.*?)</ISSQNCliente>", "<ISSQNCliente>0.0</ISSQNCliente>");
                arquivoModificado = true;
            }
            if (strFile.contains("<ISSQNSemRetencao>")) {
                strFile = strFile.replaceAll("<ISSQNSemRetencao>(.*?)</ISSQNSemRetencao>", "<ISSQNSemRetencao>0.0</ISSQNSemRetencao>");
                arquivoModificado = true;
            }
            if (strFile.contains("<ISSQNTotal>")) {
                strFile = strFile.replaceAll("<ISSQNTotal>(.*?)</ISSQNTotal>", "<ISSQNTotal>0.0</ISSQNTotal>");
                arquivoModificado = true;
            }
            if (strFile.contains("<Aliquota>")) {
                strFile = strFile.replaceAll("<Aliquota>(.*?)</Aliquota>", "<Aliquota>0.0</Aliquota>");
                arquivoModificado = true;
            }

            if (strFile.contains("<aliquota>")) {
                strFile = strFile.replaceAll("<aliquota>(.*?)</aliquota>", "<aliquota>0.0</aliquota>");
                arquivoModificado = true;
            }
            if (strFile.contains("<valorImposto>")) {
                strFile = strFile.replaceAll("<valorImposto>(.*?)</valorImposto>", "<valorImposto>0.0</valorImposto>");
                arquivoModificado = true;
            }
            
            // Lençóis Paulista
            if (strFile.contains("<CidadeIBGE>3526803</CidadeIBGE>")) {
                if (strFile.contains("<ValorISS>")) {
                    strFile = strFile.replaceAll("<ValorISS>(.*?)</ValorISS>", "<ValorISS>0,00</ValorISS>");
                    arquivoModificado = true;
                }
                if (strFile.contains("<Aliquota>")) {
                    strFile = strFile.replaceAll("<Aliquota>(.*?)</Aliquota>", "<Aliquota>0</Aliquota>");
                    arquivoModificado = true;
                }
                if (strFile.contains("<AliquotaRecalculada>")) {
                    strFile = strFile.replaceAll("<AliquotaRecalculada>(.*?)</AliquotaRecalculada>", "<AliquotaRecalculada>0,000000</AliquotaRecalculada>");
                    arquivoModificado = true;
                }
            }
            if (arquivoModificado) {
                UtilFile.createFileFromString(new File(file.getParentFile(), (file.getName().replace(".xml", "_semISS.xml"))), strFile);
            }
        } catch (IOException ex) {
            Logger.getLogger(ControllerRetirarIss.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private synchronized File nextFile() {
        if (index.get() < files.length) {
            return files[index.incrementAndGet() - 1];
        }
        return null;
    }
}
