package model;

public abstract class Profesor {
    // Atributos
    private String nombre;
    private int edad;

    // Constructor
    public Profesor(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Metodos Getter and Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Metodo mostrar Informacion
    public abstract void mostrarInfo();

    // Metodo toString
    @Override
    public String toString() {
        return "Profesor{" + "nombre='" + nombre + '\'' + ", edad=" + edad + '}';
    }
}
