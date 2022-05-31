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
         
         public void eliminarFAQ(int idFAQ){
                  String sql = "CALL eliminarFAQ(?)";
                  PreparedStatement ps;
                  try{
                           this.conectar();
                           ps = this.getCon().prepareCall(sql);
                           ps.setInt(1, idFAQ);
                           ps.executeUpdate();
                           
                           this.desconectar();
                  }
                  catch(Exception e){
                           e.printStackTrace();
                  }
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
         
         public FAQ listarFAQ(int idfaq){
                  FAQ faq = new FAQ();
                  faq.setIdFaq(0);
                  String sql = "CALL consultarFAQ(?)";
                  PreparedStatement ps;
                  ResultSet rs;
                  try{
                           this.conectar();
                           ps = this.getCon().prepareCall(sql);
                           ps.setInt(1, idfaq);
                           rs = ps.executeQuery();
                           if(rs.next()){
                                    faq.setIdFaq(idfaq);
                                    faq.setPregunta(rs.getString(2));
                                    faq.setRespuesta(rs.getString(3));
                           }
                  }
                  catch(Exception e){
                           e.printStackTrace();
                  }
                  
                  return faq;
         }
         
         public void cambiarFAQ(FAQ faq){
                  String sql = "CALL cambiarFAQ(?, ?, ?)";
                  PreparedStatement ps;
                  
                  try{
                           this.conectar();
                           ps = this.getCon().prepareCall(sql);
                           ps.setInt(1, faq.getIdFaq());
                           ps.setString(2, faq.getPregunta());
                           ps.setString(3, faq.getRespuesta());
                           
                           ps.executeUpdate();
                           
                           this.desconectar();
                  }
                  catch(Exception e){
                           e.printStackTrace();
                  }
         }
}
