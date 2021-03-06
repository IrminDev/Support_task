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
<div class="intro">
    <p>Es un gusto que estés en  <span>S</span>upport<span>W</span>ide. Registrarte en ella, te da acceso a nuestra increible platadorma de trabajo donde según tu rol podras hacer tus actividades facilmente.</p>

</div>
        <div class="container">
            
            <form class="registroForm" action="registrar" method="POST" autocomplete="off">
                
                <div class="error-text"></div>
                <div class="input-field" id="cnombre">
                    
                    <h3 class="Text">Nombre</h3>
                    <i class="fas fa-user"></i>
                    
                    <input class="fill" type="text" id="nombre" name="nombre" placeholder="Nombre">
                </div>
                <div class="warning" id="cwnombre">
                    <i class="fas fa-exclamation"></i>
                    <p id="warning-nombre"></p>
                </div>
                <div class="input-field" id="capellido">
                    <h3 class="Text">Apellido</h3>
                    <i class="fas fa-user"></i>
                    <input class="fill" type="text" id="ape" name="ape" placeholder="Apellido">
                </div>
                <div class="warning" id="cwapellido">
                    <i class="fas fa-exclamation"></i>
                    <p id="warning-apellido"></p>
                </div>
                <div class="input-field" id="ccorreo">
                    <h3 class="Text">Correo electronico</h3>
                    <i class="fas fa-envelope"></i>
                    <input class="fill" type="email" id="correo" name="correo" placeholder="Correo electrónico">
                </div>
                <div class="warning" id="cwcorreo">
                    <i class="fas fa-exclamation"></i>
                    <p id="warning-correo"></p>
                </div>
               
                <div class="input-field" id="ccontra">
                    <h3 class="Text">Contraseña</h3>
                    <i class="fas fa-lock"></i>
                    <input class="fill" type="password" id="contra" name="contra" placeholder="Contraseña">
                </div>
                <div class="warning" id="cwcontra">
                    <i class="fas fa-exclamation"></i>
                    <p id="warning-contra"></p>
                </div>

                <div class="grupo">
                    <div class="input-field">
                        <h3 class="Text">Tipo de usuario</h3>
                        <i class="fas fa-tag" id="repair"></i>
                        <select class="fill" name="tipo" id="tipo">
                            <optgroup label="Escoge una opción">
                                <option value="1">Asesor de soporte</option>
                                <option value="2">Ingenierio de soporte</option>
                                <option value="3">Ingeniero de mantenimiento</option>
                            </optgroup>
                        </select>
                    </div>
               
                     <select class="fill hide" name="editor" id="editor">                        
                            <optgroup label="Escoge una opción">
                                <option value="1">Sí, quiero ser editor</option>
                                <option value="0">No quiero ser editor</option>
                            </optgroup>
                        </select>
                    <input name="accion" type="submit" onclick="return registrar()" value="Registrar" class="button">
                </div>
                
                <div class="inicio-link">
                    <p class="social-text">¿Ya tienes una cuenta? <a href="index.jsp" class="link">Inicia sesión</a></p>
                </div>
            </form>
                    <div class="vector"> 
            <div class="box">
               <img class="" src="vector.jpg" alt="alt"/>   
            </div>
        </div>
              
        </div>

        <footer class="foot">
            <h3>© MixcoTech</h3>
            <p>Todos los derechos reservados</p>
            </footer> 
    </body>
</html>
