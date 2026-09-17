# Planeación Estudiante B - Seguridad y Batería

## 1. Función: validarBateria
* **Datos de entrada:** `nivel` (Int)
* **Resultado esperado:** `Boolean` (`true` si el nivel de batería es mayor o igual a 20%, `false` en caso contrario).
* **Pseudocódigo:** Evaluar si `nivel >= 20`.
* **Casos de prueba:**
    * Entrada: 50 -> Salida: true
    * Entrada (límite): 20 -> Salida: true
    * Entrada: 15 -> Salida: false

## 2. Función: verificarClima
* **Datos de entrada:** `condicion` (String)
* **Resultado esperado:** `Boolean` (`true` si la condición está dentro de la lista de climas permitidos: "normal", "lluvia", "emergencia").
* **Pseudocódigo:** Comprobar si `condicion` pertenece a la lista de climas válidos.
* **Casos de prueba:**
    * Entrada: "normal" -> Salida: true
    * Entrada: "tormenta" -> Salida: false

## 3. Lambdas: bateriaSuficiente y climaSeguro
* **Datos de entrada:** `nivel` (Int) para batería, `condicion` (String) para clima.
* **Resultado esperado:**
    * `bateriaSuficiente`: `true` si el nivel es mayor o igual a 30%.
    * `climaSeguro`: `true` si la condición es distinta de "tormenta".
* **Pseudocódigo:**
    * Batería: `nivel >= 30`
    * Clima: `condicion != "tormenta"`
* **Casos de prueba:**
    * Batería 35 -> Salida: true
    * Clima "tormenta" -> Salida: false

## 4. Función de orden superior: evaluarSeguridad
* **Datos de entrada:** `bateria` (Int), `condicion` (String), `reglaBateria` (Función que recibe Int y devuelve Boolean), `reglaClima` (Función que recibe String y devuelve Boolean).
* **Resultado esperado:** `Boolean` (`true` únicamente si ambas funciones de regla devuelven `true`).
* **Pseudocódigo:** Retornar el resultado lógico de `reglaBateria(bateria) && reglaClima(condicion)`.
* **Casos de prueba:**
    * Entrada: 80, "normal", lambdaBateria, lambdaClima -> Salida: true
    * Entrada: 10, "normal", lambdaBateria, lambdaClima -> Salida: false
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
