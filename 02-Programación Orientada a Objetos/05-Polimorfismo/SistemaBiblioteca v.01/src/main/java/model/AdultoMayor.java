package model;

public class AdultoMayor extends Persona {
    // Atributos
    private String rol = "Adulto Mayor";
    private String ocupacion;

    // Constructor
    public AdultoMayor(String nombre, int edad, int idPersona, String ocupacion) {
        super(nombre, edad, idPersona);
        this.ocupacion = ocupacion;
    }

    // Metodos Getter and Setter
    public String getRol() {
        return rol;
    }
    public String getOcupacion() {
        return ocupacion;
    }
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    // Metodo mostrar Informacion
    public void mostrarInfo() {
        System.out.println("Datos de Usuario: " +
                "\nNombre: " + getNombre() +
                "\nEdad : " + getEdad() +
                "\nId Persona: " + getIdPersona() +
                "\nRol: " + getRol() +
                "\nOcupacion: " + getOcupacion());
    }
}