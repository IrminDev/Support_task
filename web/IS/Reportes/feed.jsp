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
        <link rel="stylesheet" href="style_1.css">
        <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
        <script src="https://kit.fontawesome.com/64d58efce2.js" crossorigin="anonymous"></script>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--Autor:Luu-->
    </head>
   <header>
        <nav class="nav">
            <div class="nav_logo">
                <a class="a" href="../../index.jsp"><span>S</span>upport<span>W</span>ide</a>
            </div>
            <div class="links">
                <a class="a" href="Reportes/cerrado.jsp">Cerrados </a>
            </div>
            <div class="links">
                <a class="a" href="../../FAQS/FAQs.jsp">Ver FAQ's </a>
            </div>
            <div class="links">
                <a class="a" href="../../listaIS?accion=reportesM">Enviados </a>
            </div>
        </nav>
    </header>
    <body>
        <h3 class="titulo">Reportes pendientes</h3>
        <div class="container">

        </div>
              <section>
        <div class="wave wave1"></div>
        <div class="wave wave2"></div>
        <div class="wave wave3"></div>
        <div class="wave wave4"></div>
    </section>
        <script src="ENVIARrE.js"></script>
        <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
        <script>
  AOS.init();
</script>
           <script>

</script>
    </body>
    
</html>