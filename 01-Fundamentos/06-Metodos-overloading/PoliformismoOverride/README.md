
# Metodos - Sobrescritura de Métodos - Herencia y Polimorfismo

Este ejercicio aplica **herencia** y **sobrescritura de métodos** para modelar distintos tipos de usuario de un sistema de transporte. La clase base `Usuario` define un comportamiento genérico de `validarPasaje()`, mientras que `Estudiante`, `Adulto` y `TerceraEdad` heredan de ella y redefinen ese método para expresar su propia tarifa.

## 📋 Descripción

- Definición de la clase base `Usuario`, que implementa un método `validarPasaje()` con un comportamiento genérico por defecto.
- Organización del código en `package model` (clases de dominio) y `package ui` (punto de entrada de ejecución).
- Herencia mediante `extends Usuario` en las clases `Estudiante`, `Adulto` y `TerceraEdad`.
- Sobrescritura de método con `@Override` en cada subclase, redefiniendo `validarPasaje()` según el tipo de usuario.
- Creación de un arreglo polimórfico de tipo `Usuario[]`, que almacena instancias de las tres subclases bajo un mismo tipo de referencia.
- Recorrido del arreglo con `for-each`, sin necesidad de conocer en tiempo de compilación el tipo concreto de cada elemento.
- Invocación de `validarPasaje()` sobre cada elemento, resuelta dinámicamente según el tipo real del objeto en tiempo de ejecución.
- Uso de `import` en `Main` para acceder a las clases del paquete `model` desde el paquete `ui`.

## 🧩 Estructuras utilizadas

| Tipo | Sintaxis | Descripción |
|---|---|---|
| Clase | `public class Nombre { }` | Define un tipo de dato con atributos y comportamiento propio. |
| Herencia | `public class Nombre extends Base { }` | Permite que una clase adquiera atributos y métodos de una clase superior. |
| Sobrescritura de método | `@Override public tipo metodo() { }` | Redefine el comportamiento de un método heredado en la subclase. |
| Método de instancia | `public void metodo() { }` | Define una acción que puede realizar un objeto de la clase. |
| Arreglo de objetos (polimórfico) | `Tipo[] variable = { new Sub1(), new Sub2() };` | Almacena referencias de distintas subclases bajo un mismo tipo de referencia declarado. |
| Recorrido `for-each` | `for (Tipo v : arreglo) { }` | Itera sobre cada elemento de un arreglo sin usar un índice explícito. |
| `package` / `import` | `package nombre;` / `import paquete.Clase;` | Organiza clases en espacios de nombres y permite su uso entre distintos paquetes. |

## 📂 Estructura del proyecto

```
proyecto/
├── .idea/
├── .mvn/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── model/
│   │       │   ├── Usuario.java        # Clase base, define validarPasaje() con comportamiento genérico
│   │       │   ├── Estudiante.java     # Hereda de Usuario, sobrescribe validarPasaje() con tarifa estudiante
│   │       │   ├── Adulto.java         # Hereda de Usuario, sobrescribe validarPasaje() con tarifa adulto
│   │       │   └── TerceraEdad.java    # Hereda de Usuario, sobrescribe validarPasaje() con tarifa tercera edad
│   │       └── ui/
│   │           └── Main.java           # Clase principal, crea el arreglo Usuario[] y ejecuta validarPasaje()
│   └── test/
├── target/
├── .gitignore
└── pom.xml
```

## ▶️ Funcionamiento

Al ejecutar el programa se realizan las siguientes acciones:

1. Se crea un arreglo de tipo `Usuario[]` que contiene una instancia de `Estudiante`, una de `Adulto` y una de `TerceraEdad`.
2. Cada objeto queda almacenado bajo el tipo de referencia `Usuario`, aunque su tipo concreto en memoria sigue siendo el de la subclase correspondiente.
3. Se recorre el arreglo `usuarios` mediante `for-each`, obteniendo en cada iteración una variable de tipo `Usuario`.
4. Sobre cada elemento del arreglo se invoca `validarPasaje()`.
5. En tiempo de ejecución, la JVM resuelve dinámicamente qué implementación de `validarPasaje()` ejecutar según el tipo real del objeto, no según el tipo declarado del arreglo.
6. Como resultado, se imprime en consola un mensaje distinto para cada usuario ("Tarifa estudiante aplicada.", "Tarifa Adulto aplicada." y "Tarifa tercera edad aplicada."),
7. evidenciando que cada subclase reemplaza el comportamiento genérico definido en `Usuario` por su propia regla de validación.

Este ejercicio ilustra el polimorfismo por herencia: una misma llamada, `validarPasaje()`, produce comportamientos distintos según el objeto real referenciado,
aunque todos se manipulen a través del tipo común `Usuario`. A diferencia de otros ejercicios donde las subclases heredan y 
extienden estado mediante `super()`, aquí `Estudiante`, `Adulto` y `TerceraEdad` no agregan atributos propios ni delegan al 
constructor de `Usuario`: cada una se limita a redefinir el comportamiento del método heredado, manteniendo el foco exclusivamente
en la sobrescritura como mecanismo de especialización.
