package ui;

import model.Persona;

public class Main {
    public static void main(String[] args) {

        // Crear Objeto Persona
        Persona persona1 = new Persona("Camilo Perez", 25, "123315243-5");

        // mostrar informacion del objeto por metodo mostrarInfo
        persona1.mostrarInfo();

        System.out.println("--------------");

        // Uso de Setters para definir el valor del Atributo de la clase Persona
        persona1.setNombre("Alejandro Torres");
        persona1.setEdad(20);

        // Uso de Getters
        System.out.println("Nombre Actualizado: " + persona1.getNombre());
        System.out.println("Edad: " + persona1.getEdad());

        System.out.println("--------------");

        // Mostrar informacion actualizada
        persona1.mostrarInfo();
    }
}