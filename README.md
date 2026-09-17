# Dron Rescate Kotlin

## 1. Integrantes
* **Estudiante A:** Román Rodríguez Castro 
* **Estudiante B:** Isai Emiliano Valdez Vazquez

## 2. Responsabilidades
* **Román Rodríguez Castro (Estudiante A):** Responsable de la rama `calculos-vuelo`. Implementó la lógica matemática del dron: cálculo de distancia, tiempo base, funciones lambdas para los ajustes climáticos y funciones de orden superior para alterar dinámicamente el tiempo de vuelo.
* **Isai Emiliano Valdez Vazquez (Estudiante B):** Responsable de la rama de seguridad y validaciones. Encargado de programar los protocolos previos al vuelo, implementar las verificaciones del sistema y utilizar referencias a funciones para autorizar el inicio de la misión.

## 3. Instrucciones de ejecución
1. Clonar el repositorio en la computadora local.
2. Abrir el proyecto usando IntelliJ IDEA.
3. Desplegar la carpeta `src` y abrir el archivo `Main.kt`.
4. Ejecutar el código presionando el ícono verde de "Run" junto a la función `main()`, o presionando `Mayús + F10`.
5. Los resultados y operaciones de la misión se mostrarán en la consola inferior interactuando con los menús.

## 4. Clasificación de Funciones
* **Funciones de expresión única:** `calcularDistanciaTotal` y `calcularTiempoBase`.
* **Lambdas:** `aumentarVeintePorciento`, `disminuirDiezPorciento` y asignaciones de ajustes por emergencia.
* **Funciones de orden superior:** `aplicarAjuste` y `calcularTiempoFinal` (reciben funciones o lambdas como parámetros).
* **Uso de `::` (Referencia a función):** `::autorizarMisionPorSeguridad` para pasar lógicas de validación completas.

## 5. Pruebas ejecutadas y sus resultados
* **Prueba de clima lluvioso (Román):** Se ingresó la condición "lluvia". El programa calculó el tiempo base y sumó correctamente el 20% extra de tiempo utilizando la lambda correspondiente y la función de orden superior. Resultado: **Exitoso**.
* **Prueba de seguridad (Isai):** Se verificaron las condiciones de autorización previas al despegue empleando referencias a funciones. El sistema bloqueó o permitió la misión según los parámetros ingresados. Resultado: **Exitoso**.

## 6. Conclusiones individuales
* **Román Rodríguez Castro:** Comprendí el inmenso poder de las funciones de orden superior en Kotlin. El poder pasar lógica de programación (como una lambda) como si fuera un simple dato hace que el código sea extremadamente limpio, escalable y reutilizable, evitando ciclos condicionales gigantes.
* **Isai Emiliano Valdez Vazquez:** Trabajar con repositorios compartidos y ramas me permitió entender cómo se colabora en la industria. Además, aprendí que usar referencias a funciones con `::` es una forma muy eficiente de reciclar código existente sin tener que reescribirlo dentro de lambdas, manteniendo el proyecto modular.

---

## 7. Evidencia individual

### Estudiante A: Román Rodríguez Castro
1. **¿Qué diferencia existe entre una función nombrada y una lambda?**
   Una función nombrada se define formalmente usando la palabra `fun` y tiene una estructura más rígida y un nombre fijo para ser invocada. Una lambda es una función "anónima" (sin nombre) envuelta en llaves `{ }` que se puede guardar en una variable, pasar como argumento o definir directamente al vuelo de forma más concisa.
2. **¿Qué caracteriza a una función de una sola expresión?**
   Que no requiere abrir llaves `{ }` ni usar la palabra clave `return`. Utiliza el operador de asignación `=` para devolver directamente el resultado de una operación en una sola línea.
3. **¿Cuál función es de orden superior y por qué?**
   La función `aplicarAjuste` (y `calcularTiempoFinal`), porque recibe otra función como parámetro. En específico, recibe variables del tipo `(Double) -> Double`, lo que le permite inyectar distintos comportamientos matemáticos sin cambiar su estructura interna.
4. **¿Qué ventaja tuvo pasar el ajuste o criterio como parámetro?**
   Permitió crear un código genérico. En lugar de hacer una función para la lluvia, otra para el viento y otra para emergencias, creé un solo motor matemático (`aplicarAjuste`) que sabe cómo procesar el tiempo base, pero delega el cálculo específico a la lambda que se le inyecte en ese momento.
5. **¿Qué diferencia encontró entre pasar una lambda y usar `::autorizarMisionPorSeguridad`?**
   Pasar una lambda es pasar una lógica de código pequeña creada de forma dinámica y muchas veces definida en la misma línea. Por otro lado, usar el operador `::` crea una referencia hacia una función normal (nombrada) que ya existía previamente en el código, permitiendo reutilizar su lógica completa dentro de una función de orden superior.
6. **¿Qué parte desarrolló personalmente?**
   La lógica de la rama `calculos-vuelo`. Escribí todas las operaciones matemáticas base, los ajustes porcentuales basados en el clima utilizando lambdas, y la estructura principal para procesar las variables numéricas de la distancia y el tiempo.
7. **¿Qué modificó después de la revisión de su compañero?**
   Realicé ajustes en los bloques condicionales dentro del `when` y me aseguré de que las llamadas a las funciones de orden superior estuvieran correctamente estructuradas para evitar errores durante la integración del proyecto.

### Estudiante B: Isai Emiliano Valdez Vazquez
1. **¿Qué diferencia existe entre una función nombrada y una lambda?**
   Una función nombrada es la forma tradicional, declarada con la palabra `fun` y un nombre fijo. Una lambda, por el contrario, no tiene nombre, va entre llaves `{ }` y tiene la ventaja de que se puede tratar como si fuera una variable (se puede guardar, pasar o retornar a voluntad).
2. **¿Qué caracteriza a una función de una sola expresión?**
   Se caracteriza por ser muy resumida: elimina el uso de las llaves y de la palabra `return`. Simplemente usa el signo de igual `=` para asignar y retornar directamente el resultado de una única operación.
3. **¿Cuál función es de orden superior y por qué?**
   Es cualquier función que acepta a otra función (como una lambda o una referencia) como parámetro de entrada. Las funciones encargadas de procesar autorizaciones y cálculos finales lo son, porque requieren que les inyectemos las reglas operativas desde afuera para funcionar.
4. **¿Qué ventaja tuvo pasar el ajuste o criterio como parámetro?**
   Nos dio mucha flexibilidad y evitó código repetitivo. Al pasar el criterio como parámetro, la función se vuelve genérica y puede procesar cualquier regla o autorización que le enviemos sin tener que reescribir bloques enteros de código.
5. **¿Qué diferencia encontró entre pasar una lambda y usar `::autorizarMisionPorSeguridad`?**
   Las lambdas son excelentes para crear pequeñas lógicas rápidas donde se necesitan. Sin embargo, usar la referencia `::` fue ideal para mis validaciones, ya que me permitió apuntar a una función de seguridad más compleja y estructurada, enviándola como parámetro sin alterar su cuerpo original.
6. **¿Qué parte desarrolló personalmente?**
   Me encargué de la rama orientada a las validaciones y protocolos. Escribí las funciones nombradas para verificar las condiciones operativas y utilicé el operador `::` para pasar estas reglas al flujo principal, garantizando que la misión solo inicie si es seguro.
7. **¿Qué modificó después de la revisión de su compañero?**
   Ajusté los nombres de algunas variables e integré mis funciones de autorización con las funciones de impresión en consola de Román, asegurando que ambos flujos convivieran sin conflictos al momento de realizar el `merge` en la rama principal.