# Menú Combinado - Estructuras de Repetición en Java

Ejercicio en Java que muestra el uso de las estructuras de repetición `for`, `while`, `do-while` y `for-each`, integradas en un menú interactivo por consola.

## 📋 Descripción

Este proyecto es un ejercicio introductorio en Java que cubre:
- Lectura de datos ingresados por el usuario mediante `Scanner`.
- Construcción de un menú persistente con `do-while`.
- Repetición de acciones con número fijo de iteraciones usando `for`.
- Repetición controlada por condición, sin número fijo de iteraciones, usando `while`.
- Recorrido de un array sin uso de índices mediante `for-each`.
- Combinación de las estructuras dentro de un `switch` para separar cada caso de uso.

## 🧩 Estructuras utilizadas

| Tipo | Sintaxis | Descripción |
|---|---|---|
| `do-while` | `do { ... } while (condición);` | Ejecuta el bloque al menos una vez y repite mientras la condición sea verdadera. Usado para mantener el menú activo |
| `for` | `for (inicio; condición; incremento) { ... }` | Repite un número conocido de veces. Usado para generar la tabla de multiplicar |
| `while` | `while (condición) { ... }` | Repite mientras se cumpla una condición, sin número fijo de iteraciones. Usado para validar la entrada del usuario |
| `for-each` | `for (tipo elemento : coleccion) { ... }` | Recorre todos los elementos de un array o colección sin usar índices. Usado para mostrar los valores del array |
| `switch` | `switch (variable) { case valor: ... }` | Dirige la ejecución hacia la opción elegida por el usuario en el menú |

## 📂 Estructura del proyecto

```
Condicionales/
├── .idea/                          # Configuración local de IntelliJ 
├── .mvn/                           # Maven Wrapper
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── ui/
│   │   │       └── Menu.java       # Clase principal 
│   │   └── resources/              # Recursos del proyecto
│   └── test/                       # Pruebas unitarias
├── target/                         # Archivos generados por Maven
├── .gitignore
└── pom.xml                         # Configuración de dependencias y build (Maven)
```

## ▶️ Funcionamiento

Al ejecutar el programa se muestra un menú con las siguientes opciones:

1. **Tabla de multiplicar** – el usuario ingresa un número y se imprime su tabla del 1 al 10 (`for`).
2. **Adivina el número / valida entrada** – el usuario repite el ingreso de datos hasta cumplir la condición esperada (`while`).
3. **Mostrar array** – se recorren e imprimen los elementos de un array predefinido (`for-each`).
4. **Salir** – finaliza la ejecución del programa.

El menú se repite automáticamente después de cada opción hasta que el usuario elige salir, gracias al `do-while` que envuelve
toda la lógica.


