fun main() {
    // Aquí integraremos el menú y la interacción con el usuario en la Fase 7
}

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