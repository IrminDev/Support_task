/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.modelo.FAQ;
import com.modelo.OpcFAQ;
import com.modelo.Reporte;
import com.modelo.ReporteDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alumno
 */
@MultipartConfig(location = "G:/tmp", fileSizeThreshold=1024*1024*5, maxFileSize = 1024*1024*5*5, maxRequestSize = 1024*1024*5*5*5)
@WebServlet(name = "addRepoteFaq", urlPatterns = {"/addRepoteFaq"})
public class addRepoteFaq extends HttpServlet {

 

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idRepprte = Integer.parseInt(request.getParameter("id").toString());
        
        Reporte report = new ReporteDao().list(idRepprte);
        FAQ faq = new FAQ();
        faq.setPregunta(report.getTitulo());
        faq.setRespuesta(report.getSolucion());
        
        
        response.getWriter().write("Listo");
        new OpcFAQ().agregarFAQ(faq);
        response.sendRedirect("FAQS/FAQs.jsp");
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
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
