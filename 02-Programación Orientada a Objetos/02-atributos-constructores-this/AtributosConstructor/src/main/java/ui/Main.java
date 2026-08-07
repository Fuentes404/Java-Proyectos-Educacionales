package ui;

import model.Persona;

public class Main {
    public static void main(String[] args) {

        // Creamos un objeto usando el constructor por defecto
        // (usa los valores "Carlos Palma", 25, "Asistente" definidos internamente)
        Persona persona1 = new Persona();

        // Llamamos al metodo mostrar informacion y saludar del objeto con los valores predeterminados
        persona1.saludar();
        persona1.mostrarInformacion();

        // Podemos modificar sus atributos porque son public del objeto creado previamente
        persona1.nombre = "Ana Torres";
        persona1.edad = 30;
        persona1.cargo = "Gerente";

        // Llamamos al metodo mostrar informacion al objeto persona1
        persona1.mostrarInformacion();

        // Creamos un segundo objeto usando el constructor por defecto
        // sigue con los valores iniciales
        Persona persona2 = new Persona();
        persona2.mostrarInformacion();

        // Creamos un tercer objeto usando el constructor parametrizado
        // así evitamos tener que asignar los atributos uno por uno
        Persona persona3 = new Persona("Luis Fernández", 40, "Director");
        persona3.mostrarInformacion();

    }
}