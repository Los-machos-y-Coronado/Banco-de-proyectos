/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function verificar(mensaje) {
    console.log(mensaje);
    console.log("JOHAN ES RE GURRERO");
    if(mensaje!==""){
        location.href='Perfil.xhtml';
        
    }

}

function mostrarMenu(mensaje){
    console.log("2");
    console.log(mensaje);
    if(mensaje === "Administrador"){
        console.log("HOLA");
        document.getElementById('admin').style.display="none";
    }
    
}


