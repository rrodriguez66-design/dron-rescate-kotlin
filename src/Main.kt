//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val name = "Kotlin"
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    println("Hello, " + name + "!")

    for (i in 1..5) {
        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
        println("i = $i")
    }

    ------------------------------------------------

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



