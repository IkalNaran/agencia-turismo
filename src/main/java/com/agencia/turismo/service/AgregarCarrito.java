package com.agencia.turismo.service;

import com.agencia.turismo.repository.MariaDBConnection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
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

}
