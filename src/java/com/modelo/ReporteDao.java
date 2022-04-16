/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 * Author: Luu
 */
package com.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luu
 */
public class ReporteDao {
    Connection conexion;
    
    public ReporteDao(){
       Conexion con = new Conexion();
       conexion = con.getCon();        
    }
    
    public List<Reporte> listarReporte(){
           PreparedStatement ps;
           ResultSet rs;
           List<Reporte> lista = new ArrayList<>();
           try{
               ps = conexion.prepareStatement("SELECT id_reporte, descripcion, fecha_inicio, fecha_fin FROM reporte ");
               rs = ps.executeQuery();
               while(rs.next()){
                   int id = rs.getInt("id_reporte");
                   String des = rs.getString("descripcion");
                   Reporte report = new Reporte();
                   report.setInicio(rs.getDate("fecha_inicio"));
                   report.setFin(rs.getDate("fecha_fin"));
               lista.add(report);
               }
               return lista;
               
           } catch(Exception e){
               e.printStackTrace();
               return null;
           }
    }
    
        public Reporte mostrarReporte(int _id){
           PreparedStatement ps;
           ResultSet rs;
           Reporte rep = null;
           try{
               ps = conexion.prepareStatement("SELECT id_reporte, descripcion, fecha_inicio, fecha_fin FROM reporte WHERE id=?");
               ps.setInt(1, _id);
               rs = ps.executeQuery();
               while(rs.next()){
                   int id = rs.getInt("id_reporte");
                   String des = rs.getString("descripcion");
                   Reporte report = new Reporte();
                   report.setInicio(rs.getDate("fecha_inicio"));
                   report.setFin(rs.getDate("fecha_fin"));
                   rep =new Reporte();
               }
               return rep;
               
           } catch(Exception e){
               e.printStackTrace();
               return null;
           }
    }
   /*             public boolean insertarR(Reporte report){
            PreparedStatement ps;
            try{
                ps = conexion.preparedStatement("INSERT INTO");
                
            }catch(Exception e){
                e.printStackTrace();
                
            }
        }
}*/

}
