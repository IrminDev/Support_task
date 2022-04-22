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
        </nav>
    </header>
    <body>
        <h3 class="titulo">Iniciar sesion</h3>
        <div class="container">

            <form id="formInit" method="POST">
                <div>
                    <h3 class="Text">Correo electronico</h3>
                    <input class="fill" type="text" id="correo1" name="correo" placeholder="Correo electronico">
                </div>
                <div class="input-field" id="ccontral">
                    <h3 class="Text">Contraseña</h3>
                    <input class="fill" type="password" id="contral" name="contra" placeholder="Contraseña">
            </div>
                <input class="button" name="accion" id="BtnIniciar" type="submit" value="Iniciar Sesión">

                <div class="registro-link">
                    <p class="social-text">¿No estás registrado? <a href="registrate.jsp" class="link">Regístrate</a></p>
                </div>

            </form>
        </div>
        <script src="iniciarSesion.js"></script>
    </body>
</html>

