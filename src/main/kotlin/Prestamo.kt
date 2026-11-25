// Representa el préstamo de un libro a un usuario.
// Guarda solo los id: se relaciona con Libro e Usuario a través de ellos.
// "devuelto" es var porque pasa a true cuando se devuelve el libro.
data class Prestamo(
    val idLibro: Int,
    val idUsuario: Int,
    val fechaPrestamo: String,
    var devuelto: Boolean = false
)
