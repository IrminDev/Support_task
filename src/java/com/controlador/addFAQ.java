
package com.controlador;

import com.modelo.FAQ;
import com.modelo.OpcFAQ;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author IRMIN
 */
@MultipartConfig(location = "G:/tmp", fileSizeThreshold=1024*1024*5, maxFileSize = 1024*1024*5*5, maxRequestSize = 1024*1024*5*5*5)
@WebServlet(name = "addFAQ", urlPatterns = {"/addFAQ"})
public class addFAQ extends HttpServlet {

         @Override
         protected void doGet(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException {

         }

         @Override
         protected void doPost(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException {
                  response.setContentType("text/plain");
                  response.setCharacterEncoding("UTF-8");
                  request.setCharacterEncoding("UTF-8");
                  
                  FAQ faq = new FAQ();
                  faq.setPregunta(request.getParameter("pregunta"));
                  faq.setRespuesta(request.getParameter("respuesta"));
                  
                  new OpcFAQ().agregarFAQ(faq);
                  
                  response.getWriter().write("Listo");
         }

         @Override
         public String getServletInfo() {
                  return "Short description";
         }

}
