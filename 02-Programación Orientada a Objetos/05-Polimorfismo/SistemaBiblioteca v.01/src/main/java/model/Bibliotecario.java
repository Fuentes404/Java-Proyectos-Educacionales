package model;

public class Bibliotecario extends Persona{
    // Atributos
    private String rol = "Admin";

    // Constructor
    public Bibliotecario(String nombre, int edad, int idPersona) {
        super(nombre, edad, idPersona);
    }

    // Metodo Getter
    public String getRol() {
        return rol;
    }

    // Metodo mostrar Informacion
    public void mostrarInfo() {
        System.out.println("Datos Bibliotecario: " +
                "\nNombre: " + getNombre() +
                "\nEdad : " + getEdad() +
                "\nId Persona: " + getIdPersona() +
                "\nRol: " + getRol());
    }
}
