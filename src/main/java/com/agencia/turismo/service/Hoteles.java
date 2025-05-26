package com.agencia.turismo.service;

import com.agencia.turismo.repository.oracleDBConnection;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Hoteles {
    private oracleDBConnection mdbc = new oracleDBConnection();
    private List<String> hotelNames = new ArrayList<>();
    
    public void setName(){
        String query = "SELECT name FROM hotels";
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
    
    public String getType(String name){
        String query = "SELECT type_hotel FROM hotels WHERE name=?";
        try (PreparedStatement pdst = mdbc.getConn().prepareStatement(query)) {
            pdst.setString(1, name);
            try (ResultSet rs = pdst.executeQuery()) {
                if (rs.next()) {
                    // Si hay un resultado, significa que el inicio de sesión fue exitoso
                    String userId = rs.getString("type_hotel");
                    return userId;                
                } else {
                    return "";
                }
            }
        } catch (SQLException e) {
            System.out.println("No se puedo obtener e tipo de hotel: " + e);
            return "";
        }
    }
    
    public String getAddress(String name){
        String query = "SELECT address FROM hotels WHERE name=?";
        try (PreparedStatement pdst = mdbc.getConn().prepareStatement(query)) {
            pdst.setString(1, name);
            try (ResultSet rs = pdst.executeQuery()) {
                if (rs.next()) {
                    // Si hay un resultado, significa que el inicio de sesión fue exitoso
                    String userId = rs.getString("address");
                    return userId;                
                } else {
                    return "";
                }
            }
        } catch (SQLException e) {
            System.out.println("No se puedo obtener la direccion: " + e);
            return "";
        }
        
    }
    
    public String getCountry(String name){
        String query = "SELECT c.name FROM hotels h JOIN country c ON h.country_id = c.id WHERE h.name=?";
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
        String query = "SELECT price FROM hotels WHERE name=?";
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
