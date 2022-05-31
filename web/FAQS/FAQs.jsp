
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>
        <title>Inicio</title>
        <link rel="stylesheet" href="style3.css">
        <script src="https://kit.fontawesome.com/64d58efce2.js" crossorigin="anonymous"></script>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--Autor:Luu-->
</head>
<body>
    <header>
         <nav class="nav">
             <div class="nav_logo">
                 <span>S</span>upport<span>W</span>ide
             </div>

             <%
                      if(Integer.parseInt(request.getSession().getAttribute("editor").toString()) == 1){
                               out.print("<div class=\"links\">\n" +
"                 <a href=\"addFAQ.jsp\">Agregar FAQ </a>\n" +
"             </div>");
                      }
             %>
             
             

         </nav>
     </header>
            <h3 class="titulo">Preguntas frecuentes</h3>
            <div class="container">   
                
            </div>
        <script src="../JS/FAQs.js"></script>

    </body>
    


