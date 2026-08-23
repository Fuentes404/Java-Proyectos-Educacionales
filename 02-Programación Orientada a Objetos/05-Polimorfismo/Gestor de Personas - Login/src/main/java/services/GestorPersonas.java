package service;

import model.Persona;
import model.Profesor;
import model.Estudiante;

import java.util.ArrayList;
import java.util.List;

public class GestorPersonas {

    // Lista que guarda todas las personas creadas (estudiantes y profesores)
    // Se usa el tipo Persona porque tanto Estudiante como Profesor heredan de ella (polimorfismo)
    private List<Persona> personas = new ArrayList<>();

    // Crea un nuevo estudiante con los datos recibidos, lo guarda en la lista y lo retorna
    public Estudiante crearEstudiante(String nombre, int edad, String grado) {
        Estudiante e = new Estudiante(nombre, edad, grado);
        personas.add(e);
        return e;
    }

    // Crea un nuevo profesor con los datos recibidos, lo guarda en la lista y lo retorna
    public Profesor crearProfesor(String nombre, int edad, String asignatura) {
        Profesor p = new Profesor(nombre, edad, asignatura);
        personas.add(p);
        return p;
    }

    // Recorre la lista de personas y muestra la información de cada una
    // Gracias al polimorfismo, cada objeto llama a su propia versión de mostrarInfo()
    public void mostrarTodas() {
        if (personas.isEmpty()) {
            System.out.println("No hay personas registradas.");
            return;
        }
        for (Persona p : personas) {
            p.mostrarInfo();
            System.out.println("----------------------");
        }
    }

    // Retorna la lista completa de personas
    public List<Persona> getPersonas() {
        return personas;
    }
}