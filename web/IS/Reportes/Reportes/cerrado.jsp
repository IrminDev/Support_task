<%-- 
    Document   : cerrado
    Created on : 31 may. 2022, 23:02:34
    Author     : itzelsosa Y Luu hizo todo el diseño
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
        <title>Inicio</title>
        <link rel="stylesheet" href="../style_1.css">
        <script src="https://kit.fontawesome.com/64d58efce2.js" crossorigin="anonymous"></script>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
  
</head>

    <header>
         <nav class="nav">
             <div class="nav_logo">
                 <span>S</span>upport<span>W</span>ide
             </div>
             
              <div class="links">
                  <a class="a" href="../feed.jsp">Inicio</a>
            </div>

             <%
                      if(Integer.parseInt(request.getSession().getAttribute("editor").toString()) == 1){
                               out.print("<div class=\"links\">\n" +
"                 <a href=\"addFAQ.jsp\" class=\"a\">Agregar FAQ </a>\n" +
"             </div>");
                      }
             %>
             
             

         </nav>
     </header>
    <body>
            <h3 class="titulo">Reportes cerrados</h3>
            <div class="container">  
                
            </div>
                    <section>
        <div class="wave wave1"></div>
        <div class="wave wave2"></div>
        <div class="wave wave3"></div>
        <div class="wave wave4"></div>
    </section>
 </div>

        <script src="FAQs.js"></script>
        
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

