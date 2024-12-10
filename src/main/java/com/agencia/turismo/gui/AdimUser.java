package com.agencia.turismo.gui;

import com.agencia.turismo.service.MostrarCarrito;

public class AdimUser extends javax.swing.JFrame {
    MostrarCarrito mc = new MostrarCarrito();
    int id; 

    public AdimUser() {
        initComponents();
    }
    
    public AdimUser(int id) {
        this.id = id; 
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        BEliminar = new javax.swing.JButton();
        BModificar1 = new javax.swing.JButton();
        BMostrar = new javax.swing.JButton();
        BRegresar = new javax.swing.JButton();
        BMostrarReservaciones = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        BModificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("ADMITRADOR USUARIOS");

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "user", "email", "password", "Fecha Creacion"
            }
        ));
        jScrollPane1.setViewportView(tabla1);

        BEliminar.setText("ELIMINAR");

        BModificar1.setText("MODIFICAR");

        BMostrar.setText("MOSTRAR");
        BMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BMostrarActionPerformed(evt);
            }
        });

        BRegresar.setText("REGRESAR");
        BRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRegresarActionPerformed(evt);
            }
        });

        BMostrarReservaciones.setText("MOSTRAR RESERVACIONES");
        BMostrarReservaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BMostrarReservacionesActionPerformed(evt);
            }
        });

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "tipo de producto", "nombre del producto", "fecha reserva", "Precio", "Pagado", "Cancelado", "Fecha Creacion"
            }
        ));
        jScrollPane2.setViewportView(table2);

        BModificar.setText("MODIFICAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BMostrarReservaciones)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(BRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BMostrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BModificar1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(BEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BModificar, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BMostrar)
                        .addGap(18, 18, 18)
                        .addComponent(BModificar1)
                        .addGap(18, 18, 18)
                        .addComponent(BEliminar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BMostrarReservaciones)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BModificar)
                        .addGap(18, 18, 18)
                        .addComponent(BRegresar)
                        .addGap(38, 38, 38)))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BMostrarActionPerformed
       
        mc.getDescription("users", tabla1);
    }//GEN-LAST:event_BMostrarActionPerformed

    private void BMostrarReservacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BMostrarReservacionesActionPerformed
        int selectedRow = tabla1.getSelectedRow(); // Obtiene la fila seleccionada

        if (selectedRow != -1) { // Verifica que haya una fila seleccionada
            // Obtiene el ID (columna 0)
            String id = tabla1.getValueAt(selectedRow, 0).toString(); // Asegúrate de que la columna 0 es el ID
            System.out.println("ID seleccionado: " + id);
            mc.mostrarReservas(id,table2);
        } else {
            System.out.println("No se ha seleccionado ninguna fila.");
        }
        
    }//GEN-LAST:event_BMostrarReservacionesActionPerformed

    private void BRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRegresarActionPerformed
        new Admin(this.id).setVisible(true);
    }//GEN-LAST:event_BRegresarActionPerformed

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
            java.util.logging.Logger.getLogger(AdimUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdimUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdimUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdimUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdimUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BEliminar;
    private javax.swing.JButton BModificar;
    private javax.swing.JButton BModificar1;
    private javax.swing.JButton BMostrar;
    private javax.swing.JButton BMostrarReservaciones;
    private javax.swing.JButton BRegresar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tabla1;
    private javax.swing.JTable table2;
    // End of variables declaration//GEN-END:variables
}
