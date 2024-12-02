package com.agencia.turismo.service;

import com.agencia.turismo.repository.MariaDBConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Login {
    MariaDBConnection mdbc = new MariaDBConnection();
    private String name;
    private String password; 
    
    public Login(){
        
    }
    
    public Login(String name, String password){
        this.name = name; 
        this.password = password; 
    }
    
    public void checkLogin(){
        String query = "Select * from usuarios";
        try(PreparedStatement pdst = mdbc.getConn().prepareStatement(query)){
            
        }catch(SQLException e){
            System.out.println("Error al iniciar sesion:" + e);
        }
    }
    
}
