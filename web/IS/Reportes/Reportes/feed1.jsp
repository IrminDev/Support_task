<%-- 
    Document   : feed
    Created on : 15/04/2022, 09:54:49 PM
    Author     : Luu
--%>
<%@page import="java.util.List"%>
<%@page import="com.modelo.Reporte"%>
<%@page import="com.modelo.ReporteDao"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Inicio</title>
        <link rel="stylesheet" href="IS/Reportes/style.css">
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
            <div class="links">
                <a href="IS/Reportes/Reportes/cerrado.jsp">Ver Reportes </a>
            </div>
        </nav>
    </header>
    <body>
        <h3 class="titulo">Reportes solucionados</h3>
        <c:forEach  var="report" items="${lista}">
        <div class="container">
            <div class="unidad" >
                <div class="division uno">
                <div>
                    <h2>Estatus</h2>
                    <h3><c:out value="${report.estatus}" /></h3>
                </div>
            </div>
            <div class="division dos">
                <h3 class="Text">Ingeniero de Soporte a cargo:</h3>
                <h3 class="Text"><c:out value="${report.nombreEncargado}" /> <c:out value="${report.apellidoEncargado}" /></h3>
                <h3 class="Text">Fecha de inicio: <c:out value="${report.inicio}" /></h3>
                <h3 class="Text">Fecha de fin: <c:out value="${report.inicio}" /></h3>
                 <h3 class="Text" name="pregunta">Título:  <c:out value="${report.titulo}" /></h3>
                 <h3 class="Text">Solución:</h3>
                 <textarea  rows="20" id="content" class="fillarea" readonly name="respuesta"> <c:out value="${report.solucion}" /></textarea>
            </div>
            </div>
         
            
            </div>
        </div>
             </c:forEach>
        </div>
        <script src="script.js"></script>
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

