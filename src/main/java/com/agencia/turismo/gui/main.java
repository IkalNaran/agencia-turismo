/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agencia.turismo.gui;

import com.agencia.turismo.repository.MariaDBConnection;

/**
 *
 * @author Dana Gonzalez
 */
public class main {
    public static void main(String[] args) {
        MariaDBConnection connection = new MariaDBConnection();
        connection.setConn();
        
    }
}
