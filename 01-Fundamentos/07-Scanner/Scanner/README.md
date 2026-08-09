
# Entrada de Datos por Consola - Scanner y Lectura de Tipos Primitivos - Manejo de Entrada/Salida

Este ejercicio demuestra la **lectura de datos por consola** utilizando la clase `Scanner`, combinando la captura de distintos tipos primitivos (`int`, `double`) con cadenas de texto (`String`). Se ilustra además el problema clásico del **buffer de línea pendiente** al alternar entre métodos de lectura numérica y textual. La clase principal `Main` concentra toda la lógica de entrada, procesamiento y salida de datos.

## 📋 Descripción

- Uso de la clase `Scanner` del paquete `java.util` para leer datos desde `System.in`.
- Lectura de cadenas de texto completas mediante `nextLine()`.
- Lectura de valores numéricos enteros mediante `nextInt()`.
- Lectura de valores numéricos decimales mediante `nextDouble()`.
- Manejo del **salto de línea pendiente** (buffer) al combinar `nextInt()`/`nextDouble()` con `nextLine()`.
- Concatenación de variables de distintos tipos en una salida formateada con `System.out.println`.
- Buenas prácticas de **liberación de recursos** mediante `scanner.close()`.
- Organización del flujo del programa dentro del método `main` como único punto de entrada.

## 🧩 Estructuras utilizadas

| Tipo | Sintaxis | Descripción |
|------|----------|-------------|
| Importación | `import java.util.Scanner;` | Incorpora la clase `Scanner` al archivo para poder utilizarla. |
| Instanciación de objeto | `Scanner nombre = new Scanner(System.in);` | Crea un objeto `Scanner` asociado a la entrada estándar del sistema. |
| Lectura de texto | `String var = scanner.nextLine();` | Lee una línea completa de texto ingresada por el usuario. |
| Lectura de entero | `int var = scanner.nextInt();` | Lee y convierte la entrada del usuario a un valor `int`. |
| Lectura de decimal | `double var = scanner.nextDouble();` | Lee y convierte la entrada del usuario a un valor `double`. |
| Limpieza de buffer | `scanner.nextLine();` (sin asignar) | Consume el salto de línea pendiente tras leer un número, evitando lecturas vacías posteriores. |
| Concatenación | `"texto" + variable` | Combina cadenas literales con el valor de una variable para formar la salida. |
| Cierre de recurso | `scanner.close();` | Libera el recurso asociado al flujo de entrada al finalizar su uso. |
| Punto de entrada | `public static void main(String[] args) { ... }` | Método principal donde se ejecuta todo el flujo del programa. |

## 📂 Estructura del proyecto

```
scanner-entrada-consola/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── Main.java        # Clase única que solicita, lee y muestra los datos ingresados por consola
│   └── test/
│       └── java/                # Carpeta reservada para pruebas unitarias (sin casos en este ejercicio)
├── .gitignore                   # Excluye archivos generados por el build y el IDE
└── pom.xml                      # Configuración del proyecto Maven
```

## ▶️ Funcionamiento

**Captura de datos del usuario**

1. Se crea una instancia de `Scanner` vinculada a `System.in`, habilitando la lectura desde teclado.
2. Se solicita el nombre del usuario y se lee con `nextLine()`, capturando la cadena completa ingresada.
3. Se solicita la edad y se lee con `nextInt()`, que interpreta la entrada como un número entero.
4. Se solicita la estatura y se lee con `nextDouble()`, que interpreta la entrada como un número decimal.

**Manejo del buffer y lectura final**

5. Se invoca `scanner.nextLine()` sin asignar el resultado a ninguna variable, con el único fin de descartar el salto de línea que quedó pendiente después de `nextDouble()`.
6. Se solicita la ciudad y se lee con `nextLine()`, ahora capturando correctamente el texto ingresado gracias al paso anterior.

**Salida de resultados**

7. Se imprimen en consola, mediante `System.out.println`, todos los valores capturados, concatenando texto literal con el contenido de cada variable.
8. Finalmente se llama a `scanner.close()`, liberando el recurso de entrada y dando por terminado el ciclo de lectura del programa.

Este ejercicio ilustra un principio fundamental al trabajar con entrada de datos en Java: los métodos de lectura numérica (`nextInt()`, `nextDouble()`) y el método de lectura de texto (`nextLine()`) no consumen el buffer de la misma manera, por lo que alternarlos sin control produce resultados inesperados. La clase `Main`, aunque simple, ejemplifica cómo un manejo cuidadoso del objeto `Scanner` es tan importante como la lógica de negocio misma para garantizar una interacción confiable entre el programa y el usuario.
