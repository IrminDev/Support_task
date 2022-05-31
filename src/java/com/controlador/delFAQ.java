package com.controlador;

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
 * @author IrminDev
 */
@MultipartConfig(location = "G:/tmp", fileSizeThreshold=1024*1024*5, maxFileSize = 1024*1024*5*5, maxRequestSize = 1024*1024*5*5*5)
@WebServlet(name = "delFAQ", urlPatterns = {"/delFAQ"})
public class delFAQ extends HttpServlet {

         @Override
         protected void doGet(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException {
                  int idFAQ = Integer.parseInt(request.getParameter("id").toString());
                  
                  new OpcFAQ().eliminarFAQ(idFAQ);
                  response.sendRedirect("FAQS/FAQs.jsp");
         }

         @Override
         protected void doPost(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException {
                  
         }

         @Override
         public String getServletInfo() {
                  return "Short description";
         }

}
