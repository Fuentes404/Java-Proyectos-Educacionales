package model;

public class Estudiante {
    // Atributo
    private String nombreEstudiante;
    private double promedio;

    // Constructor
    public Estudiante(String nombreEstudiante, double promedio) {
        this.nombreEstudiante = nombreEstudiante;
        this.promedio = promedio;
    }

    // Metodos Getter and setter
    public String getNombreEstudiante() {
        return nombreEstudiante;
    }
    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }
    public double getPromedio() {
        return promedio;
    }
    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    // Metodo mostrar Informacion
    public void mostrarInfo() {
        System.out.println("Datos Estudiante: " + getNombreEstudiante() + " | Promedio: " + getPromedio());
    }

}
