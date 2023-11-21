// Definir variables para mantener la información de cliente, productos y total
let clienteData = {};
let productosData = [];
let totalCuenta = 0;

// Función para buscar cliente por cédula o nombre
function buscarCliente() {
    console.log("Buscar cliente ejecutado");
    const clienteInput = document.getElementById("clienteInput").value;

    // Realizar la llamada AJAX para obtener información del cliente
    $.ajax({
        url: "http://localhost:8080/api/clientes/nombre/" + clienteInput, // Reemplaza la URL con la correcta
        type: "GET",
        success: function (clienteData) {
            // Actualizar la variable clienteData con la información obtenida
            if (clienteData.length > 0) {
                clienteData = clienteData[0]; // Tomar el primer cliente encontrado (asumiendo que la búsqueda devuelve uno)
                // Mostrar saludo al cliente
                document.getElementById("saludoCliente").innerText = "Hola, " + clienteData.nomCliente;
            } else {
                // Limpiar el saludo si no se encuentra el cliente
                document.getElementById("saludoCliente").innerText = "";
            }
        },
        error: function (error) {
            console.error("Error al buscar cliente:", error);
        }
    });
}

// Función para buscar producto por código o nombre
function buscarProducto() {
    console.log("Buscar producto ejecutado");
    const productoInput = document.getElementById("productoInput").value;
    const cantidadInput = parseInt(document.getElementById("cantidadInput").value);

    // Realizar la llamada AJAX para obtener información del producto
    $.ajax({
        url: "http://localhost:8080/api/productos/nombre/" + productoInput, // Reemplaza la URL con la correcta
        type: "GET",
        success: function (productoData) {
            // Actualizar la variable productosData con la información obtenida
            if (productoData.length > 0) {
                const producto = productoData[0]; // Tomar el primer producto encontrado (asumiendo que la búsqueda devuelve uno)
                producto.cantidad = cantidadInput;
                producto.precioTotal = cantidadInput * producto.precio;

                // Agregar el producto a la lista de productos
                productosData.push(producto);

                // Actualizar la tabla de productos
                actualizarTablaProductos();

                // Calcular el total de la cuenta
                calcularTotalCuenta();
            } else {
                console.error("Producto no encontrado");
            }
        },
        error: function (error) {
            console.error("Error al buscar producto:", error);
        }
    });
}


    // Agregar el producto a la lista de productos
    productosData.push(producto);

    // Actualizar la tabla de productos
    actualizarTablaProductos();

    // Calcular el total de la cuenta
    calcularTotalCuenta();
}

// Función para actualizar la tabla de productos
function actualizarTablaProductos() {
    const productosBody = document.getElementById("productosBody");
    productosBody.innerHTML = ""; // Limpiar el contenido actual de la tabla

    // Recorrer la lista de productos y agregar filas a la tabla
    productosData.forEach(producto => {
        const row = productosBody.insertRow();
        row.insertCell(0).innerText = producto.nombre;
        row.insertCell(1).innerText = producto.cantidad;
        row.insertCell(2).innerText = producto.precioUnitario.toFixed(2);
        row.insertCell(3).innerText = producto.precioTotal.toFixed(2);

        // Agregar botón de eliminar producto
        const deleteButton = document.createElement("button");
        deleteButton.innerText = "Eliminar";
        deleteButton.addEventListener("click", function () {
            eliminarProducto(producto);
        });

        // Agregar el botón a la celda de acciones
        const cell = row.insertCell(4);
        cell.appendChild(deleteButton);
    });
}

// Función para eliminar un producto de la lista
function eliminarProducto(producto) {
    // Filtrar la lista de productos para excluir el producto a eliminar
    productosData = productosData.filter(p => p !== producto);

    // Actualizar la tabla de productos
    actualizarTablaProductos();

    // Calcular el total de la cuenta
    calcularTotalCuenta();
}

// Función para calcular el total de la cuenta
function calcularTotalCuenta() {
    totalCuenta = productosData.reduce((total, producto) => total + producto.precioTotal, 0);

    // Mostrar el total en el elemento HTML
    document.getElementById("totalCuenta").innerText = "Total: $" + totalCuenta.toFixed(2);
}

