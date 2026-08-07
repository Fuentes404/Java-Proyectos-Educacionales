
# Herencia, Clases y Polimorfismo Básico

Ejercicio en Java que muestra la aplicación del principio de herencia mediante una clase base
`Persona` y dos clases derivadas, `Trabajador` y `Cliente`, que extienden su comportamiento
agregando atributos y métodos propios.

## 📋 Descripción

Este proyecto es un ejercicio introductorio en Java que cubre:
- Definición de una clase base (`Persona`) con atributos privados y encapsulamiento.
- Organización del código mediante `package`.
- Aplicación del principio de herencia utilizando la palabra clave `extends`.
- Uso de `super()` para invocar el constructor de la clase padre desde las clases hijas.
- Creación de clases derivadas (`Trabajador` y `Cliente`) que agregan atributos y métodos propios.
- Reutilización de métodos heredados directamente desde la clase padre (`mostrarInfo()`).
- Definición de métodos `getters` y `setters` propios de cada clase hija.
- Invocación de métodos sobre distintos objetos para mostrar y actualizar su información.
- Comprobación de que el estado de un objeto puede modificarse en tiempo de ejecución a través de sus métodos públicos.

## 🧩 Estructuras utilizadas

| Tipo | Sintaxis | Descripción |
|---|---|---|
| `Clase` | `public class Nombre { ... }` | Define el molde con atributos y métodos que tendrán los objetos creados a partir de ella. |
| `Herencia` | `public class Hija extends Padre { ... }` | Permite que una clase hija herede atributos y métodos de una clase padre. |
| `Atributo privado` | `private tipo nombre;` | Almacena el estado (datos) del objeto, oculto y protegido del acceso externo directo. |
| `Objeto` | `Nombre variable = new Nombre(...);` | Crea una instancia concreta de la clase en memoria. |
| `Constructor parametrizado` | `public Nombre(tipo p1, ...) { ... }` | Inicializa el objeto con valores recibidos desde afuera. |
| `super()` | `super(p1, p2, ...);` | Invoca el constructor de la clase padre desde el constructor de la clase hija. |
| `this` | `this.atributo = valor;` | Referencia al objeto actual, usada para diferenciar el atributo del parámetro. |
| `Getter` | `public tipo getAtributo() { return atributo; }` | Permite leer el valor de un atributo privado desde fuera de la clase. |
| `Setter` | `public void setAtributo(tipo valor) { this.atributo = valor; }` | Permite modificar el valor de un atributo privado desde fuera de la clase, de forma controlada. |
| `Método heredado` | `objeto.mostrarInfo();` | Método definido en la clase padre y utilizado directamente por las clases hijas sin reescribirlo. |
| `Método propio` | `public void nombre() { ... }` | Define comportamiento adicional exclusivo de la clase hija. |
| `package` / `import` | `package model;` / `import model.Clase;` | Organiza las clases en paquetes y permite utilizarlas desde otros archivos. |

## 📂 Estructura del proyecto

```
004-herencia-persona-trabajador-cliente/
├── .idea/                          # Configuración local de IntelliJ
├── .mvn/                           # Maven Wrapper
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── model/
│   │   │   │   ├── Persona.java    # Clase base con atributos privados, constructor, getters y setters
│   │   │   │   ├── Trabajador.java # Clase hija que extiende Persona y agrega idTrabajador
│   │   │   │   └── Cliente.java    # Clase hija que extiende Persona y agrega idCliente
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
1. Se crea un objeto `trabajador1` de tipo `Trabajador` utilizando el constructor parametrizado, pasando `"Camilo Perez"`, `25`, `"123315243-5"` y `"000068"`.
2. Se crea un objeto `cliente1` de tipo `Cliente` utilizando el constructor parametrizado, pasando `"Alejandro Torres"`, `30`, `"198765432-1"` y `"000032"`.
3. Se invoca el método `mostrarInfo()` sobre `trabajador1`, heredado directamente de `Persona`, mostrando su nombre, edad y rut.
4. Se invoca el método `mostrarIdTrabajador()`, propio de la clase `Trabajador`, mostrando su identificador.
5. Se repite el mismo proceso con `cliente1`, invocando `mostrarInfo()` (heredado) y `mostrarIdCliente()` (propio de `Cliente`).
6. Se utilizan los métodos `setNombre()` y `setIdTrabajador()` para modificar el nombre y el identificador de `trabajador1`, ya que sus atributos son `private` y no pueden modificarse directamente.
7. Se vuelve a invocar `mostrarInfo()` y `mostrarIdTrabajador()` sobre `trabajador1`, evidenciando el cambio de estado del objeto tras el uso de los setters.

Este ejercicio permite comprender el principio de herencia: una clase hija puede reutilizar atributos
y métodos ya definidos en una clase padre (`Persona`), evitando duplicar código y manteniendo el
encapsulamiento en cada nivel. El constructor de la clase hija utiliza `super()` para delegar la
inicialización de los atributos comunes al constructor de la clase padre, mientras que cada clase hija
agrega únicamente los atributos y métodos que la distinguen (`idTrabajador` o `idCliente`).
