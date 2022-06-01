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
                report.setTitulo(rs.getString(4));
                report.setSolucion(rs.getString(5));
                report.setNombreEncargado(rs.getString(6));
                report.setApellidoEncargado(rs.getString(7));
                report.setEstatus(rs.getString(8));
                lista.add(report);
                /*GUARDAMOS LOS DATOS*/
            }
            
               
           } catch(Exception e){
        System.out.println(e.toString());
              
           }
           return lista;
    }
    
    /*METODO PARA GENERAR UNA LISTA DE LOS REPORTES PENDIENTES O QUE ESTAN EN EL ESTATUS MANTENIMIENTO*/
    public List<Reporte> listarReportesMM(){
        /*ARRAY QUE CONTENDRA LOS DATOS QUE QUEREMOS*/
        List<Reporte> lista = new ArrayList<>();
        /*PROCESO ALMACENADO QUE NOS MOSTRARA LOS REPORTES DEL INGENIERO DE SOPORTE*/
        String sql = "CALL listarReportesMM(3);";
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
                report.setTitulo(rs.getString(4));
                report.setSolucion(rs.getString(5));
                report.setNombreEncargado(rs.getString(6));
                report.setApellidoEncargado(rs.getString(7));
                report.setEstatus(rs.getString(9));
                lista.add(report);
                /*GUARDAMOS LOS DATOS*/
            }
            
               
           } catch(Exception e){
        System.out.println(e.toString());
              
           }
           return lista;
    }
    
     /*METODO PARA GENERAR UNA LISTA DE LOS REPORTES PENDIENTES O QUE ESTAN EN EL ESTATUS MANTENIMIENTO*/
    public List<Reporte> listarReportesC(){
        /*ARRAY QUE CONTENDRA LOS DATOS QUE QUEREMOS*/
        List<Reporte> lista = new ArrayList<>();
        /*PROCESO ALMACENADO QUE NOS MOSTRARA LOS REPORTES DEL INGENIERO DE SOPORTE*/
        String sql = "CALL listarReportesC(3);";
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
                report.setTitulo(rs.getString(4));
                report.setSolucion(rs.getString(5));
                report.setNombreEncargado(rs.getString(6));
                report.setApellidoEncargado(rs.getString(7));
                report.setEstatus(rs.getString(9));
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
                repor.setTitulo(rs.getString(4));
                repor.setSolucion(rs.getString(5));
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
    
    /*METODO QUE NOS GENERARA UN NUEVO REPORTE DE MANTENIMIENTO*/
    public boolean altaMantenimiento(Reporte repo){
        /*PROCESO ALMACENADO QUE TIENE COMO PARAMETRO EL ID DEL REPORTE DE SOPORTE Y LA DESCRICPCION QUE SE CAMBIO*/
        String sql = "CALL altaReporteMantenimiento('"+repo.getIdReporte()+"','"+repo.getTitulo()+"',4)";
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
        String sql = "CALL cerrarReporte('"+repo.getIdReporte()+"','"+repo.getSolucion()+"')";
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
    
      public void agregarFAQ(FAQ faq){
                  String sql = "CALL agregarFAQ(?, ?)";
                  PreparedStatement ps;
                  try{
                           this.conectar();
                           ps = this.getCon().prepareCall(sql);
                           ps.setString(1, faq.getPregunta());
                           ps.setString(2, faq.getRespuesta());
                           ps.executeUpdate();
                           
                           this.desconectar();
                  }
                  catch(Exception e){
                           e.printStackTrace();
                  }
         }
         
} 
