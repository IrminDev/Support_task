const faqlist = document.querySelector(".container");

function listar(){
    let xhr = new XMLHttpRequest();
    xhr.open("GET", "../../../Enviar", true);
    xhr.onload = () =>{
        if(xhr.readyState === XMLHttpRequest.DONE){
            if(xhr.status === 200){
                let data = xhr.response;
                faqlist.innerHTML = data;
            }
        }
    };
    xhr.send();
}

window.onload = listar;

