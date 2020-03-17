package com.constanzooficial.integracao.view;

import com.constanzooficial.integracao.controller.ControllerClientes;
import com.constanzooficial.integracao.model.ModelClientes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
public class ViewClientes extends javax.swing.JFrame implements Observer {

    private ViewWS viewWS = null;
    private ViewEmitirGuias viewEmitirGuias = null;

    /**
     * Creates new form ViewClientes
     */
    public ViewClientes() {
        construtor();
    }

    public ViewClientes(ViewWS viewWS) {
        this.viewWS = viewWS;
        construtor();
    }

    public ViewClientes(ViewEmitirGuias viewEmitirGuias) {
        this.viewEmitirGuias = viewEmitirGuias;
        construtor();
    }

    private void construtor() {
        initComponents();

        this.setLocationRelativeTo(null);
        if (!ControllerClientes.getClientes().isEmpty()) {
            this.preencherTabela(ControllerClientes.getClientes());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPrincipal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaClientes = new javax.swing.JTable();
        campoPesquisa = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        btnAtivarTodos = new javax.swing.JButton();
        btnDesativarTodos = new javax.swing.JButton();
        btnIssEmTodos = new javax.swing.JButton();
        btnIssEmNenhum = new javax.swing.JButton();
        btnImportarClientes = new javax.swing.JButton();
        btnRemoverCliente = new javax.swing.JButton();
        btnAdicionarCliente = new javax.swing.JButton();
        btnEditarCliente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Integração Constanzo - Clientes");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        painelPrincipal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Razão Social", "CPF/CNPJ", "Considerar ISS", "Ativo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaClientes);

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnAtivarTodos.setText("Ativar todos");
        btnAtivarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtivarTodosActionPerformed(evt);
            }
        });

        btnDesativarTodos.setText("Desativar todos");
        btnDesativarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesativarTodosActionPerformed(evt);
            }
        });

        btnIssEmTodos.setText("ISS em todos");
        btnIssEmTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIssEmTodosActionPerformed(evt);
            }
        });

        btnIssEmNenhum.setText("ISS em nenhum");
        btnIssEmNenhum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIssEmNenhumActionPerformed(evt);
            }
        });

        btnImportarClientes.setText("Importar clientes");
        btnImportarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarClientesActionPerformed(evt);
            }
        });

        btnRemoverCliente.setText("Remover cliente");
        btnRemoverCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverClienteActionPerformed(evt);
            }
        });

        btnAdicionarCliente.setText("Adicionar cliente");
        btnAdicionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarClienteActionPerformed(evt);
            }
        });

        btnEditarCliente.setText("Editar cliente");
        btnEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addComponent(campoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 116, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDesativarTodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAtivarTodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnIssEmTodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnIssEmNenhum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnImportarClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRemoverCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdicionarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelPrincipalLayout.setVerticalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPrincipalLayout.createSequentialGroup()
                        .addComponent(btnAdicionarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemoverCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnImportarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAtivarTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesativarTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnIssEmTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnIssEmNenhum, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnImportarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarClientesActionPerformed

        ControllerClientes controllerClientes = new ControllerClientes();
        controllerClientes.addObserver(this);

        Thread t = new Thread(() -> {
            try {
                controllerClientes.importarClientes();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex, "Erro!", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(ViewClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        t.start();
    }//GEN-LAST:event_btnImportarClientesActionPerformed

    private void btnAtivarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtivarTodosActionPerformed

        ControllerClientes controllerClientes = new ControllerClientes();
        controllerClientes.selecionarTodos();

        DefaultTableModel model = (DefaultTableModel) tabelaClientes.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(true, i, 3);
        }
    }//GEN-LAST:event_btnAtivarTodosActionPerformed

    private void btnDesativarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesativarTodosActionPerformed

        ControllerClientes controllerClientes = new ControllerClientes();
        controllerClientes.selecionarNenhum();

        DefaultTableModel model = (DefaultTableModel) tabelaClientes.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(false, i, 3);
        }
    }//GEN-LAST:event_btnDesativarTodosActionPerformed

    private void btnIssEmTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIssEmTodosActionPerformed

        ControllerClientes controllerClientes = new ControllerClientes();
        controllerClientes.issEmTodos();

        DefaultTableModel model = (DefaultTableModel) tabelaClientes.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(true, i, 2);
        }
    }//GEN-LAST:event_btnIssEmTodosActionPerformed

    private void btnIssEmNenhumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIssEmNenhumActionPerformed

        ControllerClientes controllerClientes = new ControllerClientes();
        controllerClientes.issEmTodos();

        DefaultTableModel model = (DefaultTableModel) tabelaClientes.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(false, i, 2);
        }
    }//GEN-LAST:event_btnIssEmNenhumActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed

        if (campoPesquisa.getText().equals("")) {
            preencherTabela(ControllerClientes.getClientes());
        } else {
            ArrayList<ModelClientes> resultadoPesquisa = new ControllerClientes().pesquisar(campoPesquisa.getText());

            if (resultadoPesquisa == null || resultadoPesquisa.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nenhum resultado encontrado!");
                preencherTabela(ControllerClientes.getClientes());
            } else {
                preencherTabela(resultadoPesquisa);
            }
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void tabelaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClientesMouseClicked

        int row = tabelaClientes.rowAtPoint(evt.getPoint());
        int col = tabelaClientes.columnAtPoint(evt.getPoint());
        if (row >= 0) {

            ModelClientes clienteSelecionado = new ControllerClientes().getCliente(((String) tabelaClientes.getValueAt(row, 1)).replaceAll("[^0-9]", ""));
            if (col == 2) {
                clienteSelecionado.setConsiderarIss((boolean) tabelaClientes.getValueAt(row, 2));
            } else if (col == 3) {
                clienteSelecionado.setAtivo((boolean) tabelaClientes.getValueAt(row, 3));
            }
        }
    }//GEN-LAST:event_tabelaClientesMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

        if (this.viewWS != null && !ControllerClientes.getClientes().isEmpty()) {
            this.viewWS.getBtnBaixarNotas().setEnabled(true);
        } else if (this.viewEmitirGuias != null && !ControllerClientes.getClientes().isEmpty()) {
            this.viewEmitirGuias.getBtnEmitirGuias().setEnabled(true);
        }

        Thread t = new Thread(() -> {
            try {
                new ControllerClientes().salvarClientes();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex, "Erro!", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(ViewClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        t.start();
    }//GEN-LAST:event_formWindowClosed

    private void btnRemoverClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverClienteActionPerformed

        if (tabelaClientes.getSelectedRow() != -1) {
            String cpfCnpj = (String) tabelaClientes.getModel().getValueAt(tabelaClientes.getSelectedRow(), 1);
            ControllerClientes clientes = new ControllerClientes();
            try {
                if (clientes.removerCliente(cpfCnpj)) {
                    preencherTabela(ControllerClientes.getClientes());
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex, "Problema ao tentar salvar a lista de clientes!", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(ViewClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um cliente!");
        }
    }//GEN-LAST:event_btnRemoverClienteActionPerformed

    private void btnAdicionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarClienteActionPerformed
        new ViewAdicionarCliente().setVisible(true);
    }//GEN-LAST:event_btnAdicionarClienteActionPerformed

    private void btnEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarClienteActionPerformed
        
        if (tabelaClientes.getSelectedRow() != -1) {
            String cpfCnpj = (String) tabelaClientes.getModel().getValueAt(tabelaClientes.getSelectedRow(), 1);
            new ViewEditarCliente(this, cpfCnpj.replaceAll("[\".\"]|/|-", "")).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um cliente!");
        }
    }//GEN-LAST:event_btnEditarClienteActionPerformed

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
            ViewClientes viewClientes = new ViewClientes();
            viewClientes.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarCliente;
    private javax.swing.JButton btnAtivarTodos;
    private javax.swing.JButton btnDesativarTodos;
    private javax.swing.JButton btnEditarCliente;
    private javax.swing.JButton btnImportarClientes;
    private javax.swing.JButton btnIssEmNenhum;
    private javax.swing.JButton btnIssEmTodos;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnRemoverCliente;
    private javax.swing.JTextField campoPesquisa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JTable tabelaClientes;
    // End of variables declaration//GEN-END:variables

    public void limparTabela() {

        DefaultTableModel model = (DefaultTableModel) tabelaClientes.getModel();
        for (int i = model.getRowCount() - 1; i > -1; i--) {
            model.removeRow(i);
        }
    }

    public void preencherTabela(ArrayList<ModelClientes> clientes) {

        limparTabela();
        tabelaClientes.getColumnModel().getColumn(1).setMaxWidth(120);
        tabelaClientes.getColumnModel().getColumn(1).setMinWidth(120);
        tabelaClientes.getColumnModel().getColumn(2).setMaxWidth(100);
        tabelaClientes.getColumnModel().getColumn(2).setMinWidth(100);
        tabelaClientes.getColumnModel().getColumn(3).setMaxWidth(50);
        tabelaClientes.getColumnModel().getColumn(3).setMinWidth(50);
        DefaultTableModel model = (DefaultTableModel) tabelaClientes.getModel();
        for (int i = 0; i < clientes.size(); i++) {
            Object[] row = new Object[4];
            row[0] = clientes.get(i).getRazaoSocial();
            row[1] = clientes.get(i).getCpfCnpjFormatado();
            row[2] = clientes.get(i).isConsiderarIss();
            row[3] = clientes.get(i).isAtivo();
            model.addRow(row);
        }
        tabelaClientes.setModel(model);
    }

    @Override
    public void update(Observable o, Object o1) {

        if (o instanceof ControllerClientes) {

            ArrayList<ModelClientes> clientes = ControllerClientes.getClientes();
            DefaultTableModel model = (DefaultTableModel) tabelaClientes.getModel();

            switch ((int) o1) {

                case 1: // Adicionar/importar clientes

                    preencherTabela(clientes);
                    break;
            }
        }
    }
}
