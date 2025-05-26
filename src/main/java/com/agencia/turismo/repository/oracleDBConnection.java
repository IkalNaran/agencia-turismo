package com.agencia.turismo.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class oracleDBConnection {
    private static final String user = "C##ikalnaran";
    private static final String pass = "C0smopolis.";
    String url = "jdbc:oracle:thin:@//mine.ikalnaran.com:1521/XE";
    private Connection conn;
    
    public oracleDBConnection() {
        try {
            conn = (Connection) DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }
}

