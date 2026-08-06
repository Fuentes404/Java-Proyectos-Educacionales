# Arrays Bidimensionales

Ejercicio en Java que muestra la creación, asignación y recorrido de matrices (`arrays bidimensionales`) utilizando acceso por índice, ciclo `for` anidado y ciclo `for-each` anidado.

## 📋 Descripción

Este proyecto es un ejercicio introductorio en Java que cubre:

- Declaración y creación de matrices de tipo `int` (arreglos bidimensionales).
- Asignación de valores a cada posición de la matriz mediante fila y columna.
- Acceso a los elementos mediante sus índices de fila y columna.
- Recorrido de una matriz utilizando un ciclo `for` anidado.
- Recorrido de una matriz utilizando un ciclo `for-each` anidado.
- Comparación de las distintas formas de mostrar el contenido de una matriz.

## 🧩 Estructuras utilizadas

| Tipo | Sintaxis | Descripción |
|---|---|---|
| `Array bidimensional` | `tipo[][] nombre = new tipo[filas][columnas];` | Permite almacenar valores del mismo tipo organizados en filas y columnas, formando una matriz. |
| `Índice` | `array[fila][columna]` | Permite acceder o modificar un elemento específico dentro de la matriz. |
| `for anidado` | `for (...) { for (...) { ... } }` | Recorre la matriz utilizando índices de fila y columna para acceder a cada elemento. |
| `for-each anidado` | `for (tipo[] fila : matriz) { for (tipo elemento : fila) { ... } }` | Recorre todos los elementos de la matriz sin necesidad de utilizar índices. |

## 📂 Estructura del proyecto
```
ArraysMultidimensionales/
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

1. Se crean dos matrices de tipo `int` de tamaño 3x3: una para almacenar notas de 3 estudiantes (cada uno con 3 notas) y otra para almacenar temperaturas registradas durante 3 días (con 3 mediciones por día).
2. Se asignan manualmente los valores de cada matriz indicando fila y columna (`matriz[fila][columna]`).
3. Se muestran algunos elementos específicos accediendo directamente a su fila y columna.
4. Se recorre la matriz de notas utilizando un ciclo `for` anidado, mostrando cada elemento mediante sus índices de fila y columna.
5. Se recorre la matriz de temperaturas utilizando un ciclo `for` anidado, de la misma forma.
6. Finalmente, se recorren nuevamente ambas matrices (notas y temperaturas) utilizando un ciclo `for-each` anidado, mostrando cada valor sin utilizar índices.

Este ejercicio permite comparar las diferentes formas de acceder y recorrer una matriz en Java, comprendiendo cuándo resulta conveniente utilizar índices y cuándo es preferible emplear un recorrido simplificado mediante `for-each`.
