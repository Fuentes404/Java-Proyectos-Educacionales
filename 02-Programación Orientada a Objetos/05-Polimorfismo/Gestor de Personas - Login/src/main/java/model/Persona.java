package model;

public class Persona {
    // Atributo
    private String nombre;
    private int edad;
    protected String rol;

    // Constructor
    public Persona(String nombre, int edad, String rol) {
        this.nombre = nombre;
        this.edad = edad;
        this.rol = rol;
    }

    // Metodos Getter and Setter
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    public String getRol() { return rol; }

    // Metodo Mostrar Informacion
    public void mostrarInfo() {
        System.out.println("Datos Generales: " +
                "\nNombre: " + getNombre() +
                "\nEdad: " + getEdad() +
                "\nRol: " + getRol());
    }
}