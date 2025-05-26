
package com.agencia.turismo.service;

import com.agencia.turismo.repository.oracleDBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.Connection;

public class Registrar {
    private oracleDBConnection mdbc = new oracleDBConnection();
    private int id; 
    private String name;
    private String password; 
    
   public boolean insertUsuario(String name, String lastname, int age, String phone, String username, String email, String password) {
        String queryClients = "INSERT INTO clients (name, lastname, age, phone) VALUES (?, ?, ?, ?)";
        String queryUsers = "INSERT INTO users (user_name, email, password) VALUES (?, ?, ?)";
        String queryUnion = "INSERT INTO accounts(user_id,client_id) value (?,?)";
        String querySelectUser = "SELECT id FROM clients WHERE phone = ?"; 
        String querySelectClients = "SELECT id FROM users WHERE user_name = ?";
        Connection conn = mdbc.getConn();
        
        try {
            conn.setAutoCommit(false); // Desactivar el auto-commit para manejar la transacción manualmente

            try (PreparedStatement pdstClients = conn.prepareStatement(queryClients, Statement.RETURN_GENERATED_KEYS);
                    PreparedStatement pdstUsers = conn.prepareStatement(queryUsers, Statement.RETURN_GENERATED_KEYS);
                    PreparedStatement pdstUnion = conn.prepareStatement(queryUnion)) {

                // Insertar en la tabla clients
                pdstClients.setString(1, name);
                pdstClients.setString(2, lastname);
                pdstClients.setInt(3, age);
                pdstClients.setString(4, phone);
                pdstClients.executeUpdate();

                // Insertar en la tabla users
                pdstUsers.setString(1, username);
                pdstUsers.setString(2, email);
                pdstUsers.setString(3, password);
                pdstUsers.executeUpdate();
                
                ResultSet generatedKeysClient = pdstClients.getGeneratedKeys();
                ResultSet generatedKeysUser = pdstUsers.getGeneratedKeys();
                if (generatedKeysClient.next() && generatedKeysUser.next()) {
                    int clientId = generatedKeysClient.getInt(1);
                    int userId = generatedKeysUser.getInt(1);

                    // Insertar en la tabla accounts
                    pdstUnion.setInt(1, userId);
                    pdstUnion.setInt(2, clientId); 
                    pdstUnion.executeUpdate();
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
