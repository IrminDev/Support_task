package com.modelo;

import java.sql.Date;

/**
 *
 * @author IrminDev
 */
public class Reporte {
    private int idReporte;
    private String solucion;
    private String titulo;
    private int idTipoReporte;
    private String tipoReporte;
    private Date inicio;
    private Date fin;
    private int idEncargado;
    private String nombreEncargado;
    private String apellidoEncargado;
    private int idEstatus;
    private String estatus;
    private int idReporte2;

    public int getIdReporte2() {
        return idReporte2;
    }

    public void setIdReporte2(int idReporte2) {
        this.idReporte2 = idReporte2;
    }
    
    public String getTitulo() {
                  return titulo;
         }

         public void setTitulo(String titulo) {
                  this.titulo = titulo;
         }

   
public String getApellidoEncargado() {
        return apellidoEncargado;
    }

    public void setApellidoEncargado(String apellidoEncargado) {
        this.apellidoEncargado = apellidoEncargado;
    }

    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    public int getIdTipoReporte() {
        return idTipoReporte;
    }

    public void setIdTipoReporte(int idTipoReporte) {
        this.idTipoReporte = idTipoReporte;
        switch(idTipoReporte){
            case(1):
                this.tipoReporte = "Soporte";
                break;
            case(2):
                this.tipoReporte = "Mantenimiento";
            default:
                break;
        }
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public int getIdEncargado() {
        return idEncargado;
    }

    public void setIdEncargado(int idEncargado) {
        this.idEncargado = idEncargado;
    }

    public String getNombreEncargado() {
        return nombreEncargado;
    }

    public void setNombreEncargado(String nombreEncargado) {
        this.nombreEncargado = nombreEncargado;
    }

    public int getIdEstatus() {
        return idEstatus;
    }

    public void setIdEstatus(int idEstatus) {
        this.idEstatus = idEstatus;
        switch(idEstatus){
            case(1):
                this.estatus = "Abierto";
                break;
            case(2):
                this.estatus = "En proceso";
            case(3):
                this.estatus = "En mantenimiento";
            case(4):
                this.estatus = "Cerrado";
            default:
                break;
        }
    }

    public String getTipoReporte() {
        return tipoReporte;
    }
    
    public String getEstatus() {
        return estatus;
    }
    
    
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }    

    public void setIdUser(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
