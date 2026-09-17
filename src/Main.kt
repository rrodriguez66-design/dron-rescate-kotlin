// --- FASE 3.1: Funciones de una sola expresión ---
fun calcularDistanciaTotal(distanciaIda: Double): Double = distanciaIda * 2.0

fun calcularTiempoBase(distanciaTotal: Double): Double = distanciaTotal / 2.0

// --- FASE 3.2: Lambdas en variables ---
val aumentarVeintePorciento: (Double) -> Double = { valor -> valor * 1.20 }

val disminuirDiezPorciento: (Double) -> Double = { valor -> valor * 0.90 }

// --- FASE 3.3: Función de orden superior ---
fun aplicarAjuste(valorBase: Double, ajuste: (Double) -> Double): Double {
    return ajuste(valorBase)
}

// --- FASE 3.4: Selección del ajuste con when ---
fun calcularTiempoFinal(
    tiempoBase: Double,
    condicion: String,
    ajusteLluvia: (Double) -> Double,
    ajusteEmergencia: (Double) -> Double
): Double {
    return when (condicion) {
        "lluvia" -> aplicarAjuste(tiempoBase, ajusteLluvia)
        "emergencia" -> aplicarAjuste(tiempoBase, ajusteEmergencia)
        else -> tiempoBase // Para la condición "normal"
    }
}

// --- FASE 4.1: Funciones compactas ---
fun validarBateria(nivel: Int): Boolean = nivel >= 20

fun verificarClima(condicion: String): Boolean = condicion in listOf("normal", "lluvia", "emergencia")

// --- FASE 4.2: Lambdas ---
val bateriaSuficiente: (Int) -> Boolean = { nivel -> nivel >= 30 }

val climaSeguro: (String) -> Boolean = { condicion -> condicion != "tormenta" }

// --- FASE 4.3: Función de orden superior ---
fun evaluarSeguridad(
    bateria: Int,
    condicion: String,
    reglaBateria: (Int) -> Boolean,
    reglaClima: (String) -> Boolean
): Boolean {
    return reglaBateria(bateria) && reglaClima(condicion)
}

// --- FASE 7: Función Principal ---
fun main() {
    println("=== SIMULADOR DE DRON DE RESCATE ===")

    // 1. Lectura de datos
    print("Ingrese la distancia de ida (km): ")
    val distanciaIda = readln().toDoubleOrNull() ?: 0.0

    print("Ingrese el nivel de batería (%): ")
    val bateria = readln().toIntOrNull() ?: 0

    print("Ingrese la condición del clima (normal/lluvia/emergencia/tormenta): ")
    val clima = readln().lowercase()

    // 2. Evaluaciones de seguridad y vuelo
    val esSeguro = evaluarSeguridad(bateria, clima, bateriaSuficiente, climaSeguro)

    if (!esSeguro) {
        println("\n[ALERTA] La misión NO es segura. Despegue cancelado.")
        return
    }

    val distanciaTotal = calcularDistanciaTotal(distanciaIda)
    val tiempoBase = calcularTiempoBase(distanciaTotal)
    val tiempoFinal = calcularTiempoFinal(
        tiempoBase,
        clima,
        aumentarVeintePorciento,
        disminuirDiezPorciento
    )

    // 3. Resultado final
    println("\n=== DICTAMEN DE MISIÓN ===")
    println("Distancia total a recorrer: $distanciaTotal km")
    println("Tiempo estimado de vuelo: $tiempoFinal minutos")
    println("Estado: AUTORIZADO")
}
// Fin de funciones de vuelo
