
# Ejemplo do-while, switch y arquitectura en capas - Registro de Estudiantes en Java

Este ejercicio combina el uso de un bucle **`do-while`** para controlar un menú interactivo por consola, con un **`switch`** que encapsula la lógica de decisión de cada opción, y una **arquitectura en capas** (`ui`, `services`, `model`) que separa la interacción con el usuario, la lógica de negocio y la representación de los datos.

## 📋 Descripción

- Uso de `Scanner` para leer datos ingresados por consola (`nextLine()`).
- Bucle `do-while` que garantiza al menos una ejecución del menú y lo repite mientras la opción ingresada sea distinta de `0`.
- Conversión de texto a número mediante `Integer.parseInt()`, tanto para la opción del menú como para la edad del estudiante.
- Uso de `switch` sobre un `int` para determinar qué acción ejecutar según la opción elegida por el usuario.
- Delegación de la lógica de negocio a la clase `GestorEstudiantes`, separando la interacción con el usuario del manejo de los datos.
- Uso de un `ArrayList<Estudiante>` como contenedor en memoria para almacenar el registro de estudiantes.
- Clase de modelo `Estudiante` con atributos privados, constructor, getters/setters y un método `mostrarInfo()` para mostrar sus datos.
- Búsqueda de estudiantes por nombre mediante `equalsIgnoreCase()` para permitir la eliminación de un registro.
- Separación de responsabilidades: `Main` se encarga de la interacción con el usuario y el control del flujo, `GestorEstudiantes` concentra la lógica de negocio (crear, eliminar, listar), y `Estudiante` representa los datos de cada estudiante.

## 🧩 Estructuras utilizadas

| Tipo | Sintaxis | Descripción |
|------|----------|-------------|
| Bucle do-while | `do { ... } while (opcion != 0);` | Ejecuta el menú al menos una vez y lo repite mientras el usuario no elija salir. |
| Lectura de consola | `sc.nextLine()` | Lee una línea de texto ingresada por el usuario. |
| Parseo numérico | `Integer.parseInt(texto)` | Convierte un `String` a `int`, usado para la opción del menú y la edad. |
| Switch sobre int | `switch (opcion) { case 1: ... }` | Ejecuta un bloque de código distinto según la opción numérica elegida. |
| Cláusula default | `default: System.out.println(...);` | Maneja de forma explícita cualquier opción no contemplada por los `case` anteriores. |
| Colección dinámica | `ArrayList<Estudiante>` | Almacena en memoria la lista de estudiantes registrados. |
| Búsqueda con for-each | `for (Estudiante e : registro) { ... }` | Recorre la colección para buscar, eliminar o mostrar estudiantes. |
| package/import | `package model;` / `import services.GestorEstudiantes;` | Organiza el código en módulos y permite reutilizar clases de otros paquetes. |

## 📂 Estructura del proyecto

```
proyecto/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── ui/
│   │       │   └── Main.java                  # Clase principal: menú, lectura de datos y control del flujo
│   │       ├── services/
│   │       │   └── GestorEstudiantes.java      # Lógica de negocio: crear, eliminar y listar estudiantes
│   │       └── model/
│   │           └── Estudiante.java             # Clase de datos: atributos, getters/setters y mostrarInfo()
│   └── test/
├── .gitignore
└── pom.xml
```

## ▶️ Funcionamiento

Al ejecutar el programa se realizan las siguientes acciones:

1. Se muestra el menú principal y se inicia el bucle `do-while`, que se ejecutará al menos una vez.
2. Se solicita al usuario que ingrese una opción, la cual se convierte de `String` a `int` mediante `Integer.parseInt()`.
3. Un `switch` evalúa la opción ingresada y ejecuta la acción correspondiente:
   - **Opción 1:** solicita nombre, edad, curso y colegio, y llama a `gestor.crearEstudiante()` para agregar un nuevo `Estudiante` al registro.
   - **Opción 2:** solicita el nombre del estudiante a eliminar y llama a `gestor.eliminarEstudiante()`, que busca una coincidencia (ignorando mayúsculas/minúsculas) y lo remueve del `ArrayList` si lo encuentra.
   - **Opción 3:** llama a `gestor.verEstudiantes()`, que recorre el registro y muestra la información de cada estudiante mediante `mostrarInfo()`, o un mensaje si no hay estudiantes registrados.
   - **Opción 0:** muestra un mensaje de despedida y finaliza el bucle.
   - **Cualquier otra opción:** el `default` del `switch` informa que la opción ingresada es inválida.
4. El bucle continúa repitiendo el menú hasta que el usuario ingresa `0` para salir.

`Main` concentra toda la interacción con el usuario y el control del flujo del programa, `GestorEstudiantes` encapsula la lógica de negocio pura (crear, buscar, eliminar y listar estudiantes sobre el `ArrayList`), y `Estudiante` representa el modelo de datos con sus atributos y comportamiento propio (`mostrarInfo()`). Esta separación en tres paquetes (`ui`, `services`, `model`) permite mantener el código organizado y facilita su mantenimiento y escalabilidad.
