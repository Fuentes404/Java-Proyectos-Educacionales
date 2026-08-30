
# Ejemplo de uso de ArrayList en Java

Este ejercicio muestra el uso de la clase **`ArrayList`** de Java para gestionar una colección dinámica de elementos,
cubriendo las operaciones más comunes: agregar, consultar, modificar, buscar y eliminar elementos, tanto en los extremos
como en posiciones específicas de la lista.

## 📋 Descripción

- Uso de `ArrayList<String>` como estructura de datos para almacenar una colección de animales.
- Agregado de elementos al final de la lista mediante `add()`.
- Agregado de elementos en los extremos mediante `add(0, elemento)` y `add(size(), elemento)` (equivalentes a `addFirst`/`addLast`).
- Consulta de los extremos de la lista con `get(0)` y `get(size() - 1)`.
- Eliminación de los extremos mediante `remove(0)` y `remove(size() - 1)` (equivalentes a `removeFirst`/`removeLast`).
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
| Colección dinámica | `ArrayList<String>` | Lista basada en arreglo redimensionable que permite acceso rápido por índice. |
| Agregar al final | `lista.add(elemento)` | Agrega un elemento al final de la lista. |
| Agregar en extremos | `lista.add(0, e)` / `lista.add(lista.size(), e)` | Inserta un elemento al inicio o al final de la lista (equivalente a `addFirst`/`addLast`). |
| Consultar extremos | `lista.get(0)` / `lista.get(lista.size() - 1)` | Obtiene el primer o último elemento sin eliminarlo. |
| Eliminar extremos | `lista.remove(0)` / `lista.remove(lista.size() - 1)` | Elimina el primer o último elemento de la lista (equivalente a `removeFirst`/`removeLast`). |
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
│   │           └── Main.java   # Clase principal: crea y manipula el ArrayList de animales
│   └── test/
├── .gitignore
└── pom.xml
```

## ▶️ Funcionamiento

Al ejecutar el programa se realizan las siguientes acciones en orden:

1. Se crea un `ArrayList<String>` vacío y se agregan tres animales (`Perro`, `Gato`, `Loro`) mediante `add()`, mostrando la lista resultante.
2. Se agrega `Pez` al inicio con `add(0, "Pez")` y `Conejo` al final con `add(lista.size(), "Conejo")`.
3. Se consultan el primer y el último animal de la lista con `get(0)` y `get(lista.size() - 1)`.
4. Se eliminan el primer y el último elemento con `remove(0)` y `remove(lista.size() - 1)`.
5. Se inserta `Hamster` en la posición 1 mediante `add(1, "Hamster")`.
6. Se verifica si `Gato` está presente en la lista usando `contains()`.
7. Se obtiene la posición de `Loro` dentro de la lista con `indexOf()`.
8. Se modifica el primer elemento de la lista, reemplazándolo por `Tortuga`, mediante `set(0, "Tortuga")`.
9. Se elimina el elemento `Gato` de la lista con `remove("Gato")`.
10. Se muestra la cantidad total de elementos restantes con `size()`.
11. Finalmente, se recorre la lista completa con un bucle `for-each`, imprimiendo cada animal registrado.

Este ejemplo permite visualizar de forma práctica el comportamiento de un `ArrayList`: su flexibilidad para insertar y eliminar elementos en cualquier posición (inicio, final o índice específico), y las operaciones básicas de consulta y modificación que ofrece la API de Java.
