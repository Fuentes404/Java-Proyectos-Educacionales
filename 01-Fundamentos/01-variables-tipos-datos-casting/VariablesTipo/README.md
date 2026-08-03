
# Variables, Tipos de Datos y Casting

Ejercicio en Java que muestra el uso de variables con distintos tipos de datos primitivos y ejemplos de **casting** (conversión de tipos) entre ellos.

## 📋 Descripción

Este proyecto es un ejercicio introductorio en Java que cubre:

- Declaración de variables con distintos tipos primitivos.
- Impresión de valores por consola.
- Conversión de tipos (casting) **implícita** y **explícita**.

## 🧩 Tipos de datos utilizados

| Variable | Tipo | Descripción |
|---|---|---|
| `nombre` | `String` | Almacena texto |
| `edad` | `int` | Almacena un número entero |
| `altura` | `double` | Almacena un número decimal de alta precisión |
| `estudiante` | `boolean` | Almacena un valor lógico (`true`/`false`) |
| `inicial` | `char` | Almacena un solo carácter |
| `poblacionMundial` | `long` | Almacena un número entero muy grande |
| `peso` | `float` | Almacena un número decimal de menor precisión |

## 🔄 Casting

- **Implícito (automático):** conversión de `int` a `double`, sin pérdida de datos.
- **Explícito (manual):** conversión de `double` a `int` usando `(int)`, con pérdida de la parte decimal.

## 📂 Estructura del proyecto

```
VariablesTipo/
├── .idea/                          # Configuración local de IntelliJ (no se sube a git)
├── .mvn/                           # Maven Wrapper
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── ui/
│   │   │       └── Main.java       # Clase principal con variables, tipos y casting
│   │   └── resources/              # Recursos del proyecto
│   └── test/                       # Pruebas unitarias
├── target/                         # Archivos generados por Maven (no se sube a git)
├── .gitignore
└── pom.xml                         # Configuración de dependencias y build (Maven)
```


