
  # Encapsulamiento, Getters y Setters

Ejercicio en Java que muestra la aplicación del principio de encapsulamiento mediante el uso de
atributos privados, junto con métodos `getters` y `setters` para acceder y modificar el estado
de un objeto de forma controlada.

## 📋 Descripción

Este proyecto es un ejercicio introductorio en Java que cubre:
- Definición de una clase con atributos privados (`private`).
- Organización del código mediante `package`.
- Creación de un objeto utilizando el operador `new` y un constructor parametrizado.
- Aplicación del principio de encapsulamiento, restringiendo el acceso directo a los atributos.
- Definición de métodos `getters` para obtener el valor de un atributo.
- Definición de métodos `setters` para modificar el valor de un atributo de forma controlada.
- Invocación de métodos sobre un objeto para mostrar y actualizar su información.
- Comprobación de que el estado de un objeto puede modificarse en tiempo de ejecución a través de sus métodos públicos.

## 🧩 Estructuras utilizadas

| Tipo | Sintaxis | Descripción |
|---|---|---|
| `Clase` | `public class Nombre { ... }` | Define el molde con atributos y métodos que tendrán los objetos creados a partir de ella. |
| `Atributo privado` | `private tipo nombre;` | Almacena el estado (datos) del objeto, oculto y protegido del acceso externo directo. |
| `Objeto` | `Nombre variable = new Nombre(...);` | Crea una instancia concreta de la clase en memoria. |
| `Constructor parametrizado` | `public Nombre(tipo p1, ...) { ... }` | Inicializa el objeto con valores recibidos desde afuera. |
| `this` | `this.atributo = valor;` | Referencia al objeto actual, usada para diferenciar el atributo del parámetro. |
| `Getter` | `public tipo getAtributo() { return atributo; }` | Permite leer el valor de un atributo privado desde fuera de la clase. |
| `Setter` | `public void setAtributo(tipo valor) { this.atributo = valor; }` | Permite modificar el valor de un atributo privado desde fuera de la clase, de forma controlada. |
| `Método` | `public void nombre() { ... }` | Define el comportamiento que puede ejecutar un objeto. |
| `package` / `import` | `package model;` / `import model.Clase;` | Organiza las clases en paquetes y permite utilizarlas desde otros archivos. |

## 📂 Estructura del proyecto

```
003-encapsulamiento-getters-setters/
├── .idea/                          # Configuración local de IntelliJ
├── .mvn/                           # Maven Wrapper
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── model/
│   │   │   │   └── Persona.java    # Clase que define atributos privados, constructor, getters y setters
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
1. Se crea un objeto `persona1` de tipo `Persona` utilizando el constructor parametrizado, pasando directamente los valores `"Camilo Perez"`, `25` y `"123315243-5"`.
2. Se invoca el método `mostrarInfo()` sobre `persona1`, mostrando su nombre, edad y rut.
3. Se utilizan los métodos `setNombre()` y `setEdad()` para modificar el nombre y la edad de `persona1`, ya que sus atributos son `private` y no pueden modificarse directamente.
4. Se utilizan los métodos `getNombre()` y `getEdad()` para obtener y mostrar por consola los valores actualizados.
5. Se vuelve a invocar `mostrarInfo()` sobre `persona1`, evidenciando el cambio de estado del objeto tras el uso de los setters.

Este ejercicio permite comprender el principio de encapsulamiento: los atributos de un objeto se declaran
`private` para protegerlos de modificaciones directas y no controladas desde fuera de la clase. El acceso
y la modificación de dichos atributos se realiza exclusivamente a través de métodos públicos (`getters` y
`setters`), lo que permite mantener el control sobre cómo se lee y se actualiza el estado de un objeto.

