package com.agencia.turismo.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDBConnection {
    private static final String user = "root";
    private static final String pass = "C0smopolis.";
    private static final String url = "jdbc:mariadb://127.0.0.1:3307/exploitiz";
    private Connection conn;
    
    public MariaDBConnection() {
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

