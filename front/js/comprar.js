// Obtener referencias a los elementos del formulario
const ventaForm = document.getElementById("ventaForm");
const empleadoSelect = document.getElementById("empleado");
const clienteSelect = document.getElementById("cliente");
const productosDiv = document.getElementById("productos");
const agregarProductoButton = document.getElementById("agregarProducto");

// Función para cargar opciones desde la base de datos
function cargarOpciones(select, endpoint) {
    fetch(endpoint)
        .then((response) => response.json())
        .then((data) => {
            select.innerHTML = "<option value=''>Selecciona una opción</option>";
            data.forEach((item) => {
                const option = document.createElement("option");
                option.value = item.id; // Reemplaza 'id' con el nombre del campo de ID en tu base de datos
                option.textContent = item.nombre; // Reemplaza 'nombre' con el nombre del campo correspondiente
                select.appendChild(option);
            });
        })
        .catch((error) => {
            console.error("Error al cargar datos: " + error);
        });
}

// Cargar empleados y clientes al cargar la página
cargarOpciones(empleadoSelect, "/empleadosEndpoint"); // Reemplaza con tu URL real
cargarOpciones(clienteSelect, "/clientesEndpoint"); // Reemplaza con tu URL real

// Manejar la adición de productos dinámicamente
let productoCounter = 0; // Contador para identificar productos agregados

agregarProductoButton.addEventListener("click", () => {
    productoCounter++;

    const productoDiv = document.createElement("div");
    productoDiv.innerHTML = `
        <label for="producto">Producto:</label>
        <select id="producto${productoCounter}" name="producto${productoCounter}" required>
            <option value="">Selecciona un producto</option>
            <!-- Opciones de productos se cargarán dinámicamente desde la base de datos -->
        </select><br><br>

        <label for="cantidad">Cantidad:</label>
        <input type="number" id="cantidad${productoCounter}" name="cantidad${productoCounter}" min="1" required><br><br>
    `;

    productosDiv.appendChild(productoDiv);

    // Cargar opciones de productos para este producto recién agregado
    const productoSelect = document.getElementById(`producto${productoCounter}`);
    cargarOpciones(productoSelect, "/productosEndpoint"); // Reemplaza con tu URL real
});

// Manejar el envío del formulario
ventaForm.addEventListener("submit", (event) => {
    event.preventDefault();

    // Recopilar datos del formulario y productos dinámicos
    const formData = new FormData(ventaForm);
    const productos = [];

    for (let i = 0; i < productoCounter; i++) {
        const productoId = formData.get(`producto${i + 1}`);
        const cantidad = formData.get(`cantidad${i + 1}`);

        if (productoId && cantidad) {
            productos.push({ productoId, cantidad });
        }
    }

    // Aquí puedes enviar los datos al servidor, incluyendo productos
    // Usar `formData` y `productos` para enviar todo al servidor
    // ...

    // Restablecer el formulario o realizar otras acciones según sea necesario
    ventaForm.reset();
    productosDiv.innerHTML = ""; // Limpiar productos dinámicos
});

