<%-- 
    Document   : index
    Created on : 21/04/2022, 10:19:18 PM
    Author     : Luu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style2.css">
        <script src="https://kit.fontawesome.com/64d58efce2.js" crossorigin="anonymous"></script>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Inicio</title>
    </head>
    <body>
        <div class="left">
            <div class="Suuportwide text"><span class="typed"> </span></div>
            

        </div>
        <div class="right">
            <div>
                <h1 class="h1">Lo que está pasando ahora</h1>
                <p class="p">Accede para mantener el mundo funcionando</p>
            </div>
            <div class="idk">
                <button onclick="mostrar()" class="iniciar" id="bti" value="Iniciar">Iniciar</button>
            </div>
            <div class="button-container">
                <div class="box">
                <p class="subtitle unactive" id="p">Selecciona lo que quieres hacer</p>
            </div>
             <div class="box">
                 <a href="indexs.jsp" class="unactive " id="b1"><button class="b1" id="tb1">Asesor de Soporte</button></a>
            </div>
            <div class="box">
                <a href="indexs.jsp"class="unactive" id="b2"><button id="tb2">Ing. Soporte</button></a>
            </div>
            <div class="box">
                <a href="indexs.jsp" class="unactive" id="b3" ><button class="pulse" id="tb3">Ing. Mantenimiento</button></a>
            </div>
                <script >
var sonido = new Audio();
sonido.src="colapso.mp3";

</script>

<button class="contact100-form-btn play" id="enviar" onmousedown="sonido.play()">
           ▶
					</button>
            </div>
        </div>
          <script src="https://cdn.jsdelivr.net/npm/typed.js@2.0.12"></script>
        <script src="Appear.js"></script>
      
    </body>
</html>
