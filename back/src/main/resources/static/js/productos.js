$(document).ready(function () {

    // Función para agregar un producto al inventario
    function agregarProductoInventario() {
        // Obtener los valores del formulario
        var idProducto = $("#idProducto").val();
        var nombreProducto = $("#Nombreproducto").val();
        var cantidadStock = $("#cantidadStock").val();
        var precioCompra = $("#precioCompra").val();
        var precioVenta = $("#precioVenta").val();

        // Validar que los campos no estén vacíos
        if (idProducto === "" || nombreProducto === "" || cantidadStock === "" || precioCompra === "" || precioVenta === "") {
            alert("Por favor, complete todos los campos.");
            return;
        }

        // Crear un objeto de producto
        var producto = {
            id: idProducto,
            nombre: nombreProducto,
            cantidad: cantidadStock,
            precioCompra: precioCompra,
            precioVenta: precioVenta
        };

        // Enviar el producto al backend a través de la API
        $.ajax({
            type: "POST",
            url: "/api/productos",
            contentType: "application/json",
            data: JSON.stringify(producto),
            success: function (response) {
                // Limpiar el formulario después de agregar el producto
                limpiarFormulario();
                // Actualizar la tabla de productos en el inventario
                actualizarTablaProductos();
            },
            error: function (error) {
                console.error("Error al agregar el producto: ", error);
            }
        });
    }

    // Función para limpiar el formulario
    function limpiarFormulario() {
        $("#idProducto").val("");
        $("#Nombreproducto").val("");
        $("#cantidadStock").val("");
        $("#precioCompra").val("");
        $("#precioVenta").val("");
    }

    // Función para actualizar la tabla de productos en el inventario
    function actualizarTablaProductos() {
        // Obtener la tabla
        var tablaProductos = $("#tablaProductosInventario tbody");

        // Limpiar la tabla antes de actualizar
        tablaProductos.empty();

        // Obtener la lista de productos desde el backend a través de la API
        $.ajax({
            type: "GET",
            url: "/api/productos",
            success: function (productos) {
                // Iterar sobre la lista de productos y agregar filas a la tabla
                productos.forEach(function (producto) {
                    var fila = "<tr>" +
                        "<td>" + producto.id + "</td>" +
                        "<td>" + producto.nombre + "</td>" +
                        "<td>" + producto.cantidad + "</td>" +
                        "<td>" + producto.precioCompra + "</td>" +
                        "<td>" + producto.precioVenta + "</td>" +
                        "<td>" + producto.proveedor + "</td>" +
                        "</tr>";
                    tablaProductos.append(fila);
                });
            },
            error: function (error) {
                console.error("Error al obtener la lista de productos: ", error);
            }
        });
    }

    // Llamar a la función de actualizarTablaProductos al cargar la página
    actualizarTablaProductos();

    // Asignar la función agregarProductoInventario al evento click del botón "Agregar al Inventario"
    $("#agregar").click(agregarProductoInventario);

});
