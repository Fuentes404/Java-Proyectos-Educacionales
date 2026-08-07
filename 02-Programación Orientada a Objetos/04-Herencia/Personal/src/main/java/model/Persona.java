package model;

public class Persona {
    // Atributos
    private String nombre;
    private int edad;
    private String rut;

    // Constructor
    public Persona(String nombre, int edad, String rut) {
        this.nombre = nombre;
        this.edad = edad;
        this.rut = rut;
    }

    // Principio de encapsulamiento
    // Getters and Setters
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
    public String getRut() {
        return rut;
    }
    public void setRut(String rut) {
        this.rut = rut;
    }

    // Metodo mostrar informacion
    public void mostrarInfo() {
        System.out.println("Datos: " + nombre + " | Edad: " + edad + " | Rut: " + rut);
    }

}
