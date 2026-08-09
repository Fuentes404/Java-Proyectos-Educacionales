package model;

public class Historia extends Profesor {
    // Atributo propio
    private String especialidad;

    // Constructor
    public Historia(String nombre, int edad, String especialidad) {
        super(nombre, edad);
        this.especialidad = especialidad;
    }

    // Getter y Setter propios de Historia
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    // Metodo mostrar informacion
    public void mostrarInfo() {
        System.out.println("Profesor de Historia: " + getNombre() + " | Edad: " + getEdad() + " | Periodo: " + getEspecialidad());
    }

    // Metodo toString
    @Override
    public String toString() {
        return "Historia{" + "nombre='" + getNombre() + '\'' + ", edad=" + getEdad() + ", periodoHistorico='" + getEspecialidad() + '\'' + '}';
    }
}