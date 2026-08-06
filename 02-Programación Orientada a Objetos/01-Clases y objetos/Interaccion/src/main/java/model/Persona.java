package model;

public class Persona {
    // Atributos
    // Por concepto de la actividad las clases seran publicas
    // En otras instancias podrias ser privadas segun se requiera
    public String nombre = "Carlos Palma";
    public int edad = 25;
    public String cargo = "Asistente";

    public void saludar() {
        System.out.println("Bienvenido : " + nombre + " | Cargo : " + cargo);
    }

    public void mostrarInformacion() {
        System.out.println("Datos:" + " | Nombre : " + nombre + " | Edad : " + edad + " | Cargo : " + cargo);
    }

}
