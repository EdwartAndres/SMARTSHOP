function obtenerProveedoresDesdeServidor() {
       $.ajax({
        url: '/api/proveedore',
        type: 'GET',
        success: function (proveedores) {
            llenarOpcionesProveedor(proveedores);
        },
        error: function (error) {
            console.error('Error al obtener la lista de proveedores:', error);
        }
    });
}


// Función para llenar dinámicamente las opciones del proveedor
function llenarOpcionesProveedor(proveedores) {
    const selectProveedor = document.getElementById('proveedor');
    selectProveedor.innerHTML = '';

    proveedores.forEach(proveedor => {
        const option = document.createElement('option');
        option.value = proveedor.rut; // Ajusta el valor según la estructura de tus proveedores
        option.text = proveedor.nombre;
        selectProveedor.add(option);
    });
}
function listarProductos() {
    $.ajax({
        url: '/api/productos',
        type: 'GET',
        success: function (productos) {
            // Llama a la función para mostrar los productos en la interfaz
            mostrarProductosEnTabla(productos);
        },
        error: function (error) {
            console.error('Error al obtener la lista de productos:', error);
        }
    });
}

// Función para mostrar los productos en la tabla de la interfaz
function mostrarProductosEnTabla(productos) {
    const tablaProductos = document.getElementById('tablaProductosInventario');
    const tbody = tablaProductos.getElementsByTagName('tbody')[0];

    // Limpia la tabla antes de agregar los nuevos productos
    tbody.innerHTML = '';

    // Itera sobre la lista de productos y agrega cada uno a la tabla
    productos.forEach(producto => {
        const fila = tbody.insertRow();
        const celdas = [
            producto.id,
            producto.nombre,
            producto.descripcion,
            producto.cantidad,
            producto.precio,
            producto.costo,
            producto.proveedor.nombre,  // Ajusta según la estructura de tu objeto de producto y proveedor
            '<button class="btn btn-danger" onclick="eliminarProducto(' + producto.id + ')">Eliminar</button>'
        ];

        // Agrega las celdas a la fila
        celdas.forEach((valor, index) => {
            const celda = fila.insertCell(index);
            celda.innerHTML = valor;
        });
    });
}

/// Función para agregar un producto al inventario
 function agregarProductoInventario() {
     const idProducto = document.getElementById('idProducto').value;
     const nombreProducto = document.getElementById('nombreProducto').value;
     const descripcionProducto = document.getElementById('descripcionProducto').value;
     const cantidadStock = document.getElementById('cantidadStock').value;
     const precioCompra = document.getElementById('precioCompra').value;  // Precio en el formulario
     const precioVenta = document.getElementById('precioVenta').value;    // Precio en el formulario
     const proveedor = document.getElementById('proveedor').value;

     // Crea un objeto con los datos del producto
     const nuevoProducto = {
         id: idProducto,
         nombre: nombreProducto,
         descripcion: descripcionProducto,
         cantidad: cantidadStock,
         precio: parseFloat(precioCompra),  // Asegúrate de convertirlo a número si es necesario
         costo: parseFloat(precioVenta),    // Asegúrate de convertirlo a número si es necesario
         proveedor: {
             rut: proveedor  // Esto asume que el proveedor tiene una propiedad 'rut'
         }
     };

     // Realiza una solicitud AJAX para agregar el producto al servidor
     $.ajax({
         url: '/api/productos',  // Ajusta la URL según tu configuración
         type: 'POST',
         contentType: 'application/json',
         data: JSON.stringify(nuevoProducto),
         success: function (productoAgregado) {
             alert('Producto agregado al inventario');

             // Limpiar los campos del formulario
             document.getElementById('idProducto').value = '';
             document.getElementById('nombreProducto').value = '';
             document.getElementById('descripcionProducto').value = '';
             document.getElementById('cantidadStock').value = '';
             document.getElementById('precioCompra').value = '';
             document.getElementById('precioVenta').value = '';
             document.getElementById('proveedor').value = '';

             // Puedes realizar otras acciones aquí, como actualizar la lista de productos
             listarProductos();
         },
         error: function (error) {
             console.error('Error al agregar el producto:', error);
         }
     });
 }

 obtenerProveedoresDesdeServidor();
