package model;

public class Estudiante {
    // Atributos
    private String nombre;
    private int edad;
    private String curso;
    private String colegio;

    // Constructor
    public Estudiante(String nombre, int edad, String curso, String colegio) {
        this.nombre = nombre;
        this.edad = edad;
        this.curso = curso;
        this.colegio = colegio;
    }

    // Metodos Getter and Setter
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public String getColegio() {
        return colegio;
    }
    public void setColegio(String colegio) {
        this.colegio = colegio;
    }

    // Metodo mostrar informacion
    public void mostrarInfo() {
        System.out.println("---- Datos del estudiante ----" +
                "\nNombre: " + getNombre() +
                "\nEdad: " + getEdad() +
                "\nCurso: " + getCurso() +
                "\nColegio: " + getColegio());
    }



}
