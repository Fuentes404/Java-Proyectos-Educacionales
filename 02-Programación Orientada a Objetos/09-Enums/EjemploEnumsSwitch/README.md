
# Ejemplo enums switch - Enum y Encapsulamiento de Lógica - Uso de Enum en Java

Este ejercicio combina el uso de un **`enum`** como conjunto cerrado y type-safe de valores con el **encapsulamiento de lógica de decisión** dentro de una clase que lo envuelve. La jerarquía involucrada es `Dia` (enum) encapsulado por `DiaInfo`, que expone comportamiento calculado a partir de ese valor sin revelar cómo se obtiene.

## 📋 Descripción

- Uso de `enum` `Dia` para representar un conjunto fijo de valores válidos en tiempo de compilación.
- Encapsulamiento del enum `Dia` dentro de la clase `DiaInfo` mediante un atributo `private final`.
- Constructor parametrizado que recibe el enum y lo asigna al atributo interno, garantizando inmutabilidad tras la construcción.
- Getter público (`getDia`) que expone el atributo sin permitir su modificación directa.
- Uso de `switch` sobre un `enum` para derivar información calculada (`getDescripcion`, `esLaboral`).
- Agrupación de múltiples `case` sin `break` intermedio para compartir el mismo resultado entre distintos valores del enum.
- Cláusula `default` con lanzamiento de excepción (`IllegalStateException`) para manejar estados no contemplados.
- Separación de responsabilidades entre paquetes: `model` (datos y lógica) y `ui` (presentación).
- La clase `Main` solo invoca métodos públicos de `DiaInfo`, sin conocer cómo se calculan los valores devueltos (ocultamiento de implementación).

## 🧩 Estructuras utilizadas

| Tipo | Sintaxis | Descripción |
|------|----------|-------------|
| Enum | `enum Nombre { VALOR1, VALOR2 }` | Define un tipo con un conjunto fijo y controlado de valores posibles. |
| Atributo privado final | `private final tipo atributo;` | Encapsula un dato interno impidiendo su modificación luego de la construcción. |
| Constructor parametrizado | `public Nombre(tipo p1) { this.atributo = p1; }` | Inicializa el estado del objeto a partir de los valores recibidos. |
| Getter | `public tipo getAtributo() { return atributo; }` | Expone el valor de un atributo privado de forma controlada. |
| Switch sobre enum | `switch (atributo) { case VALOR: ... }` | Ejecuta un bloque de código distinto según el valor del enum evaluado. |
| Agrupación de case | `case A: case B: valor = x; break;` | Asocia el mismo resultado a varios valores del enum sin duplicar código. |
| Cláusula default | `default: throw new IllegalStateException(...);` | Maneja de forma explícita valores no contemplados por los `case` anteriores. |
| package/import | `package nombre;` / `import paquete.Clase;` | Organiza el código en módulos y permite reutilizar clases de otros paquetes. |

## 📂 Estructura del proyecto

```
proyecto/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── model/
│   │       │   ├── Dia.java          # Enum con los días de la semana
│   │       │   └── DiaInfo.java      # Encapsula un Dia y calcula descripción y si es laboral
│   │       └── ui/
│   │           └── Main.java         # Clase principal: crea DiaInfo y muestra su información
│   └── test/
├── .gitignore
└── pom.xml
```

## ▶️ Funcionamiento

Al ejecutar el programa se realizan las siguientes acciones:

1. Se crea un objeto `DiaInfo` pasando el valor `Dia.MIERCOLES` al constructor, quedando encapsulado en el atributo privado `dia`.
2. Se invoca el método `mostrar` desde `Main`, que solo conoce los métodos públicos de `DiaInfo`, sin acceso a su estado interno.
3. Se llama a `getDia()` para obtener el valor del enum almacenado y mostrarlo por consola sin transformación alguna.
4. Se llama a `getDescripcion()`, que evalúa el atributo interno mediante un `switch`, agrupando `MARTES`, `MIERCOLES` y `JUEVES` bajo la misma descripción ("Mitad de semana").
5. Se llama a `esLaboral()`, que reutiliza un segundo `switch` para identificar `SABADO` y `DOMINGO` como los únicos valores que devuelven `false`.
6. El resultado impreso en consola evidencia que toda la lógica de decisión permanece oculta dentro de `DiaInfo`: `Main` solo consume los resultados finales, sin conocer los `switch` que los generan.

Dia define de antemano qué valores son válidos, y DiaInfo se encarga de interpretarlos: por dentro usa switch para decidir la descripción y si es laboral, pero hacia afuera solo muestra el resultado, no cómo llegó a él. No hay herencia ni subclases distintas, todo pasa en una sola clase. La única diferencia entre sus métodos es que getDia() solo devuelve el dato tal cual, mientras que getDescripcion() y esLaboral() calculan algo nuevo a partir de ese dato.
