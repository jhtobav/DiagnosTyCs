/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function load() {
    $('.date').datepicker({
        language: "es"
    });
    setTimeout(loadFormat(),1000);
    
}

function dateToISO8601String(date) {
    var tzoffset = date.getTimezoneOffset() * 60000; //offset in milliseconds
    var localISOTime = (new Date(date - tzoffset)).toISOString();
    return localISOTime;
}

function resizeIframe(obj) {
    obj.style.height = obj.contentWindow.document.body.scrollHeight + 'px';
}

function builder() {
    $('.selectpicker').selectpicker();
    $('.selectpicker').selectpicker('refresh');
    var date = new Date();
    if (date.getDay() === 0 || date.getDay() === 6) {
        $('.alert').hide();
    } else {
        $('.alert').show();
    }
}

function getIdLaboratorio(element) {
    document.getElementById("form:idAgenda").value = element.parentNode.parentNode.rowIndex + ((element.parentNode.cellIndex - 1) * 32);
    getId(element);
}

function getIdImagen(element) {
    document.getElementById("form:idAgenda").value = element.parentNode.parentNode.rowIndex + ((element.parentNode.cellIndex - 1) * 32) + 160;
    getId(element);
}

function  getId(element) {
    var meses = new Array("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre");
    var fechaCita = new Date();
    fechaCita.setDate(fechaCita.getDate() + (element.parentNode.cellIndex - fechaCita.getDay()));
    cleanSchedule();
    var diaEntrada = document.getElementById("diaEntrada");
    element.setAttribute("class", "btn btn-warning fullButton");
    if (element.parentNode.cellIndex === 1) {
        diaEntrada.setAttribute("Value", "Lunes ");
    }
    if (element.parentNode.cellIndex === 2) {
        diaEntrada.setAttribute("Value", "Martes ");
    }
    if (element.parentNode.cellIndex === 3) {
        diaEntrada.setAttribute("Value", "Miercoles ");
    }
    if (element.parentNode.cellIndex === 4) {
        diaEntrada.setAttribute("Value", "Jueves ");
    }
    if (element.parentNode.cellIndex === 5) {
        diaEntrada.setAttribute("Value", "Viernes ");
    }
    diaEntrada.setAttribute("Value", diaEntrada.getAttribute("Value") + fechaCita.getDate() + " de " + meses[fechaCita.getMonth()]);

    if (element.parentNode.parentNode.rowIndex === 1) {
        diaEntrada.setAttribute("Value", diaEntrada.getAttribute("Value") + " 8:00 - 8:15");
        fechaCita.setHours(08);
        fechaCita.setMinutes(00);
        fechaCita.setSeconds(0);
        fechaCita.setMilliseconds(0);
    }
    if (element.parentNode.parentNode.rowIndex === 2) {
        diaEntrada.setAttribute("Value", diaEntrada.getAttribute("Value") + " 8:15 - 8:30");
        fechaCita.setHours(08);
        fechaCita.setMinutes(15);
        fechaCita.setSeconds(0);
        fechaCita.setMilliseconds(0);
    }
    if (element.parentNode.parentNode.rowIndex === 3) {
        diaEntrada.setAttribute("Value", diaEntrada.getAttribute("Value") + " 8:30 - 8:45");
        fechaCita.setHours(08);
        fechaCita.setMinutes(30);
        fechaCita.setSeconds(0);
        fechaCita.setMilliseconds(0);
    }
    if (element.parentNode.parentNode.rowIndex === 4) {
        diaEntrada.setAttribute("Value", diaEntrada.getAttribute("Value") + " 8:45 - 9:00");
        fechaCita.setHours(08);
        fechaCita.setMinutes(45);
        fechaCita.setSeconds(0);
        fechaCita.setMilliseconds(0);
    }
    if (element.parentNode.parentNode.rowIndex === 5) {
        diaEntrada.setAttribute("Value", diaEntrada.getAttribute("Value") + " 9:00 - 9:15");
        fechaCita.setHours(09);
        fechaCita.setMinutes(00);
        fechaCita.setSeconds(0);
        fechaCita.setMilliseconds(0);
    }
    if (element.parentNode.parentNode.rowIndex === 6) {
        diaEntrada.setAttribute("Value", diaEntrada.getAttribute("Value") + " 9:15 - 9:30");
        fechaCita.setHours(09);
        fechaCita.setMinutes(15);
        fechaCita.setSeconds(0);
        fechaCita.setMilliseconds(0);
    }
    if (element.parentNode.parentNode.rowIndex === 7) {
        diaEntrada.setAttribute("Value", diaEntrada.getAttribute("Value") + " 9:30 - 9:45");
        fechaCita.setHours(09);
        fechaCita.setMinutes(30);
        fechaCita.setSeconds(0);
        fechaCita.setMilliseconds(0);
    }
    if (element.parentNode.parentNode.rowIndex === 8) {
        diaEntrada.setAttribute("Value", diaEntrada.getAttribute("Value") + " 9:45 - 10:00");
        fechaCita.setHours(09);
        fechaCita.setMinutes(45);
        fechaCita.setSeconds(0);
        fechaCita.setMilliseconds(0);
    }
    if (element.parentNode.parentNode.rowIndex === 9) {
        diaEntrada.setAttribute("Value", diaEntrada.getAttribute("Value") + " 10:00 - 10:15");
        fechaCita.setHours(10);
        fechaCita.setMinutes(00);
        fechaCita.setSeconds(0);
        fechaCita.setMilliseconds(0);
    }
    if (element.parentNode.parentNode.rowIndex === 10) {
        diaEntrada.setAttribute("Value", diaEntrada.getAttribute("Value") + " 10:15 - 10:30");
        fechaCita.setHours(10);
        fechaCita.setMinutes(15);
        fechaCita.setSeconds(0);
        fechaCita.setMilliseconds(0);
    }
    if (element.parentNode.parentNode.rowIndex === 11) {
        diaEntrada.setAttribute("Value", diaEntrada.getAttribute("Value") + " 10:30 - 10:45");
        fechaCita.setHours(10);
        fechaCita.setMinutes(30);
        fechaCita.setSeconds(0);
        fechaCita.setMilliseconds(0);
    }
    if (element.parentNode.parentNode.rowIndex === 12) {
        diaEntrada.setAttribute("Value", diaEntrada.getAttribute("Value") + " 10:45 - 11:00");
        fechaCita.setHours(10);
        fechaCita.setMinutes(45);
        fechaCita.setSeconds(0);
        fechaCita.setMilliseconds(0);
    }
    if (element.parentNode.parentNode.rowIndex === 13) {
        diaEntrada.setAttribute("Value", diaEntrada.getAttribute("Value") + " 11:00 - 11:15");
        fechaCita.setHours(11);
        fechaCita.setMinutes(00);
        fechaCita.setSeconds(0);
        fechaCita.setMilliseconds(0);
    }
    if (element.parentNode.parentNode.rowIndex === 14) {
        diaEntrada.setAttribute("Value", diaEntrada.getAttribute("Value") + " 11:15 - 11:30");
        fechaCita.setHours(11);
        fechaCita.setMinutes(15);
        fechaCita.setSeconds(0);
        fechaCita.setMilliseconds(0);
    }
    if (element.parentNode.parentNode.rowIndex === 15) {
        diaEntrada.setAttribute("Value", diaEntrada.getAttribute("Value") + " 11:30 - 11:45");
        fechaCita.setHours(11);
        fechaCita.setMinutes(30);
        fechaCita.setSeconds(0);
        fechaCita.setMilliseconds(0);
    }
    if (element.parentNode.parentNode.rowIndex === 16) {
        diaEntrada.setAttribute("Value", diaEntrada.getAttribute("Value") + " 11:45 - 12:00");
        fechaCita.setHours(11);
        fechaCita.setMinutes(45);
        fechaCita.setSeconds(0);
        fechaCita.setMilliseconds(0);
    }
    if (element.parentNode.parentNode.rowIndex === 17) {
        diaEntrada.setAttribute("Value", diaEntrada.getAttribute("Value") + " 13:00 - 13:15");
        fechaCita.setHours(13);
        fechaCita.setMinutes(00);
        fechaCita.setSeconds(0);
        fechaCita.setMilliseconds(0);
    }
    if (element.parentNode.parentNode.rowIndex === 18) {
        diaEntrada.setAttribute("Value", diaEntrada.getAttribute("Value") + " 13:15 - 13:30");
        fechaCita.setHours(13);
        fechaCita.setMinutes(15);
        fechaCita.setSeconds(0);
        fechaCita.setMilliseconds(0);
    }
    if (element.parentNode.parentNode.rowIndex === 19) {
        diaEntrada.setAttribute("Value", diaEntrada.getAttribute("Value") + " 13:30 - 13:45");
        fechaCita.setHours(13);
        fechaCita.setMinutes(30);
        fechaCita.setSeconds(0);
        fechaCita.setMilliseconds(0);
    }
    if (element.parentNode.parentNode.rowIndex === 20) {
        diaEntrada.setAttribute("Value", diaEntrada.getAttribute("Value") + " 13:45 - 14:00");
        fechaCita.setHours(13);
        fechaCita.setMinutes(45);
        fechaCita.setSeconds(0);
        fechaCita.setMilliseconds(0);
    }
    if (element.parentNode.parentNode.rowIndex === 21) {
        diaEntrada.setAttribute("Value", diaEntrada.getAttribute("Value") + " 14:00 - 14:15");
        fechaCita.setHours(14);
        fechaCita.setMinutes(00);
        fechaCita.setSeconds(0);
        fechaCita.setMilliseconds(0);
    }
    if (element.parentNode.parentNode.rowIndex === 22) {
        diaEntrada.setAttribute("Value", diaEntrada.getAttribute("Value") + " 14:15 - 14:30");
        fechaCita.setHours(14);
        fechaCita.setMinutes(15);
        fechaCita.setSeconds(0);
        fechaCita.setMilliseconds(0);
    }
    if (element.parentNode.parentNode.rowIndex === 23) {
        diaEntrada.setAttribute("Value", diaEntrada.getAttribute("Value") + " 14:30 - 14:45");
        fechaCita.setHours(14);
        fechaCita.setMinutes(30);
        fechaCita.setSeconds(0);
        fechaCita.setMilliseconds(0);
    }
    if (element.parentNode.parentNode.rowIndex === 24) {
        diaEntrada.setAttribute("Value", diaEntrada.getAttribute("Value") + " 14:45 - 15:00");
        fechaCita.setHours(14);
        fechaCita.setMinutes(45);
        fechaCita.setSeconds(0);
        fechaCita.setMilliseconds(0);
    }
    if (element.parentNode.parentNode.rowIndex === 25) {
        diaEntrada.setAttribute("Value", diaEntrada.getAttribute("Value") + " 15:00 - 15:15");
        fechaCita.setHours(15);
        fechaCita.setMinutes(00);
        fechaCita.setSeconds(0);
        fechaCita.setMilliseconds(0);
    }
    if (element.parentNode.parentNode.rowIndex === 26) {
        diaEntrada.setAttribute("Value", diaEntrada.getAttribute("Value") + " 15:15 - 15:30");
        fechaCita.setHours(15);
        fechaCita.setMinutes(15);
        fechaCita.setSeconds(0);
        fechaCita.setMilliseconds(0);
    }
    if (element.parentNode.parentNode.rowIndex === 27) {
        diaEntrada.setAttribute("Value", diaEntrada.getAttribute("Value") + " 15:30 - 15:45");
        fechaCita.setHours(15);
        fechaCita.setMinutes(30);
        fechaCita.setSeconds(0);
        fechaCita.setMilliseconds(0);
    }
    if (element.parentNode.parentNode.rowIndex === 28) {
        diaEntrada.setAttribute("Value", diaEntrada.getAttribute("Value") + " 15:45 - 16:00");
        fechaCita.setHours(15);
        fechaCita.setMinutes(45);
        fechaCita.setSeconds(0);
        fechaCita.setMilliseconds(0);
    }
    if (element.parentNode.parentNode.rowIndex === 29) {
        diaEntrada.setAttribute("Value", diaEntrada.getAttribute("Value") + " 16:00 - 16:15");
        fechaCita.setHours(16);
        fechaCita.setMinutes(00);
        fechaCita.setSeconds(0);
        fechaCita.setMilliseconds(0);
    }
    if (element.parentNode.parentNode.rowIndex === 30) {
        diaEntrada.setAttribute("Value", diaEntrada.getAttribute("Value") + " 16:15 - 16:30");
        fechaCita.setHours(16);
        fechaCita.setMinutes(15);
        fechaCita.setSeconds(0);
        fechaCita.setMilliseconds(0);
    }
    if (element.parentNode.parentNode.rowIndex === 31) {
        diaEntrada.setAttribute("Value", diaEntrada.getAttribute("Value") + " 16:30 - 16:45");
        fechaCita.setHours(16);
        fechaCita.setMinutes(30);
        fechaCita.setSeconds(0);
        fechaCita.setMilliseconds(0);
    }
    if (element.parentNode.parentNode.rowIndex === 32) {
        diaEntrada.setAttribute("Value", diaEntrada.getAttribute("Value") + " 16:45 - 17:00");
        fechaCita.setHours(16);
        fechaCita.setMinutes(45);
        fechaCita.setSeconds(0);
        fechaCita.setMilliseconds(0);
    }
    document.getElementById("form:fechaCita").value = dateToISO8601String(fechaCita);
}

