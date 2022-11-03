/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validarcosa(obj) {
    if (obj.checked === true) {

        $('#boton').attr("disabled", false);
    } else if (obj.checked === false) {

        $('#boton').attr("disabled", true);
    }
}

function validarCheck(obj){
    if (obj.checked === true) {
        $('#boton').attr("disabled",false);
    }else if (obj.checked === false) {
        $('#boton').attr("disabled",true);
    }
}


