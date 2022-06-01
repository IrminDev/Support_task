
package com.controlador;

import com.modelo.UsuarioOpx;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author IrminDev
 */
@MultipartConfig(location = "G:/tmp", fileSizeThreshold=1024*1024*5, maxFileSize = 1024*1024*5*5, maxRequestSize = 1024*1024*5*5*5)
@WebServlet(name = "iniciar", urlPatterns = {"/iniciar"})
public class iniciar extends HttpServlet {
         UsuarioOpx AUX = new UsuarioOpx();

         @Override
         protected void doGet(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException {

         }

         @Override
         protected void doPost(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException {
                  //Codificación de la solicitud y respuesta (UTF-8)
                  response.setContentType("text/plain");
                  response.setCharacterEncoding("UTF-8");
                  request.setCharacterEncoding("UTF-8");
                  
                  //Parámetros de los links
                  String correo = request.getParameter("correo");
                  String contra = request.getParameter("contra");
                  
                  //Comprobamos el tipo de usuario
                  int tipo[] = AUX.iniciar(correo, contra);
                  HttpSession objSesion = request.getSession();
                  objSesion.setAttribute("editor", tipo[2]);
                  objSesion.setAttribute("id", tipo[1]);
                  
                  //En la respuesta conetstamos con el tipo de usuario
                  System.out.println(tipo);
                  response.getWriter().write(String.valueOf(tipo[0]));
         }

         @Override
         public String getServletInfo() {
                  return "Short description";
         }

}
