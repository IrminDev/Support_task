/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
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
 * @author itzelsosa
 */
@MultipartConfig(location = "G:/tmp", fileSizeThreshold=1024*1024*5, maxFileSize = 1024*1024*5*5, maxRequestSize = 1024*1024*5*5*5)
@WebServlet(name = "cerrados", urlPatterns = {"/cerrados"})
public class cerrados extends HttpServlet {


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/plain");
                  response.setCharacterEncoding("UTF-8");
                  request.setCharacterEncoding("UTF-8");
                  
                  List<Reporte> lista = new ReporteDao().listarReportesC();
                  String output = "";
                  int size = lista.size();
                  int editor = Integer.parseInt(request.getSession().getAttribute("editor").toString());
                  
                  for(int i=0; i<size; i++){
                           if(editor == 1){
                    output +=""+ 
                            "<div class=\"unidad\" >\n" +
                              "<div class=\"division uno\">\n" +
                              "<div>\n"+
                              "<h2>Estatus</h2>\n" +
                              "<h3>" + lista.get(i).getEstatus() + "</h3>\n" +
                              "</div>\n" +
                              "</div>\n"+
                              "<div class=\"division dos\">\n" +
                              "<h3 class=\"Text\"><span>Ingeniero de Soporte a cargo:</span></h3>\n"+
                              "<h3 class=\"Text\">" +lista.get(i).getNombreEncargado()+" "+lista.get(i).getApellidoEncargado() + "</h3>\n"+
                              "<h3 class=\"Text\"><span>Fecha de inicio: </span>" +  lista.get(i).getInicio()+"</h3>\n" +
                              "<h3 class=\"Text\"><span>Fecha de fin: </span>" +lista.get(i).getInicio() +"</h3>\n"+
                              "<h3 class=\"Text\"><span>Título:</span> "  +lista.get(i).getTitulo()+ "</h3>\n"+
                              "<h3 class=\"Text\"><span>Solución:</span></h3>\n" +
                              "<textarea  rows=\"20\" id=\"content\" class=\"fillarea\" readonly >" + lista.get(i).getSolucion() + "</textarea>" +
                              "</div>\n"+
                              "</div>"+
                            "<a class=\"a\" href=\"../../../addRepoteFaq?id=" + lista.get(i).getIdReporte() +"\">Agregar FAQ</a>\n";
                                            
                  
                           }
                          
                  }
                  
                  
                  response.getWriter().write(output);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
