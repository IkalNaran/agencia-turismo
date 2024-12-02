package com.agencia.turismo.gui;

public class Registro extends javax.swing.JFrame {

    public Registro() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtapellido = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtedad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtdireccion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtcontraseña = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(812, 450));
        setPreferredSize(new java.awt.Dimension(812, 450));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Nombre(obligatorio)");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 52, -1, -1));
        getContentPane().add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 74, 129, -1));

        jLabel5.setText("Apellido(obligatorio)");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 108, -1, -1));

        jLabel6.setText("Email(obligatorio)");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 164, -1, -1));
        getContentPane().add(txtapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 130, 129, -1));

        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });
        getContentPane().add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 186, 129, -1));

        jLabel7.setText("Edad(obligatorio)");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 214, -1, -1));
        getContentPane().add(txtedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 236, 129, -1));

        jLabel1.setText("Telefono(obligatorio)");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, -1, -1));
        getContentPane().add(txttelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, 130, -1));

        jLabel8.setText("Direccion(obligatorio)");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, -1, -1));
        getContentPane().add(txtdireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, 129, -1));

        jLabel9.setText("Usuario(obligatorio)");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 50, -1, -1));
        getContentPane().add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 114, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\Jefem\\OneDrive\\Documents\\agencia-turismo\\EXPLOREITIZ\\LOGO-removebg-preview (1).png")); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 140, 90));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Jefem\\OneDrive\\Documents\\agencia-turismo\\EXPLOREITIZ\\Registro.png")); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -13, 340, 480));

        jLabel10.setText("Contraseña(obligatorio)");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 110, -1, -1));
        getContentPane().add(txtcontraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 130, 114, -1));

        jButton1.setText("Registrarse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 380, -1, -1));

        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 380, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (txtnombre.getText().trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "El campo 'Nombre' es obligatorio.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (txtapellido.getText().trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "El campo 'Apellido' es obligatorio.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (txtemail.getText().trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "El campo 'Email' es obligatorio.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (txtedad.getText().trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "El campo 'Edad' es obligatorio.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (txttelefono.getText().trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "El campo 'Telefono' es obligatorio.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (txtdireccion.getText().trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "El campo 'Direccion' es obligatorio.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (txtusuario.getText().trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "El campo 'Usuario' es obligatorio.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (txtcontraseña.getText().trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "El campo 'Contraseña' es obligatorio.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        javax.swing.JOptionPane.showMessageDialog(this, "Registro exitoso.", "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);

        // Cerrar la ventana de registro
        this.dispose();

        // Abrir la ventana de login
        //new Login().setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new Inicio().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtcontraseña;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtedad;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
