package com.agencia.turismo.service;

import com.agencia.turismo.repository.MariaDBConnection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.mariadb.jdbc.Connection;

public class AgregarCarrito {
    MariaDBConnection mdbc = new MariaDBConnection();
    private int id; 
    private int idProductos;

    public AgregarCarrito() {
        
    }
    
    public void setId(int id){
        this.id = id;
    }

    public void setIdProducto(String tabla, String name) {
        String query = "SELECT id FROM " + tabla + " WHERE name = ?";
        try (PreparedStatement pdst = mdbc.getConn().prepareStatement(query)) {
            pdst.setString(1, name);

            try (ResultSet rs = pdst.executeQuery()) {
                if (rs.next()) {
                    this.idProductos = rs.getInt("id");
                } else {
                    System.out.println("Producto no encontrado en la tabla " + tabla);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el ID del producto: " + e.getMessage());
        }
    }

    public boolean insertBookingTours(Date fecha) {
        String queryBookd = "INSERT INTO booking_dates (booking_date) VALUES (?)";
        String queryBooking = "INSERT INTO booking (account_id, tour_id, dates_id) VALUES (?,?,?)";

        try (Connection conn = mdbc.getConn()) {
            conn.setAutoCommit(false);

            try (PreparedStatement pdstBGD = conn.prepareStatement(queryBookd, Statement.RETURN_GENERATED_KEYS);
                 PreparedStatement pdstBG = conn.prepareStatement(queryBooking, Statement.RETURN_GENERATED_KEYS)) {

                // Insertar en la tabla de fechas
                pdstBGD.setDate(1, fecha);
                pdstBGD.executeUpdate();

                int datesId;
                try (ResultSet key = pdstBGD.getGeneratedKeys()) {
                    if (key.next()) {
                        datesId = key.getInt(1);
                        System.out.println("ID generado para booking_dates: " + datesId);
                    } else {
                        throw new SQLException("No se pudo obtener el ID generado para booking_dates.");
                    }
                }

                // Insertar en la tabla de reservas
                pdstBG.setInt(1, this.id);
                pdstBG.setInt(2, this.idProductos);
                pdstBG.setInt(3, datesId);
                pdstBG.executeUpdate();

                conn.commit();
                JOptionPane.showMessageDialog(null, "¡Reserva agregada correctamente!");
                return true;

            } catch (SQLException e) {
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Error al agregar la reserva: " + e.getMessage());
                return false;

            } finally {
                conn.setAutoCommit(true);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión: " + e.getMessage());
            return false;
        }
    }
    
    public boolean insertBookingVuelos(Date fechaInicio, Date fechaFin) {
        String queryBookd = "INSERT INTO booking_dates (booking_date, return_date) VALUES (?, ?)";
        String queryBooking = "INSERT INTO booking (account_id, airline_id, dates_id) VALUES (?,?,?)";

        try (Connection conn = mdbc.getConn()) {
            conn.setAutoCommit(false);

            try (PreparedStatement pdstBGD = conn.prepareStatement(queryBookd, Statement.RETURN_GENERATED_KEYS);
                 PreparedStatement pdstBG = conn.prepareStatement(queryBooking, Statement.RETURN_GENERATED_KEYS)) {

                // Insertar en la tabla de fechas
                pdstBGD.setDate(1, fechaInicio);
                pdstBGD.setDate(2, fechaFin);
                pdstBGD.executeUpdate();

                int datesId;
                try (ResultSet key = pdstBGD.getGeneratedKeys()) {
                    if (key.next()) {
                        datesId = key.getInt(1);
                        System.out.println("ID generado para booking_dates: " + datesId);
                    } else {
                        throw new SQLException("No se pudo obtener el ID generado para booking_dates.");
                    }
                }

                // Insertar en la tabla de reservas
                pdstBG.setInt(1, this.id);
                pdstBG.setInt(2, this.idProductos);
                pdstBG.setInt(3, datesId);
                pdstBG.executeUpdate();

                conn.commit();
                JOptionPane.showMessageDialog(null, "¡Reserva agregada correctamente!");
                return true;

            } catch (SQLException e) {
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Error al agregar la reserva: " + e.getMessage());
                return false;

            } finally {
                conn.setAutoCommit(true);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión: " + e.getMessage());
            return false;
        }
    }
    
    public boolean insertBookingHoteles(Date fechaInicio, Date fechaFin) {
        String queryBookd = "INSERT INTO booking_dates (booking_date, return_date) VALUES (?, ?)";
        String queryBooking = "INSERT INTO booking (account_id, hotel_id, dates_id) VALUES (?,?,?)";

        try (Connection conn = mdbc.getConn()) {
            conn.setAutoCommit(false);

            try (PreparedStatement pdstBGD = conn.prepareStatement(queryBookd, Statement.RETURN_GENERATED_KEYS);
                 PreparedStatement pdstBG = conn.prepareStatement(queryBooking, Statement.RETURN_GENERATED_KEYS)) {

                // Insertar en la tabla de fechas
                pdstBGD.setDate(1, fechaInicio);
                pdstBGD.setDate(2, fechaFin);
                pdstBGD.executeUpdate();

                int datesId;
                try (ResultSet key = pdstBGD.getGeneratedKeys()) {
                    if (key.next()) {
                        datesId = key.getInt(1);
                        System.out.println("ID generado para booking_dates: " + datesId);
                    } else {
                        throw new SQLException("No se pudo obtener el ID generado para booking_dates.");
                    }
                }

                // Insertar en la tabla de reservas
                pdstBG.setInt(1, this.id);
                pdstBG.setInt(2, this.idProductos);
                pdstBG.setInt(3, datesId);
                pdstBG.executeUpdate();

                conn.commit();
                JOptionPane.showMessageDialog(null, "¡Reserva agregada correctamente!");
                return true;

            } catch (SQLException e) {
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Error al agregar la reserva: " + e.getMessage());
                return false;

            } finally {
                conn.setAutoCommit(true);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión: " + e.getMessage());
            return false;
        }
    }
    
    public void mostarReservas(int accountId, JTable tabla) {
    String query = "SELECT \n" +
        "    'tours' AS Tipo,\n" +
        "    t.name AS Nombre,\n" +
        "    bd.booking_date AS FechaReserva,\n" +
        "    bd.return_date AS FechaRegreso,\n" +
        "    bd.pagado AS Pagado,\n" +
        "    t.price AS Precio\n" +
        "FROM tours t\n" +
        "INNER JOIN booking b ON b.tour_id = t.id\n" +
        "INNER JOIN booking_dates bd ON b.dates_id = bd.id\n" +
        "WHERE b.account_id = ?\n" +
        "\n" +
        "UNION\n" +
        "\n" +
        "SELECT \n" +
        "    'hotels' AS Tipo,\n" +
        "    h.name AS Nombre,\n" +
        "    bd.booking_date AS FechaReserva,\n" +
        "    bd.return_date AS FechaRegreso,\n" +
        "    bd.pagado AS Pagado,\n" +
        "    h.price AS Precio\n" +
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
        "    bd.pagado AS Pagado,\n" +
        "    a.price AS Precio\n" +
        "FROM airlines a\n" +
        "INNER JOIN booking b ON b.airline_id = a.id\n" +
        "INNER JOIN booking_dates bd ON b.dates_id = bd.id\n" +
        "WHERE b.account_id = ?";

    String[] columnNames = {"Tipo", "Nombre", "FechaReserva", "FechaRegreso", "Pagado", "Precio"};
    DefaultTableModel model = new DefaultTableModel();
    model.setColumnIdentifiers(columnNames);

    try (PreparedStatement pst = mdbc.getConn().prepareStatement(query)) {
        pst.setInt(1, accountId);
        pst.setInt(2, accountId);
        pst.setInt(3, accountId);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            String tipo = rs.getString("Tipo");
            String nombre = rs.getString("Nombre");
            String fechaReserva = rs.getString("FechaReserva");
            String fechaRegreso = rs.getString("FechaRegreso");
            String pagado = rs.getString("Pagado");
            String precio = rs.getString("Precio");

            Object[] datos = {tipo, nombre, fechaReserva, fechaRegreso, pagado, precio};
            model.addRow(datos);
        }

        tabla.setModel(model);
    } catch (SQLException e) {
        System.out.println("No se pudo obtener el carrito: " + e);
    }
}


}
