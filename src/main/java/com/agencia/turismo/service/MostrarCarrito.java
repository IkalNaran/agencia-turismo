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
    public void mostrarReservas(String accountId, JTable tabla) {
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
        "WHERE b.account_id = ?\n" +
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

    try (PreparedStatement ps = mdbc.getConn().prepareStatement(query)) {
        // Configura el parámetro del usuario
        ps.setString(1, accountId);
        ps.setString(2, accountId);

        // Ejecuta la consulta
        ResultSet rs = ps.executeQuery();

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
            model.addRow(new Object[]{
                rs.getString("Tipo"),
                rs.getString("Nombre"),
                rs.getString("FechaReserva"),
                rs.getString("FechaRegreso"),
                rs.getString("Cancelacion"),
                rs.getString("FechaCreacion"),
                rs.getString("Pagado")
            });
        }

        // Establece el modelo en la tabla
        tabla.setModel(model);

    } catch (SQLException e) {
        System.out.println("No se pudo consultar reservas: " + e.getMessage());
    }
}
public boolean modificarUsuario(String id, String user, String email, String password) {
    // Implementación para actualizar en la base de datos
    // Retorna true si la actualización fue exitosa, false en caso contrario.
        return false;
    // Implementación para actualizar en la base de datos
    // Retorna true si la actualización fue exitosa, false en caso contrario.
}

  

}
