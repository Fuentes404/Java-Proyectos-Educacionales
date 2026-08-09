package model;

public class Matematicas extends Profesor {
    // Atributo propio
    private String especialidad;

    // Constructor
    public Matematicas(String nombre, int edad, String especialidad) {
        super(nombre, edad);
        this.especialidad = especialidad;
    }

    // Getter y Setter propios de Matematicas
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    // Metodo mostrar informacion
    public void mostrarInfo() {
        System.out.println("Profesor de Matematicas: " + getNombre() + " | Edad: " + getEdad() + " | Especialidad: " + getEspecialidad());
    }

    // Metodo toString
    @Override
    public String toString() {
        return "Matematicas{" + "nombre='" + getNombre() + '\'' + ", edad=" + getEdad() + ", especialidad='" + especialidad + '\'' + '}';
    }
}