package com.agencia.turismo.gui;

import com.agencia.turismo.gui.Registro;
import com.agencia.turismo.service.Ingresar;
public class Login extends javax.swing.JFrame {
    int id;
 Ingresar ingresar = new Ingresar(); 
    public Login() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LOGO = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        BIniciarSesion = new javax.swing.JButton();
        contrasena = new javax.swing.JPasswordField();
        jButton3 = new javax.swing.JButton();
        BRregresar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(812, 450));
        setPreferredSize(new java.awt.Dimension(812, 450));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(LOGO, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 100, 70));

        jLabel3.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("USUARIO");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 150, -1));

        usuario.setToolTipText("");
        usuario.setBorder(null);
        usuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioActionPerformed(evt);
            }
        });
        getContentPane().add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 240, 40));
        usuario.getAccessibleContext().setAccessibleName("");

        jLabel4.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("PASSWORD");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 160, -1));

        BIniciarSesion.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        BIniciarSesion.setText("iniciar sesión");
        BIniciarSesion.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        BIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BIniciarSesionActionPerformed(evt);
            }
        });
        getContentPane().add(BIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 180, 40));

        contrasena.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(contrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, 240, 40));

        jButton3.setText("REGISTRARSE");
        jButton3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, 120, 30));

        BRregresar.setText("REGRESAR");
        BRregresar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        BRregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRregresarActionPerformed(evt);
            }
        });
        getContentPane().add(BRregresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, 120, 30));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 80, 70));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 814, 464));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Registro rg = new  Registro();
        rg.setVisible(true);
        this.setVisible (false);         
    }//GEN-LAST:event_jButton3ActionPerformed

    private void BIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BIniciarSesionActionPerformed
       
        String user = usuario.getText();
        char[] pass = contrasena.getPassword();
        String password = new String(pass);
        boolean result = ingresar.checkLogin(user, password);
        this.id =ingresar.getId(); 
        
        ingresar.showLoginResult(result);

        if (result) {
            this.setVisible(false);
        }
    }//GEN-LAST:event_BIniciarSesionActionPerformed

    private void BRregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRregresarActionPerformed
        new Inicio().setVisible(true); 
        this.setVisible(false);
    }//GEN-LAST:event_BRregresarActionPerformed

    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BIniciarSesion;
    private javax.swing.JButton BRregresar;
    private javax.swing.JLabel LOGO;
    private javax.swing.JPasswordField contrasena;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
