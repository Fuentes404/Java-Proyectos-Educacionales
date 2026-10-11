# Biblioteca Escolar - Sistema de Gestión con Java y Swing

Este proyecto simula el sistema de gestión de una **biblioteca escolar**. Aplica **Programación Orientada a Objetos** (herencia, clase abstracta, enumeraciones, polimorfismo y sobreescritura), una arquitectura en capas **Modelo - Vista - Controlador** y una interfaz gráfica con **Java Swing**. Los datos se mantienen en memoria mientras la aplicación está abierta.

## 📋 Descripción

Biblioteca Escolar es una aplicación de escritorio para que un colegio administre sus **libros**, **estudiantes** y **préstamos** desde una sola ventana. Existen dos tipos de usuario con permisos distintos:

- **Bibliotecario (ADMIN):** gestiona libros, usuarios y préstamos, y registra las devoluciones.
- **Estudiante:** consulta el catálogo de libros y revisa sus propios préstamos.

El sistema controla el stock de cada libro (baja al prestar y se repone al devolver), evita préstamos duplicados y valida todos los datos antes de guardarlos. El proyecto está organizado en capas (modelo, controladores y vistas) y sirve como ejemplo práctico de POO, validación de datos y construcción de interfaces con Swing.

## 🧩 Estructuras utilizadas

| Tipo | Sintaxis | Descripción |
|------|----------|-------------|
| Clase abstracta | `abstract class Usuario` | Define los datos y métodos comunes a todos los usuarios. |
| Herencia | `class Estudiante extends Usuario` | `Estudiante` y `Bibliotecario` especializan a la clase base. |
| Enumeraciones | `enum TipoRol` | Define los roles disponibles: `ADMIN` y `ESTUDIANTE`. |
| Sobreescritura | `@Override mostrarUsuario()` | `Estudiante` amplía la información del usuario con su curso. |
| Polimorfismo | `usuario instanceof Estudiante` | Las vistas y controladores deciden según el tipo real del usuario. |
| Colecciones | `ArrayList<Libro>` | Cada gestor guarda sus datos en listas en memoria. |
| Excepciones | `IllegalArgumentException` | Los controladores lanzan el error con un mensaje y la vista lo muestra. |
| Validación | `ValidadorDatos.rut(valor)` | Clase de utilidad con métodos estáticos que validan cada campo. |
| Expresiones regulares | `valor.matches("\\d{10}\|\\d{13}")` | Validan nombre, correo, RUT e ISBN. |
| Interfaz gráfica | `JFrame`, `JPanel`, `JTable`, `JDialog` | Ventanas, paneles, tablas y formularios emergentes. |
| Ventanas modales | `ModalityType.APPLICATION_MODAL` | Los formularios bloquean la ventana principal hasta cerrarse. |
| Cambio de pantalla | `CardLayout` | La ventana principal alterna entre Inicio, Libros, Estudiantes y Préstamos. |
| Modelo de tabla | `DefaultTableModel` | Los paneles llenan la tabla con los datos de los gestores. |
| Búsqueda en vivo | `DocumentListener` | Filtra la tabla con cada letra escrita en el buscador. |
| Renderizado personalizado | `DefaultListCellRenderer` | Muestra solo el nombre de la categoría, estudiante o libro en los combos. |
| Expresiones lambda | `btn.addActionListener(e -> guardar())` | Asocian cada botón con su acción. |
| Fecha | `LocalDate` | Registra y valida las fechas de préstamo y devolución. |

## 📂 Estructura del proyecto

```
BibliotecaGestion/
└── src/
    ├── app/
    │   └── Main.java                    # Punto de entrada: carga datos de prueba y abre el login
    ├── model/
    │   ├── Usuario.java                 # Clase abstracta base
    │   ├── Bibliotecario.java           # Usuario con rol ADMIN
    │   ├── Estudiante.java              # Usuario con rol ESTUDIANTE y curso
    │   ├── TipoRol.java                 # ADMIN, ESTUDIANTE
    │   ├── Libro.java                   # ISBN, título, autor, categoría y stock
    │   ├── Categoria.java               # Categoría de un libro
    │   └── Prestamo.java                # Relación estudiante - libro, con fechas y estado
    ├── controller/
    │   ├── GestorUsuarios.java          # Lógica de usuarios y autenticación
    │   ├── GestorLibros.java            # Lógica de libros y categorías
    │   ├── GestorPrestamos.java         # Lógica de préstamos, devoluciones y stock
    │   └── ValidadorDatos.java          # Validaciones de campos
    └── view/
        ├── VentanaLogin.java            # Inicio de sesión
        ├── VentanaMenuPrincipal.java    # Ventana con menú lateral
        ├── PanelPerfil.java             # Inicio: datos del usuario
        ├── PanelLibros.java             # Catálogo y gestión de libros
        ├── PanelEstudiantes.java        # Gestión de usuarios (solo ADMIN)
        ├── PanelPrestamos.java          # Gestión y consulta de préstamos
        ├── VentanaNuevoLibro.java       # Formulario: crear libro
        ├── VentanaEditarLibro.java      # Formulario: editar libro
        ├── VentanaNuevoUsuario.java     # Formulario: crear usuario
        ├── VentanaEditarUsuario.java    # Formulario: editar usuario
        ├── VentanaNuevoPrestamo.java    # Formulario: crear préstamo
        ├── VentanaEditarPrestamo.java   # Formulario: editar préstamo
        ├── VentanaEditarContrasena.java # Formulario: cambiar contraseña
        └── VentanaHistorial.java        # Historial de préstamos de un estudiante
```

