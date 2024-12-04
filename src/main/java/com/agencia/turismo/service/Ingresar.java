package com.agencia.turismo.service;

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
    
    public Ingresar(){
        
    }
    
    public boolean checkLogin(String user, String password) {
        String query = "SELECT id FROM users WHERE user_name = ? AND password = ?";
        this.name = name; 
        this.password = password ;
        try (PreparedStatement pdst = mdbc.getConn().prepareStatement(query)) {
            // Establecer los parámetros de la consulta
            pdst.setString(1, user);
            pdst.setString(2, password);

            // Ejecutar la consulta y obtener el resultado
            try (ResultSet rs = pdst.executeQuery()) {
                if (rs.next()) {
                    // Si hay un resultado, significa que el inicio de sesión fue exitoso
                    int userId = rs.getInt("id");
                    this.id = userId;
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
            new Reserva().setVisible(true);
        }
    }
}
