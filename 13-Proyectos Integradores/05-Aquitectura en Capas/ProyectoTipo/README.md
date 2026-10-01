# Maqueta de Proyecto en Java por Capas

Esta maqueta es una **guía de estructura y orden** para proyectos pequeños y medianos en Java. Son clases vacías con comentarios que indican qué va en cada sección, para que sirvan de punto de partida al iniciar un proyecto nuevo.

> **Importante:** la estructura es una guía, no una obligación. Se usan solo las partes que el proyecto necesite; las demás se eliminan.

## 📋 Descripción

- Cada clase tiene **una sola responsabilidad** (datos, reglas, pantalla, validación, acceso a BD).
- Cada archivo trae sus secciones ya ordenadas (constantes, atributos, constructor, métodos, etc.).
- Los comentarios `Considerar:` dan recomendaciones cortas, sin imponer código.
- Sirve para proyectos con **base de datos** o **sin ella**, y con interfaz **gráfica (Swing)** o **consola (Scanner)**.
- Separación en capas: `main`, `model`, `interfaces`, `services`, `ui`, `util` y `dao`.

## 🧩 Conceptos que se aplican

| Concepto | Descripción |
|----------|-------------|
| Capas | Cada paquete tiene un rol: modelo, lógica, pantalla, validación y datos. |
| Entidad (`model`) | Clase que representa algo del sistema y guarda sus datos. |
| Interfaz (`interfaces`) | Define qué debe poder hacer una clase, sin explicar cómo. |
| Gestor (`services`) | Aplica las reglas del negocio y conecta la pantalla con los datos. |
| DAO (`dao`) | Clase que realiza las operaciones sobre los datos (CRUD) de una entidad. |
| Validador (`util`) | Métodos `static` que responden `true` o `false`, sin mostrar mensajes. |

## 📂 Estructura del proyecto

```
proyecto/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── main/
│   │       │   └── Main.java                      # Punto de entrada: arma y arranca el sistema
│   │       ├── model/
│   │       │   └── Objeto.java                    # Entidad del sistema
│   │       ├── interfaces/
│   │       │   └── Contrato.java                  # Define qué reglas y metodos implementan las clases 
│   │       ├── services/
│   │       │   └── GestorEntidad.java             # Realiza la gestion de los Datos de la entidad
│   │       ├── ui/
│   │       │   └── Ventana.java                   # Parte visual (Swing o consola)
│   │       ├── util/
│   │       │   └── ValidadorDatos.java            # Validaciones de datos
│   │       └── dao/
│   │           ├── ConexionBD.java                # Abre y entrega la conexión a la BD
│   │           └── ObjetoDAO.java                 # Operaciones sobre los datos (CRUD)
│   └── test/
├── .gitignore
└── pom.xml
```

## 🏗️ Capas

| Capa | Responsabilidad |
|------|-----------------|
| `main` | Arranca el sistema y crea los objetos principales. Sin lógica de negocio ni diseño de pantallas. |
| `model` | Entidades del sistema y su comportamiento propio. No conoce la UI ni la BD. |
| `interfaces` | Contratos que cumplen las clases que lo necesiten. |
| `services` | Reglas del negocio. Es el intermediario entre la UI y los datos. No muestra mensajes, solo entrega resultados o errores. |
| `ui` | Parte visual. Recibe las acciones del usuario y muestra las respuestas. No lleva reglas de negocio ni acceso directo a la BD. |
| `util` | Herramientas de apoyo, como las validaciones. No depende de la UI, del gestor ni de la BD. |
| `dao` | Conexión y acceso a los datos. No aplica reglas de negocio ni muestra mensajes. |

## 🔄 Cómo se conectan las clases para formar un proyecto

<img width="2920" height="3320" alt="uml_clases_con_componentes" src="https://github.com/user-attachments/assets/988e19bc-3a2b-4f1c-95ab-58c66d082f77" />

## ▶️ Cómo usar la maqueta

1. **Copiar** la estructura de carpetas al proyecto nuevo.
2. **Renombrar** las clases según el proyecto (`Objeto` → `Usuario`, `GestorEntidad` → `GestorUsuarios`, etc.).
3. **Duplicar** las clases que se repiten por entidad: `model`, `DAO` y `Gestor`.
4. **Eliminar** las partes que no se necesiten (ver sección siguiente).
5. **Completar** cada archivo siguiendo el orden de sus secciones.
6. En `Main`, **crear los objetos** en este orden: conexión (`dao`), gestor (`services`) y ventana (`ui`).

## ✂️ Qué es opcional

Ninguna parte es obligatoria. Algunos ejemplos:

- **Sin base de datos:** se omiten `ConexionBD` y `ObjetoDAO`. El gestor guarda los datos en su lista en memoria.
- **Sin interfaces:** se omite `Contrato` si ninguna clase comparte comportamiento con otra.
- **Pocas validaciones:** se omite `ValidadorDatos` y se validan en el gestor o en el modelo.
- **Por consola:** `Ventana` se reemplaza por un menú con `Scanner`. Aplican las mismas secciones, usando menús en vez de botones.
- **Secciones internas:** constantes, atributos o métodos auxiliares se escriben solo si la clase los necesita.

