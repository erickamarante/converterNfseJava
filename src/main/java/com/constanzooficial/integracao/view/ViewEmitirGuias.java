package com.constanzooficial.integracao.view;

import com.constanzooficial.integracao.controller.ControllerClientes;
import com.constanzooficial.integracao.controller.ControllerGuiaIss;
import com.constanzooficial.integracao.controller.ControllerWebService;
import com.constanzooficial.integracao.model.ModelClientes;
import com.constanzooficial.integracao.util.MyUtils;
import com.constanzooficial.integracao.util.UtilDatas;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
public class ViewEmitirGuias extends javax.swing.JFrame implements ViewComBarra {

    /**
     * Creates new form ViewWS
     */
    public ViewEmitirGuias() {
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
            Logger.getLogger(ViewEmitirGuias.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Preenche as comboBoxes de ano
        Date date = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(date.getTime());
        int ano = cal.get(Calendar.YEAR);
        for (int i = 2010; i <= ano; i++) {
            comboAnoIncidencia.addItem(Integer.toString(i));
            comboAnoVencimento.addItem(Integer.toString(i));
            if (i == ano) {
                comboAnoVencimento.addItem(Integer.toString(i + 1));
            }
        }
        comboAnoIncidencia.setSelectedIndex(comboAnoIncidencia.getItemCount() - 1);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        comboMesIncidencia = new javax.swing.JComboBox<>();
        campoPasta = new javax.swing.JTextField();
        btnSelecionarPasta = new javax.swing.JButton();
        btnSelecionarClientes = new javax.swing.JButton();
        btnEmitirGuias = new javax.swing.JButton();
        comboAnoIncidencia = new javax.swing.JComboBox<>();
        barraProgresso = new javax.swing.JProgressBar();
        labelIncidencia = new javax.swing.JLabel();
        labelDataVencimento = new javax.swing.JLabel();
        comboDiaVencimento = new javax.swing.JComboBox<>();
        comboMesVencimento = new javax.swing.JComboBox<>();
        comboAnoVencimento = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        radioEmitidas = new javax.swing.JRadioButton();
        radioRecebidas = new javax.swing.JRadioButton();
        radioAmbas = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Integração Constanzo - São Paulo WS");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        comboMesIncidencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mês", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
        comboMesIncidencia.setEnabled(false);
        comboMesIncidencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMesIncidenciaActionPerformed(evt);
            }
        });

        campoPasta.setEditable(false);
        campoPasta.setText("Selecione uma pasta para salvar as guias");
        campoPasta.setFocusable(false);

        btnSelecionarPasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarPastaActionPerformed(evt);
            }
        });

        btnSelecionarClientes.setText("Selecionar clientes");
        btnSelecionarClientes.setEnabled(false);
        btnSelecionarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarClientesActionPerformed(evt);
            }
        });

        btnEmitirGuias.setText("Emitir guias");
        btnEmitirGuias.setEnabled(false);
        btnEmitirGuias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmitirGuiasActionPerformed(evt);
            }
        });

        comboAnoIncidencia.setEnabled(false);

        barraProgresso.setForeground(new java.awt.Color(0, 255, 0));

        labelIncidencia.setText("Incidência:");

        labelDataVencimento.setText("Data de vencimento:");

        comboDiaVencimento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dia" }));
        comboDiaVencimento.setEnabled(false);

        comboMesVencimento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mês", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
        comboMesVencimento.setEnabled(false);

        comboAnoVencimento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ano" }));
        comboAnoVencimento.setEnabled(false);

        jLabel1.setText("Tipo de emissão de guias:");

        buttonGroup1.add(radioEmitidas);
        radioEmitidas.setText("Notas emitidas");
        radioEmitidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioEmitidasActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioRecebidas);
        radioRecebidas.setText("Notas recebidas");

        buttonGroup1.add(radioAmbas);
        radioAmbas.setText("Ambas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEmitirGuias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(barraProgresso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelIncidencia)
                            .addComponent(labelDataVencimento)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(comboDiaVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboMesVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboAnoVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(radioEmitidas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioRecebidas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioAmbas))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(comboMesIncidencia, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboAnoIncidencia, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSelecionarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(campoPasta, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btnSelecionarPasta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSelecionarPasta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoPasta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelIncidencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSelecionarClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboMesIncidencia)
                    .addComponent(comboAnoIncidencia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelDataVencimento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboDiaVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboMesVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboAnoVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioEmitidas)
                    .addComponent(radioRecebidas)
                    .addComponent(radioAmbas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(barraProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEmitirGuias, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnSelecionarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarClientesActionPerformed
        new ViewClientes(this).setVisible(true);
    }//GEN-LAST:event_btnSelecionarClientesActionPerformed

    private void btnSelecionarPastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarPastaActionPerformed

        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int opcao = fc.showOpenDialog(null);
        if (opcao == JFileChooser.APPROVE_OPTION) {
            campoPasta.setText(fc.getSelectedFile().getPath());
            comboMesIncidencia.setEnabled(true);
            comboAnoIncidencia.setEnabled(true);
        }
    }//GEN-LAST:event_btnSelecionarPastaActionPerformed

    private void comboMesIncidenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMesIncidenciaActionPerformed

        if (comboMesIncidencia.getSelectedIndex() != 0) {
            btnSelecionarClientes.setEnabled(true);

            Calendar dataVencimento = Calendar.getInstance();
            if (comboMesIncidencia.getSelectedIndex() != 12) {
                dataVencimento.set(Integer.valueOf((String) comboAnoIncidencia.getSelectedItem()), comboMesIncidencia.getSelectedIndex(), 10);
            } else {
                dataVencimento.set(Integer.valueOf((String) comboAnoIncidencia.getSelectedItem()) + 1, 0, 10);
            }
            //dataVencimento.set(Integer.valueOf((String) comboAnoIncidencia.getSelectedItem()), comboMesIncidencia.getSelectedIndex() - 1, 10);
            try {
                dataVencimento = new UtilDatas().diaUtil(dataVencimento);
            } catch (Exception ex) {
                Logger.getLogger(ViewEmitirGuias.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex, "Erro!", JOptionPane.ERROR_MESSAGE);
            }

            comboDiaVencimento.removeAllItems();
            comboDiaVencimento.addItem("Dia");
            for (int i = 1; i <= MyUtils.ultimoDiaMes(comboMesIncidencia.getSelectedIndex(), Integer.valueOf((String) comboAnoIncidencia.getSelectedItem())); i++) {
                comboDiaVencimento.addItem(Integer.toString(i));
            }
            comboDiaVencimento.setSelectedIndex(dataVencimento.get(Calendar.DAY_OF_MONTH));
            comboMesVencimento.setSelectedIndex(dataVencimento.get(Calendar.MONTH) + 1);
            comboAnoVencimento.setSelectedItem(Integer.toString(dataVencimento.get(Calendar.YEAR)));
            comboDiaVencimento.setEnabled(true);
            comboMesVencimento.setEnabled(true);
            comboAnoVencimento.setEnabled(true);

            if (!ControllerClientes.getClientes().isEmpty()) {
                btnEmitirGuias.setEnabled(true);
            }
        } else {
            btnSelecionarClientes.setEnabled(false);
            btnEmitirGuias.setEnabled(false);
        }
    }//GEN-LAST:event_comboMesIncidenciaActionPerformed

    private void btnEmitirGuiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmitirGuiasActionPerformed

        // Define o valor máximo da progressBar
        barraProgresso.setMaximum(ControllerClientes.getClientes().size());
        barraProgresso.setValue(0);
        btnSelecionarPasta.setEnabled(false);
        comboMesIncidencia.setEnabled(false);
        comboAnoIncidencia.setEnabled(false);
        btnSelecionarClientes.setEnabled(false);
        btnEmitirGuias.setEnabled(false);
        try {
            ControllerWebService webService = new ControllerWebService(this);

            Date date = new Date();
            Calendar cal = new GregorianCalendar();
            cal.setTimeInMillis(date.getTime());
            int ano = cal.get(Calendar.YEAR);

            for (ModelClientes cliente : ControllerClientes.getClientes()) {
                if (cliente.isAtivo() && cliente.getInscricaoMunicipal() != null) {
                    String protocolo = "";
                    if (radioEmitidas.isSelected()) {
                        //webService.gerarMensagemXMLEmissaoGuiaRequest(cliente, 1, comboMesIncidencia.getSelectedIndex() - 1, Integer.valueOf((String) comboAnoIncidencia.getSelectedItem()));
                        protocolo = webService.emissaoGuiaAsync(cliente, 1, comboMesIncidencia.getSelectedIndex(), Integer.valueOf((String) comboAnoIncidencia.getSelectedItem()));
                        //System.out.println("Indo");
                        //webService.consultaGuia(cliente, comboMesIncidencia.getSelectedIndex() - 1, Integer.valueOf((String) comboAnoIncidencia.getSelectedItem()), 1);
                        //System.out.println("Vindo");
                    } else if (radioRecebidas.isSelected()) {
                        //webService.gerarMensagemXMLEmissaoGuiaRequest(cliente, 2, comboMesIncidencia.getSelectedIndex() - 1, Integer.valueOf((String) comboAnoIncidencia.getSelectedItem()));
                        protocolo = webService.emissaoGuiaAsync(cliente, 2, comboMesIncidencia.getSelectedIndex(), Integer.valueOf((String) comboAnoIncidencia.getSelectedItem()));
                        //webService.consultaGuia(cliente, comboMesIncidencia.getSelectedIndex() - 1, Integer.valueOf((String) comboAnoIncidencia.getSelectedItem()), 2);
                    } else if (radioAmbas.isSelected()) {
                        //webService.gerarMensagemXMLEmissaoGuiaRequest(cliente, 3, comboMesIncidencia.getSelectedIndex() - 1, Integer.valueOf((String) comboAnoIncidencia.getSelectedItem()));
                        protocolo = webService.emissaoGuiaAsync(cliente, 3, comboMesIncidencia.getSelectedIndex(), Integer.valueOf((String) comboAnoIncidencia.getSelectedItem()));
                        //webService.consultaGuia(cliente, comboMesIncidencia.getSelectedIndex() - 1, Integer.valueOf((String) comboAnoIncidencia.getSelectedItem()), 3);
                    }

                    while (true) {
                        Thread.sleep(1000);
                        webService.consultaSituacaoGuia(protocolo);
                    }
                }
            }

            //webService.baixarNotas(new File(campoPasta.getText()), comboMes.getSelectedIndex(), Integer.valueOf((String) comboAno.getSelectedItem()), 8);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(ViewEmitirGuias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEmitirGuiasActionPerformed

    private void radioEmitidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioEmitidasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioEmitidasActionPerformed

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
            new ViewEmitirGuias().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraProgresso;
    private javax.swing.JButton btnEmitirGuias;
    private javax.swing.JButton btnSelecionarClientes;
    private javax.swing.JButton btnSelecionarPasta;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField campoPasta;
    private javax.swing.JComboBox<String> comboAnoIncidencia;
    private javax.swing.JComboBox<String> comboAnoVencimento;
    private javax.swing.JComboBox<String> comboDiaVencimento;
    private javax.swing.JComboBox<String> comboMesIncidencia;
    private javax.swing.JComboBox<String> comboMesVencimento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelDataVencimento;
    private javax.swing.JLabel labelIncidencia;
    private javax.swing.JRadioButton radioAmbas;
    private javax.swing.JRadioButton radioEmitidas;
    private javax.swing.JRadioButton radioRecebidas;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnEmitirGuias() {
        return btnEmitirGuias;
    }

    @Override
    public synchronized void incrementarBarra() {
        barraProgresso.setValue(barraProgresso.getValue() + 1);
        if (barraProgresso.getValue() == barraProgresso.getMaximum()) {
            btnSelecionarPasta.setEnabled(true);
            comboMesIncidencia.setEnabled(true);
            comboAnoIncidencia.setEnabled(true);
            btnSelecionarClientes.setEnabled(true);
            btnEmitirGuias.setEnabled(true);
            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            JOptionPane.showMessageDialog(this, "Notas baixadas com sucesso!");
        }
    }
}