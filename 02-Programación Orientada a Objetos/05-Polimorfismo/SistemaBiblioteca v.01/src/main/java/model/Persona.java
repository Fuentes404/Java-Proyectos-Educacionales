package model;

public class Persona {
    // Atributos
    private String nombre;
    private int edad;
    private int idPersona;

    // Constructor
    public Persona(String nombre, int edad, int idPersona) {
        this.nombre = nombre;
        this.edad = edad;
        this.idPersona = idPersona;
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
    public int getIdPersona() {
        return idPersona;
    }
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    // Metodo Mostrar Informacion
    public void mostrarInfo() {
        System.out.println("Datos Persona: " +
                "\nNombre: " + getNombre() +
                "\nEdad : " + getEdad() +
                "\nId Persona: " + getIdPersona());
    }
}
