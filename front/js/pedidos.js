let productos = []; // Almacena los productos en la factura

// Función para agregar un producto a la factura
function agregarProducto() {
    const codigo = document.getElementById('codigo').value;
    const producto = document.getElementById('producto').value;
    const cantidad = parseFloat(document.getElementById('cantidad').value);
    const precioUnitario = parseFloat(document.getElementById('precioUnitario').value);

    if (!codigo || !producto || isNaN(cantidad) || isNaN(precioUnitario)) {
        alert('Por favor, complete todos los campos correctamente.');
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
    limpiarCampos();
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

// Función para limpiar los campos del formulario
function limpiarCampos() {
    document.getElementById('codigo').value = '';
    document.getElementById('producto').value = '';
    document.getElementById('cantidad').value = '';
    document.getElementById('precioUnitario').value = '';
}

// Ahora puedes agregar una función para enviar la factura al backend y guardarla en tu sistema.
