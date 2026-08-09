# Usando Interfaces - Clases Abstractas e Interfaces - Herencia y Polimorfismo

Ejercicio en Java que combina dos formas de lograr polimorfismo: **herencia con clase abstracta**,
mediante la jerarquía `Profesor` (con `Matematicas` e `Historia`); y **contrato por interfaz**,
mediante `Ubicable`, implementada por dos clases sin relación de herencia entre sí: `Colegio` y
`Gimnasio`.

## 📋 Descripción

Este proyecto es un ejercicio en Java que cubre:
- Definición de una clase base **abstracta** (`Profesor`) con atributos privados y encapsulamiento.
- Organización del código mediante `package`.
- Aplicación del principio de herencia utilizando la palabra clave `extends`.
- Uso de `super()` para invocar el constructor de la clase padre desde las clases hijas.
- Definición de un **método abstracto** (`mostrarInfo()`) en la clase padre, sin implementación propia.
- Creación de clases derivadas (`Matematicas` e `Historia`) que agregan atributos y métodos propios.
- Implementación **obligatoria** del método abstracto `mostrarInfo()` en cada clase hija mediante `@Override`.
- Definición de una **interfaz** (`Ubicable`) como contrato de comportamiento independiente de la herencia.
- Implementación de la interfaz `Ubicable` en clases sin parentesco entre sí (`Colegio` y `Gimnasio`).
- **Polimorfismo por herencia**: uso de un arreglo de tipo `Profesor[]` para almacenar objetos de distintas subclases.
- **Polimorfismo por interfaz**: uso de un arreglo de tipo `Ubicable[]` para almacenar objetos de clases no emparentadas.
- Uso del operador `instanceof` para identificar el tipo real de cada objeto en tiempo de ejecución.
- Sobrescritura del método `toString()` en cada clase para representar el objeto como texto.
- Definición de métodos `getters` y `setters` propios de cada clase.

## 🧩 Estructuras utilizadas

| Tipo | Sintaxis | Descripción |
|---|---|---|
| `Clase abstracta` | `public abstract class Nombre { ... }` | Define un molde incompleto que no puede instanciarse directamente, pensado para ser extendido. |
| `Método abstracto` | `public abstract void metodo();` | Declara la firma de un método sin cuerpo; obliga a las clases hijas concretas a implementarlo. |
| `Herencia` | `public class Hija extends Padre { ... }` | Permite que una clase hija herede atributos y métodos de una clase padre. |
| `Interfaz` | `public interface Nombre { void metodo(); }` | Define un contrato de comportamiento que cualquier clase, esté o no emparentada, puede implementar. |
| `Implementación de interfaz` | `public class Clase implements Interfaz { ... }` | Obliga a la clase a definir todos los métodos declarados en la interfaz. |
| `Atributo privado` | `private tipo nombre;` | Almacena el estado (datos) del objeto, oculto y protegido del acceso externo directo. |
| `Arreglo polimórfico` | `Profesor[] profesores = new Profesor[n];` | Arreglo de tipo padre o interfaz capaz de almacenar objetos de distintas clases concretas. |
| `Constructor parametrizado` | `public Nombre(tipo p1, ...) { ... }` | Inicializa el objeto con valores recibidos desde afuera. |
| `super()` | `super(p1, p2, ...);` | Invoca el constructor de la clase padre desde el constructor de la clase hija. |
| `this` | `this.atributo = valor;` | Referencia al objeto actual, usada para diferenciar el atributo del parámetro. |
| `Getter` | `public tipo getAtributo() { return atributo; }` | Permite leer el valor de un atributo privado desde fuera de la clase. |
| `Setter` | `public void setAtributo(tipo valor) { this.atributo = valor; }` | Permite modificar el valor de un atributo privado desde fuera de la clase, de forma controlada. |
| `@Override` | `@Override public void metodo() { ... }` | Indica que un método implementa o sobrescribe la versión de la clase padre o interfaz. |
| `instanceof` | `if (objeto instanceof Clase) { ... }` | Verifica en tiempo de ejecución el tipo real del objeto referenciado. |
| `Polimorfismo` | `p.mostrarInfo();` | Al invocar el método sobre una referencia de tipo padre o interfaz, se ejecuta la implementación definida por el tipo real del objeto. |
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
│   │   │   │   ├── Profesor.java    # Clase base ABSTRACTA con atributos privados, constructor, getters/setters y mostrarInfo() abstracto
│   │   │   │   ├── Matematicas.java # Clase hija que extiende Profesor, agrega especialidad e implementa mostrarInfo()
│   │   │   │   ├── Historia.java    # Clase hija que extiende Profesor, agrega periodoHistorico e implementa mostrarInfo()
│   │   │   │   ├── Ubicable.java    # Interfaz con el contrato mostrarInfo(), sin relación de herencia
│   │   │   │   ├── Colegio.java     # Clase que implementa Ubicable, sin extender de ninguna otra clase
│   │   │   │   └── Gimnasio.java    # Clase que implementa Ubicable, sin extender de ninguna otra clase
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

**Jerarquía `Profesor` (herencia + clase abstracta)**
1. Se crea un arreglo `profesores` de tipo `Profesor[]` con capacidad para 4 elementos. Como
   `Profesor` es abstracta, nunca puede instanciarse directamente (`new Profesor(...)` no
   compilaría); solo pueden almacenarse en el arreglo objetos de sus subclases concretas.
2. Se instancian dos objetos `Matematicas` y dos objetos `Historia`, almacenándolos en el arreglo
   `profesores` a través de referencias de tipo `Profesor`.
3. Se recorre el arreglo filtrando con `instanceof Matematicas` para imprimir, bajo el título
   `=== PROFESORES DE MATEMATICAS ===`, la información de cada profesor invocando `mostrarInfo()`.
4. Se recorre nuevamente el arreglo filtrando con `instanceof Historia` para imprimir, bajo el
   título `=== PROFESORES DE HISTORIA ===`, la información de cada profesor invocando `mostrarInfo()`.
5. En ambos casos, aunque la variable de recorrido es de tipo `Profesor`, la llamada
   `p.mostrarInfo()` ejecuta la implementación definida en la subclase real del objeto
   (`Matematicas` o `Historia`), ya que `Profesor` no ofrece una versión propia del método, solo
   su firma.

**Contrato `Ubicable` (interfaz, sin herencia)**
6. Se crea un arreglo `lugares` de tipo `Ubicable[]`, que almacena un objeto `Colegio` y un objeto
   `Gimnasio` — clases que no heredan de ninguna clase en común, solo comparten el contrato
   `Ubicable`.
7. Se recorre el arreglo invocando `mostrarInfo()` sobre cada lugar bajo el título
   `=== LUGARES ===`. A diferencia del caso anterior, aquí no se filtra por `instanceof`, ya que el
   objetivo es mostrar que ambos tipos, sin relación de herencia, responden al mismo método por
   cumplir el mismo contrato.

Este ejercicio permite comprender las dos formas principales de lograr polimorfismo en Java: por
**herencia**, cuando las clases comparten un antepasado común y un método abstracto que deben
implementar (`Profesor` → `Matematicas`/`Historia`); y por **interfaz**, cuando clases sin ningún
parentesco acuerdan cumplir el mismo contrato de comportamiento (`Ubicable` → `Colegio`/`Gimnasio`).
Los atributos comunes de la jerarquía (`nombre` y `edad` en `Profesor`) siguen heredándose mediante
`super()`, mientras que `Colegio` y `Gimnasio` construyen su propio estado de forma independiente, ya
que no heredan de ninguna clase.
