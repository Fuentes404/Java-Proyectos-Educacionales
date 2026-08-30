# Ejemplo de uso de LinkedList en Java

Este ejercicio muestra el uso de la clase **`LinkedList`** de Java para gestionar una colección dinámica de elementos,
cubriendo las operaciones más comunes: agregar, consultar, modificar, buscar y eliminar elementos, tanto en los extremos
como en posiciones específicas de la lista.

## 📋 Descripción

- Uso de `LinkedList<String>` como estructura de datos para almacenar una colección de animales.
- Agregado de elementos al final de la lista mediante `add()`.
- Agregado de elementos en los extremos mediante `addFirst()` y `addLast()`.
- Consulta de los extremos de la lista con `getFirst()` y `getLast()`.
- Eliminación de los extremos mediante `removeFirst()` y `removeLast()`.
- Inserción de un elemento en una posición específica con `add(indice, elemento)`.
- Búsqueda de un elemento dentro de la lista mediante `contains()`.
- Obtención de la posición de un elemento con `indexOf()`.
- Modificación de un elemento existente mediante `set(indice, elemento)`.
- Eliminación de un elemento específico por valor con `remove(elemento)`.
- Consulta del tamaño de la lista con `size()`.
- Recorrido de la lista mediante un bucle `for-each`.

## 🧩 Estructuras utilizadas

| Tipo | Sintaxis | Descripción |
|------|----------|-------------|
| Colección dinámica | `LinkedList<String>` | Lista doblemente enlazada que permite inserciones y eliminaciones eficientes en los extremos. |
| Agregar al final | `lista.add(elemento)` | Agrega un elemento al final de la lista. |
| Agregar en extremos | `lista.addFirst(e)` / `lista.addLast(e)` | Inserta un elemento al inicio o al final de la lista. |
| Consultar extremos | `lista.getFirst()` / `lista.getLast()` | Obtiene el primer o último elemento sin eliminarlo. |
| Eliminar extremos | `lista.removeFirst()` / `lista.removeLast()` | Elimina el primer o último elemento de la lista. |
| Agregar en posición | `lista.add(indice, elemento)` | Inserta un elemento en una posición específica, desplazando los siguientes. |
| Búsqueda | `lista.contains(elemento)` | Verifica si un elemento existe dentro de la lista. |
| Índice de elemento | `lista.indexOf(elemento)` | Devuelve la posición de la primera ocurrencia de un elemento. |
| Modificar elemento | `lista.set(indice, elemento)` | Reemplaza el elemento ubicado en una posición dada. |
| Eliminar por valor | `lista.remove(elemento)` | Elimina la primera ocurrencia de un elemento específico. |
| Tamaño de la lista | `lista.size()` | Devuelve la cantidad de elementos almacenados. |
| Recorrido for-each | `for (String e : lista) { ... }` | Recorre todos los elementos de la lista en orden. |

## 📂 Estructura del proyecto

```
proyecto/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── ui/
│   │           └── Main.java   # Clase principal: crea y manipula la LinkedList de animales
│   └── test/
├── .gitignore
└── pom.xml
```

## ▶️ Funcionamiento

Al ejecutar el programa se realizan las siguientes acciones en orden:

1. Se crea una `LinkedList<String>` vacía y se agregan tres animales (`Perro`, `Gato`, `Loro`) mediante `add()`, mostrando la lista resultante.
2. Se agrega `Pez` al inicio con `addFirst()` y `Conejo` al final con `addLast()`.
3. Se consultan el primer y el último animal de la lista con `getFirst()` y `getLast()`.
4. Se eliminan el primer y el último elemento con `removeFirst()` y `removeLast()`.
5. Se inserta `Hamster` en la posición 1 mediante `add(1, "Hamster")`.
6. Se verifica si `Gato` está presente en la lista usando `contains()`.
7. Se obtiene la posición de `Loro` dentro de la lista con `indexOf()`.
8. Se modifica el primer elemento de la lista, reemplazándolo por `Tortuga`, mediante `set(0, "Tortuga")`.
9. Se elimina el elemento `Gato` de la lista con `remove("Gato")`.
10. Se muestra la cantidad total de elementos restantes con `size()`.
11. Finalmente, se recorre la lista completa con un bucle `for-each`, imprimiendo cada animal registrado.

Este ejemplo permite visualizar de forma práctica el comportamiento de una `LinkedList`: su flexibilidad para insertar y eliminar elementos en cualquier posición (inicio, final o índice específico), y las operaciones básicas de consulta y modificación que ofrece la API de Java.
