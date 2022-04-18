package com.modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luu
 */
public class ReporteDao {
    /*Establecemos la conexion a la BD*/
    Connection conexion;
    
    public ReporteDao(){
        conex con = new conex();
        try{
            conexion = con.getConexion();
        }
        catch(Exception ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*Arreglo que nos dara la información de los reportes en la BD que tiene el Ingeniero de soporte*/    
           public List<Reporte> listarReporteIngenieroSop(){
           PreparedStatement ps;
           ResultSet rs;
           List<Reporte> lista = new ArrayList<>();
           try{
               /*iNSTRUCCION EN MYSQL PARA RECABAR CIERTOS DATOS*/
               ps = conexion.prepareStatement("SELECT reporte.id_reporte, reporte.fecha_inicio," +
                "reporte.fecha_fin,reporte.descripcion,usuario.nombre,usuario.apellido,estatus.estatus FROM reporte INNER JOIN relacion_reporte_encargado ON relacion_reporte_encargado.id_reporte = reporte.id_reporte\n" +
                "INNER JOIN usuario ON usuario.id_usuario = relacion_reporte_encargado.id_usuario INNER JOIN relacion_reporte_estatus ON relacion_reporte_estatus.id_reporte = reporte.id_reporte\n" +
                "INNER JOIN estatus ON estatus.id_estatus = relacion_reporte_estatus.id_estatus WHERE usuario.id_usuario = 3;");
               rs = ps.executeQuery();
               while(rs.next()){
                   /*Datos que queremos recabar*/
                  int id = rs.getInt("id_reporte");
                   String des = rs.getString("descripcion");
                   Date inicio = rs.getDate("fecha_inicio");
                   Date fin = rs.getDate("fecha_fin");
                   String nombreEncargado = rs.getString("nombre");
                   String apellidoEncargado = rs.getString("apellido");
                   String estatus = rs.getString("estatus");
                   /* almacenamos los datos consultados*/
                Reporte reporte = new Reporte(id,des,inicio,fin,nombreEncargado,apellidoEncargado,estatus);           
                           
                lista.add(reporte);
            }
            return lista;
               
           } catch(Exception e){
        System.out.println(e.toString());
               return null;
           }
    }
    /*
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
