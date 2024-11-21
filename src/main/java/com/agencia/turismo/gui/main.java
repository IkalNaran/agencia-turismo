
package com.agencia.turismo.gui;

import com.agencia.turismo.service.Crud;

import java.sql.SQLException;

public class main {
    public static void main(String[] args){
        Crud connection = new Crud();
        connection.verDatos();

    }
}