## 🏗️ Capas

| Capa | Responsabilidad |
|------|-----------------|
| `app` | Arranca el sistema: crea los gestores, carga los datos de prueba y abre el login. |
| `model` | Entidades del sistema y sus datos. |
| `controller` | Lógica de negocio: crear, editar, eliminar, buscar y validar. |
| `view` | Interfaz gráfica: muestra tablas y botones, pide datos con formularios, llama a los gestores y muestra los mensajes de error o éxito. |

Cada vista recibe los gestores por constructor, de modo que **toda la aplicación comparte una única instancia** de cada uno.

## 💾 Datos

La aplicación **no usa base de datos**: los datos viven en listas (`ArrayList`) dentro de cada gestor y **se pierden al cerrar el programa**. Al iniciar, `Main` carga estos datos de prueba:

**Usuarios** (la contraseña de todos es `123456`):

| Rol | Nombre | Correo | Curso |
|-----|--------|--------|-------|
| Bibliotecario (ADMIN) | Claudio | claudio@correo.com | - |
| Estudiante | Ana | ana@correo.com | 3°A |
| Estudiante | Pedro Soto | pedro@correo.com | 1°A |
| Estudiante | Maria Rojas | maria@correo.com | 2°B |
| Estudiante | Juan Perez | juan@correo.com | 3°B |
| Estudiante | Camila Diaz | camila@correo.com | 4°A |
| Estudiante | Diego Muñoz | diego@correo.com | 4°B |

**Categorías:** Novela, Acción, Teatro, Ciencias e Historia.

**Libros:** 10 libros distribuidos en las categorías anteriores. No hay préstamos cargados al iniciar.

## ▶️ Funcionamiento

Al ejecutar `Main.java` se realizan las siguientes acciones en orden:

1. `Main` crea los gestores y carga los usuarios, categorías y libros de prueba.
2. `SwingUtilities.invokeLater()` crea y muestra la `VentanaLogin`.
3. Al ingresar un correo y contraseña válidos, el sistema muestra un mensaje de bienvenida y abre la `VentanaMenuPrincipal` según el rol del usuario. Si los datos son incorrectos, se muestra un error y se limpia la contraseña.
4. La ventana principal crea los paneles y los alterna con `CardLayout`. Siempre abre en **Inicio** (perfil del usuario). Los paneles de Libros, Estudiantes y Préstamos se recargan cada vez que se visitan.
5. Cada formulario valida los datos y llama al gestor correspondiente. Si el gestor lanza un error, se muestra el mensaje y el formulario permanece abierto para corregirlo.

**Reglas de negocio de los préstamos:**

| Acción | Efecto sobre el stock | Reglas |
|--------|-----------------------|--------|
| Crear préstamo | Baja 1 | El libro debe tener stock disponible y el estudiante no puede tener ese mismo libro en préstamo activo. |
| Registrar devolución | Sube 1 | Solo si el préstamo sigue activo. |
| Eliminar préstamo activo | Sube 1 | Se repone el stock al deshacer el préstamo. |
| Eliminar préstamo devuelto | Sin cambios | - |
| Editar préstamo | Sin cambios | Solo se modifica la fecha de devolución, y solo si el préstamo no fue devuelto. |

**Permisos por rol:**

| Sección | Bibliotecario (ADMIN) | Estudiante |
|---------|:---------------------:|:----------:|
| Inicio (perfil y cambio de contraseña) | ✔ | ✔ |
| Libros: consultar y buscar | ✔ | ✔ |
| Libros: crear, editar y eliminar | ✔ | |
| Estudiantes (usuarios) | ✔ | |
| Préstamos: consultar y buscar | Todos | Solo los propios |
| Préstamos: crear, editar, eliminar y devolver | ✔ | |

## 📖 Manual de usuario

### Requisitos

- **Java JDK 8 o superior.**
- Un IDE con soporte para Java (IntelliJ IDEA, Eclipse o NetBeans).

