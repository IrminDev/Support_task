<%-- 
    Document   : registrate
    Created on : 14/04/2022, 05:43:20 PM
    Author     : Luu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrate</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <header>
        <nav class="nav">
            <div class="nav_logo">
                <span>S</span>upport<span>W</span>ide
            </div>
        </nav>
    </header>
    <body>
        <h3 class="titulo">Registrate</h3>
        <div class="container">
            <form class="registroForm" action="../ControlUsuarios" method="POST">
                <div class="error-text">Este es un mensaje de error</div>
                <div class="input-field" id="cnombre">
                    <i class="fas fa-user"></i>
                    <input type="text" id="nombre" name="nombreR" placeholder="Nombre">
                </div>
                <div class="warning" id="cwnombre">
                    <i class="fas fa-exclamation"></i>
                    <p id="warning-nombre"></p>
                </div>
                <div class="input-field" id="capellido">
                    <i class="fas fa-user"></i>
                    <input type="text" id="apellido" name="apellidoR" placeholder="Apellido">
                </div>
                <div class="warning" id="cwapellido">
                    <i class="fas fa-exclamation"></i>
                    <p id="warning-apellido"></p>
                </div>
                <div class="input-field" id="ccorreo">
                    <i class="fas fa-envelope"></i>
                    <input type="email" id="correo" name="correoR" placeholder="Correo electrónico">
                </div>
                <div class="warning" id="cwcorreo">
                    <i class="fas fa-exclamation"></i>
                    <p id="warning-correo"></p>
                </div>
                <div class="input-field" id="ctelefono">
                    <i class="fas fa-phone"></i>
                    <input type="text" id="telefono" name="telefonoR" placeholder="Teléfono">
                </div>
                <div class="warning" id="cwtelefono">
                    <i class="fas fa-exclamation"></i>
                    <p id="warning-telefono"></p>
                </div>
                <div class="input-field" id="ccontra">
                    <i class="fas fa-lock"></i>
                    <input type="password" id="contra" name="contraR" placeholder="Contraseña">
                </div>
                <div class="warning" id="cwcontra">
                    <i class="fas fa-exclamation"></i>
                    <p id="warning-contra"></p>
                </div>

                <div class="grupo">
                    <div class="input-field">
                        <i class="fas fa-tag" id="repair"></i>
                        <select name="tipoR" id="">
                            <optgroup label="Escoge una opción">
                                <option value="1">Asesor</option>
                                <option value="2">Trabajador</option>
                                <option value="2">Trabajador</option>
                            </optgroup>
                        </select>
                    </div>
                    <input name="accion" type="submit" onclick="return enviarRegistro()" value="Registrar" class="button">
                </div>

                <div class="inicio-link">
                    <p class="social-text">¿Ya tienes una cuenta? <a href="" class="link">Inicia sesión</a></p>
                </div>
                <p class="social-text">Para regresar al inicio da clic <a href="../index/index.jsp" class="link" >aquí</a></p>
            </form>
        </div>
    </body>
</html>
