# Planeación Estudiante A - Cálculos de Vuelo

## 1. Función: calcularDistanciaTotal
* **Datos de entrada:** `distanciaIda` (Double)
* **Resultado esperado:** El doble de la distancia ingresada (ida y vuelta).
* **Pseudocódigo:** Multiplicar `distanciaIda` por 2.
* **Casos de prueba:**
    * Entrada: 4.0 -> Salida: 8.0
    * Entrada (límite): 0.0 -> Salida: 0.0

## 2. Función: calcularTiempoBase
* **Datos de entrada:** `distanciaTotal` (Double)
* **Resultado esperado:** Minutos de vuelo. Como recorre 2 km por minuto, es la mitad de la distancia total.
* **Pseudocódigo:** Dividir `distanciaTotal` entre 2.
* **Casos de prueba:**
    * Entrada: 10.0 -> Salida: 5.0
    * Entrada (límite): 0.0 -> Salida: 0.0

## 3. Lambdas: aumentarVeintePorciento y disminuirDiezPorciento
* **Datos de entrada:** `valor` (Double)
* **Resultado esperado:** El valor ajustado por el porcentaje correspondiente.
* **Pseudocódigo:**
    * Aumentar: Multiplicar `valor` por 1.20
    * Disminuir: Multiplicar `valor` por 0.90
* **Casos de prueba:**
    * Aumentar 10.0 -> Salida: 12.0
    * Disminuir 10.0 -> Salida: 9.0

## 4. Función de orden superior: aplicarAjuste
* **Datos de entrada:** `valorBase` (Double), `ajuste` (Función que recibe un Double y devuelve un Double)
* **Resultado esperado:** El valor base transformado por la función de ajuste.
* **Pseudocódigo:** Retornar el resultado de ejecutar la función `ajuste` pasándole el `valorBase`.
* **Casos de prueba:**
    * Entrada: 10.0 y lambda de aumentar -> Salida: 12.0

## 5. Función: calcularTiempoFinal
* **Datos de entrada:** `tiempoBase` (Double), `condicion` (String), `ajusteLluvia` (Función), `ajusteEmergencia` (Función)
* **Resultado esperado:** El tiempo final dependiendo del clima.
* **Pseudocódigo:** Usar un `when` evaluando la `condicion`. Si es "normal", devolver `tiempoBase`. Si es "lluvia", aplicar `ajusteLluvia`. Si es "emergencia", aplicar `ajusteEmergencia`.
* **Casos de prueba:**
    * Entrada: 10.0, "lluvia", lambdaAumento, lambdaDisminucion -> Salida: 12.0
    * Entrada: 10.0, "normal", lambdaAumento, lambdaDisminucion -> Salida: 10.0