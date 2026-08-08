package model;

public class Proveedor extends Persona {
    // Atributos
    private String idProveedor;
    private String rol = "Proveedor";

    // Constructor
    public Proveedor(String nombre, int edad, String idProveedor) {
        super(nombre, edad);
        this.idProveedor = idProveedor;
    }

    // Getter y Setter propios de Proveedor
    public String getIdProveedor() {
        return idProveedor;
    }
    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    // Mostrar Rol
    public void mostrarRol() {
        System.out.println("Rol: " + rol);
    }

    @Override
    // Metodo mostrar informacion
    public void mostrarInfo() {
        System.out.println("Informacion Proveedor: " + getNombre() + " | Edad: " + getEdad() + " | Id Proveedor: " + getIdProveedor());
    }

    // Metodo toString
    @Override
    public String toString() {
        return "Proveedor: " + "Nombre='" + getNombre() + '\'' + ", Edad=" + getEdad() + ", Id=" + getIdProveedor();
    }

}