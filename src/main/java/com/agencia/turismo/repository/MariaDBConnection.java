package com.agencia.turismo.repository;
import org.mariadb.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDBConnection {
    private static final String user = "root";
    private static final String pass = "rute";
    private static final String url = "jdbc:mariadb://127.0.0.1:3306/exploitiz";
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

