# Atributos y Constructores

Ejercicio en Java que muestra la definición de una clase, la creación de objetos a partir de ella
y el manejo del estado independiente de cada instancia, incluyendo el uso de constructores por defecto
y parametrizados.

## 📋 Descripción

Este proyecto es un ejercicio introductorio en Java que cubre:
- Definición de una clase con atributos y métodos.
- Organización del código mediante `package`.
- Creación de objetos utilizando el operador `new`.
- Definición de un constructor por defecto y un constructor parametrizado.
- Reutilización de constructores mediante `this()`.
- Acceso y modificación de atributos de un objeto.
- Invocación de métodos sobre un objeto.
- Comprobación de que cada objeto mantiene su propio estado en memoria, independiente de otros objetos de la misma clase.

## 🧩 Estructuras utilizadas

| Tipo | Sintaxis | Descripción |
|---|---|---|
| `Clase` | `public class Nombre { ... }` | Define el molde con atributos y métodos que tendrán los objetos creados a partir de ella. |
| `Atributo` | `public tipo nombre = valor;` | Almacena el estado (datos) de cada objeto. |
| `Objeto` | `Nombre variable = new Nombre();` | Crea una instancia concreta de la clase en memoria. |
| `Constructor por defecto` | `public Nombre() { ... }` | Inicializa el objeto con valores predeterminados cuando no se reciben parámetros. |
| `Constructor parametrizado` | `public Nombre(tipo p1, ...) { ... }` | Inicializa el objeto con valores recibidos desde afuera. |
| `this()` | `this(valor1, valor2, ...);` | Reutiliza otro constructor de la misma clase para evitar duplicar código. |
| `this` | `this.atributo = valor;` | Referencia al objeto actual, usada para diferenciar el atributo del parámetro. |
| `Método` | `public void nombre() { ... }` | Define el comportamiento que puede ejecutar un objeto. |
| `package` / `import` | `package model;` / `import model.Clase;` | Organiza las clases en paquetes y permite utilizarlas desde otros archivos. |

## 📂 Estructura del proyecto

```
002-clases-objetos-constructores/
├── .idea/                          # Configuración local de IntelliJ
├── .mvn/                           # Maven Wrapper
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── model/
│   │   │   │   └── Persona.java    # Clase que define atributos, constructores y métodos
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
1. Se crea un objeto `persona1` de tipo `Persona` utilizando el constructor por defecto, el cual asigna internamente los valores `"Carlos Palma"`, `25` y `"Asistente"` mediante `this()`.
2. Se invocan los métodos `saludar()` y `mostrarInformacion()` sobre `persona1`.
3. Se modifican los atributos de `persona1` (`nombre`, `edad`, `cargo`) de forma directa, ya que son `public`.
4. Se vuelve a mostrar la información de `persona1`, evidenciando el cambio de estado.
5. Se crea un segundo objeto `persona2` de tipo `Persona` utilizando el constructor por defecto, comprobando que mantiene los valores predeterminados y no se ve afectado por los cambios realizados en `persona1`.
6. Se crea un tercer objeto `persona3` de tipo `Persona` utilizando el constructor parametrizado, pasando directamente los valores `"Luis Fernández"`, `40` y `"Director"`, evitando así asignar los atributos uno por uno.

Este ejercicio permite comprender la diferencia entre una clase y un objeto: la clase es una única definición,
mientras que cada objeto creado a partir de ella posee su propio espacio en memoria y su propio estado,
independiente del resto de las instancias. Además, muestra cómo los constructores facilitan la creación de
objetos, ya sea con valores predeterminados o con valores personalizados definidos al momento de la instanciación.
