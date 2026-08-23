package model;

public class Estudiante extends Persona {
    // Atributos
    private String grado;

    // Constructor
    public Estudiante(String nombre, int edad, String grado) {
        super(nombre, edad, "Usuario");
        this.grado = grado;
    }

    // Metodo Getter and Setter
    public String getGrado() { return grado; }
    public void setGrado(String grado) { this.grado = grado; }

    // Metodo mostrar informacion
    @Override
    public void mostrarInfo() {
        System.out.println("Datos del Estudiante: " +
                "\nNombre: " + getNombre() +
                "\nEdad: " + getEdad() +
                "\nGrado: " + getGrado() +
                "\nRol: " + getRol());
    }
}