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
        <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
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
                <a class="a" href="IM/Reportes/Feed1/cerrados.jsp">Ver Reportes </a>
            </div>
        </nav>
    </header>
    <body>
        
        <h2 class="titulo"><span>R</span>eportes pendientes</h2>
        
        
            <c:forEach  var="report" items="${lista}">
            <div class="unidad" data-aos="fade-up" >
                <div class="division uno">
                <div>
                    <h2>Estatus</h2>
                    <h3><c:out value="${report.estatus}" /></h3>
                </div>
            </div>
            <div class="division dos">
                <h3 class="Text"><span>Ingeniero de Soporte a cargo:</span></h3>
                <h3 class="Text"><c:out value="${report.nombreEncargado}" /> <c:out value="${report.apellidoEncargado}" /></h3>
                <h3 class="Text"><span> Fecha de inicio:</span> <c:out value="${report.inicio}" /></h3>
                <h3 class="Text"><span> Titulo:</span> <c:out value="${report.titulo}" /></h3>
                <h3 class="Text"><span>Sin solucionar</span></h3>
                 <textarea   rows="20" id="content" class="fillarea" readonly> </textarea>
                <a href="IM?accion=cerrar&id=<c:out value="${report.idReporte}"/>"> <button class="button">Cerrar</button></a>
            </div>
            </div>
             </c:forEach>
       
                  <footer class="foot">
            <h3>© MixcoTech</h3>
            <p>Todos los derechos reservados</p>
            </footer>           
       <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
       <script>
            AOS.init();
        </script>
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

