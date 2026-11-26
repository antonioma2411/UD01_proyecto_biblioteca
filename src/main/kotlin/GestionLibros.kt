// Funciones para registrar y listar libros (Fases 4 y 6).

// Pide los datos de un libro, los valida y, si todo es correcto, lo añade a la lista.
// Recibe MutableList porque la función tiene que AÑADIR un libro a la lista.
fun registrarLibro(libros: MutableList<Libro>) {
    println("--- Registrar libro ---")

    // 1) Identificador: debe ser un número entero mayor que 0
    print("Identificador del libro: ")
    val id = readln().trim().toIntOrNull()
    if (id == null || id <= 0) {
        println("Error: el identificador debe ser un número entero mayor que 0.")
        return
    }

    // 2) El identificador no puede estar repetido
    if (existeLibro(libros, id)) {
        println("Error: ya existe un libro con el identificador $id.")
        return
    }

    // 3) Título: no puede estar vacío ni ser solo espacios
    print("Título: ")
    val titulo = readln().trim()
    if (titulo.isBlank()) {
        println("Error: el título no puede estar vacío.")
        return
    }

    // 4) Autor: no puede estar vacío ni ser solo espacios
    print("Autor: ")
    val autor = readln().trim()
    if (autor.isBlank()) {
        println("Error: el autor no puede estar vacío.")
        return
    }

    // Todo correcto: se añade el libro como disponible (valor por defecto)
    val libro = Libro(id, titulo, autor)
    libros.add(libro)
    println("Libro registrado correctamente.")
}

// Devuelve true si en la lista ya hay un libro con ese identificador.
fun existeLibro(libros: List<Libro>, id: Int): Boolean {
    for (libro in libros) {
        if (libro.id == id) {
            return true
        }
    }
    return false
}

// Muestra todos los libros. Recibe List porque solo los LEE, no los cambia.
fun listarLibros(libros: List<Libro>) {
    println("--- Listado de libros ---")
    if (libros.isEmpty()) {
        println("No hay libros registrados.")
        return
    }

    for (libro in libros) {
        var estado = "Disponible"
        if (!libro.disponible) {
            estado = "Prestado"
        }
        println("${libro.id} - ${libro.titulo} - ${libro.autor} - $estado")
    }
}
