/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.modelo.Reporte;
import com.modelo.ReporteDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alumno
 */
@MultipartConfig(location = "G:/tmp", fileSizeThreshold=1024*1024*5, maxFileSize = 1024*1024*5*5, maxRequestSize = 1024*1024*5*5*5)
@WebServlet(name = "EnviarR", urlPatterns = {"/EnviarR"})
public class EnviarR extends HttpServlet {

  

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          response.setContentType("text/plain");
                  response.setCharacterEncoding("UTF-8");
                  request.setCharacterEncoding("UTF-8");
                  
                  List<Reporte> lista = new ReporteDao().listarReportesP();
                  String output = "";
                  int size = lista.size();
                  int editor = Integer.parseInt(request.getSession().getAttribute("editor").toString());
                  
                  for(int i=0; i<size; i++){
                           if(editor == 1){
                             output += " <div class=\"unidad\" >\n" +
"                <div class=\"division uno\">\n" +
"                <div>\n" +
"                    <h2>Estatus</h2>\n" +
                              "<h3>" + lista.get(i).getEstatus() + "</h3>\n" +
                              "</div>\n" +
                              "</div>\n"+
                              "<div class=\"division dos\">\n" +
                              "<h3 class=\"Text\">Ingeniero de Soporte a cargo:</h3>\n"+
                              "<h3 class=\"Text\">" +lista.get(i).getNombreEncargado()+" "+lista.get(i).getApellidoEncargado() + "</h3>\n"+
                              "<h3 class=\"Text\">Fecha de inicio: " +  lista.get(i).getInicio()+"</h3>\n" +
                              "<h3 class=\"Text\">Fecha de fin: " +lista.get(i).getInicio() +"</h3>\n"+
                              "<h3 class=\"Text\">Título: "  +lista.get(i).getTitulo()+ "</h3>\n"+
                              "</div>\n"+
                              "</div>"+
"<a href=\"EnviarR?id=" +lista.get(i).getIdReporte()+"\"/>\">Enviar</a>"+
 "<a href=\"listaIS?accion=altar&id="+lista.get(i).getIdReporte()+"\"/>\">Solucionar</a>\n" +
"</div>"  ;
                           }
                
                                            
                  
                           }
      
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