No requiere librerías externas ni base de datos.

### Cómo ejecutar

Abrir el proyecto en el IDE y ejecutar la clase `app.Main`. Se abre la ventana de **Login**.

### Inicio de sesión

Ingrese el correo y la contraseña de un usuario (por ejemplo `claudio@correo.com` / `123456` para el bibliotecario, o `ana@correo.com` / `123456` para un estudiante) y presione **Ingresar**. El botón **Salir** cierra la aplicación.

### Ventana principal

Al iniciar sesión aparece la ventana **Biblioteca Escolar - Sistema de Gestion**, con un menú lateral y el panel de Inicio abierto:

| Botón | Qué hace |
|-------|----------|
| Inicio | Muestra los datos del usuario que inició sesión. |
| Libros | Abre el catálogo de libros. |
| Estudiantes | Abre la gestión de usuarios (solo el bibliotecario). |
| Prestamos | Abre la gestión de préstamos (el estudiante ve solo los suyos). |
| Cerrar Sesion | Pide confirmación y vuelve al login. |

Los botones **Editar**, **Eliminar**, **Ver historial** y **Registrar devolucion** permanecen deshabilitados hasta que se selecciona una fila. El botón **Actualizar** vuelve a cargar la tabla.

**Reglas de los campos** (se validan antes de guardar):

- **Nombre:** entre 2 y 50 caracteres; solo letras (con tildes y ñ), espacios, apóstrofes y guiones.
- **Correo:** formato válido (`usuario@dominio.com`) y no repetido.
- **RUT:** formato `12345678-5`, con o sin puntos, y no repetido.
- **Contraseña:** mínimo 6 caracteres.
- **Curso:** obligatorio para estudiantes.
- **ISBN:** 10 o 13 dígitos (se aceptan guiones) y no repetido.
- **Título y Autor:** obligatorios.
- **Categoría:** debe seleccionarse una.
- **Stock:** número entero igual o mayor que 0.
- **Fecha de devolución:** formato `AAAA-MM-DD`, no anterior a la fecha del préstamo.

### 1. Inicio y perfil

Muestra el ID, nombre, RUT, correo, rol y (si es estudiante) el curso del usuario.

- **Cambiar Contraseña:** pide la contraseña antigua, la nueva y su confirmación.
- **Editar datos:** funcionalidad pendiente; muestra el aviso *Próximamente*.

### 2. Gestionar libros

1. Presione **Libros** en el menú lateral.
2. Use **Buscar** para filtrar en vivo por ISBN, título, autor o categoría.
3. Use **Ver** para ordenar el catálogo: *Todos*, *Mas prestados* o *Menos prestados*.
4. Solo el bibliotecario ve los botones de gestión:
   - **Nuevo:** ingrese ISBN, título, autor, categoría y stock.
   - **Editar:** seleccione la fila. El ISBN no se puede modificar.
   - **Eliminar:** pide confirmación. No se puede eliminar un libro con préstamos activos.

### 3. Gestionar estudiantes (solo bibliotecario)

1. Presione **Estudiantes** en el menú lateral. La tabla lista todos los usuarios con su rol y curso.
2. **Nuevo:** elija el rol (Estudiante por defecto) e ingrese nombre, RUT, correo, contraseña y curso. El curso solo aplica a estudiantes.
3. **Editar:** seleccione la fila. El ID y el rol no se pueden modificar.
4. **Ver historial:** abre una ventana con todos los préstamos del usuario seleccionado.
5. **Eliminar:** pide confirmación. No se puede eliminar la cuenta con la que se inició sesión ni un usuario con préstamos activos.

### 4. Gestionar préstamos

1. Presione **Prestamos** en el menú lateral. El bibliotecario ve todos los préstamos; el estudiante, solo los suyos.
2. Use **Buscar** para filtrar por nombre del estudiante o título del libro, y **Ver** para mostrar *Todos* o solo los *En prestamo actualmente*.
3. El bibliotecario cuenta además con estos botones:
   - **Nuevo:** elija estudiante y libro. La fecha de préstamo es la de hoy y la de devolución sugerida es a 7 días (editable). Requiere que exista al menos un estudiante y un libro.
   - **Editar:** permite cambiar la fecha de devolución de un préstamo activo.
   - **Registrar devolucion:** disponible solo para préstamos activos; repone el stock del libro.
   - **Eliminar:** pide confirmación; si el préstamo estaba activo, repone el stock.

## ⚠️ Limitaciones

- Los datos no se guardan: al cerrar la aplicación se pierden y vuelven los datos de prueba.
- Las contraseñas se almacenan en texto plano.
- El RUT se valida por formato, no por dígito verificador.
- La edición de datos desde el perfil aún no está implementada.
