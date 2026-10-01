package dao;

// Considerar: importar las funciones de Java que permiten conectar con la BD.

// - Función: Abre y entrega la conexión con la base de datos. No realiza operaciones sobre los datos.
// Considerar: es la única clase que conoce los datos de conexión.
// Considerar: las operaciones sobre los datos van en los DAO (Ej: ObjetoDAO).
public class ConexionBD {

    // — Conexión a Base de datos o fuente de datos: dónde y cómo conectarse
    // Ej: dirección, usuario y clave.
    // Considerar: no dejar claves escritas en el código si se sube a un repositorio.
    // Considerar: si se usa un archivo en vez de BD, aquí va su ruta.

    // — Constructor: prepara la conexión

    // — Métodos de conexión: abrir, entregar y cerrar la conexión
    // Ej: obtenerConexion(), cerrarConexion().

    // — Métodos Auxiliares: apoyo interno
    // Ej: comprobar si la conexión sigue abierta.

}

// ! En caso de incorporar una Base de datos debes agregar esta dependencia ¡
// En el archivo pom.xml entre: </properties> y </project>
// <dependencies>
//    <dependency>
//        <groupId>com.mysql</groupId>
//        <artifactId>mysql-connector-j</artifactId>
//        <version>9.0.0</version>
//    </dependency>
// </dependencies>