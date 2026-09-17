--------------------------
fun validarBateria(nivel: Int): Boolean = nivel >= 20

fun verificarClima(condicion: String): Boolean = condicion in listOf("normal", "lluvia", "emergencia")


--------------------------
val bateriaSuficiente: (Int) -> Boolean = { nivel -> nivel >= 30 }

val climaSeguro: (String) -> Boolean = { condicion -> condicion != "tormenta" }

---------------------------
fun evaluarSeguridad(
    bateria: Int,
    condicion: String,
    reglaBateria: (Int) -> Boolean,
    reglaClima: (String) -> Boolean
): Boolean {
    return reglaBateria(bateria) && reglaClima(condicion)
}
