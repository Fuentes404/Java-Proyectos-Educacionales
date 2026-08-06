# Arrays Unidimensionales 

Ejercicio en Java que muestra la creación, asignación y recorrido de arreglos (`arrays`) utilizando acceso por índice,
ciclo `for` y ciclo `for-each`.

## 📋 Descripción

Este proyecto es un ejercicio introductorio en Java que cubre:
- Declaración y creación de arreglos de tipo `int`.
- Asignación de valores a cada posición del arreglo.
- Acceso a los elementos mediante su índice.
- Recorrido de un arreglo utilizando un ciclo `for`.
- Recorrido de un arreglo utilizando un ciclo `for-each`.
- Comparación de las distintas formas de mostrar el contenido de un arreglo.

## 🧩 Estructuras utilizadas

| Tipo | Sintaxis | Descripción |
|---|---|---|
| `Array` | `tipo[] nombre = new tipo[tamaño];` | Permite almacenar varios valores del mismo tipo en una sola estructura de datos. |
| `Índice` | `array[posición]` | Permite acceder o modificar un elemento específico dentro del arreglo. |
| `for` | `for (inicio; condición; incremento) { ... }` | Recorre el arreglo utilizando índices para acceder a cada elemento. |
| `for-each` | `for (tipo elemento : arreglo) { ... }` | Recorre todos los elementos del arreglo sin necesidad de utilizar índices. |

## 📂 Estructura del proyecto

```
ArraysUnidimensional/
├── .idea/                          # Configuración local de IntelliJ
├── .mvn/                           # Maven Wrapper
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── ui/
│   │   │       └── Main.java       # Clase principal
│   │   └── resources/              # Recursos del proyecto
│   └── test/                       # Pruebas unitarias
├── target/                         # Archivos generados por Maven
├── .gitignore
└── pom.xml                         # Configuración de dependencias y build (Maven)
```

## ▶️ Funcionamiento

Al ejecutar el programa se realizan las siguientes acciones:

1. Se crean dos arreglos de tipo `int`, uno para almacenar números pares y otro para almacenar números impares.
2. Se asignan manualmente tres valores a cada arreglo.
3. Se muestran los elementos de ambos arreglos accediendo directamente a cada índice.
4. Se recorren los arreglos utilizando un ciclo `for`, mostrando cada elemento mediante su posición.
5. Finalmente, se recorren nuevamente los arreglos utilizando un ciclo `for-each`, mostrando cada valor sin utilizar índices.

Este ejercicio permite comparar las diferentes formas de acceder y recorrer un arreglo en Java, comprendiendo cuándo resulta
conveniente utilizar índices y cuándo es preferible emplear un recorrido simplificado mediante `for-each`.
