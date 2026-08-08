package model;

public class Persona {
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

    // Metodo mostrar informacion
    public void mostrarInfo() {
        System.out.println("Informacion Persona: " + getNombre() + " | Edad: " + getEdad());
    }

    // Metodo toString
    @Override
    public String toString() {
        return "Persona: " + "Nombre='" + getNombre() + '\'' + ", Edad=" + getEdad();
    }

}