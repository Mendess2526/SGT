/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.userInterface;

import main.sgt.SGT;
import main.sgt.Turno;
import main.sgt.exceptions.InvalidUserTypeException;

import javax.swing.table.DefaultTableModel;
import java.util.List;

import static main.userInterface.InterfaceUtils.makeComboBoxUCs;
import static main.userInterface.InterfaceUtils.makeShiftLookUpTable;

/**
 *
 * @author pedro
 */
@SuppressWarnings({"FieldCanBeLocal", "unused", "Convert2Lambda", "Anonymous2MethodRef", "TryWithIdenticalCatches"})
public class JAlunoPedirTroca extends javax.swing.JFrame {

    private final SGT sgt;
    private String uc;

    /**
     * Creates new form AlunoPedirTroca
     * @param sgt Business logic instance 
     */
    JAlunoPedirTroca(SGT sgt) {
        this.sgt = sgt;
        initComponents();
        initComboBoxUcs();
    }

    private void initComboBoxUcs() {
        try {
            this.uc = makeComboBoxUCs(this.jComboBoxUCs, this.sgt.getUCsOfUser());
        } catch (InvalidUserTypeException e) {
            this.setVisible(false);
            return;
        }
        updateTableTurnos();
    }

    private void updateTableTurnos() {
        if (this.uc == null){
            ((DefaultTableModel) this.jTableTurnos.getModel()).setRowCount(0);
            return;
        }
        List<Turno> turnosOfUC = this.sgt.getTurnosOfUC(this.uc);
        List<Turno> turnosUser;
        try {
            turnosUser = this.sgt.getTurnosUser();
        } catch (InvalidUserTypeException e) {
            this.setVisible(false);
            return;
        }
        turnosOfUC.removeAll(turnosUser);
        turnosOfUC.removeIf(t->!t.ePratico());
        this.jTableTurnos.setModel(makeShiftLookUpTable(this.jTableTurnos,turnosOfUC));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBoxUCs = new javax.swing.JComboBox<>();
        jLabelUCs = new javax.swing.JLabel();
        jScrollPaneTurnos = new javax.swing.JScrollPane();
        jTableTurnos = new javax.swing.JTable();
        jButtonPedir = new javax.swing.JButton();
        jButtonFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBoxUCs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxUCsActionPerformed(evt);
            }
        });

        jLabelUCs.setText("UCs");

        jTableTurnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Turnos", "Dia", "Hora de Inicio", "Hora de Fim"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPaneTurnos.setViewportView(jTableTurnos);

        jButtonPedir.setText("Pedir");
        jButtonPedir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPedirActionPerformed(evt);
            }
        });

        jButtonFechar.setText("Fechar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBoxUCs, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                                .addComponent(jButtonPedir))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelUCs)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPaneTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonFechar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabelUCs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxUCs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPedir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonFechar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPedirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPedirActionPerformed
        int turno = this.jTableTurnos.getSelectedRow();
        String uc  = (String) this.jComboBoxUCs.getSelectedItem();
        try {
            this.sgt.pedirTroca(uc,turno);
        } catch (InvalidUserTypeException e) {
            this.setVisible(false);
        }
    }//GEN-LAST:event_jButtonPedirActionPerformed

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt){//GEN-FIRST:event_jButtonFecharActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jComboBoxUCsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxUCsActionPerformed
        this.uc = (String) this.jComboBoxUCs.getSelectedItem();
        updateTableTurnos();
    }//GEN-LAST:event_jComboBoxUCsActionPerformed

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
            java.util.logging.Logger.getLogger(JAlunoPedirTroca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JAlunoPedirTroca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JAlunoPedirTroca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JAlunoPedirTroca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JAlunoPedirTroca(new SGT()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonPedir;
    private javax.swing.JComboBox<String> jComboBoxUCs;
    private javax.swing.JLabel jLabelUCs;
    private javax.swing.JScrollPane jScrollPaneTurnos;
    private javax.swing.JTable jTableTurnos;
    // End of variables declaration//GEN-END:variables
}
