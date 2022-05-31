const form = document.getElementById("form"),
add = document.getElementById("BtnIniciar");

form.onsubmit = (e)=>{
    e.preventDefault();
};

add.onclick = ()=>{
        let xhr = new XMLHttpRequest();
        xhr.open("POST", "../addFAQ", true);
        xhr.onload = ()=>{
            if(xhr.readyState === XMLHttpRequest.DONE){
                if(xhr.status === 200){
                    let data = xhr.response;
                    if(data === "Listo"){
                        location.href="FAQs.jsp";
                    }
                }
            }
        };
        let formData = new FormData(form);
        xhr.send(formData);
};
