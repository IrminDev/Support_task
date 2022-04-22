package com.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author IrminDev
 */
public class UsuarioOpx  extends Conexion{
         
         public int iniciar(String correo, String contra){
                  int tipo = 0;
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
                                    tipo = rs.getInt(1);
                           }
                  }
                  catch(Exception e){
                           e.printStackTrace();
                  }
                  
                  return tipo;
         }
}
