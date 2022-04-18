/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.controlador;
import com.modelo.Reporte;
import com.modelo.ReporteDao;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;

/**
 *
 * @author itzelsosa
 */
@WebServlet(name = "listaIS", urlPatterns = {"/listaIS"})
public class listaIS extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ReporteDao reporte = new ReporteDao();
        String accion;
        RequestDispatcher dispatcher=null;
        /*ACCION DEFINIMOS ESTO PARA QUE EL SERVLET SEPA A QUE PÁGINAS TIENE QUE HACER  LAS INDICACIONES*/
        accion = request.getParameter("accion");
          if(accion == null || accion.isEmpty()){
         /*SI PONEMOS /listaIS DEBE DIRECCIONAR A ESTA PAGINA*/
          dispatcher = request.getRequestDispatcher("index.jsp");
       
        }else
             if("soporte".equals(accion)){
            dispatcher = request.getRequestDispatcher("IS/Reportes/feed.jsp");
            /*LLAMAMOS AL METODO LISTAR QUE CONTIENE LOS DATOS QUE QUEREMOS MOSTRAR*/
            List<Reporte>lista = reporte.listarReporteIngenieroSop();
            request.setAttribute("lista", lista);
            /* SE LE DA ATRIBUTO "LISTA"  PARA QUE CUANDO LOS DESPLEGEMOS EN EL JSP ESTA SERA LA REFERENCIA DEL ARRAYLIST*/
             }
          
        dispatcher.forward(request, response);
    
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
