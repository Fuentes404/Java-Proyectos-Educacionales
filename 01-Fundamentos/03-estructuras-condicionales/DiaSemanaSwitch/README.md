  # Dia Semana con Switch - Condicionales en Java

Ejercicio en Java que muestra el uso de la estructura condicional `switch`, aplicada a la validación de un día de la semana ingresado por el usuario.

## 📋 Descripción

Este proyecto es un ejercicio introductorio en Java que cubre:
- Lectura de datos ingresados por el usuario mediante `Scanner`.
- Evaluación de condiciones múltiples y excluyentes con `switch`.
- Agrupación de casos mediante fall-through (ausencia de `break`).
- Uso de `default` para el manejo de valores no contemplados.
- Validación de datos numéricos ingresados por consola.

## 🧩 Estructuras utilizadas

| Tipo | Sintaxis | Descripción |
|---|---|---|
| `switch` | `switch (variable) { case valor: ... }` | Evalúa una variable y ejecuta el bloque correspondiente al valor que coincida |
| `case` | `case valor:` | Define un valor posible para la variable evaluada |
| Fall-through | `case 1: case 2: ...` | Permite que varios `case` compartan el mismo bloque de código al omitir `break` |
| `default` | `default: ... break;` | Se ejecuta cuando ningún `case` coincide con el valor evaluado |
| `break` | `break;` | Detiene la ejecución del `switch` para evitar que continúe con el siguiente caso |

## 📂 Estructura del proyecto

```
Condicionales/
├── .idea/                          # Configuración local de IntelliJ 
├── .mvn/                           # Maven Wrapper
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── ui/
│   │   │       └── Main.java       # Clase principal con la lógica de validación de días
│   │   └── resources/              # Recursos del proyecto
│   └── test/                       # Pruebas unitarias
├── target/                         # Archivos generados por Maven
├── .gitignore
└── pom.xml                         # Configuración de dependencias y build (Maven)
```
