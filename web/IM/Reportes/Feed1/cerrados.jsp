<%-- 
    Document   : feed
    Created on : 15/04/2022, 09:54:49 PM
    Author     : Luu
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Inicio</title>
        <link rel="stylesheet" href="style.css">
        <script src="https://kit.fontawesome.com/64d58efce2.js" crossorigin="anonymous"></script>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--Autor:Luu-->
    </head>
   <header>
        <nav class="nav">
            <div class="nav_logo">
                <span>S</span>upport<span>W</span>ide
            </div>
                         <%
                      if(Integer.parseInt(request.getSession().getAttribute("editor").toString()) == 1){
                               out.print("<div class=\"links\">\n" +
"                 <a href=\"../../FAQS/addFAQ.jsp\">Agregar FAQ </a>\n" +
"             </div>");
                      }
             %>
            <div class="links">
                <a href="IM?accion=reportes">Ver Reportes </a>
            </div>
        </nav>
    </header>
    <body>
        <h3 class="titulo">Reportes pendientes</h3>

        <div class="container">
        
        </div>
        <script src="FAQs.js"></script>
        </div>
        <script src="Listar.js"></script>
           <script>
$(function(){
    var textArea = $('#content'),
    hiddenDiv = $(document.createElement('div')),
    content = null;
    
    textArea.addClass('noscroll');
    hiddenDiv.addClass('hiddendiv');
    
    $(textArea).after(hiddenDiv);
    
    textArea.on('keyup', function(){
        content = $(this).val();
        content = content.replace(/n/g, '<br>');
        hiddenDiv.html(content + '<br class="lbr">');
        $(this).css('height', hiddenDiv.height());
    });
});
</script>
    </body>
    
</html>

