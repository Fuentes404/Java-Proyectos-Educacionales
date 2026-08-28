package services;

import model.Estudiante;
import java.util.ArrayList;

public class GestorEstudiantes {

    // ArrayList contenedor del Registro de Estudiantes
    ArrayList<Estudiante> registro = new ArrayList<>();

    // Metodo que crea un estudiante en el Registro
    public void crearEstudiante(String nombre, int edad, String curso, String colegio) {
        Estudiante nuevo = new Estudiante(nombre, edad, curso, colegio);
        registro.add(nuevo);
        System.out.println("Estudiante creado con exito.");
    }

    // Metodo que elimina un estudiante del Registro
    public void eliminarEstudiante(String nombre) {
        Estudiante encontrado = null;

        for (Estudiante e : registro) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                encontrado = e;
                break;
            }
        }

        if (encontrado != null) {
            registro.remove(encontrado);
            System.out.println("Estudiante eliminado con exito.");
        } else {
            System.out.println("No se encontro un estudiante con ese nombre.");
        }
    }

    // Metodo para ver los Estudiantes Registrados
    public void verEstudiantes() {
        if (registro.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        for (Estudiante e : registro) {
            e.mostrarInfo();
            System.out.println();
        }
    }

}