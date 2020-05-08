
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
    else if(pag === "Comentar"){
        location.href="/faces/AgregarComentarios.xhtml";
    }else if(pag === "AgruparIniciativa"){
             location.href="/faces/AgruparIniciativa.xhtml";
    }
    else if(pag=== "ConsultarConEstado"){
             location.href="/faces/conIniPorEst.xhtml";
        
            }
}
function back(){
	    history.back();
        }


