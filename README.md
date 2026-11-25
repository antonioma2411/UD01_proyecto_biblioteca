# UD01_Proyecto_Biblioteca

Sistema de préstamos de biblioteca en Kotlin (aplicación de consola). PMDM · UD01.

## Abrir en IntelliJ IDEA

1. `File > Open...` y seleccionar la carpeta del proyecto (la que contiene `pom.xml`).
2. IntelliJ lo detecta como proyecto Maven + Kotlin y descarga lo necesario.
3. Abrir `src/main/kotlin/Main.kt` y pulsar el triángulo verde junto a `fun main()`.

## Estructura

```
src/main/kotlin/
├── Main.kt       Menú principal y listas mutables
├── Libro.kt      data class Libro
├── Usuario.kt    data class Usuario
└── Prestamo.kt   data class Prestamo
```

## Estado

- [x] Fase 1. Creación del proyecto
- [x] Fase 2. Estructuras de datos (`data class` y `MutableList`)
- [x] Fase 3. Menú principal
- [ ] Fases 4 a 11
