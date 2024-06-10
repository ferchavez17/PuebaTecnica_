fun main() {
    // Inicializar un mapa de asientos con todos los asientos libres ('L')
    val asientos = Array(10) { Array(10) { 'L' } }

    // Mostrar el mapa inicial de asientos
    mostrarAsientos(asientos)

    // Bucle principal para realizar operaciones con los asientos
    while (true) {
        println("Opciones:")
        println("1. Reservar asiento")
        println("2. Mostrar asientos libres")
        println("3. Salir")

        print("Ingrese una opción: ")
        val opcion = readLine()?.toIntOrNull()

        when (opcion) {
            1 -> reservarAsiento(asientos)
            2 -> mostrarAsientosLibres(asientos)
            3 -> break
            else -> println("Opción inválida")
        }
    }
}

// Función para reservar un asiento
fun reservarAsiento(asientos: Array<Array<Char>>) {
    // Obtener la fila y columna del asiento a reservar
    print("Ingrese la fila (1-10): ")
    val fila = readLine()?.toIntOrNull()?.minus(1) ?: -1
    print("Ingrese la columna (1-10): ")
    val columna = readLine()?.toIntOrNull()?.minus(1) ?: -1

    // Validar la fila y columna
    if (fila in 0..9 && columna in 0..9) {
        // Verificar si el asiento está libre
        if (asientos[fila][columna] == 'L') {
            // Reservar el asiento
            asientos[fila][columna] = 'X'
            println("Asiento reservado exitosamente.")
            // Mostrar el nuevo mapa de asientos
            mostrarAsientos(asientos)
        } else {
            println("El asiento ya está reservado.")
        }
    } else {
        println("Fila o columna inválida.")
    }
}

// Función para mostrar los asientos libres
fun mostrarAsientosLibres(asientos: Array<Array<Char>>) {
    // Mostrar el mapa de asientos con los asientos libres
    mostrarAsientos(asientos)
}

// Función para mostrar el mapa de asientos
fun mostrarAsientos(asientos: Array<Array<Char>>) {
    println("Mapa de asientos:")
    for (i in 0..9) {
        for (j in 0..9) {
            print(asientos[i][j])
            print(" ")
        }
        println()
    }
}