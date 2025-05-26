package com.agencia.turismo.service;

import com.agencia.turismo.repository.oracleDBConnection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.Connection;

public class Tour {
    private oracleDBConnection mdbc = new oracleDBConnection();
    private List<String> hotelNames = new ArrayList<>();
    private int id_tour; 
    
    public void setName(){
        String query = "SELECT name FROM tours";
        try (PreparedStatement pdst = mdbc.getConn().prepareStatement(query)) {
            try (ResultSet rs = pdst.executeQuery()) {
                while(rs.next()){
                    String name = rs.getString("name");
                    hotelNames.add(name);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar los hoteles: " + e);
        }
    }
    
    public List<String> getName(){
        return hotelNames;
    }
    
    public String getDescription(String name){
        String query = "SELECT description FROM tours WHERE name=?";
        try (PreparedStatement pdst = mdbc.getConn().prepareStatement(query)) {
            pdst.setString(1, name);
            try (ResultSet rs = pdst.executeQuery()) {
                if (rs.next()) {
                    // Si hay un resultado, significa que el inicio de sesión fue exitoso
                    String userId = rs.getString("description");
                    return userId;                
                } else {
                    return "";
                }
            }
        } catch (SQLException e) {
            System.out.println("No se puedo obtener e descripcion: " + e);
            return "";
        }
    }
    
    public String getDestiny(String name){
        String query = "SELECT destiny FROM tours WHERE name=?";
        try (PreparedStatement pdst = mdbc.getConn().prepareStatement(query)) {
            pdst.setString(1, name);
            try (ResultSet rs = pdst.executeQuery()) {
                if (rs.next()) {
                    // Si hay un resultado, significa que el inicio de sesión fue exitoso
                    String userId = rs.getString("destiny");
                    return userId;                
                } else {
                    return "";
                }
            }
        } catch (SQLException e) {
            System.out.println("No se puedo obtener el destino: " + e);
            return "";
        }
        
    }
    
    
    public String getDuration(String name){
        String query = "SELECT duration FROM tours WHERE name=?";
        try (PreparedStatement pdst = mdbc.getConn().prepareStatement(query)) {
            pdst.setString(1, name);
            try (ResultSet rs = pdst.executeQuery()) {
                if (rs.next()) {
                    // Si hay un resultado, significa que el inicio de sesión fue exitoso
                    String userId = rs.getString("duration");
                    return userId;                
                } else {
                    return "";
                }
            }
        } catch (SQLException e) {
            System.out.println("No se puedo obtener la duracion del tour: " + e);
            return "";
        }
        
    }
    
    
    public String getCountry(String name){
        String query = "SELECT t.name FROM tours t JOIN country c ON t.country_id = c.id WHERE t.name=?";
        try (PreparedStatement pdst = mdbc.getConn().prepareStatement(query)) {
            pdst.setString(1, name);
            try (ResultSet rs = pdst.executeQuery()) {
                if (rs.next()) {
                    // Si hay un resultado, significa que el inicio de sesión fue exitoso
                    String userId = rs.getString("c.name");
                    return userId;                
                } else {
                    return "";
                }
            }
        } catch (SQLException e) {
            System.out.println("No se puedo obtener el pais: " + e);
            return "";
        }
        
    }
    
    public String getPrice(String name){
        String query = "SELECT price FROM tours WHERE name=?";
        try (PreparedStatement pdst = mdbc.getConn().prepareStatement(query)) {
            pdst.setString(1, name);
            try (ResultSet rs = pdst.executeQuery()) {
                if (rs.next()) {
                    // Si hay un resultado, significa que el inicio de sesión fue exitoso
                    String userId = rs.getString("price");
                    return userId;                
                } else {
                    return "";
                }
            }
        } catch (SQLException e) {
            System.out.println("No se puedo obtener el precio: " + e);
            return "";
        } 
    }
    
    public boolean agregar(String name, Date fecha, int idUser, int idTour){
        String query = "INSERT INTO booking_dates(booking_date) VALUES (?)";
        String query2 = "INSERT INTO booking(account_id,tour_id) VALUES (?,?')";
        Connection conn = mdbc.getConn();
        
        try {
            conn.setAutoCommit(false); // Desactivar el auto-commit para manejar la transacción manualmente

            try (PreparedStatement pdstClients = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                    PreparedStatement pdstUsers = conn.prepareStatement(query2, Statement.RETURN_GENERATED_KEYS)) {

                // Insertar en la tabla clients
                pdstClients.setDate(1, fecha);
                pdstClients.executeUpdate();

                // Insertar en la tabla users
                pdstUsers.setInt(1, idUser);
                pdstUsers.setInt(2, idTour);

                pdstUsers.executeUpdate();
                
                ResultSet generatedKeysClient = pdstClients.getGeneratedKeys();
                ResultSet generatedKeysUser = pdstUsers.getGeneratedKeys();
                if (generatedKeysClient.next() && generatedKeysUser.next()) {
                    int clientId = generatedKeysClient.getInt(1);
                    int userId = generatedKeysUser.getInt(1);

                    // Insertar en la tabla accounts
                    //pdstUnion.setInt(1, userId);
                    //pdstUnion.setInt(2, clientId); 
                    //pdstUnion.executeUpdate();
                }
                
                conn.commit(); // Confirmar la transacción
                JOptionPane.showMessageDialog(null, "Se a registrado correctamente!" );
                return true;
            } catch (SQLException e) {
                conn.rollback(); // Deshacer la transacción en caso de error
                System.out.println();
                JOptionPane.showMessageDialog(null, "Error al registrarte: " + e);
                return false;
            } finally {
                conn.setAutoCommit(true); // Restaurar el auto-commit
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión: " + e);
            return false;
        }
    }
}
