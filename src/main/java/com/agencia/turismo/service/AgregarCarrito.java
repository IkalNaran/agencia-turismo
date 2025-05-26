package com.agencia.turismo.service;

import com.agencia.turismo.repository.oracleDBConnection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;

public class AgregarCarrito {
    private oracleDBConnection mdbc = new oracleDBConnection();
    private int id; 
    private int idProductos;
    private String tipo;
    
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
        "    'tour' AS Tipo,\n" +
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
        "    'hotel' AS Tipo,\n" +
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
        "    'airline' AS Tipo,\n" +
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
            tipo = rs.getString("Tipo");
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
    
    public void deleteCarrito(String tabla, String columna, String idProducto, int idaccount) {
    // Validar que los nombres de tabla y columna sean seguros
    if (!tabla.matches("[a-zA-Z0-9_]+") || !columna.matches("[a-zA-Z0-9_]+")) {
        throw new IllegalArgumentException("Nombre de tabla o columna inválido");
    }

    // Construir la consulta con nombres de tabla y columna
    String sql = "DELETE b FROM booking b "
               + "INNER JOIN " + tabla + " t ON b." + columna + "_id = t.id "
               + "WHERE t.name = ? AND b.account_id = ?";

    try (PreparedStatement pst = mdbc.getConn().prepareStatement(sql)) {
        // Asignar valores a los parámetros
        pst.setString(1, idProducto);
        pst.setInt(2, idaccount);

        int rowsAffected = pst.executeUpdate();
        System.out.println("Rows affected: " + rowsAffected);

    } catch (SQLException e) {
        System.out.println("Error al eliminar: " + e.toString());
    }
}

    public double mostrarTotal(int accountId) {
        String query = "SELECT SUM(Precio) AS Total\n" +
                "FROM (\n" +
                "    SELECT t.price AS Precio\n" +
                "    FROM tours t\n" +
                "    INNER JOIN booking b ON b.tour_id = t.id\n" +
                "    INNER JOIN booking_dates bd ON b.dates_id = bd.id\n" +
                "    WHERE b.account_id = ?\n" +
                "    \n" +
                "    UNION ALL\n" +
                "    \n" +
                "    SELECT h.price AS Precio\n" +
                "    FROM hotels h\n" +
                "    INNER JOIN booking b ON b.hotel_id = h.id\n" +
                "    INNER JOIN booking_dates bd ON b.dates_id = bd.id\n" +
                "    WHERE b.account_id = ?\n" +
                "    \n" +
                "    UNION ALL\n" +
                "    \n" +
                "    SELECT a.price AS Precio\n" +
                "    FROM airlines a\n" +
                "    INNER JOIN booking b ON b.airline_id = a.id\n" +
                "    INNER JOIN booking_dates bd ON b.dates_id = bd.id\n" +
                "    WHERE b.account_id = ?\n" +
                ") AS TotalPrecios;";

        try (PreparedStatement pst = mdbc.getConn().prepareStatement(query)) {
            pst.setInt(1, accountId);
            pst.setInt(2, accountId);
            pst.setInt(3, accountId);
            ResultSet rs = pst.executeQuery();

            // Verificar si hay resultados
            if (rs.next()) {
                return rs.getDouble("Total"); // Accede al alias correcto
            } else {
                return 0.0; // Si no hay resultados, retorna 0
            }
        } catch (SQLException e) {
            System.out.println("No se pudo obtener el total: " + e.getMessage());
            return 0.0;
        }
    }
    
    public void pagar(String tabla, String columna, int id, String nombre) {
        String query = "UPDATE booking_dates bd\n" +
                       "INNER JOIN booking b ON b.dates_id = bd.id\n" +
                       "INNER JOIN " + tabla + " t ON b." + columna + "_id = t.id\n" +
                       "SET bd.pagado = 'SI'\n" +
                       "WHERE b.account_id = ? AND t.name = ?";

        try (PreparedStatement pst = mdbc.getConn().prepareStatement(query)) {
            pst.setInt(1, id); 
            pst.setString(2, nombre); 
            
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("La reserva ha sido marcada como pagada.");
            } else {
                System.out.println("No se encontró ninguna reserva para actualizar.");
            }
        } catch (SQLException e) {
            System.out.println("Error al marcar como pagado: " + e.getMessage());
        }
    }

    
}
