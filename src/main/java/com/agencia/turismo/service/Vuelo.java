package com.agencia.turismo.service;

import com.agencia.turismo.repository.MariaDBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Vuelo {
    private MariaDBConnection mdbc = new MariaDBConnection();
    private List<String> hotelNames = new ArrayList<>();
    
    public void setName(){
        String query = "SELECT name FROM airlines";
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
        String query = "SELECT type_airline FROM airlines WHERE name=?";
        try (PreparedStatement pdst = mdbc.getConn().prepareStatement(query)) {
            pdst.setString(1, name);
            try (ResultSet rs = pdst.executeQuery()) {
                if (rs.next()) {
                    // Si hay un resultado, significa que el inicio de sesión fue exitoso
                    String userId = rs.getString("type_airline");
                    return userId;                
                } else {
                    return "";
                }
            }
        } catch (SQLException e) {
            System.out.println("No se puedo obtener el tipo de airolinea: " + e);
            return "";
        }
    }
    
    public String getOrigin(String name){
        String query = "SELECT destiny_origin FROM airlines WHERE name=?";
        try (PreparedStatement pdst = mdbc.getConn().prepareStatement(query)) {
            pdst.setString(1, name);
            try (ResultSet rs = pdst.executeQuery()) {
                if (rs.next()) {
                    // Si hay un resultado, significa que el inicio de sesión fue exitoso
                    String userId = rs.getString("destiny_origin");
                    return userId;                
                } else {
                    return "";
                }
            }
        } catch (SQLException e) {
            System.out.println("No se puedo obtener el destino de origen: " + e);
            return "";
        }
        
    }
    
    public String getEnd(String name){
        String query = "SELECT destiny_end FROM airlines WHERE name=?";
        try (PreparedStatement pdst = mdbc.getConn().prepareStatement(query)) {
            pdst.setString(1, name);
            try (ResultSet rs = pdst.executeQuery()) {
                if (rs.next()) {
                    // Si hay un resultado, significa que el inicio de sesión fue exitoso
                    String userId = rs.getString("destiny_end");
                    return userId;                
                } else {
                    return "";
                }
            }
        } catch (SQLException e) {
            System.out.println("No se puedo obtener el destino final: " + e);
            return "";
        }
        
    }
    
    public String getNumberAir(String name){
        String query = "SELECT number_airline FROM airlines WHERE name=?";
        try (PreparedStatement pdst = mdbc.getConn().prepareStatement(query)) {
            pdst.setString(1, name);
            try (ResultSet rs = pdst.executeQuery()) {
                if (rs.next()) {
                    // Si hay un resultado, significa que el inicio de sesión fue exitoso
                    String userId = rs.getString("number_airline");
                    return userId;                
                } else {
                    return "";
                }
            }
        } catch (SQLException e) {
            System.out.println("No se puedo obtener el number_airline: " + e);
            return "";
        }
        
    }
    
    public String getCountry(String name){
        String query = "SELECT c.name FROM airlines a JOIN country c ON a.country_id = c.id WHERE a.name=?";
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
        String query = "SELECT price FROM airlines WHERE name=?";
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
