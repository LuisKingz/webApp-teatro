/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var raiz = window.location.origin + '/Teatro/';
var nameAsiento;
var arrayAsientos = [];
var arrayIds = [];
var numeroAsiento;
var idFuncion;
var tipoAsiento;

function numBoletos() {
    numeroAsiento = document.getElementById("cantidadCompra").value;
    idFuncion = document.getElementById("idFuncion").value;
    tipoAsiento = document.getElementById("tipoAsiento").value;
}

function asignarAsiento(asiento) {
    numeroAsiento = document.getElementById("cantidadCompra").value;
    idFuncion = document.getElementById("idFuncion").value;
    tipoAsiento = document.getElementById("tipoAsiento").value;

    nameAsiento = ($(asiento).attr("name"));
    if (nameAsiento === ("vip")) {
        if (arrayAsientos.length < numeroAsiento) {
            $(asiento).attr("class", "btn btn-circle btn-warning");
            arrayAsientos.push($(asiento).attr("id"));
            arrayIds.push($(asiento).attr("value"));
        } else {
            $("#" + arrayAsientos[0]).attr("class", "btn btn-circle btn-outline-warning");
            arrayAsientos.splice(0, 1);
            arrayIds.splice(0, 1);
            arrayAsientos.push($(asiento).attr("id"));
            arrayIds.push($(asiento).attr("value"));
            $(asiento).attr("class", "btn btn-circle btn-warning");
        }
    } else if (nameAsiento === ("med")) {
        if (arrayAsientos.length < numeroAsiento) {
            $(asiento).attr("class", "btn btn-circle btn-primary");
            arrayAsientos.push($(asiento).attr("id"));
            arrayIds.push($(asiento).attr("value"));
        } else {
            $("#" + arrayAsientos[0]).attr("class", "btn btn-circle btn-outline-primary");
            arrayAsientos.splice(0, 1);
            arrayIds.splice(0, 1);
            arrayAsientos.push($(asiento).attr("id"));
            arrayIds.push($(asiento).attr("value"));
            $(asiento).attr("class", "btn btn-circle btn-primary");
        }
    } else {
        if (arrayAsientos.length < numeroAsiento) {
            $(asiento).attr("class", "btn btn-circle btn-dark");
            arrayAsientos.push($(asiento).attr("id"));
            arrayIds.push($(asiento).attr("value"));
        } else {
            $("#" + arrayAsientos[0]).attr("class", "btn btn-circle btn-outline-dark");
            arrayAsientos.splice(0, 1);
            arrayIds.splice(0, 1);
            arrayAsientos.push($(asiento).attr("id"));
            arrayIds.push($(asiento).attr("value"));
            $(asiento).attr("class", "btn btn-circle btn-dark");
        }
    }
}
function registrarAsientos() {
    $.ajax(
            {
                url: raiz + 'registrarAsientos',
                data: {
                    idFuncion: idFuncion,
                    parametros: JSON.stringify(arrayIds)
                },
                success: function (responseText) {
                    var asientos = JSON.parse(responseText.parametros);
                    alert(asientos[0]);
                }
            });
}


