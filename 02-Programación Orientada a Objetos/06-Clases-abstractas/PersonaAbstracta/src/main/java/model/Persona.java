package model;

public abstract class Persona {
    // Atributos
    private String nombre;
    private int edad;

    // Constructor
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Getter and Setter
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

    // Metodo abstracto: cada subclase DEBE implementarlo
    // Todo metodo abstracto debe pertenecer a una clase abstracta
    // Todo metodo abstracto pone como condicion implementarlo en las clases hijas
    public abstract void mostrarInfo();

    // Metodo toString
    @Override
    public String toString() {
        return "Persona: " + "Nombre='" + getNombre() + '\'' + ", Edad=" + getEdad();
    }

}