function cleanSchedule() {
    var selectedField = document.querySelector(".btn-warning");
    if (selectedField) {
        selectedField.setAttribute("class", "btn btn-success fullButton");
    }
}

function loadTable(value) {
    var tabla = document.getElementById("tableField");
    tabla.setAttribute("class", "table-responsive elementoVisible");

    if (value === "Examen de laboratorio") {
        var selectProcedimiento = document.getElementById("procedimiento");
        selectProcedimiento.remove(2);
        selectProcedimiento.remove(1);
        var opt = document.createElement("option");
        opt.value = "Muestra de sangre";
        opt.text = "Muestra de sangre";
        selectProcedimiento.appendChild(opt);
        var opt = document.createElement("option");
        opt.value = "Muestra de orina";
        opt.text = "Muestra de orina";
        selectProcedimiento.appendChild(opt);
        resizeIframe(this.parent);
    }
    if (value === "Toma de imagenes") {
        var selectProcedimiento = document.getElementById("procedimiento");
        selectProcedimiento.remove(2);
        selectProcedimiento.remove(1);
        var opt = document.createElement("option");
        opt.value = "Radiografia";
        opt.text = "Radiografia";
        selectProcedimiento.appendChild(opt);
        var opt = document.createElement("option");
        opt.value = "Tomografia";
        opt.text = "Tomografia";
        selectProcedimiento.appendChild(opt);
    }

    $('#procedimiento').selectpicker('refresh');
}

function setBirthDate() {
    document.getElementById("form:fechaNacimiento").value = dateToISO8601String($('.date').datepicker('getDate'));
}


function loadFormat() {
    $('.outputDateTime').each(function (index) {
        $(this).html(formatearFecha($(this).html()));
    });
}

function formatearFecha(fecha) {
    if (fecha) {
        var meses = new Array("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dic");
        var slicedDate = fecha.split(' ');
        var date = new Date(slicedDate[5], meses.indexOf(slicedDate[1]), slicedDate[2]);
        return date.getDate() + "/" + (date.getMonth() + 1) + "/" + date.getFullYear() + " " + slicedDate[3];
    }
}