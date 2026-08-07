package model;

public class Cliente extends Persona{
    // Atributos
    private String idCliente;

    // Construtor
    public Cliente(String nombre, int edad, String rut, String idCliente) {
        super(nombre, edad, rut);
        this.idCliente = idCliente;
    }

    // Getter and Setter
    public String getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    // Metodo que muestra el id del Cliente
    public void mostrarIdCliente() {
        System.out.println("Id Cliente: " + idCliente);
    }
}
