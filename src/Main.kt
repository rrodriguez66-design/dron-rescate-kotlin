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
