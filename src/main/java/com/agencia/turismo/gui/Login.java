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

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usuario = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        contrasena = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        BIniciarSesion = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        BRregresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(812, 450));
        setPreferredSize(new java.awt.Dimension(812, 450));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 110, 70));

        usuario.setColumns(20);
        usuario.setRows(5);
        jScrollPane1.setViewportView(usuario);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 300, 40));

        jLabel3.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("EMAIL/USUARIO");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 150, -1));

        contrasena.setColumns(20);
        contrasena.setRows(5);
        jScrollPane2.setViewportView(contrasena);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, 300, 40));

        jLabel4.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("PASSWORD");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 160, -1));

        BIniciarSesion.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        BIniciarSesion.setText("INICIAR SESION");
        BIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BIniciarSesionActionPerformed(evt);
            }
        });
        getContentPane().add(BIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, 170, 30));

        jButton3.setText("!!REGISTRARSE AHORA!!");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 240, 30));

        BRregresar.setText("REGRESAR");
        BRregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRregresarActionPerformed(evt);
            }
        });
        getContentPane().add(BRregresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 360, 100, 30));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 814, 464));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, -1, 70));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 450));

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
        String pass = contrasena.getText();
    
        // Call checkLogin method to validate credentials
        boolean result = ingresar.checkLogin(user, pass);
        this.id =ingresar.getId(); 
    
        // Show the result of login attempt
    ingresar.showLoginResult(result);
    
    // If login was successful, hide the current form
    if (result) {
        this.setVisible(false);
    }
    }//GEN-LAST:event_BIniciarSesionActionPerformed

    private void BRregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRregresarActionPerformed
        new Inicio().setVisible(true); 
        this.setVisible(false);
    }//GEN-LAST:event_BRregresarActionPerformed

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
    private javax.swing.JTextArea contrasena;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea usuario;
    // End of variables declaration//GEN-END:variables
}
