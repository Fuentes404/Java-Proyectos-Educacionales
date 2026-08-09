package model;

public class Curso {
    // Atributos
    private String nombreCurso;
    private Estudiante[] estudiantes;

    // Constructor
    public Curso(String nombreCurso, Estudiante[] estudiantes) {
        this.nombreCurso = nombreCurso;
        this.estudiantes = estudiantes;
    }

    // Métodos Getter y Setter
    public String getNombreCurso() {
        return nombreCurso;
    }
    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }
    public Estudiante[] getEstudiantes() {
        return estudiantes;
    }
    public void setEstudiantes(Estudiante[] estudiantes) {
        this.estudiantes = estudiantes;
    }

    // Método mostrar información
    public void mostrarInfo() {
        System.out.println("Datos Curso: " + getNombreCurso());
        for (Estudiante e : getEstudiantes()) {
            e.mostrarInfo();
        }
    }
}