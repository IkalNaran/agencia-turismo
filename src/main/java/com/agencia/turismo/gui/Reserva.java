package com.agencia.turismo.gui;


public class Reserva extends javax.swing.JFrame {

    
    public Reserva() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bthoteles = new javax.swing.JButton();
        btvuelos = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        bttours = new javax.swing.JButton();
        btsalir = new javax.swing.JButton();
        btcarrito = new javax.swing.JButton();
        btcerrarsesion = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bthoteles.setText("Hoteles");
        bthoteles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthotelesActionPerformed(evt);
            }
        });
        getContentPane().add(bthoteles, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 100, -1));

        btvuelos.setText("Vuelos");
        btvuelos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btvuelosActionPerformed(evt);
            }
        });
        getContentPane().add(btvuelos, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 100, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI Historic", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("RESERVA YA!");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 150, 40));

        bttours.setText("Tours");
        bttours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttoursActionPerformed(evt);
            }
        });
        getContentPane().add(bttours, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 240, 100, -1));

        btsalir.setText("Salir");
        btsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsalirActionPerformed(evt);
            }
        });
        getContentPane().add(btsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 370, -1, -1));

        btcarrito.setIcon(new javax.swing.ImageIcon("C:\\Users\\Jefem\\OneDrive\\Documents\\agencia-turismo\\EXPLOREITIZ\\Compras car.png")); // NOI18N
        btcarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcarritoActionPerformed(evt);
            }
        });
        getContentPane().add(btcarrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 70, 40));

        btcerrarsesion.setText("cerrar sesion");
        btcerrarsesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcerrarsesionActionPerformed(evt);
            }
        });
        getContentPane().add(btcerrarsesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Jefem\\OneDrive\\Documents\\agencia-turismo\\EXPLOREITIZ\\Reserva Ya.png")); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bthotelesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthotelesActionPerformed
        // TODO add your handling code here:
        //new Hoteles().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bthotelesActionPerformed

    private void btvuelosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btvuelosActionPerformed
        // TODO add your handling code here:
        //new Vuelos().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btvuelosActionPerformed

    private void bttoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttoursActionPerformed
        // TODO add your handling code here:
        //new Tours().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bttoursActionPerformed

    private void btcarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcarritoActionPerformed
        // TODO add your handling code here:
        new Carrito().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btcarritoActionPerformed

    private void btcerrarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcerrarsesionActionPerformed
        // TODO add your handling code here:
        //new Login().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btcerrarsesionActionPerformed

    private void btsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsalirActionPerformed
        // TODO add your handling code here:
        //new Principal().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btsalirActionPerformed

    
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
            java.util.logging.Logger.getLogger(Reserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reserva().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btcarrito;
    private javax.swing.JButton btcerrarsesion;
    private javax.swing.JButton bthoteles;
    private javax.swing.JButton btsalir;
    private javax.swing.JButton bttours;
    private javax.swing.JButton btvuelos;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
