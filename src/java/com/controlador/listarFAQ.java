package com.controlador;

import com.modelo.FAQ;
import com.modelo.OpcFAQ;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig(location = "G:/tmp", fileSizeThreshold=1024*1024*5, maxFileSize = 1024*1024*5*5, maxRequestSize = 1024*1024*5*5*5)
@WebServlet(name = "listarFAQ", urlPatterns = {"/listarFAQ"})
public class listarFAQ extends HttpServlet {

         @Override
         protected void doGet(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException {
                  response.setContentType("text/plain");
                  response.setCharacterEncoding("UTF-8");
                  request.setCharacterEncoding("UTF-8");
                  
                  List<FAQ> lista = new OpcFAQ().listarFAQs();
                  String output = "";
                  int size = lista.size();
                  int editor = Integer.parseInt(request.getSession().getAttribute("editor").toString());
                  
                  for(int i=0; i<size; i++){
                           if(editor == 1){
                                    output += "<div class=\"unidad\" >\n" +
                  "                <div class=\"division uno\">\n" +
                  "                    <div>\n" +
                  "                        <h2>" + lista.get(i).getPregunta() + "</h2>\n" +
                  "                    </div>\n" +
                  "                </div>\n" +
                  "                <div class=\"division dos\">\n" +
                  "                    <p class=\"Text\">" + lista.get(i).getRespuesta() + "</p>\n" +
                  "                    <a href=\"../delFAQ?id=" + lista.get(i).getIdFaq() + "\">Eliminar FAQ</a>\n" +
                  "                    <a href=\"editFAQ.jsp?id=" + lista.get(i).getIdFaq() + "\">Modificar FAQ</a>" + 
                  "                </div>\n" +
                  "            </div>";
                           }
                           else{
                                    output += "<div class=\"unidad\" >\n" +
                  "                <div class=\"division uno\">\n" +
                  "                    <div>\n" +
                  "                        <h2>" + lista.get(i).getPregunta() + "</h2>\n" +
                  "                    </div>\n" +
                  "                </div>\n" +
                  "                <div class=\"division dos\">\n" +
                  "                    <h3 class=\"Text\">" + lista.get(i).getRespuesta() + "</h3>\n" +
                  "                </div>\n" +
                  "            </div>";
                           }
                  }
                  
                  
                  response.getWriter().write(output);
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
