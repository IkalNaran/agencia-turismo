/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agencia.turismo.gui;

import com.agencia.turismo.service.Crud;

import java.sql.SQLException;

public class main {
    public static void main(String[] args){
        Crud connection = new Crud();
        connection.verDatos();

    }
}
