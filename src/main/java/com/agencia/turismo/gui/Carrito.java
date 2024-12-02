package com.agencia.turismo.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Carrito extends javax.swing.JFrame {

   
    public Carrito() {
        initComponents();
        
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        bRegresar = new javax.swing.JButton();
        btvaciarcarrito = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        bteliminar1 = new javax.swing.JButton();
        bteliminar2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(812, 450));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Carrito");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 100, 80));

        bRegresar.setText("Regresar");
        bRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(bRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, -1, -1));

        btvaciarcarrito.setText("Vaciar carrito");
        btvaciarcarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btvaciarcarritoActionPerformed(evt);
            }
        });
        getContentPane().add(btvaciarcarrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 370, -1, -1));

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Nombre"
            }
        ));
        jScrollPane1.setViewportView(tabla1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 390, 280));

        jButton1.setBackground(new java.awt.Color(102, 255, 102));
        jButton1.setText("Pagar");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 370, -1, -1));

        bteliminar1.setText("Eliminar");
        bteliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bteliminar1ActionPerformed(evt);
            }
        });
        getContentPane().add(bteliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 370, -1, -1));

        bteliminar2.setText("Eliminar");
        bteliminar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bteliminar2ActionPerformed(evt);
            }
        });
        getContentPane().add(bteliminar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 370, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Jefem\\OneDrive\\Documents\\agencia-turismo\\EXPLOREITIZ\\Carrito.png")); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btvaciarcarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btvaciarcarritoActionPerformed
        // TODO add your handling code here:
         int response = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que quieres vaciar el carrito?", "Confirmación", JOptionPane.YES_NO_OPTION);
        
        if (response == JOptionPane.YES_OPTION) {
            // Eliminar todos los registros de la tabla
            DefaultTableModel model = (DefaultTableModel) tabla1.getModel();
            model.setRowCount(0);  // Elimina todas las filas de la tabla
            JOptionPane.showMessageDialog(this, "Carrito vaciado con éxito.");
        }
    }//GEN-LAST:event_btvaciarcarritoActionPerformed

    private void bRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRegresarActionPerformed
        new Reserva().setVisible(true); 
        this.setVisible(false);
    }//GEN-LAST:event_bRegresarActionPerformed

    private void bteliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bteliminar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bteliminar1ActionPerformed

    private void bteliminar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bteliminar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bteliminar2ActionPerformed

   
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
            java.util.logging.Logger.getLogger(Carrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Carrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Carrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Carrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Carrito().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bRegresar;
    private javax.swing.JButton bteliminar1;
    private javax.swing.JButton bteliminar2;
    private javax.swing.JButton btvaciarcarrito;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla1;
    // End of variables declaration//GEN-END:variables
}
