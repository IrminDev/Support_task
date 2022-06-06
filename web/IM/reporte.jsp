<%-- 
    Document   : reporte
    Created on : 14/04/2022, 09:16:50 PM
    Author     : Luu
--%>

<%@page import="com.modelo.Reporte"%>
<%@page import="com.modelo.IMDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Formulario de reporte</title>
        <link rel="stylesheet" href="IM/style.css">
       <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
            
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--Autor:Luu-->
    </head>
    <header>
        <nav class="nav">
            <div class="nav_logo">
                <a href="../index.jsp"><span>S</span>upport<span>W</span>ide</a>
            </div>
            <div class="links">
                <a href="index.jsp">Inicio</a>
                <a href="FAQS/FAQs.jsp">FAQs</a>
            </div>
        </nav>
    </header>
    <body>
        <h3 class="titulo">Reporte</h3>
        <div class="container">
     
   <%
         IMDao dao= new IMDao();
         int id = Integer.parseInt((String)request.getAttribute("idrepo"));
         Reporte r = (Reporte)dao.list(id);
         
     %>
        <form action="IM">
             <div>
                 <!-- FORMULARIO CON LOS DATOS DEL REPORTE SELECIONADO PARA ENVIAR O CERRAR REPORTE -->
           <input type="hidden" min="" id="fechaActual" value="<%= r.getIdReporte()%>" name="idr">
           <input type="hidden" min="" id="fechaActual2" value="<%= r.getIdReporte2()%>" name="idr2">
            </div>
            <div>
                <h3 class="Text">Fecha de inicio</h3>
                <input class="fill date1" type="date" min="" id="fechaActual" value="<%= r.getInicio()%>" readonly>
            </div>
            <div class="warning" id="cwcorreo1">
                <i class="fas fa-exclamation"></i>
                <p id="warning-correol"></p>
            </div>
            <div class="input-field" id="ccontral">
                <h3 class="Text">Ingeniero Responsable</h3>
                <i class="fas fa-lock"></i>
                <select class="fill">
                    <option value="" readonly>Luis Armando Contreras Ramos</option>
                </select>
            </div>
            <div class="warning" id="cwcontral">
                <i class="fas fa-exclamation"></i>
                <p id="warning-contral"></p>    
            </div>
            <div>
                 <h3 class="Text">Estatus</h3>
                 <select class="fill">
                    <option value="" ><%= r.getEstatus()%></option>
                    <option value="" >Mantenimiento</option>
                </select>
            </div>
               <div>
                <h3 class="Text">Título:</h3>
                <input class="fill date1" type="text" min="" id="titulo" value="<%= r.getTitulo()%>"   name="tit" readonly>
            </div>
            <div>
                 <h3 class="Text">Solucion</h3>
                 <input class="fill date1" type="text" min="" id="content" value=""   name="des" >

                                  <p class="warning" id="warning-des"></p>

            </div>

            <div class="button-area">
            <input onclick="return enviarForm()" class="button" name="accion" id="BtnIniciar" type="submit" value="guardar">
            </div>
        </form>
                                <section>
        <div class="wave wave1"></div>
        <div class="wave wave2"></div>
        <div class="wave wave3"></div>
        <div class="wave wave4"></div>
    </section>
        </div>
                    <script src="IM/validate.js"></script>           
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

