package com.modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Luu
 */
public class ReporteDao extends Conexion{
     
    Reporte repor = new Reporte(); 
    
    /*METODO PARA GENERAR UNA LISTA DE LOS REPORTES PENDIENTES O QUE ESTAN EN EL ESTATUS PROCESO*/
    public List<Reporte> listarReportesP(){
        /*ARRAY QUE CONTENDRA LOS DATOS QUE QUEREMOS*/
        List<Reporte> lista = new ArrayList<>();
        /*PROCESO ALMACENADO QUE NOS MOSTRARA LOS REPORTES DEL INGENIERO DE SOPORTE*/
        String sql = "CALL listarReportesP(3);";
        PreparedStatement ps;
        ResultSet rs;
          
           try{
            this.conectar();
            ps = this.getCon().prepareCall(sql);
            rs = ps.executeQuery();
               while(rs.next()){
                /*DATOS QUE QUEREMOS CONSULTAR*/
                Reporte report = new Reporte();
                report.setIdReporte(rs.getInt(1));
                report.setInicio(rs.getDate(2));
                report.setFin(rs.getDate(3));
                report.setDescripcion(rs.getString(4));
                report.setNombreEncargado(rs.getString(5));
                report.setApellidoEncargado(rs.getString(6));
                report.setEstatus(rs.getString(7));
                lista.add(report);
                /*GUARDAMOS LOS DATOS*/
            }
            
               
           } catch(Exception e){
        System.out.println(e.toString());
              
           }
           return lista;
    }
    
    /*METODO PARA GENERAR UNA LISTA DE LOS REPORTES QUE ESTAN EN ESTATUS "CERRADO O MANTENIMIENTO"*/
    public List<Reporte> listarReportes(){
        /*ARRAY QUE CONTENDRA LOS DATOS QUE QUEREMOS*/
        List<Reporte> lista = new ArrayList<>();
        /*PROCESO ALMACENADO QUE NOS MOSTRARA LOS REPORTES DEL INGENIERO DE SOPORTE*/
        String sql = "CALL listarReportes(3);";
        PreparedStatement ps;
        ResultSet rs;
          
           try{
            this.conectar();
            ps = this.getCon().prepareCall(sql);
            rs = ps.executeQuery();
               while(rs.next()){
                /*DATOS QUE QUEREMOS CONSULTAR*/
                Reporte report = new Reporte();
                report.setIdReporte(rs.getInt(1));
                report.setInicio(rs.getDate(2));
                report.setFin(rs.getDate(3));
                report.setDescripcion(rs.getString(4));
                report.setNombreEncargado(rs.getString(5));
                report.setApellidoEncargado(rs.getString(6));
                report.setEstatus(rs.getString(8));
                lista.add(report);
                /*GUARDAMOS LOS DATOS*/
            }
            
               
           } catch(Exception e){
        System.out.println(e.toString());
              
           }
           return lista;
    }
    
    /*METODO QUE NOS TRAERA LOS DATOS DE UN SOLO REPORTE Y ESTE DEPENDERA DEL ID DEL REPORTE QUE QUEREMOS*/
    public Reporte list(int id){
        /*PROCESO ALMACENADO QUE TIENE COMO PARAMETRO EL ID DEL REPORTE QUE QUEREMOS CONSULTAR*/
        String sql = "CALL listarReporte(?);";
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
                repor.setInicio(rs.getDate(2));
                repor.setFin(rs.getDate(3));
                repor.setDescripcion(rs.getString(4));
                repor.setNombreEncargado(rs.getString(5));
                repor.setApellidoEncargado(rs.getString(6));
                repor.setEstatus(rs.getString(7));
                   /*SE ALMACENAN EN EL OBJETO REPOR PARA QUE CUANDO QUERAMOS CONSULTARLOS*/
            }
            
             
           } catch(Exception e){
        System.out.println(e.toString());
              
           }
              
           return repor;
    }
    
    /*METODO QUE NOS GENERARA UN NUEVO REPORTE DE MANTENIMIENTO*/
    public boolean altaMantenimiento(Reporte repo){
        /*PROCESO ALMACENADO QUE TIENE COMO PARAMETRO EL ID DEL REPORTE DE SOPORTE Y LA DESCRICPCION QUE SE CAMBIO*/
        String sql = "CALL altaReporteMantenimiento('"+repo.getIdReporte()+"','"+repo.getDescripcion()+"',4)";
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
    
    /*METODO QUE NOS ACTUALIZARA NUESTRO REPORTE A ESTATUS CERRADO Y CON LA NUEVA DESCRIPCION*/
    public boolean cerrarReporte(Reporte repo){
        /*PROCESO ALMACENADO QUE NOS PERMITIRA CERRAR EL REPORTE PERO QUE TIENE COMO PARAMETRO EL ID DEL REPORTE A CAMBIAR*/
        String sql = "CALL cerrarReporte('"+repo.getIdReporte()+"','"+repo.getDescripcion()+"')";
        PreparedStatement ps;
        
           try{
            this.conectar();
            ps = this.getCon().prepareCall(sql);
            /*ACTUALIZA EL ESTATUS Y LA DESCRIPCION DEL NUEVO REPORTE*/
            ps.executeUpdate();   
                
            }catch(Exception e){
                
            }
           return false;
    }
} 
