package com.agencia.turismo.repository;
import org.mariadb.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDBConnection {
    private String user = "root";
    private String pass = "C0smopolis.";
    private String url = "jdbc:mariadb://127.0.0.1:3306/exploitiz";

    public void setConn() {
        try( Connection conn= (Connection) DriverManager.getConnection(url,user,pass)){
            System.out.println("Conectado");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }


}

