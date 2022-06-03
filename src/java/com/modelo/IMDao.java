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
 * @author Luu
 */
public class IMDao extends Conexion{
    Reporte repor = new Reporte();
    /*METODO PARA GENERAR UNA LISTA DE LOS REPORTES PENDIENTES O QUE ESTAN EN EL ESTATUS PROCESO*/
    public List<Reporte> listarReportesP(){
        /*ARRAY QUE CONTENDRA LOS DATOS QUE QUEREMOS*/
        List<Reporte> lista = new ArrayList<>();
        /*PROCESO ALMACENADO QUE NOS MOSTRARA LOS REPORTES DEL INGENIERO DE SOPORTE*/
        String sql = "CALL listarReportesM(4);";
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
     /*METODO PARA GENERAR UNA LISTA DE LOS REPORTES QUE ESTAN EN ESTATUS "CERRADO O MANTENIMIENTO"*/
    public List<Reporte> listarReportes (){
        /*ARRAY QUE CONTENDRA LOS DATOS QUE QUEREMOS*/
        List<Reporte> lista = new ArrayList<>();
        /*PROCESO ALMACENADO QUE NOS MOSTRARA LOS REPORTES DEL INGENIERO DE MANTENIMIENTO*/
        String sql = "CALL listarReportesC(4);";
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
        /*METODO QUE NOS ACTUALIZARA NUESTRO REPORTE A ESTATUS CERRADO Y CON LA NUEVA DESCRIPCION*/
    public boolean cerrarReporte(Reporte repo){
        /*PROCESO ALMACENADO QUE NOS PERMITIRA CERRAR EL REPORTE PERO QUE TIENE COMO PARAMETRO EL ID DEL REPORTE A CAMBIAR*/
        String sql = "CALL cerrarReporteM4('"+repo.getIdReporte()+"','"+repo.getSolucion()+"','"+repo.getIdReporte2()+"')";
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
    public Reporte list(int id){
        /*PROCESO ALMACENADO QUE TIENE COMO PARAMETRO EL ID DEL REPORTE QUE QUEREMOS CONSULTAR*/
        String sql = "CALL listar2Reporte(?);";
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
                repor.setSolucion(rs.getString(6));
                repor.setNombreEncargado(rs.getString(7));
                repor.setApellidoEncargado(rs.getString(8));
                repor.setEstatus(rs.getString(9 ));
                   /*SE ALMACENAN EN EL OBJETO REPOR PARA QUE CUANDO QUERAMOS CONSULTARLOS*/
            }
            
             
           } catch(Exception e){
        System.out.println(e.toString());
              
           }
              
           return repor;
    }
    
} 


