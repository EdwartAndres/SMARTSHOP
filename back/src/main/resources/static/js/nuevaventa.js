    $(document).ready(function() {
        // Variables para mantener un seguimiento de los productos seleccionados
        var selectedProducts = [];

        // Función para agregar un producto seleccionado a la tabla
        function addProductToTable(product) {
            var newRow = "<tr>" +
                "<td>" + product.codigo + "</td>" +
                "<td>" + product.nombre + "</td>" +
                "<td>" + product.cantidad + "</td>" +
                "<td>" + product.precioUnitario + "</td>" +
                "<td>" + (product.cantidad * product.precioUnitario) + "</td>" +
                "</tr>";
            $("#productosSeleccionados").append(newRow);
        }

        // Evento para agregar un producto seleccionado
        $("#agregarProducto").click(function() {
            var productoId = $("#producto").val();
            var cantidad = $("#cantidad").val();

            // Realiza una solicitud al servidor para obtener los detalles del producto
            $.get("/productos/" + productoId, function(product) {
                product.cantidad = cantidad;
                selectedProducts.push(product);
                addProductToTable(product);
            });
        });

        // Evento para buscar cliente por cédula
        $("#buscarClienteBtn").click(function() {
            var cedula = $("#buscarCliente").val();

            // Realiza una solicitud al servidor para buscar el cliente
            $.get("/clientes?cedula=" + cedula, function(cliente) {
                if (cliente) {
                    $("#cliente").val(cliente.id);
                } else {
                    alert("Cliente no encontrado");
                }
            });
        });

        // Manejar el envío del formulario
        $("#ventaForm").submit(function() {
            // Agregar los productos seleccionados al formulario antes de enviarlo
            $("#ventaForm").append('<input type="hidden" name="productosSeleccionados" value=\'' + JSON.stringify(selectedProducts) + '\'>');
        });
    });

