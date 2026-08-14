
# Sistema de Gestión de Usuarios - Herencia y Polimorfismo

Sistema de registro desarrollado en Java que modela distintos tipos de usuarios (adultos, adultos mayores, estudiantes y bibliotecarios) mediante clases organizadas en paquetes, aplicando herencia, encapsulamiento y sobreescritura (override) de métodos para la presentación de la información de cada persona.

## 📋 Descripción

- Separación del código en `package model` (clases de dominio) y `package ui` (clase de ejecución).
- Clase base `Persona` con atributos encapsulados mediante modificador `private` y expuestos a través de métodos `getter`/`setter`.
- Herencia mediante `extends` de `Adulto`, `AdultoMayor`, `Estudiante` y `Bibliotecario` respecto de `Persona`.
- Uso de `super()` en los constructores de las subclases para inicializar los atributos heredados (`nombre`, `edad`, `idPersona`).
- Atributos propios y encapsulados en cada subclase (`ocupacion` en `Adulto` y `AdultoMayor`, `institucion`/`periodoEstudio` en `Estudiante`, `rol` en `Bibliotecario`).
- Sobreescritura (`@Override`) del método `mostrarInfo()`, definido originalmente en `Persona`, en cada una de las subclases, redefiniendo el comportamiento heredado según el tipo concreto de usuario.
- Uso de atributos propios (como `rol`) dentro de los métodos sobreescritos para enriquecer la información mostrada según la clase específica.
- Arreglo polimórfico de tipo `Persona[]` que almacena instancias de las distintas subclases bajo el tipo de la superclase común.
- Recorrido con `for-each` que invoca el método sobreescrito `mostrarInfo()` sobre cada elemento del arreglo, dejando que la resolución del comportamiento ocurra en tiempo de ejecución.

## 📂 Estructura del proyecto
```
sistema-usuarios/
├── .idea/
├── src/
│   ├── model/
│   │   ├── Persona.java             # Clase base: atributos comunes y mostrarInfo() genérico
│   │   ├── Adulto.java              # extends Persona; sobreescribe mostrarInfo() agregando rol y ocupación
│   │   ├── AdultoMayor.java         # extends Persona; sobreescribe mostrarInfo() agregando rol y ocupación
│   │   ├── Estudiante.java          # extends Persona; sobreescribe mostrarInfo() agregando institución y periodo de estudio
│   │   └── Bibliotecario.java       # extends Persona; sobreescribe mostrarInfo() agregando rol de administrador
│   └── ui/
│       └── Main.java                # Clase principal: crea las personas y recorre el arreglo polimórfico Persona[]
└── .gitignore
```

## ▶️ Funcionamiento

Al ejecutar el programa se realizan las siguientes acciones:

1. Se crean seis objetos: dos de tipo `Persona` (`p1`, `p2`) y cuatro de las subclases `Bibliotecario`, `Estudiante`, `Adulto` y `AdultoMayor` (`p3`, `p4`, `p5`, `p6`), cada uno con sus atributos particulares inicializados a través de `super()` y de su propio constructor.
2. Los seis objetos se agrupan en un arreglo de tipo `Persona[]`, que almacena referencias de distintas subclases bajo el tipo de la superclase común.
3. Se recorre el arreglo con `for-each`, y para cada elemento se invoca `mostrarInfo()`.
4. La JVM resuelve en tiempo de ejecución la versión sobreescrita correspondiente al tipo real del objeto: `Persona` ejecuta la versión genérica, `Bibliotecario` muestra su rol de administrador, `Estudiante` muestra su institución y periodo de estudio, y `Adulto`/`AdultoMayor` muestran su rol y ocupación — un ejemplo de polimorfismo por sobreescritura.
5. El resultado observable es una secuencia de mensajes por consola donde el mismo llamado (`mostrarInfo()`) produce una salida distinta según el tipo real de cada objeto, evidenciando cómo la sobreescritura resuelve el comportamiento en tiempo de ejecución mientras la firma del método sigue definida en tiempo de compilación.

## 🚀 Cómo clonarlo y ejecutarlo en IntelliJ

1. Clona el repositorio con el siguiente comando:
   ```
   git clone <URL-del-repositorio>
   ```
2. Abre IntelliJ IDEA y selecciona `File > Open`, luego elige la carpeta del proyecto que acabas de clonar.
3. IntelliJ detectará la estructura del proyecto y reconocerá los paquetes `model` y `ui` automáticamente.
4. En el panel de la izquierda, navega hasta `src/ui/Main.java`.
5. Haz clic derecho sobre el archivo `Main.java` y selecciona `Run 'Main.main()'` (o usa el botón ▶️ que aparece junto al método `main`).
6. La consola de IntelliJ mostrará la salida del programa con los datos de cada persona registrada en el sistema.

El ejercicio muestra cómo la herencia y la sobreescritura permiten que un mismo método se comporte de manera distinta según el tipo real del objeto. La clase `Persona` define un método `mostrarInfo()` genérico, y cada subclase (`Adulto`, `AdultoMayor`, `Estudiante`, `Bibliotecario`) lo redefine agregando la información particular de su tipo de usuario. Así, cuando se recorre el arreglo `Persona[]` y se invoca `mostrarInfo()` sobre cada elemento, Java ejecuta en tiempo de ejecución la versión correspondiente al tipo real del objeto y no la de la superclase, evidenciando el polimorfismo dinámico propio de la sobreescritura de métodos.
