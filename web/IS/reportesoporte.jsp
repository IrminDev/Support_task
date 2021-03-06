<%-- 
    Document   : reportesoporte
    Created on : 14/04/2022, 09:01:26 PM
    Author     : Luu & Dani
--%>

<%@page import="com.modelo.Reporte"%>
<%@page import="com.modelo.ReporteDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Formulario de reporte</title>
        <link rel="stylesheet" href="Reportes/style_1.css">
       <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
                <script src="validate.js"></script>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
          <%
                 int idrep = Integer.parseInt(request.getParameter("id").toString());
                 Reporte faq = new ReporteDao().list(idrep);
                 if(faq.getIdReporte() == 0){
                          response.sendRedirect("IS/Reportes/feed.jsp");
                 }
                 else{
                          HttpSession objSesion = request.getSession();
                          objSesion.setAttribute("idr", idrep);
                 }
        %>
        <!--Autor:Luu-->
    </head>
    <header>
        <nav class="nav">
            <div class="nav_logo">
                <span>S</span>upport<span>W</span>ide
            </div>
            <div class="links">
                <a href="Reportes/feed.jsp">Inicio</a>
            </div>
        </nav>
    </header>
    <body>
        
        <h3 class="titulo">Reporte</h3>
        <div class="container">
            <!-- METODO QUE NO HACE TRAER LOS DATOS PARA REFLEJARLOS EN EL FORMULARIO -->
            <!-- CON EL "IDREPO" RECOGEMOS EL ID DEL REPORTE SELECCIONADO PARA REFLEJAR LOS DATOS DEL REPORTE -->
     
        <form action="#" id="form">
             <div>
                 <!-- FORMULARIO CON LOS DATOS DEL REPORTE SELECIONADO PARA ENVIAR O CERRAR REPORTE -->
           <input type="hidden" min="" id="fechaActual" value="<% out.print(faq.getIdReporte()); %>" name="idr">
            </div>
            <div>
                <h3 class="Text">Fecha de inicio</h3>
                <input class="fill date1" type="date" min="" id="fechaActual" value="<% out.print(faq.getInicio()); %>" readonly>
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
                    <option value="" ><% out.print(faq.getEstatus()); %></option>
                    <option value="" >Mantenimiento</option>
                </select>
            </div>
            <div>
                <h3 class="Text">T??tulo:</h3>
                <input class="fill date1" type="text" min="" id="titulo" value="<% out.print(faq.getTitulo()); %>"   name="tit" readonly>
            </div>
            <div>
                 <h3 class="Text">Solucion</h3>
                 <textarea form="form" placeholder="Describa la problematica a solucionar aqu??" rows="20" id="content" class="fillarea"  name="des"></textarea>
                                  <p class="warning" id="warning-des"></p>

            </div>
            <div class="button-area">
            <input  class="button" name="accion" id="BtnIniciar" type="submit" value="Cerrar">
            </div>
        </form>
        </div>
                                            <section>
        <div class="wave wave1"></div>
        <div class="wave wave2"></div>
        <div class="wave wave3"></div>
        <div class="wave wave4"></div>
    </section>
                    <script src="cerrar.js"></script>           

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

