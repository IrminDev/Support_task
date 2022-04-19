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
        <link rel="stylesheet" href='Reportes/style.css'>
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
                <a href="">Ver reportes </a>
            </div>
        </nav>
    </header>
    <body>
        <h3 class="titulo">Reportes pendientes</h3>
        <-<!-- AQUI TRAEMOS LOS DATOS ALMACENADOS  -->
        <c:forEach  var="reporte" items="${lista}">
        <div class="container">
            <div class="unidad" >
                <div class="division uno">
                    <-<!-- EMPEZAMOS A DESPLEGAR LOS DATOS REQUERIDOS -->
                <div>
                    <h2>Estatus</h2>
                    <h3><c:out value="${reporte.estatus}" /></h3>
                </div>
            </div>
            <div class="division dos">
                <h3 class="Text">Ingeniero de Soporte a cargo:</h3>
                <h3 class="Text"><c:out value="${reporte.nombreEncargado}" /> <c:out value="${reporte.apellidoEncargado}" /></h3>
                <h3 class="Text">Fecha de inicio: <c:out value="${reporte.inicio}" /></h3>
                <h3 class="Text">Fecha de fin: </h3>
                 <h3 class="Text">Descripción</h3>
                 <textarea  rows="20" id="content" class="fillarea" readonly> <c:out value="${reporte.descripcion}" /></textarea>
            </div>
            </div>
        </div>
            
    </div>   
        </c:forEach>

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

