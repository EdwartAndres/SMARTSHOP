
let proveedores = [];

function cargarOpcionesProveedor() {
    // Hacer una solicitud AJAX para obtener la lista de proveedores
    $.ajax({
        url: "/listarproveedores",
        type: "GET",
        success: function (data) {
            proveedores = data;
            // Limpiar las opciones existentes
            $("#proveedor").empty();
            // Agregar las nuevas opciones
            for (let i = 0; i < proveedores.length; i++) {
                $("#proveedor").append(`<option value="${proveedores[i].rut}">${proveedores[i].nombre}</option>`);
            }
        },
        error: function (error) {
            console.log("Error al obtener la lista de proveedores:", error);
        }
    });
}

// Función para agregar un producto al inventario
function agregarProductoInventario() {
    // Obtener los valores del formulario
    const idProducto = $("#idProducto").val();
    const nombreProducto = $("#nombreProducto").val();
    const descripcionProducto = $("#descripcionProducto").val();
    const cantidadStock = $("#cantidadStock").val();
    const precioCompra = $("#precioCompra").val();
    const precioVenta = $("#precioVenta").val();
    const proveedorSeleccionado = $("#proveedor").val();

    // Validar que los campos requeridos estén completos
    if (!idProducto || !nombreProducto || !descripcionProducto || !cantidadStock || !precioCompra || !precioVenta || !proveedorSeleccionado) {
        alert("Por favor, complete todos los campos.");
        return;
    }

    // Crear un objeto de producto
    const nuevoProducto = {
        id: idProducto,
        nombre: nombreProducto,
        descripcion: descripcionProducto,
        cantidad: cantidadStock,
        precioCompra: precioCompra,
        precioVenta: precioVenta,
        proveedor: proveedores.find(proveedor => proveedor.rut == proveedorSeleccionado)
    };

    // Hacer una solicitud AJAX para guardar el producto
    $.ajax({
        url: "/api/productos",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(nuevoProducto),
        success: function (data) {
            alert("Producto agregado al inventario correctamente.");
            // Limpiar el formulario después de agregar el producto
            $("#formularioProductos")[0].reset();
        },
        error: function (error) {
            console.log("Error al agregar el producto:", error);
            alert("Error al agregar el producto. Por favor, inténtelo de nuevo.");
        }
    });
}

// Función para listar productos
function listarProductos() {
    // Hacer una solicitud AJAX para obtener la lista de productos
    $.ajax({
        url: "/api/productos",
        type: "GET",
        success: function (data) {
            // Limpiar la tabla antes de llenarla con los nuevos datos
            $("#tablaProductosInventario tbody").empty();
            // Llenar la tabla con los productos
            for (let i = 0; i < data.length; i++) {
                $("#tablaProductosInventario tbody").append(`
                    <tr>
                        <td>${data[i].id}</td>
                        <td>${data[i].nombre}</td>
                        <td>${data[i].descripcion}</td>
                        <td>${data[i].cantidad}</td>
                        <td>${data[i].costo}</td>
                        <td>${data[i].precio}</td>
                        <td>${data[i].proveedor.nombre}</td>
                        <td>
                            <button class="btn btn-danger" onclick="eliminarProducto(${data[i].id})">Eliminar</button>
                        </td>
                    </tr>
                `);
            }
        },
        error: function (error) {
            console.log("Error al obtener la lista de productos:", error);
        }
    });
}

// Función para eliminar un producto
function eliminarProducto(idProducto) {
    // Confirmar antes de eliminar
    if (confirm("¿Está seguro de que desea eliminar este producto?")) {
        // Hacer una solicitud AJAX para eliminar el producto
        $.ajax({
            url: `/api/productos/${idProducto}`,
            type: "DELETE",
            success: function () {
                alert("Producto eliminado correctamente.");
                // Volver a listar los productos después de eliminar
                listarProductos();
            },
            error: function (error) {
                console.log("Error al eliminar el producto:", error);
                alert("Error al eliminar el producto. Por favor, inténtelo de nuevo.");
            }
        });
    }
}

// Función para buscar un producto por ID
function buscarProductoPorId() {
    // Obtener el ID de producto a buscar
    const idProductoABuscar = $("#porIdProducto").val();

    // Validar que el campo no esté vacío
    if (!idProductoABuscar) {
        alert("Por favor, ingrese un ID de producto.");
        return;
    }

    // Hacer una solicitud AJAX para buscar el producto por ID
    $.ajax({
        url: `/api/productos/${idProductoABuscar}`,
        type: "GET",
        success: function (data) {
            // Limpiar la tabla antes de llenarla con el resultado de búsqueda
            $("#tablaProductosInventario tbody").empty();
            // Llenar la tabla con el producto encontrado
            $("#tablaProductosInventario tbody").append(`
                <tr>
                    <td>${data.id}</td>
                    <td>${data.nombre}</td>
                    <td>${data.descripcion}</td>
                    <td>${data.cantidad}</td>
                    <td>${data.costo}</td>
                    <td>${data.precio}</td>
                    <td>${data.proveedor.nombre}</td>
                    <td>
                        <button class="btn btn-danger" onclick="eliminarProducto(${data.id})">Eliminar</button>
                    </td>
                </tr>
            `);
        },
        error: function (error) {
            console.log("Error al buscar el producto por ID:", error);
            alert("Producto no encontrado. Por favor, verifique el ID ingresado.");
        }
    });
}

// Cargar opciones de proveedores al cargar la página
$(document).ready(function () {
    cargarOpcionesProveedor();
});
