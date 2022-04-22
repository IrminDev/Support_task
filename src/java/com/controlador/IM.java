package com.controlador;

import com.modelo.IMDao;
import com.modelo.Reporte;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luu
 */
@WebServlet(name = "IM", urlPatterns = {"/IM"})
public class IM extends HttpServlet {
  String listar="IM/Reportes/feed.jsp";
  String reportes="IM/Reportes/Feed1/feed.jsp";
  String edit="IM/reporte.jsp";
  Reporte repo = new Reporte(); 
  IMDao rdao = new IMDao();
  int id;
   int id2;

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
        if(accion.equalsIgnoreCase("cerrar")){
            /*CON ESTO TOMAMOS EL ID TOMANDO EL ATRIBUTO IDREPO*/
            request.setAttribute("idrepo",request.getParameter("id"));
            acceso=edit;
            
        }else

                /*Cerrar reporte de mantenimiento y soporte*/
                if(accion.equalsIgnoreCase("guardar")){
                /*IGUAL TENEMOS DOS PARAMETROS EL ID Y UNO PARA LA DESCRIPCION*/
                id= Integer.parseInt(request.getParameter("idr"));
                String des = request.getParameter("des");
                id2= Integer.parseInt(request.getParameter("idr2"));
                repo.setIdReporte(id);
                repo.setDescripcion(des);
                repo.setIdReporte2(id2);
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
