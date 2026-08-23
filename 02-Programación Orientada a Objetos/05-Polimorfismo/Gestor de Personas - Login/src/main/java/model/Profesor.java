package model;

public class Profesor extends Persona {
    // Atributos
    private String asignatura;

    // Constructor
    public Profesor(String nombre, int edad, String asignatura) {
        super(nombre, edad, "Admin"); // el rol lo decide la clase, no quien la crea
        this.asignatura = asignatura;
    }

    // Metodo getter and Setter
    public String getAsignatura() { return asignatura; }
    public void setAsignatura(String asignatura) { this.asignatura = asignatura; }

    // Metodo mostrar informacion
    @Override
    public void mostrarInfo() {
        System.out.println("Datos del Profesor: " +
                "\nNombre: " + getNombre() +
                "\nEdad: " + getEdad() +
                "\nAsignatura: " + getAsignatura() +
                "\nRol: " + getRol());
    }
}