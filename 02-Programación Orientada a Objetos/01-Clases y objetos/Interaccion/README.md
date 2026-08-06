
# Clases y Objetos
Ejercicio en Java que muestra la definición de una clase, la creación de objetos a partir de ella
y el manejo del estado independiente de cada instancia.

## 📋 Descripción
Este proyecto es un ejercicio introductorio en Java que cubre:
- Definición de una clase con atributos y métodos.
- Organización del código mediante `package`.
- Creación de objetos utilizando el operador `new`.
- Acceso y modificación de atributos de un objeto.
- Invocación de métodos sobre un objeto.
- Comprobación de que cada objeto mantiene su propio estado en memoria, independiente de otros objetos de la misma clase.

## 🧩 Estructuras utilizadas
| Tipo | Sintaxis | Descripción |
|---|---|---|
| `Clase` | `public class Nombre { ... }` | Define el molde con atributos y métodos que tendrán los objetos creados a partir de ella. |
| `Atributo` | `public tipo nombre = valor;` | Almacena el estado (datos) de cada objeto. |
| `Objeto` | `Nombre variable = new Nombre();` | Crea una instancia concreta de la clase en memoria. |
| `Método` | `public void nombre() { ... }` | Define el comportamiento que puede ejecutar un objeto. |
| `package` / `import` | `package model;` / `import model.Clase;` | Organiza las clases en paquetes y permite utilizarlas desde otros archivos. |

## 📂 Estructura del proyecto+

```
001-clases-objetos/
├── .idea/                          # Configuración local de IntelliJ
├── .mvn/                           # Maven Wrapper
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── model/
│   │   │   │   └── Persona.java    # Clase que define atributos y métodos
│   │   │   └── Main.java           # Clase principal
│   │   └── resources/              # Recursos del proyecto
│   └── test/                       # Pruebas unitarias
├── target/                         # Archivos generados por Maven
├── .gitignore
└── pom.xml                         # Configuración de dependencias y build (Maven)
```

## ▶️ Funcionamiento
Al ejecutar el programa se realizan las siguientes acciones:
1. Se crea un objeto `persona1` de tipo `Persona`, el cual nace con los valores por defecto definidos en la clase.
2. Se invocan los métodos `saludar()` y `mostrarInformacion()` sobre `persona1`.
3. Se modifican los atributos de `persona1` (`nombre`, `edad`, `cargo`) de forma directa, ya que son `public`.
4. Se vuelve a mostrar la información de `persona1`, evidenciando el cambio de estado.
5. Se crea un segundo objeto `persona2` de tipo `Persona` y se muestra su información, comprobando que mantiene los valores por defecto y no se ve afectado por los cambios realizados en `persona1`.

Este ejercicio permite comprender la diferencia entre una clase y un objeto: la clase es una única definición,
mientras que cada objeto creado a partir de ella posee su propio espacio en memoria y su propio estado,
independiente del resto de las instancias.
