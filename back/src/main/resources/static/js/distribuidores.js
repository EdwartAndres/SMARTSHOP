// distribuidores.js

// Función para agregar o actualizar un distribuidor
function insertarDistribuidor() {
    // Recuperar los valores del formulario
    var nit = document.getElementById("nit").value;
    var nombre = document.getElementById("nombre").value;
    var direccion = document.getElementById("direccion").value;
    var telefono = document.getElementById("telefono").value;
    var correoElectronico = document.getElementById("correoElectronico").value;
    var nombreContacto = document.getElementById("nombreContacto").value;

    // Crear un objeto con los datos del distribuidor
    var distribuidor = {
        rut: parseInt(nit),
        nombre: nombre,
        direccion: direccion,
        telefono: telefono,
        correoElectronico: correoElectronico,
        nombreContacto: nombreContacto
    };

    // Realizar la llamada POST a la API para agregar o actualizar el distribuidor
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/insertarproveedor",
        contentType: "application/json",
        data: JSON.stringify(distribuidor),
        success: function (response) {
            alert(response);
            limpiarFormulario();
            listarDistribuidores();
        },
        error: function (error) {
            console.log(error);
        }
    });
}

// Función para listar todos los distribuidores
function listarDistribuidores() {
    // Realizar la llamada GET a la API para obtener la lista de distribuidores
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/listarproveedores",
        success: function (distribuidores) {
            // Limpiar la tabla antes de actualizarla
            $("#tabla tbody").empty();

            // Iterar sobre la lista de distribuidores y agregar filas a la tabla
            for (var i = 0; i < distribuidores.length; i++) {
                var distribuidor = distribuidores[i];
                $("#tabla tbody").append(
                    "<tr>" +
                    "<td>" + distribuidor.rut + "</td>" +
                    "<td>" + distribuidor.nombre + "</td>" +
                    "<td>" + distribuidor.direccion + "</td>" +
                    "<td>" + distribuidor.telefono + "</td>" +
                    "<td>" + distribuidor.correoElectronico + "</td>" +
                    "<td>" + distribuidor.nombreContacto + "</td>" +
                    "<td><button type='button' class='btn btn-danger' onclick='eliminarDistribuidor(" + distribuidor.rut + ")'>Eliminar</button></td>" +
                    "</tr>"
                );
            }
        },
        error: function (error) {
            console.log(error);
        }
    });
}

// Función para buscar un distribuidor por ID
function buscarDistribuidorPorId() {
    // Recuperar el valor del campo porId
    var porId = document.getElementById("porId").value;

    // Realizar la llamada GET a la API para obtener el distribuidor por ID
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/unicoproveedor/" + porId,
        success: function (distribuidor) {
            // Verificar si se encontró el distribuidor
            if (distribuidor != null) {
                // Llenar el formulario con los datos del distribuidor
                document.getElementById("nit").value = distribuidor.rut;
                document.getElementById("nombre").value = distribuidor.nombre;
                document.getElementById("direccion").value = distribuidor.direccion;
                document.getElementById("telefono").value = distribuidor.telefono;
                document.getElementById("correoElectronico").value = distribuidor.correoElectronico;
                document.getElementById("nombreContacto").value = distribuidor.nombreContacto;

                // Habilitar el botón de actualizar
                document.getElementById("actualizar").disabled = false;
            } else {
                alert("Distribuidor no encontrado");
            }
        },
        error: function (error) {
            console.log(error);
        }
    });
}

// Función para eliminar un distribuidor por ID
function eliminarDistribuidor(id) {
    // Realizar la llamada DELETE a la API para eliminar el distribuidor por ID
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/eliminarproveedor/" + id,
        success: function () {
            alert("Distribuidor eliminado");
            limpiarFormulario();
            listarDistribuidores();
        },
        error: function (error) {
            console.log(error);
        }
    });
}

// Función para actualizar un distribuidor
function actualizarDistribuidor() {
    // Recuperar los valores del formulario
    var nit = document.getElementById("nit").value;
    var nombre = document.getElementById("nombre").value;
    var direccion = document.getElementById("direccion").value;
    var telefono = document.getElementById("telefono").value;
    var correoElectronico = document.getElementById("correoElectronico").value;
    var nombreContacto = document.getElementById("nombreContacto").value;

    // Crear un objeto con los datos actualizados del distribuidor
    var distribuidor = {
        rut: parseInt(nit),
        nombre: nombre,
        direccion: direccion,
        telefono: telefono,
        correoElectronico: correoElectronico,
        nombreContacto: nombreContacto
    };

    // Realizar la llamada PUT a la API para actualizar el distribuidor
    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/actualizarproveedor",
        contentType: "application/json",
        data: JSON.stringify(distribuidor),
        success: function () {
            alert("Distribuidor actualizado");
            limpiarFormulario();
            listarDistribuidores();
        },
        error: function (error) {
            console.log(error);
        }
    });
}

// Función para limpiar el formulario
function limpiarFormulario() {
    document.getElementById("nit").value = "";
    document.getElementById("nombre").value = "";
    document.getElementById("direccion").value = "";
    document.getElementById("telefono").value = "";
    document.getElementById("correoElectronico").value = "";
    document.getElementById("nombreContacto").value = "";
    document.getElementById("actualizar").disabled = true;
}

// Cargar la lista de distribuidores al cargar la página
$(document).ready(function () {
    listarDistribuidores();
});
