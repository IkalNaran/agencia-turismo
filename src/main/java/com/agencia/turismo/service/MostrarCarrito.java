package com.agencia.turismo.service;

import com.agencia.turismo.repository.MariaDBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MostrarCarrito {
    MariaDBConnection mdbc= new MariaDBConnection();
    
    public void getDescription(String name, JTable tabla) {
    // Construye la consulta con el nombre de la tabla directamente
    String query = "SELECT * FROM " + name; 
    String[] datos = new String[5];
    try (Statement st = mdbc.getConn().createStatement();
         ResultSet rs = st.executeQuery(query)) {

        // Define el modelo de la tabla
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("user_name");
        model.addColumn("email");
        model.addColumn("password");
        model.addColumn("date_creation");

        // Llena el modelo con los datos obtenidos
        while (rs.next()) {
            String userId = rs.getString("id");
            String userName = rs.getString("user_name");
            String userEmail = rs.getString("email");
            String userPass = rs.getString("password");
            String userDate = rs.getString("date_creation");

            datos[0] = userId;
            datos[1] = userName;
            datos[2] = userEmail;
            datos[3] = userPass;
            datos[4] = userDate;

            // Agrega la fila al modelo
            model.addRow(datos);
        }

        // Establece el modelo en la tabla
        tabla.setModel(model);

    } catch (SQLException e) {
        System.out.println("No se pudo obtener la descripción: " + e);
    }
}

}
