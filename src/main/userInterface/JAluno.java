/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.userInterface;

import main.sgt.Aluno;
import main.sgt.Pedido;
import main.sgt.SGT;
import main.sgt.exceptions.AlunoNaoEstaInscritoNaUcException;
import main.sgt.exceptions.InvalidUserTypeException;
import main.sgt.exceptions.UtilizadorJaExisteException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;

import static main.sgt.NotifyFlags.*;
import static main.userInterface.InterfaceUtils.prepareTable;

/**
 *
 * @author pedro
 */
@SuppressWarnings({"FieldCanBeLocal", "unused", "Convert2Lambda", "Anonymous2MethodRef", "TryWithIdenticalCatches", "Duplicates"})
public class JAluno extends javax.swing.JFrame implements Observer {

    private SGT sgt;
    private List<Pedido> sugTroca = new ArrayList<>();
    /**
     * Creates new form Aluno
     * @param sgt Business logic instance
     */
    JAluno(SGT sgt) {
        this.sgt = sgt;
        this.sgt.addObserver(this);
        initComponents();
        if(this.sgt.isTurnosAtribuidos()){
            this.jButtonEscolherUCs.setEnabled(false);
        }else{
            this.jButtonPedirTroca.setEnabled(false);
        }
        updateUserUCs();
        updateSugestTroca();
    }

    private void updateSugestTroca() {
        List<Pedido> sujestoesTroca = this.sgt.getSujestoesTroca();
        DefaultTableModel tModel = prepareTable(sujestoesTroca.size(),2,this.jTablePropsTroca);
        for (int i = 0; i < sujestoesTroca.size(); i++) {
            Pedido p = sujestoesTroca.get(i);
            tModel.setValueAt(p.getUc(), i, 0);
            tModel.setValueAt(p.getTurno(), i, 1);
            this.sugTroca.set(i,p);
        }
        this.jTablePropsTroca.setModel(tModel);
    }

