// Funciones para prestar y devolver libros (Fases 7 y 8).

// Presta un libro a un usuario.
// Recibe MutableList de préstamos porque tiene que AÑADIR uno nuevo.
// Los libros también se reciben como MutableList porque se cambia el estado de uno de ellos.
fun realizarPrestamo(libros: MutableList<Libro>, usuarios: MutableList<Usuario>, prestamos: MutableList<Prestamo>) {
    println("--- Realizar préstamo ---")

    // 1) Identificador del libro: debe ser un número y el libro debe existir
    print("Identificador del libro: ")
    val idLibro = readln().trim().toIntOrNull()
    if (idLibro == null) {
        println("Error: el identificador del libro debe ser un número entero.")
        return
    }
    val libro = buscarLibro(libros, idLibro)
    if (libro == null) {
        println("Error: no existe ningún libro con el identificador $idLibro.")
        return
    }

    // 2) El libro debe estar disponible (no se puede prestar un libro ya prestado)
    if (!libro.disponible) {
        println("Error: el libro \"${libro.titulo}\" ya está prestado.")
        return
    }

    // 3) Identificador del usuario: debe ser un número y el usuario debe existir
    print("Identificador del usuario: ")
    val idUsuario = readln().trim().toIntOrNull()
    if (idUsuario == null) {
        println("Error: el identificador del usuario debe ser un número entero.")
        return
    }
    if (!existeUsuario(usuarios, idUsuario)) {
        println("Error: no existe ningún usuario con el identificador $idUsuario.")
        return
    }

    // 4) Fecha del préstamo: no puede estar vacía ni ser solo espacios
    print("Fecha del préstamo (dd/mm/aaaa): ")
    val fecha = readln().trim()
    if (fecha.isBlank()) {
        println("Error: la fecha del préstamo no puede estar vacía.")
        return
    }

    // Todo correcto: el libro deja de estar disponible y se guarda el préstamo
    libro.disponible = false
    val prestamo = Prestamo(idLibro, idUsuario, fecha)
    prestamos.add(prestamo)
    println("Préstamo registrado correctamente.")
}

// Devuelve un libro prestado.
// No necesita la lista de usuarios: para devolver basta con el identificador del libro.
fun devolverLibro(libros: MutableList<Libro>, prestamos: MutableList<Prestamo>) {
    println("--- Devolver libro ---")

    // 1) Identificador del libro: debe ser un número y el libro debe existir
    print("Identificador del libro: ")
    val idLibro = readln().trim().toIntOrNull()
    if (idLibro == null) {
        println("Error: el identificador del libro debe ser un número entero.")
        return
    }
    val libro = buscarLibro(libros, idLibro)
    if (libro == null) {
        println("Error: no existe ningún libro con el identificador $idLibro.")
        return
    }

    // 2) El libro debe estar actualmente prestado
    if (libro.disponible) {
        println("Error: el libro \"${libro.titulo}\" no está prestado, no se puede devolver.")
        return
    }

    // 3) Debe existir un préstamo activo (no devuelto) de ese libro
    val prestamo = buscarPrestamoActivo(prestamos, idLibro)
    if (prestamo == null) {
        println("Error: no hay ningún préstamo activo del libro \"${libro.titulo}\".")
        return
    }

    // Todo correcto: el libro vuelve a estar disponible y el préstamo queda cerrado
    libro.disponible = true
    prestamo.devuelto = true
    println("Libro devuelto correctamente.")
}

// Busca un libro por su identificador.
// Devuelve el libro encontrado o null si no hay ninguno con ese id.
fun buscarLibro(libros: List<Libro>, id: Int): Libro? {
    for (libro in libros) {
        if (libro.id == id) {
            return libro
        }
    }
    return null
}

// Busca el préstamo que todavía no se ha devuelto de un libro.
// Devuelve ese préstamo o null si el libro no tiene ningún préstamo activo.
// (Los préstamos antiguos del mismo libro ya tienen devuelto = true y se saltan.)
fun buscarPrestamoActivo(prestamos: List<Prestamo>, idLibro: Int): Prestamo? {
    for (prestamo in prestamos) {
        if (prestamo.idLibro == idLibro && !prestamo.devuelto) {
            return prestamo
        }
    }
    return null
}
