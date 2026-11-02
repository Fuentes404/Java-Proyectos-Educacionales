# Usuario Abstracto - Clases Abstractas, Herencia y Enums

Ejercicio en Java que usa una clase base **abstracta** `Usuario` y dos clases derivadas, `UsuarioAdmin` y `UsuarioCliente`, que implementan el método abstracto `mostrarInformacion()`. Cada usuario tiene un rol definido con el enum `TipoRol`. El código está separado en paquetes: `main` para el punto de entrada y `model` para las clases del dominio.

## 📋 Descripción

Este proyecto es un ejercicio en Java que cubre:
- Definición de una clase base **abstracta** (`Usuario`) con atributos, constructor y getters/setters.
- Definición de un **método abstracto** (`mostrarInformacion()`) que cada clase hija debe implementar.
- Herencia con `extends` y uso de `super()` para llamar al constructor del padre.
- Uso de un **enum** (`TipoRol`) para representar el rol del usuario.
- Atributo `final` (`rol`), que se asigna una sola vez desde el constructor de cada subclase.
- **Polimorfismo**: las variables son de tipo `Usuario`, pero los objetos son `UsuarioCliente` y `UsuarioAdmin`.
- Separación del código en paquetes: `main` (ejecución) y `model` (entidades y enum).

## 🧩 Estructuras utilizadas

| Tipo | Sintaxis | Descripción |
|---|---|---|
| `Clase abstracta` | `public abstract class Usuario { ... }` | Molde incompleto que no se puede instanciar directamente. |
| `Método abstracto` | `public abstract void mostrarInformacion();` | Firma sin cuerpo; obliga a las clases hijas a implementarlo. |
| `Herencia` | `public class UsuarioAdmin extends Usuario { ... }` | La clase hija hereda atributos y métodos del padre. |
| `Constructor protected` | `protected Usuario(...) { ... }` | Solo puede ser llamado desde las subclases. |
| `super()` | `super(id, nombre, ..., TipoRol.ADMIN);` | Invoca el constructor de la clase padre. |
| `Enum` | `public enum TipoRol { ADMIN, CLIENTE }` | Define un conjunto fijo de valores posibles. |
| `final` | `protected final TipoRol rol;` | El valor se asigna una vez y no puede cambiar. |
| `Getter / Setter` | `getNombre()` / `setNombre(...)` | Lectura y modificación de los atributos. |
| `Polimorfismo` | `Usuario u = new UsuarioCliente(...);` | Una referencia del padre apunta a un objeto de la hija. |
| `package` / `import` | `package model;` / `import model.Usuario;` | Organiza las clases en paquetes y permite usarlas desde otros archivos. |

## 📂 Estructura del proyecto

```
├── main/
│   └── Main.java              # Clase principal, crea los usuarios y prueba los métodos
└── model/
    ├── TipoRol.java           # Enum con los roles ADMIN y CLIENTE
    ├── Usuario.java           # Clase base abstracta con atributos, constructor y getters/setters
    ├── UsuarioAdmin.java      # Clase hija, rol ADMIN, implementa mostrarInformacion()
    └── UsuarioCliente.java    # Clase hija, rol CLIENTE, implementa mostrarInformacion()
```

### Paquetes

| Paquete | Contenido | Rol dentro del proyecto |
|---|---|---|
| `main` | `Main` | Punto de entrada: crea los objetos y prueba sus métodos. Importa las clases de `model`. |
| `model` | `Usuario`, `UsuarioAdmin`, `UsuarioCliente`, `TipoRol` | Clases del dominio: datos, comportamiento y el enum de roles. No depende de `main`. |

## ▶️ Funcionamiento

Al ejecutar el programa se realizan las siguientes acciones:
1. `Main` (paquete `main`) importa `Usuario`, `UsuarioAdmin` y `UsuarioCliente` desde el paquete `model`.
2. Se crea un `UsuarioCliente` ("Alejandro Perez") y un `UsuarioAdmin` ("Juan uno"), ambos guardados en variables de tipo `Usuario`.
3. Se llama a `mostrarInformacion()` en cada uno. Aunque la variable es de tipo `Usuario`, se ejecuta la versión de la clase real del objeto.
4. Se imprime el rol de cada usuario con `getRol()`, que devuelve el valor del enum `TipoRol`.

### Salida esperada

```
Cliente: Alejandro Perez
Correo: alejandro@correo.com
Cliente: Juan uno
Correo: juan@correo.com
CLIENTE
ADMIN
```

Este ejercicio muestra cómo una clase abstracta define un contrato común (`mostrarInformacion()`) y cómo cada subclase lo cumple a su manera, mientras comparte los atributos y getters/setters de la clase base.
