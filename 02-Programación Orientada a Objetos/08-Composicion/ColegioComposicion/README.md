
# Modelo de Composición - Colegio, Curso y Estudiante

Ejercicio en Java que aplica el principio de **composición de objetos**, mediante la jerarquía
`Colegio` → `Curso` → `Estudiante`, donde cada clase de nivel superior contiene un arreglo de
objetos de la clase de nivel inferior, y delega en ellos la responsabilidad de mostrar su propia
información.

## 📋 Descripción

Este proyecto es un ejercicio en Java que cubre:
- Definición de clases con atributos **privados** y encapsulamiento mediante `getters` y `setters`.
- Organización del código mediante `package` (`model` y `ui`).
- Aplicación del principio de **composición**: una clase contiene arreglos de objetos de otra clase
  (`Colegio` contiene `Curso[]`, y `Curso` contiene `Estudiante[]`).
- Uso de constructores parametrizados para inicializar el estado del objeto, incluyendo arreglos de
  objetos ya construidos.
- Definición de un método `mostrarInfo()` en cada clase, que imprime los datos propios del objeto.
- **Delegación en cascada**: `mostrarInfo()` de una clase invoca el `mostrarInfo()` de cada objeto
  que compone, propagando la impresión de información desde el nivel superior hasta el inferior.
- Recorrido de arreglos de objetos mediante `for-each` (`for (Tipo x : arreglo)`).
- Separación de responsabilidades entre la capa de datos (`model`) y la capa de ejecución (`ui`).

## 🧩 Estructuras utilizadas

| Tipo | Sintaxis | Descripción |
|---|---|---|
| `Clase` | `public class Nombre { ... }` | Define un molde para crear objetos con atributos y comportamiento propio. |
| `Atributo privado` | `private tipo nombre;` | Almacena el estado (datos) del objeto, oculto y protegido del acceso externo directo. |
| `Composición` | `private Curso[] cursos;` | Un objeto almacena referencias a otros objetos como parte de su propio estado. |
| `Constructor parametrizado` | `public Nombre(tipo p1, ...) { ... }` | Inicializa el objeto con valores recibidos desde afuera, incluyendo arreglos de objetos ya creados. |
| `this` | `this.atributo = valor;` | Referencia al objeto actual, usada para diferenciar el atributo del parámetro. |
| `Getter` | `public tipo getAtributo() { return atributo; }` | Permite leer el valor de un atributo privado desde fuera de la clase. |
| `Setter` | `public void setAtributo(tipo valor) { this.atributo = valor; }` | Permite modificar el valor de un atributo privado desde fuera de la clase, de forma controlada. |
| `Arreglo de objetos` | `Estudiante[] estudiantes = new Estudiante[n];` | Estructura que almacena múltiples objetos de un mismo tipo. |
| `for-each` | `for (Tipo x : arreglo) { ... }` | Recorre cada elemento de un arreglo sin necesidad de un índice explícito. |
| `Delegación en cascada` | `c.mostrarInfo();` dentro de `mostrarInfo()` | Un método invoca el método equivalente de los objetos que componen la clase, propagando la acción hacia niveles inferiores. |
| `package` / `import` | `package model;` / `import model.Clase;` | Organiza las clases en paquetes y permite utilizarlas desde otros archivos. |

## 📂 Estructura del proyecto

```
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── model/
│   │   │   │   ├── Estudiante.java  # Clase con nombre y promedio, getters/setters y mostrarInfo()
│   │   │   │   ├── Curso.java       # Clase con nombre y arreglo de Estudiante; mostrarInfo() delega en cada estudiante
│   │   │   │   └── Colegio.java     # Clase con nombre y arreglo de Curso; mostrarInfo() delega en cada curso
│   │   │   └── ui/
│   │   │       └── Main.java        # Clase principal: crea estudiantes, cursos y colegio, y muestra la información
│   │   └── resources/               # Recursos del proyecto
│   └── test/                        # Pruebas unitarias
├── .gitignore
└── pom.xml                          # Configuración de dependencias y build (Maven)
```

## ▶️ Funcionamiento

Al ejecutar el programa se realizan las siguientes acciones:

1. Se crean tres objetos `Estudiante` (con nombre y promedio) y se almacenan en un arreglo
   `Estudiante[] estudiantesCurso1`, y otros dos objetos `Estudiante` en un arreglo
   `estudiantesCurso2`.
2. Se crean dos objetos `Curso` (`Matemáticas` e `Historia`), pasando a cada uno el arreglo de
   estudiantes correspondiente a través del constructor. Cada `Curso` queda **compuesto** por sus
   propios `Estudiante`.
3. Ambos cursos se agrupan en un arreglo `Curso[] cursos`.
4. Se crea un objeto `Colegio` (`Colegio San José`), pasando el arreglo `cursos` a través del
   constructor. El `Colegio` queda **compuesto** por sus propios `Curso`.
5. Se invoca `colegio.mostrarInfo()`, lo que dispara una **cascada de llamadas**:
   - `Colegio.mostrarInfo()` imprime el nombre del colegio y recorre su arreglo de `Curso`,
     invocando `mostrarInfo()` sobre cada uno.
   - Cada `Curso.mostrarInfo()` imprime su propio nombre y recorre su arreglo de `Estudiante`,
     invocando `mostrarInfo()` sobre cada uno.
   - Cada `Estudiante.mostrarInfo()` imprime su nombre y su promedio.
6. El resultado final en consola muestra la información completa del colegio, con sus cursos
   anidados y, dentro de cada curso, sus estudiantes anidados.

Este ejercicio permite comprender el principio de **composición** ("tiene un") como alternativa a la
herencia ("es un"): en vez de que `Curso` u `Estudiante` extiendan de otra clase, `Colegio` **tiene**
un arreglo de `Curso`, y `Curso` **tiene** un arreglo de `Estudiante`. La responsabilidad de mostrar
la información no se concentra en un solo lugar, sino que se **delega** de forma recursiva desde el
objeto contenedor hacia cada uno de los objetos que lo componen.
