 let productosEnVenta = [];
$(document).ready(function () {
    // Cargar productos desde la API al cargar la página
    cargarProductos();

    // Función para cargar productos desde la API y llenar el select
    function cargarProductos() {
        $.ajax({
            url: '/api/productos',
            type: 'GET',
            success: function (productos) {
                // Llenar el select con los productos obtenidos
                const productosSelect = $('#productosSelect');
                productosSelect.empty();
                productosSelect.append('<option value="" disabled selected>Seleccione un producto</option>');
                productos.forEach(function (producto) {
                    productosSelect.append(`<option value="${producto.id}" data-precio="${producto.precio}">${producto.nombre}</option>`);
                });
            },
            error: function (error) {
                console.error('Error al cargar los productos:', error);
            }
        });
    }
});
    // Función para agregar un producto al detalle de venta
    function agregarProducto() {
        const productoId = $('#productosSelect').val();
        const productoNombre = $('#productosSelect option:selected').text();
        const cantidad = parseInt($('#cantidad').val());

        // Validar que se haya seleccionado un producto y la cantidad sea válida
        if (!productoId || isNaN(cantidad) || cantidad <= 0) {
            alert('Por favor, seleccione un producto y especifique una cantidad válida.');
            return;
        }

        // Verificar si el producto ya está en la venta
        const productoExistente = productosEnVenta.find(p => p.id === productoId);
        if (productoExistente) {
            // Si el producto ya está en la venta, actualizar la cantidad
            productoExistente.cantidad += cantidad;
        } else {
            // Si el producto no está en la venta, agregarlo
            const precioUnitario = parseFloat($('#productosSelect option:selected').data('precio'));
            productosEnVenta.push({
                id: productoId,
                nombre: productoNombre,
                cantidad: cantidad,
                precioUnitario: precioUnitario
            });
        }

        // Actualizar la lista del detalle de venta y el total
        actualizarDetalleVenta();
        calcularTotalVenta();
    }

    // Función para actualizar la lista del detalle de venta en el HTML
    function actualizarDetalleVenta() {
        const detalleVenta = $('#detalleVenta');
        detalleVenta.empty();
        productosEnVenta.forEach(function (producto) {
            detalleVenta.append(`<li class="list-group-item">${producto.nombre} - Cantidad: ${producto.cantidad}</li>`);
        });
    }

    // Función para calcular y mostrar el total de la venta
    function calcularTotalVenta() {
        let totalVenta = 0;
        productosEnVenta.forEach(function (producto) {
            totalVenta += producto.cantidad * producto.costo;
        });
        $('#totalVenta').text(totalVenta.toFixed(2));
    }

    // Función para generar la factura y enviarla al backend
    function generarFactura() {
        const clienteCedula = $('#clienteCedula').val();

        // Validar que se haya ingresado la cédula del cliente
        if (!clienteCedula) {
            alert('Por favor, ingrese la cédula del cliente.');
            return;
        }

        // Crear objeto con datos de la venta
        const venta = {
            clienteCedula: clienteCedula,
            productos: productosEnVenta
        };

        // Enviar la solicitud al backend
        $.ajax({
            url: '/api/ventas',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(venta),
            success: function (response) {
                alert('Factura generada con éxito.');
                // Limpiar el formulario después de generar la factura
                limpiarFormulario();
            },
            error: function (error) {
                console.error('Error al generar la factura:', error);
            }
        });
    }

    // Función para limpiar el formulario después de generar la factura
    function limpiarFormulario() {
        $('#clienteCedula').val('');
        $('#productosSelect').val('');
        $('#cantidad').val('');
        productosEnVenta = [];
        actualizarDetalleVenta();
        calcularTotalVenta();
    }

    // Función para agregar un producto al detalle de venta
    function agregarProducto() {
        const productoId = $('#productosSelect').val();
        const productoNombre = $('#productosSelect option:selected').text();
        const cantidad = parseInt($('#cantidad').val());

        // Validar que se haya seleccionado un producto y la cantidad sea válida
        if (!productoId || isNaN(cantidad) || cantidad <= 0) {
            alert('Por favor, seleccione un producto y especifique una cantidad válida.');
            return;
        }

        // Verificar si el producto ya está en la venta
        const productoExistente = productosEnVenta.find(p => p.id === productoId);
        if (productoExistente) {
            // Si el producto ya está en la venta, actualizar la cantidad
            productoExistente.cantidad += cantidad;
        } else {
            // Si el producto no está en la venta, agregarlo
            const precioUnitario = parseFloat($('#productosSelect option:selected').data('precio'));
            productosEnVenta.push({
                id: productoId,
                nombre: productoNombre,
                cantidad: cantidad,
                precioUnitario: precioUnitario
            });
        }

        // Actualizar la lista del detalle de venta y el total
        actualizarDetalleVenta();
        calcularTotalVenta();
    }