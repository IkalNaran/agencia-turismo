package com.agencia.turismo.service;

import com.agencia.turismo.repository.MariaDBConnection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MostrarCarrito {
    MariaDBConnection mdbc= new MariaDBConnection();
    private String name;
    private String numberAirline;
    private String typeAirline;
    private String destinyOrigin;
    private String destinyEnd;
    private String country;
    private double price;
    private Date creationDate;
    

    
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
    
    public void mostrarProductos(String tabla, String valor, JComboBox combo) {
        // Concatenar el nombre de la tabla directamente en la consulta
        String query = "SELECT * FROM " + tabla;

        try (PreparedStatement pdst = mdbc.getConn().prepareStatement(query)) {
            // Ejecutar la consulta
            ResultSet rs = pdst.executeQuery();

            // Iterar sobre el resultado y añadir los elementos al ComboBox
            while (rs.next()) {
                combo.addItem(rs.getString(valor)); 
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener " + tabla + ": " + e);
        }
    }
    
    public void mostrarContenidoHoteles(String name) {
        // Consulta SQL con un JOIN
        String query = "SELECT g.name, g.type_hotel, g.address, c.name as country, g.price, g.creation_date " +
                       "FROM hotels g " +
                       "INNER JOIN country c ON g.country_id = c.id " + 
                       "WHERE g.name = ?";

        try (PreparedStatement pdst = mdbc.getConn().prepareStatement(query)) {
            pdst.setString(1, name);
            ResultSet rs = pdst.executeQuery();

            // Comprobar si hay resultados
            if (rs.next()) {
                // Obtener los valores de las columnas
                this.name = rs.getString("name");
                this.numberAirline = rs.getString("type_hotel");
                this.typeAirline = rs.getString("address");
                this.country = rs.getString("country");  // Alias usado en la consulta
                this.price = rs.getDouble("price");
                this.creationDate = rs.getDate("creation_date");
            } else {
                System.out.println("No se encontró los hoteles con ese nombre.");
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener la aerolínea: " + e);
        }
    }

    public void mostrarContenidoVuelos(String airlineName) {
        // Consulta SQL con un JOIN
        String query = "SELECT g.name, g.number_airline, g.type_airline, g.destiny_origin, g.destiny_end, c.name as country, g.price, g.creation_date " +
                       "FROM airlines g " +
                       "INNER JOIN country c ON g.country_id = c.id " +  // Asegúrate de que 'c.id' es el campo correcto
                       "WHERE g.name = ?";

        try (PreparedStatement pdst = mdbc.getConn().prepareStatement(query)) {
            pdst.setString(1, airlineName);
            ResultSet rs = pdst.executeQuery();

            // Comprobar si hay resultados
            if (rs.next()) {
                // Obtener los valores de las columnas
                this.name = rs.getString("name");
                this.numberAirline = rs.getString("number_airline");
                this.typeAirline = rs.getString("type_airline");
                this.destinyOrigin = rs.getString("destiny_origin");
                this.destinyEnd = rs.getString("destiny_end");
                this.country = rs.getString("country");  // Alias usado en la consulta
                this.price = rs.getDouble("price");
                this.creationDate = rs.getDate("creation_date");

            } else {
                System.out.println("No se encontró la aerolínea con ese nombre.");
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener la aerolínea: " + e);
        }
    }

    
    public void mostrarContenidoTours(String hotelName) {
        // Consulta SQL con un JOIN
        String query = "SELECT g.name, g.description, g.duration, g.destiny, c.name as country, g.price, g.creation_date " +
                       "FROM tours g " +
                       "INNER JOIN country c ON g.country_id = c.id " + 
                       "WHERE g.name = ?";

        try (PreparedStatement pdst = mdbc.getConn().prepareStatement(query)) {
            pdst.setString(1, hotelName);
            ResultSet rs = pdst.executeQuery();

            // Comprobar si hay resultados
            if (rs.next()) {
                // Obtener los valores de las columnas
                this.name = rs.getString("name");
                this.numberAirline = rs.getString("description");
                this.typeAirline = rs.getString("duration");
                this.destinyOrigin = rs.getString("destiny");
                this.country = rs.getString("country");  // Alias usado en la consulta
                this.price = rs.getDouble("price");
                this.creationDate = rs.getDate("creation_date");

            } else {
                System.out.println("No se encontró la aerolínea con ese nombre.");
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener la aerolínea: " + e);
        }
    }
    
    public void modificarHotel(String hotelName, String typeHotel, String address, String country, String price, String currentHotelName) {
        String query = "UPDATE hotels h " +
                       "JOIN country c ON c.name = ? " + // País como parámetro
                       "SET h.name = ?, " +
                       "    h.type_hotel = ?, " +
                       "    h.address = ?, " +
                       "    h.country_id = c.id, " + // Asignar country_id basado en el país
                       "    h.price = ? " +
                       "WHERE h.name = ?"; // Nombre actual del hotel como parámetro

        try (PreparedStatement pdst = mdbc.getConn().prepareStatement(query)) {

            // Asignar valores a los parámetros
            pdst.setString(1, country);          // c.name
            pdst.setString(2, hotelName);       // h.name
            pdst.setString(3, typeHotel);       // h.type_hotel
            pdst.setString(4, address);         // h.address
            pdst.setString(5, price);           // h.price
            pdst.setString(6, currentHotelName);// h.name en WHERE

            // Ejecutar la consulta
            int rowsAffected = pdst.executeUpdate();
            System.out.println("Filas actualizadas: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public void modificarTour(String name, String description, String duration, String destiny,String country, String price, String currentName){
        String query = "UPDATE tours t " +
            "JOIN country c ON c.name = ? " +
            "SET t.name = ?," +
            "    t.description = ?," +
            "    t.duration = ?," +
            "    t.destiny = ?," +
            "    t.country_id = c.id," +
            "    t.price = ?" +
            "WHERE t.name = ?;"; // Nombre actual del hotel como parámetro

        try (PreparedStatement pdst = mdbc.getConn().prepareStatement(query)) {

            // Asignar valores a los parámetros
            pdst.setString(1, country);          // c.name
            pdst.setString(2, name);       // h.name
            pdst.setString(3, description);       // h.type_hotel
            pdst.setString(4, duration);         // h.address
            pdst.setString(5, destiny);           // h.price
            pdst.setString(6, price);// h.name en WHERE
            pdst.setString(7, currentName);// h.name en WHERE

            // Ejecutar la consulta
            int rowsAffected = pdst.executeUpdate();
            System.out.println("Filas actualizadas: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void modificarAir(String name, String typeAirline, String destinyOrigen, String destinyEnd,String country, String price,String currentName){
        String query = "UPDATE airlines t " +
            "JOIN country c ON c.name = ? " +
            "SET t.name = ?," +
            "    t.type_airline = ?," +
            "    t.destiny_origin = ?," +
            "    t.destiny_end = ?," +
            "    t.country_id = c.id," +
            "    t.price = ?" +
            "WHERE t.name = ?;"; // Nombre actual del hotel como parámetro

        try (PreparedStatement pdst = mdbc.getConn().prepareStatement(query)) {

            // Asignar valores a los parámetros
            pdst.setString(1, country);
            pdst.setString(2, name);
            pdst.setString(3, typeAirline);         
            pdst.setString(4, destinyOrigen);  
            pdst.setString(5, destinyEnd);
            pdst.setString(6, price);
            pdst.setString(7, currentName);

            // Ejecutar la consulta
            int rowsAffected = pdst.executeUpdate();
            System.out.println("Filas actualizadas: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public void agregarTour(String name, String description, String duration, String destiny, String price){
        String query = "INSERT INTO tours(name,DESCRIPTION,duration,destiny,price) VALUES (?,?,?,?,?)";
        try (PreparedStatement pdst = mdbc.getConn().prepareStatement(query)) {

            // Asignar valores a los parámetros
            pdst.setString(1, name);
            pdst.setString(2, description);
            pdst.setString(3, duration);         
            pdst.setString(4, destiny);  
            pdst.setString(5, price);

            // Ejecutar la consulta
            int rowsAffected = pdst.executeUpdate();
            System.out.println("Filas actualizadas: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void agregarHotel(String name, String description, String duration, String price){
        String query = "INSERT INTO hotels(name,type_hotel,address,price) VALUES (?,?,?,?)";
        try (PreparedStatement pdst = mdbc.getConn().prepareStatement(query)) {

            // Asignar valores a los parámetros
            pdst.setString(1, name);
            pdst.setString(2, description);
            pdst.setString(3, duration);          
            pdst.setString(4, price);

            // Ejecutar la consulta
            int rowsAffected = pdst.executeUpdate();
            System.out.println("Filas actualizadas: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    public void agregarAir(String name, String numberAirline, String typeAirline, String destinyOrigin,String destinyEnd, String price){
        String query = "INSERT INTO airlines(name,number_airline,type_airline,destiny_origin,destiny_end,price) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement pdst = mdbc.getConn().prepareStatement(query)) {

            // Asignar valores a los parámetros
            pdst.setString(1, name);
            pdst.setString(2, numberAirline);
            pdst.setString(3, typeAirline);         
            pdst.setString(4, destinyOrigin);
            pdst.setString(5, destinyEnd);
            pdst.setString(6, price);

            // Ejecutar la consulta
            int rowsAffected = pdst.executeUpdate();
            System.out.println("Filas actualizadas: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    public void eliminarTour(String name) {
    String query = "DELETE FROM tours WHERE name = ?";
    try (PreparedStatement pdst = mdbc.getConn().prepareStatement(query)) {
        pdst.setString(1, name);
        int rowsAffected = pdst.executeUpdate();
        
        if (rowsAffected > 0) {
            System.out.println("El tour '" + name + "' fue eliminado correctamente.");
        } else {
            System.out.println("No se encontró ningún tour con el nombre: " + name);
        }
    } catch (SQLException e) {
        System.err.println("Error al intentar eliminar el tour: " + name);
        e.printStackTrace();
    }
}
    
    public void eliminarAir(String name, String numberAirline) {
    String query = "DELETE FROM airlines WHERE name = ? AND number_airline = ?";
    try (PreparedStatement pdst = mdbc.getConn().prepareStatement(query)) {
        pdst.setString(1, name);
        pdst.setString(2, numberAirline);
        int rowsAffected = pdst.executeUpdate();
        
        if (rowsAffected > 0) {
            System.out.println("La aerolínea '" + name + "' con número '" + numberAirline + "' fue eliminada correctamente.");
        } else {
            System.out.println("No se encontró ninguna aerolínea con el nombre '" + name + "' y número '" + numberAirline + "'.");
        }
    } catch (SQLException e) {
        System.err.println("Error al intentar eliminar la aerolínea: " + name + " con número: " + numberAirline);
        e.printStackTrace();
    }
}

    
    public void eliminarHotel(String name) {
    String query = "DELETE FROM hotels WHERE name = ?";
    try (PreparedStatement pdst = mdbc.getConn().prepareStatement(query)) {
        pdst.setString(1, name);
        int rowsAffected = pdst.executeUpdate();
        
        if (rowsAffected > 0) {
            System.out.println("El hotel '" + name + "' fue eliminado correctamente.");
        } else {
            System.out.println("No se encontró ningún hotel con el nombre: '" + name + "'.");
        }
    } catch (SQLException e) {
        System.err.println("Error al intentar eliminar el hotel: '" + name + "'.");
        e.printStackTrace();
    }
}


    public String getName() {
        return name;
    }

    public String getNumberAirline() {
        return numberAirline;
    }

    public String getTypeAirlines() {
        return typeAirline;
    }

    public String getDestinyOrigin() {
        return destinyOrigin;
    }

    public String getDestinyEnd() {
        return destinyEnd;
    }

    public double getPrice() {
        return price;
    }

    public Date getCreationDate() {
        return creationDate;
    }
    public String getCoutry() {
        return country;
    }
}

  
