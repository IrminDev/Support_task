/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Luu
 */
public class UsuarioDao {
    
    Connection conexion;
         public UsuarioDao(){
             Conexion con = new Conexion();
             conexion = con.getCon();
         }
       public  List<Usuario> listarUsuario(){
           PreparedStatement ps;
           ResultSet rs;
           return null;
           
       }
}
