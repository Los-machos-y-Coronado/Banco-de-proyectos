
function cambiarPagina(pag) {
    
    if(pag === "AsignacionPerfiles"){
        location.href="/faces/AsignacionPerfiles.xhtml";
    }else if(pag === "EstadoIniciativa"){
        location.href="/faces/EstadoIniciativa.xhtml";
    }
    else if(pag === "Publico"){
        location.href="/faces/Publico.xhtml";
    }
    else if(pag === "Riniciativas"){
        location.href="/faces/Riniciativas.xhtml";
    }
    else if(pag === "Consult"){
        location.href="/faces/frontConsult.xhtml";
    }
    else if(pag === "Autenticar"){
        location.href="/faces/Autenticacion.xhtml";
    }
    else if(pag === "IniciativaArea"){
        location.href="/faces/IniciativasArea.xhtml";
    }

}



