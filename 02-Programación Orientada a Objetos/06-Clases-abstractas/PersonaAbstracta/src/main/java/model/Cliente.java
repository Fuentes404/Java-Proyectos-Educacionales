package model;

public class Cliente extends Persona {
    // Atributos
    private String idCliente;
    private String rol = "Cliente";

    // Constructor
    public Cliente(String nombre, int edad, String idCliente) {
        super(nombre, edad);
        this.idCliente = idCliente;
    }

    // Getter y Setter propios de Cliente
    public String getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    // Mostrar Rol
    public void mostrarRol() {
        System.out.println("Rol: " + rol);
    }

    @Override
    // Metodo mostrar informacion
    public void mostrarInfo() {
        System.out.println("Informacion Cliente: " + getNombre() + " | Edad: " + getEdad() + " | Id Cliente: " + getIdCliente());
    }

    // Metodo toString
    @Override
    public String toString() {
        return "Cliente: " + "Nombre='" + getNombre() + '\'' + ", Edad=" + getEdad() + ", Id=" + getIdCliente();
    }

}