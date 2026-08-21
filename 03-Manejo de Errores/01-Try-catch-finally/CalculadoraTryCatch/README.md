# Ejemplo do-while, switch y manejo de excepciones - Calculadora Básica en Java

Este ejercicio combina el uso de un bucle **`do-while`** para repetir un proceso controlado por el usuario, con un **`switch`** que encapsula la lógica de decisión de una operación matemática, y un bloque **`try/catch/finally`** que gestiona de forma robusta los distintos errores que pueden ocurrir durante la ejecución.

## 📋 Descripción

- Uso de `Scanner` para leer datos ingresados por consola (`nextLine()`).
- Bucle `do-while` que garantiza al menos una ejecución y repite el cálculo mientras el usuario responda "s".
- Conversión de texto a número mediante `Double.parseDouble()`, capaz de lanzar `NumberFormatException` si el valor no es válido.
- Delegación del cálculo a un método independiente `operar()`, separando la lógica matemática de la lógica de interacción con el usuario.
- Uso de `switch` sobre un `String` para determinar qué operación aritmética ejecutar según el operador ingresado.
- Validación explícita de división por cero, lanzando una `ArithmeticException` con un mensaje descriptivo.
- Cláusula `default` dentro del `switch` que lanza una `IllegalArgumentException` cuando el operador no es reconocido.
- Manejo de múltiples excepciones específicas mediante varios bloques `catch`, cada uno atendiendo un tipo de error distinto.
- Uso de `finally` para ejecutar código que debe correr siempre, sin importar si hubo error o no.
- Separación de responsabilidades: `main` se encarga de la interacción con el usuario y el control del flujo, mientras que `operar()` concentra la lógica de cálculo.

## 🧩 Estructuras utilizadas

| Tipo | Sintaxis | Descripción |
|------|----------|-------------|
| Bucle do-while | `do { ... } while (condicion);` | Ejecuta el bloque al menos una vez y repite mientras la condición sea verdadera. |
| Lectura de consola | `sc.nextLine()` | Lee una línea de texto ingresada por el usuario. |
| Parseo numérico | `Double.parseDouble(texto)` | Convierte un `String` a `double`, lanzando `NumberFormatException` si no es válido. |
| Switch sobre String | `switch (op) { case "+": ... }` | Ejecuta un bloque de código distinto según el valor de texto evaluado. |
| Excepción personalizada | `throw new ArithmeticException("mensaje");` | Lanza manualmente una excepción con un mensaje descriptivo. |
| Cláusula default | `default: throw new IllegalArgumentException(...);` | Maneja de forma explícita valores no contemplados por los `case` anteriores. |
| Try-catch múltiple | `catch (TipoException e) { ... }` | Captura y maneja distintos tipos de error de forma independiente. |
| Finally | `finally { ... }` | Ejecuta un bloque de código siempre, ocurra o no una excepción. |
| package/import | `package ui;` / `import java.util.Scanner;` | Organiza el código en módulos y permite reutilizar clases de otros paquetes. |

## 📂 Estructura del proyecto

```
proyecto/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── ui/
│   │           └── Main.java         # Clase principal: lee datos, controla el bucle y muestra resultados
│   └── test/
├── .gitignore
└── pom.xml
```

## ▶️ Funcionamiento

Al ejecutar el programa se realizan las siguientes acciones:

1. Se muestra un mensaje de bienvenida y se inicia el bucle `do-while`, que se ejecutará al menos una vez.
2. Se solicita el primer número y se convierte de `String` a `double` mediante `Double.parseDouble()`.
3. Se solicita el operador como `String` (`+`, `-`, `*`, `/`) y luego el segundo número.
4. Se invoca el método `operar()`, que mediante un `switch` decide qué operación matemática ejecutar según el operador recibido.
5. Si el operador es `/` y el segundo número es `0`, se lanza una `ArithmeticException` antes de realizar la división.
6. Si el operador no coincide con ningún `case`, el `default` lanza una `IllegalArgumentException` indicando que no fue reconocido.
7. Cualquier error de conversión numérica es capturado por `NumberFormatException`, y los errores de operación por los `catch` correspondientes, mostrando un mensaje claro sin detener el programa.
8. El bloque `finally` se ejecuta siempre, haya ocurrido un error o no, imprimiendo "-- Calculo finalizado --".
9. Finalmente, se pregunta al usuario si desea repetir el proceso; el bucle continúa mientras la respuesta sea "s" o "S".

`Main` concentra toda la interacción con el usuario y el control del flujo del programa, mientras que `operar()` encapsula la lógica matemática pura: recibe dos números y un operador, y devuelve un resultado o lanza una excepción si algo no es válido. No hay separación en distintas clases o paquetes como `model`/`ui`; toda la lógica vive en una sola clase, pero se mantiene igualmente una diferencia clara de responsabilidades: leer/validar entrada, decidir la operación, y comunicar el resultado o el error.