## 🗄️ Si se usa base de datos

Agregar esta dependencia en el `pom.xml`, entre `</properties>` y `</project>`:

```xml
<dependencies>
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <version>9.0.0</version>
    </dependency>
</dependencies>
```

> No dejar usuario ni clave escritos en el código si el proyecto se sube a un repositorio.

## 📑 Estructura de la maqueta

Descripción de cada parte que compone las clases:

| Clase | Elemento | Descripción |
|---|---|---|
| `Contrato` | Función | Define qué debe poder hacer una clase, sin explicar cómo lo hace |
| `Main` | Función | Arranca el sistema y prepara todo para que la aplicación funcione |
| `Main` | Método de arranque | Punto donde inicia el programa |
| `Main` | Instancias (UI o GUI) | Creación de los objetos principales |
| `Main` | Métodos de apertura | Mostrar la aplicación |
| `Objeto` | Función | Representa una entidad del sistema, guarda sus datos y su comportamiento propio |
| `Objeto` | Constantes | Valores fijos de la clase |
| `Objeto` | Atributos | Datos que describen a la entidad |
| `Objeto` | Constructor | Cómo se crea la entidad |
| `Objeto` | Métodos Getter and Setter | Leer y modificar los atributos |
| `Objeto` | Métodos Funcionales | Lo que la entidad sabe hacer |
| `Objeto` | Métodos Auxiliares | Apoyo interno a los funcionales |
| `Objeto` | Métodos de Representación | Cómo se compara y se muestra (equals, hashCode, toString) |
| `GestorEntidad` | Función | Controla los datos de una clase o grupo de clases y aplica las reglas del negocio |
| `GestorEntidad` | Dependencias | Clases externas que necesita para trabajar |
| `GestorEntidad` | Referencias | Datos que mantiene en memoria |
| `GestorEntidad` | Constructor | Cómo se crea el gestor |
| `GestorEntidad` | Métodos de Entrada | Datos que llegan desde la UI |
| `GestorEntidad` | Métodos de control | Reglas del negocio |
| `GestorEntidad` | Métodos de Salida | Datos que se entregan a la UI |
| `GestorEntidad` | Manejo de Errores | Qué hacer cuando algo falla |
| `GestorEntidad` | Métodos Auxiliares | Apoyo interno |
| `Ventana` | Función | Parte visual del sistema: recibe las acciones del usuario y muestra las respuestas de la lógica |
| `Ventana` | Constantes | Valores fijos de la pantalla |
| `Ventana` | Atributos | Componentes visuales |
| `Ventana` | Dependencias | Clases externas que necesita |
| `Ventana` | Controladores | Quienes responden a las acciones del usuario |
| `Ventana` | Constructor | Arma la ventana paso a paso |
| `Ventana` | Configuraciones de Ventana | Título, tamaño y comportamiento al cerrar (dentro del constructor) |
| `Ventana` | Inicializar componentes | Crear los componentes de la pantalla (dentro del constructor) |
| `Ventana` | Configurar Diseño | Ubicar los componentes en la pantalla (dentro del constructor) |
| `Ventana` | Configurar Los Eventos funcionales | Botones, clicks y demás acciones (dentro del constructor) |
| `Ventana` | Métodos Funcionales | Acciones visibles para el usuario |
| `Ventana` | Métodos Auxiliares | Apoyo interno |
| `ValidadorDatos` | Función | Verifica que los datos sean correctos antes de que pasen a la lógica o a la BD |
| `ValidadorDatos` | Constantes | Reglas fijas de validación |
| `ValidadorDatos` | Atributos | Datos propios de la clase |
| `ValidadorDatos` | Constructor | Cómo se crea la clase |
| `ValidadorDatos` | Métodos Funcionales (Validaciones de Datos) | Las revisiones en sí |
| `ValidadorDatos` | Métodos Auxiliares (Recorrer listas, etc) | Apoyo interno |
| `ConexionBD` | Función | Abre y entrega la conexión con la base de datos |
| `ConexionBD` | Conexión a Base de datos o fuente de datos | Dónde y cómo conectarse |
| `ConexionBD` | Constructor | Prepara la conexión |
| `ConexionBD` | Métodos de conexión | Abrir, entregar y cerrar la conexión |
| `ConexionBD` | Métodos Auxiliares | Apoyo interno |
| `ObjetoDAO` | Función | Realiza las operaciones sobre los datos de una entidad, usando la conexión |
| `ObjetoDAO` | Dependencias | Clases externas que necesita |
| `ObjetoDAO` | Constructor | Cómo se crea el DAO |
| `ObjetoDAO` | Métodos CRUD | Operaciones básicas sobre los datos: Crear, Leer, Actualizar o editar, Eliminar |
| `ObjetoDAO` | Consultas | Búsquedas específicas |
| `ObjetoDAO` | Métodos Auxiliares | Apoyo interno |


Esta maqueta permite arrancar un proyecto con orden desde el primer día: cada clase tiene su lugar, cada sección su propósito, y se adapta al tamaño y las necesidades de cada proyecto.
