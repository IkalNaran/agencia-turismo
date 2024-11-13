package com.agencia.turismo.repository;
import org.mariadb.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDBConnection {
    private String user = "root";
    private String pass = "rute";
    private String url = "jdbc:mariadb://127.0.0.1:3307/exploitiz";
    private Connection conn=null;
    
    public Connection getConn(){
      return conn;
    }

    public void setConn() {
        try{
             conn= (Connection) DriverManager.getConnection(url,user,pass);
            System.out.println("Conectado");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }


}

