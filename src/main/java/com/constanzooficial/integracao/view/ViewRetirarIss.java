package com.constanzooficial.integracao.view;

import com.constanzooficial.integracao.controller.ControllerRetirarIss;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
public class ViewRetirarIss extends javax.swing.JFrame {

    private File[] selectedFiles;

    /**
     * Creates new form ViewWS
     */
    public ViewRetirarIss() {
        initComponents();

        this.setLocationRelativeTo(null);

        try {
            Image iconePrograma = ImageIO.read(getClass().getResourceAsStream("/res/iconeNFSe.png"));
            this.setIconImage(iconePrograma);

            BufferedImage iconeAbrirArquivo = ImageIO.read(getClass().getResourceAsStream("/res/iconeAbrirArquivo.png"));
            Image dimg = iconeAbrirArquivo.getScaledInstance(btnSelecionarPasta.getWidth() - 15, btnSelecionarPasta.getHeight() - 10, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(dimg);
            btnSelecionarPasta.setIcon(imageIcon);
        } catch (IOException ex) {
            Logger.getLogger(ViewRetirarIss.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.selectedFiles = null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        campoPasta = new javax.swing.JTextField();
        btnSelecionarPasta = new javax.swing.JButton();
        btnRetirarIss = new javax.swing.JButton();
        barraProgresso = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Integração Constanzo - Retirar ISS");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        campoPasta.setEditable(false);
        campoPasta.setText("Selecione os arquivos XML");
        campoPasta.setFocusable(false);

        btnSelecionarPasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarPastaActionPerformed(evt);
            }
        });

        btnRetirarIss.setText("Retirar ISS das notas");
        btnRetirarIss.setEnabled(false);
        btnRetirarIss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetirarIssActionPerformed(evt);
            }
        });

        barraProgresso.setForeground(new java.awt.Color(0, 255, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(campoPasta, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btnSelecionarPasta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnRetirarIss, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(barraProgresso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSelecionarPasta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoPasta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(barraProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRetirarIss, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelecionarPastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarPastaActionPerformed

        JFileChooser fc = new JFileChooser(selectedFiles == null ? null : selectedFiles[0].getParentFile());
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setMultiSelectionEnabled(true);
        fc.setFileFilter(new FileNameExtensionFilter("XML", "xml"));
        fc.setAcceptAllFileFilterUsed(false);
        int opcao = fc.showOpenDialog(null);
        if (opcao == JFileChooser.APPROVE_OPTION) {
            btnRetirarIss.setEnabled(true);
            selectedFiles = fc.getSelectedFiles();
            if (selectedFiles.length > 1) {
                campoPasta.setText(selectedFiles[0].getParentFile().getPath() + "\\[" + selectedFiles.length + " arquivos].xml");
            } else {
                campoPasta.setText(selectedFiles[0].getPath());
            }
        }
    }//GEN-LAST:event_btnSelecionarPastaActionPerformed

    private void btnRetirarIssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetirarIssActionPerformed

        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        barraProgresso.setMaximum(selectedFiles.length);
        barraProgresso.setValue(0);
        btnSelecionarPasta.setEnabled(false);
        btnRetirarIss.setEnabled(false);
        ControllerRetirarIss controllerRetirarIss = new ControllerRetirarIss(selectedFiles, this);
        controllerRetirarIss.iniciar(4);
    }//GEN-LAST:event_btnRetirarIssActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            javax.swing.UIManager.setLookAndFeel(new com.jgoodies.looks.plastic.Plastic3DLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ViewRetirarIss().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraProgresso;
    private javax.swing.JButton btnRetirarIss;
    private javax.swing.JButton btnSelecionarPasta;
    private javax.swing.JTextField campoPasta;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnBaixarNotas() {
        return btnRetirarIss;
    }

    public synchronized void incrementarBarra() {
        barraProgresso.setValue(barraProgresso.getValue() + 1);
        if (barraProgresso.getValue() == barraProgresso.getMaximum()) {
            btnSelecionarPasta.setEnabled(true);
            btnRetirarIss.setEnabled(true);
            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            JOptionPane.showMessageDialog(this, "ISSs retirados com sucesso!");
        }
    }
}
