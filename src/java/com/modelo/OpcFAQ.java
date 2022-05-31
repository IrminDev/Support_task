package com.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IrminDev
 */
public class OpcFAQ extends Conexion{
         
         public List<FAQ> listarFAQs(){
                  List<FAQ> lista = new ArrayList<>();
                  String sql = "SELECT * FROM faq";
                  PreparedStatement ps;
                  ResultSet rs;
                  try{
                           this.conectar();
                           ps = this.getCon().prepareStatement(sql);
                           rs = ps.executeQuery();
                           while(rs.next()){
                                    FAQ faq = new FAQ();
                                    faq.setIdFaq(rs.getInt(1));
                                    faq.setPregunta(rs.getString(2));
                                    faq.setRespuesta(rs.getString(3));
                                    lista.add(faq);
                           }
                           this.desconectar();
                  }
                  catch(Exception e){
                           e.printStackTrace();
                  }
                  
                  return lista;
         } 
}
