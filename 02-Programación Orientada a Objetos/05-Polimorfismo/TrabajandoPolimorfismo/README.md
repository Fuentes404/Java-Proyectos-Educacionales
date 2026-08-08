
# Herencia, Polimorfismo y Sobrescritura de Métodos

Ejercicio en Java que demuestra el uso de polimorfismo mediante una clase base Persona y tres
clases derivadas: Trabajador, Cliente y Proveedor.
Todas las subclases heredan los atributos comunes de Persona, pero cada una sobrescribe el método mostrarInfo()
para mostrar su propia información.

## 📋 Descripción

Este proyecto es un ejercicio en Java que cubre:
- Definición de una clase base (`Persona`) con atributos privados y encapsulamiento.
- Organización del código mediante `package`.
- Aplicación del principio de herencia utilizando la palabra clave `extends`.
- Uso de `super()` para invocar el constructor de la clase padre desde las clases hijas.
- Creación de clases derivadas (`Trabajador`, `Cliente` y `Proveedor`) que agregan atributos y métodos propios.
- **Polimorfismo**: uso de un arreglo de tipo `Persona[]` para almacenar objetos de distintas subclases.
- **Sobrescritura de métodos** (`@Override`) del método `mostrarInfo()` en cada clase hija, con comportamiento propio.
- Uso del operador `instanceof` para identificar el tipo real de cada objeto en tiempo de ejecución.
- Sobrescritura del método `toString()` en cada clase para representar el objeto como texto.
- Definición de métodos `getters` y `setters` propios de cada clase hija.

## 🧩 Estructuras utilizadas

| Tipo | Sintaxis | Descripción |
|---|---|---|
| `Clase` | `public class Nombre { ... }` | Define el molde con atributos y métodos que tendrán los objetos creados a partir de ella. |
| `Herencia` | `public class Hija extends Padre { ... }` | Permite que una clase hija herede atributos y métodos de una clase padre. |
| `Atributo privado` | `private tipo nombre;` | Almacena el estado (datos) del objeto, oculto y protegido del acceso externo directo. |
| `Arreglo polimórfico` | `Persona[] personas = new Persona[n];` | Arreglo de tipo padre capaz de almacenar objetos de cualquier clase hija. |
| `Constructor parametrizado` | `public Nombre(tipo p1, ...) { ... }` | Inicializa el objeto con valores recibidos desde afuera. |
| `super()` | `super(p1, p2, ...);` | Invoca el constructor de la clase padre desde el constructor de la clase hija. |
| `this` | `this.atributo = valor;` | Referencia al objeto actual, usada para diferenciar el atributo del parámetro. |
| `Getter` | `public tipo getAtributo() { return atributo; }` | Permite leer el valor de un atributo privado desde fuera de la clase. |
| `Setter` | `public void setAtributo(tipo valor) { this.atributo = valor; }` | Permite modificar el valor de un atributo privado desde fuera de la clase, de forma controlada. |
| `@Override` | `@Override public void metodo() { ... }` | Indica que un método sobrescribe la implementación heredada de la clase padre. |
| `instanceof` | `if (objeto instanceof Clase) { ... }` | Verifica en tiempo de ejecución el tipo real del objeto referenciado. |
| `Polimorfismo` | `p.mostrarInfo();` | Al invocar el método sobre una referencia `Persona`, se ejecuta la versión sobrescrita según el tipo real del objeto. |
| `toString()` | `@Override public String toString() { ... }` | Define la representación en texto del objeto. |
| `package` / `import` | `package model;` / `import model.Clase;` | Organiza las clases en paquetes y permite utilizarlas desde otros archivos. |

## 📂 Estructura del proyecto

```
005-polimorfismo-persona-trabajador-cliente-proveedor/
├── .idea/                          # Configuración local de IntelliJ
├── .mvn/                           # Maven Wrapper
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── model/
│   │   │   │   ├── Persona.java     # Clase base con atributos privados, constructor, getters, setters y mostrarInfo()
│   │   │   │   ├── Trabajador.java  # Clase hija que extiende Persona, agrega idTrabajador y sobrescribe mostrarInfo()
│   │   │   │   ├── Cliente.java     # Clase hija que extiende Persona, agrega idCliente y sobrescribe mostrarInfo()
│   │   │   │   └── Proveedor.java   # Clase hija que extiende Persona, agrega idProveedor y sobrescribe mostrarInfo()
│   │   │   └── ui/
│   │   │       └── Main.java        # Clase principal
│   │   └── resources/               # Recursos del proyecto
│   └── test/                        # Pruebas unitarias
├── target/                          # Archivos generados por Maven
├── .gitignore
└── pom.xml                          # Configuración de dependencias y build (Maven)
```

## ▶️ Funcionamiento

Al ejecutar el programa se realizan las siguientes acciones:
1. Se crea un arreglo `personas` de tipo `Persona[]` con capacidad para 6 elementos.
2. Se instancian dos objetos `Trabajador` (`"Juan Pérez"` y `"María López"`), dos objetos `Cliente`
   (`"Carlos Soto"` y `"Ana Muñoz"`) y dos objetos `Proveedor` (`"Pedro Ramírez"` y `"Laura Fuentes"`),
   almacenándolos todos en el arreglo `personas` a través de referencias de tipo `Persona`.
3. Se recorre el arreglo filtrando con `instanceof Trabajador` para imprimir, bajo el título
   `=== TRABAJADORES ===`, la información de cada trabajador invocando `mostrarInfo()`.
4. Se recorre nuevamente el arreglo filtrando con `instanceof Cliente` para imprimir, bajo el título
   `=== CLIENTES ===`, la información de cada cliente invocando `mostrarInfo()`.
5. Se recorre el arreglo una tercera vez filtrando con `instanceof Proveedor` para imprimir, bajo el
   título `=== PROVEEDORES ===`, la información de cada proveedor invocando `mostrarInfo()`.
6. En cada caso, aunque la variable de recorrido `p` es de tipo `Persona`, la llamada `p.mostrarInfo()`
   ejecuta la versión sobrescrita (`@Override`) definida en la subclase real del objeto (`Trabajador`,
   `Cliente` o `Proveedor`), demostrando el comportamiento polimórfico.

Este ejercicio permite comprender el principio de polimorfismo: un mismo mensaje (`mostrarInfo()`)
enviado a través de una referencia de tipo padre (`Persona`) produce respuestas distintas según el
tipo real del objeto en tiempo de ejecución. Cada subclase reutiliza los atributos comunes heredados
de `Persona` mediante `super()`, y sobrescribe únicamente el comportamiento que la distingue,
manteniendo el encapsulamiento y evitando duplicar lógica innecesaria.
