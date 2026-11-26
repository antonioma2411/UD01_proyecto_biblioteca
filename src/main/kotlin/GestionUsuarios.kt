// Funciones para registrar y listar usuarios (Fases 5 y 6).

// Pide los datos de un usuario, los valida y, si todo es correcto, lo añade a la lista.
// Recibe MutableList porque la función tiene que AÑADIR un usuario a la lista.
fun registrarUsuario(usuarios: MutableList<Usuario>) {
    println("--- Registrar usuario ---")

    // 1) Identificador: debe ser un número entero mayor que 0
    print("Identificador del usuario: ")
    val id = readln().trim().toIntOrNull()
    if (id == null || id <= 0) {
        println("Error: el identificador debe ser un número entero mayor que 0.")
        return
    }

    // 2) El identificador no puede estar repetido
    if (existeUsuario(usuarios, id)) {
        println("Error: ya existe un usuario con el identificador $id.")
        return
    }

    // 3) Nombre: no puede estar vacío ni ser solo espacios
    print("Nombre: ")
    val nombre = readln().trim()
    if (nombre.isBlank()) {
        println("Error: el nombre no puede estar vacío.")
        return
    }

    // 4) Apellidos: no pueden estar vacíos ni ser solo espacios
    print("Apellidos: ")
    val apellidos = readln().trim()
    if (apellidos.isBlank()) {
        println("Error: los apellidos no pueden estar vacíos.")
        return
    }

    // Todo correcto: se añade el usuario a la lista
    val usuario = Usuario(id, nombre, apellidos)
    usuarios.add(usuario)
    println("Usuario registrado correctamente.")
}

// Devuelve true si en la lista ya hay un usuario con ese identificador.
fun existeUsuario(usuarios: List<Usuario>, id: Int): Boolean {
    for (usuario in usuarios) {
        if (usuario.id == id) {
            return true
        }
    }
    return false
}

// Muestra todos los usuarios. Recibe List porque solo los LEE, no los cambia.
fun listarUsuarios(usuarios: List<Usuario>) {
    println("--- Listado de usuarios ---")
    if (usuarios.isEmpty()) {
        println("No hay usuarios registrados.")
        return
    }

    for (usuario in usuarios) {
        println("${usuario.id} - ${usuario.nombre} ${usuario.apellidos}")
    }
}
