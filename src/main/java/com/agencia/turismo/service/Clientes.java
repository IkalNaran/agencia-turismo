package com.agencia.turismo.service;

import com.agencia.turismo.repository.MariaDBConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Clientes {
    private int id;
    private String name; 
    MariaDBConnection mdbc = new MariaDBConnection();
    
    public void setName(){
        String query = "SELECT * FROM cliente";
        try(PreparedStatement pdst = mdbc.getConn().prepareStatement(query)){
            System.out.println("hola");
        }catch(SQLException e){
            System.out.println("Error al consultar: " + e);
        }
    }
    
}
