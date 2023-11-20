function buscarProducto() {
    var nombreOId = document.getElementById("productoInput").value;

    // Realizar la solicitud AJAX al controlador de productos
    $.ajax({
        type: "GET",
        url: "/api/productos/nombre/" + nombreOId,
        success: function (producto) {
            // Manejar la respuesta del servidor
            agregarProductoAFactura(producto);
        },
        error: function () {
            alert("Producto no encontrado");
        }
    });
}

function agregarProductoAFactura(producto) {
    // Obtener la tabla de la factura y su cuerpo
    var facturaTable = document.getElementById("facturaBody");

    // Crear una nueva fila para el producto en la factura
    var newRow = facturaTable.insertRow();
    var cellProducto = newRow.insertCell(0);
    var cellCantidad = newRow.insertCell(1);
    var cellPrecioUnitario = newRow.insertCell(2);
    var cellTotal = newRow.insertCell(3);

    // Llenar las celdas con la información del producto
    cellProducto.innerHTML = producto.nombre;
    cellCantidad.innerHTML = "<input type='number' value='1' class='form-control' onchange='actualizarTotal(this, " + producto.precio + ")'>";
    cellPrecioUnitario.innerHTML = "$" + producto.precio;
    cellTotal.innerHTML = "$" + producto.precio;

    // Actualizar el total general de la factura
    actualizarTotalGeneral();
}

function actualizarTotal(inputCantidad, precioUnitario) {
    // Obtener la fila actual
    var currentRow = inputCantidad.parentNode.parentNode;

    // Obtener el valor de la cantidad y calcular el nuevo total
    var cantidad = inputCantidad.value;
    var nuevoTotal = cantidad * precioUnitario;

    // Actualizar la celda de total en la misma fila
    currentRow.cells[3].innerHTML = "$" + nuevoTotal;

    // Actualizar el total general de la factura
    actualizarTotalGeneral();
}

function actualizarTotalGeneral() {
    var facturaTable = document.getElementById("facturaBody");
    var totalGeneral = 0;

    // Recorrer las filas de la factura y sumar los totales
    for (var i = 0; i < facturaTable.rows.length; i++) {
        totalGeneral += parseFloat(facturaTable.rows[i].cells[3].innerText.replace("$", ""));
    }

    // Mostrar el total general en algún lugar de tu página
    console.log("Total General: $" + totalGeneral);
}

