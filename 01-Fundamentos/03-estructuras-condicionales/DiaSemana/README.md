# Condicionales en Java

Ejercicio en Java que muestra el uso de los distintos tipos de estructuras condicionales del lenguaje: `if`, `if-else` e `if-else if`, aplicados a la validación de un día de la semana ingresado por el usuario.
 
## 📋 Descripción

Este proyecto es un ejercicio introductorio en Java que cubre:
- Lectura de datos ingresados por el usuario mediante `Scanner`.
- Evaluación de condiciones simples con `if`.
- Evaluación de condiciones múltiples y excluyentes con `if - else if - else`.
- Combinación de condiciones mediante operadores lógicos y relacionales.
- Validación de datos numéricos ingresados por consola.

## 🧩 Estructuras utilizadas

| Tipo | Sintaxis | Descripción |
|---|---|---|
| `if` | `if (condicion) { }` | Ejecuta un bloque de código solo si la condición es verdadera |
| `if - else` | `if (condicion) { } else { }` | Ejecuta un bloque u otro según si la condición es verdadera o falsa |
| `if - else if - else` | `if () { } else if () { } else { }` | Evalúa múltiples condiciones en orden hasta encontrar una verdadera |
| Relacionales | `>=` `<=` `==` | Comparan dos valores y devuelven un `boolean` |
| Lógicos | `&&` `\|\|` | Combinan condiciones booleanas |

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
