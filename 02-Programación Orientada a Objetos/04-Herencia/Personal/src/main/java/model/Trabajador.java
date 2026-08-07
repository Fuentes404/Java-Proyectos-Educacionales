package model;

public class Trabajador extends Persona{
    // Atributos
    private String idTrabajador;

    // Constructor
    public Trabajador(String nombre, int edad, String rut, String idCliente) {
        super(nombre, edad, rut);
        this.idTrabajador = idCliente;
    }

    // Getter and Setter
    public String getIdTrabajador() {
        return idTrabajador;
    }
    public void setIdTrabajador(String idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    // Metodo que muestra el id del Trabajador
    public void mostrarIdTrabajador() {
        System.out.println("Id Trabajador: " + idTrabajador);
    }
}
