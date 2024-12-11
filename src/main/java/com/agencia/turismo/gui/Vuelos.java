package com.agencia.turismo.gui;

import com.agencia.turismo.service.AgregarCarrito;
import com.agencia.turismo.service.Ingresar;
import com.agencia.turismo.service.Vuelo;
import com.toedter.calendar.JDateChooser;
import java.awt.Dimension;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Vuelos extends javax.swing.JFrame {
Vuelo vuelo = new Vuelo();
AgregarCarrito carrito = new AgregarCarrito();
Date selectedDate;
Date selectedDate2;
String nameVuelo;
Ingresar login;

int id;
    public Vuelos(int id) {
        initComponents();
        this.id = id;
        vuelo.setName();
        for (String name : vuelo.getName()){
            CBVuelos.addItem(name);
        }
    }
    
    public Vuelos() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CBVuelos = new javax.swing.JComboBox<>();
        BRegresar = new javax.swing.JButton();
        BAgregar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        precio = new javax.swing.JTextField();
        tipoVuelo = new javax.swing.JTextField();
        numero = new javax.swing.JTextField();
        destinoO = new javax.swing.JTextField();
        destinoF = new javax.swing.JTextField();
        pais = new javax.swing.JTextField();
        BFechaRegreso = new javax.swing.JButton();
        BFechaReserva = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        jLabel1.setPreferredSize(new java.awt.Dimension(812, 250));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel2.setText("Vuelos");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        CBVuelos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CBVuelos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elige el vuelo" }));
        CBVuelos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBVuelosActionPerformed(evt);
            }
        });
        getContentPane().add(CBVuelos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 140, 30));

        BRegresar.setBackground(new java.awt.Color(0, 0, 0));
        BRegresar.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        BRegresar.setForeground(new java.awt.Color(255, 255, 255));
        BRegresar.setText("Regresar");
        BRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(BRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, -1, -1));

        BAgregar.setBackground(new java.awt.Color(0, 0, 0));
        BAgregar.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        BAgregar.setForeground(new java.awt.Color(255, 255, 255));
        BAgregar.setText("Agregar");
        BAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(BAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, -1, -1));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Pais:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Numero airolinea:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Destino origen");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Destino Final");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, -1, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Precio:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, -1, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Tipo de vuelo:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));
        getContentPane().add(precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, 200, -1));
        getContentPane().add(tipoVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 260, -1));
        getContentPane().add(numero, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 260, -1));
        getContentPane().add(destinoO, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 260, -1));
        getContentPane().add(destinoF, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 260, -1));
        getContentPane().add(pais, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 220, -1));

        BFechaRegreso.setText("Fecha Regreso");
        BFechaRegreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BFechaRegresoActionPerformed(evt);
            }
        });
        getContentPane().add(BFechaRegreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, -1, -1));

        BFechaReserva.setText("Fecha Reserva");
        BFechaReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BFechaReservaActionPerformed(evt);
            }
        });
        getContentPane().add(BFechaReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, -1, -1));
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRegresarActionPerformed
        new Reserva(this.id).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BRegresarActionPerformed

    private void CBVuelosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBVuelosActionPerformed
        this.nameVuelo = (String) CBVuelos.getSelectedItem();
        tipoVuelo.setText(vuelo.getType(nameVuelo));
        numero.setText(vuelo.getNumberAir(nameVuelo));
        destinoO.setText(vuelo.getOrigin(nameVuelo));
        destinoF.setText(vuelo.getEnd(nameVuelo));
        pais.setText(vuelo.getCountry(nameVuelo));
        precio.setText("$" + vuelo.getPrice(nameVuelo) + " pesos");
    }//GEN-LAST:event_CBVuelosActionPerformed

    private void BFechaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BFechaReservaActionPerformed
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("dd/MM/yyyy"); // Formato de la fecha
        dateChooser.setPreferredSize(new Dimension(200, 30)); // Tamaño del componente

        // Crear un JPanel para añadir el JDateChooser
        JPanel panel = new JPanel();
        panel.add(dateChooser);

        // Mostrar el JDateChooser en un JOptionPane
        int option = JOptionPane.showConfirmDialog(null, panel, "Selecciona una Fecha", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            // Obtener la fecha seleccionada directamente como java.sql.Date
            selectedDate = new Date(dateChooser.getDate().getTime()); // Convertir a java.sql.Date
            if (selectedDate != null) {
                // Mostrar la fecha seleccionada
                JOptionPane.showMessageDialog(null, "Fecha seleccionada: " + selectedDate.toString());
            } else {
                JOptionPane.showMessageDialog(null, "No se seleccionó ninguna fecha.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Operación cancelada.");
        }

        // Usar la fecha fuera del bloque if
        if (selectedDate != null) {
            System.out.println("La fecha seleccionada es: " + selectedDate);
        } else {
            System.out.println("No se seleccionó ninguna fecha.");
        }
    }//GEN-LAST:event_BFechaReservaActionPerformed

    private void BAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAgregarActionPerformed
        carrito.setId(this.id);
        carrito.setIdProducto("airlines", nameVuelo);
        carrito.insertBookingVuelos(selectedDate,selectedDate2);
    }//GEN-LAST:event_BAgregarActionPerformed

    private void BFechaRegresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BFechaRegresoActionPerformed
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("dd/MM/yyyy"); // Formato de la fecha
        dateChooser.setPreferredSize(new Dimension(200, 30)); // Tamaño del componente

        // Crear un JPanel para añadir el JDateChooser
        JPanel panel = new JPanel();
        panel.add(dateChooser);

        // Mostrar el JDateChooser en un JOptionPane
        int option = JOptionPane.showConfirmDialog(null, panel, "Selecciona una Fecha", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            // Obtener la fecha seleccionada directamente como java.sql.Date
            selectedDate2 = new Date(dateChooser.getDate().getTime()); // Convertir a java.sql.Date
            if (selectedDate2 != null) {
                // Mostrar la fecha seleccionada
                JOptionPane.showMessageDialog(null, "Fecha seleccionada: " + selectedDate2.toString());
            } else {
                JOptionPane.showMessageDialog(null, "No se seleccionó ninguna fecha.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Operación cancelada.");
        }

        // Usar la fecha fuera del bloque if
        if (selectedDate2 != null) {
            System.out.println("La fecha seleccionada es: " + selectedDate2);
        } else {
            System.out.println("No se seleccionó ninguna fecha.");
        }
    }//GEN-LAST:event_BFechaRegresoActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vuelos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAgregar;
    private javax.swing.JButton BFechaRegreso;
    private javax.swing.JButton BFechaReserva;
    private javax.swing.JButton BRegresar;
    private javax.swing.JComboBox<String> CBVuelos;
    private javax.swing.JTextField destinoF;
    private javax.swing.JTextField destinoO;
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
    private javax.swing.JTextField numero;
    private javax.swing.JTextField pais;
    private javax.swing.JTextField precio;
    private javax.swing.JTextField tipoVuelo;
    // End of variables declaration//GEN-END:variables
}
