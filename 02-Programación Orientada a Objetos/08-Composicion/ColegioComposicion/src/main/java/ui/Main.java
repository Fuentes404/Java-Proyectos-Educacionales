package ui;

import model.Estudiante;
import model.Curso;
import model.Colegio;

public class Main {
    public static void main(String[] args) {

        // Crear estudiantes para el Curso 1
        Estudiante[] estudiantesCurso1 = new Estudiante[3];
        estudiantesCurso1[0] = new Estudiante("Ana Torres", 4.5);
        estudiantesCurso1[1] = new Estudiante("Luis Pérez", 3.8);
        estudiantesCurso1[2] = new Estudiante("Marta Gómez", 4.9);

        // Crear estudiantes para el Curso 2
        Estudiante[] estudiantesCurso2 = new Estudiante[2];
        estudiantesCurso2[0] = new Estudiante("Carlos Ruiz", 3.2);
        estudiantesCurso2[1] = new Estudiante("Elena Díaz", 4.1);

        // Crear cursos
        Curso curso1 = new Curso("Matemáticas", estudiantesCurso1);
        Curso curso2 = new Curso("Historia", estudiantesCurso2);

        // Agrupar cursos en un arreglo
        Curso[] cursos = new Curso[2];
        cursos[0] = curso1;
        cursos[1] = curso2;

        // Crear colegio
        Colegio colegio = new Colegio("Colegio San José", cursos);

        // Mostrar toda la información
        colegio.mostrarInfo();
    }
}