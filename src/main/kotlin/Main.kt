// Sistema de préstamos de biblioteca - UD01 PMDM

fun main() {
    // Listas mutables donde se guarda toda la información del programa
    val libros = mutableListOf<Libro>()
    val usuarios = mutableListOf<Usuario>()
    val prestamos = mutableListOf<Prestamo>()

    var opcion = 0

    // El menú se repite hasta que el usuario elige 9 (Salir)
    while (opcion != 9) {
        mostrarMenu()
        val entrada = readln()

        // toIntOrNull() devuelve null si lo escrito no es un número (por ejemplo "abc")
        val numero = entrada.toIntOrNull()

        if (numero == null) {
            println("Error: debe introducir un número del 1 al 9.")
        } else {
            opcion = numero
            when (opcion) {
                1 -> registrarLibro(libros)
                2 -> registrarUsuario(usuarios)
                3 -> listarLibros(libros)
                4 -> listarUsuarios(usuarios)
                5 -> realizarPrestamo(libros, usuarios, prestamos)
                6 -> devolverLibro(libros, prestamos)
                7 -> mostrarPendiente("Consultar préstamos activos")
                8 -> mostrarPendiente("Buscar libro")
                9 -> println("Saliendo del sistema de biblioteca. ¡Hasta pronto!")
                else -> println("Opción no válida. Elija un número del 1 al 9.")
            }
        }
        println()
    }
}

// Muestra las opciones del menú principal
fun mostrarMenu() {
    println("===== SISTEMA DE BIBLIOTECA =====")
    println("1. Registrar libro")
    println("2. Registrar usuario")
    println("3. Listar libros")
    println("4. Listar usuarios")
    println("5. Realizar préstamo")
    println("6. Devolver libro")
    println("7. Consultar préstamos activos")
    println("8. Buscar libro")
    println("9. Salir")
    print("Seleccione una opción: ")
}

// Aviso temporal para las opciones que todavía no están hechas
fun mostrarPendiente(nombreOpcion: String) {
    println("[$nombreOpcion] Opción pendiente de implementar.")
}
