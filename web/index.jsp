<%-- 
    Document   : index
    Created on : 14/04/2022, 05:42:08 PM
    Author     : Luu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Inicio</title>
        <link rel="stylesheet" href="style.css">
       
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--Autor:Luu-->
    </head>
    <header>
        <nav class="nav">
            <div class="nav_logo">
                <span>S</span>upport<span>W</span>ide
            </div>
        </nav>
    </header>
    <body>
        <h3 class="titulo">Iniciar sesion</h3>
        <div class="container">
     
        <form action="action" method="Post">
            <div>
                <h3 class="Text">Correo electronico</h3>
                <input class="fill" type="text" id="correo1" name="correo1" placeholder="Correo electronico">
            </div>
            <div class="warning" id="cwcorreo1">
                <i class="fas fa-exclamation"></i>
                <p id="warning-correol"></p>
            </div>
            <div class="input-field" id="ccontral">
                <h3 class="Text">Correo electronico</h3>
                <i class="fas fa-lock"></i>
                <input class="fill" type="password" id="contral" name="contral" placeholder="Contraseña">
            </div>
            <div class="warning" id="cwcontral">
                <i class="fas fa-exclamation"></i>
                <p id="warning-contral"></p>
            </div>
            <input class="button" name="accion" id="BtnIniciar" type="submit" value="Iniciar Sesión">
            <%-- 
            Comentado porque no entendi lo que decia la base de datos xd
            <div class="registro-link">
                <p class="social-text">¿No estás registrado? <a href="registrate.jsp" class="link">Regístrate</a></p>
            </div>
            --%>
        </form>
        </div>
         <script src="script.js"></script>
    </body>
</html>

