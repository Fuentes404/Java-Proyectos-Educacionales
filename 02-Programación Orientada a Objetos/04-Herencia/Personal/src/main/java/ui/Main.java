package ui;

import model.Trabajador;
import model.Cliente;

public class Main {
    public static void main(String[] args) {

        // Crear Las Instancias de objetos
        Trabajador trabajador1 = new Trabajador("Camilo Perez", 25, "123315243-5", "000068");
        Cliente cliente1 = new Cliente("Alejandro Torres", 30, "198765432-1", "000032");

        // mostrarInfo() heredado directamente de Persona
        trabajador1.mostrarInfo();
        trabajador1.mostrarIdTrabajador();

        System.out.println("--------------");

        cliente1.mostrarInfo();
        cliente1.mostrarIdCliente();

        System.out.println("--------------");

        trabajador1.setNombre("Camilo Andres");
        trabajador1.setIdTrabajador("000012");

        trabajador1.mostrarInfo();
        trabajador1.mostrarIdTrabajador();
    }
}