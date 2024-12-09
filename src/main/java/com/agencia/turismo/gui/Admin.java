package com.agencia.turismo.gui;

public class Admin extends javax.swing.JFrame {
    int id; 
    public Admin(int id) {
        this.id = id;
        initComponents();
    }
    
    public Admin( ) {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        CBEleccion2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        BCerrarSesion = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtAero = new javax.swing.JTextField();
        txtTipoVuelo = new javax.swing.JTextField();
        txtOrigen = new javax.swing.JTextField();
        txtFinal = new javax.swing.JTextField();
        txtPais = new javax.swing.JTextField();
        precio = new javax.swing.JTextField();
        CBEleccion1 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(812, 450));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("ADMITRADOR");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        CBEleccion2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        CBEleccion2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elige Opcion" }));
        CBEleccion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBEleccion2ActionPerformed(evt);
            }
        });
        getContentPane().add(CBEleccion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 170, -1));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, -1, -1));

        jButton1.setText("MODIFICAR");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, -1, -1));

        jButton2.setText("AGREGAR");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, -1, -1));

        BCerrarSesion.setText("Cerrar Sesion");
        BCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCerrarSesionActionPerformed(evt);
            }
        });
        getContentPane().add(BCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, -1, -1));

        jLabel3.setText("Fecha de creacion");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        jLabel4.setText("Nombre");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel5.setText("Numero de aroelinia");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel6.setText("Tipo de Vuelo");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel7.setText("Destino Origen");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel8.setText("Destino Final");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel9.setText("Pais");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jLabel10.setText("Precio");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        jTextField1.setEditable(false);
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 200, -1));
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 200, -1));
        getContentPane().add(txtAero, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 200, -1));
        getContentPane().add(txtTipoVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 200, -1));
        getContentPane().add(txtOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 200, -1));
        getContentPane().add(txtFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 200, -1));
        getContentPane().add(txtPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 200, -1));
        getContentPane().add(precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 200, -1));

        CBEleccion1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        CBEleccion1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vuelos", "Tours", "Hoteles" }));
        CBEleccion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBEleccion1ActionPerformed(evt);
            }
        });
        getContentPane().add(CBEleccion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 170, -1));

        jButton4.setText("VER EMPLEADOS");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 390, -1, -1));

        jButton5.setText("ELIMINAR");
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 390, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CBEleccion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBEleccion2ActionPerformed

    }//GEN-LAST:event_CBEleccion2ActionPerformed

    private void CBEleccion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBEleccion1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBEleccion1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new AdimUser(this.id).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void BCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCerrarSesionActionPerformed
        new Inicio().setVisible(true); 
        this.setVisible(false);
    }//GEN-LAST:event_BCerrarSesionActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCerrarSesion;
    private javax.swing.JComboBox<String> CBEleccion1;
    private javax.swing.JComboBox<String> CBEleccion2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField precio;
    private javax.swing.JTextField txtAero;
    private javax.swing.JTextField txtFinal;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtOrigen;
    private javax.swing.JTextField txtPais;
    private javax.swing.JTextField txtTipoVuelo;
    // End of variables declaration//GEN-END:variables
}
