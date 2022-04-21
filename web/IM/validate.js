/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 * Autor: Luu
 */
//

var des = document.getElementById('content');
var war = document.getElementById('warning-des');
let wardes = "";
let regexdesc = /(<([^>]+)>)/i;
const expresiones ={
    texto:/^[a-zA-A0-9\_\-]{4-5}$/
};
des.addEventListener('keyup',function(evt){

    if(regexdesc.test(des.value)){
       des.classList.add('incorrectinput');
       war.classList.remove('warning');
        war.classList.remove('textarea');
       des.classList.add('textareaw');

       war.classList.add('activew');
       war.innerHTML="No introduzcas etiquetas";
           console.log("Si");

   } else{
                  console.log("si paso");
                  war.innerHTML= wardes;
                  des.classList.remove('incorrectinput');
                  war.classList.add('warning');
                  war.classList.remove('activew');
                          war.classList.add('textarea');
       des.classList.remove('textareaw');

   }
});
function enviarForm(){
   if(des.value === null || des.value==="" || des.value.length < 1){
       des.classList.add('incorrectinput');
       war.classList.remove('warning');
       war.classList.add('activew');
       war.innerHTML="Describe la situacion del reporte";
           console.log("Si");

   } else{
                  console.log("si paso");
                  war.innerHTML= wardes;
                  des.classList.remove('incorrectinput');
                  war.classList.add('warning');
                  war.classList.remove('activew');

   }
   
}