
package com.controlador;

import com.modelo.Usuario;
import com.modelo.UsuarioOpx;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Moni
 */
@WebServlet(name = "registrar", urlPatterns = {"/registrar"})
public class registrar extends HttpServlet{
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
                  String nombre = request.getParameter("nombre");
                  String ape = request.getParameter("ape");
                  String correo = request.getParameter("correo");
                  String contra = request.getParameter("contra");
                  int tipo = Integer.parseInt(request.getParameter("tipo"));
                  String editor = String.valueOf(request.getParameter("editor"));
                  Boolean edit = null;
                  
                  if(editor.equals("1")){
                      edit=true;
                  }
                  else if(editor.equals("0")){
                      edit=false;
                  }

                  Usuario user = new Usuario();
                  user.setNombre(nombre);
                  user.setApellido(ape);
                  user.setCorreo(correo);
                  user.setContrasena(contra);
                  user.setTipo(tipo);
                  user.setEditor(edit);
                  
                  HttpSession objSesion = request.getSession();
                  
                  try{
                  //Comprobamos el tipo de usuario
                  String tipos[] = AUX.register(user);
                  objSesion.setAttribute("editor", tipos[0]);

                  
                  //En la respuesta contestamos con el tipo de usuario
                  System.out.println(tipo);
                  response.getWriter().write(String.valueOf(tipos[0]));
                  }
                  catch(Exception e){
                      objSesion.setAttribute("error", e);
                      response.sendRedirect("error.jsp");
                  }
                  //Redirigimos al index al iniciar sesion - (Luu 2022)
          RequestDispatcher vista = request.getRequestDispatcher("indexs.jsp");
          vista.forward(request, response);
         }

         @Override
         public String getServletInfo() {
                  return "Short description";
         }
}
