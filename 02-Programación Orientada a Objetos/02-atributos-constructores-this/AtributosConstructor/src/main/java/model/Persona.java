package model;

public class Persona {

    // Atributos
    // Por concepto de la actividad las clases seran publicas
    // En otras instancias podrias ser privadas segun se requiera
    public String nombre;
    public int edad;
    public String cargo;

    // Constructor por defecto (sin parámetros)
    // Asigna valores iniciales usando this() para reutilizar el otro constructor
    public Persona() {
        this("Carlos Palma", 25, "Asistente");
    }

    // Constructor parametrizado
    // Recibe valores desde afuera y los asigna a los atributos con "this"
    public Persona(String nombre, int edad, String cargo) {
        this.nombre = nombre;
        this.edad = edad;
        this.cargo = cargo;
    }

    public void saludar() {
        System.out.println("Bienvenido : " + nombre + " | Cargo : " + cargo);
    }

    public void mostrarInformacion() {
        System.out.println("Datos:" + " | Nombre : " + nombre + " | Edad : " + edad + " | Cargo : " + cargo);
    }

}