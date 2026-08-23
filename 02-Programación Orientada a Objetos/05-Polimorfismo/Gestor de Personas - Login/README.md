
# Gesstion de personas - Login Herencia, Polimorfismo y Sobrescritura de Métodos

Ejercicio en Java que demuestra el uso de polimorfismo mediante una clase base `Persona` y dos
clases derivadas: `Estudiante` y `Profesor`. Ambas subclases heredan los atributos comunes de `Persona`,
pero cada una sobrescribe el método `mostrarInfo()`para mostrar su propia información. Además, se incorpora
una clase de servicio (`GestorPersonas`) que realiza la gestion a trevez del polimorfismo de las entidades creadas .

## 📋 Descripción

Este proyecto es un ejercicio en Java que cubre:
- Definición de una clase base (`Persona`) con atributos privados, un atributo `protected` (`rol`) y encapsulamiento.
- Organización del código mediante `package` (`model`, `service`, `main`).
- Aplicación del principio de herencia utilizando la palabra clave `extends`.
- Uso de `super()` para invocar el constructor de la clase padre desde las clases hijas, fijando el `rol` según el tipo de subclase.
- Creación de clases derivadas (`Estudiante` y `Profesor`) que agregan atributos propios (`grado` y `asignatura`).
- **Polimorfismo**: uso de una `List<Persona>` para almacenar objetos de distintas subclases sin conocer su tipo concreto.
- **Sobrescritura de métodos** (`@Override`) del método `mostrarInfo()` en cada clase hija, con comportamiento propio.
- Separación de responsabilidades mediante una clase de servicio (`GestorPersonas`) que encapsula la lógica de creación y almacenamiento.
- Definición de métodos `getters` y `setters` propios de cada clase.
- Interacción por consola con `Scanner` a través de un menú (`Main`).

## 🧩 Estructuras utilizadas

| Tipo | Sintaxis | Descripción |
|---|---|---|
| `Clase` | `public class Nombre { ... }` | Define el molde con atributos y métodos que tendrán los objetos creados a partir de ella. |
| `Herencia` | `public class Hija extends Padre { ... }` | Permite que una clase hija herede atributos y métodos de una clase padre. |
| `Atributo privado` | `private tipo nombre;` | Almacena el estado (datos) del objeto, oculto y protegido del acceso externo directo. |
| `Atributo protegido` | `protected tipo rol;` | Visible para la clase y sus subclases, pero no desde fuera del paquete/jerarquía. |
| `Colección polimórfica` | `List<Persona> personas = new ArrayList<>();` | Lista de tipo padre capaz de almacenar objetos de cualquier clase hija. |
| `Constructor parametrizado` | `public Nombre(tipo p1, ...) { ... }` | Inicializa el objeto con valores recibidos desde afuera. |
| `super()` | `super(p1, p2, ...);` | Invoca el constructor de la clase padre desde el constructor de la clase hija. |
| `this` | `this.atributo = valor;` | Referencia al objeto actual, usada para diferenciar el atributo del parámetro. |
| `Getter` | `public tipo getAtributo() { return atributo; }` | Permite leer el valor de un atributo privado desde fuera de la clase. |
| `Setter` | `public void setAtributo(tipo valor) { this.atributo = valor; }` | Permite modificar el valor de un atributo privado desde fuera de la clase, de forma controlada. |
| `@Override` | `@Override public void metodo() { ... }` | Indica que un método sobrescribe la implementación heredada de la clase padre. |
| `Polimorfismo` | `p.mostrarInfo();` | Al invocar el método sobre una referencia `Persona`, se ejecuta la versión sobrescrita según el tipo real del objeto. |
| `Clase de servicio` | `public class Gestor { ... }` | Centraliza la lógica de negocio (crear, guardar, listar) separada del modelo y de la interfaz. |
| `package` / `import` | `package model;` / `import model.Clase;` | Organiza las clases en paquetes y permite utilizarlas desde otros archivos. |

## 📂 Estructura del proyecto

```
005-polimorfismo-persona-estudiante-profesor/
├── src/
│   ├── model/
│   │   ├── Persona.java               # Clase base con atributos privados, rol protegido, constructor, getters, setters y mostrarInfo()
│   │   ├── Estudiante.java            # Clase hija que extiende Persona, agrega grado y sobrescribe mostrarInfo()
│   │   └── Profesor.java              # Clase hija que extiende Persona, agrega asignatura y sobrescribe mostrarInfo()
│   ├── service/
│   │   └── GestorPersonas.java        # Gestion de Entidades: Crea, almacena en <Arraylist> y muestra todas las personas
│   └── main/
│       └── Main.java                  # Menú por consola (Scanner) que interactúa con GestorPersonas
├── .gitignore
└── README.md
```

## ▶️ Funcionamiento

Al ejecutar el programa se realizan las siguientes acciones:
1. Se muestra un menú por consola con las opciones: crear estudiante, crear profesor, mostrar todas las personas y salir.
2. Al crear un `Estudiante` o un `Profesor`, `Main` delega la creación en `GestorPersonas`, que instancia el objeto correspondiente y lo agrega a una `List<Persona>` interna.
3. El `rol` de cada persona no lo decide quien la crea: cada subclase lo fija internamente mediante `super()` (`"Usuario"` para `Estudiante`, `"Admin"` para `Profesor`).
4. Al elegir "Mostrar todas las personas", `GestorPersonas.mostrarTodas()` recorre la lista con un `for (Persona p : personas)` e invoca `p.mostrarInfo()` sobre cada elemento.
5. Aunque la variable de recorrido `p` es de tipo `Persona`, la llamada `p.mostrarInfo()` ejecuta la versión sobrescrita (`@Override`) definida en la subclase real del objeto (`Estudiante` o `Profesor`), demostrando el comportamiento polimórfico.

Este ejercicio permite comprender el principio de polimorfismo , un mismo mensaje `mostrarInfo()`
enviado a través de una referencia de tipo padre (`Persona`) produce respuestas distintas según el
tipo de objeto. Cada subclase reutiliza los atributos comunes heredados de `Persona` mediante `super()`,
y sobrescribe únicamente el comportamiento que la distingue cada elemento . Además, la incorporación del
`GestorPersonas` muestra cómo separar la lógica de gestión de datos del modelo y de la interfaz de usuario,
manteniendo el código organizado y fácil de extender.
