package com.agencia.turismo.service;

import com.agencia.turismo.repository.MariaDBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Admintrador {
    MariaDBConnection mdbc= new MariaDBConnection();
    
    public void mostarReservas(String name, JTable tabla){
        String query = "SELECT \n" +
            "    'hotels' AS Tipo,\n" +
            "    h.name AS Nombre,\n" +
            "    bd.booking_date AS FechaReserva,\n" +
            "    bd.return_date AS FechaRegreso,\n" +
            "    bd.cancellation AS Cancelacion,\n" +
            "    bd.creation_date AS FechaCreacion,\n" +
            "    bd.pagado AS Pagado\n" +
            "FROM hotels h\n" +
            "INNER JOIN booking b ON b.hotel_id = h.id\n" +
            "INNER JOIN booking_dates bd ON b.dates_id = bd.id\n" +
            "WHERE b.account_id = 1\n" +
            "\n" +
            "UNION\n" +
            "\n" +
            "SELECT \n" +
            "    'airlines' AS Tipo,\n" +
            "    a.name AS Nombre,\n" +
            "    bd.booking_date AS FechaReserva,\n" +
            "    bd.return_date AS FechaRegreso,\n" +
            "    bd.cancellation AS Cancelacion,\n" +
            "    bd.creation_date AS FechaCreacion,\n" +
            "    bd.pagado AS Pagado\n" +
            "FROM airlines a\n" +
            "INNER JOIN booking b ON b.airline_id = a.id\n" +
            "INNER JOIN booking_dates bd ON b.dates_id = bd.id\n" +
            "WHERE b.account_id = ?";
        String[] datos = new String[7];
    try (Statement st = mdbc.getConn().createStatement();
         ResultSet rs = st.executeQuery(query)) {

        // Define el modelo de la tabla
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Tipo");
        model.addColumn("Nombre");
        model.addColumn("FechaReserva");
        model.addColumn("FechaRegreso");
        model.addColumn("Cancelacion");
        model.addColumn("FechaCreacion");
        model.addColumn("Pagado");

        // Llena el modelo con los datos obtenidos
        while (rs.next()) {
            String userId = rs.getString("Tipo");
            String userName = rs.getString("Nombre");
            String userFRA = rs.getString("FechaReserva");
            String userFRO = rs.getString("FechaRegreso");
            String userC = rs.getString("Cancelacion");
            String userCR = rs.getString("FechaCreacion");
            String userP = rs.getString("Pagado");

            datos[0] = userId;
            datos[1] = userName;
            datos[2] = userFRA;
            datos[3] = userFRO;
            datos[4] = userC;
            datos[5] = userCR;
            datos[6] = userP;

            // Agrega la fila al modelo
            model.addRow(datos);
        }

        // Establece el modelo en la tabla
        tabla.setModel(model);

    } catch (SQLException e) {
        System.out.println("No se pudo obtener la descripción: " + e);
    }
    }
    public void mostar(){
        
    }
    public void eliminar(){
      
    }
}
