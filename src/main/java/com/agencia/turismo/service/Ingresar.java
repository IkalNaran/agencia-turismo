package com.agencia.turismo.service;

import com.agencia.turismo.gui.Admin;
import com.agencia.turismo.gui.Reserva;
import com.agencia.turismo.repository.MariaDBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Ingresar {
    MariaDBConnection mdbc = new MariaDBConnection();
    private int id; 
    private String name;
    private String password; 
    
    public Ingresar() {
        
    }

    public boolean checkLogin(String user, String password) {
        String query = "SELECT id FROM users WHERE user_name = ? AND password = ?";
        this.name = user; 
        this.password = password;
        try (PreparedStatement pdst = mdbc.getConn().prepareStatement(query)) {
            // Establecer los parámetros de la consulta
            pdst.setString(1, user);
            pdst.setString(2, password);

            // Ejecutar la consulta y obtener el resultado
            try (ResultSet rs = pdst.executeQuery()) {
                if (rs.next()) {
                    // Si hay un resultado, el inicio de sesión fue exitoso
                    this.id = rs.getInt("id");
                    return true;                
                } else {
                    return false;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al iniciar sesión: " + e);
            return false;
        }
    }

    public void showLoginResult(boolean success) {
        String message = success ? "Inicio de sesión exitoso" : "Nombre de usuario o contraseña incorrectos";
        int messageType = success ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE;

        JOptionPane.showMessageDialog(null, message, "Resultado del inicio de sesión", messageType);

        if (success) {
            // Obtener el rol del usuario
            String rol = getUserRole(this.id);

            // Redirigir según el rol
            if ("administrador".equals(rol)) {
                // Abre la interfaz de administración
                System.out.println(rol);
                new Admin(this.id).setVisible(true);
            } else if ("cliente".equals(rol)) {
                // Abre la interfaz de cliente
                System.out.println(rol);
                new Reserva(this.id).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Rol no reconocido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private String getUserRole(int userId) {
        String query = "SELECT r.name AS rol FROM users u JOIN role r ON r.id = u.role_id WHERE u.id = ?";
        try (PreparedStatement stmt = mdbc.getConn().prepareStatement(query)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("rol");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el rol del usuario: " + e);
        }
        return null;
    }

    public int getId() {
        return this.id;
    }
}
