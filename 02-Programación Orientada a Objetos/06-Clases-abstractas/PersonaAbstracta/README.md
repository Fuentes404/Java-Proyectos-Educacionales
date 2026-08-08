

# Persona Abstracta - Herencia, Clases Abstractas y Polimorfismo

Ejercicio en Java que demuestra el uso de **polimorfismo** mediante una clase base **abstracta**
`Persona` y tres clases derivadas, `Trabajador`, `Cliente` y `Proveedor`, que implementan
obligatoriamente el método abstracto `mostrarInfo()` para mostrar su propia información, aunque
todas sean tratadas a través de referencias de tipo `Persona`.

## 📋 Descripción

Este proyecto es un ejercicio en Java que cubre:
- Definición de una clase base **abstracta** (`Persona`) con atributos privados y encapsulamiento.
- Organización del código mediante `package`.
- Aplicación del principio de herencia utilizando la palabra clave `extends`.
- Uso de `super()` para invocar el constructor de la clase padre desde las clases hijas.
- Definición de un **método abstracto** (`mostrarInfo()`) en la clase padre, sin implementación propia.
- Creación de clases derivadas (`Trabajador`, `Cliente` y `Proveedor`) que agregan atributos y métodos propios.
- Implementación **obligatoria** del método abstracto `mostrarInfo()` en cada clase hija mediante `@Override`.
- **Polimorfismo**: uso de un arreglo de tipo `Persona[]` para almacenar objetos de distintas subclases.
- Uso del operador `instanceof` para identificar el tipo real de cada objeto en tiempo de ejecución.
- Sobrescritura del método `toString()` en cada clase para representar el objeto como texto.
- Definición de métodos `getters` y `setters` propios de cada clase hija.

## 🧩 Estructuras utilizadas

| Tipo | Sintaxis | Descripción |
|---|---|---|
| `Clase abstracta` | `public abstract class Nombre { ... }` | Define un molde incompleto que no puede instanciarse directamente, pensado para ser extendido. |
| `Método abstracto` | `public abstract void metodo();` | Declara la firma de un método sin cuerpo; obliga a las clases hijas concretas a implementarlo. |
| `Herencia` | `public class Hija extends Padre { ... }` | Permite que una clase hija herede atributos y métodos de una clase padre. |
| `Atributo privado` | `private tipo nombre;` | Almacena el estado (datos) del objeto, oculto y protegido del acceso externo directo. |
| `Arreglo polimórfico` | `Persona[] personas = new Persona[n];` | Arreglo de tipo padre capaz de almacenar objetos de cualquier clase hija concreta. |
| `Constructor parametrizado` | `public Nombre(tipo p1, ...) { ... }` | Inicializa el objeto con valores recibidos desde afuera. |
| `super()` | `super(p1, p2, ...);` | Invoca el constructor de la clase padre desde el constructor de la clase hija. |
| `this` | `this.atributo = valor;` | Referencia al objeto actual, usada para diferenciar el atributo del parámetro. |
| `Getter` | `public tipo getAtributo() { return atributo; }` | Permite leer el valor de un atributo privado desde fuera de la clase. |
| `Setter` | `public void setAtributo(tipo valor) { this.atributo = valor; }` | Permite modificar el valor de un atributo privado desde fuera de la clase, de forma controlada. |
| `@Override` | `@Override public void metodo() { ... }` | Indica que un método implementa o sobrescribe la versión de la clase padre. |
| `instanceof` | `if (objeto instanceof Clase) { ... }` | Verifica en tiempo de ejecución el tipo real del objeto referenciado. |
| `Polimorfismo` | `p.mostrarInfo();` | Al invocar el método sobre una referencia `Persona`, se ejecuta la implementación definida por el tipo real del objeto. |
| `toString()` | `@Override public String toString() { ... }` | Define la representación en texto del objeto. |
| `package` / `import` | `package model;` / `import model.Clase;` | Organiza las clases en paquetes y permite utilizarlas desde otros archivos. |

## 📂 Estructura del proyecto

```
├── .idea/                          # Configuración local de IntelliJ
├── .mvn/                           # Maven Wrapper
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── model/
│   │   │   │   ├── Persona.java     # Clase base ABSTRACTA con atributos privados, constructor, getters/setters y mostrarInfo() abstracto
│   │   │   │   ├── Trabajador.java  # Clase hija que extiende Persona, agrega idTrabajador e implementa mostrarInfo()
│   │   │   │   ├── Cliente.java     # Clase hija que extiende Persona, agrega idCliente e implementa mostrarInfo()
│   │   │   │   └── Proveedor.java   # Clase hija que extiende Persona, agrega idProveedor e implementa mostrarInfo()
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
1. Se crea un arreglo `personas` de tipo `Persona[]` con capacidad para 6 elementos. Como `Persona`
   es abstracta, nunca puede instanciarse directamente (`new Persona(...)` no compilaría); solo
   pueden almacenarse en el arreglo objetos de sus subclases concretas.
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
   ejecuta la implementación definida en la subclase real del objeto (`Trabajador`, `Cliente` o
   `Proveedor`), ya que `Persona` no ofrece una versión propia del método, solo su firma.

Este ejercicio permite comprender el uso de clases abstractas como herramienta de diseño: al declarar
`Persona` como `abstract` y `mostrarInfo()` como método abstracto, se impide crear objetos "Persona"
genéricos y se obliga, en tiempo de compilación, a que toda subclase concreta (`Trabajador`, `Cliente`,
`Proveedor`) defina su propia forma de mostrar su información. Los atributos comunes (`nombre` y
`edad`) y sus getters/setters siguen siendo heredados normalmente mediante `super()`, mientras que el
comportamiento polimórfico al invocar `mostrarInfo()` se mantiene exactamente igual que antes, ahora
respaldado por un contrato formal impuesto por el compilador.
