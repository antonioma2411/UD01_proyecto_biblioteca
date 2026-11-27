# UD01_Proyecto_Biblioteca

Sistema de préstamos de biblioteca en Kotlin (aplicación de consola). PMDM · UD01.

## Abrir en IntelliJ IDEA

1. `File > Open...` y seleccionar la carpeta del proyecto (la que contiene `pom.xml`).
2. IntelliJ lo detecta como proyecto Maven + Kotlin y descarga lo necesario.
3. Abrir `src/main/kotlin/Main.kt` y pulsar el triángulo verde junto a `fun main()`.

## Estructura

```
src/main/kotlin/
├── Main.kt            Menú principal y listas mutables
├── GestionLibros.kt   registrarLibro, listarLibros (Fases 4 y 6)
├── GestionUsuarios.kt registrarUsuario, listarUsuarios (Fases 5 y 6)
├── GestionPrestamos.kt realizarPrestamo, devolverLibro (Fases 7 y 8)
├── Libro.kt           data class Libro
├── Usuario.kt         data class Usuario
└── Prestamo.kt        data class Prestamo
```

## Estado

- [x] Fase 1. Creación del proyecto
- [x] Fase 2. Estructuras de datos (`data class` y `MutableList`)
- [x] Fase 3. Menú principal
- [x] Fase 4. Registro de libros
- [x] Fase 5. Registro de usuarios
- [x] Fase 6. Listado de libros y usuarios
- [x] Fase 7. Realización de préstamos
- [x] Fase 8. Devolución de libros
- [ ] Fases 9 a 11
