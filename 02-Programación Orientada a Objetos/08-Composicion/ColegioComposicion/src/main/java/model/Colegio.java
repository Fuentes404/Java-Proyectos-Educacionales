package model;

public class Colegio {
    // Atributos
    private String nombreColegio;
    private Curso[] cursos;

    // Constructor
    public Colegio(String nombreColegio, Curso[] cursos) {
        this.nombreColegio = nombreColegio;
        this.cursos = cursos;
    }

    // Metodo Getter and Setters
    public String getNombreColegio() {
        return nombreColegio;
    }
    public void setNombreColegio(String nombreColegio) {
        this.nombreColegio = nombreColegio;
    }
    public Curso[] getCursos() {
        return cursos;
    }
    public void setCursos(Curso[] cursos) {
        this.cursos = cursos;
    }

    // Metodo mostrar Informacion
    public void mostrarInfo() {
        System.out.println("Datos Colegio: " + getNombreColegio());
        for (Curso c : getCursos()) {
            c.mostrarInfo();
        }
    }

}
