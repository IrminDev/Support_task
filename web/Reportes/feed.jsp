<%-- 
    Document   : feed
    Created on : 15/04/2022, 09:54:49 PM
    Author     : Luu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <div class="links">
                <a href="">Ver Reportes </a>
            </div>
        </nav>
    </header>
    <body>
        <h3 class="titulo">Reportes pendientes</h3>
        <div class="container">
            <div class="unidad" >
                <div class="division uno">
                <div>
                    <h2>Estatus</h2>
                    <h3>Abierto</h3>
                </div>
            </div>
            <div class="division dos">
                <h3 class="Text">Fecha de inicio</h3>
                <h3 class="Text">Fecha de fin</h3>
                 <h3 class="Text">Descripción</h3>
                 <textarea placeholder="Describa la problematica a solucionar aquí" rows="20" id="content" class="fillarea" readonly></textarea>
            </div>
            </div>
        </div>
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

