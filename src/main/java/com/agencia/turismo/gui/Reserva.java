package com.agencia.turismo.gui;


public class Reserva extends javax.swing.JFrame {
int id; 

    public Reserva(int id) {
        this.id = id;
        initComponents();
    }

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
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(812, 450));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bthoteles.setText("HOTELES");
        bthoteles.setBorder(null);
        bthoteles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthotelesActionPerformed(evt);
            }
        });
        getContentPane().add(bthoteles, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 140, 80));

        btvuelos.setText("VUELOS");
        btvuelos.setBorder(null);
        btvuelos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btvuelosActionPerformed(evt);
            }
        });
        getContentPane().add(btvuelos, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 140, 80));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI Historic", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("RESERVA YA!");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 150, 40));

        bttours.setText("TOURS");
        bttours.setBorder(null);
        bttours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttoursActionPerformed(evt);
            }
        });
        getContentPane().add(bttours, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 140, 80));

        btsalir.setText("SALIR");
        btsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsalirActionPerformed(evt);
            }
        });
        getContentPane().add(btsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 350, -1, -1));

        btcarrito.setMnemonic('c');
        btcarrito.setText("carrito");
        btcarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcarritoActionPerformed(evt);
            }
        });
        getContentPane().add(btcarrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 70, 40));

        btcerrarsesion.setText("CERRAR SESIÓN");
        btcerrarsesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcerrarsesionActionPerformed(evt);
            }
        });
        getContentPane().add(btcerrarsesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, -1, -1));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 450));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bthotelesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthotelesActionPerformed
        new Hotel(this.id).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bthotelesActionPerformed

    private void btvuelosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btvuelosActionPerformed
        new Vuelos(this.id).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btvuelosActionPerformed

    private void bttoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttoursActionPerformed
        new Tours(this.id).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bttoursActionPerformed

    private void btcarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcarritoActionPerformed
        Carrito carrito = new Carrito(this.id);
        carrito.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btcarritoActionPerformed

    private void btcerrarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcerrarsesionActionPerformed
        Inicio inicio = new Inicio(); 
        inicio.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btcerrarsesionActionPerformed

    private void btsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsalirActionPerformed
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
