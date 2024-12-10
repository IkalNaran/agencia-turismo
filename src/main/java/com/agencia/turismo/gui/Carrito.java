package com.agencia.turismo.gui;

import com.agencia.turismo.service.AgregarCarrito;
import com.agencia.turismo.service.MostrarCarrito;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Carrito extends javax.swing.JFrame {
int id;
String columna;
String produto;
AgregarCarrito mc = new AgregarCarrito();

AgregarCarrito carrito = new AgregarCarrito();

    public Carrito(int id){
        this.id = id;
        initComponents();  
    }
    
    public Carrito() {
        initComponents();       
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        bRegresar = new javax.swing.JButton();
        btReservaciones = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        BPagar = new javax.swing.JButton();
        bteliminar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(812, 450));
        setMinimumSize(new java.awt.Dimension(812, 450));
        setPreferredSize(new java.awt.Dimension(812, 450));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Carrito");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, 50));

        bRegresar.setText("Regresar");
        bRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(bRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        btReservaciones.setText("Mostrar Reservaciones");
        btReservaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReservacionesActionPerformed(evt);
            }
        });
        getContentPane().add(btReservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, -1, -1));

        jScrollPane1.setViewportView(tabla1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 620, 280));

        BPagar.setBackground(new java.awt.Color(102, 255, 102));
        BPagar.setText("Pagar");
        BPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BPagarActionPerformed(evt);
            }
        });
        getContentPane().add(BPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 370, -1, -1));

        bteliminar.setText("Eliminar");
        bteliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bteliminarActionPerformed(evt);
            }
        });
        getContentPane().add(bteliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 370, -1, -1));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 450));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btReservacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReservacionesActionPerformed
        mc.mostarReservas(id, tabla1);

    }//GEN-LAST:event_btReservacionesActionPerformed

    private void bRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRegresarActionPerformed
        new Reserva(this.id).setVisible(true); 
        this.setVisible(false);
    }//GEN-LAST:event_bRegresarActionPerformed

    private void bteliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bteliminarActionPerformed
        int selectedRow = tabla1.getSelectedRow();
        
        if (selectedRow != -1) {
            columna =  tabla1.getValueAt(selectedRow, 0).toString();
            produto =  tabla1.getValueAt(selectedRow, 1).toString();
            System.out.println("ID seleccionado: " + id);
            mc.deleteCarrito(columna + "s",columna,produto,this.id);
            mc.mostarReservas(id, tabla1);
        }else {
            System.out.println("No se ha seleccionado ninguna fila.");
        }
      
    }//GEN-LAST:event_bteliminarActionPerformed

    private void BPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BPagarActionPerformed
        int selectedRow = tabla1.getSelectedRow();
        
        if (selectedRow != -1) {
            columna =  tabla1.getValueAt(selectedRow, 0).toString();
            produto =  tabla1.getValueAt(selectedRow, 1).toString();
            System.out.println("ID seleccionado: " + id);
            JOptionPane.showMessageDialog(null, "¡La reserva ha sido pagada exitosamente!", "Información", JOptionPane.INFORMATION_MESSAGE);
            mc.pagar(columna + "s",columna,this.id,produto );
            mc.mostarReservas(id, tabla1);
        }else {
            System.out.println("No se ha seleccionado ninguna fila.");
        }
    }//GEN-LAST:event_BPagarActionPerformed

   
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
    private javax.swing.JButton BPagar;
    private javax.swing.JButton bRegresar;
    private javax.swing.JButton btReservaciones;
    private javax.swing.JButton bteliminar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla1;
    // End of variables declaration//GEN-END:variables
}
