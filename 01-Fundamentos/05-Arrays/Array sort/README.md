
# Ordenamiento de Arrays con Arrays.sort()
Ejercicio en Java que muestra el ordenamiento de un array unidimensional de números enteros utilizando el método `sort()` de la clase `Arrays`.
## 📋 Descripción
Este proyecto es un ejercicio introductorio en Java que cubre:
- Declaración y creación de un array de tipo `int`.
- Uso de la clase utilitaria `Arrays` de `java.util`.
- Ordenamiento ascendente de un array mediante `Arrays.sort()`.
- Conversión de un array a texto legible mediante `Arrays.toString()`.
- Impresión del resultado por consola.
## 🧩 Estructuras utilizadas
| Tipo | Sintaxis | Descripción |
|---|---|---|
| `Array unidimensional` | `tipo[] nombre = {valor1, valor2, ...};` | Permite almacenar una colección de valores del mismo tipo en una sola fila. |
| `Arrays.sort()` | `Arrays.sort(array);` | Ordena los elementos del array de forma ascendente, modificando el array original (ordenamiento in-place). |
| `Arrays.toString()` | `Arrays.toString(array)` | Convierte el array en un `String` legible con formato `[valor1, valor2, ...]` para poder imprimirlo. |
## 📂 Estructura del proyecto
```
OrdenarArrays/
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
1. Se crea un array de tipo `int` con seis valores desordenados: `{5, 2, 9, 1, 8, 7}`.
2. Se ordena el array utilizando `Arrays.sort(numeros)`, el cual organiza los elementos de menor a mayor directamente sobre el array original.
3. Se convierte el array ordenado a texto mediante `Arrays.toString(numeros)`.
4. Se imprime el resultado por consola, mostrando el array ya ordenado: `[1, 2, 5, 7, 8, 9]`.

Este ejercicio permite comprender el uso del método `sort()` de la clase `Arrays` como una herramienta rápida y directa para ordenar arreglos de tipos primitivos, sin necesidad de implementar manualmente un algoritmo de ordenamiento.
