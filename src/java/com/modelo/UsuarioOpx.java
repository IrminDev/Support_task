package com.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author IrminDev
 */
public class UsuarioOpx  extends Conexion{
         
         public int[] iniciar(String correo, String contra){
                  int tipo[] = new int[3];
                  tipo[0] = 0;
                  tipo[1] = 0;
                  tipo[2] = 0;
                  String sql = "CALL iniciarSesion(?, ?)";
                  PreparedStatement ps;
                  ResultSet rs;
                  
                  try{
                           this.conectar();
                           ps = this.getCon().prepareCall(sql);
                           ps.setString(1, correo);
                           ps.setString(2, contra);
                           rs = ps.executeQuery();
                           
                           if(rs.next()){
                                    tipo[0] = rs.getInt(1);
                                    tipo[1] = rs.getInt(2);
                                    if(this.editor(tipo[1])){
                                             tipo[2] = 1;
                                    }
                           }
                  }
                  catch(Exception e){
                           e.printStackTrace();
                  }
                  
                  return tipo;
         }
         
         public boolean editor(int id){
                  boolean bandera = false;
                  String sql = "SELECT * FROM relacion_usuario_editor WHERE id_usuario = " + id;
                  PreparedStatement ps;
                  ResultSet rs;
                  try{
                           this.conectar();
                           ps = this.getCon().prepareStatement(sql);
                           rs = ps.executeQuery();
                           if(rs.next()){
                                    bandera = rs.getBoolean(2);
                                    System.out.println(bandera);
                           }
                  }
                  catch(Exception e){
                           e.printStackTrace();
                  }
                  
                  return bandera;
         }
}
