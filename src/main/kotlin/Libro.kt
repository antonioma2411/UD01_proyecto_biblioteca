// Representa un libro de la biblioteca.
// "disponible" es var porque cambia al prestar y al devolver el libro.
data class Libro(
    val id: Int,
    val titulo: String,
    val autor: String,
    var disponible: Boolean = true
)
