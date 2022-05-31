<%-- 
    Document   : editFAQ
    Created on : 31/05/2022, 06:02:49 PM
    Author     : IRMIN
--%>

<%@page import="com.modelo.FAQ"%>
<%@page import="com.modelo.OpcFAQ"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Editar FAQ</title>
        <link rel="stylesheet" href="style1.css">
       <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
            
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--Autor:Luu-->
        <%
                 int idFAQ = Integer.parseInt(request.getParameter("id").toString());
                 FAQ faq = new OpcFAQ().listarFAQ(idFAQ);
                 if(faq.getIdFaq() == 0){
                          response.sendRedirect("FAQs.jsp");
                 }
                 else{
                          HttpSession objSesion = request.getSession();
                          objSesion.setAttribute("idFAQ", idFAQ);
                 }
        %>
    </head>
    <header>
        <nav class="nav">
            <div class="nav_logo">
                <span>S</span>upport<span>W</span>ide
            </div>
            <div class="links">
                <a href="index.jsp">Inicio</a>
            </div>
        </nav>
    </header>
    <body>
        <h3 class="titulo">Añadir FAQ</h3>
        <div class="container">
    
        <form action="#" id="form">
            <div>
                 <h3 class="Text">Pregunta</h3>
                 <input class="fill" type="text" name="pregunta" value="<% out.print(faq.getPregunta()); %>">
            </div>
            <div>
                 <h3 class="Text">Respuesta</h3>
                 <textarea form="form" placeholder="Escriba la solución a la problematica" rows="20" id="content" class="fillarea"  name="respuesta"><% out.print(faq.getRespuesta()); %></textarea>
                 <p class="warning" id="warning-des"></p>
            </div>
            <div class="button-area">
            <input class="button" name="accion" id="BtnIniciar" type="submit" value="Añadir">
            </div>
        </form>
        </div>
        
        <script src="../JS/editFAQ.js"></script>
    </body>
</html>
