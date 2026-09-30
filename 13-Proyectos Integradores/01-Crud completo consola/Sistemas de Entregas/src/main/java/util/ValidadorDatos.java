package util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Collection;

// Aca se realizan las validaciones de campos
// Cada metodo devuelve el mensaje de error, o null si el dato es valido
public class ValidadorDatos {

    // Mensaje que se muestra cuando una lista no tiene elementos
    public static final String SIN_ENTIDADES = "No existen entidades creadas.";

    // Solo letras (con tildes y ñ) y espacios
    private static final String PATRON_NOMBRE = "^[\\p{L}]+( [\\p{L}]+)*$";

    // Digitos con parte decimal opcional, separada por punto o coma
    private static final String PATRON_NUMERO = "^\\d+([.,]\\d+)?$";

    // Numero entero de hasta 9 digitos (cabe en un int)
    private static final String PATRON_ENTERO = "^\\d{1,9}$";

    // Clase de utilidad: no se instancia
    private ValidadorDatos() {
    }

    // ---------- Listas ----------

    // Revisa que la lista tenga elementos
    public static String validarLista(Collection<?> lista) {
        if (lista == null || lista.isEmpty()) {
            return SIN_ENTIDADES;
        }
        return null;
    }

    // ---------- Campos de texto ----------

    // Revisa que el texto no sea nulo, vacio ni solo espacios
    public static String validarTextoObligatorio(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            return "El campo " + campo + " no puede estar vacío.";
        }
        return null;
    }

    // Revisa que el texto no este vacio y tenga solo letras y espacios
    public static String validarNombre(String valor, String campo) {
        String error = validarTextoObligatorio(valor, campo);
        if (error != null) {
            return error;
        }
        if (!valor.trim().matches(PATRON_NOMBRE)) {
            return "El campo " + campo + " solo puede contener letras y espacios.";
        }
        return null;
    }

    // ---------- Campos numericos ----------

    // Revisa que el texto sea un numero entero (por ejemplo un ID)
    public static String validarEntero(String valor, String campo) {
        String error = validarTextoObligatorio(valor, campo);
        if (error != null) {
            return error;
        }
        if (!valor.trim().matches(PATRON_ENTERO)) {
            return "El campo " + campo + " debe ser un número entero.";
        }
        return null;
    }

    // Revisa que el texto sea un numero mayor que 0, acepta punto o coma decimal
    public static String validarNumeroPositivo(String valor, String campo) {
        String error = validarTextoObligatorio(valor, campo);
        if (error != null) {
            return error;
        }

        String texto = valor.trim();
        if (!texto.matches(PATRON_NUMERO)) {
            return "El campo " + campo + " debe ser un número (ejemplo: 2,5 o 2.5).";
        }

        double numero = convertirADecimal(texto);
        // Un numero con demasiados digitos puede convertirse en infinito
        if (Double.isInfinite(numero) || Double.isNaN(numero)) {
            return "El campo " + campo + " tiene un valor no válido.";
        }
        if (numero <= 0) {
            return "El campo " + campo + " debe ser mayor que 0.";
        }
        return null;
    }

    // Convierte el texto a double aceptando coma o punto, usar solo despues de validar
    public static double convertirADecimal(String valor) {
        return Double.parseDouble(valor.trim().replace(',', '.'));
    }

    // ---------- Fecha y hora ----------

    // Revisa que la fecha tenga formato AAAA-MM-DD y no sea anterior a hoy
    public static String validarFecha(String valor) {
        String error = validarTextoObligatorio(valor, "Fecha");
        if (error != null) {
            return error;
        }
        try {
            LocalDate fecha = LocalDate.parse(valor.trim());
            if (fecha.isBefore(LocalDate.now())) {
                return "La fecha no puede ser anterior a hoy.";
            }
        } catch (DateTimeParseException e) {
            return "La fecha debe tener el formato AAAA-MM-DD (ejemplo: 2026-09-29).";
        }
        return null;
    }

    // Revisa que la hora tenga formato HH:mm
    public static String validarHora(String valor) {
        String error = validarTextoObligatorio(valor, "Hora");
        if (error != null) {
            return error;
        }
        try {
            LocalTime.parse(valor.trim());
        } catch (DateTimeParseException e) {
            return "La hora debe tener el formato HH:mm (ejemplo: 14:30).";
        }
        return null;
    }
}