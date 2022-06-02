const form = document.getElementById("form"),
edit = document.getElementById("BtnIniciar");

form.onsubmit = (e)=>{
    e.preventDefault();
};

edit.onclick = ()=>{
        let xhr = new XMLHttpRequest();
        xhr.open("POST", "../cerrar", true);
        xhr.onload = ()=>{
            if(xhr.readyState === XMLHttpRequest.DONE){
                if(xhr.status === 200){
                    let data = xhr.response;
                    if(data === "Listo"){
                        location.href="Reportes/feed.jsp";
                    }
                }
            }
        };
        let formData = new FormData(form);
        xhr.send(formData);
};


