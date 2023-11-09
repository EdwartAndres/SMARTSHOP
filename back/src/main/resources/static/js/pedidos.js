let productos = []; // Almacena los productos en la factura
let cliente = null; // Almacena los datos del cliente

// Función para buscar un cliente por número de cédula
function buscarClientePorCedula() {
    const cedulaCliente = document.getElementById('cedulaCliente').value;
    // Realiza una consulta al backend para obtener los datos del cliente con la cédula especificada
    // Llena los campos con los datos del cliente si se encuentra
    // Debe asignar los datos del cliente a la variable 'cliente'

    // Ejemplo de cómo llenar los campos con los datos del cliente (debes ajustarlo según tu implementación):
    cliente = {
        nombre: 'Nombre del Cliente',
        telefono: 'Teléfono del Cliente',
        correo: 'Correo del Cliente'
    };

    // Llena los campos con los datos del cliente
    document.getElementById('nombreCliente').value = cliente.nombre;
    document.getElementById('telefonoCliente').value = cliente.telefono;
    document.getElementById('correoCliente').value = cliente.correo;
}

// Función para agregar un producto a la factura
function agregarProducto() {
    // Verifica que se haya seleccionado un cliente
    if (!cliente) {
        alert('Por favor, seleccione un cliente antes de agregar productos.');
        return;
    }

    const codigo = document.getElementById('codigo').value;
    const producto = document.getElementById('producto').value;
    const cantidad = parseFloat(document.getElementById('cantidad').value);
    const precioUnitario = parseFloat(document.getElementById('precioUnituario').value);

    if (!codigo || !producto || isNaN(cantidad) || isNaN(precioUnitario)) {
        alert('Por favor, complete todos los campos de producto correctamente.');
        return;
    }

    const subtotal = cantidad * precioUnitario;

    // Agregar el producto a la lista
    productos.push({
        codigo: codigo,
        producto: producto,
        cantidad: cantidad,
        precioUnitario: precioUnitario,
        subtotal: subtotal
    });

    // Actualizar la tabla de productos
    mostrarProductosEnTabla();
    actualizarTotal();
    limpiarCamposProductos();
}

// Función para mostrar los productos en la tabla
function mostrarProductosEnTabla() {
    const tablaProductos = document.getElementById('tablaProductos');
    tablaProductos.innerHTML = '';

    for (let i = 0; i < productos.length; i++) {
        const producto = productos[i];
        tablaProductos.innerHTML += `
            <tr>
                <td>${producto.codigo}</td>
                <td>${producto.producto}</td>
                <td>${producto.cantidad}</td>
                <td>${producto.precioUnitario}</td>
                <td>${producto.subtotal}</td>
                <td><button type="button" class="btn btn-danger" onclick="eliminarProducto(${i})">Eliminar</button></td>
            </tr>
        `;
    }
}

// Función para eliminar un producto de la factura
function eliminarProducto(index) {
    productos.splice(index, 1);
    mostrarProductosEnTabla();
    actualizarTotal();
}

// Función para actualizar el total de la factura
function actualizarTotal() {
    const totalElement = document.getElementById('total');
    let total = 0;

    for (let i = 0; i < productos.length; i++) {
        total += productos[i].subtotal;
    }

    totalElement.value = total.toFixed(2);
}

// Función para limpiar los campos de productos del formulario
function limpiarCamposProductos() {
    document.getElementById('codigo').value = '';
    document.getElementById('producto').value = '';
    document.getElementById('cantidad').value = '';
    document.getElementById('precioUnitario').value = '';
}

// Función para registrar la venta con el cliente
function registrarVenta() {
    // Verifica que se haya seleccionado un cliente y que se hayan agregado productos
    if (!cliente) {
        alert('Por favor, seleccione un cliente antes de registrar la venta.');
        return;
    }
    if (productos.length === 0) {
        alert('Agregue al menos un producto a la venta.');
        return;
    }

    // Aquí debes implementar la lógica para enviar los datos de la venta (cliente, productos) al backend y registrar la venta en la base de datos.

    // Reinicia los campos de cliente y productos
    cliente = null;
    limpiarCamposCliente();
    productos = [];
    mostrarProductosEnTabla();
    actualizarTotal();
}

// Función para limpiar los campos de cliente del formulario
function limpiarCamposCliente() {
    document.getElementById('cedulaCliente').value = '';
    document.getElementById('nombreCliente').value = '';
    document.getElementById('telefonoCliente').value = '';
    document.getElementById('correoCliente').value = '';
}
