package com.agencia.turismo.service;

import com.agencia.turismo.repository.MariaDBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Tour {
    private MariaDBConnection mdbc = new MariaDBConnection();
    private List<String> hotelNames = new ArrayList<>();
    
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
}
