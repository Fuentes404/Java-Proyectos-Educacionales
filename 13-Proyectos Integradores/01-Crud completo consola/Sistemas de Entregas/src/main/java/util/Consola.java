package util;

import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

// Utilidades para leer datos y mostrar informacion por consola
public class Consola {

    // Lector unico para toda la aplicacion
    private static final Scanner scanner = new Scanner(System.in);

    // Clase de utilidad: no se instancia
    private Consola() {
    }

    // ---------- Mensajes ----------

    // Muestra un titulo de seccion
    public static void titulo(String texto) {
        System.out.println();
        System.out.println("=== " + texto + " ===");
    }

    // Muestra un texto normal
    public static void mensaje(String texto) {
        System.out.println(texto);
    }

    // Muestra un aviso o error
    public static void aviso(String texto) {
        System.out.println("[!] " + texto);
    }

    // Muestra una confirmacion de exito
    public static void exito(String texto) {
        System.out.println("[OK] " + texto);
    }

    // ---------- Lectura ----------

    // Lee una linea de texto, si se cierra la entrada termina el programa
    public static String leerLinea(String prompt) {
        System.out.print(prompt);
        if (!scanner.hasNextLine()) {
            System.out.println();
            System.exit(0);
        }
        return scanner.nextLine().trim();
    }

    // Lee una opcion numerica dentro de un rango, repite hasta que sea valida
    public static int leerOpcion(String prompt, int minimo, int maximo) {
        while (true) {
            String entrada = leerLinea(prompt);
            try {
                int opcion = Integer.parseInt(entrada);
                if (opcion >= minimo && opcion <= maximo) {
                    return opcion;
                }
            } catch (NumberFormatException e) {
                // Se ignora: se muestra el aviso de abajo
            }
            aviso("Opción no válida. Ingrese un número entre " + minimo + " y " + maximo + ".");
        }
    }

    // Lee un campo y lo valida, repite hasta que sea valido
    // Si hay un valor actual, presionar Enter lo mantiene
    public static String leerCampo(String etiqueta, Function<String, String> validador, String actual) {
        while (true) {
            String prompt = (actual == null) ? etiqueta + ": " : etiqueta + " [" + actual + "]: ";
            String entrada = leerLinea(prompt);

            // Enter sin texto conserva el valor actual
            if (entrada.isEmpty() && actual != null) {
                return actual;
            }

            String error = validador.apply(entrada);
            if (error == null) {
                return entrada;
            }
            aviso(error);
        }
    }

    // Lee un campo nuevo, sin valor actual
    public static String leerCampo(String etiqueta, Function<String, String> validador) {
        return leerCampo(etiqueta, validador, null);
    }

    // Lee un numero entero, por ejemplo un ID
    public static int leerEntero(String etiqueta) {
        String valor = leerCampo(etiqueta, v -> ValidadorDatos.validarEntero(v, etiqueta));
        return Integer.parseInt(valor);
    }

    // Pregunta si/no, devuelve true si responde s
    public static boolean confirmar(String pregunta) {
        while (true) {
            String respuesta = leerLinea(pregunta + " (s/n): ").toLowerCase();
            if (respuesta.equals("s")) {
                return true;
            }
            if (respuesta.equals("n")) {
                return false;
            }
            aviso("Responda s o n.");
        }
    }

    // ---------- Tablas ----------

    // Imprime una tabla con columnas alineadas, los valores null se muestran como "-"
    public static void imprimirTabla(String[] columnas, List<Object[]> filas) {
        if (filas.isEmpty()) {
            mensaje(ValidadorDatos.SIN_ENTIDADES);
            return;
        }

        // Ancho de cada columna segun su contenido mas largo
        int[] anchos = new int[columnas.length];
        for (int i = 0; i < columnas.length; i++) {
            anchos[i] = columnas[i].length();
        }
        for (Object[] fila : filas) {
            for (int i = 0; i < fila.length; i++) {
                anchos[i] = Math.max(anchos[i], texto(fila[i]).length());
            }
        }

        // Encabezado, separador y filas
        imprimirFila(columnas, anchos);
        int total = 3 * (columnas.length - 1);
        for (int ancho : anchos) {
            total += ancho;
        }
        System.out.println(new String(new char[total]).replace('\0', '-'));
        for (Object[] fila : filas) {
            imprimirFila(fila, anchos);
        }
    }

    // Imprime una fila de la tabla
    private static void imprimirFila(Object[] fila, int[] anchos) {
        StringBuilder linea = new StringBuilder();
        for (int i = 0; i < fila.length; i++) {
            linea.append(String.format("%-" + anchos[i] + "s", texto(fila[i])));
            if (i < fila.length - 1) {
                linea.append(" | ");
            }
        }
        System.out.println(linea);
    }

    // Convierte un valor a texto, "-" si es null
    private static String texto(Object valor) {
        return valor == null ? "-" : valor.toString();
    }
}