    private void updateUserUCs() {
        Map<String, Integer> horario;
        try {
            horario = ((Aluno) this.sgt.getLoggedUser()).getHorario();
        } catch (ClassCastException e) {
            this.dispose();
            return;
        }
        DefaultTableModel tModel = prepareTable(horario.size(), 2, this.jTableUCsETurnos);
        int i=0;
        for(Map.Entry<String,Integer> e: horario.entrySet()){
            tModel.setValueAt(this.sgt.getUC(e.getKey()).getNome(),i,0);
            tModel.setValueAt(e.getValue()!=0 ? e.getValue() : "n\\a",i++,1);
        }
        this.jTableUCsETurnos.setModel(tModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonEscolherUCs = new javax.swing.JButton();
        jScrollPaneUCsETurnos = new javax.swing.JScrollPane();
        jTableUCsETurnos = new javax.swing.JTable();
        jButtonPedirTroca = new javax.swing.JButton();
        jScrollPanePropsTroca = new javax.swing.JScrollPane();
        jTablePropsTroca = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonEscolherUCs.setText("Escolher UCs");
        jButtonEscolherUCs.setEnabled(!this.sgt.isTurnosAtribuidos());
        jButtonEscolherUCs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEscolherUCsActionPerformed(evt);
            }
        });

        jTableUCsETurnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UC:", "Turno:"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneUCsETurnos.setViewportView(jTableUCsETurnos);
        if (jTableUCsETurnos.getColumnModel().getColumnCount() > 0) {
            jTableUCsETurnos.getColumnModel().getColumn(1).setMinWidth(50);
            jTableUCsETurnos.getColumnModel().getColumn(1).setPreferredWidth(50);
            jTableUCsETurnos.getColumnModel().getColumn(1).setMaxWidth(50);
        }

        jButtonPedirTroca.setText("Pedir Troca");
        jButtonPedirTroca.setEnabled(this.sgt.isTurnosAtribuidos());
        jButtonPedirTroca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPedirTrocaActionPerformed(evt);
            }
        });

        jTablePropsTroca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UC:", "Turno:"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePropsTroca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePropsTrocaMouseClicked(evt);
            }
        });
        jScrollPanePropsTroca.setViewportView(jTablePropsTroca);
        if (jTablePropsTroca.getColumnModel().getColumnCount() > 0) {
            jTablePropsTroca.getColumnModel().getColumn(1).setMinWidth(50);
            jTablePropsTroca.getColumnModel().getColumn(1).setPreferredWidth(50);
            jTablePropsTroca.getColumnModel().getColumn(1).setMaxWidth(50);
        }

        jLabel1.setText("UCs:");

        jLabel2.setText("Sugestoes de troca:");

        jButtonLogout.setText("Logout");
        jButtonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonEscolherUCs)
                    .addComponent(jScrollPaneUCsETurnos, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPanePropsTroca, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonPedirTroca)))
                        .addGap(29, 29, 29))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonLogout)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPedirTroca)
                    .addComponent(jButtonEscolherUCs))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPaneUCsETurnos, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                    .addComponent(jScrollPanePropsTroca, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addComponent(jButtonLogout)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEscolherUCsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEscolherUCsActionPerformed
        JAlunoEscolherUC escolherUC = new JAlunoEscolherUC(this.sgt);
        this.setVisible(false);
        escolherUC.setVisible(true);
        escolherUC.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent windowEvent) {
                reOpen();
            }
        });
    }//GEN-LAST:event_jButtonEscolherUCsActionPerformed

    private void reOpen() {
        this.setVisible(true);
    }

    private void jButtonPedirTrocaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPedirTrocaActionPerformed
        JAlunoPedirTroca pedirTroca = new JAlunoPedirTroca(this.sgt);
        pedirTroca.setVisible(true);
        this.setVisible(false);
        pedirTroca.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent windowEvent) {
                reOpen();
            }
        });
    }//GEN-LAST:event_jButtonPedirTrocaActionPerformed

    private void jTablePropsTrocaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePropsTrocaMouseClicked
        //TODO double click
        int selectedRow = this.jTablePropsTroca.getSelectedRow();
        Pedido pedido = this.sugTroca.get(selectedRow);
        String uc = pedido.getUc();
        int turno = pedido.getTurno();
        boolean ePratico = pedido.ePratico();
        try {
            int response;
            if(this.sgt.horarioConflicts((Aluno) this.sgt.getLoggedUser(), uc,turno,ePratico)){
                response = JOptionPane.showConfirmDialog(null,
                        "O turno selecionado entra em conflito com o seu horário. Quer continuar?",
                        "Conflito de turnos", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            }else{
                response = JOptionPane.showConfirmDialog(null,
                        "Tem a certeza que pretende trocar para este turno?",
                        "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            }
            if (response == JOptionPane.YES_OPTION) {
                this.sgt.realizarTroca(pedido);
            }
        } catch (InvalidUserTypeException | ClassCastException e) {
            this.dispose();
        } catch (AlunoNaoEstaInscritoNaUcException | UtilizadorJaExisteException e) {
            this.updateSugestTroca();
        }
    }//GEN-LAST:event_jTablePropsTrocaMouseClicked

    private void jButtonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoutActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonLogoutActionPerformed

    @Override
    public void update(Observable observable, Object o) {
        if(o instanceof Integer){
            switch ((Integer) o) {
                case ALUNO_ADDED_TO_UC:
                case ALUNO_REMOVED_FROM_UC:
                    updateUserUCs();
                    break;
                case TROCA_REALIZADA:
                    updateSugestTroca();
                    break;
                case LOGINS_ATIVADOS:
                    this.jButtonEscolherUCs.setEnabled(false);
                    this.jButtonPedirTroca.setEnabled(true);
                    break;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JAluno(new SGT()).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEscolherUCs;
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JButton jButtonPedirTroca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPanePropsTroca;
    private javax.swing.JScrollPane jScrollPaneUCsETurnos;
    private javax.swing.JTable jTablePropsTroca;
    private javax.swing.JTable jTableUCsETurnos;
    // End of variables declaration//GEN-END:variables
}
