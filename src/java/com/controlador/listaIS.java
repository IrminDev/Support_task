/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.controlador;
import com.modelo.FAQ;
import com.modelo.OpcFAQ;
import com.modelo.Reporte;
import com.modelo.ReporteDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author itzelsosa
 */
@WebServlet(name = "listaIS", urlPatterns = {"/listaIS"})
public class listaIS extends HttpServlet {
  String listar="IS/Reportes/feed.jsp";
  String listarC="IS/Reportes/Reportes/feed1.jsp";//cerrados
  String reportes="IS/Reportes/Reportes/feed.jsp";//mantenimiento
  String cerrado ="IS/Reportes/Reportes/cerrado.jsp";
  String add="IS/reportesoporte.jsp";
  String edit="IS/reportesoporte.jsp";
  String faqs="IS/Reportes/FAQS/addFAQ.jsp";
  Reporte repo = new Reporte(); 
  ReporteDao rdao = new ReporteDao();
  int id;

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AltaR</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AltaR at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String acceso="";  
    String accion = request.getParameter("accion");
    
    
            /*SI QUEREMOS VER LOS REPORTES QUE SE ENVIARON*/
        if(accion.equalsIgnoreCase("reportesM")){
        List<Reporte> lista = new ArrayList<>();
        lista= rdao.listarReportesMM();
        acceso=reportes;
        request.setAttribute("list",lista);
        
        }
      RequestDispatcher vista = request.getRequestDispatcher(acceso);
          vista.forward(request, response);
        
    
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
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
