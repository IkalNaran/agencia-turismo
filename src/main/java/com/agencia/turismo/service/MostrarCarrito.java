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

  
