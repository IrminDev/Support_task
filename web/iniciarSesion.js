const form = document.getElementById("formInit"),
BtnIniciar = document.getElementById("BtnIniciar");

form.onsubmit = (e)=>{
    e.preventDefault();
}

BtnIniciar.onclick = ()=>{
        let xhr = new XMLHttpRequest();
        xhr.open("POST", "iniciar", true);
        xhr.onload = ()=>{
            if(xhr.readyState === XMLHttpRequest.DONE){
                if(xhr.status === 200){
                    let data = xhr.response;
                    if(data === "1"){
                        location.href = "AS?accion=altar";
                    }
                    else{
                        if(data === "2"){
                            location.href = "listaIS?accion=pendientes";
                        }
                        else{
                            if(data === "3"){
                                location.href = "IM?accion=pendientes";
                            }
                            else{
                                console.log(data)
                            }
                        }
                    }
                }
            }
        };

        let formData = new FormData(form);
        xhr.send(formData);
};