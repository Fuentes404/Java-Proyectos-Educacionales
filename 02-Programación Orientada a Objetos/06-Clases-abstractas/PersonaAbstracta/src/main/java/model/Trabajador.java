package model;

public class Trabajador extends Persona {
    // Atributos
    private String idTrabajador;
    private String rol = "Trabajador";

    // Constructor
    public Trabajador(String nombre, int edad, String idTrabajador) {
        super(nombre, edad);
        this.idTrabajador = idTrabajador;
    }

    // Getter y Setter propios de Trabajador
    public String getIdTrabajador() {
        return idTrabajador;
    }
    public void setIdTrabajador(String idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    // Mostrar Rol
    public void mostrarRol() {
        System.out.println("Rol: " + rol);
    }

    @Override
    // Metodo mostrar informacion
    public void mostrarInfo() {
        System.out.println("Informacion Trabajador: " + getNombre() + " | Edad: " + getEdad() + " | Id Trabajador: " + getIdTrabajador());
    }

    // Metodo toString
    @Override
    public String toString() {
        return "Trabajador: " + "Nombre='" + getNombre() + '\'' + ", Edad=" + getEdad() + ", Id=" + getIdTrabajador();
    }

}