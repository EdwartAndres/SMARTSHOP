function agregarProductoInventario() {
    var idProducto = $("#idProducto").val();
    var cantidadStock = $("#cantidadStock").val();
    var precioCompra = $("#precioCompra").val();
    var precioVenta = $("#precioVenta").val();

    var data = {
        idProducto: idProducto,
        cantidadStock: cantidadStock,
        precioCompra: precioCompra,
        precioVenta: precioVenta
    };

    $.ajax({
        url: "http://localhost:8080/agregarProductoInventario",
        type: "POST",
        data: JSON.stringify(data),
        contentType: "application/json",
        success: function () {
            $("#idProducto").val('');
            $("#cantidadStock").val('');
            $("#precioCompra").val('');
            $("#precioVenta").val('');
            listarProductosEnInventario();
        },
        error: function (xhr) {
            if (xhr.status === 404) {
                alert("El ID de producto no existe.");
            } else {
                alert("Ocurrió un error al agregar el producto al inventario.");
            }
        }
    });
}

function listarProductosEnInventario() {
    var tablaProductosInventario = document.querySelector("#tablaProductosInventario");
    $.ajax({
        url: "http://localhost:8080/listarProductosEnInventario",
        type: "GET",
        dataType: "json",
        success: function (respuesta) {
            $("#tablaProductosInventario tbody").remove();
            for (var i = 0; i < respuesta.length; i++) {
                tablaProductosInventario.innerHTML += '<tr><td>' + respuesta[i].idProducto +
                    '</td><td>' + respuesta[i].producto.nombre +
                    '</td><td>' + respuesta[i].cantidadStock +
                    '</td><td>' + respuesta[i].precioCompra +
                    '</td><td>' + respuesta[i].precioVenta +
                    '</td></tr>';
            }
        }
    });
}
