<%-- 
    Document   : report
    Created on : 14/04/2022, 07:16:48 PM
    Author     : Luu & Moni
--%>

<%@page import="com.modelo.Reporte"%>
<%@page import="com.modelo.ASDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Formulario de reporte</title>
        <link rel="stylesheet" href="AS/style.css">
       <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
                <script src="AS/validate.js"></script>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <header>
        <nav class="nav">
            <div class="nav_logo">
                <span>S</span>upport<span>W</span>ide
            </div>
            <div class="links">
                <a class="a" href="index.jsp">Inicio</a>
                 <a class="a" href="FAQS/FAQs.jsp">FAQs</a>
            </div>
        </nav>
    </header>
    <body>
        <h3 class="titulo">Reporte</h3>
        <div class="container">
     
    <%
        ASDao dao= new ASDao();         
     %>          
  <!--Autor:Moni-->   
        <form action="AS" method="Get" id="altaZo">
            <div>
                <h3 class="Text">Fecha de inicio</h3>
                <input class="fill date1" type="date" min="" id="fechaActual" name="correo1" placeholder="Correo electronico" readonly>
            </div>
            <div class="warning" id="cwcorreo1">
                <i class="fas fa-exclamation"></i>
                <p id="warning-correol"></p>
            </div>
            <div class="input-field" id="ccontral">
                <h3 class="Text">Ingeniero Responsable</h3>
                <i class="fas fa-lock"></i>
                <select class="fill">
                    <option value="value">Daniela Sosa Becerra</option>
                </select>
            </div>
            <div class="warning" id="cwcontral">
                <i class="fas fa-exclamation"></i>
                <p id="warning-contral"></p>
            </div>
            <div>
                 <h3 class="Text">Estatus</h3>
                 <select class="fill">
                    <option value="value" readonly>Abierto</option>
                </select>
            </div>
            <div>
                 <h3 class="Text">Evento</h3>
                 <textarea form="altaZo" name="des" placeholder="Describa la problematica a solucionar aquí" rows="20" id="content" class="fillarea"></textarea>
            </div>
            <input class="button" name="accion" id="BtnIniciar" type="submit" value="Enviar">
          
        </form>
        </div>
                                            <section>
        <div class="wave wave1"></div>
        <div class="wave wave2"></div>
        <div class="wave wave3"></div>
        <div class="wave wave4"></div>
    </section>
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
