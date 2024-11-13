
package com.agencia.turismo.service;

import com.agencia.turismo.repository.MariaDBConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Crud extends MariaDBConnection{
    String ver="select * from ?";
    public void verDatos(){
        setConn();
        getConn();
        try(PreparedStatement statement = getConn().prepareStatement(ver)) {  
        statement.setString(1, "vuelos");
        int rowsInserted = statement.executeUpdate();
    }catch(SQLException a){
        System.out.print(a);
    }
    }
}
