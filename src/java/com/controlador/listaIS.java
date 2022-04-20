/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.controlador;
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
  String reportes="IS/Reportes/Reportes/feed.jsp";
  String add="IS/reportesoporte.jsp";
  String edit="IS/reportesoporte.jsp";
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
    
    /*Acceso a diferentes pagina modulo de consultas*/
    if(accion.equalsIgnoreCase("pendientes")){
        List<Reporte> lista = new ArrayList<>();
        lista= rdao.listarReportesP();
        acceso=listar;
        request.setAttribute("lista",lista);
        
    }else
        /*SI QUEREMOS VER LOS REPORTES QUE SE CERRARON O SE ENVIARON*/
        if(accion.equalsIgnoreCase("reportes")){
        List<Reporte> lista = new ArrayList<>();
        lista= rdao.listarReportes();
        acceso=reportes;
        request.setAttribute("lista",lista);
        
    }else
            /*CUANDO QUEREMOS IR AL FORMULARIO PARA ENVIAR O CERRAR Y QUEREMOS DESPLEGAR LOS DATOS DE ESTE NECESITAMOS EL
            PARAMETRO DEL ID*/
        if(accion.equalsIgnoreCase("altar")){
            /*CON ESTO TOMAMOS EL ID TOMANDO EL ATRIBUTO IDREPO*/
            request.setAttribute("idrepo",request.getParameter("id"));
            acceso=add;
            
        }else
            /*CUANDO QUEREMOS ENVIAR EL REPORTE A MANTENIMIENTO*/
            if(accion.equalsIgnoreCase("Enviar")){
                /*TENEMOS DOS PARAMETROS UNO EL ID Y LA DESCRIPCION*/
               int id= Integer.parseInt(request.getParameter("idr"));
                String des = request.getParameter("des");
                repo.setIdReporte(id);
                repo.setDescripcion(des);
                /*ENVIAMOS LOS DATOS AL ALTAMANTENIMIENTO PARA QUE SE GENERE UN REPORTE DE TIPO MANTENIMIENTO*/
                rdao.altaMantenimiento(repo);
                
                /*UNA VEZ HECHO EL FORMULARIO NOS LLEVARA A LA PAGINA DE CONSULTAS PENDIENTES*/
                List<Reporte> lista = new ArrayList<>();
                lista= rdao.listarReportesP();
                acceso=listar;
                request.setAttribute("lista",lista);
                
            }else
                /*CUANDO QUEREMOS CERRAR EL REPORTE*/
                if(accion.equalsIgnoreCase("Cerrar")){
                /*IGUAL TENEMOS DOS PARAMETROS EL ID Y LA DESCRIPCION*/
                id= Integer.parseInt(request.getParameter("idr"));
                String des = request.getParameter("des");
                repo.setIdReporte(id);
                repo.setDescripcion(des);
                /*AENVIAMOS LOS DATOS AL METODO CERRARREPORTE PARA GENERAR UN CABIO DE ESTADO Y DESCRIPCION*/
                rdao.cerrarReporte(repo);
               
                /*UNA VEZ HECHO EL FORMULARIO NOS LLEVARA A LA PAGINA DE CONSULTAS PENDIENTES*/
                List<Reporte> lista = new ArrayList<>();
                lista= rdao.listarReportesP();
                acceso=listar;
                request.setAttribute("lista",lista);
                
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
