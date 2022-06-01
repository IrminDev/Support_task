/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Moni
 */
public class ASDao extends Conexion{
    Reporte repor = new Reporte();
    /*METODO QUE NOS GENERARA UN NUEVO REPORTE DE MANTENIMIENTO*/
    public boolean altaReporte(Reporte repo){
        /*PROCESO ALMACENADO QUE TIENE COMO PARAMETRO LA DESCRICPCION DEL REPORTE DE SOPORTE*/
        String sql = "CALL altaReporte('"+repo.getTitulo()+"',3)";
        PreparedStatement ps;
        
           try{
            this.conectar();
            ps = this.getCon().prepareCall(sql);
            /*SE GENERA UN NUEVO REPORTE */
            ps.executeUpdate();  
                
            }catch(Exception e){
                
            }
           return false;
    }
    public Reporte list(int id){
        String sql = "CALL listarReportes(?);";
        PreparedStatement ps;
        ResultSet rs;
           try{
            this.conectar();
            ps = this.getCon().prepareCall(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
               while(rs.next()){
               /*DATOS QUE QUEREMOS CONSULTAR DE DICHO REPORTE*/
                repor.setIdReporte(rs.getInt(1));
                repor.setIdReporte2(rs.getInt(2));
                repor.setInicio(rs.getDate(3));
                repor.setFin(rs.getDate(4));
                repor.setTitulo(rs.getString(5));
                repor.setNombreEncargado(rs.getString(6));
                repor.setApellidoEncargado(rs.getString(7));
                repor.setEstatus(rs.getString(8));
                   /*SE ALMACENAN EN EL OBJETO REPOR PARA QUE CUANDO QUERAMOS CONSULTARLOS*/
            }
           } catch(Exception e){
        System.out.println(e.toString()); 
           }   
           return repor;
    }

    public List<Reporte> listarReportes() {
        throw new UnsupportedOperationException("Not supported yet."); 
    //SI SE QUIEREN VER LOS REPORTES QUE SE ENVIARON
    }
}
