package com.agencia.turismo.gui;

import com.agencia.turismo.service.MostrarCarrito;

public class Admin extends javax.swing.JFrame {
    int id; 
    MostrarCarrito mc= new MostrarCarrito();
    String eleccion;
    String eleccion2;
    public Admin(int id) {
        initComponents();
        //eleccion = (String) CBEleccion1.getSelectedItem();
        //mc.mostrarProductos(eleccion, "name", CBEleccion2);
        this.id = id;
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
        txt8 = new javax.swing.JLabel();
        txt1 = new javax.swing.JLabel();
        txt2 = new javax.swing.JLabel();
        txt3 = new javax.swing.JLabel();
        txt4 = new javax.swing.JLabel();
        txt5 = new javax.swing.JLabel();
        txt6 = new javax.swing.JLabel();
        txt7 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtAero = new javax.swing.JTextField();
        txtTipoVuelo = new javax.swing.JTextField();
        txtOrigen = new javax.swing.JTextField();
        txtFinal = new javax.swing.JTextField();
        txtPais = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
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
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, -1, -1));

        jButton2.setText("AGREGAR");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, -1, -1));

        BCerrarSesion.setText("Cerrar Sesion");
        BCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCerrarSesionActionPerformed(evt);
            }
        });
        getContentPane().add(BCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, -1, -1));

        txt8.setText("Fecha de creacion");
        getContentPane().add(txt8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        txt1.setText("Nombre");
        getContentPane().add(txt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        txt2.setText("Numero de aroelinia");
        getContentPane().add(txt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        txt3.setText("Tipo de Vuelo");
        getContentPane().add(txt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        txt4.setText("Destino Origen");
        getContentPane().add(txt4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        txt5.setText("Destino Final");
        getContentPane().add(txt5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        txt6.setText("Pais");
        getContentPane().add(txt6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        txt7.setText("Precio");
        getContentPane().add(txt7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        txtFecha.setEditable(false);
        getContentPane().add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 200, -1));
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 200, -1));
        getContentPane().add(txtAero, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 200, -1));
        getContentPane().add(txtTipoVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 200, -1));
        getContentPane().add(txtOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 200, -1));
        getContentPane().add(txtFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 200, -1));
        getContentPane().add(txtPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 200, -1));
        getContentPane().add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 200, -1));

        CBEleccion1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        CBEleccion1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "airlines", "tours", "hotels" }));
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
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, -1, -1));

        jButton5.setText("ELIMINAR");
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CBEleccion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBEleccion2ActionPerformed
        eleccion = (String) CBEleccion1.getSelectedItem();
        eleccion2 = (String) CBEleccion2.getSelectedItem();
        
        if( eleccion == "hotels"){ 
            mc.mostrarContenidoHoteles(eleccion2);
            txtName.setText(mc.getName());
            
            txt2.setText("Tipo de Hotel");
            txtAero.setText(mc.getNumberAirline());
            txt3.setText("Dirreción");
            txtTipoVuelo.setText(mc.getTypeAirlines());
            txt4.setEnabled(false);
            txtOrigen.setEnabled(false);
            txt5.setEnabled(false);
            txtFinal.setEnabled(false);
            txtPais.setText(mc.getCoutry());
            txtPrecio.setText( String.valueOf(mc.getPrice()));
            txtFecha.setText(String.valueOf(mc.getCreationDate()));
        }else if (eleccion == "airlines"){
            mc.mostrarContenidoVuelos(eleccion2);
            txtName.setText(mc.getName());
            txt2.setText("Numero de airolinea");
            txtAero.setText(mc.getNumberAirline());
            txt3.setText("Tipo de vuelo");
            txtTipoVuelo.setText(mc.getTypeAirlines());
            txt4.setEnabled(true);
            txtOrigen.setEnabled(true);
            txt4.setText("Destino Origen");
            txtOrigen.setText(mc.getDestinyOrigin());
            txt5.setEnabled(true);
            txtFinal.setEnabled(true);
            txtFinal.setText(mc.getDestinyEnd());
            txtPais.setText(mc.getCoutry());
            txtPrecio.setText( String.valueOf(mc.getPrice()));
            txtFecha.setText(String.valueOf(mc.getCreationDate()));
        }else if (eleccion == "tours"){
            mc.mostrarContenidoTours(eleccion2);
            txtName.setText(mc.getName());
            
            txt2.setText("Descripcion");
            txtAero.setText(mc.getNumberAirline());
            
            txt3.setText("Duracion");
            txtTipoVuelo.setText(mc.getTypeAirlines());
            
            txt4.setEnabled(true);
            txtOrigen.setEnabled(true);
            txt4.setText("Destino");
            txtOrigen.setText(mc.getDestinyOrigin());      
            
            txt5.setEnabled(false);
            txtFinal.setEnabled(false);
            
            txtPais.setText(mc.getCoutry());
            txtPrecio.setText( String.valueOf(mc.getPrice()));
            txtFecha.setText(String.valueOf(mc.getCreationDate()));
        
        } 
    }//GEN-LAST:event_CBEleccion2ActionPerformed

    private void CBEleccion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBEleccion1ActionPerformed
        CBEleccion2.removeAllItems();
        
        eleccion = (String) CBEleccion1.getSelectedItem();
        mc.mostrarProductos( eleccion, "name", CBEleccion2);
    }//GEN-LAST:event_CBEleccion1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new AdimUser(this.id).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void BCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCerrarSesionActionPerformed
        new Inicio().setVisible(true); 
        this.setVisible(false);
    }//GEN-LAST:event_BCerrarSesionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        eleccion = (String) CBEleccion1.getSelectedItem();
        eleccion2 = (String) CBEleccion2.getSelectedItem();
        
        if( eleccion == "hotels"){ 
            mc.modificarHotel(txtName.getText(),txtAero.getText(),txtTipoVuelo.getText(), txtPais.getText(),txtPrecio.getText(), eleccion2);
        }else if (eleccion == "airlines"){
            mc.modificarAir(txtName.getText(),txtAero.getText(),txtTipoVuelo.getText(), txtOrigen.getText(),txtFinal.getText() , txtPais.getText(),txtPrecio.getText(), eleccion2);
        }else if (eleccion == "tours"){
            mc.modificarTour(txtName.getText(),txtAero.getText(),txtTipoVuelo.getText(), txtOrigen.getText(), txtPais.getText(),txtPrecio.getText(), txtName.getText());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel txt1;
    private javax.swing.JLabel txt2;
    private javax.swing.JLabel txt3;
    private javax.swing.JLabel txt4;
    private javax.swing.JLabel txt5;
    private javax.swing.JLabel txt6;
    private javax.swing.JLabel txt7;
    private javax.swing.JLabel txt8;
    private javax.swing.JTextField txtAero;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtFinal;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtOrigen;
    private javax.swing.JTextField txtPais;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTipoVuelo;
    // End of variables declaration//GEN-END:variables
}
