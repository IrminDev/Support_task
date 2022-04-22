/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 * Autor Luu
 */
var bt1 = document.getElementById("b1");
var tb1 = document.getElementById("tb1");
var tb2 = document.getElementById("tb2");
var tb3 = document.getElementById("tb3");
var bt2 = document.getElementById("b2");
var bt3 = document.getElementById("b3");
var bti = document.getElementById("bti");
var bta = document.getElementById("enviar");
var p = document.getElementById("p");

tb1.addEventListener("mouseover",function(evt){
    tb1.innerHTML="Alta de reportes";
}
);
tb1.addEventListener("mouseout",function(evt){
    tb1.innerHTML="Asesor de Soporte";
}
);
tb2.addEventListener("mouseover",function(evt){
    tb2.innerHTML="Administrar reportes";
}
);
tb2.addEventListener("mouseout",function(evt){
    tb2.innerHTML="Ing. Soporte";
}
);
tb3.addEventListener("mouseover",function(evt){
    tb3.innerHTML="Cerrar reportes";
}
);
tb3.addEventListener("mouseout",function(evt){
    tb3.innerHTML="Ing. Mantenimiento";
}
);
function mostrar(){
    bt1.classList.add("active");
    bt3.classList.add("active");
    bt2.classList.add("active");
    p.classList.add("active");
    bti.classList.add("unactive");
    bta.classList.add("unactive");


}
var typed = new Typed('.typed', {
	strings: [
	'<i class="span">G</i>upport<i class="span">W</i>ide','<i class="span">S</i>upport<i class="span">W</i>ide'
	],
	stringsElement: '#cadenas-texto', // ID del elemento que contiene cadenas de texto a mostrar.
	typeSpeed: 75, // Velocidad en mlisegundos para poner una letra,
	startDelay: 300, // Tiempo de retraso en iniciar la animacion. Aplica tambien cuando termina y vuelve a iniciar,
	backSpeed: 75, // Velocidad en milisegundos para borrrar una letra,
	smartBackspace: true, // Eliminar solamente las palabras que sean nuevas en una cadena de texto.
	shuffle: false, // Alterar el orden en el que escribe las palabras.
	backDelay: 1500, // Tiempo de espera despues de que termina de escribir una palabra.
	loop: true, // Repetir el array de strings
	loopCount: false, // Cantidad de veces a repetir el array.  false = infinite
	showCursor: true, // Mostrar cursor palpitanto
	cursorChar: '|', // Caracter para el cursor
	contentType: 'html', // 'html' o 'null' para texto sin formato
});
