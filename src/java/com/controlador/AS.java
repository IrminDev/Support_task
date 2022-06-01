package com.controlador;
import com.modelo.ASDao;
import com.modelo.Reporte;
import java.io.IOException;
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
 * @author MoniRior
 */
@WebServlet(name = "AS", urlPatterns = {"/AS"})
public class AS extends HttpServlet {
  String listar="AS/Reportes/feed.jsp";
  String reportes="AS/Reportes/Reportes/feed.jsp";
  String add="AS/report.jsp";
  String edit="AS/report.jsp";
  Reporte repo = new Reporte(); 
  ASDao rdao = new ASDao();
  int id;
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String acceso="";  
    String accion = request.getParameter("accion");
    
/*SI QUEREMOS VER LOS REPORTES QUE SE ENVIARON*/
    if(accion.equalsIgnoreCase("reportes")){
        List<Reporte> lista = new ArrayList<>();
        lista= rdao.listarReportes();
        acceso=reportes;
        request.setAttribute("lista",lista);
        
    }else
    /*CUANDO QUEREMOS IR AL FORMULARIO PARA ENVIAR Y QUEREMOS DESPLEGAR LOS DATOS DE ESTE NECESITAMOS EL
            PARAMETRO DEL ID*/
        if(accion.equalsIgnoreCase("altar")){
            /*CON ESTO TOMAMOS EL ID TOMANDO EL ATRIBUTO IDUSER*/
            request.setAttribute("iduser",request.getParameter("id"));
            acceso=add;
            /*CUANDO QUEREMOS ENVIAR EL REPORTE A ING. DE SOPORTE*/
        }else
            /*CUANDO QUEREMOS ENVIAR EL REPORTE A ING. DE SOPORTE*/
            if (accion.equalsIgnoreCase("Enviar")){
               /*TENEMOS DOS PARAMETROS UNO EL ID Y LA DESCRIPCION*/
               String des = request.getParameter("des");
               repo.setTitulo(des);
               /*ENVIAMOS LOS DATOS AL ING. DE SOPORTE*/
               rdao.altaReporte(repo);  
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
     * Pequeña descripción del servlet
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

